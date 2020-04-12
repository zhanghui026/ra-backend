import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { IPainting, defaultValue } from 'app/shared/model/painting.model';

export const ACTION_TYPES = {
  FETCH_PAINTING_LIST: 'painting/FETCH_PAINTING_LIST',
  FETCH_PAINTING: 'painting/FETCH_PAINTING',
  CREATE_PAINTING: 'painting/CREATE_PAINTING',
  UPDATE_PAINTING: 'painting/UPDATE_PAINTING',
  DELETE_PAINTING: 'painting/DELETE_PAINTING',
  RESET: 'painting/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<IPainting>,
  entity: defaultValue,
  updating: false,
  totalItems: 0,
  updateSuccess: false
};

export type PaintingState = Readonly<typeof initialState>;

// Reducer

export default (state: PaintingState = initialState, action): PaintingState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_PAINTING_LIST):
    case REQUEST(ACTION_TYPES.FETCH_PAINTING):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_PAINTING):
    case REQUEST(ACTION_TYPES.UPDATE_PAINTING):
    case REQUEST(ACTION_TYPES.DELETE_PAINTING):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_PAINTING_LIST):
    case FAILURE(ACTION_TYPES.FETCH_PAINTING):
    case FAILURE(ACTION_TYPES.CREATE_PAINTING):
    case FAILURE(ACTION_TYPES.UPDATE_PAINTING):
    case FAILURE(ACTION_TYPES.DELETE_PAINTING):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_PAINTING_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data,
        totalItems: parseInt(action.payload.headers['x-total-count'], 10)
      };
    case SUCCESS(ACTION_TYPES.FETCH_PAINTING):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_PAINTING):
    case SUCCESS(ACTION_TYPES.UPDATE_PAINTING):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_PAINTING):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: {}
      };
    case ACTION_TYPES.RESET:
      return {
        ...initialState
      };
    default:
      return state;
  }
};

const apiUrl = 'api/paintings';

// Actions

export const getEntities: ICrudGetAllAction<IPainting> = (page, size, sort) => {
  const requestUrl = `${apiUrl}${sort ? `?page=${page}&size=${size}&sort=${sort}` : ''}`;
  return {
    type: ACTION_TYPES.FETCH_PAINTING_LIST,
    payload: axios.get<IPainting>(`${requestUrl}${sort ? '&' : '?'}cacheBuster=${new Date().getTime()}`)
  };
};

export const getEntity: ICrudGetAction<IPainting> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_PAINTING,
    payload: axios.get<IPainting>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<IPainting> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_PAINTING,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<IPainting> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_PAINTING,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  return result;
};

export const deleteEntity: ICrudDeleteAction<IPainting> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_PAINTING,
    payload: axios.delete(requestUrl)
  });
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});

import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { IMuseum, defaultValue } from 'app/shared/model/museum.model';

export const ACTION_TYPES = {
  FETCH_MUSEUM_LIST: 'museum/FETCH_MUSEUM_LIST',
  FETCH_MUSEUM: 'museum/FETCH_MUSEUM',
  CREATE_MUSEUM: 'museum/CREATE_MUSEUM',
  UPDATE_MUSEUM: 'museum/UPDATE_MUSEUM',
  DELETE_MUSEUM: 'museum/DELETE_MUSEUM',
  RESET: 'museum/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<IMuseum>,
  entity: defaultValue,
  updating: false,
  updateSuccess: false
};

export type MuseumState = Readonly<typeof initialState>;

// Reducer

export default (state: MuseumState = initialState, action): MuseumState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_MUSEUM_LIST):
    case REQUEST(ACTION_TYPES.FETCH_MUSEUM):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_MUSEUM):
    case REQUEST(ACTION_TYPES.UPDATE_MUSEUM):
    case REQUEST(ACTION_TYPES.DELETE_MUSEUM):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_MUSEUM_LIST):
    case FAILURE(ACTION_TYPES.FETCH_MUSEUM):
    case FAILURE(ACTION_TYPES.CREATE_MUSEUM):
    case FAILURE(ACTION_TYPES.UPDATE_MUSEUM):
    case FAILURE(ACTION_TYPES.DELETE_MUSEUM):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_MUSEUM_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.FETCH_MUSEUM):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_MUSEUM):
    case SUCCESS(ACTION_TYPES.UPDATE_MUSEUM):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_MUSEUM):
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

const apiUrl = 'api/museums';

// Actions

export const getEntities: ICrudGetAllAction<IMuseum> = (page, size, sort) => ({
  type: ACTION_TYPES.FETCH_MUSEUM_LIST,
  payload: axios.get<IMuseum>(`${apiUrl}?cacheBuster=${new Date().getTime()}`)
});

export const getEntity: ICrudGetAction<IMuseum> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_MUSEUM,
    payload: axios.get<IMuseum>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<IMuseum> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_MUSEUM,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<IMuseum> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_MUSEUM,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  return result;
};

export const deleteEntity: ICrudDeleteAction<IMuseum> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_MUSEUM,
    payload: axios.delete(requestUrl)
  });
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});

import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { IFileManager, defaultValue } from 'app/shared/model/file-manager.model';

export const ACTION_TYPES = {
  FETCH_FILEMANAGER_LIST: 'fileManager/FETCH_FILEMANAGER_LIST',
  FETCH_FILEMANAGER: 'fileManager/FETCH_FILEMANAGER',
  CREATE_FILEMANAGER: 'fileManager/CREATE_FILEMANAGER',
  UPDATE_FILEMANAGER: 'fileManager/UPDATE_FILEMANAGER',
  DELETE_FILEMANAGER: 'fileManager/DELETE_FILEMANAGER',
  RESET: 'fileManager/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<IFileManager>,
  entity: defaultValue,
  updating: false,
  totalItems: 0,
  updateSuccess: false
};

export type FileManagerState = Readonly<typeof initialState>;

// Reducer

export default (state: FileManagerState = initialState, action): FileManagerState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_FILEMANAGER_LIST):
    case REQUEST(ACTION_TYPES.FETCH_FILEMANAGER):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_FILEMANAGER):
    case REQUEST(ACTION_TYPES.UPDATE_FILEMANAGER):
    case REQUEST(ACTION_TYPES.DELETE_FILEMANAGER):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_FILEMANAGER_LIST):
    case FAILURE(ACTION_TYPES.FETCH_FILEMANAGER):
    case FAILURE(ACTION_TYPES.CREATE_FILEMANAGER):
    case FAILURE(ACTION_TYPES.UPDATE_FILEMANAGER):
    case FAILURE(ACTION_TYPES.DELETE_FILEMANAGER):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_FILEMANAGER_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data,
        totalItems: parseInt(action.payload.headers['x-total-count'], 10)
      };
    case SUCCESS(ACTION_TYPES.FETCH_FILEMANAGER):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_FILEMANAGER):
    case SUCCESS(ACTION_TYPES.UPDATE_FILEMANAGER):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_FILEMANAGER):
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

const apiUrl = 'api/file-managers';

// Actions

export const getEntities: ICrudGetAllAction<IFileManager> = (page, size, sort) => {
  const requestUrl = `${apiUrl}${sort ? `?page=${page}&size=${size}&sort=${sort}` : ''}`;
  return {
    type: ACTION_TYPES.FETCH_FILEMANAGER_LIST,
    payload: axios.get<IFileManager>(`${requestUrl}${sort ? '&' : '?'}cacheBuster=${new Date().getTime()}`)
  };
};

export const getEntity: ICrudGetAction<IFileManager> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_FILEMANAGER,
    payload: axios.get<IFileManager>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<IFileManager> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_FILEMANAGER,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<IFileManager> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_FILEMANAGER,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  return result;
};

export const deleteEntity: ICrudDeleteAction<IFileManager> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_FILEMANAGER,
    payload: axios.delete(requestUrl)
  });
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});

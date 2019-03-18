import { selectTruck,getAdvancedForm, deleteTruck, addTruck, updateTruck } from '@/services/truck';

export default {
  namespace: 'truck',

  state: {
    data: {
      list: [],
      pagination: {},
    },
    advancedForm: {}
  },

  effects: {
    *search({ payload }, { call, put }) {
      const response = yield call(selectTruck, payload);
      yield put({
        type: 'save',
        payload: response,
      });
    },
    *getAdvancedForm({ payload }, { call, put }) {
      const response = yield call(getAdvancedForm, payload);
      yield put({
        type: 'saveAdvancedForm',
        payload: response,
      });
    },
    *add({ payload, callback }, { call, put }) {
      const response = yield call(addTruck, payload);
      yield put({
        type: 'save',
        payload: response,
      });
      if (callback) callback();
    },
    *remove({ payload, callback }, { call, put }) {
      const response = yield call(deleteTruck, payload);
      yield put({
        type: 'save',
        payload: response,
      });
      if (callback) callback();
    },
    *update({ payload, callback }, { call, put }) {
      const response = yield call(updateTruck, payload);
      yield put({
        type: 'save',
        payload: response,
      });
      if (callback) callback();
    },
  },

  reducers: {
    save(state, action) {
      return {
        ...state,
        data: action.payload,
      };
    },
    saveAdvancedForm(state, action) {
      return {
        ...state,
        advancedForm: action.payload,
      };
    },
  },
};

import { createStore } from 'vuex';

// Import modules
import auth from './modules/auth';

export default createStore({
  modules: {
    auth,
  },
  state: {
    token: null
  },
  mutations: {
    setToken(state, token) {
      state.token = token;
    }
  },
  actions: {},
});

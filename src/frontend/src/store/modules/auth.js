import axios from '@/plugins/axios';

export default {
  state: {
    user: null,
    accessToken: null,
  },
  mutations: {
    SET_USER(state, user) {
      state.user = user;
    },
    SET_ACCESS_TOKEN(state, token) {
      state.accessToken = token;
    },
  },
  actions: {
    async login({ commit }, { username, password }) {
      try {
        const response = await axios.post('/login', {
          username,
          password,
        });
        commit('SET_USER', response.data.user); // Adjust as per your response structure
        commit('SET_ACCESS_TOKEN', response.data.accessToken); // Adjust as per your response structure
      } catch (error) {
        console.error('Error during login:', error);
        throw error;
      }
    },
    async logout({ state, commit }) {
      try {
        await axios.post('/logout', null, {
          params: {
            refreshToken: state.accessToken,
          }
        });
        commit('SET_USER', null);
        commit('SET_ACCESS_TOKEN', null);
      } catch (error) {
        console.error('Error during logout:', error);
        throw error;
      }
    },
    async refreshToken({ commit }, refreshToken) {
      try {
        const response = await axios.post('/refresh', null, {
          params: {
            refreshToken,
          }
        });
        commit('SET_ACCESS_TOKEN', response.data.accessToken); // Adjust as per your response structure
      } catch (error) {
        console.error('Error during token refresh:', error);
        throw error;
      }
    },
  },
};

import { createStore } from "vuex";

// Import modules
import auth from "./modules/auth";
import axios from "axios";

export default createStore({
  modules: {
    auth,
  },
  state: {
    token: null,
    activities: null,
    medical: null,
    overseasPresent: null,
    mba: null,
    pubs: null,
  },
  mutations: {
    setToken(state, token) {
      state.token = token;
    },
    setActivities(state, payload) {
      state.activities = payload;
    },
    setMedical(state, payload) {
      state.medical = payload;
    },
    setOverseasPresent(state, payload) {
      state.overseasPresent = payload;
    },
    setMba(state, payload) {
      state.mba = payload;
    },
    setPubs(state, payload) {
      state.pubs = payload;
    },
  },
  actions: {
    async fetchActivities({ commit }) {
      const response = await axios.get("/academicActivities");

      response.data.forEach((item) => {
        item.academicDate = item.academicDate.replace(/  /g, " &nbsp;");
      });

      commit("setActivities", response.data);
    },
    async fetchMedical({ commit }) {
      const response = await axios.get("/medical");

      let count = 1;
      response.data.forEach((item) => {
        item.id = count;
        count++;
      });

      commit("setMedical", response.data);
    },
    async fetchOverseasPresent({ commit }) {
      const response = await axios.get("/overseasPresent");

      commit("setOverseasPresent", response.data);
    },
    async fetchMba({ commit }) {
      const response = await axios.get("/mba");

      commit("setMba", response.data);
    },
    async fetchPubs({ commit }) {
      const response = await axios.get("/pubs");

      commit("setPubs", response.data);
    },
  },
  getters: {},
});

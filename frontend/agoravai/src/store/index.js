import { createApp } from 'vue'
import Vuex from 'vuex'
import Axios from 'axios'
import App from '../App.vue'
const app = createApp(App)
app.use(Vuex);

export const store = new Vuex.Store({
  state: {
    perfil : null,
    token:null

  },
  getters : {
    PERFIL : state => {
      return state.perfil;
    },
    TOKEN : state => {
      return state.token;
    }
  },
  mutations: {
    SET_TOKEN : (state,payload) => {
      state.token = payload
    },
    SET_PERFIL: (state,payload) => {
      state.perfil = payload
    },
  },
  actions:{   
   SAVE_TOKEN : async (context,payload) => {     
    context.commit('SET_TOKEN',payload)
 },
 SAVE_PERFIL : async (context,payload) => {     
  context.commit('SET_PERFIL',payload)
},
 },
})
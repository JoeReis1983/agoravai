import { createApp } from 'vue'
import Vuex from 'vuex'
import Axios from 'axios'
import App from '../App.vue'
const app = createApp(App)
app.use(Vuex);

export const store = new Vuex.Store({
  state: {
    todos : null,
    token:null

  },
  getters : {
    TODOS : state => {
      return state.todos;
    },
    TOKEN : state => {
      return state.token;
    }
  },
  mutations: {
    SET_TOKEN : (state,payload) => {
      state.token = payload
    },
    ADD_TODO : (state,payload) => {
      state.todos.push(payload)
    },
    SgET_TOKEN: (state,payload) => {
      state.token = payload
    },
  },
  actions:{
   GET_TDO : async (context,payload) => {
      let { data } = await Axios.get('http://yourwebsite.com/api/todo')
      context.commit('SET_TODO',data)
   },
   SAVE_TODO : async (context,payload) => {
      let { data } = await Axios.post('http://yourwebsite.com/api/todo')
      context.commit('ADD_TODO',payload)
   },
   SAVE_TOKEN : async (context,payload) => {
     console.log('save token')
     console.log(payload)
    context.commit('SET_TOKEN',payload)
 },
 },
})
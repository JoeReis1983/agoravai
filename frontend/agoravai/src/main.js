import { createApp } from 'vue'
import App from './App.vue'
import {store} from './store'
import router from './router'
import '../node_modules/bulma/css/bulma.css'
import axios from 'axios'
import Toaster from '@meforma/vue-toaster';

// magia pra nao precisar chamar a api pelo endereço completo
axios.defaults.baseURL = 'https://8080-joereis1983-agoravai-olur88ey6he.ws-us47.gitpod.io'

const app = createApp(App)
app.use(store)
app.use(Toaster)

app.use(router)

app.mount('#app')

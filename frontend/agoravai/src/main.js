import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import '../node_modules/bulma/css/bulma.css'
import axios from 'axios'


// magia pra nao precisar chamar a api pelo endereço completo
axios.defaults.baseURL = 'https://8080-joereis1983-agoravai-w0p6av831aa.ws-us47.gitpod.io'

const app = createApp(App)

app.use(router)

app.mount('#app')

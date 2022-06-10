
<template>
  <div>
    
  
    <div class="glassLogin">

      <div class="columns is-flex is-mobile">
  <div class="column is-11 is-offset-1">
    <div class="field ">
        <p class="control has-icons-left has-icons-right ">
          <input class="input" type="email" placeholder="Email" v-model="username">
          <span class="icon is-small is-left">
            <i class="fas fa-envelope"></i>
          </span>
          <span class="icon is-small is-right">
            <i class="fas fa-check"></i>
          </span>
        </p>
      </div>
      <div class="field">
        <p class="control has-icons-left">
          <input class="input" type="password" placeholder="Password" v-model="password">
          <span class="icon is-small is-left">
            <i class="fas fa-lock"></i>
          </span>
        </p>
      </div>
      <div class="field">
        <p class="control">
          <button class="button is-dark is-success is-fullwidth" @click="autenticar()">
            Login
          </button>
        </p>
      </div>
     </div>
    </div>
   </div>
  </div>
</template>

<script>
import axios from 'axios'
import router from "../router"
export default{
  data() {
    return {
      username:"",
      password:""
      
    }
  },
  methods: { 
    autenticar(){
      const formData = {
                username: this.username,
                password: this.password
            }
            axios.post("/login/", formData).then(snapshot=>{
                  console.log(snapshot)
                  alert('Bem vindo')
                  router.replace({ path: '/principal' })
                }).catch(error=>{
                  console.log(error)
                  alert('Falha na autenticação: '+error.message)
                })
    }
  },
}

</script>
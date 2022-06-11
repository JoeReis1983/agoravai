<template>
  <div>
    <div class="glassLogin">
      <div class="columns is-flex is-mobile">
        <div class="column is-11 is-offset-1">
          <div class="field ">
            <p class="has-text-light is-size-1 has-text-centered has-text-weight-semibold mb-4 is-family-code">LOGIN</p>
            <p class="control has-icons-left has-icons-right ">
              <input class="input" type="email" placeholder="Email" v-model="username">
            </p>
          </div>
          <div class="field">
            <p class="control has-icons-left">
              <input class="input" type="password" placeholder="Password" v-model="password" v-on:keyup.enter="autenticar()">
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
                  this.$store.dispatch('SAVE_TOKEN',snapshot.data.token)
                   this.$toast.success(`Hey! Bem vindo.`,{
                      position:"bottom",
                      duration:1000,
                      dismissible:true
                    });
                  router.replace({ path: '/principal' })
                }).catch(error=>{
                  console.log(error)
                  this.$toast.error('Falha na autenticação: '+error.message,{
                      position:"bottom",
                      duration:1000,
                      dismissible:true
                    })
                })
    }
  },
}

</script>
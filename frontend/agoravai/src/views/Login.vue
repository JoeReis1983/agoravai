
<template>
  <div>
    
  
    <div class="glassLogin">

      <div class="columns is-flex is-mobile">
  <div class="column is-11 is-offset-1">
    <div class="field ">
        <p class="control has-icons-left has-icons-right ">
          <input class="input" type="email" placeholder="Email">
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
          <input class="input" type="password" placeholder="Password">
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
import router from "../router"
export default{
  data() {
    return {
      
    }
  },
  methods: { 
    autenticar(){
      alert('Bem vindo')
      router.replace({ path: '/principal' })
    }
  },
}

</script>
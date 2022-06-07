
<template>

    
  
    <div class="glassLogin">

      <div class="columns is-flex is-mobile">
        
  <div class="column is-11 is-offset-1">
    <div class="field ">
          <input class="input is-fullwidth" type="email" placeholder="Email">
        
      </div>
      <div class="field">
       
          <input class="input  is-fullwidth" type="password" placeholder="Password">          
       
      </div>
      <div class="field">
       
          <button class="button is-success is-fullwidth" @click="autenticar()">
            Login
          </button>
       
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
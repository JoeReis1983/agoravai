<template >
<nav class="navbar is-dark" role="navigation" aria-label="main navigation">
 

  <div id="navbarBasicExample" class="navbar-menu">
    <div class="navbar-start">
      <a class="navbar-item">
        Politica
      </a>

      <a class="navbar-item">
        Esportes
      </a>
      <a class="navbar-item">
        Internacional
      </a>

   
    </div>

    <div class="navbar-end">
      <div class="navbar-item">
        <div class="buttons">
          <a class="button is-primary" @click="login">
            <strong>Login</strong>
          </a>
            <a class="button is-info">
            Administrar
          </a>
          <a class="button is-danger">
            Sair
          </a>
        </div>
      </div>
    </div>
  </div>
</nav>
  
</template>
<style>


</style>
<script>
import router from "../router"
export default{
  data() {
    return {
      
    }
  },
  methods: { 
    cadastro(){
      router.replace({ path: '/cadastro' })
    }
  },
}

</script>
<template >
<nav class="navbar is-black" role="navigation" aria-label="main navigation">
  <div class="navbar-brand">
    
          <a class="button is-link ml-3" @click="cadastro">
            <strong>HOME</strong>
          </a>

    
  </div>

  <div id="navbarBasicExample" class="navbar-menu">
    
    <div class="navbar-end">
      <div class="navbar-item">
        <div class="buttons">
          <a class="button is-primary" @click="cadastro">
            <strong>Cadastro</strong>
          </a>
          <a class="button is-info" @click="cadastroAluno">
            <strong>Cadastro Alunos</strong>
          </a>
          <a class="button is-danger" @click="sair">
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
    sair(){
      console.log('sair')
      console.log(this.$store.getters.TOKEN  )
    }, 
    cadastro(){
      router.replace({ path: '/cadastro' })
    },
    cadastroAluno(){
      router.replace({ path: '/cadastroAluno' })
    }
  },
}

</script>
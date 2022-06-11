<template >
<nav class="navbar is-black" role="navigation" aria-label="main navigation">
  <div class="navbar-brand">
    
          <a class="button is-link ml-3" @click="goHome">
            <strong>HOME</strong>
          </a>

    
  </div>

  <div id="navbarBasicExample" class="navbar-menu">
    
    <div class="navbar-end">
      <div class="navbar-item">
        <div class="buttons">
          <a class="button is-primary" @click="cadastro" v-if="perfil=='ROLE_ADMIN'">
            <strong>Cadastro</strong>
          </a>
          <a class="button is-info" @click="cadastroAluno" v-if="perfil=='ROLE_ADMIN'">
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
      perfil:''
    }
  },
  
  methods: {
    sair(){
      console.log('sair')
      this.$store.dispatch('SAVE_TOKEN',null);
      router.replace({ path: '/' })

    }, 
    cadastro(){
      router.replace({ path: '/cadastro' })
    },
    cadastroAluno(){
      router.replace({ path: '/cadastroAluno' })
    },
    goHome(){
      router.replace({ path: '/principal' })
    },
    checaPerfil(){
      this.perfil=this.$store.getters.PERFIL
      console.log(this.perfil)
    }
  },
  created() {
    this.checaPerfil()
  },
}

</script>
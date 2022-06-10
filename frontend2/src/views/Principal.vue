<script setup>
// import NavBar from '../components/NavBar.vue'
import Esporte from '../components/Esporte.vue'
import Politica from '../components/Politica.vue'
import Internacional from '../components/Internacional.vue'
import Login from '../components/Login.vue'


</script>

<template>
  <main>
    <nav class="navbar is-dark" role="navigation" aria-label="main navigation">
 

  <div id="navbarBasicExample" class="navbar-menu">
    <div class="navbar-start">
      <a class="navbar-item" @click="selecionarTipo('politica')">
        Politica
      </a>
      <a class="navbar-item" @click="selecionarTipo('esportes')">
        Esportes
      </a>
      <a class="navbar-item" @click="selecionarTipo('internacional')">
        Internacional
      </a>  
    </div>
    <div class="navbar-end">
      <div class="navbar-item">
        <div class="buttons">
          <a class="button is-primary" @click="showModal=!showModal">
            <strong>Login</strong>
          </a>
            <a class="button is-info" @click="cadastro" v-if="true">
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

  <div v-if="noticia=='esportes'"><Esporte />        </div>    
  <div v-if="noticia=='politica'"> <Politica />      </div>    
  <div v-if="noticia=='internacional'"> <Internacional />        </div>    
  <div v-if="noticia=='noticias'"> <Esporte />    <Politica />    <Internacional />       </div>    
  
 <div class="modal" :class="{'is-active':showModal}">
       <div class="modal-background"></div>
       <div class="modal-content">         
           <Login />         
       </div>
       <button class="modal-close" @click="showModal=!showModal"></button> 
     </div>

  </main>
</template>

<script>
import router from "../router"
export default {
  
  data() {
    return {
      noticia:'noticias',
      showModal:false
    }
  },
  methods: {
    selecionarTipo(tipo){
      this.noticia=tipo
    },
    cadastro(){      
       router.replace({ path: '/cadastro' })
    }
  },
}
</script>

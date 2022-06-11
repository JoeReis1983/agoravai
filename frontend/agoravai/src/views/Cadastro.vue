<script setup>
import NavBar from '../components/NavBar.vue';

</script>
<template>
  <div>
    <NavBar />
  
    <div class="glassCadastro">
      

      <div class="columns is-flex is-mobile">
  <div class="column is-11 is-offset-1">
    <div>
      <h1 class="titleGlass">CADASTRO DE USUARIOS</h1>
    </div>
    <div class="field ">
        <p class="control">
          <input class="input" v-model="novo.nome" type="text" placeholder="Login">
        </p>
      </div>
      <div class="field">
        <p class="control">
          <input class="input" v-model="novo.senha" type="password" placeholder="Senha">          
        </p>
      </div>
       <div class="field">
        <p class="control">
          <input class="input" v-model="confirmaSenha" type="password" placeholder="Confirme a Senha">          
        </p>
      </div>
      <div class="field select is-fullwidth">
        <select v-model="perfil">
          <option value="user">Usuario </option>
          <option value="admin">Administrador</option>
        </select>
      </div>
      <div class="field">
        <p class="control">
          <button class="button is-dark is-success is-fullwidth" @click="cadastrar()">
            Cadastrar
          </button>
        </p>
      </div>  
  </div>

      
      
    </div>

   </div>
  </div>
</template>

<script>
import axios from "axios"
import router from "../router"
export default{
  data() {
    return {
      novo:{
        nome:'',
        senha:''},
      perfil:'user',
      confirmaSenha:''
      
    }
  },
  methods: { 
    cadastrar(){
      axios.defaults.headers.common['Authorization'] = this.$store.getters.TOKEN
      if(this.novo.senha!==this.confirmaSenha || this.novo.senha=='' ){
        this.$toast.error(`Dados invalidos.`,{
          position:"bottom",
          duration:1000,
          dismissible:true
          });
      }else{
        if(this.perfil=='user'){
        this.cadastraUser()
        }else{
          this.cadastraAdmin()
        }        
          }
    },
    cadastraUser(){
      axios.post("/usuario/user", this.novo).then(snapshot=>{
          this.$toast.success(this.novo.nome +` Cadastrado.`,{
            position:"bottom",
            duration:5000,
            dismissible:true
            });
            router.replace({ path: '/principal' })
            }).catch(error=>{
              this.$toast.error(`Falha no cadastro.`,{
                position:"bottom",
                duration:1000,
                dismissible:true
                });
              console.log(error)                  
              })
      },      
    cadastraAdmin(){
      axios.post("/usuario/admin", this.novo).then(snapshot=>{
          this.$toast.success(this.novo.nome +` Cadastrado.`,{
            position:"bottom",
            duration:5000,
            dismissible:true
            });
            router.replace({ path: '/principal' })
            }).catch(error=>{
              this.$toast.error(`Falha no cadastro.`,{
                position:"bottom",
                duration:1000,
                dismissible:true
                });
              console.log(error)                  
              })
      }
  },
  created() {
    if(this.$store.getters.PERFIL!="ROLE_ADMIN"){
      router.replace({ path: '/' })
    }
  },
}

</script>
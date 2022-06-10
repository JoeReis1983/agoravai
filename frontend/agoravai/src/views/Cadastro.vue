
<template>
  <div>
    
  
    <div class="glassCadastro">
      

      <div class="columns is-flex is-mobile">
  <div class="column is-11 is-offset-1">
    <div>
      <h1 class="titleGlass">CADASTRO DE USUARIOS</h1>
    </div>
    <div class="field ">
        <p class="control has-icons-left has-icons-right ">
          <input class="input" v-model="novo.nome" type="text" placeholder="Login">
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
          <input class="input" v-model="novo.senha" type="password" placeholder="Senha">
          <span class="icon is-small is-left">
            <i class="fas fa-lock"></i>
          </span>
        </p>
      </div>
       <div class="field">
        <p class="control has-icons-left">
          <input class="input" v-model="confirmaSenha" type="password" placeholder="Confirme a Senha">
          <span class="icon is-small is-left">
            <i class="fas fa-lock"></i>
          </span>
        </p>
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
        senha:''
      },
      confirmaSenha:''
      
    }
  },
  methods: { 
    cadastrar(){
      axios.defaults.headers.common['Authorization'] = "eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyRGV0YWlscyI6IntcInVzZXJuYW1lXCI6XCJhZG1pblwiLFwicGFzc3dvcmRcIjpudWxsLFwiYXV0b3JpemFjYW9cIjpcIlJPTEVfQURNSU5cIixcInRva2VuXCI6bnVsbH0iLCJpc3MiOiJici5nb3Yuc3AuZmF0ZWMiLCJzdWIiOiJhZG1pbiIsImV4cCI6MTY1NDgzMDU4M30.onzGWBDokAX-WksLwMdwLOrd5kT6hVXkA9d7GFGnmq7xtp69dVNgxpAo7OS32aGFpbURkj0D34cJfDy_Ee-1WQ";
      if(this.novo.senha!==this.confirmaSenha || this.novo.senha=='' ){
        alert('Falha no cadastro')
      }else{
           axios.post("/usuario/", this.novo).then(snapshot=>{
                  console.log(snapshot)
                  alert('usuario cadastrado')
                  router.replace({ path: '/principal' })
                }).catch(error=>{
                  console.log(error)
                  alert('Falha no cadastro: '+error.message)
                })
        alert('cadastro')
      }      
  

      
    }
  },
}

</script>
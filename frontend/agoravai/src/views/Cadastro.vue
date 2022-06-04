
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
          <input class="input" v-model="novo.email" type="email" placeholder="Email">
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
          <button class="button is-dark is-success is-fullwidth" @click="autenticar()">
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
import router from "../router"
export default{
  data() {
    return {
      novo:{
        email:'',
        senha:''
      },
      confirmaSenha:''
      
    }
  },
  methods: { 
    autenticar(){
      if(this.novo.senha!==this.confirmaSenha || this.novo.senha=='' ){
        alert('Falha no cadastro')
      }else{
        alert('cadastro')
      }      
  

      
    }
  },
}

</script>
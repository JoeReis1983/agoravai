
<template>
  <div>
    
  
    <div class="glassCadastro">
      

      <div class="columns is-flex is-mobile">
  <div class="column is-11 is-offset-1">
    <div>
      <h1 class="titleGlass">CADASTRO DE Alunos</h1>
    </div>
    <div class="field ">
        <p class="control has-icons-left">
          <input class="input" v-model="novo.nome" type="text" placeholder="nome">          
        </p>
      </div>
      <div class="field">
        <p class="control">
          <input class="input" v-model="novo.p1" type="text" placeholder="P1">          
        </p>
      </div>
      <div class="field">
        <p class="control">
          <input class="input" v-model="novo.p2" type="text" placeholder="P2">          
        </p>
      </div>
      <div class="field">
        <p class="control">
          <input class="input" v-model="novo.trabalho" type="text" placeholder="Trabalho">          
        </p>
      </div>       
      <div class="field">
        <p class="control">
          <button class="button is-dark is-success is-fullwidth" @click="cadastrarAluno()">
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
        p1:'',
        p2:'',
        trabalho:''
      }      
    }
  },
  methods: { 
    cadastrarAluno(){
      axios.defaults.headers.common['Authorization'] = this.$store.getters.TOKEN     
      if(this.novo.p1=='' || this.novo.p2=='' || this.novo.trabalho=='' ){
        this.$toast.error(`Falha no cadastro. Campos invalidos`,{
                      position:"bottom",
                      duration:1000,
                      dismissible:true
                    });
      }else{
           axios.post("/aluno/", this.novo).then(snapshot=>{
            this.$toast.success(`Aluno Cadastrado.`,{
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
  

      
    }
  },
}

</script>
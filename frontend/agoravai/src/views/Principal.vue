<script setup>
import NavBar from '@/components/NavBar.vue'
import Card from '../components/Card.vue';
</script>

<template>
  <main>
    <NavBar />
    <div class="columns is-mobile">
  <div class="column is-three-fifths is-offset-one-fifth">
    
    <Card  v-for="user in dadosUser" :key="user" :dados='user'/>
    
  </div>
</div>
    
  </main>
</template>

<script>
import router from "../router"
import axios from 'axios'

export default{
  data() {
    return {
      dadosUser:[]      
    }
  },
  methods: {
    buscaUsuarios(){
      axios.defaults.headers.common['Authorization'] = this.$store.getters.TOKEN
       axios.get("/aluno").then(snapshot=>{
        snapshot.data.forEach(element => {
          this.dadosUser.push(element)
          console.log(this.dadosUser)          
        });
       })

    }
  },
created() {
  this.buscaUsuarios()
}

}
</script>

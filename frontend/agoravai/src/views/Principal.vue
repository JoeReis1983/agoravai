<script setup>
import NavBar from '@/components/NavBar.vue'
import Card from '../components/Card.vue';
</script>

<template>
  <main>
    <NavBar />
    <div class="columns">
      <div class="column is-6"><Card :dados='dadosUser'/></div>
      <div class="column is-6"><Card /></div>
      

    </div>
    
  </main>
</template>

<script>
import router from "../router"

export default{
  data() {
    return {
      dadosUser:{
        nome:"nome da pessoa",
        p1:9,
        p2:5,
        trabalho:8
      }
      
    }
  },
created() {
},

}
</script>

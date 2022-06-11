

<template>
  <div class=" mt-4 boxGlass columns">    
    <div class="column is-4 is-size-3 has-text-centered has-text-weight-semibold is-family-code is-uppercase mt-4">
      {{dados.nome}}
    </div>
    <div class="column is-4 is-size-5 has-text-centered has-text-weight-semibold is-family-code is-uppercase">
      p1: {{dados.p1}} <br> p2: {{dados.p2}} <br> trabalho: {{dados.trabalho}}
    </div>
    <div class="column is-4 is-size-4 has-text-centered has-text-weight-semibold is-family-code is-uppercase" v-if="media>=6">
      media: {{media}}
      <br>
      <span class="is-size-2 has-text-success-dark">APROVADO</span>
    </div>
    <div class="column is-4 is-size-4 has-text-centered has-text-weight-semibold is-family-code is-uppercase" v-else>
      media: {{media}}
      <br>
      <span class="is-size-2 has-text-danger-dark">REPROVADO</span>   
    </div>
  </div>
</template>
<style scoped>

</style>
<script>
export default {
  data() {
    return {
      media:''
    }
  },
  props:{
    dados:Object
  },
  methods: {
    status(){

      this.media=((parseFloat(this.dados.p1.replaceAll(',','.'))
      +parseFloat(this.dados.p2.replaceAll(',','.'))+parseFloat(this.dados.trabalho.replaceAll(',','.')))/3).toFixed(2)      
    }
  },
  created() {
    this.status()
  },
}
</script>
<template>
  <main>        
    
      <section class="section box">
        <div class="container">
          <div class="columns is-centered">
            <div class="column">
              <p class="title">Harry e Meghan divulgam foto de Lilibet em seu primeiro aniversário</p>
              <p>Uma foto divulgada nesta segunda-feira (6) pelo príncipe Harry e Meghan Markle mostra a filha deles, Lilibet Diana, comemorando seu primeiro aniversário em um piquenique no quintal no fim de semana.

Usando um vestido azul claro e um laço branco na cabeça, a criança aparece sentada na grama em uma foto tirada pelo fotógrafo e amigo da família, Misan Harriman, no sábado (4), disse um porta-voz.</p>
              <button class="button mt-4" :disabled='assinante' @click="saibaMais('https://g1.globo.com/mundo/noticia/2022/06/06/harry-e-meghan-divulgam-foto-de-lilibet-em-seu-primeiro-aniversario.ghtml')">saiba mais...</button>
            </div>        
          </div>
        </div>
      </section>

      <section class="section box">
        <div class="container">
          <div class="columns is-centered">
            <div class="column">
              <p class="title">Líder de grupo de extrema-direita Proud Boys é indiciado por conspiração nos EUA</p>
              <p>Enrique Tarrio, ex-líder do grupo de direita Proud Boys, e quatro de seus principais integrantes enfrentaram novas acusações federais de conspiração sediciosa nesta segunda-feira (6) por envolvimento no ataque de 6 de janeiro de 2021 contra o Capitólio dos EUA, de acordo com um documento judicial.

Os promotores federais que investigam o ataque apresentaram novas acusações contra Tarrio, Dominic Pezzola, Ethan Nordean, Joe Biggs e Zachary Rehl, segundo o documento. Todos os cinco réus já se declararam inocentes de outras acusações criminais relacionadas ao ataque.</p>
              <button class="button mt-4" :disabled='assinante' @click="saibaMais('https://g1.globo.com/mundo/noticia/2022/06/06/lider-de-grupo-de-extrema-direita-proud-boys-e-indiciado-por-conspiracao-nos-eua.ghtml')">saiba mais...</button>
            </div>        
          </div>
        </div>
      </section>
   </main>
</template>
<style scoped>
.title{
  font-size: 3rem;
  font-weight: 600; 
}
.box{
  margin: 5rem;
  background-color: rgba(177, 176, 176, 0.452);
} 

</style>
<script>
export default {
  data() {
    return {
      assinante:false
    }
  },

  methods: {
    saibaMais(link){
      window.open(link)
    }
  },
}
</script>
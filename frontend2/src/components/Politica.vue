<template>
  <main>        
    
      <section class="section box">
        <div class="container">
          <div class="columns is-centered">
            <div class="column">
              <p class="title">Bolsonaro propõe compensar estados para reduzir ICMS e tentar conter alta do combustível</p>
              <p>O presidente Jair Bolsonaro anunciou nesta segunda-feira (6) que o governo federal aceitará ressarcir os estados pelas perdas de arrecadação com o projeto de lei que estabelece uma alíquota máxima para o ICMS sobre os combustíveis.

Como contrapartida, no entanto, o governo exigirá que os estados e o Distrito Federal derrubem a zero a alíquota do ICMS sobre o diesel e o gás de cozinha.</p>
              <button class="button mt-4" :disabled='assinante' @click="saibaMais('https://g1.globo.com/politica/noticia/2022/06/06/bolsonaro-anuncia-compensacao-aos-estados-por-reducao-de-icms-para-conter-alta-dos-precos-do-combustivel.ghtml')">saiba mais...</button>
            </div>        
          </div>
        </div>
      </section>

      <section class="section box">
        <div class="container">
          <div class="columns is-centered">
            <div class="column">
              <p class="title">Nunes Marques pauta na 2ª Turma do STF julgamento da decisão dele que devolveu mandato a cassado</p>
              <p>O ministro Kassio Nunes Marques decidiu levar para referendo da Segunda Turma do Supremo Tribunal Federal a decisão individual que tomou ao suspender a cassação — determinada em outubro pelo Tribunal Superior Eleitoral (TSE) — do deputado estadual do Paraná Fernando Francischini (União Brasil).

Presidente da turma, Nunes Marques marcou a análise do caso para esta terça-feira, em sessão presencial a partir das 14h. Cada uma das duas turmas do Supremo é integrada por cinco ministros. Na Segunda Turma, além de Marques, estão Gilmar Mendes, Ricardo Lewandowski, Edson Fachin e André Mendonça.</p>
              <button class="button mt-4" :disabled='assinante' @click="saibaMais('https://g1.globo.com/politica/noticia/2022/06/06/nunes-marques-pauta-na-2a-turma-do-stf-julgamento-da-decisao-dele-que-devolveu-mandato-a-cassado.ghtml')">saiba mais...</button>
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
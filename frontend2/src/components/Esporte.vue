<template>
  <main>        
    
      <section class="section box">
        <div class="container">
          <div class="columns is-centered">
            <div class="column">
              <p class="title">Rafinha fica? E Miranda? Como está a situação dos jogadores do São Paulo com contrato até dezembro</p>
              <p>O mês de junho surge como um período que pode mudar o panorama do elenco do São Paulo para a próxima temporada. Veteranos como Reinaldo, Rafinha, Eder e Miranda; jovens como Igor Vinicius e Walce; e atletas emprestados como Gabriel Neves possuem compromisso até o fim da temporada e podem, a partir de 1º de julho, assinar pré-contrato com outra equipe.
                 As renovações deste grupo de veteranos estão em pauta, como trouxe o ge em maio. Porém, cada um vive uma situação diferente dentro do elenco do São Paulo. Em relação aos outros atletas, também há indefinição (e paciência para decidir no próximo semestre).</p>
              <button class="button mt-4" :disabled='assinante' @click="saibaMais('https://ge.globo.com/futebol/times/sao-paulo/noticia/2022/06/06/rafinha-fica-e-miranda-como-esta-a-situacao-dos-jogadores-do-sao-paulo-com-contrato-ate-dezembro.ghtml')">saiba mais...</button>
            </div>        
          </div>
        </div>
      </section>

      <section class="section box">
        <div class="container">
          <div class="columns is-centered">
            <div class="column">
              <p class="title">São Paulo se aproxima de renovação com Caio e Beraldo, joias de Cotia</p>
              <p>O São Paulo está perto de renovar os contratos do atacante Caio e do zagueiro Beraldo, ambos formados na base do clube e que agora fazem parte do elenco principal.

Segundo dirigentes ouvidos pela reportagem, os documentos estão praticamente prontos, com poucos detalhes a resolver. A expectativa é de que eles sejam assinados até a próxima semana.</p>
              <button class="button mt-4" :disabled='assinante' @click="saibaMais('https://ge.globo.com/futebol/times/sao-paulo/noticia/2022/06/06/sao-paulo-se-aproxima-de-renovacao-com-caio-e-beraldo-joias-de-cotia.ghtml')">saiba mais...</button>
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
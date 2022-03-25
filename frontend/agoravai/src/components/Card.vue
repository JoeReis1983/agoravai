<script setup>
import StarRating from 'vue-star-rating'
</script>

<template>
  <div class=" mt-4 boxGlass">
    <header>
     <StarRating increment='0.125'
      inactive-color="#ffffff" active-color="#dd0000"
      :border-width="5" :star-size="30"/>
      <a class="boxNota">4.8</a>
          </header>
    <div>
    frases aqui
    </div>
    <footer>
      rodape
    </footer>
  </div>
</template>
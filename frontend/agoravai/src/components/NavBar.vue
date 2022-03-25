<template >
<nav class="navbar is-gray" role="navigation" aria-label="main navigation">
  <div class="navbar-brand">
    <a class="navbar-item nomeBarra">
      Celso <br> Reis
    </a>

    <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
      <span aria-hidden="true"></span>
      <span aria-hidden="true"></span>
      <span aria-hidden="true"></span>
    </a>
  </div>

  <div id="navbarBasicExample" class="navbar-menu">
    <div class="navbar-start">
      <a class="navbar-item">
        Melhores
      </a>

      <a class="navbar-item">
        Novas
      </a>

      <div class="navbar-item has-dropdown is-hoverable">
        <a class="navbar-link">
          Tipos
        </a>

        <div class="navbar-dropdown">
          <a class="navbar-item">
            Humor
          </a>
          <a class="navbar-item">
            Biblicas
          </a>
          <a class="navbar-item">
            Pensadores
          </a>
          <!-- <hr class="navbar-divider">
          <a class="navbar-item">
            Report an issue
          </a> -->
        </div>
      </div>
    </div>

    <div class="navbar-end">
      <div class="navbar-item">
        <div class="buttons">
          <a class="button is-primary">
            <strong>Administração</strong>
          </a>
          <a class="button is-danger">
            Sair
          </a>
        </div>
      </div>
    </div>
  </div>
</nav>
  
</template>
<style>


</style>
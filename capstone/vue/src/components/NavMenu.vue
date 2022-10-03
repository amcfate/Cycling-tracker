<template>
  <div class="menu">
      <router-link v-bind:to="{name: 'home'}">
          <img src="..\assets\home.png" alt="Home" class="home-link">
      </router-link>
      <router-link v-bind:to="{}">
          <img src="..\assets\road.png" alt="Routes" class="routes-link">
      </router-link>
      <router-link v-bind:to="{name: 'login'}">
          <img src="..\assets\gear.png" alt="Settings" class="settings-link">
      </router-link>
  </div>
</template>

<script>
export default {
    name: "nav-menu"
}
</script>

<style>
.menu{
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
    margin-top: auto;
    max-height: 10%;
    background-color: black;
    
}
.home-link, .routes-link, .settings-link {
    max-height: 30px;
    display: flex;
    align-self: end;
}
</style>
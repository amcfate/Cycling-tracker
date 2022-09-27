<template>
  <div id="app">
    <Map />
    <div id="nav">
      <router-link class="home-btn" v-bind:to="{ name: 'home' }"
        >Home</router-link
      >&nbsp;|&nbsp;
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
      <router-link v-bind:to="{ name: 'Map' }">Map Test!</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>
.home-btn {
  padding: 4px;
  border: 2px solid black;
  border-radius: 3px;
  background-color: whitesmoke;
}
#app {
  font-family: "Segoe UI", Verdana, sans-serif;
  text-align: center;
  color: white;
  display: flex;
  flex-direction: column;
  justify-items: center;
  /* background-image: url("../public/topoMapDark.jpg"); */
  /* background-color: rgb(255, 203, 158); */
  background-color: rgb(184, 184, 184);
  border-radius: 10px;
  background-repeat: no-repeat;
  background-size: 100% 100%;
  background-image: blur;
  min-height: 100vh;
  background-position: center 100%;
}
</style>
<script>
export default {
  name: "App",
  components: {},
};
</script>

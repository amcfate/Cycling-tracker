<template>
  <div id="app">
    <Map />
    <div id="nav">
      
      <router-link v-bind:to="{ name: 'home' }"><h3>cicleta</h3></router-link>&nbsp;|&nbsp;
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

<script>
export default {
  name: "App",
  components: {},
};
</script>
<style>
@font-face {
  font-family: Inter-Light;
  src: url("../public/static/Inter-Light.ttf");
}

#nav {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  align-items: center;
  background-color: whitesmoke;
  border: 1px solid lightgray;
}

#app {
  font-family: Inter-Light, Arial, Helvetica, sans-serif;
  text-align: center;
  color: black;
  display: flex;
  flex-direction: column;
  background-image: url("../public/mapNY.png");
  background-repeat: no-repeat;
  background-size: 100% 100%;
  min-height: 100vh;
  background-position: center 100%;
}
</style>


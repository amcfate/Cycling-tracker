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
      <router-link v-bind:to="{ name: 'maptesting' }">Map Test!</router-link>
    </div>
    <router-view />
    <div class="control-bar">
      <button class="btn">
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>
      </button>
      <button class="btn">
        <router-link v-bind:to="{ name: 'map' }">Map</router-link>
      </button>
      <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link> -->
      <button class="btn">
        <router-link v-bind:to="{ name: 'profile' }">Profile</router-link>
      </button>
    </div>
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

.control-bar {
  display: flex;
  flex-direction: row;
  background-color: whitesmoke;
  border: 1px solid lightgray;
  padding: 18px;
  margin: 10px;
  border-radius: 10px;
  justify-content: space-between;
}

.btn {
  size: flex-grow;
  border-radius: 6px;
  padding: 10px;
}

#app {
  font-family: Inter-Light, Arial, Helvetica, sans-serif;
  text-align: center;
  color: black;
  display: flex;
  flex-direction: column;
<<<<<<< HEAD
  /* background-image: url("../public/mapNY.png"); */
=======
  background-image: url("../public/mapNY.png");
  background-color: darkgray;
  max-width: 800px;
  background-blend-mode: multiply;
>>>>>>> main
  background-repeat: no-repeat;
  background-size: 100% 100%;
  background-clip: border-box;
  min-height: 100vh;
  background-position: center 100%;
  background-attachment: fixed;
}
</style>


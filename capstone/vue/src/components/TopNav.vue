<template>
  <div id="nav">
      
      <router-link v-bind:to="{ name: 'home' }"><h3>Velocidad</h3></router-link
      >&nbsp;|&nbsp;
    
      <router-link v-bind:to="{ name: 'maptesting' }">Map Test!</router-link>
        <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </div>
</template>

<script>
export default {

}
</script>

<style>
#nav {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
  background-color: whitesmoke;
  border: 1px solid lightgray;
  width: 100vw;
  height: 5vh;
}
</style>
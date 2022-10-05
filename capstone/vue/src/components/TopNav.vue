<template>
  <div id="nav">
      
      <router-link v-bind:to="{ name: 'home' }" style="text-decoration: none; color: inherit"><h3>Velocidad</h3></router-link
      >&nbsp;|&nbsp;
    
      <router-link v-bind:to="{ name: 'maptesting' }" style="text-decoration: none; color: inherit">Map Test!</router-link>
        <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        style="text-decoration: none; color: inherit"
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
  
  width: 100vw;
  height: 5vh;
}
</style>
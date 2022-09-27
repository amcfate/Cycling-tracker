<template>
  <div>
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">
        <img src="" alt="">
        </router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> 
    </div>
    <router-view />
    <nav-menu/>
  </div>
</template>


<script>
import NavMenu from './components/NavMenu.vue';

export default{

  components:{
    NavMenu
  }
}

    
 
</script>

<style>
.app{
  display: flex;
  min-height: 100vh;
   display: flex;
  flex-direction: column;
}
</style>



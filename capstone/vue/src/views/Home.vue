<template>
  <div class="main">

      <nav-block/>
    
  </div>
</template>

<script>

import NavBlock from '../components/NavBar/NavBlock.vue';


export default {
  name: "home",
  data() {
    return {
      ActivityClicked: false,
    };
  },
  components: {
    
    NavBlock
  },
};
</script>

<style>
.main {
  display: flex;
  flex-direction: column;
  align-items: center;
  align-content: space-evenly;
  min-height: 100vh;
}


</style>

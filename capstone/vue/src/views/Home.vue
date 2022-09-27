<template>
<div>
  <activities>
    <Map/>
  </activities>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    
  </div>
  </div>
</template>

<script>
import Map from "@/components/maps/Map";
import Activities from '../components/tiles/activities.vue';
export default {
  name: "home",
  components :{
    Map,
    Activities
  }
};
</script>

<style>
#Map{
  opacity: .05;
}
</style>

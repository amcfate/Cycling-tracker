<template>
  <div class="tile">

    <Map class="map"/>
  </div>
</template>

<script>
import Map from "@/components/maps/Map";
export default {
    name: "activities",
    components: {
        Map
    }

}
</script>

<style>
.tile{
    
  margin: auto;
  background-color: lightgray;
  background-repeat: no-repeat;
  background-size: 100% 100%;
  background-image: blur;
  border-radius: 8px;
  width: 50%;
  box-shadow: 2px 10px 20px darkgrey;
}
</style>
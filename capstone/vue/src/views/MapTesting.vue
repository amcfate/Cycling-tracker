<template>
  <div id="map">
    <MapTestComponent />
  </div>
</template>


<script>
import MapTestComponent from "@/components/maps/MapTestComponent";
export default {
  name: "MapTesting",
  components: {
    MapTestComponent
  },
};
</script>

<style>
#map {
  height: 100%;
  width: 100% ;
}
</style>
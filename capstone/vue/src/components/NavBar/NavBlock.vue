<template>
  <div class="home">
    <h2 class="header">Home</h2>
    <div class="mapDiv">
      <Map class="map" id="map" />
    </div>
  </div>
</template>

<script>
import Map from "@/components/maps/Map";
export default {
  name: "home",
  data() {
    return {
      ActivityClicked: false,
    };
  },
  components: {
    Map,
  },
};
</script>

<style>
.home {
  margin: auto;
  display: flex;
  flex-grow: auto;
  align-content: space-between;
  flex-direction: column;
  justify-content: center;
  background-color: lightgray;
  background-size: 100% 100%;
  border-radius: 8px;
  height: 80vh;
  box-shadow: 2px 10px 20px darkgrey;
  width: auto;
  padding-left: 3%;
  padding-right: 3%;
}
@media only screen and (max-width: 1000px) {
  .home {
    margin: auto;
    display: flex;
    flex-grow: auto;
    align-content: space-between;
    flex-direction: column;
    justify-content: center;
    background-color: lightgray;
    background-size: 100% 100%;
    border-radius: 8px;
    width: 70%;
    height: 80vh;
    box-shadow: 2px 10px 20px darkgrey;

    flex-basis: auto;
  }
}

.mapDiv {
  border-radius: 8px;
  flex-grow: 1;
  flex-shrink: 1;
}
</style>
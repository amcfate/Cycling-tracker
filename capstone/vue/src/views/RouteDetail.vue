<template>
  <div class="main">
    <nav-menu class="nav-menu" />
    <div class="tile">
      <div class="tile-head">
        <div class="map-cage"><img class="map" src="../assets/Screenshot 2022-10-06 214151.jpg"><img></div>
      </div>

      <div class="route-detail">
        <h2 class="header">Route Details</h2>
        <h3 class="header">{{ getRouteDetails.routeName }}</h3>
        <ul class="act-details">
          <li>Length | {{ getRouteDetails.distanceMiles }} miles</li>
          <li>Starting | {{ getRouteDetails.elevation }} feet</li>
          <li>Elevation Gain | {{ getRouteDetails.ascent }} feet</li>
          <li class="last">{{ getRouteDetails.description }}</li>
        </ul>
      </div>
    </div>
  </div>
</template>


<script>

import NavMenu from "../components/NavMenu.vue";
export default {
  name: "route-detail",
  props: {
    route: Object,
  },
  components: {
    
    NavMenu,
  },
  data() {
    return {
      activitiesTab: false,
      clicked: false,
    };
  },
  computed: {
    getRouteDetails() {
      return this.$store.state.routes.find((route) => {
        return route.routeId == this.$route.params.id;
      });
    },
  },
};
</script>

<style scoped>
.main {
  display: flex;
  width: 98vw;
  height: 100vh;
}
.nav-menu {
  width: 100%;
  max-width: 300px;
}
.tile {
  align-self: center;
  justify-self: center;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
  height: 93vh;
  width: 70%;
  margin-bottom: 20px;
}
.header {
  margin-left: 10px;
}

.route-detail {
  display: flex;
  flex-direction: column;
  justify-content: left;
  margin: 6px;
  background-color: whitesmoke;
  padding: 1px;
  height: 50%;
  width: 97%;
  border-radius: 8px;
  box-shadow: 2px 10px 20px darkgray;
  text-align: left;
}
.last {
  padding-top: 10px;
}
.tile-head {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin: 0;
  padding: 0;
  height: 30vh;
  width: 100%;
  border-radius: 8px;
}
.map-cage {
  margin-left: 0px;
  border-radius: 8px;
  display: flex;
  height: 300px;
  width: 98%;
  overflow: hidden;
  margin-bottom: 20px;
}
Map {
  height: 100%;
  width: 100%;
  margin-bottom: 300px;
}
.map .nav-controls .btn {
  display: none;
}
@media only screen and (max-width: 700px) {
  .tile {
    align-self: center;
    justify-self: center;
    display: flex;
    flex-direction: column;
    align-content: center;
    padding: 20px;

    height: 75%;
    width: 90%;
    margin-bottom: 26%;
    margin-right: 5px;
  }
}
</style>
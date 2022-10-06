<template>
  <div class="main">
    <nav-menu class="nav-menu" />
    <div class="tile">
      <div class="tile-head">
        <div class="map-cage"><Map class="map"></Map></div>
      </div>
      <div class="route-detail">
        <h3>Activity Details</h3>
        <h3>{{ getActivityDetails.activityName }}</h3>
        <ul class="act-details">
          <li>
            {{ getActivityDetails.activityDate }} |
            {{ getActivityDetails.startTime }} |
            {{ getActivityDetails.endTime }}
          </li>
          <li>{{}}</li>
          <li class="last">{{ getActivityDetails.description }}</li>
        </ul>
      </div>
      <div class="route-detail">
        <h3>Route Details</h3>
        <h3>{{ getRouteDetails.routeName }}</h3>
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
import Map from "../components/maps/Map.vue";
import NavMenu from "../components/NavMenu.vue";
export default {
  name: "activity-detail",
  props: {
    activity: Object,
  },
  components: {
    Map,
    NavMenu,
  },
  data() {
    return {
      activitiesTab: false,
      clicked: false,
    };
  },
  computed: {
    getActivityDetails() {
      return this.$store.state.activity.find((activity) => {
        return activity.activityId == this.$route.params.id;
      });
    },
    getRouteDetails() {
      return this.$store.state.routes.find((route) => {
        return route.routeId == this.getActivityDetails.routeId;
      });
    },
    // getBikeDetails(){
    //   return this.$store.state.user_bikes.find((bike)=>{
    //     return bike.bikeId == this.getActivityDetails.bikeId;
    //   })
    // }
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
.route-detail {
  display: flex;
  justify-content: left;
  margin: 6px;
  background-color: whitesmoke;
  padding: 6px;
  size: auto;
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
  width: 95%;
  overflow: hidden;
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
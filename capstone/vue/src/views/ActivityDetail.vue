<template>
  <div class="main">
    <activities-tile v-show="clicked" />
    <nav-menu class="nav-menu"></nav-menu>
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
          <li>{{ getActivityDetails.description }}</li>
        </ul>
      </div>
      <div class="route-detail">
        <h3>Route Details</h3>
        <h3>{{ getActivityDetails.activityName }}</h3>
        <ul class="act-details">
          <li>
            {{ getActivityDetails.activityDate }} |
            {{ getActivityDetails.startTime }} |
            {{ getActivityDetails.endTime }}
          </li>
          <li>{{ getActivityDetails.description }}</li>
        </ul>
      </div>
    </div>
  </div>
</template>


<script>
import Map from "../components/maps/Map.vue";
import NavMenu from "../components/NavMenu.vue";
import ActivitiesTile from "../components/tiles/ActivitiesTile.vue";
export default {
  name: "activity-detail",
  props: {
    activity: Object,
  },
  components: {
    Map,
    NavMenu,
    ActivitiesTile,
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
    mounted() {
      const e = document.querySelector("Map");
      return e.remove();
    },
  },
};
</script>

<style scoped>
.main {
  display: flex;
  width: 100vw;
}
.nav-menu {
  width: 100%;
}
.tile {
  align-self: center;
  justify-self: center;
  display: flex;
  flex-direction: column;
  align-content: center;
  padding: 1px;

  height: 93vh;
  width: 70vw;
}
.route-detail {
  margin-right: 8px;
  display: flex;
  border-radius: 8px;
  height: 25%;
  width: 95%;
  background: lightgray;
  overflow: auto;
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
</style>
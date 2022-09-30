<template>
  <div class="main">
    <nav class="desktop-nav" v-if="!isMobile">
      <h1 class="logo">Wheels of Fury</h1>
      <h2></h2>

      <h3
        @click="
          showActivitiesTile = false;
          showRouteTile = !showRouteTile;
        "
      >
        Routes
      </h3>

      <h3
        @click="
          showRouteTile = false;
          showActivitiesTile = !showActivitiesTile;
        "
      >
        My Activities
      </h3>

      <router-link
        v-bind:to="{ name: 'profile' }"
        style="text-decoration: none; color: inherit"
        class="h3"
        ><h3>Profile</h3></router-link
      >
    </nav>

    <nav class="desktop-nav" v-else>
      <h3
        @click="
          showActivitiesTile = false;
          showRouteTile = !showRouteTile;
        "
      >
        Routes
      </h3>

      <h3
        @click="
          showRouteTile = false;
          showActivitiesTile = !showActivitiesTile;
        "
      >
        My Activities
      </h3>

      <router-link
        v-bind:to="{ name: 'profile' }"
        style="text-decoration: none; color: inherit"
        class="h3"
        ><h3>Profile</h3></router-link
      >
    </nav>

    <div class="view">
      <div class="route-tile overlay" v-show="showRouteTile">
        <h3>Routes</h3>

        <div class="route-options">
          <!-- make the next two lines functional -->
          <h4>My routes</h4>
          <h4>Public Routes</h4>
        </div>
        <input type="text" id="route-search" v-model="routeFilter.routeName" />
        <route-tile
          class="route-div"
          v-for="route in filteredRoutes"
          v-bind:key="route.route_id"
        />
      </div>

      <div class="route-tile overlay" v-show="showActivitiesTile">
        <h3>My Activities</h3>
        <h4>Add Activity</h4>
        <input
          type="text"
          id="route-search"
          v-model="activityFilter.activity_name"
        />
        <!-- activity filter needs to be implemented -->
        <activity
          class="activity-div"
          v-for="activity in filteredActivity"
          v-bind:key="activity.activity_id"
        />
      </div>

      <Map class="map"></Map>
    </div>
  </div>
</template>



<script>
// make media queries work like they should
//expand search feature and apply to routes && bikes

import Map from "../components/maps/Map.vue";
import activity from "../components/tiles/activity.vue";
import RouteTile from "../components/tiles/RouteTile.vue";

export default {
  name: "home",


  data() {
    return {
      isMobile: false,
      windowWidth: window.innerWidth,
      activityFilter: {
        route_id: 0,
        user_id: 0,
        activity_name: "",
        activity_id: 0,
        is_public: true,
        photos: "",
        description: "",
        activity_date: "",
        start_time: "",
        end_time: "",
      },
      routeFilter: {
        routeName: "",
        description: "",
        distance: 0,
        elevation: 0,
        ascent: 0,
      },
      showRouteTile: false,
      showActivitiesTile: false,
      routes: [],
      activities: [],
    };
  },
  components: {
    Map,
    RouteTile,
    activity,
  },
  mounted() {
    this.$nextTick(() => {
      window.addEventListener("resize", this.onResize);
      this.onResize();
    });
  },

  beforeDestroy() {
    window.removeEventListener("resize", this.onResize);
  },

  computed: {
    filteredActivity() {
      let activityFilter = this.activityFilter.activity_name;
      let filteredActivity = this.activities;
      const activities = this.$store.state.activity;
      if (activityFilter != "") {
        filteredActivity = activities.filter((activity) =>
          activity.activity_name
            .toLowerCase()
            .includes(activityFilter.toLowerCase())
        );
        return filteredActivity;
      } else return this.$store.state.activity;
    },
    filteredRoutes() {
      let routeFilter = this.routeFilter.routeName;
      let filteredRoutes = this.routes;
      const routes = this.$store.state.routes;
      if (routeFilter != "") {
        filteredRoutes = routes.filter((route) =>
          route.routeName.toLowerCase().includes(routeFilter.toLowerCase())
        );
        return filteredRoutes;
      } else return this.$store.state.routes;
    },
    lastRoute() {
      const routes = this.$store.state.routes;
      const lastRoute = routes.pop();
      return lastRoute.routeName;
    },
  },
  methods: {
    hideOtherTiles() {
      this.showRouteTile = false;
      this.showActivitiesTile = false;
    },
    onResize() {
      this.windowWidth = window.innerWidth;
      if (this.windowWidth < 700) {
        this.isMobile = true;
      } else {
        this.isMobile = false;
      }
    },
  },
};


</script>
<style>
@media only screen and (min-width: 700px) {
  .view {
    display: flex;
    margin: 0;
    padding: 0;
    height: 100vh;
    width: 80%;
  }
  .map {
    height: 100vh;
  }
  .main {
    display: flex;
    height: 100vh;
  }
  .logo {
    padding-top: 6%;
    padding-bottom: 8%;
  }
  h2 {
    border-bottom: 1px;
    border-style: solid;
    border-color: black;
    margin-left: 30%;
    margin-right: 30%;
  }
  .logo:hover {
    background-color: whitesmoke;
  }
  .desktop-nav {
    height: 100%;
    width: 20%;
    background: lightgray;
  }
  h3 {
    padding-top: 4%;
    padding-bottom: 4%;
  }
  h3:hover {
    background-color: whitesmoke;
  }
  .h3 {
    padding-top: 4%;
    padding-bottom: 4%;
  }
  .h3:hover {
    background-color: whitesmoke;
  }
  .route-tile {
    display: flex;
    align-items: center;
    flex-direction: column;
    border-radius: 8px;
    position: absolute;
    padding-left: 5px;
    margin-left: 10px;
    padding-top: 30px;
    height: 76%;
    width: 35%;
    background: lightgray;
    z-index: 5;
    align-self: center;
    overflow: auto;
  }
  #route-search {
    margin: 5%;
  }
  .route-div {
    height: 50%;
    width: 80%;
    margin: 10px;
    background-color: whitesmoke;
    align-self: center;
    justify-self: center;
    justify-self: end;
  }
  .activity-div {
    height: 50%;
    width: 90%;
    margin: 10px;
    background-color: whitesmoke;
    align-self: center;
    justify-self: center;
    justify-self: end;
  }
  .route-options {
    display: flex;
    justify-content: space-evenly;
  }
  h4 {
    margin: 50px;
    margin-bottom: 10px;
  }
  .activity {
    height: 50%;
    width: 80%;
    background-color: whitesmoke;
    align-self: center;
    justify-self: center;
    justify-self: end;
  }
  .overlay h3 {
    font-size: 32px;
    margin: 0px;
    padding-top: 10px;
  }
  input {
    width: 200px;
  }
}
@media only screen and (min-width: 1440px) {
  .view {
    display: flex;
    margin: 0;
    padding: 0;
    height: 100vh;
    width: 85%;
  }
  .map {
    height: 100vh;
  }
  .main {
    display: flex;
    height: 100vh;
  }
  .logo {
    padding-top: 6%;
    padding-bottom: 8%;
  }
  h2 {
    border-bottom: 1px;
    border-style: solid;
    border-color: black;
    margin-left: 30%;
    margin-right: 30%;
  }
  .logo:hover {
    background-color: whitesmoke;
  }
  .desktop-nav {
    height: 100%;
    width: 15%;
    background: lightgray;
  }
  h3 {
    padding-top: 4%;
    padding-bottom: 4%;
  }
  h3:hover {
    background-color: whitesmoke;
  }
  .h3 {
    padding-top: 4%;
    padding-bottom: 4%;
  }
  .h3:hover {
    background-color: whitesmoke;
  }
  .route-tile {
    display: flex;
    align-items: center;
    flex-direction: column;
    border-radius: 8px;
    position: absolute;
    padding-left: 5px;
    margin-left: 10px;
    padding-top: 30px;
    height: 76%;
    width: 35%;
    background: lightgray;
    z-index: 5;
    align-self: center;
    overflow: auto;
  }
  #route-search {
    margin: 5%;
  }
  .route-div {
    height: 50%;
    width: 80%;
    margin: 10px;
    background-color: whitesmoke;
    align-self: center;
    justify-self: center;
    justify-self: end;
  }
  .activity-div {
    height: 50%;
    width: 90%;
    margin: 10px;
    background-color: whitesmoke;
    align-self: center;
    justify-self: center;
    justify-self: end;
  }
  .route-options {
    display: flex;
    justify-content: space-evenly;
  }
  h4 {
    margin: 50px;
    margin-bottom: 10px;
  }
  .activity {
    height: 50%;
    width: 80%;
    background-color: whitesmoke;
    align-self: center;
    justify-self: center;
    justify-self: end;
  }
  .overlay h3 {
    font-size: 32px;
    margin: 0px;
    padding-top: 10px;
  }
  input {
    width: 200px;
  }
}
@media only screen and (max-width: 700px) {
  .view {
    display: flex;
    margin: 0;
    padding: 0;
    height: 100vh;
    width: 100%;
    justify-content: center;
  }

  .main {
    display: flex;
    flex-direction: column;
    height: 100vh;
    align-content: center;
  }
  .map {
    height: 100%;
    width: 10%;
    overflow: hidden;
  }
  .route-tile {
    display: flex;
    align-items: center;
    flex-direction: column;
    border-radius: 8px;
    position: absolute;
    padding-left: 5px;
    margin-left: 10px;
    padding-top: 30px;
    height: 30%;
    width: 80%;
    background: lightgray;
    z-index: 5;
    align-self: flex-end;
    overflow: auto;
    margin-bottom: 32%;
  }
  .activity {
    height: 50%;
    width: 80%;
    background-color: whitesmoke;
    align-self: center;
    justify-self: center;
    justify-self: end;
  }
  .route-div {
    height: 50%;
    width: 80%;
    margin: 10px;
    background-color: whitesmoke;
    align-self: center;
    justify-self: center;
    justify-self: end;
  }
  .activity-div {
    height: 50%;
    width: 90%;
    margin: 10px;
    background-color: whitesmoke;
    align-self: center;
    justify-self: center;
    justify-self: end;
  }

  .desktop-nav {
    display: flex;
    flex-direction: row;
    background-color: whitesmoke;
    border: 1px solid lightgray;
    margin: 10px;
    border-radius: 10px;
    justify-content: space-evenly;
    position: fixed;
    left: 0;
    bottom: 0;
    height: 10vh;
    width: 100vw;
    background: lightgray;
    z-index: 5;
    float: inherit;
  }

  h3 {
    padding-top: 4%;
    padding-bottom: 4%;
  }

  h3:hover {
    background-color: whitesmoke;
  }
  .h3 {
    padding-top: 4%;
    padding-bottom: 4%;
  }
  .h3:hover {
    background-color: whitesmoke;
  }
}
</style>

<template>
  <div class="main">
    <nav class="desktop-nav">
      <h1 class="logo">Wheels of Fury</h1>
      <h2></h2>
      <h3
        @click="
          hideOtherTiles();
          showRouteTile = !showRouteTile;
        "
      >
        Routes
      </h3>
      <h3
        @click="
          hideOtherTiles();
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
          <h4>My routes</h4>
          <h4>Public Routes</h4>
          <h4></h4>
        </div>
        <input type="text" id="route-search" v-model="searchRoute.routeName" />
        <route-tile class="route-div" />
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
          class="activity"
          v-for="activity in filteredActivity"
          v-bind:key="activity.activity_id"
        />
      </div>
      <Map class="map"></Map>
    </div>
  </div>
</template>

<script>
import Map from "../components/maps/Map.vue";
import activity from "../components/tiles/activity.vue";
import RouteTile from "../components/tiles/RouteTile.vue";

export default {
  name: "home",
  data() {
    return {
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
      searchRoute: {
        routeName: "Search for Routes",
      },
      searchActivity: {
        ActivityName: "Search Activities",
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
      }
      return filteredActivity;
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
  },
};
</script>

<style>
.view {
  display: flex;
  height: 100vh;
  width: 80vw;
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
  border-right: 0px;
  border-top: 0px;
  border-left: 0px;
  border-bottom: 2px;
  border-style: solid;
  border-color: black;
  margin-left: 30%;
  margin-right: 30%;
}
.logo:hover {
  background-color: whitesmoke;
}
.desktop-nav {
  height: 100vh;
  width: 30vw;
  background: lightgray;
}
.map {
  height: 100vh;
  width: 70vw;
  z-index: 1;
  position: absolute;
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
  flex-direction: column;
  border-radius: 8px;
  position: absolute;
  padding-left: 5px;
  margin-left: 10px;
  height: 76%;
  width: 40%;
  background: lightgray;
  z-index: 5;
  align-self: center;
  overflow: auto;
}

#route-search {
  margin: 5%;
}
#route-selector {
  margin: 5%;
}

.route-div {
  height: 50%;
  width: 80%;
  background-color: whitesmoke;
  align-self: center;
  justify-self: center;
  justify-self: end;
}
.route-options {
  display: flex;
  justify-content: space-evenly;
}
.activity {
  height: 50%;
  width: 80%;
  background-color: whitesmoke;
  align-self: center;
  justify-self: center;
  justify-self: end;
}
</style>

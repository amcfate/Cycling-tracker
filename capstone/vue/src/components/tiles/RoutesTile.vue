<template>
  <div class="route-tile overlay">
    <h3>Community Routes</h3>
    <input
      type="text"
      id="route-search"
      placeholder="Search by route name..."
      v-model="routeFilter.routeName"
    />
    <route-thumb
      class="route-div"
      @click="displayDetail = !displayDetail"
      v-for="route in filteredRoutes"
      v-bind:key="route.route_id"
      v-bind:route="route"
    />
    <route-detail v-show="!displayDetail" />
  </div>
</template>

<script>
import RouteDetail from "../../views/RouteDetail.vue";
import RouteThumb from "./RouteThumb.vue";

export default {
  name: "routes-tile",

  data() {
    return {
      routeFilter: {
        routeName: "",
        description: "",
        distance: 0,
        elevation: 0,
        ascent: 0,
      },
      showRouteTile: false,
      displayDetail: true,
      routes: [],
    };
  },
  components: {
    RouteThumb,
    RouteDetail,
  },
  computed: {
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
  },
};
</script>

<style scoped>
@media only screen and (min-width: 700px) {
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
    background: #9bcea8;
    z-index: 5;
    align-self: center;
    overflow: auto;
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
  #route-search {
    margin: 5%;
  }
}

@media only screen and (min-width: 1440px) {
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
    background: #9bcea8;
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
}

@media only screen and (max-width: 700px) {
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
    background: #9bcea8;
    z-index: 5;
    align-self: flex-end;
    overflow: auto;
    margin-bottom: 40%;
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
}
</style>
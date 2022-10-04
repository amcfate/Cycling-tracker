<template>
  <div class="main">

    <nav class="desktop-nav" v-if="!isMobile">
      <h1 class="logo">Velocity</h1>
      <h2></h2>

      <div class="highlighter"><h3
        @click="
          showActivitiesTile = false;
          showRouteTile = !showRouteTile;
        "
      >
        Routes
      </h3></div>

      <h3
        @click="
          showRouteTile = false;
          showActivitiesTile = !showActivitiesTile;
        "
      >
      Activities
      </h3>

     <h3> <router-link
        v-bind:to="{ name: 'profile' }"
        style="text-decoration: none; color: inherit"
        class="h3"
        >Profile</router-link
      ></h3>

      
      <h3> <router-link
        v-bind:to="{ name: 'leaderboard' }"
        style="text-decoration: none; color: inherit"
        class="h3"
        >Leaderboard</router-link
      ></h3>

       <router-link
        v-bind:to="{ name: 'logout' }"
        style="text-decoration: none; color: inherit"
        class="logout"
        ><h3>Logout</h3></router-link
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
        Activities
      </h3>

      <router-link
        v-bind:to="{ name: 'profile' }"
        style="text-decoration: none; color: inherit"
        class="h3"
        ><h3>Profile</h3></router-link
      >

     
    </nav>

    <div class="view">

      <routes-tile v-show="showRouteTile"/>
   
      <activities-tile v-show="showActivitiesTile"/>


      <Map class="map"></Map>
    </div>
  </div>
</template>



<script>

//expand search feature and apply to routes && bikes

import Map from "../components/maps/Map.vue";
import RouteService from "@/services/RouteServices.js"
import ActivitiesService from "@/services/ActivitiesService.js"
import RoutesTile from '../components/tiles/RoutesTile.vue';
import ActivitiesTile from '../components/tiles/ActivitiesTile.vue';
export default {
  name: "home",


  data() {
    return {
      isMobile: false,
      windowWidth: window.innerWidth,
      showRouteTile: false,
      showActivitiesTile: false,
      routes: [],
      activities: [],
    };
  },
  components: {
    Map,
    RoutesTile,
    ActivitiesTile,

    
  },
  mounted() {
    this.$nextTick(() => {
      window.addEventListener("resize", this.onResize);
      this.onResize();
    });
      this.getAllActivities();
     this.getAllRoutes()
  },

  beforeDestroy() {
    window.removeEventListener("resize", this.onResize);
     this.clearData();

  },
   created(){
     

  },

  computed: {

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
    clearData(){
      this.$store.commit('CLEAR_DATA')
    },
    getAllActivities(){
          ActivitiesService
      .getActivities()
      .then(response => {
        this.$store.commit("SET_ACTIVITIES", response.data);
      })
      .catch(error => {
        if (error.response.status == 404) {
          this.$router.push({name: 'NotFound'});
        }
      });
    },
    getAllRoutes(){
         RouteService
      .getAllRoutes()
      .then(response => {
        this.$store.commit("SET_ROUTES", response.data);
      })
      .catch(error => {
        if (error.response.status == 404) {
          this.$router.push({name: 'NotFound'});
        }
      });
    }

  },
};


</script>
<style >

 

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
   padding-top: 4%;
    padding-bottom: 4%;
    border-radius: 4px;
  
  }
  h2 {
    border-bottom: 1px;
    border-style: solid;
    border-color: black;
    margin-left: 30%;
    margin-right: 30%;
  }

  .desktop-nav {
    height: 100%;
    width: 20%;
    background: rgb(114, 111, 111);
   display: flex;
   flex-flow: column;
  }
  .logout{
    margin-top: auto;
    font-weight: 100;
  }
  .logout h3{
    font-weight: 1;
  }

  h3 {
    margin: 10px;
    padding-top: 4%;
    padding-bottom: 4%;
    border-radius: 4px;

  }

  .h3 {
    padding-top: 4%;
    padding-bottom: 4%;
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

 

  .activity {
    height: 50%;
    width: 80%;
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
    justify-content: space-evenly;
    position: fixed;
    left: 0;
    bottom: 0;
    height: 90px;
    width: 96.5%;
    background: lightgray;
    z-index: 4;
    float: inherit;
  }



  h3, .h3{
    text-align: center;
    padding: 1%;
  }

  h3:hover, h3:hover {
  color: whitesmoke;
  }
 
  /* .h3:hover {
    background-color: whitesmoke;
  } */
}
</style>

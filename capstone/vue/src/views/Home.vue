<template>
  <div class="main">

      <nav class="desktop-nav">
        <h1 class="logo">Wheels of Fury</h1>
        <h2></h2>
        <h3 @click="showRouteTile = !showRouteTile">Routes</h3>
        <h3 @click="showActivitiesTile = !showActivitiesTile">My Activities</h3>
        <router-link v-bind:to="{name: 'profile'}" 
        style="text-decoration: none; color: inherit;" class="h3"><h3>Profile</h3></router-link>
      
    </nav>
    <div class="view">
      
        <div class="route-tile overlay" v-show ="showRouteTile">
          
          <input value="Search Routes" type="text"  id="route-search" v-model="searchRoute.routeName">
          <select id="route-selector">
             <option>{{route}}</option> 
          </select>
          <route-tile class="route-div"/>
        </div>
         <div class="route-tile overlay" v-show ="showActivitiesTile">Hello baby
          
        </div>
        <Map class="map"></Map >
    </div>
  </div>
</template>

<script>


import Map from "../components/maps/Map.vue"
import RouteTile from "../components/NavBar/RouteTile.vue"

export default {
  name: "home",
  data() {
    return {
      searchRoute:{
        routeName:""
      },
      showRouteTile: false,
      showActivitiesTile: false,
      routes:[],
    };
  },
  components: {
    Map,
    RouteTile,
   
  },
  computed: {
    filteredList() {
      let filteredRoutes = this.$store.state.searchRoute.toLowerCase;
      const routes = this.$store.state.routes;
      if (this.SearchRoute.RouteName != "") {
        filteredRoutes = routes.filter((route) =>
          route.routeName.toLowerCase()
            .includes(filteredRoutes.toLowerCase())
        );   
  } return filteredRoutes;
},
  lastRoute(){
    const routes = this.$store.state.routes;
    const lastRoute = routes.pop();
     return lastRoute.routeName;
  }
  }
};

</script>

<style>
body{
  
}
.view{
  display: flex;
  height: 100vh;
  width: 80vw;
  
}
.main{
  display: flex;
  height: 100vh;
}
.logo{
  padding-top: 6%; 
  padding-bottom: 8%; 
}
h2{
 border-right: 0px;
  border-top:0px;
  border-left: 0px;
  border-bottom: 2px;
  border-style:solid;
  border-color: black;
  margin-left: 30%;
  margin-right: 30%;
}
.logo:hover{
  background-color: whitesmoke;
}
.desktop-nav {
 height: 100vh;
 width: 30vw;
 background: lightgray;

}
.map{
  height: 100vh;
  width: 70vw;
  z-index: 1;
  position: absolute;
  
}

h3{
  padding-top: 4%;
  padding-bottom: 4%;

}

h3:hover{
  background-color: whitesmoke;
}
.h3{
  padding-top: 4%;
  padding-bottom: 4%;
  
  
}
.h3:hover{
  background-color: whitesmoke;
}
.route-tile{
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

}

#route-search{
  margin: 5%;
}
#route-selector{
  margin: 5%;
}

.route-div{
  
  height: 50%;
  width: 80%;
  background-color: whitesmoke;
  align-self: center;
  justify-self: center;
  justify-self: end;
}

</style>

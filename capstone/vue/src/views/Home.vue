<template>
  <div class="main">

      <nav class="desktop-nav">
        <h1 class="logo">Wheels of Fury</h1>
        <h2></h2>
        <h3 @click="showRouteTile = !showRouteTile">Routes</h3>
        <h3><router-link v-bind:to="{name: 'profile'}" 
        style="text-decoration: none; color: inherit;" class="h3">Profile</router-link></h3>
        <h3 @click="showActivitiesTile = !showActivitiesTile">My Activities</h3>
    </nav>
    <div class="view">
      
        <div class="route-tile overlay" v-show ="showRouteTile">Hello baby
          
        </div>
         <div class="route-tile overlay" v-show ="showActivitiesTile">Hello baby
          
        </div>
        <Map class="map"></Map >
    </div>
  </div>
</template>

<script>


import Map from "../components/maps/Map.vue"

export default {
  name: "home",
  data() {
    return {
      showRouteTile: false,
      showActivitiesTile: false,
    };
  },
  components: {
    Map
    
  },
};
</script>

<style>
.view{
  display: flex;
  height: 100vh;
  width: 80vw;
  
}
.main{
  display: flex;

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
  z-index: 5;
  position: absolute;
}
.h3:hover{
  background-color: whitesmoke;
}
.route-tile{
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
router-link{
  text-decoration-line: none;
}
</style>

<template>
<router-link class="home route-thumb" 
v-bind:to="{name: 'route-detail', params: {id: route_id}}" 
v-bind:route="route"
 style="text-decoration: none; color: inherit">
      <h2 class="header">{{route.routeName}}</h2>
      <div class="info">
      <h5>Length</h5>
      <p>{{route.distance}} miles</p>
      <h5>elevation gain</h5>
      <p>{{route.ascent}} feet</p>
      <h5></h5>
      </div>
      <div class="mapDiv"></div>    
  </router-link>
</template>

<script>


export default {
  name: "route-thumb",
  props: ["route"],
  
  data() {
    return {
      ActivityClicked: false,
      
     
    };
    
  },

  };
</script>

<style>

.home{
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  background-color: lightgray;
  border-radius: 8px;
  box-shadow: 2px 10px 20px darkgrey;  
  }

 @media only screen and (max-width: 1000px){
  .route-thumb {
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
 }
@media only screen and (max-width: 1000px) {
  .route-thumb {
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
  height:50%;
  width: 80%;
  background-color: black;
  margin-bottom: 22px;
  
}
h5{
  margin-top: 3px;
  margin-bottom: 3px;
  padding: none;
}
p{
   margin-top: 3px;
  margin-bottom: 3px;
}
</style>
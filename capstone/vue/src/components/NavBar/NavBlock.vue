<template>
  <div class="home">
      <h2 class="header">Home</h2>
      <div class="mapDiv">
      <Map class="map"/>
      </div>    
        <ul class="menu">
          <li class="activities"><img src="..\public\assets\open-book.png" alt=""></li>
          <li><img class="routes" src="..\public\assets\signpost (2).png" alt=""></li>
          <li class="bikes"><img src="..\public\assets\road-bike (2).png" alt=""></li>
          <li class="gear"><img src="..\public\assets\darkbackpack.png" alt=""></li>
          <li class="settings"><img src="..\public\assets\gear.png" alt=""></li>
        </ul>
        </div>
</template>

<script>
import Map from "@/components/maps/Map";
export default {

  name: "home",
  data() {
    return {
      ActivityClicked: false,
    };
  },
  components: {
    Map
  },
};

</script>

<style>
.home{
  margin: auto;
  display: flex;
  align-content: space-between;
  flex-direction: column;
  justify-content: center;
  background-color: lightgray;
  background-size: 100% 100%;
  border-radius: 8px;
  height: 60vh;
  box-shadow: 2px 10px 20px darkgrey;
    width: 60vh;
    padding: 40px;
  }
@media only screen and (max-width: 1000px){
  .home {
  margin: auto;
  display: flex;
  align-content: space-between;
  flex-direction: column;
  justify-content: center;
  background-color: lightgray;
  background-size: 100% 100%;
  border-radius: 8px;
  width: 60%;
  height: 60vh;
  box-shadow: 2px 10px 20px darkgrey;
  padding: 40px;
}
}

.mapDiv{
  border-radius: 8px;
}

.map {
 max-height: 60%;
 max-width: 60%;
 border-radius: 8px;
}
.menu{
  list-style-type: none;
  display: flex;
  align-items: center;
  justify-content: space-evenly;
}

.menu li img{
  height: 30px;
  width: 30px;
  
}
</style>
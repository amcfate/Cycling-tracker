<template>
  <div class="home">
      <h2 class="header">LastRoute</h2>
      <div class="info">
      <h5>date:</h5>
      <p>500ad</p>
      <h5>Best time:</h5>
      <p>500 hours</p>
      <h5></h5>
      </div>
      <div class="mapDiv"></div>    
  </div>
</template>

<script>

export default {

  name: "home",
  data() {
    return {
      ActivityClicked: false,
    };
  },
  components: {
    
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
/* @media only screen and (max-width: 1000px){
  .home {
  margin: auto;
  display: flex;
  align-content: space-between;
  flex-direction: column;
  justify-content: center;
  background-color: lightgray;
  background-size: 100% 100%;
  border-radius: 8px;
  width: 70%;
  height: 80vh;
  box-shadow: 2px 10px 20px darkgrey;
 
  flex-basis:auto;
}
} */

.mapDiv{
    
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
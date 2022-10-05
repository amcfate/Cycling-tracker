<template>
  <router-link class="home"
  v-bind:to="{name: 'activity-detail', params: {id: activity.activityId}}"
  v-bind:activity="activity"
  style="text-decoration: none; color: inherit">
      <h2 class="header">{{activity.activityName}}</h2>
      <div class="info">
      <h5>Description</h5>
      <p>{{activity.description}}</p>
      <h5>Date</h5>
      <p>{{activity.activity_date}}</p>
      <h5></h5>
      </div>
      <div class="mapDiv"></div>    
  </router-link>
</template>

<script>

export default {
  name: "activity-thumb",
  props: {
    activity: Object,
  },

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
 .header{
    background-color: #9BCEA8;
  }

 @media only screen and (max-width: 1000px){
  .home {
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
  .home {
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
<template>
  <router-link class="home"
  v-bind:to="{name: 'activity-detail', params: {id: activity.activityId}}"
  v-bind:activity="activity"
  style="text-decoration: none; color: inherit">
      <h3 class="header">{{activity.activityName}}</h3>
      <div class="info">
      <h5>Description</h5>
      <p>{{ activity.description }}</p>
      <h5>Date</h5>
      <p>{{activity.activityDate}}</p>
      <h5>Time</h5>
      <p>{{activity.startTime}}</p>
      </div>
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

<style scoped>
.home {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  background-color: lightgray;
  border-radius: 8px;
  box-shadow: 2px 10px 20px darkgrey; 
  overflow: auto;
  }
 .header{
   margin-top: 10px;
    background-color: #9BCEA8;
    border-radius: 6px;
    padding: 5px;
  }

 @media only screen and (max-width: 700px){
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
  overflow: auto;
}
 }
@media only screen and (max-width: 700px) {
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
      overflow: auto;
    flex-basis: auto;
  }
}

.mapDiv {
  border-radius: 8px;
  height: 50%;
  width: 80%;
  background-color: black;
  margin-bottom: 22px;
}
h5 {
  margin-top: 3px;
  margin-bottom: 3px;
  padding: none;
}
p {
  margin-top: 3px;
  margin-bottom: 3px;
}
</style>
<template>
  <div class="route-tile overlay">
    <h3>Recent Activities in the Community</h3>
    <input
      type="text"
      id="route-search"
      placeholder = "Search by activity name..."
      v-model="activityFilter.activityName"
    />
    <activity-thumb
      class="route-div"
      v-for="activity in filteredActivity"
      v-bind:key="activity.activity_id"
      v-bind:activity="activity"
      @click="displayDetail = !displayDetail"
    />
  </div>
</template>

<script>
import ActivityThumb from "./activityThumbnail.vue";
export default {
  name: "activities-tile",
  components: {
    ActivityThumb,
  },
  data() {
    return {
      activityFilter: {
        route_id: 0,
        user_id: 0,
        bike_id: "",
        activityName: "",
        activity_id: 0,
        is_public: true,
        photos: "",
        description: "",
        activity_date: "",
        start_time: "",
        end_time: "",
      },
      showActivitiesTile: false,
      displayDetail: false,
      activities: [],
    };
  },
  computed: {
    filteredActivity() {
      let filteredActivityName = this.activityFilter.activityName;
      let filteredActivity = this.activities;
      if (filteredActivityName != "") {
        filteredActivity = this.$store.state.activity.filter((activity) =>
         activity.activityName.toLowerCase()
         .includes(filteredActivityName.toLowerCase())
        );
        return filteredActivity;
      } else return this.$store.state.activity;
      
    },
  },
};
</script>

<style>
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
      background: #9BCEA8;
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
    background: lightgray;
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
    height: 65%;
    width: 80%;
    background: #9bcea8;
    z-index: 5;
    align-self: flex-end;
    overflow: auto;
    margin-bottom: 150px;
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
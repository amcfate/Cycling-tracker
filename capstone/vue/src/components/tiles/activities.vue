<template>
  <div class="tile">
    <div class="tile-head">
      <h3>My Activities</h3>
      <button class="activity-btn">Add Activity</button>
    </div>
    <div class="display-content" v-for="activity in activities" :key="activity">
      <h2>{{ activity.activityName }}</h2>
      <ul class="act-details">
        <li>
          {{ activity.activityDate }} | {{ activity.startTime }} |
          {{ activity.endTime }}
        </li>
        <li>{{ activity.description }}</li>
      </ul>
    </div>
  </div>
</template>

<script>
import activitiesService from "../../services/ActivitiesService.js";
export default {
  name: "activities",
  components: {},
  data() {
    return {
      activities: [
        {
          routeId: "",
          userId: "int",
          activityName: "",
          activityId: "",
          isPublic: "",
          photos: "",
          description: "",
          activityDate: "",
          startTime: "",
          endTime: "",
        },
      ],
    };
  },
  methods: {
    loadActivities() {
      activitiesService.getActivities().then((response) => {
        this.activities = response.data;
      });
    },
  },
  mounted() {
    this.loadActivities();
  },
};
</script>

<style scoped>
.tile {
  margin: 12px;
  background-color: lightgray;
  background-repeat: no-repeat;
  background-size: 100% 100%;
  background-image: blur;
  border-radius: 8px;
  width: 94%;
  height: auto;
  padding: 6px;
}

.display-content {
  margin: 6px;
  background-color: whitesmoke;
  border: 1px solid black;
  border-radius: 8px;
  text-decoration-color: black;
  text-align: left;
}
.tile-head {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
.tile h3 {
  text-align: left;
  padding: 6px;
}

.activity-btn {
  margin: 6px;
  background-color: whitesmoke;
  border: 1px solid black;
  border-radius: 8px;
  text-decoration-color: black;
  text-align: center;
}
</style>
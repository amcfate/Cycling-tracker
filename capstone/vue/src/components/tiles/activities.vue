<template>
  <div class="tile">
    <div class="tile-head">
      <h3>My Activities</h3>
      <button id="activity-btn" @click="showActivityForm = !showActivityForm">
        Add Activity
      </button>
    </div>
    <new-activity-form
      class="form"
      v-show="showActivityForm"
      :userId="activities[0].userId"
    />
    <div id="display-content" v-for="activity in activities" :key="activity">
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
import NewActivityForm from "../forms/NewActivityForm.vue";
export default {
  name: "activities",
  components: {
    NewActivityForm,
  },
  data() {
    return {
      showActivityForm: false,
      activities: [
        {
          routeId: "",
          userId: "",
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
  display: flex;
  flex-direction: column;
  justify-content: space-around;
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

#display-content,
.form {
  margin: 6px;
  background-color: whitesmoke;
  padding: 6px;
  /* border: 1px solid black; */
  border-radius: 8px;
  box-shadow: 2px 10px 20px darkgray;
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

#activity-btn {
  margin: 6px;
  background-color: whitesmoke;
  border-radius: 8px;
  border-block-style: none;
  box-shadow: 2px 10px 20px darkgray;
  text-align: center;
}
</style>
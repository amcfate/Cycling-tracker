<template>
  <div class="tile">
    <div class="tile-head">
      <h3>My Activities</h3>
      <button
        v-show="showActivity == true"
        style="align-self: center"
        class="remove"
        @click="showActivity = !showActivity"
      >
        ^
      </button>
      <button
        v-show="showActivity == false"
        style="align-self: center"
        class="remove"
        @click="showActivity = !showActivity"
      >
        v
      </button>
      <button id="activity-btn" @click="showActivityForm = !showActivityForm">
        Add Activity
      </button>
    </div>
    <new-activity-form class="form" v-show="showActivityForm" />
    <!-- :userId="activities[0].userId" -->
    <div
      id="display-content"
      v-for="activity in activities"
      :key="activity"
      v-show="showActivity"
    >
      <div class="disp-head">
        <h3>{{ activity.activityName }}</h3>
      </div>
      <ul class="act-details">
        <li>
          {{ activity.activityDate }} | {{ activity.startTime }} -
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
      showActivity: true,
      showActivityForm: false,
      activities: [
        {
          routeId: "",
          userId: "",
          bikeId: "",
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
.remove {
  display: inline-block;
  color: black;
  padding: 6px 6px;
  height: 26px;
  font-weight: bolder;
  font-size: 14px;
  background-color: #9bcea8;
  border-color: white;
  border-radius: 4px;
  margin-right: 240px;
}

.remove:hover {
  background-image: linear-gradient(rgb(0 0 0/40%) 0 0);
}

.tile {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  margin: 12px;
  background-color: #9bcea8;
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
  background-color: white;
  padding: 6px;
  size: auto;
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

.tile-head h3 {
  color: black;
}

.tile h3 {
  text-align: left;
  padding: 6px;
}

#activity-btn {
  margin: 6px;
  background-color: white;
  border-radius: 8px;
  border-block-style: none;
  box-shadow: 2px 10px 20px darkgray;
  text-align: center;
}
</style>
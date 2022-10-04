<template>
  <div id="activity-form">
    <form action="" class="new-activity-form">
      <div class="left-form-container">
        <h3>New Activity</h3>
        <label class="public" for="isPublic"
          >Public:
          <input type="checkbox" v-model="newActivity.isPublic" />
        </label>
        <label for="routeId">Select Route: </label>
        <input
          type="text"
          v-model="newActivity.routeId"
          placeholder="Type routeId FOR NOW..."
        />
        <!-- <select
          class="route-sel"
          name="routeId"
          id=""
          v-model="newActivity.routeId"
        ></select> -->
      </div>
      <div class="container">
        <label class="form-el" for="activityName">Activity Name:</label>
        <input
          class="form-el"
          type="text"
          name="activityName"
          id=""
          v-model="newActivity.activityName"
        />
        <label class="form-el" for="activityDate">Date:</label>
        <input class="form-el" type="date" v-model="newActivity.activityDate" />
        <label class="form-el" for="description">Description:</label>
        <textarea
          class="form-el"
          type="text"
          name="description"
          v-model="newActivity.description"
        />
      </div>
      <div class="container">
        <label class="form-el" for="startTime">Start time:</label>
        <input class="form-el" type="time" v-model="newActivity.startTime" />
        <label class="form-el" for="endTime">End time:</label>
        <input class="form-el" type="time" v-model="newActivity.endTime" />
        <button class="add-btn" @click="submitForm()">Add Activity</button>
      </div>
    </form>
  </div>
</template>

<script>
import activitiesService from "../../services/ActivitiesService.js";
export default {
  props: ["userId"],
  data() {
    return {
      newActivity: {
        activityName: "",
        activityDate: "",
        userId: "",
        startTime: "",
        endTime: "",
        description: "",
        isPublic: "",
        routeId: "",
      },
    };
  },
  methods: {
    submitForm() {
      console.log(this.newActivity);
      activitiesService.addNewActivity(this.newActivity).then((response) => {
        if (response.status === 201) {
          this.$store.commit("ADD_ACTIVITY", this.newActivity);
          this.$router.push("/activity");
          console.log(this.newActivity);
        }
      });
    },
  },
  mounted() {
    this.newActivity = {
      activityName: this.activityName,
      activityDate: this.activityDate,
      userId: this.userId,
      startTime: this.startTime,
      endTime: this.endTime,
      description: this.description,
      isPublic: this.isPublic,
      routeId: this.routeId,
    };
    console.log(this.newActivity);
  },
};
</script>

<style>
#activity-form {
  display: flex;
  flex-direction: row;
  width: auto;
  flex-wrap: wrap;
}
.new-activity-form {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
}
.left-form-container {
  display: flex;
  flex-direction: column;
  align-content: space-evenly;
}
.public {
  display: flex;
  flex-direction: row;
  justify-content: left;
  width: 50%;
  margin-bottom: 8px;
}
.route-sel {
  width: 60%;
  padding: 4px;
}
.container {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
}
.add-btn {
  margin: 4px;
  padding: 8px;
}
.form-el {
  margin: 4px;
  flex-direction: row;
}
</style>
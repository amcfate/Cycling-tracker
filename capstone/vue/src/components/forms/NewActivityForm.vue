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
        <!-- <input
          class="form-el"
          type="text"
          v-model="newActivity.routeId"
          placeholder="Type routeId FOR NOW..."
        /> -->
        <select name="routeId" id="" v-model="newActivity.routeId">
          <option v-for="route in routes" :key="route.routeName">
            {{ route.routeId }}
            <!-- {{ route.routeName }} -->
          </option>
        </select>
        <label for="bikeId">Select your bike: </label>

        <select name="bike" id="" v-model="newActivity.bikeId">
          <option v-for="bike in userBikes" :key="bike.bikeId">
            {{ bike.bikeId }}
            <!-- {{ bike.bikeName }} -->
          </option>
        </select>
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
        <button class="add-btn form-el" @click="submitForm()">
          Add Activity
        </button>
      </div>
    </form>
  </div>
</template>

<script>
import activitiesService from "../../services/ActivitiesService.js";
import bikeService from "../../services/BikeService.js";
import RouteService from "../../services/RouteServices.js";
export default {
  components: {},
  data() {
    return {
      //routeName: "",
      routes: [
        {
          routeName: "",
          routeId: "",
          description: "",
          distance: "",
          elevation: "",
          ascent: "",
        },
      ],
      userBikes: [
        {
          bikeId: "",
          userId: "",
          type: "",
          bikeName: "",
          bikeWeight: "",
          bikeDescription: "",
        },
      ],
      newActivity: {
        activityName: "",
        activityDate: "",
        userId: "",
        bikeId: "",
        startTime: "",
        endTime: "",
        description: "",
        isPublic: "",
        routeId: "",
      },
    };
  },
  // computed: {
  //   getRouteId() {
  //     return this.$store.state.routes.find((route) => {
  //       route.routeName == this.routeName;
  //     });
  //   },
  // },
  methods: {
    submitForm() {
      console.log(this.newActivity);
      activitiesService.addNewActivity(this.newActivity).then((response) => {
        if (response.status === 201) {
          this.$store.commit("ADD_ACTIVITY", this.newActivity);
          // this.$router.push("/activity");
          console.log(this.newActivity);
        }
      });
    },
    loadBikes() {
      bikeService.getUserBikes().then((response) => {
        this.userBikes = response.data;
      });
    },
    loadRoutes() {
      RouteService.getAllRoutes().then((response) => {
        this.routes = response.data;
      });
    },
  },
  mounted() {
    this.loadRoutes();
    this.loadBikes();
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
  justify-content: space-evenly;
  width: auto;
  flex-wrap: wrap;
}
.new-activity-form {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: space-evenly;
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
  /* border-radius: 4px; */
}
</style>
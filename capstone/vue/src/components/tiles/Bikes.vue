<template>
  <div class="tile">
    <div class="tile-head">
      <h3>My Bikes</h3>
      <button class="bikes-btn" @click="showBikeForm = !showBikeForm">
        Add Bikes
      </button>
    </div>
    <new-bike-form
      class="form"
      v-show="showBikeForm"
      :userId="userBikes[0].userId"
    />
    <div class="tile-content">
      <div class="display-content" v-for="bike in userBikes" :key="bike">
        <div class="bike-tiles">
          {{ bike.bikeName }}
          {{ bike.type }}
          {{ bike.bikeDescription }}
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import bikeService from "../../services/BikeService.js";
import newBikeForm from "../forms/NewBikeForm.vue";
export default {
  name: "bikes",
  components: {
    newBikeForm,
  },
  data() {
    return {
      showBikeForm: false,
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
      methods: {
        loadBikes() {
          bikeService.getUserBikes().then((response) => {
            this.userBikes = response.data;
          });
        },
      },
      mounted() {
        this.loadBikes();
      },
    };
  },
};
</script>

<style>
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
.tile-head {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
.tile h3 {
  text-align: left;
  padding: 6px;
}
.display-content {
  display: flex;
  flex-direction: row;
  /* width: fit-content; */
  flex-wrap: wrap;
  margin: 6px;
  background-color: whitesmoke;
  border-radius: 8px;
  box-shadow: 2px 10px 20px darkgray;
  padding: 6px;
  text-align: left;
}
.form {
  margin: 6px;
  background-color: whitesmoke;
  border-radius: 8px;
  box-shadow: 2px 10px 20px darkgray;
  padding: 6px;
  text-align: left;
}
.form {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
}
.bikes-btn {
  margin: 6px;
  background-color: whitesmoke;
  border-block-style: none;
  box-shadow: 2px 10px 20px darkgray;
  border-radius: 8px;
  text-align: center;
}
</style>
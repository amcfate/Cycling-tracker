<template>
  <div id="bike-form">
    <h3>Add a new bike!</h3>
    <form action="" class="new-bike-form">
      <label for="bikeName">Name: </label>
      <input type="text" name="bikeName" id="" v-model="newBike.bikeName" />
      <label for="type">Discipline: </label>
      <input type="text" v-model="newBike.type" />
      <label for="bikeWeight">Weight?</label>
      <input type="text" v-model="newBike.bikeWeight" />
      <label class="form-el" for="description">Description:</label>
      <textarea
        class="form-el"
        type="text"
        name="description"
        v-model="newBike.bikeDescription"
      />
      <button class="add-btn" @click="submitForm()">Add Bike</button>
    </form>
  </div>
</template>

<script>
import bikeService from "../../services/BikeService.js";
export default {
  name: "new-bike-form",
  // props: ["userId"],

  data() {
    return {
      newBike: {
        bikeId: "",
        userId: "",
        type: "",
        bikeName: "",
        bikeWeight: "",
        bikeDescription: "",
      },
    };
  },
  methods: {
    submitForm() {
      console.log(this.newGear);
      bikeService.addNewBike(this.newBike).then((response) => {
        if (response.status === 201) {
          this.$store.commit("ADD_NEW_BIKE", this.newBike);
          //    this.$router.push("/profile");
          console.log(this.newBike);
        }
        location.reload();
      });
    },
  },
  mounted() {
    this.newGear = {
      userId: this.userId,
      miscGear: this.miscGear,
    };
    console.log(this.newGear);
  },
};
</script>

<style>
#bike-form {
  display: flexbox;
  flex-direction: row;
  border-radius: 8px;
  padding-left: 5px;
  margin-left: 10px;
  background: white;
  z-index: 5;
  align-self: flex-start;
  size: auto;
}
.new-bike-form {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  flex-wrap: wrap;
  margin: 4px;
  width: 100%;
}
.add-btn {
  margin: 4px;
  padding: 8px;
}
</style>
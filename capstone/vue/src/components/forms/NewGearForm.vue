<template>
  <div id="gear-form">
    <h3>Add your new piece of gear!</h3>
    <form action="" class="new-gear-form">
      <label class="form-el" for="description">Description:</label>
      <textarea
        class="form-el"
        type="text"
        name="description"
        v-model="newGear.miscGear"
      />
      <button class="add-btn" @click="submitForm()">Add Gear</button>
    </form>
  </div>
</template>

<script>
import gearService from "../../services/GearService.js";
export default {
  props: ["userId"],
  data() {
    return {
      newGear: {
        userId: "",
        miscGear: "",
      },
    };
  },
  methods: {
    submitForm() {
      console.log(this.newGear);
      gearService.addGear(this.newGear).then((response) => {
        if (response.status === 201) {
          this.$store.commit("ADD_GEAR", this.newGear);
          this.$router.push("/gear");
          console.log(this.newGear);
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
.gear-form {
  display: flexbox;
  flex-direction: column;
  border-radius: 8px;
  padding-left: 5px;
  margin-left: 10px;
  background: lightgray;
  z-index: 5;
  align-self: center;
  overflow: auto;
}
.new-gear-form {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  margin: 4px;
  width: 60%;
}
.add-btn {
  margin: 4px;
  padding: 8px;
}
</style>
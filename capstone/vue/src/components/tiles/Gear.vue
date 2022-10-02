<template>
  <div class="tile">
    <div class="tile-head">
      <h3>My Gear</h3>
      <button class="gear-btn" @click="showGearForm = !showGearForm">
        Add Gear
      </button>
    </div>

    <new-gear-form
      class="form"
      v-show="showGearForm"
      :userId="userGear[0].userId"
    />
    <div class="tile-content">
      <div
        class="display-content"
        v-for="gear in userGear"
        v-bind:key="gear.userId"
      >
        <div class="gear-tiles">
          {{ gear.miscGear }}
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import gearService from "../../services/GearService.js";
import newGearForm from "../forms/NewGearForm.vue";
export default {
  name: "gear",
  components: {
    newGearForm,
  },
  data() {
    return {
      showGearForm: false,
      userGear: [
        {
          userId: "",
          miscGear: "",
        },
      ],
    };
  },
  methods: {
    loadGear() {
      gearService.getUserGear().then((response) => {
        this.userGear = response.data;
      });
    },
  },
  mounted() {
    this.loadGear();
  },
};
</script>

<style>
.tile-head {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
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
.tile h3 {
  text-align: left;
  padding: 6px;
}

.tile-content {
  display: flex;
  flex-direction: row;
}

.display-content {
  display: flex;
  flex-direction: row;
  width: fit-content;
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
.gear-btn {
  margin: 6px;
  background-color: whitesmoke;
  border-block-style: none;
  box-shadow: 2px 10px 20px darkgray;
  border-radius: 8px;
  text-align: center;
}
</style>
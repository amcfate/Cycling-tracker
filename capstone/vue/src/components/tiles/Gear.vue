<template>
  <div class="tile">
    <div class="tile-head">
      <h3>My Gear</h3>
      <button class="gear-btn">Add Gear</button>
    </div>
    <div class="display-content">
      {{ userGear.miscGear }}
    </div>
  </div>
</template>

<script>
import gearService from "../../services/GearService.js";
export default {
  name: "gear",
  data() {
    return {
      userGear: {
        userId: "",
        miscGear: "",
      },
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
.display-content {
  margin: 6px;
  background-color: whitesmoke;
  border: 1px solid black;
  border-radius: 8px;
  text-decoration-color: black;
  text-align: left;
}
.gear-btn {
  margin: 6px;
  background-color: whitesmoke;
  border: 1px solid black;
  border-radius: 8px;
  text-decoration-color: black;
  text-align: center;
}
</style>
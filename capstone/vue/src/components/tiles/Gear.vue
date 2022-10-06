<template>
  <div class="tile">
    <div class="tile-head">
      <h3>My Gear</h3>
      <button
        v-show="showGear == true"
        style="align-self: center"
        class="remove"
        @click="showGear = !showGear"
      >
        ^
      </button>
      <button
        v-show="showGear == false"
        style="align-self: center"
        class="remove"
        @click="showGear = !showGear"
      >
        v
      </button>
      <button class="gear-btn" @click="showGearForm = !showGearForm">
        Add Gear
      </button>
    </div>

    <new-gear-form class="form" v-show="showGearForm" />
    <!-- :userId="userGear[0].userId" -->
    <div class="tile-content">
      <div
        v-show="showGear"
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
      showGear: true,

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
    console.log(this.userGear);
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
  margin-right: 290px auto;
}

.remove:hover {
  background-image: linear-gradient(rgb(0 0 0/40%) 0 0);
}
.tile-head {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
.tile {
  margin: 12px;
  background-color: #9bcea8;
  background-size: 100% 100%;
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
  flex-wrap: wrap;
}

.display-content {
  display: flex;
  flex-direction: row;
  width: fit-content;
  flex-wrap: wrap;
  margin: 6px;
  background-color: white;
  border-radius: 8px;
  box-shadow: 2px 10px 20px darkgray;
  padding: 6px;
  text-align: left;
}
.form {
  margin: 6px;
  background-color: white;
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
  background-color: white;
  border-block-style: none;
  box-shadow: 2px 10px 20px darkgray;
  border-radius: 8px;
  text-align: center;
}
</style>
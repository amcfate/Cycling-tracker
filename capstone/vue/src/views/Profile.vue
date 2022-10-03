<template>
  <div class="profile">
    <user-profile />
    <activities />
    <bikes />
    <gear />
  </div>
</template>

<script>
import activities from "../components/tiles/activities.vue";
import Bikes from "../components/tiles/Bikes.vue";
import Gear from "../components/tiles/Gear.vue";
import userProfile from "../components/tiles/UserProfile.vue";
export default {
  name: "profile",
  components: {
    userProfile,
    activities,
    Bikes,
    Gear,
  },
};
</script>

<style>
.profile {
  display: flex;
  flex-direction: column;
  overflow: auto;
  align-items: center;
}
</style>
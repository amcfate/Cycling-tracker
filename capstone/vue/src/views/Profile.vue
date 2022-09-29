<template>
  <div>
    <user-profile />
    <activities />
    <gear />
  </div>
</template>

<script>
import Activities from "../components/tiles/activities.vue";
import Gear from "../components/tiles/Gear.vue";
import userProfile from "../components/tiles/UserProfile.vue";
export default {
  name: "profile",
  components: {
    userProfile,
    Activities,
    Gear,
  },
};
</script>

<style>
</style>
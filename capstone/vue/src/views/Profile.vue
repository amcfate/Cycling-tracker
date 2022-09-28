<template>
  <div>
    <user-profile />
    <activities />
  </div>
</template>

<script>
import userProfile from "../components/tiles/UserProfile.vue";
import activities from "../components/tiles/activities.vue";
export default {
  name: "profile",
  components: {
    userProfile,
    activities,
  },
};
</script>

<style>
</style>
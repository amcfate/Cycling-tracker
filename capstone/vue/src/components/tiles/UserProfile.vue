<template>
  <div class="profile-page">
    <div class="header">
      <h2 id="username">// username</h2>
    </div>
    <!-- <activities /> -->
  </div>
</template>

<script>
// import activities from "../tiles/activities.vue";
export default {
  name: "user-profile",
  components: {
    // activities,
  },
};
</script>

<style>
.header {
  display: flex;
  flex-direction: row;
  background-color: lightgray;
  border: 1px solid darkgray;
  border-radius: 8px;
  margin: 4px;
}

#username {
  color: black;
  text-align: left;
}
</style>
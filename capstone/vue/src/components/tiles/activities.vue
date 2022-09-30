<template>
  <div class="tile">
    <h3>My Activities</h3>
    <div class="disp-content">//user has no activities/history</div>
  </div>
</template>

<script>
export default {
  name: "activities",
  components: {},
};
</script>

<style scoped>
.tile {
  margin: auto;
  background-color: lightgray;
  background-repeat: no-repeat;
  background-size: 100% 100%;
  background-image: blur;
  border-radius: 8px;
  width: 94%;
  height: 200px;
}

.tile h3 {
  text-align: left;
  padding: 6px;
}
</style>
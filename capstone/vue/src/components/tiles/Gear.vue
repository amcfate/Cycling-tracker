<template>
  <div class="tile">
    <h3>My Gear</h3>
    <div class="disp-content">//User has no gear added</div>
  </div>
</template>

<script>
export default {
  name: "gear",
};
</script>

<style>
.tile {
  margin: auto;
  background-color: lightgray;
  background-repeat: no-repeat;
  background-size: 100% 100%;
  background-image: blur;
  border-radius: 8px;
  width: 94%;
  height: 200px;
  /* box-shadow: 2px 10px 20px darkgrey; */
}
.tile h3 {
  text-align: left;
  padding: 6px;
}
</style>
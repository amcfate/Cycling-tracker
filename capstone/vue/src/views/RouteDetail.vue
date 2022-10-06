<template>
  <div class="view">
    <top-nav />
    <h2>HELLO?!?!</h2>
    <div class="route-detail">
      <div>
        <h1>{{ route.routeName }}</h1>
      </div>
    </div>
  </div>
</template>

<script>
import TopNav from "../components/TopNav.vue";
export default {
  components: { TopNav },
  name: "route-detail",
  props: ["route"],
};
</script>

<style scoped>
.view {
  display: flex;
  margin: 0;
  padding: 0;
  height: 100vh;
  width: 100vw;
}
.route-detail {
  display: flex;
  align-items: center;
  flex-direction: column;
  border-radius: 8px;

  padding-left: 5px;
  margin-left: 10px;
  padding-top: 30px;
  height: 100vh;
  width: 35vw;
  background: lightgray;
  z-index: 5;
  align-self: center;
  overflow: auto;
}
</style>
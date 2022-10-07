<template>
  <div class="home route-thumb">
    <router-link
      v-bind:to="{ name: 'route-detail', params: { id: route.routeId } }"
      v-bind:route="route"
      style="text-decoration: none; color: inherit"
    >
      <h3 class="header">{{ route.routeName }}</h3>

      <div class="info">
      <h5>Length</h5>
      <p>{{ route.distanceMiles }} miles</p>
      <h5>elevation gain</h5>
      <p>{{ route.ascent }} feet</p>
      </div>
    </router-link>
  </div>
</template>

<script>
export default {
  name: "route-thumb",
  props: ["route"],

  data() {
    return {
      ActivityClicked: false,
    };
  },
};
</script>

<style scoped>
.home {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  align-items: center;
  background-color: lightgray;
  border-radius: 8px;
  box-shadow: 2px 10px 20px darkgrey;
  overflow: auto;
}

 .header{
   margin-top: 10px;
    background-color: #9BCEA8;
    border-radius: 6px;
    padding: 5px;
  }
@media only screen and (max-width: 700px) {
  .route-thumb {
    margin: auto;
    display: flex;
    align-content: space-between;
    flex-direction: column;
    justify-content: center;
    background-color: lightgray;
    background-size: 100% 100%;
    border-radius: 8px;
    height: 200px;
    box-shadow: 2px 10px 20px darkgrey;
    width: auto;
    padding-left: 3%;
    padding-right: 3%;
    overflow: auto;
  }

}
@media only screen and (max-width: 1000px) {
  .route-thumb {
    margin: auto;
    display: flex;
    flex-grow: auto;
    align-content: space-between;
    flex-direction: column;
    justify-content: center;
    background-color: lightgray;
    background-size: 100% 100%;
    border-radius: 8px;
    width: 70%;
    height: 200px;
    box-shadow: 2px 10px 20px darkgrey;
    overflow: auto;
  }
}
h5 {
  margin-top: 3px;
  margin-bottom: 3px;
  padding: none;
}
p {
  margin-top: 3px;
  margin-bottom: 3px;
}
.info {
  margin-top: 0px;
}

</style>
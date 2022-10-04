<template>
  <div class="view" >
  <h2>{{getActivityDetails.activityName}}</h2>
  </div>
</template>

<script>


export default {

  name: "activity-detail",
  props: {
    activity: Object,
  },
  computed: {
    getActivityDetails(){
      return this.$store.state.activity.find((activity) =>{
        return activity.activityId == this.$route.params.id;
      });
    },
  }

}
</script>

<style>
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
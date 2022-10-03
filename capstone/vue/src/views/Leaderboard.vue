<template>
  <div class = "leaderboard">  
    <h3>Top Athletes on Cicleta</h3>
  
</div>
</template>

<script>


export default {
  name: "leaderboard",
  components: {
    
    
    
  },
};
</script>

<style>
.leaderboard {
  display: flex;
  flex-direction: column;
  overflow: auto;
  margin: 12px;
  background-color: lightgray;
  background-repeat: no-repeat;
  background-size: 100% 100%;
  background-image: blur;
  border-radius: 8px;
  width: 94%;
  height: auto;
  padding: 6px;
}
</style>
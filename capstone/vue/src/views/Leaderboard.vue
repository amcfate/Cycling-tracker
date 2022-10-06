<template>
  <div class="leaderboard">
    <h4>Top Athletes on Velocidad</h4>
    <table>
      <tr>
        <th>Position</th>
        <th>Name</th>
        <th>Total Distance Cycled</th>
      </tr>
      <tr>
        <td>1</td>
        <td>Bob</td>
        <td>100 miles</td>
      </tr>
      <tr>
        <td>2</td>
        <td>Mark</td>
        <td>99 miles</td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "leaderboard",
  components: {},
};
</script>

<style scoped>
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

h4 {
  font-size: 4vh;
}
</style>
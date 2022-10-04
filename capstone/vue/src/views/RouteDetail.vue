<template>
  <div class="route-detail">
      <div>{{route.name}}</div>
  </div>
</template>

<script>
export default {
  name: 'route-detail',
  props:["route"]

}
</script>

<style>
.route-detail {
    display: flex;
    align-items: center;
    flex-direction: column;
    border-radius: 8px;
    position: absolute;
    padding-left: 5px;
    margin-left: 10px;
    padding-top: 30px;
    height: 76%;
    width: 35%;
    background: lightgray;
    z-index: 5;
    align-self: center;
    overflow: auto;
  }
</style>
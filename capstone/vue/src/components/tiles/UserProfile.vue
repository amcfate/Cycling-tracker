<template>
  <div class="profile-page">
    <div class="header">
      <h2 id="username">{{ this.username }}</h2>
    </div>
  </div>
</template>

<script>
export default {
  name: "user-profile",
  components: {},
  data() {
    return {
      id: "",
      username: "",
      cyclingTeam: "",
      userWeight: "",
      uerAge: "",
    };
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
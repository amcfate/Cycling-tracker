<template>
  <div class="profile-form">
    <div class="form-elements">
      <label for="cyclingTeam"
        >A part of a cycling team or club? Put it's name here:
      </label>
      <input type="text" v-model="updateInfo.cyclingTeam" />
      <label for="userAge">If you'd like, add your age here: </label>
      <input type="text" v-model="updateInfo.userAge" />
      <label for="photo">Upload a new profile photo here: </label>
      <input type="file" />
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      updateInfo: {
        username: "",
        cyclingTeam: "",
        userWeight: "",
        uerAge: "",
        photo: "",
      },
    };
  },
};
</script>

<style>
.profile-form {
  display: flex;
  flex-direction: column;
  align-content: space-evenly;
  size: auto;
  margin: 8px;
  border-radius: 8px;
  box-shadow: 2px 10px 20px darkgray;
  background-color: white;
  padding: 8px;
}
.form-elements {
  display: flex;
  flex-direction: column;
  width: 100%;
  margin: 4px;
}
</style>
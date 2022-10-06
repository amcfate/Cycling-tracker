<template>
  <div class="profile-form">
    <div class="form-elements">
      <div class="team">
        <label for="cyclingTeam"
          >A part of a cycling team or club? Put it's name here:
        </label>
        <input type="text" v-model="updateInfo.cyclingTeam" />
      </div>
      <div class="age">
        <label for="userAge">If you'd like, add your age here: </label>
        <input type="text" v-model="updateInfo.userAge" />
      </div>
      <div class="photo">
        <label for="photo">Upload a new profile photo here: </label>
        <select name="photo" id="" v-model="updateInfo.photo"></select>
        <button style="width: auto" @click="updateProfile()">
          Submit Changes
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import profileService from "../../services/ProfileService.js";
export default {
  data() {
    return {
      updateInfo: {
        userId: "",
        username: "",
        cyclingTeam: "",
        userWeight: "",
        uerAge: "",
        photo: "",
      },
    };
  },
  methods: {
    updateProfile() {
      profileService.updateProfileDetails(this.updateInfo).then((response) => {
        if (response.status == 200) {
          this.$store.commit("UPDATE_PROFILE", this.updateInfo);
          //   this.$router.push("/profile");
        }
      });
    },
  },
  mounted() {
    this.updateInfo = {
      userId: this.userId,
      username: this.username,
      cyclingTeam: this.cyclingTeam,
      userWeight: this.userWeight,
      uerAge: this.uerAge,
      photo: this.photo,
    };
  },
};
</script>

<style >
.profile-form {
  display: flex;
  flex-direction: column;
  align-content: center;
  size: auto;
  margin: 8px;
  border-radius: 8px;
  box-shadow: 2px 10px 20px darkgray;
  background-color: white;
  padding: 8px;
  text-align: left;
}

.form-elements {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  width: 100%;
  margin: 4px;
}

.photo {
  display: flex;
  justify-content: flex-start;
  margin: 4px;
}

input {
  margin: 8px;
}
</style>
<template>
  <div class="profile-form">
    <div class="form-elements">
      <form v-on:submit.prevent>
        <div class="team">
          <label for="cyclingTeam"
            >Part of a cycling team or club? Put its name here:
          </label>
          <input type="text" v-model="updateInfo.cyclingTeam" />
        </div>
        <div class="age">
          <label for="userAge">If you'd like, add your age here: </label>
          <input type="text" v-model="updateInfo.userAge" />
        </div>
        <!-- <div class="weight">
          <label for="userAge">Enter your weight here: </label>
          <input type="text" v-model="updateInfo.userWeight" />
        </div> -->
        <div class="submit">
          <!-- <label for="photo">Upload a new profile photo here: </label>
        <select name="photo" id="" v-model="updateInfo.photo"></select> -->
          <button style="width: auto" @click="updateProfile()">
            Submit Changes
          </button>
        </div>
      </form>
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
        userAge: "",
        photo: "",
      },
      
    };
  },
  methods: {
    updateProfile() {
      profileService.updateProfileDetails(this.updateInfo).then((response) => {
        if (response.status == 200) {
          this.$store.commit("UPDATE_PROFILE", this.updateInfo);
          //alert("You have successfully updated your profile!");
        }
      });
    },
    loadProfile() {
      profileService.getProfileDetails().then((response) => {
        this.updateInfo = response.data;
      });
  },
  },

  mounted() {
    this.loadProfile();
  },
    
};
</script>

<style scoped>
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
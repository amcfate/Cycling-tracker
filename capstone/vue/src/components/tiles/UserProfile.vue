<template>
  <div class="profile-page">
    <div class="header">
      <div class="left-container">
        <h2 id="username">
          {{ userProfile.username }}
        </h2>
        <ul>
          <li class="details">Team: {{ userProfile.cyclingTeam }}</li>
          <li class="details">Age: {{ userProfile.userAge }}</li>
        </ul>
      </div>
      <div class="right-container">
        <button class="edit-profile-btn" @click="showEditForm = !showEditForm">
          Edit Profile
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import profileService from "../../services/ProfileService.js";
export default {
  name: "user-profile",
  components: {},
  data() {
    return {
      showEditForm: false,
      userProfile: {
        id: "",
        username: "",
        cyclingTeam: "",
        userWeight: "",
        uerAge: "",
      },
    };
  },
  methods: {
    loadProfile() {
      profileService.getProfileDetails().then((response) => {
        this.userProfile = response.data;
      });
    },
  },

  mounted() {
    this.loadProfile();
  },
};
</script>

<style>
.profile-page {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.header {
  display: flex;
  flex-direction: row;
  background-color: lightgray;
  border: 1px solid darkgray;
  border-radius: 8px;
  justify-content: space-between;
  margin: 4px;
  width: 96vw;
}
.left-container {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  width: 70%;
}
.right-container {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}

#username {
  color: black;
  text-align: left;
  border-block-style: none;
}

.edit-profile-btn {
  margin: 6px;
  background-color: whitesmoke;
  border-radius: 8px;
  border-block-style: none;
  box-shadow: 2px 10px 20px darkgray;
  text-align: center;
}
</style>
<template>
  <div class="profile-page">
    <div class="header">
      <div class="left-container">
        <h2 id="username">
          {{ userProfile.username }}
        </h2>
        <ul class="user-info">
          <li class="details">Team: {{ userProfile.cyclingTeam }}</li>
          <li class="details">Age: {{ userProfile.userAge }}</li>
        </ul>
      </div>
      <div class="right-container">
        <button class="edit-profile-btn" @click="showEditForm = !showEditForm">
          <img src="../../assets/gear.png" />
        </button>
      </div>
    </div>
    <edit-profile-form v-show="showEditForm" />
  </div>
</template>

<script>
import profileService from "../../services/ProfileService.js";
import editProfileForm from "../forms/EditProfileForm.vue";
export default {
  name: "user-profile",
  components: {
    editProfileForm,
  },
  data() {
    return {
      showEditForm: false,
      userProfile: {
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
  flex-direction: column;
  justify-content: space-between;
  background-color: #9bcea8;
  border: 1px solid darkgray;
  border-radius: 8px;
  margin: 4px;
  width: 96vw;
}

.header {
  display: flex;
  flex-direction: row;
  /* background-color: lightgray;
  border: 1px solid darkgray;
  border-radius: 8px; */
  justify-content: space-between;
}
.left-container {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  size: auto;
  width: 100%;
  margin: 8px;
  border-radius: 8px;
  box-shadow: 2px 10px 20px darkgray;
  background-color: white;
}
.right-container {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}

.user-info {
  display: flex;
  flex-direction: column;
}
.details {
  align-self: flex-start;
}

#username {
  color: black;
  text-align: left;
  border-block-style: none;
}

.edit-profile-btn {
  margin: 6px;
  background-color: white;
  border-radius: 8px;
  border-block-style: none;
  box-shadow: 2px 10px 20px darkgray;
  text-align: center;
}

.edit-profile-btn img {
  max-height: 30px;
}
</style>
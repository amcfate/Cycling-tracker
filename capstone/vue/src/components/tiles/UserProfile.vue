<template>
  <div class="profile-page">
    <div class="header">
      <div class="left-container">
        <h2 id="username">
          {{ userProfile.username }}
        </h2>
        <ul class="user-info" v-show="showDetails">
          <li class="details">Team: {{ cyclingTeam }}</li>
          <li class="details">Age: {{ age }}</li>
        </ul>
      </div>
      <div class="right-container">
        <button class="edit-profile-btn" @click="showEditForm = !showEditForm">
          <img src="../../assets/gear.png" />
        </button>
      </div>
    </div>
    <div class="toggle-details" v-show="showEditForm">
      <button @click="showDetails = !showDetails">Show / Hide Details</button>
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
      showDetails: true,
      showEditForm: false,
      userProfile: {
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
    loadProfile() {
      profileService.getProfileDetails().then((response) => {
        if (response.status == 200) {
           this.userProfile = response.data;
          this.$store.commit("UPDATE_PROFILE", this.userProfile);
        }
      });
    
    },
  },
  computed: {
    cyclingTeam() {
      return this.$store.state.user_profile.cyclingTeam},
    age(){
      return this.$store.state.user_profile.userAge},  
  },

  mounted() {
    this.loadProfile();
  },
};
</script>

<style scoped>
.toggle-details {
  display: inline-block;
  color: black;
  padding: 6px 6px;
  height: 26px;
  font-weight: bolder;
  font-size: 10px;
  background-color: #9bcea8;
  border-color: white;
  border-radius: 4px;
}

.toggle-details:hover {
  background-image: linear-gradient(rgb(0 0 0/40%) 0 0);
}
.profile-page {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  background-color: #9bcea8;
  border: 1px solid darkgray;
  border-radius: 8px;
  margin: 4px;
  width: 96%;
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
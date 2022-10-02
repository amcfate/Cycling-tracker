<template>
  <div class="profile-page">
    <div class="header">
      <h2 id="username">
        {{ userProfile.username }}
      </h2>
      <ul>
        <li class="details">Team: {{ userProfile.cyclingTeam }}</li>
        <li class="details">Age: {{ userProfile.userAge }}</li>
      </ul>
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
.header {
  display: flex;
  flex-direction: row;
  background-color: lightgray;
  border: 1px solid darkgray;
  border-radius: 8px;
  margin: 4px;
  justify-content: space-evenly;
  width: 96vw;
}

#username {
  color: black;
  text-align: left;
  border-block-style: none;
}
</style>
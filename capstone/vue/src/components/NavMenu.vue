<template>
  <div>
    <nav class="desktop-nav" v-if="!isMobile">
      <h1 class="logo">VELOcity</h1>
      <h2></h2>

      <h3>
        <router-link
          v-bind:to="{ name: 'home' }"
          style="text-decoration: none; color: inherit"
          class="h3"
          >Home</router-link
        >
      </h3>

      <h3>
        <router-link
          v-bind:to="{ name: 'profile' }"
          style="text-decoration: none; color: inherit"
          class="h3"
          >Profile</router-link
        >
      </h3>

      <h3>
        <router-link
          v-bind:to="{ name: 'leaderboard' }"
          style="text-decoration: none; color: inherit"
          class="h3"
          >Leaderboard</router-link
        >
      </h3>

      <router-link
        v-bind:to="{ name: 'logout' }"
        style="text-decoration: none; color: inherit"
        class="logout"
        ><h3>Logout</h3></router-link
      >
    </nav>
    <!--try to change this to focus event-->
    <nav class="desktop-nav" v-else>
      <h3>
        <router-link
          v-bind:to="{ name: 'home' }"
          style="text-decoration: none; color: inherit"
          class="h3"
          >Home</router-link
        >
      </h3>

      <!-- <h3>
        <router-link
          v-bind:to="{ name: 'profile' }"
          style="text-decoration: none; color: inherit"
          class="h3"
          >Profile</router-link
        >
      </h3> -->

      <h3>
        <router-link
          v-bind:to="{ name: 'leaderboard' }"
          style="text-decoration: none; color: inherit"
          class="h3"
          >Leaderboard</router-link
        >
      </h3>
    </nav>
  </div>
</template>

<script>
import profileService from "../services/ProfileService.js";
export default {
  name: "home",

  data() {
    return {
      userProfile: {
        id: "",
        username: "",
        cyclingTeam: "",
        userWeight: "",
        uerAge: "",
        photo: "",
      },
      isMobile: false,
      windowWidth: window.innerWidth,
      showRouteTile: false,
      showActivitiesTile: false,
      routes: [],
      activities: [],
    };
  },
  components: {},
  mounted() {
    this.profileButton();
    this.$nextTick(() => {
      window.addEventListener("resize", this.onResize);
      this.onResize();
    });
  },

  beforeDestroy() {
    window.removeEventListener("resize", this.onResize);
  },

  methods: {
    profileButton() {
      profileService.getProfileDetails().then((response) => {
        this.userProfile = response.data;
      });
    },
    hideOtherTiles() {
      this.showRouteTile = false;
      this.showActivitiesTile = false;
    },
    onResize() {
      this.windowWidth = window.innerWidth;
      if (this.windowWidth < 700) {
        this.isMobile = true;
      } else {
        this.isMobile = false;
      }
    },
    clearData() {
      this.$store.commit("CLEAR_DATA");
    },
  },
};
</script>

<style scoped>
@media only screen and (min-width: 700px) {
  .logo {
    font-size: 40px;
    padding-top: 4%;
    padding-bottom: 0%;
    border-radius: 4px;
  }
  h2 {
    border-bottom: 1px;
    border-style: solid;
    border-color: black;
    margin-left: 30%;
    margin-right: 30%;
  }

  .desktop-nav {
    height: 100%;
    width: 100%;
    padding: 4px;
    background: #9bcea8;
    display: flex;
    flex-flow: column;
  }
  .logout {
    margin-top: auto;
  }
  .logout h3 {
    font-weight: 1;
    box-shadow: none;
  }

  h3 {
    margin: 10px;
    padding-top: 4%;
    padding-bottom: 4%;
    border-radius: 2px;
    box-shadow: 1px 1px 0px 10px rgba(97, 104, 104, 0.52);
    -webkit-box-shadow: 1px 1px 0px 1px rgba(97, 104, 104, 0.52);
    -moz-box-shadow: 1px 1px 0px 1px rgba(97, 104, 104, 0.52);
    transition: 100ms ease-in-out;
  }

  .h3 {
    padding-top: 4%;
    padding-bottom: 4%;
  }
  h3:hover {
    background-color: #97cea4;
    box-shadow: 1px 1px 0px 10px rgba(97, 104, 104, 0.52);
    -webkit-box-shadow: 1px 1px 0px 1px rgba(97, 104, 104, 0.52);
    -moz-box-shadow: 1px 1px 0px 1px rgba(97, 104, 104, 0.52),
      inset -1px -1px 9px rgba(97, 104, 104, 0.52),
      inset 4px 4px 24px rgba(97, 104, 104, 0.52);
    transform: scale(1.01);
  }

  .activity-div {
    height: 50%;
    width: 90%;
    margin: 10px;
    background-color: whitesmoke;
    align-self: center;
    justify-self: center;
    justify-self: end;
  }
  .route-options {
    display: flex;
    justify-content: space-evenly;
  }
  h4 {
    margin: 50px;
    margin-bottom: 10px;
  }
  .activity {
    height: 50%;
    width: 80%;
    background-color: whitesmoke;
    align-self: center;
    justify-self: center;
    justify-self: end;
  }
  .overlay h3 {
    font-size: 32px;
    margin: 0px;
    padding-top: 10px;
  }
  input {
    width: 200px;
  }
}
@media only screen and (min-width: 1440px) {
  .logo {
    padding-top: 6%;
    padding-bottom: 8%;
  }
  h2 {
    border-bottom: 1px;
    border-style: solid;
    border-color: black;
    margin-left: 30%;
    margin-right: 30%;
  }
  .logo:hover {
    background-color: whitesmoke;
  }
  .desktop-nav {
    height: 100%;
    width: 100%;
    background: #9bcea8;
  }
  h3 {
    padding-top: 4%;
    padding-bottom: 4%;
  }
  h3:hover {
    background-color: whitesmoke;
  }
  .h3 {
    padding-top: 4%;
    padding-bottom: 4%;
  }
  .h3:hover {
    background-color: whitesmoke;
  }

  .activity-div {
    height: 50%;
    width: 90%;
    margin: 10px;
    background-color: whitesmoke;
    align-self: center;
    justify-self: center;
    justify-self: end;
  }
  .route-options {
    display: flex;
    justify-content: space-evenly;
  }
  h4 {
    margin: 50px;
    margin-bottom: 10px;
  }
  .activity {
    height: 50%;
    width: 80%;
    background-color: whitesmoke;
    align-self: center;
    justify-self: center;
    justify-self: end;
  }
  .overlay h3 {
    font-size: 32px;
    margin: 0px;
    padding-top: 10px;
  }
  input {
    width: 200px;
  }
}
@media only screen and (max-width: 700px) {
  .h3 {
    margin: 10px;
    padding-top: 4%;
    padding-bottom: 4%;
    border-radius: 2px;
    box-shadow: 1px 1px 0px 10px rgba(97, 104, 104, 0.52);
    -webkit-box-shadow: 1px 1px 0px 1px rgba(97, 104, 104, 0.52);
    -moz-box-shadow: 1px 1px 0px 1px rgba(97, 104, 104, 0.52);
    transition: 100ms ease-in-out;
  }
  .h3 {
    padding-top: 4%;
    padding-bottom: 4%;
  }
  .h3:hover {
    background-color: #97cea4;
    box-shadow: 1px 1px 0px 10px rgba(97, 104, 104, 0.52);
    -webkit-box-shadow: 1px 1px 0px 1px rgba(97, 104, 104, 0.52);
    -moz-box-shadow: 1px 1px 0px 1px rgba(97, 104, 104, 0.52),
      inset -1px -1px 9px rgba(97, 104, 104, 0.52),
      inset 4px 4px 24px rgba(97, 104, 104, 0.52);
    transform: scale(1.01);
  }
  .activity {
    height: 50%;
    width: 80%;
    background-color: whitesmoke;
    align-self: center;
    justify-self: center;
    justify-self: end;
  }

  .activity-div {
    height: 50%;
    width: 90%;
    margin: 10px;
    background-color: whitesmoke;
    align-self: center;
    justify-self: center;
    justify-self: end;
  }

  .desktop-nav {
    display: flex;
    flex-direction: row;
    background-color: whitesmoke;
    border: 1px solid lightgray;
    margin: 2px;
    border-radius: 2px;
    justify-content: space-evenly;
    position: fixed;
    left: 0;
    bottom: 0;
    height: 70px;
    width: 99vw;
    background: #9bcea8;
    z-index: 4;
    float: inherit;
  }

  h3,
  .h3 {
    text-align: center;
    padding: 1%;
  }

  h3:hover,
  h3:hover {
    color: whitesmoke;
  }
}
</style>
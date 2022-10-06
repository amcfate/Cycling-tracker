<template>
  <div class="main">
    <nav-menu class="nav-menu" />
    <div class="useless-div">
      <div class="profile">
        <user-profile />
        <activities />
        <bikes />
        <gear />
      </div>
    </div>
  </div>
</template>

<script>
import NavMenu from "../components/NavMenu.vue";
import activities from "../components/tiles/activities.vue";
import Bikes from "../components/tiles/Bikes.vue";
import Gear from "../components/tiles/Gear.vue";
import userProfile from "../components/tiles/UserProfile.vue";

export default {
  name: "profile",
  isMobile: false,
  components: {
    userProfile,
    activities,
    Bikes,
    Gear,
    NavMenu,
  },
  data() {
    return {
      isMobile: false,
      windowWidth: window.innerWidth,
    };
  },
  mounted() {
    this.$nextTick(() => {
      window.addEventListener("resize", this.onResize);
      this.onResize();
    });
  },

  beforeDestroy() {
    window.removeEventListener("resize", this.onResize);
  },
  methods: {
    onResize() {
      this.windowWidth = window.innerWidth;
      if (this.windowWidth < 700) {
        this.isMobile = true;
        this.$store.state.commit("SET_IS_MOBILE");
      } else {
        this.isMobile = false;
      }
    },
  },
};
</script>

<style scoped>
.main {
  display: flex;
  width: 98vw;
  height: 100vh;
  overflow: auto;
}

.nav-menu {
  width: 300px;
}
.profile {
  align-self: center;
  justify-self: center;
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100vh;
  width: 80vw;
  margin: auto;
}

@media only screen and (max-width: 700px) {
  .main {
    display: flex;
    width: 98vw;
    height: 86vh;
    overflow: auto;
  }
  .profile {
    align-self: center;
    justify-self: center;
    display: flex;
    flex-direction: column;
    align-content: center;
    width: 98vw;
  }
}
</style>
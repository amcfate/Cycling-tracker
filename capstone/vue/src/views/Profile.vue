<template>
  <div class="profile">
    <user-profile />
    <activities />
    <bikes />
    <gear />
  </div>
</template>

<script>
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
    
  },
  //  props: [""],
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

<style>
.profile {
  display: flex;
  flex-direction: column;
  overflow: auto;
  align-items: center;
}
</style>
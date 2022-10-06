 <template>
  <div id="app">
    <div id="nav" v-if="isMobile">
      <router-link
        v-bind:to="{ name: 'home' }"
        style="text-decoration: none; color: inherit"
        ><h3>VELOcity</h3></router-link
      >&nbsp;|&nbsp;

      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        style="text-decoration: none; color: inherit"
        >Logout</router-link
      >
    </div>
    <router-view />
    <!-- <nav-menu /> -->
  </div>
</template>

<script>
import RouteService from "@/services/RouteServices.js";
import ActivitiesService from "@/services/ActivitiesService.js";
// import NavMenu from "../src/components/NavMenu.vue";
export default {
  name: "App",
  data() {
    return {
      isMobile: false,
      windowWidth: window.innerWidth,
    };
  },
  components: {},
  created() {
    this.getAllRoutes();
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
        //this.$store.state.commit("SET_IS_MOBILE");
      } else {
        this.isMobile = false;
      }
    },
    getAllActivities() {
      ActivitiesService.getActivities()
        .then((response) => {
          this.$store.commit("SET_ACTIVITIES", response.data);
        })
        .catch((error) => {
          if (error.response.status == 404) {
            this.$router.push({ name: "NotFound" });
          }
        });
    },
    getAllRoutes() {
      RouteService.getAllRoutes()
        .then((response) => {
          this.$store.commit("SET_ROUTES", response.data);
        })
        .catch((error) => {
          if (error.response.status == 404) {
            this.$router.push({ name: "NotFound" });
          }
        });
    },
  },
};
</script>
<style>
*::-webkit-scrollbar {
  width: 0.5em;
  height: 10px;
}
*::-webkit-scrollbar-thumb {
  background-color: none;
  border-radius: 5px;
}
@font-face {
  font-family: Inter-Light;
  src: url("../public/static/Inter-Light.ttf");
}
html {
  background-color: black;
  min-height: 100vh;
  overflow: hidden;
}
body {
  background-color: red;
  min-height: 100vh;
  overflow: hidden;
}

#nav {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
  background-color: #9bcea8;
  border: 1px solid lightgray;
  width: 100vw;
  height: 5vh;
}

/* @media only screen and (min-width: 700px) {
  #nav {
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    align-items: center;
    background-color: #9bcea8;
    border: 1px solid lightgray;
    width: 30vw;
    height: 100vh;
  }
} */
/* 
.control-bar {
  display: flex;
  flex-direction: row;
  justify-self: center;
  background-color: #9bcea8;
  border: 1px solid #9bcea8;
  padding: 18px;
  margin: 10px;
  border-radius: 10px;
  justify-content: space-between;
  position: fixed;
  left: 0;
  bottom: 0;
  width: 86vw;
  width: 86%;
} */

.btn {
  size: flex-grow;
  border-radius: 6px;
  padding: 10px;
}
router-link {
  padding: 20px;
}

#app {
  margin: none;
  font-family: Inter-Light, Arial, Helvetica, sans-serif;
  text-align: center;
  color: black;
  display: flex;
  flex-direction: column;
  background-image: url("../public/mapNY.png");
  background-color: darkgray;
  background-blend-mode: difference;
  background-repeat: no-repeat;
  background-size: 100% 100%;
  background-clip: border-box;
  height: 100vh;
  background-position: center 100%;
}
</style>


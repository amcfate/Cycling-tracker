 <template>
 
  <div id="app">
    <Map />
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }"><h3>cicleta</h3></router-link
      >&nbsp;|&nbsp;
    
      <router-link v-bind:to="{ name: 'maptesting' }">Map Test!</router-link>
        <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </div>
    <router-view />
    <!-- <div class="control-bar">
      <button class="btn">
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>
      </button>
      <button class="btn">
        <router-link v-bind:to="{ name: 'map' }">Map</router-link>
      </button>
    
      <button class="btn">
        <router-link v-bind:to="{ name: 'profile' }">Profile</router-link>
      </button>
    </div> -->
  </div>
</template>

<script>
export default {
  name: "App",
  components: {},
};
</script>
<style>
*::-webkit-scrollbar{
  width:.5em;
  height:10px;  
}
*::-webkit-scrollbar-thumb{
    background-color: darkgrey;
    border-radius: 5px;
  
}
@font-face {
  font-family: Inter-Light;
  src: url("../public/static/Inter-Light.ttf");
}
html{
  background-color: black;
  min-height: 100vh;
  overflow: hidden;
}
body{
  background-color: red;
  min-height: 100vh;
   overflow: hidden;
}

#nav {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
  background-color: whitesmoke;
  border: 1px solid lightgray;
  width: 100vw;
  height: 5vh;
}

.control-bar {
  display: flex;
  flex-direction: row;
  justify-self: center;
  background-color: whitesmoke;
  border: 1px solid lightgray;
  padding: 18px;
  margin: 10px;
  border-radius: 10px;
  justify-content: space-between;
  position: fixed;
  left: 0;
  bottom: 0;
  width: 86vw;
  /* width: 86%; */
}

.btn {
  size: flex-grow;
  border-radius: 6px;
  padding: 10px;
}
router-link{
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
  /* background-attachment: fixed; */
  
}
</style>


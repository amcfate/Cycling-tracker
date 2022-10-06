import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import 'vuejs-google-maps/dist/vuejs-google-maps.css'
import Map from "@/components/maps/Map";
Vue.config.productionTip = false

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;


new Vue({
  Map,
  router,
  store,
  render: h => h(App),
  beforeCreate() {
  }
}).$mount('#app')
//this.$store.commit('intialiseStore')

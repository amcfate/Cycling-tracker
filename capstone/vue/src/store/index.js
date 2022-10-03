import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    
    user: currentUser || {},
    routes: [
      {
        routeName: "steve",
        description: "",
        distance: 0,
        elevation: 0,
        ascent: 2,

      },
      {
        routeName: "block",
        description: "",
        distance: 40,
        elevation: 0,
        ascent: 4,

      },
      {
        routeName: "float",
        description: "",
        distance: 500,
        elevation: 0,
        ascent: 500,

      },
    ],
    activity: [
      {
        route_id: 0,
        user_id: 0,
        activity_name: "activity",
        activity_id: 1,
        is_public: true,
        photos: "xxxxx",
        description: "cool",
        activity_date: "today",
        start_time: "morn",
        end_time: "never",
      },
      {
        route_id: 0,
        user_id: 0,
        activity_name: "bike ride",
        activity_id: 1,
        is_public: true,
        photos: "xxxxx",
        description: "cool",
        activity_date: "today",
        start_time: "morn",
        end_time: "never",
      },
      {
        route_id: 0,
        user_id: 0,
        activity_name: "run",
        activity_id: 1,
        is_public: true,
        photos: "xxxxx",
        description: "cool",
        activity_date: "today",
        start_time: "morn",
        end_time: "never",
      },
    ],
    user_bikes: [
      {

      },
    ],
    user_gear: [
      {

      },
    ],
    user_profile: [
      // {
      //   user_id: 5,
      //   username: "markb",
      //   cycling_team: "",
      //   user_weight: "",
      //   userAge: 25
      // }
    ]
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_ROUTES(state, routes) {
      routes.forEach(route => {
        state.routes.unshift(route)
      });
      
    },
    SET_ACTIVITIES(state, activities) {
      state.activity = activities
    }
  }
})

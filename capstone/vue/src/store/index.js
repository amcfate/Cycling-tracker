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
<<<<<<< HEAD
        routeName: "Brooklyn Trail",
        description: "Lots of stopping, but beautiful ride with a view of the Hudson.",
        distance: 18,
        elevation: 82,
        ascent: 234,

      },
      {
        routeName: "Prospect Park",
        description: "Low-Demand ride through Prospect, Sean loves this ride!",
        distance: 12,
        elevation: 0,
=======
        routeName: "256 to parkway",
        description: "Lots of elevation gain, lots of elevation loss. Good views.",
        distance: 45,
        elevation: 3500,
        ascent: 5500,

      },
      {
        routeName: "around the block",
        description: "A cool down after work.",
        distance: 1,
        elevation: 350,
>>>>>>> main
        ascent: 4,

      },

    ],
    activity: [
      {
        route_id: 5,
        user_id: 0,
        activityName: "Morning ride",
        activityId: 1,
        is_public: true,
        photos: "xxxxx",
        description: "Rode down to outerlands for a cup of coffee, then stopped in the park to talk with an old man walking his cat.",
        activity_date: "today",
        startTime: "08:00:00",
        end_time: "09:00:00",
      },
      {
        route_id: 2,
        user_id: 0,
        activityName: "Parkway Ride",
        activityId: 37,
        is_public: true,
        photos: "xxxxx",
        description: "Got up above the clouds near Black balsam, then bombmed 151 into Brevard. Stopped for some fishing on the Davidson.",
        activity_date: "today",
        startTime: "morn",
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
      {
        userId: "",
        userName: "",
        cyclingTeam: "",
        userWeight: "",
        userAge: ""
      }
    ],
    trackpoint: [
      {

      }
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
    ADD_ROUTE(state, route) {
      state.routes.unshift(route)
    },
    ADD_GEAR(state, gear) {
      state.user_gear.unshift(gear);
    },
    NEW_BIKE(state, newBike) {
      state.user_gear.unshift(newBike);
    },
    ADD_ACTIVITY(state, newActivity) {
      state.activity.unshift(newActivity);
    },

    SET_ROUTES(state, routes) {
      routes.forEach(route => {
        let z = [state.routes.length]
        for (let i = 0; i < state.routes.length; i++) {
          z.push(state.routes[i].routeId)
        }
        if (!z.includes(route.routeId)) {
          state.routes.unshift(route)
        }

      });

    },
    SET_ACTIVITIES(state, activities) {
      activities.forEach(activity => {
        let z = [state.activity.length]
        for (let i = 0; i < state.activity.length; i++) {
          z.push(state.activity[i].activityId)
        }
        if (!z.includes(activity.activityId)) {
          state.activity.unshift(activity)
        }

      })
    },
    ADD_TRACKPOINT(state, trackpoint) {
      state.trackpoint.unshift(trackpoint)
    },
    UPDATE_PROFILE(state, updateInfo) {
      state.user_profile = updateInfo;
    }
  }
})

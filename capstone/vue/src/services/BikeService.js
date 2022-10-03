import axios from 'axios';

export default {

  getUserBikes() {
    return axios.get(`/bikes`);
  },

  // getBike(bikeName) {
  //   return axios.get('/bikes', bikeName)
  // },

  // postBike(bike) {
  //   return axios.post('/bikes', bike)
  // }

}

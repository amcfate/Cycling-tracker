import axios from 'axios';

export default {

  getBike(bikeName) {
    return axios.get('/bikes', bikeName)
  },

  postBike(bike) {
    return axios.post('/bikes', bike)
  }

}

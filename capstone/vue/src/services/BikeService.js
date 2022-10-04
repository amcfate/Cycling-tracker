import axios from 'axios';

export default {

  getUserBikes() {
    return axios.get(`/bikes`);
  },

  addNewBike(newBike) {
    return axios.post('/addBike', newBike);
  }

}

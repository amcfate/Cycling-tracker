import axios from 'axios';

export default {

  getAllRoutes() {
    return axios.get(`/getallroutes`);
},
getRouteById(id) {
  return axios.get(`/getroute/${id}`);
}

}

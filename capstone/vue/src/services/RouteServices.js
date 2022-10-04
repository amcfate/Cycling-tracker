import axios from 'axios';

/*const http = axios.create({
  baseURL: "http://localhost:9000"
});*/

export default {

  getAllRoutes() {
    return axios.get(`/getallroutes`);
  },
  getRouteById(id) {
    return axios.get(`/getroute/${id}`);
  },
  saveTrackPoints(trackpoint) {
    return axios.post("/savetrackpoint", trackpoint)
  },
  saveRoute(route) {
    return axios.post("/saveroute", route)
  }
}


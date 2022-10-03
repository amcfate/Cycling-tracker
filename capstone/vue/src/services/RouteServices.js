import axios from 'axios';

let http = axios.create({
    baseURL: "http://localhost:8080"
})

export default {

    getAllRoutes() {
        return http.get(`/getallroutes`);
    },
    getRouteById(id) {
        return http.get(`/getroute/${id}`);
    },
    saveTrackPoints(trackpoint){
        http.post("/savetrackpoint", trackpoint)
    },
    saveRoute(route) {
        http.post("/saveroute", route)
    }

}

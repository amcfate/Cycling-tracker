import axios from 'axios';


export default {
    getElevation(lat, lng){
        return axios.get(`https://maps.googleapis.com/maps/api/elevation/json?locations=${lat}%2C${lng}&key=AIzaSyDjB5lrCyoXaoU7Lv4RXi909TRAq5Wua9g`, {
            headers: 'Access-Control-Allow-Origin'
        });
    }
}
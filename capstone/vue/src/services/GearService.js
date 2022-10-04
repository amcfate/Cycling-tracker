import axios from "axios";

export default {
    getUserGear() {
        return axios.get('/gear');
    },

    addGear(newGear) {
        return axios.post('/addGear', newGear);
    }
}
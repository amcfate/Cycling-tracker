import axios from "axios";

export default {
    getUserGear() {
        return axios.get('/gear');
    }
}
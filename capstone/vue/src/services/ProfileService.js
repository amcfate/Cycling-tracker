import axios from "axios";

export default {
    getProfileDetails() {
        return axios.get(`/profile`);
    }

}
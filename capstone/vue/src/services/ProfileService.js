import axios from "axios";

export default {
    getProfileDetails() {
        return axios.get(`/profile`);
    },

    updateProfileDetails(updateInfo) {
        return axios.post('/updateProfile', updateInfo)
    }

}
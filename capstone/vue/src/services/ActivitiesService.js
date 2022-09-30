import axios from "axios";

export default {
    getActivities() {
        return axios.get(`/activity`);
    }
}
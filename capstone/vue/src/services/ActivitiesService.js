import axios from "axios";

export default {
    getActivities() {
        return axios.get(`/activity`);
    },

    addNewActivity(newActivity) {
        return axios.post(`/addActivity`, newActivity);
    }
}
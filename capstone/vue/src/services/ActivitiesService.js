import axios from "axios";

export default {

    getAllActivities() {
        return axios.get('/allActivities')
    },
    getActivities() {
        return axios.get(`/activity`);
    },
    addNewActivity(newActivity) {
        return axios.post(`/addActivity`, newActivity);
    }
}
import axios from "axios";

export default{
    getTotalMilesLeaderboard(){
        return axios.get('/leaderboardtotalmiles');
    }
}
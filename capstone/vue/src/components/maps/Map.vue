<template>
  <div class="wrapper">
   
    <!-- <h1 style="text-align: center">Google Maps</h1> -->

    <div class="nav-controls">
      <div class="button" v-on:click="calculateRoute()">
        Get Route
      </div>
      <div class="button" v-on:click="deleteMarkers()">Start Over</div>
      <div class="last-btn" v-on:click="saveRoute()">Save route</div>
    </div>
     <div id="map"></div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      startingLat: null,
      startingLong: null,
      map: null,
      directionsDisplay: null,
      service: null,
      markers: [],
      waypoints: [],
      locations: [],
      fromLocation: "",
      toLocation: "",
    };
  },
  methods: {
    /*
     * Initialize map
     * https://developers.google.com/maps/documentation/javascript/overview
     */
    initMap() {
      const mapElement = document.getElementById("map");
      const mapOptions = {
        center: {lat: 40.73061, lng:  -73.935242},
        zoom: 13,
        mapTypeId: window.google.maps.MapTypeId.ROADMAP,
        panControl: true,
        zoomControl: true,
          zoomControlOptions: {
      position: window.google.maps.ControlPosition.RIGHT_TOP,
    },
        mapTypeControl: true,
        scaleControl: true,
        streetViewControl: true,
        overviewMapControl: true,
        rotateControl: true,
      };

      if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
          let initialLocation = new window.google.maps.LatLng(position.coords.latitude, position.coords.longitude);
          mapOptions.center = initialLocation;
        });
      }

      //this.getLocation();
      this.map = new window.google.maps.Map(mapElement, mapOptions);
      window.google.maps.event.addListener(this.map, 'click', this.addPinViaClick);
    },
    /*
     * Add Marker
     */
    addPinViaClick(event) {
      let description = window.prompt("Name marker:");
      if(description.length === 0){
        window.alert("Please enter a description.")
        return;
      }

      let markLatLng = new window.google.maps.LatLng(event.latLng.toJSON())
      this.waypoints.push(markLatLng)

      const markerObj = this.makeMarkerObj(event.latLng.toJSON(), description);
      this.locations.push(markerObj);
      this.dropPin(markerObj);
    },

    dropPin(markerObj) {
      let marker = new window.google.maps.Marker({
        position: markerObj.loc,
        animation: window.google.maps.Animation.DROP,
        map: this.map,
        label: {
          text: markerObj.name,
          color: "blue",
        },
      });

      this.markers.unshift(marker)
    },

    makeMarkerObj(latLng, name) {
      const markerObj =  {loc: latLng, name: name};
      return markerObj;
    },

    /*
     * Calculate route between 2 Coordinates
     * https://stackoverflow.com/questions/27341214/how-to-draw-a-route-between-two-markers-in-google-maps
     * input start: { lat: 32.7341, lng: -117.1446 }
     * input end: { lat: 32.7075, lng: -117.1575 }
     */
    calculateRoute() {
      let waypnts = []
      let orgn = this.waypoints[0];
      if(this.waypoints.length > 2) {
        for (let i = 1; i < this.waypoints.length - 1; i++) {
          waypnts.push({location: this.waypoints[i], stopover:true});
        }
      }

      const request = {
        origin: orgn,
        waypoints: waypnts,
        destination: this.waypoints[(this.waypoints.length - 1)],
        // https://developers.google.com/maps/documentation/transportation-logistics/on-demand-rides-deliveries-solution/pickup-and-dropoff-selection/location-selection/reference/rest/v1beta/TravelMode
        travelMode: window.google.maps.TravelMode.TWO_WHEELER
      };
      this.directionsDisplay.setMap(this.map);
      this.service.route(request, (response, status) => {
        if (status === window.google.maps.DirectionsStatus.OK) {
          this.directionsDisplay.setDirections(response);
          this.directionsDisplay.setMap(this.map);
        }
      });
      this.hideMarkers();
      this.markers = []
    },
    clearRoutes() {
      this.hideMarkers();
      this.directionsDisplay.setMap(null);
    },

    setMapOnAll(map) {
      for (let i = 0; i < this.markers.length; i++) {
        this.markers[i].setMap(map);
      }
    },

    hideMarkers() {
      this.setMapOnAll(null)
    },

    showMarkers() {
      this.setMapOnAll(this.map)
    },

    deleteMarkers() {
      this.locations = []
      this.markers = []
    },

    saveRoute(){
      for(let i = 0; i < this.locations.length; i++){
        axios.post('/saveRoute', {
          lat: this.locations[i].loc.lat,
          lng: this.locations[i].loc.lng
        })
      }


    }

  },

  mounted() {
    // Initialize map after DOM is mounted
    this.initMap();
    this.directionsDisplay = new window.google.maps.DirectionsRenderer();
    this.service = new window.google.maps.DirectionsService();
  },
};

</script>

<style scoped>
.wrapper{
  display: flex;
  position:relative;
  height: 100vh;
  width: 100vw;
}

#map {
  grid-area: map;
  width: 100%;
  height: 100%;
  /* position: absolute; */
  

}

.nav-controls{
  
  font-weight: bold;
  display: flex;
  background-color: #fff;
  z-index: 1;
  width:200px;
  align-self: start;
  border-radius: 3px;
  margin-top: 65px;
  margin-left: 10px;
  margin-right: 0%;
  position: absolute;
 
}



.button{
  padding: 5px;
  border-right-style: solid;
  border-width: 2px;
  border-color:  rgb(240, 240, 240);
  border-top-right-radius: 0px;
  border-bottom-right-radius: 0px;
}

.last-btn{
  border: none;
  padding: 5px;
  border-top-right-radius: 2px;
  border-bottom-right-radius: 2px;
}
.nav {
  text-align: center;
  position: absolute;
  z-index: 5;
}
</style>
<template>
  <div class="wrapper">

    <div class="nav-controls">
      <div class="button" v-on:click="calculateRoute(); showRouteForm = !showRouteForm">Get Route</div>
      <div class="button" v-on:click="deleteMarkers()">Start Over</div>
      <div class="last-btn" v-on:click="saveRoute()">Save route</div>
    </div>
    <div id="map"></div>
    <new-route-form  class="route-form" v-show=" !showRouteForm"/>
  </div>
</template>

<script>
import routeServices from "../../services/RouteServices";
import newRouteForm from "../forms/NewRouteForm.vue"
export default {
  data() {
    return {
      showRouteForm: true,
      callbackObj: {
        routeName: "",
        description: "",
        distanceMiles: "",
        elevation: "",
        ascent: "",
      },
      elevator: null,
      routeDescription: null,
      routeName: null,
      duration: null,
      distance: null,
      elevations: null,
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
  components:{
    newRouteForm,
  },
  methods: {
    /*
     * Initialize map
     * https://developers.google.com/maps/documentation/javascript/overview
     */
    initMap() {
      const mapElement = document.getElementById("map");
      const mapOptions = {
        center: {lat: 40.73061, lng: -73.935242},
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
          mapOptions.center = new window.google.maps.LatLng(position.coords.latitude, position.coords.longitude);
        });
      }

      //this.getLocation();zex3ase3Z@ws

      this.map = new window.google.maps.Map(mapElement, mapOptions);
      this.elevator = new window.google.maps.ElevationService();
      window.google.maps.event.addListener(this.map, 'click', this.addPinViaClick);
    },
    /*
     * Add Marker
     */
    addPinViaClick(event) {
      //Accept input on click for marker name
      let description = window.prompt("Name marker:");
      if (description.length === 0) {
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
      //Instantiate new marker and drop it on location of markerObj
      let marker = new window.google.maps.Marker({
        position: markerObj.loc,
        animation: window.google.maps.Animation.DROP,
        map: this.map,
        label: {
          text: markerObj.name,
          color: "blue",
        },
      });

      this.markers.push(marker)
    },

    makeMarkerObj(latLng, name) {
      return {loc: latLng, name: name};
    },

    makeTrackPointObj(markObj, marker) {
      let obj = {
        lat: markObj.loc.lat,
        lng: markObj.loc.lng,
        elevation: this.requestElevations(marker)
      }
      return obj;
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
      let des = this.waypoints[(this.waypoints.length - 1)]
      if (this.waypoints.length > 2) {
        for (let i = 1; i < this.waypoints.length - 1; i++) {
          waypnts.push({location: this.waypoints[i], stopover: false});
        }
      }

      const request = {
        origin: orgn,
        waypoints: waypnts,
        destination: des,
        travelMode: window.google.maps.TravelMode.TWO_WHEELER
      };
      this.directionsDisplay.setMap(this.map);
      this.service.route(request, (response, status) => {
        if (status === window.google.maps.DirectionsStatus.OK) {
          this.directionsDisplay.setDirections(response);
          this.directionsDisplay.setMap(this.map);

          this.computeTotalDistance(response)
        }
      });
      this.hideMarkers();
    },


    deleteMarkers() {
      location.reload()
    },

    saveRoute() {
      this.routeName = window.prompt("Name this route");
      //Check for null and recall if null
      if (this.routeName === null) {
        window.alert("Please enter a name")
        this.saveRoute();
      }
      this.routeDescription = window.prompt("Give this route a description");
      if (this.routeDescription === null) {
        window.alert("Please enter a description");
        this.saveRoute();
      }
      window.alert("Distance = " + this.distance);

      //Package into JSON for callback
      this.callbackObj = {
        routeName: this.routeName,
        description: this.routeDescription,
        distanceMiles: this.distance,
        elevation: 1337,
        ascent: 345
      }
      //Commit to store, call API
      routeServices.saveRoute(this.callbackObj).then((response) => {
        if (response.status === 200 || response.status === 201) {
          this.$store.commit("ADD_ROUTE", this.callbackObj)
        }
      });
      //Reset obj
      this.callbackObj = {}

      //Save trackpoints after route save
      this.saveTrackPoints()

      window.alert("Saved!")
      location.reload();
    },


    saveTrackPoints() {
      //Loop through locations
      for (let i = 0; i < this.locations.length; i++) {
        let trackPoint = this.makeTrackPointObj(this.locations[i], this.markers[i]);

        //Save trackpoint
        routeServices.saveTrackPoints(trackPoint).then((response) => {
          if (response.status === 201 || response.status === 200) {
            this.$store.commit("ADD_TRACKPOINT", trackPoint)
          }
          else{
            window.alert("ERROR SAVING TRACKPOINTS")
          }
        });
      }
      this.locations = [];

    },
    computeTotalDistance(result) {
      let totalDist = 0;
      let totalTime = 0;
      let myRoute = result.routes[0];
      for (let i = 0; i < myRoute.legs.length; i++) {
        totalDist += myRoute.legs[i].distance.value;
        totalTime += myRoute.legs[i].duration.value;
      }
      totalDist = totalDist / 1000;
      this.distance = totalDist * .62137
      this.duration = totalTime

    },
    requestElevations(marker) {
      let location = marker.getPosition();
      this.elevator.getElevationForLocations(location, (results, status) => {
        if(status === window.google.maps.ElevationStatus.OK) {
          if(results[0]) {
            return parseFloat(results[0].elevation.toFixed(1))
          }
        }
      })
      
    }
  },
mounted()
{
  // Initialize map after DOM is mounted
  this.initMap();
  this.directionsDisplay = new window.google.maps.DirectionsRenderer();
  this.service = new window.google.maps.DirectionsService();
}
,
}
;

</script>

<style scoped>
.wrapper {
  display: flex;
  position: relative;
  height: 100vh;
  width: 100vw;
}

#map {
  grid-area: map;
  width: 100%;
  height: 100%;
  /* position: absolute; */


}

.nav-controls {
  font-weight: bold;
  display: flex;
  background-color: #fff;
  z-index: 1;
  width: 200px;
  align-self: start;
  border-radius: 3px;
  margin-top: 65px;
  margin-left: 10px;
  margin-right: 0%;
  position: absolute;

}


.button {
  display: block;
  padding: 5px;
  border-right-style: solid;
  border-width: 2px;
  border-color: rgb(240, 240, 240);
  border-top-right-radius: 0px;
  border-bottom-right-radius: 0px;
}

.last-btn {
  display: block;
  border: none;
  padding: 5px;
  border-top-right-radius: 2px;
  border-bottom-right-radius: 2px;
}

.nav-controls {

  font-weight: bold;
  display: flex;
  background-color: #fff;
  z-index: 1;
  width: 200px;
  align-self: start;
  border-radius: 3px;
  margin-top: 65px;
  margin-left: 10px;
  margin-right: 0%;
  position: absolute;

}


.button {
  padding: 5px;
  border-right-style: solid;
  border-width: 2px;
  border-color: rgb(240, 240, 240);
  border-top-right-radius: 0px;
  border-bottom-right-radius: 0px;
}

.last-btn {
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
.route-form{
  position: absolute;
  top: 150px;
  left: 10px;
  z-index: 5;
  min-height: 30%;
  min-width: 30%;
}
</style>

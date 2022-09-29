<template>
  <div>
    <h1 style="text-align: center">Google Maps</h1>

    <nav className="nav">
      <select name="" id="" v-model="fromLocation">
        <option value="">--from--</option>
        <option
            v-for="(eachLocation, index) in locations"
            v-bind:key="index"
            v-bind:value="eachLocation.loc"
        >
          {{ eachLocation.name }}
        </option>
      </select>

      <select name="" id="" v-model="toLocation">
        <option value="">--to--</option>
        <option
            v-for="(eachLocation, index) in locations"
            v-bind:key="index"
            v-bind:value="eachLocation.loc"
        >
          {{ eachLocation.name }}
        </option>
      </select>

      <button v-on:click="calculateRoute(fromLocation, toLocation)">
        Get Route!
      </button>

      <button v-on:click="clearRoutes()">Clear route and hide markers!</button>
      <button v-on:click="deleteMarkers()">Delete all markers!</button>
    </nav>

    <div id="map"></div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      map: null,
      directionsDisplay: null,
      service: null,
      markers: [],
      locations: [
        {name: "balboaPark", loc: {lat: 32.7341, lng: -117.1446}},
        {name: "petcoPark", loc: {lat: 32.7075, lng: -117.1575}},
        {name: "sanDiegoAirport", loc: {lat: 32.7323, lng: -117.196}},
      ],
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
        center: this.locations[0].loc,
        zoom: 13,
        mapTypeId: window.google.maps.MapTypeId.ROADMAP,
        panControl: true,
        zoomControl: true,
        mapTypeControl: true,
        scaleControl: true,
        streetViewControl: true,
        overviewMapControl: true,
        rotateControl: true,
      };
      this.map = new window.google.maps.Map(mapElement, mapOptions);
      window.google.maps.event.addListener(this.map, 'click', this.addPinViaClick);
      this.getLocation()
    },

    //Get user location
    getLocation() {
      if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
          let initialLocation = new this.map.LatLng(position.coords.latitude, position.coords.longitude);
          this.map.setCenter(initialLocation);
        });
      }

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
      const markerObj = this.makeMarkerObj(event.latLng.toJSON(), description);
      this.locations.push(markerObj);
      this.dropPin(markerObj);
    },

    dropPin(markerObj) {
      if (this.markers.length === 2) {
        this.markers.slice(2)
      }
      let marker = new window.google.maps.Marker({
        position: markerObj.loc,
        map: this.map,
        label: {
          text: markerObj.name,
          color: "blue",
        },
      });
      this.markers.unshift(marker)
    },

    makeMarkerObj(latLng, name) {
      const markerObj = {loc: latLng, name: name};
      return markerObj;
    },

    /*
     * Calculate route between 2 Coordinates
     * https://stackoverflow.com/questions/27341214/how-to-draw-a-route-between-two-markers-in-google-maps
     * input start: { lat: 32.7341, lng: -117.1446 }
     * input end: { lat: 32.7075, lng: -117.1575 }
     */
    calculateRoute(start, end) {
      const request = {
        origin: start,
        destination: end,
        // https://developers.google.com/maps/documentation/transportation-logistics/on-demand-rides-deliveries-solution/pickup-and-dropoff-selection/location-selection/reference/rest/v1beta/TravelMode
        travelMode: window.google.maps.TravelMode.TWO_WHEELER
      };
      this.directionsDisplay.setMap(this.map);
      this.service.route(request, (response, status) => {
        if (status == window.google.maps.DirectionsStatus.OK) {
          this.directionsDisplay.setDirections(response);
          this.directionsDisplay.setMap(this.map);
        }
      });
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
      this.hideMarkers();
      this.markers = []
      this.locations = []
    },

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
#map {
  grid-area: map;
  width: 500px;
  height: 400px;
  padding: 25px;
  margin: 25px auto;
}

.nav {
  text-align: center;
}
</style>
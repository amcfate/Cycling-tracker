<template>
  <div class="main">
   
    <div id="map"></div>

    <h1 style="text-align: center">Google Maps</h1>

    <nav class="nav">
      <button v-on:click="calculatePoints()">
        Get Route!
      </button>

      <button v-on:click="savePins()">Save markers!</button>

      <button v-on:click="clearRoutes()">Clear!</button>
    </nav>

    
  </div>
</template>

<script>
export default {
  data() {
    return {
      map: null,
      directionsDisplay: null,
      service: null,
      path: null,
      poly: null,
      lat_ling: [],
      locations: [
        { name: "user", loc: { lat: 32.7341, lng: -117.1446 } },
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

      window.google.maps.event.addListener(this.map, 'click' , (e) => {
        this.addPinViaClick(e)
      })

    },
    /*
     * Add Marker
     */
    addPinViaClick(event) {
      let description = window.prompt("Enter a description");
      const markerObj = this.makeMarkerObj(event.latLng.toJSON(), description);
      this.locations.push(markerObj);
      this.dropPin(markerObj);
    },

    dropPin(markerObj) {
      new window.google.maps.Marker({
        position: markerObj.coord,
        map: this.map,
        label: {
          text: markerObj.name,
          color: "blue",
        },
      });
    },


    makeMarkerObj(latLng, name) {
      const markerObj = { coord: latLng, name: name };
      return markerObj;
    },


    calculatePoints(){
      this.locations.forEach(pos => {
        let myLatLng = new window.google.maps.LatLng(pos.lat, pos.lng);
        this.lat_ling.push(myLatLng)
      })
      for(let i = 0; i < this.lat_ling.length; i++){
        if((i + 1) < this.lat_ling.length){
          let src = this.lat_ling[i];
          let des = this.lat_ling[i + 1];
          this.path.push(src)
          this.poly.setPath(this.path)
          this.service.route ({
            origin: src,
            destination: des,
            travelMode: window.google.maps.TravelMode.TWO_WHEELER
          })
          }
        }
      }
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
        travelMode: window.google.maps.TravelMode.TWO_WHEELER,
      };
      this.directionsDisplay.setMap(this.map);
      this.service.route(request, (response, status) => {
        if (status == window.google.maps.DirectionsStatus.OK) {
          this.directionsDisplay.setDirections(response);
          this.directionsDisplay.setMap(this.map);
        } else {
          alert(
              "Directions Request from " +
              start.toUrlValue(6) +
              " to " +
              end.toUrlValue(6) +
              " failed: " +
              status
          );
        }
      });
    },
    clearRoutes() {
      this.directionsDisplay.setMap(null);
      this.map.markers = null;
    },
    savePins(){
      alert("This feature has not been created yet!")
    },
  mounted() {
    // Initialize map after DOM is mounted
    this.initMap();
    this.directionsDisplay = new window.google.maps.DirectionsRenderer();
    this.service = new window.google.maps.DirectionsService();
    this.path = new window.google.maps.MVCArray();
    this.poly = new window.google.maps.Polyline({ map: this.map, strokeColor: '#46986E7'});
  },
};
</script>

<style scoped>
.main{
  display: flex;
}
.text-center{

  display: flex;
  flex-direction: column;
  align-content: space-evenly;
  height: 100%;
  margin-bottom: 5%;
  padding-left:5%;
  padding-right:5%;
}

.nav{
  height: 25%;
  margin-bottom: 10px; 
  position: absolute;
  z-index: 5;
}

#map {
  grid-area: map;
  width: 100vw;
  height: 100vh;
  position: absolute;
  

}
.nav {
  justify-self: center;
  text-align: center;
  position: absolute;
}
</style>
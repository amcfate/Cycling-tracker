<template>
  <div>
    <div class="google-map"
         ref="googleMap">
    </div>
    <Template>
      <slot
          :google="google"
          :map="map"/>
    </Template>
  </div>
</template>

<script>
import GoogleMapsApiLoader from 'google-maps-api-loader'
export default {
  props: {
    mapConfig: Object
  },
  data() {
    return {
      google: null,
      map: null
    };
  },
  async mounted() {
    const googleMapApi = await GoogleMapsApiLoader ({
      libraries: ['geometry'],
      apiKey: process.env.VUE_APP_MAPS_KEY
    });
    this.google = googleMapApi
    this.intializeMap();
  },
  methods: {
    intializeMap(){
      const mapContainer = this.$refs.googleMap;
      this.map = new this.google.maps.Map(mapContainer, this.mapConfig)
    }
  }
}
</script>

<style scoped>
.google-map {
  width: 100%;
  min-height : 100%;
}

</style>
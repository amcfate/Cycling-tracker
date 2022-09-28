<script>
/* eslint-disable no-undef */
import { computed, ref, onMounted, onUnmounted, watch } from 'vue'
import { useGeolocation } from './useGeolocation'
import { Loader } from '@googlemaps/js-api-loader'

const GOOGLE_MAPS_API_KEY = ' AIzaSyDjB5lrCyoXaoU7Lv4RXi909TRAq5Wua9g'

export default {
  name: 'Map',
  setup() {
    const { coords } = useGeolocation()
    const currPos = computed(() => ({
      lat: coords.value.latitude,
      lng: coords.value.longitude
    }))
    const otherPos = ref(null)

    const loader = new Loader({ apiKey: GOOGLE_MAPS_API_KEY })
    const mapDiv = ref(null)
    let map = ref(null)
    let clickListener = null
    onMounted(async () => {
      await loader.load()
      map.value = new google.maps.Map(mapDiv.value, {
        center: currPos.value,
        zoom: 15
      })
      clickListener = map.value.addListener(
          'click',
          ({ latLng: { lat, lng } }) =>
              (otherPos.value = { lat: lat(), lng: lng() })
      )
    })
    onUnmounted(async () => {
      if (clickListener) clickListener.remove()
    })

    let line = null
    watch([map, currPos, otherPos], () => {
      if (line) line.setMap(null)
      if (map.value && otherPos.value != null)
        line = new google.maps.Polyline({
          path: [currPos.value, otherPos.value],
          map: map.value
        })
    })

    const haversineDistance = (pos1, pos2) => {
      const R = 3958.8 // Radius of the Earth in miles
      const rlat1 = pos1.lat * (Math.PI / 180) // Convert degrees to radians
      const rlat2 = pos2.lat * (Math.PI / 180) // Convert degrees to radians
      const difflat = rlat2 - rlat1 // Radian difference (latitudes)
      const difflon = (pos2.lng - pos1.lng) * (Math.PI / 180) // Radian difference (longitudes)

      const d =
          2 *
          R *
          Math.asin(
              Math.sqrt(
                  Math.sin(difflat / 2) * Math.sin(difflat / 2) +
                  Math.cos(rlat1) *
                  Math.cos(rlat2) *
                  Math.sin(difflon / 2) *
                  Math.sin(difflon / 2)
              )
          )
      return d
    }
    const distance = computed(() =>
        otherPos.value === null
            ? 0
            : haversineDistance(currPos.value, otherPos.value)
    )
    return { currPos, otherPos, distance, mapDiv }
  }
}
</script>

<style scoped>
.text-center{

  display: flex;
  flex-direction: column;
  align-content: space-evenly;
  height: 100%;
  margin-bottom: 5%;
  padding-left:5%;
  padding-right:5%;
}

.mapDiv{
  height: 25%;
  margin-bottom: 10px; 
}
.position{
display: flex;
justify-content: space-between;
margin-bottom: 8px;
}
.position-header{
  margin: 0px;
}
.miles{
  display: flex;
  justify-content: space-between;
  margin-bottom: 8px;
}
.miles-header{
  margin: 0px;
}
.clicked-position{
  display: flex;
  justify-content: space-between;
  margin-bottom: 8px;
}
.clicked-header{
  margin: 0px
}

</style>

<template>
  <div class="d-flex text-center" >
    <div class="m-auto position">
      <h4 class="position-header">You:</h4>
      Y: {{ currPos.lat.toFixed(2) }}, X:
      {{ currPos.lng.toFixed(2) }}
    </div>
    <div class="m-auto miles">
      <h4 class="miles-header">Distance</h4>
      {{ distance.toFixed(2) }} miles
    </div>
    <div class="m-auto clicked-position">
      <h4 class="clicked-header">Destination</h4>
      <span v-if="otherPos">
          Y: {{ otherPos.lat.toFixed(2) }}, X:
          {{ otherPos.lng.toFixed(2) }}
        </span>
      <span v-else>Click the map</span>
      
    </div>
    <div ref="mapDiv" class="mapDiv"/>
  </div>

</template>

<template>
  <v-dialog
    v-model="showLoader"
    persistent
    width="300"
  >
    <v-card dark>
      <v-card-text>
        {{ loaderMessage }}
        <v-progress-linear
          indeterminate
          color="white"
          class="mb-0"
        ></v-progress-linear>
      </v-card-text>
    </v-card>
  </v-dialog>
</template>

<script>
import { mapState } from 'vuex'
export default {
  data () {
    return { }
  },
  computed: mapState([
    'showLoader', 'loaderMessage'
  ])
}
</script>

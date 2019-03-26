<template>
  <v-snackbar 
    v-model="show"
    :timeout=0
    :right="true"
    :top="true"
    :vertical="true"
  >
    {{ message }}
    <v-btn flat color="accent" @click="closeSnackbar">Fechar</v-btn>
  </v-snackbar>
</template>

<script>
import { mapState, mapMutations } from 'vuex'
export default {
  data () {
    return { }
  },
  computed: mapState([
    'show', 'message'
  ]),
  methods: {
    ...mapMutations([
      'CLOSE_SNACKBAR'
    ]),
    closeSnackbar: function() {
      this.CLOSE_SNACKBAR()
    }
  }
}
</script>
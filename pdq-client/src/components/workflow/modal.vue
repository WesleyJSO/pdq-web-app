<template>
  <v-layout row justify-center>
    <v-dialog v-model="dialog" persistent max-width="50%">
      <v-card>
        <v-card-title class="headline">Porcentagens para o status.</v-card-title>
        <v-card-text>
          <v-layout v-for="color in orderColors" :key="color.id">
            <v-flex md1>
              <v-btn icon :color="color.orderColor" class="white--text">
                {{ color.colorPercentage }}%
              </v-btn>
            </v-flex>
            <v-flex md11>
              <v-slider v-model="color.colorPercentage"></v-slider>
            </v-flex>
          </v-layout>
          <p class="ma-0">* As porcentagens escolhidas definem o ponto no qual o pedido deverá acatar para necessitar da aprovação.</p>
          <p class="ma-0">Ex: Caso o vermelho esteja em 20% o status será necessário caso o 20% ou mais do valor do pedido corresponsa a esta cor.</p>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="green darken-1" flat @click="sendParentConfirmation">Salvar</v-btn>
          <v-btn color="green darken-1" flat @click="sendParentConfirmation">Cancelar</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-layout>
</template>

<script>
  export default {
    props: {
      dialog: {
        type: Boolean,
        default: false
      }
    },
    data () {
      return {
        orderColors: [
          {
            id: 1,
            orderColor: 'light-blue darken-4',
            colorPercentage: 0
          },
          {
            id: 2,
            orderColor: 'green',
            colorPercentage: 0
          },
          {
            id: 3,
            orderColor: 'amber accent-3',
            colorPercentage: 0
          },
          {
            id: 4,
            orderColor: 'red',
            colorPercentage: 0
          },
          {
            id: 5,
            orderColor: 'black',
            colorPercentage: 0
          }
        ]
      }
    },
    methods: {
      sendParentConfirmation () {
        this.$emit('closeDialog', true)
      }
    }
  }
</script>
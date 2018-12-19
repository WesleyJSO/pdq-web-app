<template>
  <v-container fluid grid-list-md>
    <v-layout row wrap>

      <!-- Detalhes do pedido -->
      <v-flex d-flex xs12 sm12 md9 lg9 xl9>
      <v-hover>
          <v-card
            slot-scope="{ hover }"
            :class="`elevation-${hover ? 12 : 2}`"
            class="mx-auto" dark
          >
        <v-card-title class="deep-orange title text--white">Detalhes do Pedido</v-card-title>
        <v-card-text><OrderDetails /></v-card-text>
          </v-card>
        </v-hover>
      </v-flex>
      
      <!-- Timeline -->
      <v-flex d-flex xs12 sm12 md3 lg3 xl3>
        <v-hover>
          <v-card
            slot-scope="{ hover }"
            :class="`elevation-${hover ? 12 : 2}`"
            class="mx-auto" dark
          >
            <v-card-title class="deep-orange title text--white">Histórico de Status</v-card-title>
            <v-card-text><OrderTimeline /></v-card-text>
          </v-card>
        </v-hover>
      </v-flex>
      
    </v-layout>

    <v-layout row wrap>

      <v-flex d-flex xs12 order-xs5>
        <v-layout column>

          <v-flex d-flex>

            <v-hover>
              <v-hover>
                <v-card 
                  slot-scope="{ hover }"
                  :class="`elevation-${hover ? 12 : 2}`"
                  class="mx-auto"
                >
                  <v-card-text>{{ lorem }}</v-card-text>
                </v-card>
              </v-hover>
            </v-hover>
          </v-flex>

          <v-flex d-flex>
            <v-hover>
              <v-card 
                slot-scope="{ hover }"
                :class="`elevation-${hover ? 12 : 2}`"
                class="mx-auto"
              >
                <v-card-text>{{ lorem }}</v-card-text>
              </v-card>
            </v-hover>
          </v-flex>

        </v-layout>
      </v-flex>
      <v-flex d-flex xs12 sm7>
        <v-layout row wrap>

          <v-flex d-flex>
            <v-hover>
              <v-card 
                slot-scope="{ hover }"
                :class="`elevation-${hover ? 12 : 2}`"
                class="mx-auto"
              >
                <v-card-text>{{ lorem.slice(0, 70) }}</v-card-text>
              </v-card>
            </v-hover>
          </v-flex>

          <v-flex d-flex>
            <v-layout row>
              <v-flex v-for="n in 3" :key="n" d-flex >
                <v-hover>
                  <v-card 
                    slot-scope="{ hover }"
                    :class="`elevation-${hover ? 12 : 2}`"
                    class="mx-auto"
                  >
                    <v-card-text>{{ lorem.slice(0, 100) }}</v-card-text>
                  </v-card>
                </v-hover>
              </v-flex>
            </v-layout>
          </v-flex>

        </v-layout>
      </v-flex>

      <v-flex d-flex xs12 sm2 child-flex>
        <v-hover>
          <v-card 
            slot-scope="{ hover }"
            :class="`elevation-${hover ? 12 : 2}`"
            class="mx-auto"
          >
            <v-card-text>{{ lorem.slice(0, 90) }}</v-card-text>
          </v-card>
        </v-hover>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
import OrderTimeline from './OrderTimeline'
import OrderDetails from './OrderDetails'
  export default {
    components: {
      OrderTimeline,
      OrderDetails
    },
    data: () => ({
      lorem: `Lorem ipsum dolor sit amet, mel at clita quando. Te sit oratio vituperatoribus, nam ad ipsum posidonium mediocritatem, explicari dissentiunt cu mea. Repudiare disputationi vim in, mollis iriure nec cu, alienum argumentum ius ad. Pri eu justo aeque torquatos.`
    })
  }
</script>
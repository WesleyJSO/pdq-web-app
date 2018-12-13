<template>
  <v-app id="inspire">
    <v-navigation-drawer
      :clipped="$vuetify.breakpoint.lgAndUp"
      v-model="drawer" fixed app
    >
      <v-list dense>

      </v-list>
    </v-navigation-drawer>
    <v-toolbar
      :clipped-left="$vuetify.breakpoint.lgAndUp"
      color="blue darken-3"
      dark app fixed
    >
      <v-toolbar-title style="width: 300px" class="ml-0 pl-3">
        <v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>
        <span class="hidden-sm-and-down">ProduQuimica</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn icon large>
        <v-avatar
          size="45px" 
          color="grey lighten-4"
        >
          <img
            src="./assets/pdq_logo.jpg"
            alt="ProduQuimica"
          >
        </v-avatar>
      </v-btn>
    </v-toolbar>
    <v-content> 
      <GridContainer />
      <v-container>
          <v-layout wrap>
            <v-flex md12>
            
            </v-flex>
          </v-layout>
      </v-container>

      <v-container grid-list-xl text-md-center>
          <v-layout wrap>
            <v-flex md4>
              <v-hover>
                  <v-card 
                    slot-scope="{ hover }"
                    :class="`elevation-${hover ? 12 : 2}`"
                    class="mx-auto"
                  >
                  <v-card-title primary-title>
                      <h3 class="headline mb-0">Detalhes do pedido</h3>
                  </v-card-title>
                  <v-card-text>                      
                    <p class="text-md-left">Cliente:</p>
                    <p class="text-md-left">Número:</p>
                    <p class="text-md-left">Status:</p>
                    <p class="text-md-left">Regional:</p>
                    <p class="text-md-left">Tabela de preço:</p>
                    <p class="text-md-left">Data de criação:</p>
                    <p class="text-md-left">Tipo de venda:</p>
                    <p class="text-md-left">Pedido foi gerado há {{daysPastCreation}} dias.</p>
                  </v-card-text>
                </v-card>
              </v-hover>
            </v-flex>

            <v-flex md8>
              <v-hover>
                <v-card
                  slot-scope="{ hover }"
                  :class="`elevation-${hover ? 12 : 2}`"
                  class="mx-auto"
                >
                  <v-card-title primary-title>
                      <h3 class="headline mb-0">Totais</h3>
                  </v-card-title>

                  <v-card-text>
                    <v-container fluid>
                      <v-layout wrap elevation-2 mb-3>
                        <v-flex md4><p class="text-md-left">Quantidade:</p></v-flex>
                        <v-flex md4><p class="text-md-left">Preço bruto:</p></v-flex>
                        <v-flex md4><p class="text-md-left">Frete:</p></v-flex>
                      </v-layout>

                      <v-layout wrap elevation-2 mt-3 mb-3>
                          <v-flex md4><p class="text-md-left">Preço à vista:</p></v-flex>
                          <v-flex md4><p class="text-md-left">Custo:</p></v-flex>
                          <v-flex md4><p class="text-md-left">MB valor a vista:</p></v-flex>
                      </v-layout>

                      <v-layout wrap elevation-2 mt-3 mb-3>
                          <v-flex md3><p class="text-md-left">MB valor à prazo:</p></v-flex>
                          <v-flex md3><p class="text-md-left">Lucro:</p></v-flex>
                          <v-flex md3><p class="text-md-left">Faturamento:</p></v-flex>
                          <v-flex md3><p class="text-md-left">Comissão:</p></v-flex>
                      </v-layout>
                    </v-container>
                  </v-card-text>
                </v-card>
              </v-hover>
            </v-flex>
            
            <v-flex md12>
              <v-hover>
                <v-card
                  slot-scope="{ hover }"
                  :class="`elevation-${hover ? 12 : 2}`"
                  class="mx-auto"
                >
                  <v-card-title primary-title>
                    <h3 class="headline mb-0">a</h3>
                  </v-card-title>
                  <v-card-text>                      
                    <p class="text-md-left">Cliente:</p>
                    <p class="text-md-left">Número:</p>
                    <p class="text-md-left">Status:</p>
                    <p class="text-md-left">Regional:</p>
                    <p class="text-md-left">Tabela de preço:</p>
                    <p class="text-md-left">Data de criação:</p>
                    <p class="text-md-left">Tipo de venda:</p>
                  </v-card-text>
                </v-card>
              </v-hover>
            </v-flex>
            
          </v-layout>
      </v-container>

    </v-content>
  </v-app>
</template>

<script>
import GridContainer from './components/GridContainer'
export default {
  components: {
    GridContainer
  },
  data: () => ({
    daysPastCreation: 0,
    show4: false,
    drawer: null,
  })
}
</script>

<style>
table {
	white-space: nowrap;
}
.v-table__overflow {
	height: 350px;
	overflow-y: auto;
}
</style>
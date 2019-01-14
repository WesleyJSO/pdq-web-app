<template>
  <v-app id="inspire">
    <v-navigation-drawer
      :clipped="$vuetify.breakpoint.lgAndUp"
      v-model="drawer" fixed app
    >
      <v-list dense>

        <v-list-tile>
          <v-list-tile-action>
            <v-icon></v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <router-link to="consultarpedido">
              <v-list-tile-title>Consultar Pedidos</v-list-tile-title>
            </router-link>
          </v-list-tile-content>
        </v-list-tile>

        <v-list-tile>
          <v-list-tile-action>
            <v-icon></v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <router-link to="aprovarpedido">
              <v-list-tile-title>Aprovação de Pedido</v-list-tile-title>
            </router-link>
          </v-list-tile-content>
        </v-list-tile>

        <v-list-tile>
          <v-list-tile-action>
            <v-icon></v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <router-link to="fluxoaprovacao">
              <v-list-tile-title>Fluxo de Aprovação</v-list-tile-title>
            </router-link>
          </v-list-tile-content>
        </v-list-tile>

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
      <!-- <GridContainer /> -->
      <router-view />
    </v-content>
  </v-app>
</template>

<script>
// import GridContainer from './components/GridContainer'
export default {
  components: {
    // GridContainer
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
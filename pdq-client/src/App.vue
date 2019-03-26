<template>
  <v-app id="inspire">
    <Snackbar />
    <Loader />
    <v-navigation-drawer
      :clipped="$vuetify.breakpoint.lgAndUp"
      v-model="drawer"
      fixed
      app
      style="background-color: #F2F1EF"
    >
      <v-list dense>
        <template v-for="item in items">
          <v-list-group
            v-if="item.children"
            v-model="item.model"
            :key="item.text"
            :prepend-icon="item.model ? item.icon : item['icon-alt']"
            append-icon
          >
            <v-list-tile slot="activator" :key="item.text" :to="item.link">
              <v-list-tile-content>
                <v-list-tile-title>{{ item.text }}</v-list-tile-title>
              </v-list-tile-content>
            </v-list-tile>
            <v-list-tile v-for="(child, i) in item.children" :key="i" :to="child.link">
              <!-- @click="" -->
              <v-list-tile-action v-if="child.icon">
                <v-icon>{{ child.icon }}</v-icon>
              </v-list-tile-action>
              <v-list-tile-content>
                <v-list-tile-title>{{ child.text }}</v-list-tile-title>
              </v-list-tile-content>
            </v-list-tile>
          </v-list-group>

          <v-list-tile v-else :key="item.text" :to="item.link">
            <!-- @click="" -->
            <v-list-tile-action>
              <v-icon>{{ item.icon }}</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title>{{ item.text }}</v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>
        </template>
      </v-list>
    </v-navigation-drawer>
    <v-toolbar :clipped-left="$vuetify.breakpoint.lgAndUp" color="#007486" dark app fixed dense>
      <v-toolbar-side-icon @click.stop="drawer = !drawer"/>
      <v-divider class="mx-2" inset vertical/>
      <v-toolbar-title style="width: 300px" class="ml-0 pl-3">
        <v-btn color="white" class="button-icon pa-1" depressed>
          <img src="./assets/compass-minerals.jpg" alt="ProduQuimica" width="70%" height="70%">
        </v-btn>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-avatar size="40" color="blue">
        <span class="white--text headline">J</span>
      </v-avatar>
    </v-toolbar>
    <v-content>
      <!-- <GridContainer /> -->
      <v-container fluid fill-height class="grey lighten-4">
        <v-layout>
          <v-flex>
            <transition name="fade">
              <router-view></router-view>
            </transition>
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
// import GridContainer from './components/GridContainer'
import Snackbar from './components/shared/Snackbar'
import Loader from './components/shared/Loader'
export default {
  components: {
    Snackbar, Loader // GridContainer
  },
  data() {
    return {
      daysPastCreation: 0,
      drawer: null,
      items: [
        {
          icon: "keyboard_arrow_up",
          "icon-alt": "keyboard_arrow_down",
          text: "Pedido",
          link: ``,
          model: true,
          children: [
            { icon: "search", text: "Consultar", link: `/consultarpedido/` },
            // { icon: 'list_alt', text: 'Aprovar',  link: `/aprovarpedido/`},
            {
              icon: "blur_on",
              text: "Fluxo de aprovação",
              link: `/fluxoaprovacao/`
            }
          ]
        }
        // { icon: 'trending_up', text: 'Relatórios', link: '/report' },
        // { icon: 'settings', text: 'Configurações', link: '/configuration' },
      ]
    };
  }
};
</script>

<style>
.v-table__overflow {
  white-space: nowrap;
  overflow: hidden;
  max-height: 350px;
  width: 100%;
  overflow-y: auto;
  overflow-x: auto;
}
.button-icon {
  height: 90%;
  width: 45%;
}
.fade-enter-active, .fade-leave-active {
  transition: opacity .5s;
}
.fade-enter, .fade-leave-to {
  opacity: 0;
}
</style>
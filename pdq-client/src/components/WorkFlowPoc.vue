<template>
  <v-card 
    color="white" 
    class="black--text"
  >
    <v-card-text>
      <div class='chart'>
        <chart-sankey 
          :data='chartData' 
          :config='chartConfig'
        ></chart-sankey>
      </div>
    </v-card-text>
  </v-card>
</template>

<script>
  import { ChartSankey } from 'vue-d2b'

  export default {
    props: {
      tabIndex: {
        type: Number,
        default: 1
      }
    },
    components: {
      ChartSankey
    },
    data: () => ({
      chartData: {
        nodes: [
          {name: 'Node A'},
          {name: 'Node B'},
          {name: 'Node C'},
          {name: 'Node D'},
          {name: 'Node E'}
        ],
        links: [
          {source: 'Node A', target: 'Node E', value: 2},
          {source: 'Node A', target: 'Node C', value: 2},
          {source: 'Node B', target: 'Node C', value: 2},
          {source: 'Node B', target: 'Node D', value: 2},
          {source: 'Node C', target: 'Node D', value: 2},
          {source: 'Node C', target: 'Node E', value: 2},
          {source: 'Node D', target: 'Node E', value: 4}
        ]
      },

      chartConfig (config) {
        config
          .sankey()
          .sankey()
          .nodePadding(100)

        config
          .sankey()
          .nodeDraggableY(true)
          .nodeDraggableX(true)
      }
    })
  }
</script>

<style scoped>
  .chart{
    width: 100%;
    height: 500px;
  }
</style>
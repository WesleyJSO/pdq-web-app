<template>
  <v-hover>
    <v-card
      slot-scope="{ hover }"
      :class="`elevation-${hover ? 12 : 2}`"
      class="mx-auto"
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
  </v-hover>
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
          // status
          {name: 'Em Construção'},
          {name: 'Gerente Distribução'},
          {name: 'AR'},
          {name: 'Gerente Regional'},
          {name: 'Gerente Comercial'},
          {name: 'Diretor Comercial'},
          {name: 'Adm Vendas'},
          {name: 'Implantado'},
          {name: 'Cancelado'},
          {name: 'Reprovado'},
          // aprovações
          { name: 'Cor'},
          { name: 'Prazo'},
          { name: 'Tabela Preço'},
          { name: 'Campanha'},
          
        ],
        links: [
          {source: 'Em Construção', target: 'Gerente Distribução', value: 1},
          {source: 'Em Construção', target: 'Cancelado', value: 1},
          {source: 'Em Construção', target: 'Reprovado', value: 1},

          {source: 'Gerente Distribução', target: 'AR', value: 1},
          {source: 'Gerente Distribução', target: 'Cancelado', value: 1},
          {source: 'Gerente Distribução', target: 'Reprovado', value: 1},

          {source: 'AR', target: 'Gerente Regional', value: 1},
          {source: 'AR', target: 'Cancelado', value: 1},
          {source: 'AR', target: 'Reprovado', value: 1},
          
          {source: 'Gerente Regional', target: 'Gerente Comercial', value: 1},
          {source: 'Gerente Regional', target: 'Cancelado', value: 1},
          {source: 'Gerente Regional', target: 'Reprovado', value: 1},

          {source: 'Gerente Comercial', target: 'Cor', value: 1},
          {source: 'Gerente Comercial', target: 'Prazo', value: 1},
          {source: 'Gerente Comercial', target: 'Tabela Preço', value: 1},
          {source: 'Gerente Comercial', target: 'Campanha', value: 1},
          {source: 'Cor', target: 'Diretor Comercial', value: 1},
          {source: 'Prazo', target: 'Diretor Comercial', value: 1},
          {source: 'Tabela Preço', target: 'Diretor Comercial', value: 1},
          {source: 'Campanha', target: 'Diretor Comercial', value: 1},

          {source: 'Diretor Comercial', target: 'Adm Vendas', value: 1},
          {source: 'Diretor Comercial', target: 'Cancelado', value: 1},
          {source: 'Diretor Comercial', target: 'Reprovado', value: 1},

          {source: 'Adm Vendas', target: 'Implantado', value: 1},
          {source: 'Adm Vendas', target: 'Cancelado', value: 1},
          {source: 'Adm Vendas', target: 'Reprovado', value: 1},
        ]
      },
      chartConfig (config) {
        config
          .sankey()
          .sankey()
          .nodeWidth(8)
          .nodePadding(140)

        config
          .sankey()
          .nodeDraggableY(true)
          .nodeDraggableX(true)
          // .linkSourceColor('#000')
          // .linkTargetColor('#aaa')

        config
          .sankey()

        // console.log(Object.getOwnPropertyNames(config.sankey().linkSource()))
        // console.log(Object.values(config.sankey().linkSource()))
        // console.log(Object.getOwnPropertyNames(config.sankey().sankey()))
        // console.log(Object.getOwnPropertyNames(config.sankey()))
        // console.log(config.linkTooltip())
          
      }
    }),
    methods: {
      verifyLink (newSource, newTarget) {
        let canChange = true
        this.chartData.links.map(element => {
          if (element.source === newSource && element.target === newTarget
            || element.target === newSource && element.source === newTarget
            || newSource === newTarget) 
            canChange = false
        })
        return canChange
      },
      nodeAlreadyExists (itemName) {
        for (let element of this.chartData.links) {
          if (element.target === itemName)
            return true
        }
        return false
      },
      newItemName (element, newSource) {
        let initials = ''
        newSource.split('').forEach(el => {
          if (el === el.toUpperCase()) {
            initials += el
          }
        })
        return `${element} ${initials.replace( /\s/g, '')}`
      },
      async addNode (newSource, newTarget, itemName) {
        console.log({ newSource })
        console.log({ newTarget })
        console.log({ itemName })
        if (!itemName) {
          this.chartData.links.push({ source: newSource, target: newTarget,  value: 1 })
        } else {
          this.chartData.nodes.push({ name: itemName })
          this.chartData.links.push({ source: newSource, target: itemName,  value: 1 })
          this.chartData.links.push({ source: itemName, target: newTarget,  value: 1 })
        }
      }
    },
    mounted () {
      this.$root.$on('AddLink', (newSource, newTarget, selected) => {
        
        let canChangeNode = this.verifyLink(newSource, newTarget)
        if (canChangeNode) {
          if(selected.length > 0) {
            for (let element of selected) {
              this.addNode(newSource, newTarget, this.newItemName(element, newSource))
            }
          } else {
            this.addNode(newSource, newTarget, null)
          }
        } else if (newSource !== newTarget) { // add only the validations
          selected.forEach(element => {
            let itemName = this.newItemName(element, newSource)
            if (!this.nodeAlreadyExists(itemName)) {
              this.addNode(newSource, newTarget, itemName)
            }
          })
        }
      })
    }
  }
</script>

<style scoped>
  .chart {
    width: 100%;
    height: 500px;
  }
</style>

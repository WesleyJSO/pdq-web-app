<template>
  <v-hover>
    <v-card
      slot-scope="{ hover }"
      :class="`elevation-${hover ? 12 : 2}`"
      class="mx-auto"
    >
      <v-card-title>Adicionar Aprovação</v-card-title>
      <v-card-text>
        <v-form v-model="valid" ref="form">
          <v-container>
            <v-layout>
              
              <v-flex xs12 md4>
                <v-select class=""
                  v-model="selectedSourceItem"
                  :items="sourceItems"
                  :rules="$v_basic.emptyComboField(selectedSourceItem)"
                  label="De..."
                  outline
                ></v-select>
              </v-flex>

              <v-flex xs12 md4>
                <v-select
                  v-model="selectedTargetItem"
                  :items="targetItems"
                  :rules="$v_basic.emptyComboField(selectedTargetItem)"
                  label="Para..."
                  outline
                ></v-select>
              </v-flex>

              <v-flex xs12 md4>
                <v-checkbox v-model="selected" label="Cor" value="Cor" @change="changeDialog"></v-checkbox>
                <v-checkbox v-model="selected" label="Prazo" value="Prazo"></v-checkbox>
                <v-checkbox v-model="selected" label="Tabela Preço" value="Tabela Preço"></v-checkbox>
                <v-checkbox v-model="selected" label="Campanha" value="Campanha"></v-checkbox>
              </v-flex>

            </v-layout>
            
          </v-container>
        </v-form>
      </v-card-text>

      <v-card-actions>
        <v-btn :disabled="!valid" color="success" @click="sendNewLinkData">Adicionar</v-btn>
        <v-btn color="error" @click="reset">Cancelar</v-btn>
        <modal @closeDialog="closeDialog" :dialog="dialog"/>
      </v-card-actions>
    </v-card>
  </v-hover>
</template>

<script>
import modal from './modal'
export default {
  components: {
    modal
  },
  data: () => ({
    dialog: false,
    selected: [],
    selectedSourceItem: '',
    selectedTargetItem: '',
    valid: true,
    sourceItems: [
      'Em Construção',
      'Gerente Distribução',
      'AR',
      'Gerente Regional',
      'Gerente Comercial',
      'Diretor Comercial',
      'Adm Vendas',
      'Implantado',
      'Cancelado',
      'Reprovado',
      'Cor',
      'Prazo',
      'Tabela Preço',
      'Campanha',
    ],
    targetItems: [
      'Em Construção',
      'Gerente Distribução',
      'AR',
      'Gerente Regional',
      'Gerente Comercial',
      'Diretor Comercial',
      'Adm Vendas',
      'Implantado',
      'Cancelado',
      'Reprovado',
      'Cor',
      'Prazo',
      'Tabela Preço',
      'Campanha',
    ]
  }),
  mounted () {
    this.$root.$on('addNode', (newItem, setInSource) => {
      if (setInSource) {
        this.sourceItems.push(newItem)
      } else {
        this.targetItems.push(newItem)
      }
    })
  },
  methods: {
    changeDialog () {
      this.dialog = !this.dialog
      if (this.selected.includes('Cor')) {
        this.dialog = true
      }
    },
    closeDialog (removeSelection) {
      if (removeSelection)
        this.selected = this.selected.filter(element => element !== 'Cor')
      this.dialog = !this.dialog
    },
    sendNewLinkData () {
      this.$root.$emit('AddLink', this.selectedSourceItem, this.selectedTargetItem, this.selected)
    },
    reset () {
      this.$refs.form.reset()
    }
  }
}
</script>

<style scoped>
  
</style>
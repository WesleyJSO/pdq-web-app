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

            </v-layout>
            
          </v-container>
        </v-form>
      </v-card-text>

      <v-card-actions>
        <v-btn :disabled="!valid" color="success" @click="SendNewLinkData">Adicionar</v-btn>
        <v-btn color="error" @click="reset">Cancelar</v-btn>
      </v-card-actions>

    </v-card>
  </v-hover>
</template>

<script>
export default {
  data: () => ({
    selectedSourceItem: '',
    selectedTargetItem: '',
    valid: true,
    items: ['Foo', 'Bar', 'Fizz', 'Buzz'],
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
      'Reprovado'
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
      'Reprovado'
    ]
  }),
  methods: {
    SendNewLinkData () {
      this.$root.$emit('AddLink', this.selectedSourceItem, this.selectedTargetItem)
    },
    reset () {
      this.$refs.form.reset()
    }
  }
}
</script>

<style scoped>
  
</style>
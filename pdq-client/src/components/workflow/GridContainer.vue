<template>
  <v-container fluid grid-list-md>
    <v-layout row wrap>

      <v-flex d-flex xs12 sm12 md12 lg12 xl12>
        <v-card color="#eee">
          <v-card-title class="title">Fluxo de Aprovação</v-card-title>
          
          <v-card-text>
            <!-- Edição do fluxo -->
            <v-flex><WorkflowConfiguration /></v-flex>

            <!-- Fluxo de aprovação -->
            <v-flex><Workflow /></v-flex>
          </v-card-text>
        </v-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
import WorkflowConfiguration from './WorkflowConfiguration'
import Workflow from './WorkflowPoc'
  export default {
    components: {
      WorkflowConfiguration,
      Workflow
    },
    data: () => ({

    })
  }
</script>

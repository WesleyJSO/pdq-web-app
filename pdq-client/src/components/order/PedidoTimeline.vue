<template>
  <v-container style="max-height: 800px;">
    <v-timeline dense clipped>
      <v-timeline-item
        v-for="(item, i) in items"
        :key="i" small
      >
        <v-card color="#666" dark>
          <v-card-title class="pa-1 title">{{ item.employee }}</v-card-title>
          <v-card-text class="pa-1 ml-2 white text--primary">
            <p>{{ item.status }}</p>
            <p>Aprovado em {{ item.date }}</p>
          </v-card-text>
        </v-card>
      </v-timeline-item>
    </v-timeline>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    items: [
      {
        employee: 'Marjory',
        status: 'Aprovação Gerente Comercial',
        date: '01/01/2018'
      },
      {
        employee: 'Marjory',
        status: 'Aprovação Gerente Comercial',
        date: '01/01/2018'
      },
      {
        employee: 'Marjory',
        status: 'Aprovação Gerente Comercial',
        date: '01/01/2018'
      },
      {
        employee: 'Marjory',
        status: 'Aprovação Gerente Comercial',
        date: '01/01/2018'
      },
      {
        employee: 'Marjory',
        status: 'Aprovação Gerente Comercial',
        date: '01/01/2018'
      }
    ]
  }),
}
</script>
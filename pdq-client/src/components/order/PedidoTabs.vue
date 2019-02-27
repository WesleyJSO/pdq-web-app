<template>
  <div>
    <!-- tab 0 informações do pedido -->
    <PedidoDetalhes 
      :pedido="pedido"
      :tabIndex="tabIndex"
    />

    <!-- tab 1 informações dos itens -->
    <PedidoItensDetalhes 
      :listItemPedido="pedido.listPedidoItem"
      :tabIndex="tabIndex"
    />

    <!-- tab 2 outros -->
    
  </div>
</template>

<script>
import PedidoDetalhes from './PedidoDetalhes'
import PedidoItensDetalhes from './PedidoItensDetalhes'

  export default {
    components: {
      PedidoDetalhes,
      PedidoItensDetalhes
    },
		props: {
      tabIndex: { type: Number, default: 0 },
      pedido: { type: Object, default: () => {} }
    },
    data: () => ({
    })
  }
</script>

<style scoped>
.v-card__text {
  height: 441px;
}
</style>
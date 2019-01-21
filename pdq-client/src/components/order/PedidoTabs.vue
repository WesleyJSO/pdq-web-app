<template>
  <div>
    <!-- tab 1 informações do pedido -->
    <PedidoDetalhes 
      :pedido="pedido"
      :tabIndex="tabIndex"
    />

    <!-- tab 2 informações dos itens -->
    <PedidoItensDetalhes 
      :listItemPedido="pedido.listPedidoItem"
      :tabIndex="tabIndex"
    />

    <!-- tab 3 outros -->
    
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
      tabIndex: { type: Number, default: 1 },
      pedido: { type: Object, default: () => {} }
    },
    data: () => ({
    })
  }
</script>

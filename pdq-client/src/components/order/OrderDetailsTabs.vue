<template>
  <div>
    <!-- tab 1 informações do pedido -->
    <OrderInfo 
      :pedido="pedido"
      :tabIndex="tabIndex"
    />

    <!-- tab 2 informações dos itens -->
    <OrderItensDetails 
      :listItemPedido="pedido.listPedidoItem"
      :tabIndex="tabIndex"
    />

    <!-- tab 3 outros -->
    
  </div>
</template>

<script>
import OrderInfo from './OrderInfo'
import OrderItensDetails from './OrderItensDetails'

  export default {
    components: {
      OrderInfo,
      OrderItensDetails
    },
    props: {
      tabIndex: {
        type: Number,
        default: 1
      },
      pedido: { 
        type: Object,
        default: () => {} 
      }
    },
    data: () => ({
    })
  }
</script>

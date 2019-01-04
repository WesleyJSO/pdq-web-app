<template>
  <div>
    <!-- tab 1 informações do pedido -->
    <OrderInfo 
      :order="order"
      :tabIndex="tabIndex"
    />

    <!-- tab 2 informações dos itens -->
    <OrderItensDetails 
      :orderItens="order.itensPedido"
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
      order: { 
        type: Object,
        default: null 
      }
    },
    data: () => ({
    })
  }
</script>

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
    <WorkFlow 
      :tabIndex="tabIndex"
    />
  </div>
</template>

<script>
import OrderInfo from './OrderInfo'
import OrderItensDetails from './OrderItensDetails'
import WorkFlow from './WorkFlowPoc'

  export default {
    components: {
      OrderInfo,
      OrderItensDetails,
      WorkFlow
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

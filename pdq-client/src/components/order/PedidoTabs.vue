<template>
  <div>
    <!-- tab 0 informações do pedido -->
    
    <transition name="fade">
      <PedidoDetalhes 
        :pedido="pedido"
        :tabIndex="tabIndex"
      />
    </transition>

    <!-- tab 1 informações dos itens -->
    
    <transition name="fade">
      <PedidoItensDetalhes 
        :pedido="pedido"
        :tabIndex="tabIndex"
      />
    </transition>

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
    data () {
      return { }
    }
  }
</script>

<style scoped>
.v-card__text {
  height: 441px;
}
</style>
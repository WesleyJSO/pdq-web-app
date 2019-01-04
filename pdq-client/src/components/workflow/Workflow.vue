<template> <!-- http://bl.ocks.org/Neilos/584b9a5d44d5fe00f779 -->
    <div id="chart">
      <v-btn color="black" class="white--text" @click="teste">teste</v-btn>
    </div>
</template>

<script>
  export default {
    data: () => ({
      isTransitioning: false,
      OPACITY: {
        NODE_DEFAULT: 0.9,
        NODE_FADED: 0.1,
        NODE_HIGHLIGHT: 0.8,
        LINK_DEFAULT: 0.6,
        LINK_FADED: 0.05,
        LINK_HIGHLIGHT: 0.9
      },
      TYPES: ['Asset', 'Expense', 'Revenue', 'Equity', 'Liability'],
      TYPE_COLORS: ['#1b9e77', '#d95f02', '#7570b3', '#e7298a', '#66a61e', '#e6ab02', '#a6761d'],
      TYPE_HIGHLIGHT_COLORS: ['#66c2a5', '#fc8d62', '#8da0cb', '#e78ac3', '#a6d854', '#ffd92f', '#e5c494'],
      LINK_COLOR: '#b3b3b3',
      INFLOW_COLOR: '#2E86D1',
      OUTFLOW_COLOR: '#D63028',
      NODE_WIDTH: 36,
      COLLAPSER: {},
      OUTER_MARGIN: 10,
      MARGIN: {},
      TRANSITION_DURATION: 400,
      HEIGHT: 0,
      WIDTH: 0,
      LAYOUT_INTERATIONS: 32,
      colorScale: {},
      highlightColorScale: {},
      svg: {},
      tooltip: {},
      biHiSankey: {},
      path: {},
      defs: {},
      exampleNodes: [
        {'type':'Asset','id':'a','parent':null,'name':'Assets'},
        {'type':'Asset','id':1,'parent':'a','number':'101','name':'Cash'},
        {'type':'Asset','id':2,'parent':'a','number':'120','name':'Accounts Receivable'},
        {'type':'Asset','id':3,'parent':'a','number':'140','name':'Merchandise Inventory'},
        {'type':'Asset','id':4,'parent':'a','number':'150','name':'Supplies'},
        {'type':'Asset','id':5,'parent':'a','number':'160','name':'Prepaid Insurance'},
        {'type':'Asset','id':6,'parent':'a','number':'170','name':'Land'},
        {'type':'Asset','id':7,'parent':'a','number':'175','name':'Buildings'},
        {'type':'Asset','id':8,'parent':'a','number':'178','name':'Acc. Depreciation Buildings'},
        {'type':'Asset','id':9,'parent':'a','number':'180','name':'Equipment'},
        {'type':'Asset','id':10,'parent':'a','number':'188','name':'Acc. Depreciation Equipment'},
        {'type':'Liability','id':'l','parent':null,'number':'l','name':'Liabilities'},
        {'type':'Liability','id':11,'parent':'l','number':'210','name':'Notes Payable'},
        {'type':'Liability','id':12,'parent':'l','number':'215','name':'Accounts Payable'},
        {'type':'Liability','id':13,'parent':'l','number':'220','name':'Wages Payable'},
        {'type':'Liability','id':14,'parent':'l','number':'230','name':'Interest Payable'},
        {'type':'Liability','id':15,'parent':'l','number':'240','name':'Unearned Revenues'},
        {'type':'Liability','id':16,'parent':'l','number':'250','name':'Mortage Loan Payable'},
        {'type':'Equity','id':'eq','parent':null,'number':'eq','name':'Equity'},
        {'type':'Revenue','id':'r','parent':null,'number':'r','name':'Revenues'},
        {'type':'Revenue','id':'or','parent':'r','number':'','name':'Operating Revenue'},
        {'type':'Revenue','id':17,'parent':'or','number':'310','name':'Service Revenues'},
        {'type':'Revenue','id':'nor','parent':'r','number':'','name':'Non-Operating Revenue'},
        {'type':'Revenue','id':18,'parent':'nor','number':'810','name':'Interest Revenues'},
        {'type':'Revenue','id':19,'parent':'nor','number':'910','name':'Asset Sale Gain'},
        {'type':'Revenue','id':20,'parent':'nor','number':'960','name':'Asset Sale Loss'},
        {'type':'Expense','id':'ex','parent':null,'number':'ex','name':'Expenses'},
        {'type':'Expense','id':21,'parent':'ex','number':'500','name':'Salaries Expense'},
        {'type':'Expense','id':22,'parent':'ex','number':'510','name':'Wages Expense'},
        {'type':'Expense','id':23,'parent':'ex','number':'540','name':'Supplies Expense'},
        {'type':'Expense','id':24,'parent':'ex','number':'560','name':'Rent Expense'},
        {'type':'Expense','id':25,'parent':'ex','number':'570','name':'Utilities Expense'},
        {'type':'Expense','id':26,'parent':'ex','number':'576','name':'Telephone Expense'},
        {'type':'Expense','id':27,'parent':'ex','number':'610','name':'Advertising Expense'},
        {'type':'Expense','id':28,'parent':'ex','number':'750','name':'Depreciation Expense'}
      ],
      exampleLinks: [
        {'source':8, 'target':28, 'value':Math.floor(Math.random() * 100)},
        {'source':17, 'target':18, 'value':Math.floor(Math.random() * 100)},
        {'source':22, 'target':24, 'value':Math.floor(Math.random() * 100)},
        {'source':3, 'target':13, 'value':Math.floor(Math.random() * 100)},
        {'source':24, 'target':24, 'value':Math.floor(Math.random() * 100)},
        {'source':5, 'target':4, 'value':Math.floor(Math.random() * 100)},
        {'source':15, 'target':5, 'value':Math.floor(Math.random() * 100)},
        {'source':18, 'target':8, 'value':Math.floor(Math.random() * 100)},
        {'source':3, 'target':20, 'value':Math.floor(Math.random() * 100)},
        {'source':17, 'target':18, 'value':Math.floor(Math.random() * 100)},
        {'source':22, 'target':5, 'value':Math.floor(Math.random() * 100)},
        {'source':4, 'target':24, 'value':Math.floor(Math.random() * 100)},
        {'source':26, 'target':16, 'value':Math.floor(Math.random() * 100)},
        {'source':27, 'target':6, 'value':Math.floor(Math.random() * 100)},
        {'source':23, 'target':4, 'value':Math.floor(Math.random() * 100)},
        {'source':10, 'target':24, 'value':Math.floor(Math.random() * 100)},
        {'source':17, 'target':16, 'value':Math.floor(Math.random() * 100)},
        {'source':5, 'target':12, 'value':Math.floor(Math.random() * 100)},
        {'source':12, 'target':16, 'value':Math.floor(Math.random() * 100)},
        {'source':19, 'target':5, 'value':Math.floor(Math.random() * 100)},
        {'source':15, 'target':24, 'value':Math.floor(Math.random() * 100)},
        {'source':27, 'target':2, 'value':Math.floor(Math.random() * 100)},
        {'source':26, 'target':28, 'value':Math.floor(Math.random() * 100)},
        {'source':22, 'target':24, 'value':Math.floor(Math.random() * 100)},
        {'source':3, 'target':18, 'value':Math.floor(Math.random() * 100)},
        {'source':18, 'target':5, 'value':Math.floor(Math.random() * 100)},
        {'source':25, 'target':28, 'value':Math.floor(Math.random() * 100)},
        {'source':12, 'target':1, 'value':Math.floor(Math.random() * 100)},
        {'source':28, 'target':21, 'value':Math.floor(Math.random() * 100)},
        {'source':9, 'target':16, 'value':Math.floor(Math.random() * 100)},
        {'source':14, 'target':23, 'value':Math.floor(Math.random() * 100)},
        {'source':6, 'target':1, 'value':Math.floor(Math.random() * 100)},
        {'source':9, 'target':15, 'value':Math.floor(Math.random() * 100)},
        {'source':16, 'target':24, 'value':Math.floor(Math.random() * 100)},
        {'source':22, 'target':28, 'value':Math.floor(Math.random() * 100)},
        {'source':8, 'target':21, 'value':Math.floor(Math.random() * 100)},
        {'source':22, 'target':7, 'value':Math.floor(Math.random() * 100)},
        {'source':18, 'target':10, 'value':Math.floor(Math.random() * 100)},
        {'source':'eq', 'target':1, 'value':Math.floor(Math.random() * 100)}, 
        {'source':1, 'target':21, 'value':Math.floor(Math.random() * 100)},
        {'source':1, 'target':24, 'value':Math.floor(Math.random() * 100)},
        {'source':17, 'target':1, 'value':Math.floor(Math.random() * 100)},
        {'source':Math.ceil(Math.random() * 28), 'target':Math.ceil(Math.random() * 28), 'value':Math.floor(Math.random() * 100)},
        {'source':Math.ceil(Math.random() * 28), 'target':Math.ceil(Math.random() * 28), 'value':Math.floor(Math.random() * 100)},
        {'source':Math.ceil(Math.random() * 28), 'target':Math.ceil(Math.random() * 28), 'value':Math.floor(Math.random() * 100)},
        {'source':Math.ceil(Math.random() * 28), 'target':Math.ceil(Math.random() * 28), 'value':Math.floor(Math.random() * 100)},
        {'source':Math.ceil(Math.random() * 28), 'target':Math.ceil(Math.random() * 28), 'value':Math.floor(Math.random() * 100)},
        {'source':Math.ceil(Math.random() * 28), 'target':Math.ceil(Math.random() * 28), 'value':Math.floor(Math.random() * 100)},
        {'source':Math.ceil(Math.random() * 28), 'target':Math.ceil(Math.random() * 28), 'value':Math.floor(Math.random() * 100)},
        {'source':Math.ceil(Math.random() * 28), 'target':Math.ceil(Math.random() * 28), 'value':Math.floor(Math.random() * 100)},
        {'source':Math.ceil(Math.random() * 28), 'target':Math.ceil(Math.random() * 28), 'value':Math.floor(Math.random() * 100)},
        {'source':Math.ceil(Math.random() * 28), 'target':Math.ceil(Math.random() * 28), 'value':Math.floor(Math.random() * 100)}
      ]
    }),
    mounted () {
      // this.d3 = document.createElement('script'),
      // this.$_d3.setAttribute('src', 'http://d3js.org/d3.v3.min.js'),
      // document.head.appendChild(this.d3),
      this.biHiSankey = document.createElement('script'),
      this.biHiSankey.setAttribute('src', 'https://cdn.rawgit.com/Neilos/bihisankey/master/bihisankey.js'),
      document.head.appendChild(this.biHiSankey),

      this.COLLAPSER = {
        RADIUS: this.NODE_WIDTH / 2,
        SPACING: 2
      },
      this.MARGIN = {
        TOP: 2 * (this.COLLAPSER.RADIUS + this.OUTER_MARGIN),
        RIGHT: this.OUTER_MARGIN,
        BOTTOM: this.OUTER_MARGIN,
        LEFT: this.OUTER_MARGIN
      },
      this.HEIGHT = 500 - this.MARGIN.TOP - this.MARGIN.BOTTOM
      this.WIDTH = 960 - this.MARGIN.LEFT - this.MARGIN.RIGHT
      /* eslint-disable no-console */
      console.log(this.$_d3)
      this.colorScale = this.$_d3.scale.ordinal().domain(this.TYPES).range(this.TYPE_COLORS)
      this.highlightColorScale = this.$_d3.scale.ordinal().domain(this.TYPES).range(this.TYPE_HIGHLIGHT_COLORS)
      this.svg = this.$_d3.select('#chart').append('svg')
        .attr('width', this.WIDTH + this.MARGIN.LEFT + this.MARGIN.RIGHT)
        .attr('height', this.HEIGHT + this.MARGIN.TOP + this.MARGIN.BOTTOM)
        .append('g')
        .attr('transform', 'translate(' + this.MARGIN.LEFT + ',' + this.MARGIN.TOP + ')')
        .append('g').attr('id', 'links')
        .append('g').attr('id', 'nodes')
        .append('g').attr('id', 'collapsers')

      this.tooltip = this.$_d3.select('#chart')
        .append('div').attr('id', 'tooltip')
        .style('opacity', 0)
        .append('p').attr('class', 'value')

      this.biHiSankey = this.$_d3.biHiSankey()
        // Set the this.biHiSankey diagram properties
        .nodeWidth(this.NODE_WIDTH)
        .nodeSpacing(10)
        .linkSpacing(4)
        .arrowheadScaleFactor(0.5) // Specifies that 0.5 of the link's stroke this.WIDTH should be allowed for the marker at the end of the link.
        .size([this.WIDTH, this.HEIGHT])
        .nodes(this.exampleNodes)
        .links(this.exampleLinks)
        .initializeNodes(function (node) {
          node.state = node.parent ? 'contained' : 'collapsed'
        })
        .layout(this.LAYOUT_INTERATIONS)
      this.path = this.biHiSankey.link().curvature(0.45)
      
      this.defs = this.svg.append('defs')
        .append('marker')
        .style('fill', this.LINK_COLOR)
        .attr('id', 'arrowHead')
        .attr('viewBox', '0 0 6 10')
        .attr('refX', '1')
        .attr('refY', '5')
        .attr('markerUnits', 'strokeWidth')
        .attr('markerWidth', '1')
        .attr('markerHeight', '1')
        .attr('orient', 'auto')
        .append('path')
        .attr('d', 'M 0 0 L 1 0 L 6 5 L 1 10 L 0 10 z')

        .append('marker')
        .style('fill', this.OUTFLOW_COLOR)
        .attr('id', 'arrowHeadInflow')
        .attr('viewBox', '0 0 6 10')
        .attr('refX', '1')
        .attr('refY', '5')
        .attr('markerUnits', 'strokeWidth')
        .attr('markerWidth', '1')
        .attr('markerHeight', '1')
        .attr('orient', 'auto')
        .append('path')
        .attr('d', 'M 0 0 L 1 0 L 6 5 L 1 10 L 0 10 z')

        .append('marker')
        .style('fill', this.INFLOW_COLOR)
        .attr('id', 'arrowHeadOutlow')
        .attr('viewBox', '0 0 6 10')
        .attr('refX', '1')
        .attr('refY', '5')
        .attr('markerUnits', 'strokeWidth')
        .attr('markerWidth', '1')
        .attr('markerHeight', '1')
        .attr('orient', 'auto')
        .append('path')
        .attr('d', 'M 0 0 L 1 0 L 6 5 L 1 10 L 0 10 z')

      this.disableUserInterractions(2 * this.TRANSITION_DURATION)
      this.update()
    },
    methods: {
      teste () {
        /* eslint-disable no-console */
        console.log(this.$_d3.sankey())
      },
      formatNumber (d) {
        var numberFormat = this.$_d3.format(',.0f') // zero decimal places
        return '£' + numberFormat(d)
      },
      
      formatFlow (d) {
        var flowFormat = this.$_d3.format(',.0f') // zero decimal places with sign
        return '£' + flowFormat(Math.abs(d)) + (d < 0 ? ' CR' : ' DR')
      },
       // Used when temporarily disabling user interractions to allow animations to complete
      
      disableUserInterractions (time) {
        this.isTransitioning = true
        setTimeout(function() {
          this.isTransitioning = false
        }, time)
      },
      
      hideTooltip () {
        return this.tooltip.transition()
          .duration(this.TRANSITION_DURATION)
          .style('opacity', 0)
      },
      
      showTooltip () {
        return this.tooltip
          .style('left', this.$_d3.event.pageX + 'px')
          .style('top', this.$_d3.event.pageY + 15 + 'px')
          .transition()
          .duration(this.TRANSITION_DURATION)
          .style('opacity', 1)
      },
      
      dragmove (node) {
        node.x = Math.max(0, Math.min(this.WIDTH - node.width, this.$_d3.event.x))
        node.y = Math.max(0, Math.min(this.HEIGHT - node.height, this.$_d3.event.y))
        this.$_d3.select(this).attr('transform', 'translate(' + node.x + ',' + node.y + ')')
        this.biHiSankey.relayout()
        this.svg.selectAll('.node').selectAll('rect').attr('height', function (d) { return d.height })
        this.link.attr('d', this.path)
      },
      
      containChildren(node) {
        node.children.forEach(function (child) {
          child.state = 'contained'
          child.parent = this
          child._parent = null
          this.containChildren(child)
        }, node)
      },
      
      expand(node) {
        node.state = 'expanded'
        node.children.forEach(function (child) {
          child.state = 'collapsed'
          child._parent = this
          child.parent = null
          this.containChildren(child)
        }, node)
      },
      
      collapse(node) {
        node.state = 'collapsed'
        this.containChildren(node)
      },
      
      restoreLinksAndNodes() {
        this.link
          .style('stroke', this.LINK_COLOR)
          .style('marker-end', function () { return 'url(#arrowHead)' })
          .transition()
          .duration(this.TRANSITION_DURATION)
          .style('opacity', this.OPACITY.LINK_DEFAULT)

        this.node
          .selectAll('rect')
          .style('fill', function (d) {
            d.color = this.colorScale(d.type.replace(/ .*/, ''))
            return d.color
          }).style('stroke', function (d) {
            return this.$_d3.rgb(this.colorScale(d.type.replace(/ .*/, ''))).darker(0.1)
          }).style('fill-opacity', this.OPACITY.NODE_DEFAULT)

        this.node
          .filter(function (n) { return n.state === 'collapsed' })
          .transition()
          .duration(this.TRANSITION_DURATION)
          .style('opacity', this.OPACITY.NODE_DEFAULT)
      },
      
      showHideChildren(node) {
        this.disableUserInterractions(2 * this.TRANSITION_DURATION)
        this.hideTooltip()
        if (node.state === 'collapsed') { this.expand(node) }
        else { this.collapse(node) }

        this.biHiSankey.relayout()
        this.update(this.svg, this.OPACITY)
        this.link.attr('d', this.path)
        this.restoreLinksAndNodes()
      },
      
      highlightConnected(g) {
        this.link.filter( d => d.source === g )
          .style('marker-end', () => 'url(#arrowHeadInflow)' )
          .style('stroke', this.OUTFLOW_COLOR)
          .style('opacity', this.OPACITY.LINK_DEFAULT)

        this.link.filter( d => d.target === g )
          .style('marker-end', () => 'url(#arrowHeadOutlow)' )
          .style('stroke', this.INFLOW_COLOR)
          .style('stroke', this.INFLOW_COLOR)
          .style('opacity', this.OPACITY.LINK_DEFAULT)
      },
      
      fadeUnconnected(g) {
        this.link.filter(function (d) { return d.source !== g && d.target !== g })
          .style('marker-end', function () { return 'url(#arrowHead)' })
          .transition()
            .duration(this.TRANSITION_DURATION)
            .style('opacity', this.OPACITY.LINK_FADED)

        this.node.filter(function (d) {
          return (d.name === g.name) ? false : !this.biHiSankey.connected(d, g)
        }).transition()
          .duration(this.TRANSITION_DURATION)
          .style('opacity', this.OPACITY.NODE_FADED)
      },

      update () {
        var link, linkEnter, node, nodeEnter, collapser, collapserEnter

        this.dragmove(node)
        this.containChildren(node)
        this.expand(node)
        this.collapse(node)
        this.restoreLinksAndNodes()
        this.this.showHideChildren(this.node, this.svg, this.OPACITY, this.path)
        this.highlightConnected()
        this.this.fadeUnconnected(this.OPACITY)

        link = this.svg.select('#links').selectAll('path.link')
          .data(this.biHiSankey.visibleLinks(), function (d) { return d.id })

        link.transition()
          .duration(this.TRANSITION_DURATION)
          .style('stroke-this.WIDTH', function (d) { return Math.max(1, d.thickness) })
          .attr('d', this.path)
          .style('opacity', this.OPACITY.LINK_DEFAULT)

        link.exit().remove()

        linkEnter = link.enter().append('path')
          .attr('class', 'link')
          .style('fill', 'none')

        linkEnter.on('mouseenter', function (d) {
          if (!this.isTransitioning) {
            this.showTooltip().select('.value').text(function () {
              if (d.direction > 0) {
                return d.source.name + ' → ' + d.target.name + '\n' + this.formatNumber(d.value)
              }
              return d.target.name + ' ← ' + d.source.name + '\n' + this.formatNumber(d.value)
            })

            this.$_d3.select(this)
              .style('stroke', this.LINK_COLOR)
              .transition()
                .duration(this.TRANSITION_DURATION / 2)
                .style('opacity', this.OPACITY.LINK_HIGHLIGHT)
          }
        })

        linkEnter.on('mouseleave', function () {
          if (!this.isTransitioning) {
            this.hideTooltip()

            this.$_d3.select(this)
              .style('stroke', this.LINK_COLOR)
              .transition()
              .duration(this.TRANSITION_DURATION / 2)
              .style('opacity', this.OPACITY.LINK_DEFAULT)
          }
        })

        linkEnter.sort(function (a, b) { return b.thickness - a.thickness })
          .classed('leftToRight', function (d) {
            return d.direction > 0
          })
          .classed('rightToLeft', function (d) {
            return d.direction < 0
          })
          .style('marker-end', function () {
            return 'url(#arrowHead)'
          })
          .style('stroke', this.LINK_COLOR)
          .style('opacity', 0)
          .transition()
          .delay(this.TRANSITION_DURATION)
          .duration(this.TRANSITION_DURATION)
          .attr('d', this.path)
          .style('stroke-this.WIDTH', function (d) { return Math.max(1, d.thickness) })
          .style('opacity', this.OPACITY.LINK_DEFAULT)

        node = this.svg.select('#nodes').selectAll('.node')
          .data(this.biHiSankey.collapsedNodes(), function (d) { return d.id })


        node.transition()
          .duration(this.TRANSITION_DURATION)
          .attr('transform', function (d) { return 'translate(' + d.x + ',' + d.y + ')' })
          .style('opacity', this.OPACITY.NODE_DEFAULT)
          .select('rect')
          .style('fill', function (d) {
            d.color = this.colorScale(d.type.replace(/ .*/, ''))
            return d.color
          })
          .style('stroke', function (d) { return this.$_d3.rgb(this.colorScale(d.type.replace(/ .*/, ''))).darker(0.1) })
          .style('stroke-this.WIDTH', '1px')
          .attr('height', function (d) { return d.height })
          .attr('width', this.biHiSankey.nodeWidth())


        node.exit()
          .transition()
          .duration(this.TRANSITION_DURATION)
          .attr('transform', function (d) {
            var collapsedAncestor, endX, endY
            collapsedAncestor = d.ancestors.filter(function (a) {
              return a.state === 'collapsed'
            })[0]
            endX = collapsedAncestor ? collapsedAncestor.x : d.x
            endY = collapsedAncestor ? collapsedAncestor.y : d.y
            return 'translate(' + endX + ',' + endY + ')'
          })
          .remove()

        nodeEnter = node.enter().append('g').attr('class', 'node')

        nodeEnter
          .attr('transform', function (d) {
            var startX = d._parent ? d._parent.x : d.x,
                startY = d._parent ? d._parent.y : d.y
            return 'translate(' + startX + ',' + startY + ')'
          })
          .style('opacity', 1e-6)
          .transition()
          .duration(this.TRANSITION_DURATION)
          .style('opacity', this.OPACITY.NODE_DEFAULT)
          .attr('transform', function (d) { return 'translate(' + d.x + ',' + d.y + ')' })

        nodeEnter.append('text')
        nodeEnter.append('rect')
          .style('fill', function (d) {
            d.color = this.colorScale(d.type.replace(/ .*/, ''))
            return d.color
          })
          .style('stroke', function (d) {
            return this.$_d3.rgb(this.colorScale(d.type.replace(/ .*/, ''))).darker(0.1)
          })
          .style('stroke-this.WIDTH', '1px')
          .attr('height', function (d) { return d.height })
          .attr('width', this.biHiSankey.nodeWidth())

        node.on('mouseenter', function (g) {
          if (!this.isTransitioning) {
            this.restoreLinksAndNodes()
            this.highlightConnected(g)
            this.fadeUnconnected(g)

            this.$_d3.select(this).select('rect')
              .style('fill', function (d) {
                d.color = d.netFlow > 0 ? this.INFLOW_COLOR : this.OUTFLOW_COLOR
                return d.color
              })
              .style('stroke', function (d) {
                return this.$_d3.rgb(d.color).darker(0.1)
              })
              .style('fill-opacity', this.OPACITY.LINK_DEFAULT)

            this.tooltip
              .style('left', g.x + this.MARGIN.LEFT + 'px')
              .style('top', g.y + g.height + this.MARGIN.TOP + 15 + 'px')
              .transition()
              .duration(this.TRANSITION_DURATION)
              .style('opacity', 1).select('.value')
              .text(function () {
                var additionalInstructions = g.children.length ? '\n(Double click to expand)' : ''
                return g.name + '\nNet flow: ' + this.formatFlow(g.netFlow) + additionalInstructions
              })
          }
        })

        node.on('mouseleave', function () {
          if (!this.isTransitioning) {
            this.hideTooltip()
            this.restoreLinksAndNodes()
          }
        })

        node.filter(function (d) { return d.children.length })
          .on('dblclick', this.showHideChildren)

        // allow nodes to be dragged to new positions
        node.call(this.$_d3.behavior.drag()
          .origin(function (d) { return d })
          .on('dragstart', function () { this.parentNode.appendChild(this) })
          .on('drag', this.dragmove))

        // add in the text for the nodes
        node.filter(function (d) { return d.value !== 0 })
          .select('text')
            .attr('x', -6)
            .attr('y', function (d) { return d.height / 2 })
            .attr('dy', '.35em')
            .attr('text-anchor', 'end')
            .attr('transform', null)
            .text(function (d) { return d.name })
          .filter(function (d) { return d.x < this.WIDTH / 2 })
            .attr('x', 6 + this.biHiSankey.nodeWidth())
            .attr('text-anchor', 'start')


        collapser = this.svg.select('#collapsers').selectAll('.collapser')
          .data(this.biHiSankey.expandedNodes(), function (d) { return d.id })


        collapserEnter = collapser.enter().append('g').attr('class', 'collapser')

        collapserEnter.append('circle')
          .attr('r', this.COLLAPSER.RADIUS)
          .style('fill', function (d) {
            d.color = this.colorScale(d.type.replace(/ .*/, ''))
            return d.color
          })

        collapserEnter
          .style('opacity', this.OPACITY.NODE_DEFAULT)
          .attr('transform', function (d) {
            return 'translate(' + (d.x + d.width / 2) + ',' + (d.y + this.COLLAPSER.RADIUS) + ')'
          })

        collapserEnter.on('dblclick', this.showHideChildren)

        collapser.select('circle')
          .attr('r', this.COLLAPSER.RADIUS)

        collapser.transition()
          .delay(this.TRANSITION_DURATION)
          .duration(this.TRANSITION_DURATION)
          .attr('transform', function (d, i) {
            return 'translate('
              + (this.COLLAPSER.RADIUS + i * 2 * (this.COLLAPSER.RADIUS + this.COLLAPSER.SPACING))
              + ','
              + (-this.COLLAPSER.RADIUS - this.OUTER_MARGIN)
              + ')'
          })

        collapser.on('mouseenter', function (g) {
          if (!this.isTransitioning) {
            this.showTooltip().select('.value')
              .text(function () {
                return g.name + '\n(Double click to collapse)'
              })

            var highlightColor = this.highlightColorScale(g.type.replace(/ .*/, ''))

            this.$_d3.select(this)
              .style('opacity', this.OPACITY.NODE_HIGHLIGHT)
              .select('circle')
                .style('fill', highlightColor)

            node.filter(function (d) {
              return d.ancestors.indexOf(g) >= 0
            }).style('opacity', this.OPACITY.NODE_HIGHLIGHT)
              .select('rect')
                .style('fill', highlightColor)
          }
        })

        collapser.on('mouseleave', function (g) {
          if (!this.isTransitioning) {
            this.hideTooltip()
            this.$_d3.select(this)
              .style('opacity', this.OPACITY.NODE_DEFAULT)
              .select('circle')
                .style('fill', function (d) { return d.color })

            node.filter(function (d) {
              return d.ancestors.indexOf(g) >= 0
            }).style('opacity', this.OPACITY.NODE_DEFAULT)
              .select('rect')
                .style('fill', function (d) { return d.color })
          }
        })

        collapser.exit().remove()
      }
    },
  }
</script>

<style scoped>
.node rect {
  cursor: move;
  shape-rendering: crispEdges;
}

.node text {
  pointer-events: none;
  text-shadow: 1px 1px 2px #fff;
  font-size: 0.8em;
  font-family: sans-serif;
}

#this.tooltip {
  position: absolute;
  pointer-events: none;
  font-size: 0.7em;
  font-family: sans-serif;
  padding: 3px;
  width: auto;
  height: auto;
  background-color: #F2F2F2;
  -webkit-box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.4);
  -mox-box-shadow: 0px 0px 0px 5px rgba(0, 0, 0, 0.4);
  box-shadow: 0px 0px 5px rbga(0, 0, 0, 0.4);
  pointer-events: none;
}

.value {
  white-space: pre-line;
  margin: 0;
}
</style>
package com.pdq.pedido.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.pdq.utils.DomainEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author Bruno Holanda - Muralis
 * @date 9 de abr de 2019
 *
 */

@Data
@EqualsAndHashCode(callSuper=false)
@Table
@Entity
@AttributeOverride(name = "id", column = @Column(name = "ID_PRODUTO_PRECO"))
public class ProdutoPrecoRegras extends DomainEntity<Long> {

	private static final long serialVersionUID = 6988876037701409548L;

	@Column ( name = "OBSERVACAO_GP_NF" )
    private String observacaoGPNF;

    @Column ( name = "TIPO_EMBALAGEM" )
    private String tipoEmbalagem;

    @OneToOne
    @JoinColumn ( name = "ID_PRODUTO" , referencedColumnName = "ID_PRODUTO" )
    private Produto produto;

    @OneToOne
    @JoinColumn ( name = "ID_TABELA_PRECO" )
    private TabelaPreco tabelaPreco;

    @OneToOne ( )
    @JoinColumn ( name = "UF_ORIGEM_1" )
    private Estado ufOrigem1;

    @OneToOne ( )
    @JoinColumn ( name = "UF_ORIGEM_2" )
    private Estado ufOrigem2;

    @OneToOne ( )
    @JoinColumn ( name = "UF_ORIGEM_3" )
    private Estado ufOrigem3;

    @OneToOne ( )
    @JoinColumn ( name = "UF_ORIGEM_4" )
    private Estado ufOrigem4;

    @Column ( name = "NCM" )
    private String ncm;

    @OneToOne ( )
    @JoinColumn ( name = "ID_ORGANIZACAO" )
    private OrganizacaoVenda organizacao;

    @OneToOne ( )
    @JoinColumn ( name = "ID_FABRICA" )
    private Fabrica fabrica;
    
    @OneToOne
    @JoinColumn ( name = "ID_DEPOSITO" )
    private Deposito deposito;

    @OneToOne
    @JoinColumn ( name = "ID_LINHA_PRODUTO" )
    private LinhaProduto linhaProduto;

    @OneToOne
    @JoinColumn ( name = "ID_GRUPO_MERCADORIA" )
    private GrupoMercadoria grupoMercadoria;

    @Column ( name = "UNIDADE" )
    private String unidade;

    @Column ( name = "PRODUTOS_IGUAIS" )
    private String produtosIguais;

    @Column ( name = "OBSERVACAO_GP" )
    private String observacaoGP;

    @Column ( name = "BARTER" )
    private String barter;

    @Column ( name = "PROGRAMA_CAFE" )
    private String programaCafe;

    @Column ( name = "PROGRAMA_MILHO" )
    private String programaMilho;

    @Column ( name = "PROGRAMA_SOJA" )
    private String programaSoja;

    @Column ( name = "EMBALAGEM" )
    private Double embalagem;

    @Column ( name = "DENSIDADE" )
    private Double densidade;

    @Column ( name = "GERENTE" )
    private String gerente;

    @Column ( name = "CARGA_PERIGOSA" )
    private Double cargaPerigosa;

    @Column ( name = "DIAS_PARA_PRODUCAO" )
    private Double diasParaProducao;

    @Column ( name = "CUSTO_KILO" )
    private Double custoKilo;

    @Column ( name = "CUSTO_GORDURA" )
    private Double custoGordura;

    @Column ( name = "CUSTO_TOTAL" )
    private Double custoTotal;

    @Column ( name = "PRECO_AZUL" )
    private Double precoAzul;

    @Column ( name = "PRECO_VERDE" )
    private Double precoVerde;

    @Column ( name = "PRECO_AMARELO" )
    private Double precoAmarelo;

    @Column ( name = "PRECO_VERMELHO" )
    private Double precoVermelho;

    @Column ( name = "PRECO_PRETO" )
    private Double precoPreto;

    @Column ( name = "COMISSAO_AZUL" )
    private Double comissaoAzul;

    @Column ( name = "COMISSAO_VERDE" )
    private Double comissaoVerde;

    @Column ( name = "COMISSAO_AMARELO" )
    private Double comissaoAmarelo;

    @Column ( name = "COMISSAO_VERMELHO" )
    private Double comissaoVermelho;

    @Column ( name = "COMISSAO_PRETO" )
    private Double comissaoPreto;

    @Column ( name = "MARGEM_AZUL" )
    private Double margemAzul;

    @Column ( name = "MARGEM_VERDE" )
    private Double margemVerde;

    @Column ( name = "MARGEM_AMARELO" )
    private Double margemAmarelo;

    @Column ( name = "MARGEM_VERMELHO" )
    private Double margemVermelho;

    @Column ( name = "MARGEM_PRETO" )
    private Double margemPreto;

    @Column ( name = "ATIVO" )
    private Boolean ativo;
}

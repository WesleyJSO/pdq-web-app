//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:50:30 PM BRT 
//


package com.s3.sap.z_pedido_novo_sap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IChAcesso" type="{urn:sap-com:document:sap:rfc:functions}char15" minOccurs="0"/&gt;
 *         &lt;element name="TabErroPedido" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeErroPedidoWebs" minOccurs="0"/&gt;
 *         &lt;element name="TabPedido" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdePedidoWebs" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "iChAcesso",
    "tabErroPedido",
    "tabPedido"
})
@XmlRootElement(name = "ZbcPedidoNovoArtWebs")
public class ZbcPedidoNovoArtWebs {

    @XmlElement(name = "IChAcesso")
    protected String iChAcesso;
    @XmlElement(name = "TabErroPedido")
    protected TableOfZsdeErroPedidoWebs tabErroPedido;
    @XmlElement(name = "TabPedido")
    protected TableOfZsdePedidoWebs tabPedido;

    /**
     * Obtém o valor da propriedade iChAcesso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIChAcesso() {
        return iChAcesso;
    }

    /**
     * Define o valor da propriedade iChAcesso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIChAcesso(String value) {
        this.iChAcesso = value;
    }

    /**
     * Obtém o valor da propriedade tabErroPedido.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeErroPedidoWebs }
     *     
     */
    public TableOfZsdeErroPedidoWebs getTabErroPedido() {
        return tabErroPedido;
    }

    /**
     * Define o valor da propriedade tabErroPedido.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeErroPedidoWebs }
     *     
     */
    public void setTabErroPedido(TableOfZsdeErroPedidoWebs value) {
        this.tabErroPedido = value;
    }

    /**
     * Obtém o valor da propriedade tabPedido.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdePedidoWebs }
     *     
     */
    public TableOfZsdePedidoWebs getTabPedido() {
        return tabPedido;
    }

    /**
     * Define o valor da propriedade tabPedido.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdePedidoWebs }
     *     
     */
    public void setTabPedido(TableOfZsdePedidoWebs value) {
        this.tabPedido = value;
    }

}

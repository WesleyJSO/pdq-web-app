//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:50:30 PM BRT 
//


package com.s3.sap.z_outros_cad_sap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ZsdeTpOrdemWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeTpOrdemWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TpPedido" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="DcTpPedido" type="{urn:sap-com:document:sap:rfc:functions}char20"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeTpOrdemWebs", propOrder = {
    "tpPedido",
    "dcTpPedido"
})
public class ZsdeTpOrdemWebs {

    @XmlElement(name = "TpPedido", required = true)
    protected String tpPedido;
    @XmlElement(name = "DcTpPedido", required = true)
    protected String dcTpPedido;

    /**
     * Obtém o valor da propriedade tpPedido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpPedido() {
        return tpPedido;
    }

    /**
     * Define o valor da propriedade tpPedido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpPedido(String value) {
        this.tpPedido = value;
    }

    /**
     * Obtém o valor da propriedade dcTpPedido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcTpPedido() {
        return dcTpPedido;
    }

    /**
     * Define o valor da propriedade dcTpPedido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcTpPedido(String value) {
        this.dcTpPedido = value;
    }

}

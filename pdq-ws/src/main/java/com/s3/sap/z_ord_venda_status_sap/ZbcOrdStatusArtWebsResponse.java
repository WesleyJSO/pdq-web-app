//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:50:30 PM BRT 
//


package com.s3.sap.z_ord_venda_status_sap;

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
 *         &lt;element name="RegistrosOrdVenda" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="Retorno" type="{urn:sap-com:document:sap:rfc:functions}char70"/&gt;
 *         &lt;element name="TabOrdStatus" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeOrdStatusWebs" minOccurs="0"/&gt;
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
    "registrosOrdVenda",
    "retorno",
    "tabOrdStatus"
})
@XmlRootElement(name = "ZbcOrdStatusArtWebsResponse")
public class ZbcOrdStatusArtWebsResponse {

    @XmlElement(name = "RegistrosOrdVenda", required = true)
    protected String registrosOrdVenda;
    @XmlElement(name = "Retorno", required = true)
    protected String retorno;
    @XmlElement(name = "TabOrdStatus")
    protected TableOfZsdeOrdStatusWebs tabOrdStatus;

    /**
     * Obtém o valor da propriedade registrosOrdVenda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrosOrdVenda() {
        return registrosOrdVenda;
    }

    /**
     * Define o valor da propriedade registrosOrdVenda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrosOrdVenda(String value) {
        this.registrosOrdVenda = value;
    }

    /**
     * Obtém o valor da propriedade retorno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRetorno() {
        return retorno;
    }

    /**
     * Define o valor da propriedade retorno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRetorno(String value) {
        this.retorno = value;
    }

    /**
     * Obtém o valor da propriedade tabOrdStatus.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeOrdStatusWebs }
     *     
     */
    public TableOfZsdeOrdStatusWebs getTabOrdStatus() {
        return tabOrdStatus;
    }

    /**
     * Define o valor da propriedade tabOrdStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeOrdStatusWebs }
     *     
     */
    public void setTabOrdStatus(TableOfZsdeOrdStatusWebs value) {
        this.tabOrdStatus = value;
    }

}

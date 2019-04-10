//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:50:32 PM BRT 
//


package com.s3.sap.z_taxa_cambio_sap;

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
 *         &lt;element name="RegistrosMoeda" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="RegistrosTaxa" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="Retorno" type="{urn:sap-com:document:sap:rfc:functions}char70"/&gt;
 *         &lt;element name="TabMoeda" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeMoedaWebs" minOccurs="0"/&gt;
 *         &lt;element name="TabTaxa" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeTaxaCambioWebs" minOccurs="0"/&gt;
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
    "registrosMoeda",
    "registrosTaxa",
    "retorno",
    "tabMoeda",
    "tabTaxa"
})
@XmlRootElement(name = "ZbcTaxaCambioArtWebsResponse")
public class ZbcTaxaCambioArtWebsResponse {

    @XmlElement(name = "RegistrosMoeda", required = true)
    protected String registrosMoeda;
    @XmlElement(name = "RegistrosTaxa", required = true)
    protected String registrosTaxa;
    @XmlElement(name = "Retorno", required = true)
    protected String retorno;
    @XmlElement(name = "TabMoeda")
    protected TableOfZsdeMoedaWebs tabMoeda;
    @XmlElement(name = "TabTaxa")
    protected TableOfZsdeTaxaCambioWebs tabTaxa;

    /**
     * Obtém o valor da propriedade registrosMoeda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrosMoeda() {
        return registrosMoeda;
    }

    /**
     * Define o valor da propriedade registrosMoeda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrosMoeda(String value) {
        this.registrosMoeda = value;
    }

    /**
     * Obtém o valor da propriedade registrosTaxa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrosTaxa() {
        return registrosTaxa;
    }

    /**
     * Define o valor da propriedade registrosTaxa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrosTaxa(String value) {
        this.registrosTaxa = value;
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
     * Obtém o valor da propriedade tabMoeda.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeMoedaWebs }
     *     
     */
    public TableOfZsdeMoedaWebs getTabMoeda() {
        return tabMoeda;
    }

    /**
     * Define o valor da propriedade tabMoeda.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeMoedaWebs }
     *     
     */
    public void setTabMoeda(TableOfZsdeMoedaWebs value) {
        this.tabMoeda = value;
    }

    /**
     * Obtém o valor da propriedade tabTaxa.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeTaxaCambioWebs }
     *     
     */
    public TableOfZsdeTaxaCambioWebs getTabTaxa() {
        return tabTaxa;
    }

    /**
     * Define o valor da propriedade tabTaxa.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeTaxaCambioWebs }
     *     
     */
    public void setTabTaxa(TableOfZsdeTaxaCambioWebs value) {
        this.tabTaxa = value;
    }

}

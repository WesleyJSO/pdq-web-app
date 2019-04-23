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
 *         &lt;element name="IChAcesso" type="{urn:sap-com:document:sap:rfc:functions}char15" minOccurs="0"/&gt;
 *         &lt;element name="IData" type="{urn:sap-com:document:sap:rfc:functions}numeric8" minOccurs="0"/&gt;
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
    "iChAcesso",
    "iData",
    "tabMoeda",
    "tabTaxa"
})
@XmlRootElement(name = "ZbcTaxaCambioArtWebs")
public class ZbcTaxaCambioArtWebs {

    @XmlElement(name = "IChAcesso")
    protected String iChAcesso;
    @XmlElement(name = "IData")
    protected String iData;
    @XmlElement(name = "TabMoeda")
    protected TableOfZsdeMoedaWebs tabMoeda;
    @XmlElement(name = "TabTaxa")
    protected TableOfZsdeTaxaCambioWebs tabTaxa;

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
     * Obtém o valor da propriedade iData.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIData() {
        return iData;
    }

    /**
     * Define o valor da propriedade iData.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIData(String value) {
        this.iData = value;
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

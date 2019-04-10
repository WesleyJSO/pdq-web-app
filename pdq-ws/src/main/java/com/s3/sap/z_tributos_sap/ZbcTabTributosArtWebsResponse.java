//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:50:32 PM BRT 
//


package com.s3.sap.z_tributos_sap;

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
 *         &lt;element name="RegistrosCofins" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="RegistrosIcms" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="RegistrosPis" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="Retorno" type="{urn:sap-com:document:sap:rfc:functions}char70"/&gt;
 *         &lt;element name="TabCofins" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeCofinsWebs" minOccurs="0"/&gt;
 *         &lt;element name="TabIcms" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeIcmsWebs" minOccurs="0"/&gt;
 *         &lt;element name="TabPis" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdePisWebs" minOccurs="0"/&gt;
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
    "registrosCofins",
    "registrosIcms",
    "registrosPis",
    "retorno",
    "tabCofins",
    "tabIcms",
    "tabPis"
})
@XmlRootElement(name = "ZbcTabTributosArtWebsResponse")
public class ZbcTabTributosArtWebsResponse {

    @XmlElement(name = "RegistrosCofins", required = true)
    protected String registrosCofins;
    @XmlElement(name = "RegistrosIcms", required = true)
    protected String registrosIcms;
    @XmlElement(name = "RegistrosPis", required = true)
    protected String registrosPis;
    @XmlElement(name = "Retorno", required = true)
    protected String retorno;
    @XmlElement(name = "TabCofins")
    protected TableOfZsdeCofinsWebs tabCofins;
    @XmlElement(name = "TabIcms")
    protected TableOfZsdeIcmsWebs tabIcms;
    @XmlElement(name = "TabPis")
    protected TableOfZsdePisWebs tabPis;

    /**
     * Obtém o valor da propriedade registrosCofins.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrosCofins() {
        return registrosCofins;
    }

    /**
     * Define o valor da propriedade registrosCofins.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrosCofins(String value) {
        this.registrosCofins = value;
    }

    /**
     * Obtém o valor da propriedade registrosIcms.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrosIcms() {
        return registrosIcms;
    }

    /**
     * Define o valor da propriedade registrosIcms.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrosIcms(String value) {
        this.registrosIcms = value;
    }

    /**
     * Obtém o valor da propriedade registrosPis.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrosPis() {
        return registrosPis;
    }

    /**
     * Define o valor da propriedade registrosPis.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrosPis(String value) {
        this.registrosPis = value;
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
     * Obtém o valor da propriedade tabCofins.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeCofinsWebs }
     *     
     */
    public TableOfZsdeCofinsWebs getTabCofins() {
        return tabCofins;
    }

    /**
     * Define o valor da propriedade tabCofins.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeCofinsWebs }
     *     
     */
    public void setTabCofins(TableOfZsdeCofinsWebs value) {
        this.tabCofins = value;
    }

    /**
     * Obtém o valor da propriedade tabIcms.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeIcmsWebs }
     *     
     */
    public TableOfZsdeIcmsWebs getTabIcms() {
        return tabIcms;
    }

    /**
     * Define o valor da propriedade tabIcms.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeIcmsWebs }
     *     
     */
    public void setTabIcms(TableOfZsdeIcmsWebs value) {
        this.tabIcms = value;
    }

    /**
     * Obtém o valor da propriedade tabPis.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdePisWebs }
     *     
     */
    public TableOfZsdePisWebs getTabPis() {
        return tabPis;
    }

    /**
     * Define o valor da propriedade tabPis.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdePisWebs }
     *     
     */
    public void setTabPis(TableOfZsdePisWebs value) {
        this.tabPis = value;
    }

}

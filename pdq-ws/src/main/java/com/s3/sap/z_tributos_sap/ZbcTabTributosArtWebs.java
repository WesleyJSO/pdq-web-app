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
 *         &lt;element name="IChAcesso" type="{urn:sap-com:document:sap:rfc:functions}char15" minOccurs="0"/&gt;
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
    "iChAcesso",
    "tabCofins",
    "tabIcms",
    "tabPis"
})
@XmlRootElement(name = "ZbcTabTributosArtWebs")
public class ZbcTabTributosArtWebs {

    @XmlElement(name = "IChAcesso")
    protected String iChAcesso;
    @XmlElement(name = "TabCofins")
    protected TableOfZsdeCofinsWebs tabCofins;
    @XmlElement(name = "TabIcms")
    protected TableOfZsdeIcmsWebs tabIcms;
    @XmlElement(name = "TabPis")
    protected TableOfZsdePisWebs tabPis;

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

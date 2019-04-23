//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:49:32 PM BRT 
//


package com.s3.sap.z_cad_estrut_venda_sap;

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
 *         &lt;element name="RegistrosCanal" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="RegistrosEscr" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="RegistrosOrg" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="RegistrosSetAtiv" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="Retorno" type="{urn:sap-com:document:sap:rfc:functions}char70"/&gt;
 *         &lt;element name="TabCanalDistr" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeCanalDistrWebs" minOccurs="0"/&gt;
 *         &lt;element name="TabEscrVenda" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeEscrVendaWebs" minOccurs="0"/&gt;
 *         &lt;element name="TabOrgVenda" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeOrgVendaWebs" minOccurs="0"/&gt;
 *         &lt;element name="TabSetAtiv" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeSetorAtivWebs" minOccurs="0"/&gt;
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
    "registrosCanal",
    "registrosEscr",
    "registrosOrg",
    "registrosSetAtiv",
    "retorno",
    "tabCanalDistr",
    "tabEscrVenda",
    "tabOrgVenda",
    "tabSetAtiv"
})
@XmlRootElement(name = "ZbcCadEstrutVendaArtWebsResponse")
public class ZbcCadEstrutVendaArtWebsResponse {

    @XmlElement(name = "RegistrosCanal", required = true)
    protected String registrosCanal;
    @XmlElement(name = "RegistrosEscr", required = true)
    protected String registrosEscr;
    @XmlElement(name = "RegistrosOrg", required = true)
    protected String registrosOrg;
    @XmlElement(name = "RegistrosSetAtiv", required = true)
    protected String registrosSetAtiv;
    @XmlElement(name = "Retorno", required = true)
    protected String retorno;
    @XmlElement(name = "TabCanalDistr")
    protected TableOfZsdeCanalDistrWebs tabCanalDistr;
    @XmlElement(name = "TabEscrVenda")
    protected TableOfZsdeEscrVendaWebs tabEscrVenda;
    @XmlElement(name = "TabOrgVenda")
    protected TableOfZsdeOrgVendaWebs tabOrgVenda;
    @XmlElement(name = "TabSetAtiv")
    protected TableOfZsdeSetorAtivWebs tabSetAtiv;

    /**
     * Obtém o valor da propriedade registrosCanal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrosCanal() {
        return registrosCanal;
    }

    /**
     * Define o valor da propriedade registrosCanal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrosCanal(String value) {
        this.registrosCanal = value;
    }

    /**
     * Obtém o valor da propriedade registrosEscr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrosEscr() {
        return registrosEscr;
    }

    /**
     * Define o valor da propriedade registrosEscr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrosEscr(String value) {
        this.registrosEscr = value;
    }

    /**
     * Obtém o valor da propriedade registrosOrg.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrosOrg() {
        return registrosOrg;
    }

    /**
     * Define o valor da propriedade registrosOrg.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrosOrg(String value) {
        this.registrosOrg = value;
    }

    /**
     * Obtém o valor da propriedade registrosSetAtiv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrosSetAtiv() {
        return registrosSetAtiv;
    }

    /**
     * Define o valor da propriedade registrosSetAtiv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrosSetAtiv(String value) {
        this.registrosSetAtiv = value;
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
     * Obtém o valor da propriedade tabCanalDistr.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeCanalDistrWebs }
     *     
     */
    public TableOfZsdeCanalDistrWebs getTabCanalDistr() {
        return tabCanalDistr;
    }

    /**
     * Define o valor da propriedade tabCanalDistr.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeCanalDistrWebs }
     *     
     */
    public void setTabCanalDistr(TableOfZsdeCanalDistrWebs value) {
        this.tabCanalDistr = value;
    }

    /**
     * Obtém o valor da propriedade tabEscrVenda.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeEscrVendaWebs }
     *     
     */
    public TableOfZsdeEscrVendaWebs getTabEscrVenda() {
        return tabEscrVenda;
    }

    /**
     * Define o valor da propriedade tabEscrVenda.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeEscrVendaWebs }
     *     
     */
    public void setTabEscrVenda(TableOfZsdeEscrVendaWebs value) {
        this.tabEscrVenda = value;
    }

    /**
     * Obtém o valor da propriedade tabOrgVenda.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeOrgVendaWebs }
     *     
     */
    public TableOfZsdeOrgVendaWebs getTabOrgVenda() {
        return tabOrgVenda;
    }

    /**
     * Define o valor da propriedade tabOrgVenda.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeOrgVendaWebs }
     *     
     */
    public void setTabOrgVenda(TableOfZsdeOrgVendaWebs value) {
        this.tabOrgVenda = value;
    }

    /**
     * Obtém o valor da propriedade tabSetAtiv.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeSetorAtivWebs }
     *     
     */
    public TableOfZsdeSetorAtivWebs getTabSetAtiv() {
        return tabSetAtiv;
    }

    /**
     * Define o valor da propriedade tabSetAtiv.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeSetorAtivWebs }
     *     
     */
    public void setTabSetAtiv(TableOfZsdeSetorAtivWebs value) {
        this.tabSetAtiv = value;
    }

}

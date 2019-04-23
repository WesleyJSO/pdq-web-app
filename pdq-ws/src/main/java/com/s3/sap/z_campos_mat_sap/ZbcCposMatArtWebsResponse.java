//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:47:39 PM BRT 
//


package com.s3.sap.z_campos_mat_sap;

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
 *         &lt;element name="RegistrosCfop" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="RegistrosGrM" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="RegistrosLinha" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="RegistrosOrigM" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="RegistrosTpMat" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="Retorno" type="{urn:sap-com:document:sap:rfc:functions}char70"/&gt;
 *         &lt;element name="TabCfop" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeCatCfopWebs" minOccurs="0"/&gt;
 *         &lt;element name="TabGrMerc" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeGrMercWebs" minOccurs="0"/&gt;
 *         &lt;element name="TabLinha" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeLinhaMatWebs" minOccurs="0"/&gt;
 *         &lt;element name="TabOrigM" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeOrigMatWebs" minOccurs="0"/&gt;
 *         &lt;element name="TabTpMat" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeMtartWebs" minOccurs="0"/&gt;
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
    "registrosCfop",
    "registrosGrM",
    "registrosLinha",
    "registrosOrigM",
    "registrosTpMat",
    "retorno",
    "tabCfop",
    "tabGrMerc",
    "tabLinha",
    "tabOrigM",
    "tabTpMat"
})
@XmlRootElement(name = "ZbcCposMatArtWebsResponse")
public class ZbcCposMatArtWebsResponse {

    @XmlElement(name = "RegistrosCfop", required = true)
    protected String registrosCfop;
    @XmlElement(name = "RegistrosGrM", required = true)
    protected String registrosGrM;
    @XmlElement(name = "RegistrosLinha", required = true)
    protected String registrosLinha;
    @XmlElement(name = "RegistrosOrigM", required = true)
    protected String registrosOrigM;
    @XmlElement(name = "RegistrosTpMat", required = true)
    protected String registrosTpMat;
    @XmlElement(name = "Retorno", required = true)
    protected String retorno;
    @XmlElement(name = "TabCfop")
    protected TableOfZsdeCatCfopWebs tabCfop;
    @XmlElement(name = "TabGrMerc")
    protected TableOfZsdeGrMercWebs tabGrMerc;
    @XmlElement(name = "TabLinha")
    protected TableOfZsdeLinhaMatWebs tabLinha;
    @XmlElement(name = "TabOrigM")
    protected TableOfZsdeOrigMatWebs tabOrigM;
    @XmlElement(name = "TabTpMat")
    protected TableOfZsdeMtartWebs tabTpMat;

    /**
     * Obtém o valor da propriedade registrosCfop.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrosCfop() {
        return registrosCfop;
    }

    /**
     * Define o valor da propriedade registrosCfop.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrosCfop(String value) {
        this.registrosCfop = value;
    }

    /**
     * Obtém o valor da propriedade registrosGrM.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrosGrM() {
        return registrosGrM;
    }

    /**
     * Define o valor da propriedade registrosGrM.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrosGrM(String value) {
        this.registrosGrM = value;
    }

    /**
     * Obtém o valor da propriedade registrosLinha.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrosLinha() {
        return registrosLinha;
    }

    /**
     * Define o valor da propriedade registrosLinha.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrosLinha(String value) {
        this.registrosLinha = value;
    }

    /**
     * Obtém o valor da propriedade registrosOrigM.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrosOrigM() {
        return registrosOrigM;
    }

    /**
     * Define o valor da propriedade registrosOrigM.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrosOrigM(String value) {
        this.registrosOrigM = value;
    }

    /**
     * Obtém o valor da propriedade registrosTpMat.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrosTpMat() {
        return registrosTpMat;
    }

    /**
     * Define o valor da propriedade registrosTpMat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrosTpMat(String value) {
        this.registrosTpMat = value;
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
     * Obtém o valor da propriedade tabCfop.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeCatCfopWebs }
     *     
     */
    public TableOfZsdeCatCfopWebs getTabCfop() {
        return tabCfop;
    }

    /**
     * Define o valor da propriedade tabCfop.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeCatCfopWebs }
     *     
     */
    public void setTabCfop(TableOfZsdeCatCfopWebs value) {
        this.tabCfop = value;
    }

    /**
     * Obtém o valor da propriedade tabGrMerc.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeGrMercWebs }
     *     
     */
    public TableOfZsdeGrMercWebs getTabGrMerc() {
        return tabGrMerc;
    }

    /**
     * Define o valor da propriedade tabGrMerc.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeGrMercWebs }
     *     
     */
    public void setTabGrMerc(TableOfZsdeGrMercWebs value) {
        this.tabGrMerc = value;
    }

    /**
     * Obtém o valor da propriedade tabLinha.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeLinhaMatWebs }
     *     
     */
    public TableOfZsdeLinhaMatWebs getTabLinha() {
        return tabLinha;
    }

    /**
     * Define o valor da propriedade tabLinha.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeLinhaMatWebs }
     *     
     */
    public void setTabLinha(TableOfZsdeLinhaMatWebs value) {
        this.tabLinha = value;
    }

    /**
     * Obtém o valor da propriedade tabOrigM.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeOrigMatWebs }
     *     
     */
    public TableOfZsdeOrigMatWebs getTabOrigM() {
        return tabOrigM;
    }

    /**
     * Define o valor da propriedade tabOrigM.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeOrigMatWebs }
     *     
     */
    public void setTabOrigM(TableOfZsdeOrigMatWebs value) {
        this.tabOrigM = value;
    }

    /**
     * Obtém o valor da propriedade tabTpMat.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeMtartWebs }
     *     
     */
    public TableOfZsdeMtartWebs getTabTpMat() {
        return tabTpMat;
    }

    /**
     * Define o valor da propriedade tabTpMat.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeMtartWebs }
     *     
     */
    public void setTabTpMat(TableOfZsdeMtartWebs value) {
        this.tabTpMat = value;
    }

}

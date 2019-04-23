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
 *         &lt;element name="IChAcesso" type="{urn:sap-com:document:sap:rfc:functions}char15" minOccurs="0"/&gt;
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
    "iChAcesso",
    "tabCfop",
    "tabGrMerc",
    "tabLinha",
    "tabOrigM",
    "tabTpMat"
})
@XmlRootElement(name = "ZbcCposMatArtWebs")
public class ZbcCposMatArtWebs {

    @XmlElement(name = "IChAcesso")
    protected String iChAcesso;
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

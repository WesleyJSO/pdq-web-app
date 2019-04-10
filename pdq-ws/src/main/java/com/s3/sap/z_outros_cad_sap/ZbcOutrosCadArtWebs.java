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
 *         &lt;element name="TabCidade" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeCidadeWebs" minOccurs="0"/&gt;
 *         &lt;element name="TabConvUnid" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeConvUnidWebs" minOccurs="0"/&gt;
 *         &lt;element name="TabGrConta" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeGrCtaCliWebs" minOccurs="0"/&gt;
 *         &lt;element name="TabMotivo" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeMotivoWebs" minOccurs="0"/&gt;
 *         &lt;element name="TabSetInd" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeSetIndWebs" minOccurs="0"/&gt;
 *         &lt;element name="TabTpPed" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeTpOrdemWebs" minOccurs="0"/&gt;
 *         &lt;element name="TabUnidade" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeUnidadeWebs" minOccurs="0"/&gt;
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
    "tabCidade",
    "tabConvUnid",
    "tabGrConta",
    "tabMotivo",
    "tabSetInd",
    "tabTpPed",
    "tabUnidade"
})
@XmlRootElement(name = "ZbcOutrosCadArtWebs")
public class ZbcOutrosCadArtWebs {

    @XmlElement(name = "IChAcesso")
    protected String iChAcesso;
    @XmlElement(name = "TabCidade")
    protected TableOfZsdeCidadeWebs tabCidade;
    @XmlElement(name = "TabConvUnid")
    protected TableOfZsdeConvUnidWebs tabConvUnid;
    @XmlElement(name = "TabGrConta")
    protected TableOfZsdeGrCtaCliWebs tabGrConta;
    @XmlElement(name = "TabMotivo")
    protected TableOfZsdeMotivoWebs tabMotivo;
    @XmlElement(name = "TabSetInd")
    protected TableOfZsdeSetIndWebs tabSetInd;
    @XmlElement(name = "TabTpPed")
    protected TableOfZsdeTpOrdemWebs tabTpPed;
    @XmlElement(name = "TabUnidade")
    protected TableOfZsdeUnidadeWebs tabUnidade;

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
     * Obtém o valor da propriedade tabCidade.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeCidadeWebs }
     *     
     */
    public TableOfZsdeCidadeWebs getTabCidade() {
        return tabCidade;
    }

    /**
     * Define o valor da propriedade tabCidade.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeCidadeWebs }
     *     
     */
    public void setTabCidade(TableOfZsdeCidadeWebs value) {
        this.tabCidade = value;
    }

    /**
     * Obtém o valor da propriedade tabConvUnid.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeConvUnidWebs }
     *     
     */
    public TableOfZsdeConvUnidWebs getTabConvUnid() {
        return tabConvUnid;
    }

    /**
     * Define o valor da propriedade tabConvUnid.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeConvUnidWebs }
     *     
     */
    public void setTabConvUnid(TableOfZsdeConvUnidWebs value) {
        this.tabConvUnid = value;
    }

    /**
     * Obtém o valor da propriedade tabGrConta.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeGrCtaCliWebs }
     *     
     */
    public TableOfZsdeGrCtaCliWebs getTabGrConta() {
        return tabGrConta;
    }

    /**
     * Define o valor da propriedade tabGrConta.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeGrCtaCliWebs }
     *     
     */
    public void setTabGrConta(TableOfZsdeGrCtaCliWebs value) {
        this.tabGrConta = value;
    }

    /**
     * Obtém o valor da propriedade tabMotivo.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeMotivoWebs }
     *     
     */
    public TableOfZsdeMotivoWebs getTabMotivo() {
        return tabMotivo;
    }

    /**
     * Define o valor da propriedade tabMotivo.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeMotivoWebs }
     *     
     */
    public void setTabMotivo(TableOfZsdeMotivoWebs value) {
        this.tabMotivo = value;
    }

    /**
     * Obtém o valor da propriedade tabSetInd.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeSetIndWebs }
     *     
     */
    public TableOfZsdeSetIndWebs getTabSetInd() {
        return tabSetInd;
    }

    /**
     * Define o valor da propriedade tabSetInd.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeSetIndWebs }
     *     
     */
    public void setTabSetInd(TableOfZsdeSetIndWebs value) {
        this.tabSetInd = value;
    }

    /**
     * Obtém o valor da propriedade tabTpPed.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeTpOrdemWebs }
     *     
     */
    public TableOfZsdeTpOrdemWebs getTabTpPed() {
        return tabTpPed;
    }

    /**
     * Define o valor da propriedade tabTpPed.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeTpOrdemWebs }
     *     
     */
    public void setTabTpPed(TableOfZsdeTpOrdemWebs value) {
        this.tabTpPed = value;
    }

    /**
     * Obtém o valor da propriedade tabUnidade.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeUnidadeWebs }
     *     
     */
    public TableOfZsdeUnidadeWebs getTabUnidade() {
        return tabUnidade;
    }

    /**
     * Define o valor da propriedade tabUnidade.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeUnidadeWebs }
     *     
     */
    public void setTabUnidade(TableOfZsdeUnidadeWebs value) {
        this.tabUnidade = value;
    }

}

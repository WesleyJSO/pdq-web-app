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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ZsdeTaxaCambioWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeTaxaCambioWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CdCategoria" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="CdMoedaDe" type="{urn:sap-com:document:sap:rfc:functions}cuky5"/&gt;
 *         &lt;element name="CdMoedaPara" type="{urn:sap-com:document:sap:rfc:functions}cuky5"/&gt;
 *         &lt;element name="DtCambio" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="VlTaxa" type="{urn:sap-com:document:sap:rfc:functions}numeric9"/&gt;
 *         &lt;element name="VlFatDe" type="{urn:sap-com:document:sap:rfc:functions}numeric9"/&gt;
 *         &lt;element name="VlFatPara" type="{urn:sap-com:document:sap:rfc:functions}numeric9"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeTaxaCambioWebs", propOrder = {
    "cdCategoria",
    "cdMoedaDe",
    "cdMoedaPara",
    "dtCambio",
    "vlTaxa",
    "vlFatDe",
    "vlFatPara"
})
public class ZsdeTaxaCambioWebs {

    @XmlElement(name = "CdCategoria", required = true)
    protected String cdCategoria;
    @XmlElement(name = "CdMoedaDe", required = true)
    protected String cdMoedaDe;
    @XmlElement(name = "CdMoedaPara", required = true)
    protected String cdMoedaPara;
    @XmlElement(name = "DtCambio", required = true)
    protected String dtCambio;
    @XmlElement(name = "VlTaxa", required = true)
    protected String vlTaxa;
    @XmlElement(name = "VlFatDe", required = true)
    protected String vlFatDe;
    @XmlElement(name = "VlFatPara", required = true)
    protected String vlFatPara;

    /**
     * Obtém o valor da propriedade cdCategoria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdCategoria() {
        return cdCategoria;
    }

    /**
     * Define o valor da propriedade cdCategoria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdCategoria(String value) {
        this.cdCategoria = value;
    }

    /**
     * Obtém o valor da propriedade cdMoedaDe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdMoedaDe() {
        return cdMoedaDe;
    }

    /**
     * Define o valor da propriedade cdMoedaDe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdMoedaDe(String value) {
        this.cdMoedaDe = value;
    }

    /**
     * Obtém o valor da propriedade cdMoedaPara.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdMoedaPara() {
        return cdMoedaPara;
    }

    /**
     * Define o valor da propriedade cdMoedaPara.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdMoedaPara(String value) {
        this.cdMoedaPara = value;
    }

    /**
     * Obtém o valor da propriedade dtCambio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtCambio() {
        return dtCambio;
    }

    /**
     * Define o valor da propriedade dtCambio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtCambio(String value) {
        this.dtCambio = value;
    }

    /**
     * Obtém o valor da propriedade vlTaxa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVlTaxa() {
        return vlTaxa;
    }

    /**
     * Define o valor da propriedade vlTaxa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVlTaxa(String value) {
        this.vlTaxa = value;
    }

    /**
     * Obtém o valor da propriedade vlFatDe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVlFatDe() {
        return vlFatDe;
    }

    /**
     * Define o valor da propriedade vlFatDe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVlFatDe(String value) {
        this.vlFatDe = value;
    }

    /**
     * Obtém o valor da propriedade vlFatPara.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVlFatPara() {
        return vlFatPara;
    }

    /**
     * Define o valor da propriedade vlFatPara.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVlFatPara(String value) {
        this.vlFatPara = value;
    }

}

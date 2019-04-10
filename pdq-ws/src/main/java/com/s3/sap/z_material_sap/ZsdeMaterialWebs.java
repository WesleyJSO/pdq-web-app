//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:50:30 PM BRT 
//


package com.s3.sap.z_material_sap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ZsdeMaterialWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeMaterialWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TpRegistro" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="CdCentro" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="DcCentro" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *         &lt;element name="CdOrgVenda" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="CdCanalDistr" type="{urn:sap-com:document:sap:rfc:functions}char2"/&gt;
 *         &lt;element name="CdMaterial" type="{urn:sap-com:document:sap:rfc:functions}char18"/&gt;
 *         &lt;element name="DcMaterial" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="CdSetAtiv" type="{urn:sap-com:document:sap:rfc:functions}char2"/&gt;
 *         &lt;element name="UnMedBasica" type="{urn:sap-com:document:sap:rfc:functions}unit3"/&gt;
 *         &lt;element name="TpMaterial" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="GrMercadoria" type="{urn:sap-com:document:sap:rfc:functions}char9"/&gt;
 *         &lt;element name="PesoBruto" type="{urn:sap-com:document:sap:rfc:functions}numeric20"/&gt;
 *         &lt;element name="PesoLiquido" type="{urn:sap-com:document:sap:rfc:functions}numeric20"/&gt;
 *         &lt;element name="UnMedPeso" type="{urn:sap-com:document:sap:rfc:functions}unit3"/&gt;
 *         &lt;element name="Volume" type="{urn:sap-com:document:sap:rfc:functions}numeric20"/&gt;
 *         &lt;element name="UnMedVolume" type="{urn:sap-com:document:sap:rfc:functions}unit3"/&gt;
 *         &lt;element name="UnMedVenda" type="{urn:sap-com:document:sap:rfc:functions}unit3"/&gt;
 *         &lt;element name="CdNcm" type="{urn:sap-com:document:sap:rfc:functions}char16"/&gt;
 *         &lt;element name="CdCatCfop" type="{urn:sap-com:document:sap:rfc:functions}char2"/&gt;
 *         &lt;element name="CdOrigMat" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeMaterialWebs", propOrder = {
    "tpRegistro",
    "cdCentro",
    "dcCentro",
    "cdOrgVenda",
    "cdCanalDistr",
    "cdMaterial",
    "dcMaterial",
    "cdSetAtiv",
    "unMedBasica",
    "tpMaterial",
    "grMercadoria",
    "pesoBruto",
    "pesoLiquido",
    "unMedPeso",
    "volume",
    "unMedVolume",
    "unMedVenda",
    "cdNcm",
    "cdCatCfop",
    "cdOrigMat"
})
public class ZsdeMaterialWebs {

    @XmlElement(name = "TpRegistro", required = true)
    protected String tpRegistro;
    @XmlElement(name = "CdCentro", required = true)
    protected String cdCentro;
    @XmlElement(name = "DcCentro", required = true)
    protected String dcCentro;
    @XmlElement(name = "CdOrgVenda", required = true)
    protected String cdOrgVenda;
    @XmlElement(name = "CdCanalDistr", required = true)
    protected String cdCanalDistr;
    @XmlElement(name = "CdMaterial", required = true)
    protected String cdMaterial;
    @XmlElement(name = "DcMaterial", required = true)
    protected String dcMaterial;
    @XmlElement(name = "CdSetAtiv", required = true)
    protected String cdSetAtiv;
    @XmlElement(name = "UnMedBasica", required = true)
    protected String unMedBasica;
    @XmlElement(name = "TpMaterial", required = true)
    protected String tpMaterial;
    @XmlElement(name = "GrMercadoria", required = true)
    protected String grMercadoria;
    @XmlElement(name = "PesoBruto", required = true)
    protected String pesoBruto;
    @XmlElement(name = "PesoLiquido", required = true)
    protected String pesoLiquido;
    @XmlElement(name = "UnMedPeso", required = true)
    protected String unMedPeso;
    @XmlElement(name = "Volume", required = true)
    protected String volume;
    @XmlElement(name = "UnMedVolume", required = true)
    protected String unMedVolume;
    @XmlElement(name = "UnMedVenda", required = true)
    protected String unMedVenda;
    @XmlElement(name = "CdNcm", required = true)
    protected String cdNcm;
    @XmlElement(name = "CdCatCfop", required = true)
    protected String cdCatCfop;
    @XmlElement(name = "CdOrigMat", required = true)
    protected String cdOrigMat;

    /**
     * Obtém o valor da propriedade tpRegistro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpRegistro() {
        return tpRegistro;
    }

    /**
     * Define o valor da propriedade tpRegistro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpRegistro(String value) {
        this.tpRegistro = value;
    }

    /**
     * Obtém o valor da propriedade cdCentro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdCentro() {
        return cdCentro;
    }

    /**
     * Define o valor da propriedade cdCentro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdCentro(String value) {
        this.cdCentro = value;
    }

    /**
     * Obtém o valor da propriedade dcCentro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcCentro() {
        return dcCentro;
    }

    /**
     * Define o valor da propriedade dcCentro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcCentro(String value) {
        this.dcCentro = value;
    }

    /**
     * Obtém o valor da propriedade cdOrgVenda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdOrgVenda() {
        return cdOrgVenda;
    }

    /**
     * Define o valor da propriedade cdOrgVenda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdOrgVenda(String value) {
        this.cdOrgVenda = value;
    }

    /**
     * Obtém o valor da propriedade cdCanalDistr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdCanalDistr() {
        return cdCanalDistr;
    }

    /**
     * Define o valor da propriedade cdCanalDistr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdCanalDistr(String value) {
        this.cdCanalDistr = value;
    }

    /**
     * Obtém o valor da propriedade cdMaterial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdMaterial() {
        return cdMaterial;
    }

    /**
     * Define o valor da propriedade cdMaterial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdMaterial(String value) {
        this.cdMaterial = value;
    }

    /**
     * Obtém o valor da propriedade dcMaterial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcMaterial() {
        return dcMaterial;
    }

    /**
     * Define o valor da propriedade dcMaterial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcMaterial(String value) {
        this.dcMaterial = value;
    }

    /**
     * Obtém o valor da propriedade cdSetAtiv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdSetAtiv() {
        return cdSetAtiv;
    }

    /**
     * Define o valor da propriedade cdSetAtiv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdSetAtiv(String value) {
        this.cdSetAtiv = value;
    }

    /**
     * Obtém o valor da propriedade unMedBasica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnMedBasica() {
        return unMedBasica;
    }

    /**
     * Define o valor da propriedade unMedBasica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnMedBasica(String value) {
        this.unMedBasica = value;
    }

    /**
     * Obtém o valor da propriedade tpMaterial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpMaterial() {
        return tpMaterial;
    }

    /**
     * Define o valor da propriedade tpMaterial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpMaterial(String value) {
        this.tpMaterial = value;
    }

    /**
     * Obtém o valor da propriedade grMercadoria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrMercadoria() {
        return grMercadoria;
    }

    /**
     * Define o valor da propriedade grMercadoria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrMercadoria(String value) {
        this.grMercadoria = value;
    }

    /**
     * Obtém o valor da propriedade pesoBruto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPesoBruto() {
        return pesoBruto;
    }

    /**
     * Define o valor da propriedade pesoBruto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPesoBruto(String value) {
        this.pesoBruto = value;
    }

    /**
     * Obtém o valor da propriedade pesoLiquido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPesoLiquido() {
        return pesoLiquido;
    }

    /**
     * Define o valor da propriedade pesoLiquido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPesoLiquido(String value) {
        this.pesoLiquido = value;
    }

    /**
     * Obtém o valor da propriedade unMedPeso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnMedPeso() {
        return unMedPeso;
    }

    /**
     * Define o valor da propriedade unMedPeso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnMedPeso(String value) {
        this.unMedPeso = value;
    }

    /**
     * Obtém o valor da propriedade volume.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVolume() {
        return volume;
    }

    /**
     * Define o valor da propriedade volume.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVolume(String value) {
        this.volume = value;
    }

    /**
     * Obtém o valor da propriedade unMedVolume.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnMedVolume() {
        return unMedVolume;
    }

    /**
     * Define o valor da propriedade unMedVolume.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnMedVolume(String value) {
        this.unMedVolume = value;
    }

    /**
     * Obtém o valor da propriedade unMedVenda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnMedVenda() {
        return unMedVenda;
    }

    /**
     * Define o valor da propriedade unMedVenda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnMedVenda(String value) {
        this.unMedVenda = value;
    }

    /**
     * Obtém o valor da propriedade cdNcm.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdNcm() {
        return cdNcm;
    }

    /**
     * Define o valor da propriedade cdNcm.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdNcm(String value) {
        this.cdNcm = value;
    }

    /**
     * Obtém o valor da propriedade cdCatCfop.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdCatCfop() {
        return cdCatCfop;
    }

    /**
     * Define o valor da propriedade cdCatCfop.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdCatCfop(String value) {
        this.cdCatCfop = value;
    }

    /**
     * Obtém o valor da propriedade cdOrigMat.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdOrigMat() {
        return cdOrigMat;
    }

    /**
     * Define o valor da propriedade cdOrigMat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdOrigMat(String value) {
        this.cdOrigMat = value;
    }

}

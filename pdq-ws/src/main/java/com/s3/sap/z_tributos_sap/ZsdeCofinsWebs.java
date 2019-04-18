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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ZsdeCofinsWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeCofinsWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Pais" type="{urn:sap-com:document:sap:rfc:functions}char3"/&gt;
 *         &lt;element name="GrupoSap" type="{urn:sap-com:document:sap:rfc:functions}numeric2"/&gt;
 *         &lt;element name="DtIniValid" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="DtFimValid" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="GrMercadoria" type="{urn:sap-com:document:sap:rfc:functions}char20"/&gt;
 *         &lt;element name="CdSetInd" type="{urn:sap-com:document:sap:rfc:functions}char20"/&gt;
 *         &lt;element name="CdOrigMat" type="{urn:sap-com:document:sap:rfc:functions}char20"/&gt;
 *         &lt;element name="CdCliente" type="{urn:sap-com:document:sap:rfc:functions}char20"/&gt;
 *         &lt;element name="CdMaterial" type="{urn:sap-com:document:sap:rfc:functions}char20"/&gt;
 *         &lt;element name="Base" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="Taxa" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="RegUnid" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="NumUnid" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="Unidade" type="{urn:sap-com:document:sap:rfc:functions}char3"/&gt;
 *         &lt;element name="CdMoeda" type="{urn:sap-com:document:sap:rfc:functions}cuky5"/&gt;
 *         &lt;element name="LeiTrib" type="{urn:sap-com:document:sap:rfc:functions}char3"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeCofinsWebs", propOrder = {
    "pais",
    "grupoSap",
    "dtIniValid",
    "dtFimValid",
    "grMercadoria",
    "cdSetInd",
    "cdOrigMat",
    "cdCliente",
    "cdMaterial",
    "base",
    "taxa",
    "regUnid",
    "numUnid",
    "unidade",
    "cdMoeda",
    "leiTrib"
})
public class ZsdeCofinsWebs {

    @XmlElement(name = "Pais", required = true)
    protected String pais;
    @XmlElement(name = "GrupoSap", required = true)
    protected String grupoSap;
    @XmlElement(name = "DtIniValid", required = true)
    protected String dtIniValid;
    @XmlElement(name = "DtFimValid", required = true)
    protected String dtFimValid;
    @XmlElement(name = "GrMercadoria", required = true)
    protected String grMercadoria;
    @XmlElement(name = "CdSetInd", required = true)
    protected String cdSetInd;
    @XmlElement(name = "CdOrigMat", required = true)
    protected String cdOrigMat;
    @XmlElement(name = "CdCliente", required = true)
    protected String cdCliente;
    @XmlElement(name = "CdMaterial", required = true)
    protected String cdMaterial;
    @XmlElement(name = "Base", required = true)
    protected String base;
    @XmlElement(name = "Taxa", required = true)
    protected String taxa;
    @XmlElement(name = "RegUnid", required = true)
    protected String regUnid;
    @XmlElement(name = "NumUnid", required = true)
    protected String numUnid;
    @XmlElement(name = "Unidade", required = true)
    protected String unidade;
    @XmlElement(name = "CdMoeda", required = true)
    protected String cdMoeda;
    @XmlElement(name = "LeiTrib", required = true)
    protected String leiTrib;

    /**
     * Obtém o valor da propriedade pais.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPais() {
        return pais;
    }

    /**
     * Define o valor da propriedade pais.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPais(String value) {
        this.pais = value;
    }

    /**
     * Obtém o valor da propriedade grupoSap.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrupoSap() {
        return grupoSap;
    }

    /**
     * Define o valor da propriedade grupoSap.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrupoSap(String value) {
        this.grupoSap = value;
    }

    /**
     * Obtém o valor da propriedade dtIniValid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtIniValid() {
        return dtIniValid;
    }

    /**
     * Define o valor da propriedade dtIniValid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtIniValid(String value) {
        this.dtIniValid = value;
    }

    /**
     * Obtém o valor da propriedade dtFimValid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtFimValid() {
        return dtFimValid;
    }

    /**
     * Define o valor da propriedade dtFimValid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtFimValid(String value) {
        this.dtFimValid = value;
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
     * Obtém o valor da propriedade cdSetInd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdSetInd() {
        return cdSetInd;
    }

    /**
     * Define o valor da propriedade cdSetInd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdSetInd(String value) {
        this.cdSetInd = value;
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

    /**
     * Obtém o valor da propriedade cdCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdCliente() {
        return cdCliente;
    }

    /**
     * Define o valor da propriedade cdCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdCliente(String value) {
        this.cdCliente = value;
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
     * Obtém o valor da propriedade base.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBase() {
        return base;
    }

    /**
     * Define o valor da propriedade base.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBase(String value) {
        this.base = value;
    }

    /**
     * Obtém o valor da propriedade taxa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxa() {
        return taxa;
    }

    /**
     * Define o valor da propriedade taxa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxa(String value) {
        this.taxa = value;
    }

    /**
     * Obtém o valor da propriedade regUnid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegUnid() {
        return regUnid;
    }

    /**
     * Define o valor da propriedade regUnid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegUnid(String value) {
        this.regUnid = value;
    }

    /**
     * Obtém o valor da propriedade numUnid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumUnid() {
        return numUnid;
    }

    /**
     * Define o valor da propriedade numUnid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumUnid(String value) {
        this.numUnid = value;
    }

    /**
     * Obtém o valor da propriedade unidade.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * Define o valor da propriedade unidade.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnidade(String value) {
        this.unidade = value;
    }

    /**
     * Obtém o valor da propriedade cdMoeda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdMoeda() {
        return cdMoeda;
    }

    /**
     * Define o valor da propriedade cdMoeda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdMoeda(String value) {
        this.cdMoeda = value;
    }

    /**
     * Obtém o valor da propriedade leiTrib.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeiTrib() {
        return leiTrib;
    }

    /**
     * Define o valor da propriedade leiTrib.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeiTrib(String value) {
        this.leiTrib = value;
    }

}

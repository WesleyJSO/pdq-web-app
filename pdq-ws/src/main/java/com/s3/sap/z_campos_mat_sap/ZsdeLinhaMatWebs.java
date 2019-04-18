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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ZsdeLinhaMatWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeLinhaMatWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CdMaterial" type="{urn:sap-com:document:sap:rfc:functions}char18"/&gt;
 *         &lt;element name="Linha" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *         &lt;element name="DePara" type="{urn:sap-com:document:sap:rfc:functions}char60"/&gt;
 *         &lt;element name="SemEmb" type="{urn:sap-com:document:sap:rfc:functions}char60"/&gt;
 *         &lt;element name="Foco" type="{urn:sap-com:document:sap:rfc:functions}char60"/&gt;
 *         &lt;element name="Gerente" type="{urn:sap-com:document:sap:rfc:functions}char60"/&gt;
 *         &lt;element name="CdLinha" type="{urn:sap-com:document:sap:soap:functions:mc-style}numeric4"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeLinhaMatWebs", propOrder = {
    "cdMaterial",
    "linha",
    "dePara",
    "semEmb",
    "foco",
    "gerente",
    "cdLinha"
})
public class ZsdeLinhaMatWebs {

    @XmlElement(name = "CdMaterial", required = true)
    protected String cdMaterial;
    @XmlElement(name = "Linha", required = true)
    protected String linha;
    @XmlElement(name = "DePara", required = true)
    protected String dePara;
    @XmlElement(name = "SemEmb", required = true)
    protected String semEmb;
    @XmlElement(name = "Foco", required = true)
    protected String foco;
    @XmlElement(name = "Gerente", required = true)
    protected String gerente;
    @XmlElement(name = "CdLinha", required = true)
    protected String cdLinha;

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
     * Obtém o valor da propriedade linha.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinha() {
        return linha;
    }

    /**
     * Define o valor da propriedade linha.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinha(String value) {
        this.linha = value;
    }

    /**
     * Obtém o valor da propriedade dePara.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDePara() {
        return dePara;
    }

    /**
     * Define o valor da propriedade dePara.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDePara(String value) {
        this.dePara = value;
    }

    /**
     * Obtém o valor da propriedade semEmb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSemEmb() {
        return semEmb;
    }

    /**
     * Define o valor da propriedade semEmb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSemEmb(String value) {
        this.semEmb = value;
    }

    /**
     * Obtém o valor da propriedade foco.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFoco() {
        return foco;
    }

    /**
     * Define o valor da propriedade foco.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFoco(String value) {
        this.foco = value;
    }

    /**
     * Obtém o valor da propriedade gerente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGerente() {
        return gerente;
    }

    /**
     * Define o valor da propriedade gerente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGerente(String value) {
        this.gerente = value;
    }

    /**
     * Obtém o valor da propriedade cdLinha.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdLinha() {
        return cdLinha;
    }

    /**
     * Define o valor da propriedade cdLinha.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdLinha(String value) {
        this.cdLinha = value;
    }

}

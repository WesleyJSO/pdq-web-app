//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:50:29 PM BRT 
//


package com.s3.sap.z_fab_centro_sap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ZsdeCentroWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeCentroWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CdCentro" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="DcCentro" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *         &lt;element name="Endereco" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *         &lt;element name="Cidade" type="{urn:sap-com:document:sap:rfc:functions}char25"/&gt;
 *         &lt;element name="CdLocNeg" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="Uf" type="{urn:sap-com:document:sap:rfc:functions}char3"/&gt;
 *         &lt;element name="Pais" type="{urn:sap-com:document:sap:rfc:functions}char3"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeCentroWebs", propOrder = {
    "cdCentro",
    "dcCentro",
    "endereco",
    "cidade",
    "cdLocNeg",
    "uf",
    "pais"
})
public class ZsdeCentroWebs {

    @XmlElement(name = "CdCentro", required = true)
    protected String cdCentro;
    @XmlElement(name = "DcCentro", required = true)
    protected String dcCentro;
    @XmlElement(name = "Endereco", required = true)
    protected String endereco;
    @XmlElement(name = "Cidade", required = true)
    protected String cidade;
    @XmlElement(name = "CdLocNeg", required = true)
    protected String cdLocNeg;
    @XmlElement(name = "Uf", required = true)
    protected String uf;
    @XmlElement(name = "Pais", required = true)
    protected String pais;

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
     * Obtém o valor da propriedade endereco.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o valor da propriedade endereco.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndereco(String value) {
        this.endereco = value;
    }

    /**
     * Obtém o valor da propriedade cidade.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Define o valor da propriedade cidade.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCidade(String value) {
        this.cidade = value;
    }

    /**
     * Obtém o valor da propriedade cdLocNeg.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdLocNeg() {
        return cdLocNeg;
    }

    /**
     * Define o valor da propriedade cdLocNeg.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdLocNeg(String value) {
        this.cdLocNeg = value;
    }

    /**
     * Obtém o valor da propriedade uf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUf() {
        return uf;
    }

    /**
     * Define o valor da propriedade uf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUf(String value) {
        this.uf = value;
    }

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

}

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
 * <p>Classe Java de ZsdeMoedaWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeMoedaWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CdMoeda" type="{urn:sap-com:document:sap:rfc:functions}cuky5"/&gt;
 *         &lt;element name="DcMoeda" type="{urn:sap-com:document:sap:rfc:functions}char15"/&gt;
 *         &lt;element name="DcMoedaLong" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeMoedaWebs", propOrder = {
    "cdMoeda",
    "dcMoeda",
    "dcMoedaLong"
})
public class ZsdeMoedaWebs {

    @XmlElement(name = "CdMoeda", required = true)
    protected String cdMoeda;
    @XmlElement(name = "DcMoeda", required = true)
    protected String dcMoeda;
    @XmlElement(name = "DcMoedaLong", required = true)
    protected String dcMoedaLong;

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
     * Obtém o valor da propriedade dcMoeda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcMoeda() {
        return dcMoeda;
    }

    /**
     * Define o valor da propriedade dcMoeda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcMoeda(String value) {
        this.dcMoeda = value;
    }

    /**
     * Obtém o valor da propriedade dcMoedaLong.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcMoedaLong() {
        return dcMoedaLong;
    }

    /**
     * Define o valor da propriedade dcMoedaLong.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcMoedaLong(String value) {
        this.dcMoedaLong = value;
    }

}

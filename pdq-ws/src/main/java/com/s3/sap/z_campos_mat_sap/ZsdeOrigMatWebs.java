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
 * <p>Classe Java de ZsdeOrigMatWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeOrigMatWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CdOrigMat" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="DcOrigMat" type="{urn:sap-com:document:sap:rfc:functions}char60"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeOrigMatWebs", propOrder = {
    "cdOrigMat",
    "dcOrigMat"
})
public class ZsdeOrigMatWebs {

    @XmlElement(name = "CdOrigMat", required = true)
    protected String cdOrigMat;
    @XmlElement(name = "DcOrigMat", required = true)
    protected String dcOrigMat;

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
     * Obtém o valor da propriedade dcOrigMat.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcOrigMat() {
        return dcOrigMat;
    }

    /**
     * Define o valor da propriedade dcOrigMat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcOrigMat(String value) {
        this.dcOrigMat = value;
    }

}

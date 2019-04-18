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
 * <p>Classe Java de ZsdeCatCfopWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeCatCfopWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CdCatCfop" type="{urn:sap-com:document:sap:rfc:functions}char2"/&gt;
 *         &lt;element name="DcCatCfop" type="{urn:sap-com:document:sap:rfc:functions}char60"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeCatCfopWebs", propOrder = {
    "cdCatCfop",
    "dcCatCfop"
})
public class ZsdeCatCfopWebs {

    @XmlElement(name = "CdCatCfop", required = true)
    protected String cdCatCfop;
    @XmlElement(name = "DcCatCfop", required = true)
    protected String dcCatCfop;

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
     * Obtém o valor da propriedade dcCatCfop.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcCatCfop() {
        return dcCatCfop;
    }

    /**
     * Define o valor da propriedade dcCatCfop.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcCatCfop(String value) {
        this.dcCatCfop = value;
    }

}

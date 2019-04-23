//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:49:32 PM BRT 
//


package com.s3.sap.z_cad_estrut_venda_sap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ZsdeCanalDistrWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeCanalDistrWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CdCanalDistr" type="{urn:sap-com:document:sap:rfc:functions}char2"/&gt;
 *         &lt;element name="DcCanalDistr" type="{urn:sap-com:document:sap:rfc:functions}char20"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeCanalDistrWebs", propOrder = {
    "cdCanalDistr",
    "dcCanalDistr"
})
public class ZsdeCanalDistrWebs {

    @XmlElement(name = "CdCanalDistr", required = true)
    protected String cdCanalDistr;
    @XmlElement(name = "DcCanalDistr", required = true)
    protected String dcCanalDistr;

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
     * Obtém o valor da propriedade dcCanalDistr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcCanalDistr() {
        return dcCanalDistr;
    }

    /**
     * Define o valor da propriedade dcCanalDistr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcCanalDistr(String value) {
        this.dcCanalDistr = value;
    }

}

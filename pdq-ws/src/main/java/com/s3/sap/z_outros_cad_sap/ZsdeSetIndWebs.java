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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ZsdeSetIndWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeSetIndWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CdSetInd" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="DcSetInd" type="{urn:sap-com:document:sap:rfc:functions}char20"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeSetIndWebs", propOrder = {
    "cdSetInd",
    "dcSetInd"
})
public class ZsdeSetIndWebs {

    @XmlElement(name = "CdSetInd", required = true)
    protected String cdSetInd;
    @XmlElement(name = "DcSetInd", required = true)
    protected String dcSetInd;

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
     * Obtém o valor da propriedade dcSetInd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcSetInd() {
        return dcSetInd;
    }

    /**
     * Define o valor da propriedade dcSetInd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcSetInd(String value) {
        this.dcSetInd = value;
    }

}

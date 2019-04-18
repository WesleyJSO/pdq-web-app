//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:50:33 PM BRT 
//


package com.s3.sap.z_utiliz_cultura_sap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ZsdeUtilCultWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeUtilCultWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CdCultura" type="{urn:sap-com:document:sap:rfc:functions}char3"/&gt;
 *         &lt;element name="DcCultura" type="{urn:sap-com:document:sap:rfc:functions}char20"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeUtilCultWebs", propOrder = {
    "cdCultura",
    "dcCultura"
})
public class ZsdeUtilCultWebs {

    @XmlElement(name = "CdCultura", required = true)
    protected String cdCultura;
    @XmlElement(name = "DcCultura", required = true)
    protected String dcCultura;

    /**
     * Obtém o valor da propriedade cdCultura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdCultura() {
        return cdCultura;
    }

    /**
     * Define o valor da propriedade cdCultura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdCultura(String value) {
        this.cdCultura = value;
    }

    /**
     * Obtém o valor da propriedade dcCultura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcCultura() {
        return dcCultura;
    }

    /**
     * Define o valor da propriedade dcCultura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcCultura(String value) {
        this.dcCultura = value;
    }

}

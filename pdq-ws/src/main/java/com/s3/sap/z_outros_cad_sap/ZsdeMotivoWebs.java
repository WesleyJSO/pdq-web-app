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
 * <p>Classe Java de ZsdeMotivoWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeMotivoWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CdMotivoOrd" type="{urn:sap-com:document:sap:rfc:functions}char3"/&gt;
 *         &lt;element name="DcMotivoOrd" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeMotivoWebs", propOrder = {
    "cdMotivoOrd",
    "dcMotivoOrd"
})
public class ZsdeMotivoWebs {

    @XmlElement(name = "CdMotivoOrd", required = true)
    protected String cdMotivoOrd;
    @XmlElement(name = "DcMotivoOrd", required = true)
    protected String dcMotivoOrd;

    /**
     * Obtém o valor da propriedade cdMotivoOrd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdMotivoOrd() {
        return cdMotivoOrd;
    }

    /**
     * Define o valor da propriedade cdMotivoOrd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdMotivoOrd(String value) {
        this.cdMotivoOrd = value;
    }

    /**
     * Obtém o valor da propriedade dcMotivoOrd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcMotivoOrd() {
        return dcMotivoOrd;
    }

    /**
     * Define o valor da propriedade dcMotivoOrd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcMotivoOrd(String value) {
        this.dcMotivoOrd = value;
    }

}

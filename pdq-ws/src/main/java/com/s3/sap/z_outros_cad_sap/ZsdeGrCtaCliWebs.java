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
 * <p>Classe Java de ZsdeGrCtaCliWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeGrCtaCliWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CdGrConta" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="DcGrConta" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeGrCtaCliWebs", propOrder = {
    "cdGrConta",
    "dcGrConta"
})
public class ZsdeGrCtaCliWebs {

    @XmlElement(name = "CdGrConta", required = true)
    protected String cdGrConta;
    @XmlElement(name = "DcGrConta", required = true)
    protected String dcGrConta;

    /**
     * Obtém o valor da propriedade cdGrConta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdGrConta() {
        return cdGrConta;
    }

    /**
     * Define o valor da propriedade cdGrConta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdGrConta(String value) {
        this.cdGrConta = value;
    }

    /**
     * Obtém o valor da propriedade dcGrConta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcGrConta() {
        return dcGrConta;
    }

    /**
     * Define o valor da propriedade dcGrConta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcGrConta(String value) {
        this.dcGrConta = value;
    }

}

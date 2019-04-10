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
 * <p>Classe Java de ZsdeGrMercWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeGrMercWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GrMercadoria" type="{urn:sap-com:document:sap:rfc:functions}char9"/&gt;
 *         &lt;element name="DcGrMercadoria" type="{urn:sap-com:document:sap:rfc:functions}char20"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeGrMercWebs", propOrder = {
    "grMercadoria",
    "dcGrMercadoria"
})
public class ZsdeGrMercWebs {

    @XmlElement(name = "GrMercadoria", required = true)
    protected String grMercadoria;
    @XmlElement(name = "DcGrMercadoria", required = true)
    protected String dcGrMercadoria;

    /**
     * Obtém o valor da propriedade grMercadoria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrMercadoria() {
        return grMercadoria;
    }

    /**
     * Define o valor da propriedade grMercadoria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrMercadoria(String value) {
        this.grMercadoria = value;
    }

    /**
     * Obtém o valor da propriedade dcGrMercadoria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcGrMercadoria() {
        return dcGrMercadoria;
    }

    /**
     * Define o valor da propriedade dcGrMercadoria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcGrMercadoria(String value) {
        this.dcGrMercadoria = value;
    }

}

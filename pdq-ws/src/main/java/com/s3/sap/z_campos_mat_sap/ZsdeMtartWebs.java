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
 * <p>Classe Java de ZsdeMtartWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeMtartWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TpMaterial" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="DcTpMaterial" type="{urn:sap-com:document:sap:rfc:functions}char25"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeMtartWebs", propOrder = {
    "tpMaterial",
    "dcTpMaterial"
})
public class ZsdeMtartWebs {

    @XmlElement(name = "TpMaterial", required = true)
    protected String tpMaterial;
    @XmlElement(name = "DcTpMaterial", required = true)
    protected String dcTpMaterial;

    /**
     * Obtém o valor da propriedade tpMaterial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpMaterial() {
        return tpMaterial;
    }

    /**
     * Define o valor da propriedade tpMaterial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpMaterial(String value) {
        this.tpMaterial = value;
    }

    /**
     * Obtém o valor da propriedade dcTpMaterial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcTpMaterial() {
        return dcTpMaterial;
    }

    /**
     * Define o valor da propriedade dcTpMaterial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcTpMaterial(String value) {
        this.dcTpMaterial = value;
    }

}

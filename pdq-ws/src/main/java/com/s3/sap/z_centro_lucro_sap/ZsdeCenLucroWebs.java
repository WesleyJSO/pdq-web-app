//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:50:29 PM BRT 
//


package com.s3.sap.z_centro_lucro_sap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ZsdeCenLucroWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeCenLucroWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CdCentroLucro" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="DcCentroLucro" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeCenLucroWebs", propOrder = {
    "cdCentroLucro",
    "dcCentroLucro"
})
public class ZsdeCenLucroWebs {

    @XmlElement(name = "CdCentroLucro", required = true)
    protected String cdCentroLucro;
    @XmlElement(name = "DcCentroLucro", required = true)
    protected String dcCentroLucro;

    /**
     * Obtém o valor da propriedade cdCentroLucro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdCentroLucro() {
        return cdCentroLucro;
    }

    /**
     * Define o valor da propriedade cdCentroLucro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdCentroLucro(String value) {
        this.cdCentroLucro = value;
    }

    /**
     * Obtém o valor da propriedade dcCentroLucro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcCentroLucro() {
        return dcCentroLucro;
    }

    /**
     * Define o valor da propriedade dcCentroLucro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcCentroLucro(String value) {
        this.dcCentroLucro = value;
    }

}

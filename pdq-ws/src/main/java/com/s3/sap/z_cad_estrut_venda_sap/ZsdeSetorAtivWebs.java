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
 * <p>Classe Java de ZsdeSetorAtivWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeSetorAtivWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CdSetAtiv" type="{urn:sap-com:document:sap:rfc:functions}char2"/&gt;
 *         &lt;element name="DcSetAtiv" type="{urn:sap-com:document:sap:rfc:functions}char20"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeSetorAtivWebs", propOrder = {
    "cdSetAtiv",
    "dcSetAtiv"
})
public class ZsdeSetorAtivWebs {

    @XmlElement(name = "CdSetAtiv", required = true)
    protected String cdSetAtiv;
    @XmlElement(name = "DcSetAtiv", required = true)
    protected String dcSetAtiv;

    /**
     * Obtém o valor da propriedade cdSetAtiv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdSetAtiv() {
        return cdSetAtiv;
    }

    /**
     * Define o valor da propriedade cdSetAtiv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdSetAtiv(String value) {
        this.cdSetAtiv = value;
    }

    /**
     * Obtém o valor da propriedade dcSetAtiv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcSetAtiv() {
        return dcSetAtiv;
    }

    /**
     * Define o valor da propriedade dcSetAtiv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcSetAtiv(String value) {
        this.dcSetAtiv = value;
    }

}

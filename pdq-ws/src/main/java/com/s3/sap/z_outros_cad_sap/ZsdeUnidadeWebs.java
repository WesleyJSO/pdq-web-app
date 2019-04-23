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
 * <p>Classe Java de ZsdeUnidadeWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeUnidadeWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Unidade" type="{urn:sap-com:document:sap:rfc:functions}char3"/&gt;
 *         &lt;element name="DcUnidade" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeUnidadeWebs", propOrder = {
    "unidade",
    "dcUnidade"
})
public class ZsdeUnidadeWebs {

    @XmlElement(name = "Unidade", required = true)
    protected String unidade;
    @XmlElement(name = "DcUnidade", required = true)
    protected String dcUnidade;

    /**
     * Obtém o valor da propriedade unidade.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * Define o valor da propriedade unidade.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnidade(String value) {
        this.unidade = value;
    }

    /**
     * Obtém o valor da propriedade dcUnidade.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcUnidade() {
        return dcUnidade;
    }

    /**
     * Define o valor da propriedade dcUnidade.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcUnidade(String value) {
        this.dcUnidade = value;
    }

}

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
 * <p>Classe Java de ZsdeEscrVendaWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeEscrVendaWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CdEscrVenda" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="DcEscrVenda" type="{urn:sap-com:document:sap:rfc:functions}char20"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeEscrVendaWebs", propOrder = {
    "cdEscrVenda",
    "dcEscrVenda"
})
public class ZsdeEscrVendaWebs {

    @XmlElement(name = "CdEscrVenda", required = true)
    protected String cdEscrVenda;
    @XmlElement(name = "DcEscrVenda", required = true)
    protected String dcEscrVenda;

    /**
     * Obtém o valor da propriedade cdEscrVenda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdEscrVenda() {
        return cdEscrVenda;
    }

    /**
     * Define o valor da propriedade cdEscrVenda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdEscrVenda(String value) {
        this.cdEscrVenda = value;
    }

    /**
     * Obtém o valor da propriedade dcEscrVenda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcEscrVenda() {
        return dcEscrVenda;
    }

    /**
     * Define o valor da propriedade dcEscrVenda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcEscrVenda(String value) {
        this.dcEscrVenda = value;
    }

}

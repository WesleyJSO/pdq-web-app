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
 * <p>Classe Java de ZsdeOrgVendaWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeOrgVendaWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CdOrgVenda" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="DcOrgVenda" type="{urn:sap-com:document:sap:rfc:functions}char20"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeOrgVendaWebs", propOrder = {
    "cdOrgVenda",
    "dcOrgVenda"
})
public class ZsdeOrgVendaWebs {

    @XmlElement(name = "CdOrgVenda", required = true)
    protected String cdOrgVenda;
    @XmlElement(name = "DcOrgVenda", required = true)
    protected String dcOrgVenda;

    /**
     * Obtém o valor da propriedade cdOrgVenda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdOrgVenda() {
        return cdOrgVenda;
    }

    /**
     * Define o valor da propriedade cdOrgVenda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdOrgVenda(String value) {
        this.cdOrgVenda = value;
    }

    /**
     * Obtém o valor da propriedade dcOrgVenda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcOrgVenda() {
        return dcOrgVenda;
    }

    /**
     * Define o valor da propriedade dcOrgVenda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcOrgVenda(String value) {
        this.dcOrgVenda = value;
    }

}

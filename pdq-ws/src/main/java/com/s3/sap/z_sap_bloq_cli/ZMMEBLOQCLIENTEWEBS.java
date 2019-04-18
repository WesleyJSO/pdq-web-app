//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:50:31 PM BRT 
//


package com.s3.sap.z_sap_bloq_cli;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ZMME_BLOQ_CLIENTE_WEBS complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZMME_BLOQ_CLIENTE_WEBS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CD_SAP" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="CD_EXT_PARCEIRO" type="{urn:sap-com:document:sap:rfc:functions}char50"/&gt;
 *         &lt;element name="MOTIVO" type="{urn:sap-com:document:sap:rfc:functions}char120"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZMME_BLOQ_CLIENTE_WEBS", propOrder = {
    "cdsap",
    "cdextparceiro",
    "motivo"
})
public class ZMMEBLOQCLIENTEWEBS {

    @XmlElement(name = "CD_SAP", required = true)
    protected String cdsap;
    @XmlElement(name = "CD_EXT_PARCEIRO", required = true)
    protected String cdextparceiro;
    @XmlElement(name = "MOTIVO", required = true)
    protected String motivo;

    /**
     * Obtém o valor da propriedade cdsap.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCDSAP() {
        return cdsap;
    }

    /**
     * Define o valor da propriedade cdsap.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCDSAP(String value) {
        this.cdsap = value;
    }

    /**
     * Obtém o valor da propriedade cdextparceiro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCDEXTPARCEIRO() {
        return cdextparceiro;
    }

    /**
     * Define o valor da propriedade cdextparceiro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCDEXTPARCEIRO(String value) {
        this.cdextparceiro = value;
    }

    /**
     * Obtém o valor da propriedade motivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMOTIVO() {
        return motivo;
    }

    /**
     * Define o valor da propriedade motivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMOTIVO(String value) {
        this.motivo = value;
    }

}

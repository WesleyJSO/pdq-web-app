//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:50:31 PM BRT 
//


package com.s3.sap.z_sap_alt_cli;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="COD_SAP_PRE" type="{urn:sap-com:document:sap:rfc:functions}char6"/&gt;
 *         &lt;element name="DC_STATUS" type="{urn:sap-com:document:sap:rfc:functions}char70"/&gt;
 *         &lt;element name="RETORNO" type="{urn:sap-com:document:sap:rfc:functions}char70"/&gt;
 *         &lt;element name="STATUS" type="{urn:sap-com:document:sap:rfc:functions}char2"/&gt;
 *         &lt;element name="TAB_ERRO" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_ZSDE_ERRO_WEBS" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "codsappre",
    "dcstatus",
    "retorno",
    "status",
    "taberro"
})
@XmlRootElement(name = "ZBC_ALT_CLIENTE_ART_WEBSResponse")
public class ZBCALTCLIENTEARTWEBSResponse {

    @XmlElement(name = "COD_SAP_PRE", required = true)
    protected String codsappre;
    @XmlElement(name = "DC_STATUS", required = true)
    protected String dcstatus;
    @XmlElement(name = "RETORNO", required = true)
    protected String retorno;
    @XmlElement(name = "STATUS", required = true)
    protected String status;
    @XmlElement(name = "TAB_ERRO")
    protected TABLEOFZSDEERROWEBS taberro;

    /**
     * Obtém o valor da propriedade codsappre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODSAPPRE() {
        return codsappre;
    }

    /**
     * Define o valor da propriedade codsappre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODSAPPRE(String value) {
        this.codsappre = value;
    }

    /**
     * Obtém o valor da propriedade dcstatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDCSTATUS() {
        return dcstatus;
    }

    /**
     * Define o valor da propriedade dcstatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDCSTATUS(String value) {
        this.dcstatus = value;
    }

    /**
     * Obtém o valor da propriedade retorno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRETORNO() {
        return retorno;
    }

    /**
     * Define o valor da propriedade retorno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRETORNO(String value) {
        this.retorno = value;
    }

    /**
     * Obtém o valor da propriedade status.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTATUS() {
        return status;
    }

    /**
     * Define o valor da propriedade status.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTATUS(String value) {
        this.status = value;
    }

    /**
     * Obtém o valor da propriedade taberro.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFZSDEERROWEBS }
     *     
     */
    public TABLEOFZSDEERROWEBS getTABERRO() {
        return taberro;
    }

    /**
     * Define o valor da propriedade taberro.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFZSDEERROWEBS }
     *     
     */
    public void setTABERRO(TABLEOFZSDEERROWEBS value) {
        this.taberro = value;
    }

}

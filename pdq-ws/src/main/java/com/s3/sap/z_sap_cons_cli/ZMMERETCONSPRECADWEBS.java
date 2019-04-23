//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:50:32 PM BRT 
//


package com.s3.sap.z_sap_cons_cli;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ZMME_RET_CONS_PRE_CAD_WEBS complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZMME_RET_CONS_PRE_CAD_WEBS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CD_EXT_PARCEIRO" type="{urn:sap-com:document:sap:rfc:functions}char50"/&gt;
 *         &lt;element name="COD_SAP_PRE" type="{urn:sap-com:document:sap:rfc:functions}numeric6"/&gt;
 *         &lt;element name="CD_SAP" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="CD_SAP_COBRANCA" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="RETORNO" type="{urn:sap-com:document:sap:rfc:functions}char70"/&gt;
 *         &lt;element name="STATUS" type="{urn:sap-com:document:sap:rfc:functions}char2"/&gt;
 *         &lt;element name="DC_STATUS" type="{urn:sap-com:document:sap:rfc:functions}char70"/&gt;
 *         &lt;element name="DC_TIPO" type="{urn:sap-com:document:sap:rfc:functions}char70"/&gt;
 *         &lt;element name="DATA_STATUS" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="HORA_STATUS" type="{urn:sap-com:document:sap:rfc:functions}numeric6"/&gt;
 *         &lt;element name="UNAME_STATUS" type="{urn:sap-com:document:sap:rfc:functions}char12"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZMME_RET_CONS_PRE_CAD_WEBS", propOrder = {
    "cdextparceiro",
    "codsappre",
    "cdsap",
    "cdsapcobranca",
    "retorno",
    "status",
    "dcstatus",
    "dctipo",
    "datastatus",
    "horastatus",
    "unamestatus"
})
public class ZMMERETCONSPRECADWEBS {

    @XmlElement(name = "CD_EXT_PARCEIRO", required = true)
    protected String cdextparceiro;
    @XmlElement(name = "COD_SAP_PRE", required = true)
    protected String codsappre;
    @XmlElement(name = "CD_SAP", required = true)
    protected String cdsap;
    @XmlElement(name = "CD_SAP_COBRANCA", required = true)
    protected String cdsapcobranca;
    @XmlElement(name = "RETORNO", required = true)
    protected String retorno;
    @XmlElement(name = "STATUS", required = true)
    protected String status;
    @XmlElement(name = "DC_STATUS", required = true)
    protected String dcstatus;
    @XmlElement(name = "DC_TIPO", required = true)
    protected String dctipo;
    @XmlElement(name = "DATA_STATUS", required = true)
    protected String datastatus;
    @XmlElement(name = "HORA_STATUS", required = true)
    protected String horastatus;
    @XmlElement(name = "UNAME_STATUS", required = true)
    protected String unamestatus;

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
     * Obtém o valor da propriedade cdsapcobranca.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCDSAPCOBRANCA() {
        return cdsapcobranca;
    }

    /**
     * Define o valor da propriedade cdsapcobranca.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCDSAPCOBRANCA(String value) {
        this.cdsapcobranca = value;
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
     * Obtém o valor da propriedade dctipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDCTIPO() {
        return dctipo;
    }

    /**
     * Define o valor da propriedade dctipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDCTIPO(String value) {
        this.dctipo = value;
    }

    /**
     * Obtém o valor da propriedade datastatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDATASTATUS() {
        return datastatus;
    }

    /**
     * Define o valor da propriedade datastatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDATASTATUS(String value) {
        this.datastatus = value;
    }

    /**
     * Obtém o valor da propriedade horastatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHORASTATUS() {
        return horastatus;
    }

    /**
     * Define o valor da propriedade horastatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHORASTATUS(String value) {
        this.horastatus = value;
    }

    /**
     * Obtém o valor da propriedade unamestatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUNAMESTATUS() {
        return unamestatus;
    }

    /**
     * Define o valor da propriedade unamestatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUNAMESTATUS(String value) {
        this.unamestatus = value;
    }

}

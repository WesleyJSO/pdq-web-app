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
 *         &lt;element name="I_CD_EXT_PARCEIRO" type="{urn:sap-com:document:sap:rfc:functions}char50" minOccurs="0"/&gt;
 *         &lt;element name="I_CH_ACESSO" type="{urn:sap-com:document:sap:rfc:functions}char15" minOccurs="0"/&gt;
 *         &lt;element name="TAB_STATUS" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_ZMME_RET_CONS_PRE_CAD_WEBS" minOccurs="0"/&gt;
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
    "icdextparceiro",
    "ichacesso",
    "tabstatus"
})
@XmlRootElement(name = "ZBC_CONS_PRE_CAD_ART_WEBS")
public class ZBCCONSPRECADARTWEBS {

    @XmlElement(name = "I_CD_EXT_PARCEIRO")
    protected String icdextparceiro;
    @XmlElement(name = "I_CH_ACESSO")
    protected String ichacesso;
    @XmlElement(name = "TAB_STATUS")
    protected TABLEOFZMMERETCONSPRECADWEBS tabstatus;

    /**
     * Obtém o valor da propriedade icdextparceiro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICDEXTPARCEIRO() {
        return icdextparceiro;
    }

    /**
     * Define o valor da propriedade icdextparceiro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICDEXTPARCEIRO(String value) {
        this.icdextparceiro = value;
    }

    /**
     * Obtém o valor da propriedade ichacesso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICHACESSO() {
        return ichacesso;
    }

    /**
     * Define o valor da propriedade ichacesso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICHACESSO(String value) {
        this.ichacesso = value;
    }

    /**
     * Obtém o valor da propriedade tabstatus.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFZMMERETCONSPRECADWEBS }
     *     
     */
    public TABLEOFZMMERETCONSPRECADWEBS getTABSTATUS() {
        return tabstatus;
    }

    /**
     * Define o valor da propriedade tabstatus.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFZMMERETCONSPRECADWEBS }
     *     
     */
    public void setTABSTATUS(TABLEOFZMMERETCONSPRECADWEBS value) {
        this.tabstatus = value;
    }

}

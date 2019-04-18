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
 *         &lt;element name="I_ALT_CADASTRO" type="{urn:sap-com:document:sap:rfc:functions}ZMME_ALT_CLIENTE_WEBS" minOccurs="0"/&gt;
 *         &lt;element name="I_CH_ACESSO" type="{urn:sap-com:document:sap:rfc:functions}char15" minOccurs="0"/&gt;
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
    "ialtcadastro",
    "ichacesso",
    "taberro"
})
@XmlRootElement(name = "ZBC_ALT_CLIENTE_ART_WEBS")
public class ZBCALTCLIENTEARTWEBS {

    @XmlElement(name = "I_ALT_CADASTRO")
    protected ZMMEALTCLIENTEWEBS ialtcadastro;
    @XmlElement(name = "I_CH_ACESSO")
    protected String ichacesso;
    @XmlElement(name = "TAB_ERRO")
    protected TABLEOFZSDEERROWEBS taberro;

    /**
     * Obtém o valor da propriedade ialtcadastro.
     * 
     * @return
     *     possible object is
     *     {@link ZMMEALTCLIENTEWEBS }
     *     
     */
    public ZMMEALTCLIENTEWEBS getIALTCADASTRO() {
        return ialtcadastro;
    }

    /**
     * Define o valor da propriedade ialtcadastro.
     * 
     * @param value
     *     allowed object is
     *     {@link ZMMEALTCLIENTEWEBS }
     *     
     */
    public void setIALTCADASTRO(ZMMEALTCLIENTEWEBS value) {
        this.ialtcadastro = value;
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

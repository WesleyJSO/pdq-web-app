//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:50:30 PM BRT 
//


package com.s3.sap.z_pre_cad_cliente_sap;

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
 *         &lt;element name="CodSapPre" type="{urn:sap-com:document:sap:rfc:functions}char6"/&gt;
 *         &lt;element name="DcStatus" type="{urn:sap-com:document:sap:rfc:functions}char70"/&gt;
 *         &lt;element name="Retorno" type="{urn:sap-com:document:sap:rfc:functions}char70"/&gt;
 *         &lt;element name="Status" type="{urn:sap-com:document:sap:rfc:functions}char2"/&gt;
 *         &lt;element name="TabErro" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeErroWebs" minOccurs="0"/&gt;
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
    "codSapPre",
    "dcStatus",
    "retorno",
    "status",
    "tabErro"
})
@XmlRootElement(name = "ZbcPreCadClienteArtWebsResponse")
public class ZbcPreCadClienteArtWebsResponse {

    @XmlElement(name = "CodSapPre", required = true)
    protected String codSapPre;
    @XmlElement(name = "DcStatus", required = true)
    protected String dcStatus;
    @XmlElement(name = "Retorno", required = true)
    protected String retorno;
    @XmlElement(name = "Status", required = true)
    protected String status;
    @XmlElement(name = "TabErro")
    protected TableOfZsdeErroWebs tabErro;

    /**
     * Obtém o valor da propriedade codSapPre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSapPre() {
        return codSapPre;
    }

    /**
     * Define o valor da propriedade codSapPre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSapPre(String value) {
        this.codSapPre = value;
    }

    /**
     * Obtém o valor da propriedade dcStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcStatus() {
        return dcStatus;
    }

    /**
     * Define o valor da propriedade dcStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcStatus(String value) {
        this.dcStatus = value;
    }

    /**
     * Obtém o valor da propriedade retorno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRetorno() {
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
    public void setRetorno(String value) {
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
    public String getStatus() {
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
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Obtém o valor da propriedade tabErro.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeErroWebs }
     *     
     */
    public TableOfZsdeErroWebs getTabErro() {
        return tabErro;
    }

    /**
     * Define o valor da propriedade tabErro.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeErroWebs }
     *     
     */
    public void setTabErro(TableOfZsdeErroWebs value) {
        this.tabErro = value;
    }

}

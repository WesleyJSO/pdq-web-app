//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:50:30 PM BRT 
//


package com.s3.sap.z_ord_venda_status_sap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ZsdeOrdStatusWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeOrdStatusWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NrOrdVenda" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="StOrdVenda" type="{urn:sap-com:document:sap:rfc:functions}char50"/&gt;
 *         &lt;element name="ObsSt" type="{urn:sap-com:document:sap:rfc:functions}char70"/&gt;
 *         &lt;element name="StOrdAdv" type="{urn:sap-com:document:sap:rfc:functions}char50"/&gt;
 *         &lt;element name="BloqRemessa" type="{urn:sap-com:document:sap:rfc:functions}char20"/&gt;
 *         &lt;element name="BloqDocFatur" type="{urn:sap-com:document:sap:rfc:functions}char20"/&gt;
 *         &lt;element name="StGlobal" type="{urn:sap-com:document:sap:rfc:functions}char20"/&gt;
 *         &lt;element name="StRecusa" type="{urn:sap-com:document:sap:rfc:functions}char20"/&gt;
 *         &lt;element name="StRemessa" type="{urn:sap-com:document:sap:rfc:functions}char20"/&gt;
 *         &lt;element name="StCredito" type="{urn:sap-com:document:sap:rfc:functions}char20"/&gt;
 *         &lt;element name="MotRecCred" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="StGerBloq" type="{urn:sap-com:document:sap:rfc:functions}char20"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeOrdStatusWebs", propOrder = {
    "nrOrdVenda",
    "stOrdVenda",
    "obsSt",
    "stOrdAdv",
    "bloqRemessa",
    "bloqDocFatur",
    "stGlobal",
    "stRecusa",
    "stRemessa",
    "stCredito",
    "motRecCred",
    "stGerBloq"
})
public class ZsdeOrdStatusWebs {

    @XmlElement(name = "NrOrdVenda", required = true)
    protected String nrOrdVenda;
    @XmlElement(name = "StOrdVenda", required = true)
    protected String stOrdVenda;
    @XmlElement(name = "ObsSt", required = true)
    protected String obsSt;
    @XmlElement(name = "StOrdAdv", required = true)
    protected String stOrdAdv;
    @XmlElement(name = "BloqRemessa", required = true)
    protected String bloqRemessa;
    @XmlElement(name = "BloqDocFatur", required = true)
    protected String bloqDocFatur;
    @XmlElement(name = "StGlobal", required = true)
    protected String stGlobal;
    @XmlElement(name = "StRecusa", required = true)
    protected String stRecusa;
    @XmlElement(name = "StRemessa", required = true)
    protected String stRemessa;
    @XmlElement(name = "StCredito", required = true)
    protected String stCredito;
    @XmlElement(name = "MotRecCred", required = true)
    protected String motRecCred;
    @XmlElement(name = "StGerBloq", required = true)
    protected String stGerBloq;

    /**
     * Obtém o valor da propriedade nrOrdVenda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNrOrdVenda() {
        return nrOrdVenda;
    }

    /**
     * Define o valor da propriedade nrOrdVenda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNrOrdVenda(String value) {
        this.nrOrdVenda = value;
    }

    /**
     * Obtém o valor da propriedade stOrdVenda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStOrdVenda() {
        return stOrdVenda;
    }

    /**
     * Define o valor da propriedade stOrdVenda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStOrdVenda(String value) {
        this.stOrdVenda = value;
    }

    /**
     * Obtém o valor da propriedade obsSt.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObsSt() {
        return obsSt;
    }

    /**
     * Define o valor da propriedade obsSt.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObsSt(String value) {
        this.obsSt = value;
    }

    /**
     * Obtém o valor da propriedade stOrdAdv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStOrdAdv() {
        return stOrdAdv;
    }

    /**
     * Define o valor da propriedade stOrdAdv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStOrdAdv(String value) {
        this.stOrdAdv = value;
    }

    /**
     * Obtém o valor da propriedade bloqRemessa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBloqRemessa() {
        return bloqRemessa;
    }

    /**
     * Define o valor da propriedade bloqRemessa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBloqRemessa(String value) {
        this.bloqRemessa = value;
    }

    /**
     * Obtém o valor da propriedade bloqDocFatur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBloqDocFatur() {
        return bloqDocFatur;
    }

    /**
     * Define o valor da propriedade bloqDocFatur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBloqDocFatur(String value) {
        this.bloqDocFatur = value;
    }

    /**
     * Obtém o valor da propriedade stGlobal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStGlobal() {
        return stGlobal;
    }

    /**
     * Define o valor da propriedade stGlobal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStGlobal(String value) {
        this.stGlobal = value;
    }

    /**
     * Obtém o valor da propriedade stRecusa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStRecusa() {
        return stRecusa;
    }

    /**
     * Define o valor da propriedade stRecusa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStRecusa(String value) {
        this.stRecusa = value;
    }

    /**
     * Obtém o valor da propriedade stRemessa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStRemessa() {
        return stRemessa;
    }

    /**
     * Define o valor da propriedade stRemessa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStRemessa(String value) {
        this.stRemessa = value;
    }

    /**
     * Obtém o valor da propriedade stCredito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStCredito() {
        return stCredito;
    }

    /**
     * Define o valor da propriedade stCredito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStCredito(String value) {
        this.stCredito = value;
    }

    /**
     * Obtém o valor da propriedade motRecCred.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotRecCred() {
        return motRecCred;
    }

    /**
     * Define o valor da propriedade motRecCred.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotRecCred(String value) {
        this.motRecCred = value;
    }

    /**
     * Obtém o valor da propriedade stGerBloq.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStGerBloq() {
        return stGerBloq;
    }

    /**
     * Define o valor da propriedade stGerBloq.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStGerBloq(String value) {
        this.stGerBloq = value;
    }

}

//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:50:29 PM BRT 
//


package com.s3.sap.z_consulta_cpf_cnpj_sap;

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
 *         &lt;element name="IChAcesso" type="{urn:sap-com:document:sap:rfc:functions}char15" minOccurs="0"/&gt;
 *         &lt;element name="ICpfCnpj" type="{urn:sap-com:document:sap:rfc:functions}char14" minOccurs="0"/&gt;
 *         &lt;element name="ITpParceiro" type="{urn:sap-com:document:sap:rfc:functions}char1" minOccurs="0"/&gt;
 *         &lt;element name="ITpPessoa" type="{urn:sap-com:document:sap:rfc:functions}char1" minOccurs="0"/&gt;
 *         &lt;element name="TabParceiro" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeConsCpfCnpjWebs" minOccurs="0"/&gt;
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
    "iChAcesso",
    "iCpfCnpj",
    "iTpParceiro",
    "iTpPessoa",
    "tabParceiro"
})
@XmlRootElement(name = "ZbcConsCpfCnpjArtWebs")
public class ZbcConsCpfCnpjArtWebs {

    @XmlElement(name = "IChAcesso")
    protected String iChAcesso;
    @XmlElement(name = "ICpfCnpj")
    protected String iCpfCnpj;
    @XmlElement(name = "ITpParceiro")
    protected String iTpParceiro;
    @XmlElement(name = "ITpPessoa")
    protected String iTpPessoa;
    @XmlElement(name = "TabParceiro")
    protected TableOfZsdeConsCpfCnpjWebs tabParceiro;

    /**
     * Obtém o valor da propriedade iChAcesso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIChAcesso() {
        return iChAcesso;
    }

    /**
     * Define o valor da propriedade iChAcesso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIChAcesso(String value) {
        this.iChAcesso = value;
    }

    /**
     * Obtém o valor da propriedade iCpfCnpj.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICpfCnpj() {
        return iCpfCnpj;
    }

    /**
     * Define o valor da propriedade iCpfCnpj.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICpfCnpj(String value) {
        this.iCpfCnpj = value;
    }

    /**
     * Obtém o valor da propriedade iTpParceiro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getITpParceiro() {
        return iTpParceiro;
    }

    /**
     * Define o valor da propriedade iTpParceiro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setITpParceiro(String value) {
        this.iTpParceiro = value;
    }

    /**
     * Obtém o valor da propriedade iTpPessoa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getITpPessoa() {
        return iTpPessoa;
    }

    /**
     * Define o valor da propriedade iTpPessoa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setITpPessoa(String value) {
        this.iTpPessoa = value;
    }

    /**
     * Obtém o valor da propriedade tabParceiro.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeConsCpfCnpjWebs }
     *     
     */
    public TableOfZsdeConsCpfCnpjWebs getTabParceiro() {
        return tabParceiro;
    }

    /**
     * Define o valor da propriedade tabParceiro.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeConsCpfCnpjWebs }
     *     
     */
    public void setTabParceiro(TableOfZsdeConsCpfCnpjWebs value) {
        this.tabParceiro = value;
    }

}

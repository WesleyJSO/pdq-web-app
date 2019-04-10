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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ZsdeConsCpfCnpjWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeConsCpfCnpjWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TpParceiro" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="TpPessoa" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="CpfCnpj" type="{urn:sap-com:document:sap:rfc:functions}char14"/&gt;
 *         &lt;element name="CdParceiro" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="DcParceiro" type="{urn:sap-com:document:sap:rfc:functions}char70"/&gt;
 *         &lt;element name="Cidade" type="{urn:sap-com:document:sap:rfc:functions}char35"/&gt;
 *         &lt;element name="Uf" type="{urn:sap-com:document:sap:rfc:functions}char3"/&gt;
 *         &lt;element name="Pais" type="{urn:sap-com:document:sap:rfc:functions}char3"/&gt;
 *         &lt;element name="InsEstadual" type="{urn:sap-com:document:sap:rfc:functions}char18"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeConsCpfCnpjWebs", propOrder = {
    "tpParceiro",
    "tpPessoa",
    "cpfCnpj",
    "cdParceiro",
    "dcParceiro",
    "cidade",
    "uf",
    "pais",
    "insEstadual"
})
public class ZsdeConsCpfCnpjWebs {

    @XmlElement(name = "TpParceiro", required = true)
    protected String tpParceiro;
    @XmlElement(name = "TpPessoa", required = true)
    protected String tpPessoa;
    @XmlElement(name = "CpfCnpj", required = true)
    protected String cpfCnpj;
    @XmlElement(name = "CdParceiro", required = true)
    protected String cdParceiro;
    @XmlElement(name = "DcParceiro", required = true)
    protected String dcParceiro;
    @XmlElement(name = "Cidade", required = true)
    protected String cidade;
    @XmlElement(name = "Uf", required = true)
    protected String uf;
    @XmlElement(name = "Pais", required = true)
    protected String pais;
    @XmlElement(name = "InsEstadual", required = true)
    protected String insEstadual;

    /**
     * Obtém o valor da propriedade tpParceiro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpParceiro() {
        return tpParceiro;
    }

    /**
     * Define o valor da propriedade tpParceiro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpParceiro(String value) {
        this.tpParceiro = value;
    }

    /**
     * Obtém o valor da propriedade tpPessoa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpPessoa() {
        return tpPessoa;
    }

    /**
     * Define o valor da propriedade tpPessoa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpPessoa(String value) {
        this.tpPessoa = value;
    }

    /**
     * Obtém o valor da propriedade cpfCnpj.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCpfCnpj() {
        return cpfCnpj;
    }

    /**
     * Define o valor da propriedade cpfCnpj.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCpfCnpj(String value) {
        this.cpfCnpj = value;
    }

    /**
     * Obtém o valor da propriedade cdParceiro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdParceiro() {
        return cdParceiro;
    }

    /**
     * Define o valor da propriedade cdParceiro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdParceiro(String value) {
        this.cdParceiro = value;
    }

    /**
     * Obtém o valor da propriedade dcParceiro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcParceiro() {
        return dcParceiro;
    }

    /**
     * Define o valor da propriedade dcParceiro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcParceiro(String value) {
        this.dcParceiro = value;
    }

    /**
     * Obtém o valor da propriedade cidade.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Define o valor da propriedade cidade.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCidade(String value) {
        this.cidade = value;
    }

    /**
     * Obtém o valor da propriedade uf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUf() {
        return uf;
    }

    /**
     * Define o valor da propriedade uf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUf(String value) {
        this.uf = value;
    }

    /**
     * Obtém o valor da propriedade pais.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPais() {
        return pais;
    }

    /**
     * Define o valor da propriedade pais.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPais(String value) {
        this.pais = value;
    }

    /**
     * Obtém o valor da propriedade insEstadual.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsEstadual() {
        return insEstadual;
    }

    /**
     * Define o valor da propriedade insEstadual.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsEstadual(String value) {
        this.insEstadual = value;
    }

}

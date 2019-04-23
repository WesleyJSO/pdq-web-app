//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:50:32 PM BRT 
//


package com.s3.sap.z_transportadora_sap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ZsdeAgFreteWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeAgFreteWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TpRegistro" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="CdEmpresa" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="DcEmpresa" type="{urn:sap-com:document:sap:rfc:functions}char25"/&gt;
 *         &lt;element name="CdTransp" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="DcTransp" type="{urn:sap-com:document:sap:rfc:functions}char70"/&gt;
 *         &lt;element name="CdGrConta" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="Endereco" type="{urn:sap-com:document:sap:rfc:functions}char60"/&gt;
 *         &lt;element name="Numero" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="Complemento" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="Bairro" type="{urn:sap-com:document:sap:rfc:functions}char35"/&gt;
 *         &lt;element name="Cep" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="Cidade" type="{urn:sap-com:document:sap:rfc:functions}char35"/&gt;
 *         &lt;element name="Uf" type="{urn:sap-com:document:sap:rfc:functions}char3"/&gt;
 *         &lt;element name="Pais" type="{urn:sap-com:document:sap:rfc:functions}char3"/&gt;
 *         &lt;element name="Telefone" type="{urn:sap-com:document:sap:rfc:functions}char16"/&gt;
 *         &lt;element name="Cnpj" type="{urn:sap-com:document:sap:rfc:functions}char16"/&gt;
 *         &lt;element name="Cpf" type="{urn:sap-com:document:sap:rfc:functions}char11"/&gt;
 *         &lt;element name="InsEstadual" type="{urn:sap-com:document:sap:rfc:functions}char18"/&gt;
 *         &lt;element name="CdDomFiscal" type="{urn:sap-com:document:sap:rfc:functions}char15"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeAgFreteWebs", propOrder = {
    "tpRegistro",
    "cdEmpresa",
    "dcEmpresa",
    "cdTransp",
    "dcTransp",
    "cdGrConta",
    "endereco",
    "numero",
    "complemento",
    "bairro",
    "cep",
    "cidade",
    "uf",
    "pais",
    "telefone",
    "cnpj",
    "cpf",
    "insEstadual",
    "cdDomFiscal"
})
public class ZsdeAgFreteWebs {

    @XmlElement(name = "TpRegistro", required = true)
    protected String tpRegistro;
    @XmlElement(name = "CdEmpresa", required = true)
    protected String cdEmpresa;
    @XmlElement(name = "DcEmpresa", required = true)
    protected String dcEmpresa;
    @XmlElement(name = "CdTransp", required = true)
    protected String cdTransp;
    @XmlElement(name = "DcTransp", required = true)
    protected String dcTransp;
    @XmlElement(name = "CdGrConta", required = true)
    protected String cdGrConta;
    @XmlElement(name = "Endereco", required = true)
    protected String endereco;
    @XmlElement(name = "Numero", required = true)
    protected String numero;
    @XmlElement(name = "Complemento", required = true)
    protected String complemento;
    @XmlElement(name = "Bairro", required = true)
    protected String bairro;
    @XmlElement(name = "Cep", required = true)
    protected String cep;
    @XmlElement(name = "Cidade", required = true)
    protected String cidade;
    @XmlElement(name = "Uf", required = true)
    protected String uf;
    @XmlElement(name = "Pais", required = true)
    protected String pais;
    @XmlElement(name = "Telefone", required = true)
    protected String telefone;
    @XmlElement(name = "Cnpj", required = true)
    protected String cnpj;
    @XmlElement(name = "Cpf", required = true)
    protected String cpf;
    @XmlElement(name = "InsEstadual", required = true)
    protected String insEstadual;
    @XmlElement(name = "CdDomFiscal", required = true)
    protected String cdDomFiscal;

    /**
     * Obtém o valor da propriedade tpRegistro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpRegistro() {
        return tpRegistro;
    }

    /**
     * Define o valor da propriedade tpRegistro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpRegistro(String value) {
        this.tpRegistro = value;
    }

    /**
     * Obtém o valor da propriedade cdEmpresa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdEmpresa() {
        return cdEmpresa;
    }

    /**
     * Define o valor da propriedade cdEmpresa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdEmpresa(String value) {
        this.cdEmpresa = value;
    }

    /**
     * Obtém o valor da propriedade dcEmpresa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcEmpresa() {
        return dcEmpresa;
    }

    /**
     * Define o valor da propriedade dcEmpresa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcEmpresa(String value) {
        this.dcEmpresa = value;
    }

    /**
     * Obtém o valor da propriedade cdTransp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdTransp() {
        return cdTransp;
    }

    /**
     * Define o valor da propriedade cdTransp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdTransp(String value) {
        this.cdTransp = value;
    }

    /**
     * Obtém o valor da propriedade dcTransp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcTransp() {
        return dcTransp;
    }

    /**
     * Define o valor da propriedade dcTransp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcTransp(String value) {
        this.dcTransp = value;
    }

    /**
     * Obtém o valor da propriedade cdGrConta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdGrConta() {
        return cdGrConta;
    }

    /**
     * Define o valor da propriedade cdGrConta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdGrConta(String value) {
        this.cdGrConta = value;
    }

    /**
     * Obtém o valor da propriedade endereco.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o valor da propriedade endereco.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndereco(String value) {
        this.endereco = value;
    }

    /**
     * Obtém o valor da propriedade numero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Define o valor da propriedade numero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumero(String value) {
        this.numero = value;
    }

    /**
     * Obtém o valor da propriedade complemento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * Define o valor da propriedade complemento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComplemento(String value) {
        this.complemento = value;
    }

    /**
     * Obtém o valor da propriedade bairro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Define o valor da propriedade bairro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBairro(String value) {
        this.bairro = value;
    }

    /**
     * Obtém o valor da propriedade cep.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCep() {
        return cep;
    }

    /**
     * Define o valor da propriedade cep.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCep(String value) {
        this.cep = value;
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
     * Obtém o valor da propriedade telefone.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o valor da propriedade telefone.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefone(String value) {
        this.telefone = value;
    }

    /**
     * Obtém o valor da propriedade cnpj.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Define o valor da propriedade cnpj.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCnpj(String value) {
        this.cnpj = value;
    }

    /**
     * Obtém o valor da propriedade cpf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o valor da propriedade cpf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCpf(String value) {
        this.cpf = value;
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

    /**
     * Obtém o valor da propriedade cdDomFiscal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdDomFiscal() {
        return cdDomFiscal;
    }

    /**
     * Define o valor da propriedade cdDomFiscal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdDomFiscal(String value) {
        this.cdDomFiscal = value;
    }

}

//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:50:29 PM BRT 
//


package com.s3.sap.z_cliente_sap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ZsdeClienteWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeClienteWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TpRegistro" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="CdEmpresa" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="DcEmpresa" type="{urn:sap-com:document:sap:rfc:functions}char25"/&gt;
 *         &lt;element name="CdOrgVenda" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="CdCanalDistr" type="{urn:sap-com:document:sap:rfc:functions}char2"/&gt;
 *         &lt;element name="CdSetAtiv" type="{urn:sap-com:document:sap:rfc:functions}char2"/&gt;
 *         &lt;element name="CdEscrVenda" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="CdCliente" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="DcCliente" type="{urn:sap-com:document:sap:rfc:functions}char70"/&gt;
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
 *         &lt;element name="CdExtCliente" type="{urn:sap-com:document:sap:rfc:functions}char50"/&gt;
 *         &lt;element name="CdSetInd" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="Email" type="{urn:sap-com:document:sap:soap:functions:mc-style}char132"/&gt;
 *         &lt;element name="EmailNfe" type="{urn:sap-com:document:sap:soap:functions:mc-style}char132"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeClienteWebs", propOrder = {
    "tpRegistro",
    "cdEmpresa",
    "dcEmpresa",
    "cdOrgVenda",
    "cdCanalDistr",
    "cdSetAtiv",
    "cdEscrVenda",
    "cdCliente",
    "dcCliente",
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
    "cdDomFiscal",
    "cdExtCliente",
    "cdSetInd",
    "email",
    "emailNfe"
})
public class ZsdeClienteWebs {

    @XmlElement(name = "TpRegistro", required = true)
    protected String tpRegistro;
    @XmlElement(name = "CdEmpresa", required = true)
    protected String cdEmpresa;
    @XmlElement(name = "DcEmpresa", required = true)
    protected String dcEmpresa;
    @XmlElement(name = "CdOrgVenda", required = true)
    protected String cdOrgVenda;
    @XmlElement(name = "CdCanalDistr", required = true)
    protected String cdCanalDistr;
    @XmlElement(name = "CdSetAtiv", required = true)
    protected String cdSetAtiv;
    @XmlElement(name = "CdEscrVenda", required = true)
    protected String cdEscrVenda;
    @XmlElement(name = "CdCliente", required = true)
    protected String cdCliente;
    @XmlElement(name = "DcCliente", required = true)
    protected String dcCliente;
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
    @XmlElement(name = "CdExtCliente", required = true)
    protected String cdExtCliente;
    @XmlElement(name = "CdSetInd", required = true)
    protected String cdSetInd;
    @XmlElement(name = "Email", required = true)
    protected String email;
    @XmlElement(name = "EmailNfe", required = true)
    protected String emailNfe;

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
     * Obtém o valor da propriedade cdOrgVenda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdOrgVenda() {
        return cdOrgVenda;
    }

    /**
     * Define o valor da propriedade cdOrgVenda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdOrgVenda(String value) {
        this.cdOrgVenda = value;
    }

    /**
     * Obtém o valor da propriedade cdCanalDistr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdCanalDistr() {
        return cdCanalDistr;
    }

    /**
     * Define o valor da propriedade cdCanalDistr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdCanalDistr(String value) {
        this.cdCanalDistr = value;
    }

    /**
     * Obtém o valor da propriedade cdSetAtiv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdSetAtiv() {
        return cdSetAtiv;
    }

    /**
     * Define o valor da propriedade cdSetAtiv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdSetAtiv(String value) {
        this.cdSetAtiv = value;
    }

    /**
     * Obtém o valor da propriedade cdEscrVenda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdEscrVenda() {
        return cdEscrVenda;
    }

    /**
     * Define o valor da propriedade cdEscrVenda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdEscrVenda(String value) {
        this.cdEscrVenda = value;
    }

    /**
     * Obtém o valor da propriedade cdCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdCliente() {
        return cdCliente;
    }

    /**
     * Define o valor da propriedade cdCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdCliente(String value) {
        this.cdCliente = value;
    }

    /**
     * Obtém o valor da propriedade dcCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcCliente() {
        return dcCliente;
    }

    /**
     * Define o valor da propriedade dcCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcCliente(String value) {
        this.dcCliente = value;
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

    /**
     * Obtém o valor da propriedade cdExtCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdExtCliente() {
        return cdExtCliente;
    }

    /**
     * Define o valor da propriedade cdExtCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdExtCliente(String value) {
        this.cdExtCliente = value;
    }

    /**
     * Obtém o valor da propriedade cdSetInd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdSetInd() {
        return cdSetInd;
    }

    /**
     * Define o valor da propriedade cdSetInd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdSetInd(String value) {
        this.cdSetInd = value;
    }

    /**
     * Obtém o valor da propriedade email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o valor da propriedade email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Obtém o valor da propriedade emailNfe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailNfe() {
        return emailNfe;
    }

    /**
     * Define o valor da propriedade emailNfe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailNfe(String value) {
        this.emailNfe = value;
    }

}

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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ZmmePreCadClienteWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZmmePreCadClienteWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TpRegistro" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="CdOrgVenda" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="CdCanalDistr" type="{urn:sap-com:document:sap:rfc:functions}char2"/&gt;
 *         &lt;element name="CdGrConta" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="SetorIndus" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="CdExtParceiro" type="{urn:sap-com:document:sap:rfc:functions}char50"/&gt;
 *         &lt;element name="DcCliente" type="{urn:sap-com:document:sap:rfc:functions}char70"/&gt;
 *         &lt;element name="TermoPesq" type="{urn:sap-com:document:sap:rfc:functions}char20"/&gt;
 *         &lt;element name="Endereco" type="{urn:sap-com:document:sap:rfc:functions}char60"/&gt;
 *         &lt;element name="Numero" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="Complemento" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="Rua2" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="Rua3" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="Rua4" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="Rua5" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="Bairro" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="Cep" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="Cidade" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="Uf" type="{urn:sap-com:document:sap:rfc:functions}char3"/&gt;
 *         &lt;element name="Pais" type="{urn:sap-com:document:sap:rfc:functions}char3"/&gt;
 *         &lt;element name="CaixaPostal" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="Telefone" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *         &lt;element name="Ramal" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="Celular" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *         &lt;element name="Cnpj" type="{urn:sap-com:document:sap:rfc:functions}char16"/&gt;
 *         &lt;element name="Cpf" type="{urn:sap-com:document:sap:rfc:functions}char11"/&gt;
 *         &lt;element name="InsEstadual" type="{urn:sap-com:document:sap:rfc:functions}char18"/&gt;
 *         &lt;element name="Suframa" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="ZonaFranca" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="Email" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="EmailNfe" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="EmailBoleto1" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="EmailBoleto2" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="EmailBoleto3" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="CpfCob" type="{urn:sap-com:document:sap:rfc:functions}char11"/&gt;
 *         &lt;element name="CnpjCob" type="{urn:sap-com:document:sap:rfc:functions}char16"/&gt;
 *         &lt;element name="InsEstCob" type="{urn:sap-com:document:sap:rfc:functions}char18"/&gt;
 *         &lt;element name="EndCob" type="{urn:sap-com:document:sap:rfc:functions}char60"/&gt;
 *         &lt;element name="NumeroCob" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="ComplementoCob" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="BairroCob" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="CepCob" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="CidadeCob" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="UfCob" type="{urn:sap-com:document:sap:rfc:functions}char3"/&gt;
 *         &lt;element name="PaisCob" type="{urn:sap-com:document:sap:rfc:functions}char3"/&gt;
 *         &lt;element name="TelefoneCob" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *         &lt;element name="RamalCob" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="CaixaPostalCob" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZmmePreCadClienteWebs", propOrder = {
    "tpRegistro",
    "cdOrgVenda",
    "cdCanalDistr",
    "cdGrConta",
    "setorIndus",
    "cdExtParceiro",
    "dcCliente",
    "termoPesq",
    "endereco",
    "numero",
    "complemento",
    "rua2",
    "rua3",
    "rua4",
    "rua5",
    "bairro",
    "cep",
    "cidade",
    "uf",
    "pais",
    "caixaPostal",
    "telefone",
    "ramal",
    "celular",
    "cnpj",
    "cpf",
    "insEstadual",
    "suframa",
    "zonaFranca",
    "email",
    "emailNfe",
    "emailBoleto1",
    "emailBoleto2",
    "emailBoleto3",
    "cpfCob",
    "cnpjCob",
    "insEstCob",
    "endCob",
    "numeroCob",
    "complementoCob",
    "bairroCob",
    "cepCob",
    "cidadeCob",
    "ufCob",
    "paisCob",
    "telefoneCob",
    "ramalCob",
    "caixaPostalCob"
})
public class ZmmePreCadClienteWebs {

    @XmlElement(name = "TpRegistro", required = true)
    protected String tpRegistro;
    @XmlElement(name = "CdOrgVenda", required = true)
    protected String cdOrgVenda;
    @XmlElement(name = "CdCanalDistr", required = true)
    protected String cdCanalDistr;
    @XmlElement(name = "CdGrConta", required = true)
    protected String cdGrConta;
    @XmlElement(name = "SetorIndus", required = true)
    protected String setorIndus;
    @XmlElement(name = "CdExtParceiro", required = true)
    protected String cdExtParceiro;
    @XmlElement(name = "DcCliente", required = true)
    protected String dcCliente;
    @XmlElement(name = "TermoPesq", required = true)
    protected String termoPesq;
    @XmlElement(name = "Endereco", required = true)
    protected String endereco;
    @XmlElement(name = "Numero", required = true)
    protected String numero;
    @XmlElement(name = "Complemento", required = true)
    protected String complemento;
    @XmlElement(name = "Rua2", required = true)
    protected String rua2;
    @XmlElement(name = "Rua3", required = true)
    protected String rua3;
    @XmlElement(name = "Rua4", required = true)
    protected String rua4;
    @XmlElement(name = "Rua5", required = true)
    protected String rua5;
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
    @XmlElement(name = "CaixaPostal", required = true)
    protected String caixaPostal;
    @XmlElement(name = "Telefone", required = true)
    protected String telefone;
    @XmlElement(name = "Ramal", required = true)
    protected String ramal;
    @XmlElement(name = "Celular", required = true)
    protected String celular;
    @XmlElement(name = "Cnpj", required = true)
    protected String cnpj;
    @XmlElement(name = "Cpf", required = true)
    protected String cpf;
    @XmlElement(name = "InsEstadual", required = true)
    protected String insEstadual;
    @XmlElement(name = "Suframa", required = true)
    protected String suframa;
    @XmlElement(name = "ZonaFranca", required = true)
    protected String zonaFranca;
    @XmlElement(name = "Email", required = true)
    protected String email;
    @XmlElement(name = "EmailNfe", required = true)
    protected String emailNfe;
    @XmlElement(name = "EmailBoleto1", required = true)
    protected String emailBoleto1;
    @XmlElement(name = "EmailBoleto2", required = true)
    protected String emailBoleto2;
    @XmlElement(name = "EmailBoleto3", required = true)
    protected String emailBoleto3;
    @XmlElement(name = "CpfCob", required = true)
    protected String cpfCob;
    @XmlElement(name = "CnpjCob", required = true)
    protected String cnpjCob;
    @XmlElement(name = "InsEstCob", required = true)
    protected String insEstCob;
    @XmlElement(name = "EndCob", required = true)
    protected String endCob;
    @XmlElement(name = "NumeroCob", required = true)
    protected String numeroCob;
    @XmlElement(name = "ComplementoCob", required = true)
    protected String complementoCob;
    @XmlElement(name = "BairroCob", required = true)
    protected String bairroCob;
    @XmlElement(name = "CepCob", required = true)
    protected String cepCob;
    @XmlElement(name = "CidadeCob", required = true)
    protected String cidadeCob;
    @XmlElement(name = "UfCob", required = true)
    protected String ufCob;
    @XmlElement(name = "PaisCob", required = true)
    protected String paisCob;
    @XmlElement(name = "TelefoneCob", required = true)
    protected String telefoneCob;
    @XmlElement(name = "RamalCob", required = true)
    protected String ramalCob;
    @XmlElement(name = "CaixaPostalCob", required = true)
    protected String caixaPostalCob;

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
     * Obtém o valor da propriedade setorIndus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSetorIndus() {
        return setorIndus;
    }

    /**
     * Define o valor da propriedade setorIndus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSetorIndus(String value) {
        this.setorIndus = value;
    }

    /**
     * Obtém o valor da propriedade cdExtParceiro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdExtParceiro() {
        return cdExtParceiro;
    }

    /**
     * Define o valor da propriedade cdExtParceiro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdExtParceiro(String value) {
        this.cdExtParceiro = value;
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
     * Obtém o valor da propriedade termoPesq.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermoPesq() {
        return termoPesq;
    }

    /**
     * Define o valor da propriedade termoPesq.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermoPesq(String value) {
        this.termoPesq = value;
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
     * Obtém o valor da propriedade rua2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRua2() {
        return rua2;
    }

    /**
     * Define o valor da propriedade rua2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRua2(String value) {
        this.rua2 = value;
    }

    /**
     * Obtém o valor da propriedade rua3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRua3() {
        return rua3;
    }

    /**
     * Define o valor da propriedade rua3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRua3(String value) {
        this.rua3 = value;
    }

    /**
     * Obtém o valor da propriedade rua4.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRua4() {
        return rua4;
    }

    /**
     * Define o valor da propriedade rua4.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRua4(String value) {
        this.rua4 = value;
    }

    /**
     * Obtém o valor da propriedade rua5.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRua5() {
        return rua5;
    }

    /**
     * Define o valor da propriedade rua5.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRua5(String value) {
        this.rua5 = value;
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
     * Obtém o valor da propriedade caixaPostal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaixaPostal() {
        return caixaPostal;
    }

    /**
     * Define o valor da propriedade caixaPostal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaixaPostal(String value) {
        this.caixaPostal = value;
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
     * Obtém o valor da propriedade ramal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRamal() {
        return ramal;
    }

    /**
     * Define o valor da propriedade ramal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRamal(String value) {
        this.ramal = value;
    }

    /**
     * Obtém o valor da propriedade celular.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Define o valor da propriedade celular.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCelular(String value) {
        this.celular = value;
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
     * Obtém o valor da propriedade suframa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuframa() {
        return suframa;
    }

    /**
     * Define o valor da propriedade suframa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuframa(String value) {
        this.suframa = value;
    }

    /**
     * Obtém o valor da propriedade zonaFranca.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZonaFranca() {
        return zonaFranca;
    }

    /**
     * Define o valor da propriedade zonaFranca.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZonaFranca(String value) {
        this.zonaFranca = value;
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

    /**
     * Obtém o valor da propriedade emailBoleto1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailBoleto1() {
        return emailBoleto1;
    }

    /**
     * Define o valor da propriedade emailBoleto1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailBoleto1(String value) {
        this.emailBoleto1 = value;
    }

    /**
     * Obtém o valor da propriedade emailBoleto2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailBoleto2() {
        return emailBoleto2;
    }

    /**
     * Define o valor da propriedade emailBoleto2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailBoleto2(String value) {
        this.emailBoleto2 = value;
    }

    /**
     * Obtém o valor da propriedade emailBoleto3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailBoleto3() {
        return emailBoleto3;
    }

    /**
     * Define o valor da propriedade emailBoleto3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailBoleto3(String value) {
        this.emailBoleto3 = value;
    }

    /**
     * Obtém o valor da propriedade cpfCob.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCpfCob() {
        return cpfCob;
    }

    /**
     * Define o valor da propriedade cpfCob.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCpfCob(String value) {
        this.cpfCob = value;
    }

    /**
     * Obtém o valor da propriedade cnpjCob.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCnpjCob() {
        return cnpjCob;
    }

    /**
     * Define o valor da propriedade cnpjCob.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCnpjCob(String value) {
        this.cnpjCob = value;
    }

    /**
     * Obtém o valor da propriedade insEstCob.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsEstCob() {
        return insEstCob;
    }

    /**
     * Define o valor da propriedade insEstCob.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsEstCob(String value) {
        this.insEstCob = value;
    }

    /**
     * Obtém o valor da propriedade endCob.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndCob() {
        return endCob;
    }

    /**
     * Define o valor da propriedade endCob.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndCob(String value) {
        this.endCob = value;
    }

    /**
     * Obtém o valor da propriedade numeroCob.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroCob() {
        return numeroCob;
    }

    /**
     * Define o valor da propriedade numeroCob.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroCob(String value) {
        this.numeroCob = value;
    }

    /**
     * Obtém o valor da propriedade complementoCob.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComplementoCob() {
        return complementoCob;
    }

    /**
     * Define o valor da propriedade complementoCob.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComplementoCob(String value) {
        this.complementoCob = value;
    }

    /**
     * Obtém o valor da propriedade bairroCob.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBairroCob() {
        return bairroCob;
    }

    /**
     * Define o valor da propriedade bairroCob.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBairroCob(String value) {
        this.bairroCob = value;
    }

    /**
     * Obtém o valor da propriedade cepCob.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCepCob() {
        return cepCob;
    }

    /**
     * Define o valor da propriedade cepCob.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCepCob(String value) {
        this.cepCob = value;
    }

    /**
     * Obtém o valor da propriedade cidadeCob.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCidadeCob() {
        return cidadeCob;
    }

    /**
     * Define o valor da propriedade cidadeCob.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCidadeCob(String value) {
        this.cidadeCob = value;
    }

    /**
     * Obtém o valor da propriedade ufCob.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUfCob() {
        return ufCob;
    }

    /**
     * Define o valor da propriedade ufCob.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUfCob(String value) {
        this.ufCob = value;
    }

    /**
     * Obtém o valor da propriedade paisCob.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaisCob() {
        return paisCob;
    }

    /**
     * Define o valor da propriedade paisCob.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaisCob(String value) {
        this.paisCob = value;
    }

    /**
     * Obtém o valor da propriedade telefoneCob.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefoneCob() {
        return telefoneCob;
    }

    /**
     * Define o valor da propriedade telefoneCob.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefoneCob(String value) {
        this.telefoneCob = value;
    }

    /**
     * Obtém o valor da propriedade ramalCob.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRamalCob() {
        return ramalCob;
    }

    /**
     * Define o valor da propriedade ramalCob.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRamalCob(String value) {
        this.ramalCob = value;
    }

    /**
     * Obtém o valor da propriedade caixaPostalCob.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaixaPostalCob() {
        return caixaPostalCob;
    }

    /**
     * Define o valor da propriedade caixaPostalCob.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaixaPostalCob(String value) {
        this.caixaPostalCob = value;
    }

}

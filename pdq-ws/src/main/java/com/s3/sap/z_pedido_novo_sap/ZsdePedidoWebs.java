//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:50:30 PM BRT 
//


package com.s3.sap.z_pedido_novo_sap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ZsdePedidoWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdePedidoWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdSequencia" type="{urn:sap-com:document:sap:rfc:functions}numeric3"/&gt;
 *         &lt;element name="TpPedido" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="NrPedido" type="{urn:sap-com:document:sap:rfc:functions}char15"/&gt;
 *         &lt;element name="DtPedido" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="NrPedidoCli" type="{urn:sap-com:document:sap:rfc:functions}char15"/&gt;
 *         &lt;element name="CdEmissor" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="CdRecebedor" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="CdPagador" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="CdMotivoOrd" type="{urn:sap-com:document:sap:rfc:functions}char3"/&gt;
 *         &lt;element name="CdMoeda" type="{urn:sap-com:document:sap:rfc:functions}char5"/&gt;
 *         &lt;element name="CdOrgVenda" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="CdCanalDistr" type="{urn:sap-com:document:sap:rfc:functions}char2"/&gt;
 *         &lt;element name="CdSetAtiv" type="{urn:sap-com:document:sap:rfc:functions}char2"/&gt;
 *         &lt;element name="CdMaterial" type="{urn:sap-com:document:sap:rfc:functions}char18"/&gt;
 *         &lt;element name="DcMaterial" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="CdUtilMat" type="{urn:sap-com:document:sap:rfc:functions}char3"/&gt;
 *         &lt;element name="CdCentro" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="CdIncoterms" type="{urn:sap-com:document:sap:rfc:functions}char3"/&gt;
 *         &lt;element name="CondPagto" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="QtMaterial" type="{urn:sap-com:document:sap:rfc:functions}numeric12"/&gt;
 *         &lt;element name="VlUnMaterial" type="{urn:sap-com:document:sap:rfc:functions}numeric11"/&gt;
 *         &lt;element name="UnMedVenda" type="{urn:sap-com:document:sap:rfc:functions}unit3"/&gt;
 *         &lt;element name="TxCambio" type="{urn:sap-com:document:sap:rfc:functions}numeric9"/&gt;
 *         &lt;element name="DtTxCambio" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="CdCentroLucro" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="DtRemessa" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="UnPreco" type="{urn:sap-com:document:sap:rfc:functions}numeric5"/&gt;
 *         &lt;element name="CdAgFrete" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="VlFrete" type="{urn:sap-com:document:sap:rfc:functions}numeric11"/&gt;
 *         &lt;element name="CdSupVda" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="PerComisSup" type="{urn:sap-com:document:sap:rfc:functions}numeric12"/&gt;
 *         &lt;element name="CdVendedor" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="PerComisVen" type="{urn:sap-com:document:sap:rfc:functions}numeric12"/&gt;
 *         &lt;element name="DcTextoNf1" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="DcTextoNf2" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="DcTextoNf3" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="DcTextoNf4" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="DcTextoCar1" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="DcTextoCar2" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="DcTextoCar3" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="DcTextoCar4" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="DcTextoTra1" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="DcTextoTra2" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="DcTextoTra3" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="DcTextoTra4" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="DcTextoCom1" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="DcTextoCom2" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="DcTextoCom3" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="DcTextoCom4" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="NrOrdVenda" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="TpEmb" type="{urn:sap-com:document:sap:soap:functions:mc-style}char4"/&gt;
 *         &lt;element name="DtFixa" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="CdVenEstat" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdePedidoWebs", propOrder = {
    "idSequencia",
    "tpPedido",
    "nrPedido",
    "dtPedido",
    "nrPedidoCli",
    "cdEmissor",
    "cdRecebedor",
    "cdPagador",
    "cdMotivoOrd",
    "cdMoeda",
    "cdOrgVenda",
    "cdCanalDistr",
    "cdSetAtiv",
    "cdMaterial",
    "dcMaterial",
    "cdUtilMat",
    "cdCentro",
    "cdIncoterms",
    "condPagto",
    "qtMaterial",
    "vlUnMaterial",
    "unMedVenda",
    "txCambio",
    "dtTxCambio",
    "cdCentroLucro",
    "dtRemessa",
    "unPreco",
    "cdAgFrete",
    "vlFrete",
    "cdSupVda",
    "perComisSup",
    "cdVendedor",
    "perComisVen",
    "dcTextoNf1",
    "dcTextoNf2",
    "dcTextoNf3",
    "dcTextoNf4",
    "dcTextoCar1",
    "dcTextoCar2",
    "dcTextoCar3",
    "dcTextoCar4",
    "dcTextoTra1",
    "dcTextoTra2",
    "dcTextoTra3",
    "dcTextoTra4",
    "dcTextoCom1",
    "dcTextoCom2",
    "dcTextoCom3",
    "dcTextoCom4",
    "nrOrdVenda",
    "tpEmb",
    "dtFixa",
    "cdVenEstat"
})
public class ZsdePedidoWebs {

    @XmlElement(name = "IdSequencia", required = true)
    protected String idSequencia;
    @XmlElement(name = "TpPedido", required = true)
    protected String tpPedido;
    @XmlElement(name = "NrPedido", required = true)
    protected String nrPedido;
    @XmlElement(name = "DtPedido", required = true)
    protected String dtPedido;
    @XmlElement(name = "NrPedidoCli", required = true)
    protected String nrPedidoCli;
    @XmlElement(name = "CdEmissor", required = true)
    protected String cdEmissor;
    @XmlElement(name = "CdRecebedor", required = true)
    protected String cdRecebedor;
    @XmlElement(name = "CdPagador", required = true)
    protected String cdPagador;
    @XmlElement(name = "CdMotivoOrd", required = true)
    protected String cdMotivoOrd;
    @XmlElement(name = "CdMoeda", required = true)
    protected String cdMoeda;
    @XmlElement(name = "CdOrgVenda", required = true)
    protected String cdOrgVenda;
    @XmlElement(name = "CdCanalDistr", required = true)
    protected String cdCanalDistr;
    @XmlElement(name = "CdSetAtiv", required = true)
    protected String cdSetAtiv;
    @XmlElement(name = "CdMaterial", required = true)
    protected String cdMaterial;
    @XmlElement(name = "DcMaterial", required = true)
    protected String dcMaterial;
    @XmlElement(name = "CdUtilMat", required = true)
    protected String cdUtilMat;
    @XmlElement(name = "CdCentro", required = true)
    protected String cdCentro;
    @XmlElement(name = "CdIncoterms", required = true)
    protected String cdIncoterms;
    @XmlElement(name = "CondPagto", required = true)
    protected String condPagto;
    @XmlElement(name = "QtMaterial", required = true)
    protected String qtMaterial;
    @XmlElement(name = "VlUnMaterial", required = true)
    protected String vlUnMaterial;
    @XmlElement(name = "UnMedVenda", required = true)
    protected String unMedVenda;
    @XmlElement(name = "TxCambio", required = true)
    protected String txCambio;
    @XmlElement(name = "DtTxCambio", required = true)
    protected String dtTxCambio;
    @XmlElement(name = "CdCentroLucro", required = true)
    protected String cdCentroLucro;
    @XmlElement(name = "DtRemessa", required = true)
    protected String dtRemessa;
    @XmlElement(name = "UnPreco", required = true)
    protected String unPreco;
    @XmlElement(name = "CdAgFrete", required = true)
    protected String cdAgFrete;
    @XmlElement(name = "VlFrete", required = true)
    protected String vlFrete;
    @XmlElement(name = "CdSupVda", required = true)
    protected String cdSupVda;
    @XmlElement(name = "PerComisSup", required = true)
    protected String perComisSup;
    @XmlElement(name = "CdVendedor", required = true)
    protected String cdVendedor;
    @XmlElement(name = "PerComisVen", required = true)
    protected String perComisVen;
    @XmlElement(name = "DcTextoNf1", required = true)
    protected String dcTextoNf1;
    @XmlElement(name = "DcTextoNf2", required = true)
    protected String dcTextoNf2;
    @XmlElement(name = "DcTextoNf3", required = true)
    protected String dcTextoNf3;
    @XmlElement(name = "DcTextoNf4", required = true)
    protected String dcTextoNf4;
    @XmlElement(name = "DcTextoCar1", required = true)
    protected String dcTextoCar1;
    @XmlElement(name = "DcTextoCar2", required = true)
    protected String dcTextoCar2;
    @XmlElement(name = "DcTextoCar3", required = true)
    protected String dcTextoCar3;
    @XmlElement(name = "DcTextoCar4", required = true)
    protected String dcTextoCar4;
    @XmlElement(name = "DcTextoTra1", required = true)
    protected String dcTextoTra1;
    @XmlElement(name = "DcTextoTra2", required = true)
    protected String dcTextoTra2;
    @XmlElement(name = "DcTextoTra3", required = true)
    protected String dcTextoTra3;
    @XmlElement(name = "DcTextoTra4", required = true)
    protected String dcTextoTra4;
    @XmlElement(name = "DcTextoCom1", required = true)
    protected String dcTextoCom1;
    @XmlElement(name = "DcTextoCom2", required = true)
    protected String dcTextoCom2;
    @XmlElement(name = "DcTextoCom3", required = true)
    protected String dcTextoCom3;
    @XmlElement(name = "DcTextoCom4", required = true)
    protected String dcTextoCom4;
    @XmlElement(name = "NrOrdVenda", required = true)
    protected String nrOrdVenda;
    @XmlElement(name = "TpEmb", required = true)
    protected String tpEmb;
    @XmlElement(name = "DtFixa", required = true)
    protected String dtFixa;
    @XmlElement(name = "CdVenEstat", required = true)
    protected String cdVenEstat;

    /**
     * Obtém o valor da propriedade idSequencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdSequencia() {
        return idSequencia;
    }

    /**
     * Define o valor da propriedade idSequencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdSequencia(String value) {
        this.idSequencia = value;
    }

    /**
     * Obtém o valor da propriedade tpPedido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpPedido() {
        return tpPedido;
    }

    /**
     * Define o valor da propriedade tpPedido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpPedido(String value) {
        this.tpPedido = value;
    }

    /**
     * Obtém o valor da propriedade nrPedido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNrPedido() {
        return nrPedido;
    }

    /**
     * Define o valor da propriedade nrPedido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNrPedido(String value) {
        this.nrPedido = value;
    }

    /**
     * Obtém o valor da propriedade dtPedido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtPedido() {
        return dtPedido;
    }

    /**
     * Define o valor da propriedade dtPedido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtPedido(String value) {
        this.dtPedido = value;
    }

    /**
     * Obtém o valor da propriedade nrPedidoCli.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNrPedidoCli() {
        return nrPedidoCli;
    }

    /**
     * Define o valor da propriedade nrPedidoCli.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNrPedidoCli(String value) {
        this.nrPedidoCli = value;
    }

    /**
     * Obtém o valor da propriedade cdEmissor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdEmissor() {
        return cdEmissor;
    }

    /**
     * Define o valor da propriedade cdEmissor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdEmissor(String value) {
        this.cdEmissor = value;
    }

    /**
     * Obtém o valor da propriedade cdRecebedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdRecebedor() {
        return cdRecebedor;
    }

    /**
     * Define o valor da propriedade cdRecebedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdRecebedor(String value) {
        this.cdRecebedor = value;
    }

    /**
     * Obtém o valor da propriedade cdPagador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdPagador() {
        return cdPagador;
    }

    /**
     * Define o valor da propriedade cdPagador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdPagador(String value) {
        this.cdPagador = value;
    }

    /**
     * Obtém o valor da propriedade cdMotivoOrd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdMotivoOrd() {
        return cdMotivoOrd;
    }

    /**
     * Define o valor da propriedade cdMotivoOrd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdMotivoOrd(String value) {
        this.cdMotivoOrd = value;
    }

    /**
     * Obtém o valor da propriedade cdMoeda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdMoeda() {
        return cdMoeda;
    }

    /**
     * Define o valor da propriedade cdMoeda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdMoeda(String value) {
        this.cdMoeda = value;
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
     * Obtém o valor da propriedade cdMaterial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdMaterial() {
        return cdMaterial;
    }

    /**
     * Define o valor da propriedade cdMaterial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdMaterial(String value) {
        this.cdMaterial = value;
    }

    /**
     * Obtém o valor da propriedade dcMaterial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcMaterial() {
        return dcMaterial;
    }

    /**
     * Define o valor da propriedade dcMaterial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcMaterial(String value) {
        this.dcMaterial = value;
    }

    /**
     * Obtém o valor da propriedade cdUtilMat.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdUtilMat() {
        return cdUtilMat;
    }

    /**
     * Define o valor da propriedade cdUtilMat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdUtilMat(String value) {
        this.cdUtilMat = value;
    }

    /**
     * Obtém o valor da propriedade cdCentro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdCentro() {
        return cdCentro;
    }

    /**
     * Define o valor da propriedade cdCentro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdCentro(String value) {
        this.cdCentro = value;
    }

    /**
     * Obtém o valor da propriedade cdIncoterms.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdIncoterms() {
        return cdIncoterms;
    }

    /**
     * Define o valor da propriedade cdIncoterms.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdIncoterms(String value) {
        this.cdIncoterms = value;
    }

    /**
     * Obtém o valor da propriedade condPagto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCondPagto() {
        return condPagto;
    }

    /**
     * Define o valor da propriedade condPagto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCondPagto(String value) {
        this.condPagto = value;
    }

    /**
     * Obtém o valor da propriedade qtMaterial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQtMaterial() {
        return qtMaterial;
    }

    /**
     * Define o valor da propriedade qtMaterial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQtMaterial(String value) {
        this.qtMaterial = value;
    }

    /**
     * Obtém o valor da propriedade vlUnMaterial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVlUnMaterial() {
        return vlUnMaterial;
    }

    /**
     * Define o valor da propriedade vlUnMaterial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVlUnMaterial(String value) {
        this.vlUnMaterial = value;
    }

    /**
     * Obtém o valor da propriedade unMedVenda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnMedVenda() {
        return unMedVenda;
    }

    /**
     * Define o valor da propriedade unMedVenda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnMedVenda(String value) {
        this.unMedVenda = value;
    }

    /**
     * Obtém o valor da propriedade txCambio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxCambio() {
        return txCambio;
    }

    /**
     * Define o valor da propriedade txCambio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxCambio(String value) {
        this.txCambio = value;
    }

    /**
     * Obtém o valor da propriedade dtTxCambio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtTxCambio() {
        return dtTxCambio;
    }

    /**
     * Define o valor da propriedade dtTxCambio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtTxCambio(String value) {
        this.dtTxCambio = value;
    }

    /**
     * Obtém o valor da propriedade cdCentroLucro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdCentroLucro() {
        return cdCentroLucro;
    }

    /**
     * Define o valor da propriedade cdCentroLucro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdCentroLucro(String value) {
        this.cdCentroLucro = value;
    }

    /**
     * Obtém o valor da propriedade dtRemessa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtRemessa() {
        return dtRemessa;
    }

    /**
     * Define o valor da propriedade dtRemessa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtRemessa(String value) {
        this.dtRemessa = value;
    }

    /**
     * Obtém o valor da propriedade unPreco.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnPreco() {
        return unPreco;
    }

    /**
     * Define o valor da propriedade unPreco.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnPreco(String value) {
        this.unPreco = value;
    }

    /**
     * Obtém o valor da propriedade cdAgFrete.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdAgFrete() {
        return cdAgFrete;
    }

    /**
     * Define o valor da propriedade cdAgFrete.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdAgFrete(String value) {
        this.cdAgFrete = value;
    }

    /**
     * Obtém o valor da propriedade vlFrete.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVlFrete() {
        return vlFrete;
    }

    /**
     * Define o valor da propriedade vlFrete.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVlFrete(String value) {
        this.vlFrete = value;
    }

    /**
     * Obtém o valor da propriedade cdSupVda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdSupVda() {
        return cdSupVda;
    }

    /**
     * Define o valor da propriedade cdSupVda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdSupVda(String value) {
        this.cdSupVda = value;
    }

    /**
     * Obtém o valor da propriedade perComisSup.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPerComisSup() {
        return perComisSup;
    }

    /**
     * Define o valor da propriedade perComisSup.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPerComisSup(String value) {
        this.perComisSup = value;
    }

    /**
     * Obtém o valor da propriedade cdVendedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdVendedor() {
        return cdVendedor;
    }

    /**
     * Define o valor da propriedade cdVendedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdVendedor(String value) {
        this.cdVendedor = value;
    }

    /**
     * Obtém o valor da propriedade perComisVen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPerComisVen() {
        return perComisVen;
    }

    /**
     * Define o valor da propriedade perComisVen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPerComisVen(String value) {
        this.perComisVen = value;
    }

    /**
     * Obtém o valor da propriedade dcTextoNf1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcTextoNf1() {
        return dcTextoNf1;
    }

    /**
     * Define o valor da propriedade dcTextoNf1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcTextoNf1(String value) {
        this.dcTextoNf1 = value;
    }

    /**
     * Obtém o valor da propriedade dcTextoNf2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcTextoNf2() {
        return dcTextoNf2;
    }

    /**
     * Define o valor da propriedade dcTextoNf2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcTextoNf2(String value) {
        this.dcTextoNf2 = value;
    }

    /**
     * Obtém o valor da propriedade dcTextoNf3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcTextoNf3() {
        return dcTextoNf3;
    }

    /**
     * Define o valor da propriedade dcTextoNf3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcTextoNf3(String value) {
        this.dcTextoNf3 = value;
    }

    /**
     * Obtém o valor da propriedade dcTextoNf4.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcTextoNf4() {
        return dcTextoNf4;
    }

    /**
     * Define o valor da propriedade dcTextoNf4.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcTextoNf4(String value) {
        this.dcTextoNf4 = value;
    }

    /**
     * Obtém o valor da propriedade dcTextoCar1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcTextoCar1() {
        return dcTextoCar1;
    }

    /**
     * Define o valor da propriedade dcTextoCar1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcTextoCar1(String value) {
        this.dcTextoCar1 = value;
    }

    /**
     * Obtém o valor da propriedade dcTextoCar2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcTextoCar2() {
        return dcTextoCar2;
    }

    /**
     * Define o valor da propriedade dcTextoCar2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcTextoCar2(String value) {
        this.dcTextoCar2 = value;
    }

    /**
     * Obtém o valor da propriedade dcTextoCar3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcTextoCar3() {
        return dcTextoCar3;
    }

    /**
     * Define o valor da propriedade dcTextoCar3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcTextoCar3(String value) {
        this.dcTextoCar3 = value;
    }

    /**
     * Obtém o valor da propriedade dcTextoCar4.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcTextoCar4() {
        return dcTextoCar4;
    }

    /**
     * Define o valor da propriedade dcTextoCar4.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcTextoCar4(String value) {
        this.dcTextoCar4 = value;
    }

    /**
     * Obtém o valor da propriedade dcTextoTra1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcTextoTra1() {
        return dcTextoTra1;
    }

    /**
     * Define o valor da propriedade dcTextoTra1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcTextoTra1(String value) {
        this.dcTextoTra1 = value;
    }

    /**
     * Obtém o valor da propriedade dcTextoTra2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcTextoTra2() {
        return dcTextoTra2;
    }

    /**
     * Define o valor da propriedade dcTextoTra2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcTextoTra2(String value) {
        this.dcTextoTra2 = value;
    }

    /**
     * Obtém o valor da propriedade dcTextoTra3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcTextoTra3() {
        return dcTextoTra3;
    }

    /**
     * Define o valor da propriedade dcTextoTra3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcTextoTra3(String value) {
        this.dcTextoTra3 = value;
    }

    /**
     * Obtém o valor da propriedade dcTextoTra4.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcTextoTra4() {
        return dcTextoTra4;
    }

    /**
     * Define o valor da propriedade dcTextoTra4.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcTextoTra4(String value) {
        this.dcTextoTra4 = value;
    }

    /**
     * Obtém o valor da propriedade dcTextoCom1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcTextoCom1() {
        return dcTextoCom1;
    }

    /**
     * Define o valor da propriedade dcTextoCom1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcTextoCom1(String value) {
        this.dcTextoCom1 = value;
    }

    /**
     * Obtém o valor da propriedade dcTextoCom2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcTextoCom2() {
        return dcTextoCom2;
    }

    /**
     * Define o valor da propriedade dcTextoCom2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcTextoCom2(String value) {
        this.dcTextoCom2 = value;
    }

    /**
     * Obtém o valor da propriedade dcTextoCom3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcTextoCom3() {
        return dcTextoCom3;
    }

    /**
     * Define o valor da propriedade dcTextoCom3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcTextoCom3(String value) {
        this.dcTextoCom3 = value;
    }

    /**
     * Obtém o valor da propriedade dcTextoCom4.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcTextoCom4() {
        return dcTextoCom4;
    }

    /**
     * Define o valor da propriedade dcTextoCom4.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcTextoCom4(String value) {
        this.dcTextoCom4 = value;
    }

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
     * Obtém o valor da propriedade tpEmb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpEmb() {
        return tpEmb;
    }

    /**
     * Define o valor da propriedade tpEmb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpEmb(String value) {
        this.tpEmb = value;
    }

    /**
     * Obtém o valor da propriedade dtFixa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtFixa() {
        return dtFixa;
    }

    /**
     * Define o valor da propriedade dtFixa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtFixa(String value) {
        this.dtFixa = value;
    }

    /**
     * Obtém o valor da propriedade cdVenEstat.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdVenEstat() {
        return cdVenEstat;
    }

    /**
     * Define o valor da propriedade cdVenEstat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdVenEstat(String value) {
        this.cdVenEstat = value;
    }

}

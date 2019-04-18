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
 * <p>Classe Java de ZsdeErroPedidoWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeErroPedidoWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Status" type="{urn:sap-com:document:sap:rfc:functions}char2"/&gt;
 *         &lt;element name="DcStatus" type="{urn:sap-com:document:sap:rfc:functions}char70"/&gt;
 *         &lt;element name="IdSequencia" type="{urn:sap-com:document:sap:rfc:functions}numeric3"/&gt;
 *         &lt;element name="Valor" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeErroPedidoWebs", propOrder = {
    "status",
    "dcStatus",
    "idSequencia",
    "valor"
})
public class ZsdeErroPedidoWebs {

    @XmlElement(name = "Status", required = true)
    protected String status;
    @XmlElement(name = "DcStatus", required = true)
    protected String dcStatus;
    @XmlElement(name = "IdSequencia", required = true)
    protected String idSequencia;
    @XmlElement(name = "Valor", required = true)
    protected String valor;

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
     * Obtém o valor da propriedade valor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValor() {
        return valor;
    }

    /**
     * Define o valor da propriedade valor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValor(String value) {
        this.valor = value;
    }

}

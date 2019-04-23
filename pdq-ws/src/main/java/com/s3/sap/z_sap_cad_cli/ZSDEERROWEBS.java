//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:50:31 PM BRT 
//


package com.s3.sap.z_sap_cad_cli;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ZSDE_ERRO_WEBS complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZSDE_ERRO_WEBS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SEQUENCIA" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="CAMPO" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="MENSAGEM" type="{urn:sap-com:document:sap:rfc:functions}char80"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZSDE_ERRO_WEBS", propOrder = {
    "sequencia",
    "campo",
    "mensagem"
})
public class ZSDEERROWEBS {

    @XmlElement(name = "SEQUENCIA", required = true)
    protected String sequencia;
    @XmlElement(name = "CAMPO", required = true)
    protected String campo;
    @XmlElement(name = "MENSAGEM", required = true)
    protected String mensagem;

    /**
     * Obtém o valor da propriedade sequencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSEQUENCIA() {
        return sequencia;
    }

    /**
     * Define o valor da propriedade sequencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSEQUENCIA(String value) {
        this.sequencia = value;
    }

    /**
     * Obtém o valor da propriedade campo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCAMPO() {
        return campo;
    }

    /**
     * Define o valor da propriedade campo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCAMPO(String value) {
        this.campo = value;
    }

    /**
     * Obtém o valor da propriedade mensagem.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMENSAGEM() {
        return mensagem;
    }

    /**
     * Define o valor da propriedade mensagem.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMENSAGEM(String value) {
        this.mensagem = value;
    }

}

//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:50:30 PM BRT 
//


package com.s3.sap.z_outros_cad_sap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ZsdeConvUnidWebs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZsdeConvUnidWebs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CdMaterial" type="{urn:sap-com:document:sap:soap:functions:mc-style}char18"/&gt;
 *         &lt;element name="UnMedDe" type="{urn:sap-com:document:sap:soap:functions:mc-style}unit3"/&gt;
 *         &lt;element name="UnMedPara" type="{urn:sap-com:document:sap:soap:functions:mc-style}unit3"/&gt;
 *         &lt;element name="Contador" type="{urn:sap-com:document:sap:soap:functions:mc-style}numeric5"/&gt;
 *         &lt;element name="Denominador" type="{urn:sap-com:document:sap:soap:functions:mc-style}numeric5"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZsdeConvUnidWebs", propOrder = {
    "cdMaterial",
    "unMedDe",
    "unMedPara",
    "contador",
    "denominador"
})
public class ZsdeConvUnidWebs {

    @XmlElement(name = "CdMaterial", required = true)
    protected String cdMaterial;
    @XmlElement(name = "UnMedDe", required = true)
    protected String unMedDe;
    @XmlElement(name = "UnMedPara", required = true)
    protected String unMedPara;
    @XmlElement(name = "Contador", required = true)
    protected String contador;
    @XmlElement(name = "Denominador", required = true)
    protected String denominador;

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
     * Obtém o valor da propriedade unMedDe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnMedDe() {
        return unMedDe;
    }

    /**
     * Define o valor da propriedade unMedDe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnMedDe(String value) {
        this.unMedDe = value;
    }

    /**
     * Obtém o valor da propriedade unMedPara.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnMedPara() {
        return unMedPara;
    }

    /**
     * Define o valor da propriedade unMedPara.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnMedPara(String value) {
        this.unMedPara = value;
    }

    /**
     * Obtém o valor da propriedade contador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContador() {
        return contador;
    }

    /**
     * Define o valor da propriedade contador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContador(String value) {
        this.contador = value;
    }

    /**
     * Obtém o valor da propriedade denominador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominador() {
        return denominador;
    }

    /**
     * Define o valor da propriedade denominador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominador(String value) {
        this.denominador = value;
    }

}

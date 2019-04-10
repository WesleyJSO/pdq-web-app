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
 *         &lt;element name="ICdTransp" type="{urn:sap-com:document:sap:rfc:functions}char10" minOccurs="0"/&gt;
 *         &lt;element name="IChAcesso" type="{urn:sap-com:document:sap:rfc:functions}char15" minOccurs="0"/&gt;
 *         &lt;element name="TabTransp" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeAgFreteWebs" minOccurs="0"/&gt;
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
    "iCdTransp",
    "iChAcesso",
    "tabTransp"
})
@XmlRootElement(name = "ZbcCadTranspArtWebs")
public class ZbcCadTranspArtWebs {

    @XmlElement(name = "ICdTransp")
    protected String iCdTransp;
    @XmlElement(name = "IChAcesso")
    protected String iChAcesso;
    @XmlElement(name = "TabTransp")
    protected TableOfZsdeAgFreteWebs tabTransp;

    /**
     * Obtém o valor da propriedade iCdTransp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICdTransp() {
        return iCdTransp;
    }

    /**
     * Define o valor da propriedade iCdTransp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICdTransp(String value) {
        this.iCdTransp = value;
    }

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
     * Obtém o valor da propriedade tabTransp.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeAgFreteWebs }
     *     
     */
    public TableOfZsdeAgFreteWebs getTabTransp() {
        return tabTransp;
    }

    /**
     * Define o valor da propriedade tabTransp.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeAgFreteWebs }
     *     
     */
    public void setTabTransp(TableOfZsdeAgFreteWebs value) {
        this.tabTransp = value;
    }

}

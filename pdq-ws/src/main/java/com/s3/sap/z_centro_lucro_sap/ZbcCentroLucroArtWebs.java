//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:50:29 PM BRT 
//


package com.s3.sap.z_centro_lucro_sap;

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
 *         &lt;element name="TabCenLucro" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeCenLucroWebs" minOccurs="0"/&gt;
 *         &lt;element name="TabRepRelac" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeRelRelacWebs" minOccurs="0"/&gt;
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
    "tabCenLucro",
    "tabRepRelac"
})
@XmlRootElement(name = "ZbcCentroLucroArtWebs")
public class ZbcCentroLucroArtWebs {

    @XmlElement(name = "IChAcesso")
    protected String iChAcesso;
    @XmlElement(name = "TabCenLucro")
    protected TableOfZsdeCenLucroWebs tabCenLucro;
    @XmlElement(name = "TabRepRelac")
    protected TableOfZsdeRelRelacWebs tabRepRelac;

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
     * Obtém o valor da propriedade tabCenLucro.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeCenLucroWebs }
     *     
     */
    public TableOfZsdeCenLucroWebs getTabCenLucro() {
        return tabCenLucro;
    }

    /**
     * Define o valor da propriedade tabCenLucro.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeCenLucroWebs }
     *     
     */
    public void setTabCenLucro(TableOfZsdeCenLucroWebs value) {
        this.tabCenLucro = value;
    }

    /**
     * Obtém o valor da propriedade tabRepRelac.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeRelRelacWebs }
     *     
     */
    public TableOfZsdeRelRelacWebs getTabRepRelac() {
        return tabRepRelac;
    }

    /**
     * Define o valor da propriedade tabRepRelac.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeRelRelacWebs }
     *     
     */
    public void setTabRepRelac(TableOfZsdeRelRelacWebs value) {
        this.tabRepRelac = value;
    }

}

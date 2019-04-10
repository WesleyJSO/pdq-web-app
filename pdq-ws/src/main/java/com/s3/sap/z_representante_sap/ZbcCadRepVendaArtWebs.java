//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:50:31 PM BRT 
//


package com.s3.sap.z_representante_sap;

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
 *         &lt;element name="ICdRepVenda" type="{urn:sap-com:document:sap:rfc:functions}char10" minOccurs="0"/&gt;
 *         &lt;element name="IChAcesso" type="{urn:sap-com:document:sap:rfc:functions}char15" minOccurs="0"/&gt;
 *         &lt;element name="TabRepVenda" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZsdeRepVendaWebs" minOccurs="0"/&gt;
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
    "iCdRepVenda",
    "iChAcesso",
    "tabRepVenda"
})
@XmlRootElement(name = "ZbcCadRepVendaArtWebs")
public class ZbcCadRepVendaArtWebs {

    @XmlElement(name = "ICdRepVenda")
    protected String iCdRepVenda;
    @XmlElement(name = "IChAcesso")
    protected String iChAcesso;
    @XmlElement(name = "TabRepVenda")
    protected TableOfZsdeRepVendaWebs tabRepVenda;

    /**
     * Obtém o valor da propriedade iCdRepVenda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICdRepVenda() {
        return iCdRepVenda;
    }

    /**
     * Define o valor da propriedade iCdRepVenda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICdRepVenda(String value) {
        this.iCdRepVenda = value;
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
     * Obtém o valor da propriedade tabRepVenda.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZsdeRepVendaWebs }
     *     
     */
    public TableOfZsdeRepVendaWebs getTabRepVenda() {
        return tabRepVenda;
    }

    /**
     * Define o valor da propriedade tabRepVenda.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZsdeRepVendaWebs }
     *     
     */
    public void setTabRepVenda(TableOfZsdeRepVendaWebs value) {
        this.tabRepVenda = value;
    }

}

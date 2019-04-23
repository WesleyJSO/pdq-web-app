//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:50:32 PM BRT 
//


package com.s3.sap.z_sap_cons_cli;

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
 *         &lt;element name="REGISTROS" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/&gt;
 *         &lt;element name="RETORNO" type="{urn:sap-com:document:sap:rfc:functions}char70"/&gt;
 *         &lt;element name="TAB_STATUS" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_ZMME_RET_CONS_PRE_CAD_WEBS" minOccurs="0"/&gt;
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
    "registros",
    "retorno",
    "tabstatus"
})
@XmlRootElement(name = "ZBC_CONS_PRE_CAD_ART_WEBSResponse")
public class ZBCCONSPRECADARTWEBSResponse {

    @XmlElement(name = "REGISTROS", required = true)
    protected String registros;
    @XmlElement(name = "RETORNO", required = true)
    protected String retorno;
    @XmlElement(name = "TAB_STATUS")
    protected TABLEOFZMMERETCONSPRECADWEBS tabstatus;

    /**
     * Obtém o valor da propriedade registros.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREGISTROS() {
        return registros;
    }

    /**
     * Define o valor da propriedade registros.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREGISTROS(String value) {
        this.registros = value;
    }

    /**
     * Obtém o valor da propriedade retorno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRETORNO() {
        return retorno;
    }

    /**
     * Define o valor da propriedade retorno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRETORNO(String value) {
        this.retorno = value;
    }

    /**
     * Obtém o valor da propriedade tabstatus.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFZMMERETCONSPRECADWEBS }
     *     
     */
    public TABLEOFZMMERETCONSPRECADWEBS getTABSTATUS() {
        return tabstatus;
    }

    /**
     * Define o valor da propriedade tabstatus.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFZMMERETCONSPRECADWEBS }
     *     
     */
    public void setTABSTATUS(TABLEOFZMMERETCONSPRECADWEBS value) {
        this.tabstatus = value;
    }

}

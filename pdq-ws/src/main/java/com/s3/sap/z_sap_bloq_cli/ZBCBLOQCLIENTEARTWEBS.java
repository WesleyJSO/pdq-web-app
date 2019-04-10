//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:50:31 PM BRT 
//


package com.s3.sap.z_sap_bloq_cli;

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
 *         &lt;element name="I_BLOQ_CADASTRO" type="{urn:sap-com:document:sap:rfc:functions}ZMME_BLOQ_CLIENTE_WEBS" minOccurs="0"/&gt;
 *         &lt;element name="I_CH_ACESSO" type="{urn:sap-com:document:sap:rfc:functions}char15" minOccurs="0"/&gt;
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
    "ibloqcadastro",
    "ichacesso"
})
@XmlRootElement(name = "ZBC_BLOQ_CLIENTE_ART_WEBS")
public class ZBCBLOQCLIENTEARTWEBS {

    @XmlElement(name = "I_BLOQ_CADASTRO")
    protected ZMMEBLOQCLIENTEWEBS ibloqcadastro;
    @XmlElement(name = "I_CH_ACESSO")
    protected String ichacesso;

    /**
     * Obtém o valor da propriedade ibloqcadastro.
     * 
     * @return
     *     possible object is
     *     {@link ZMMEBLOQCLIENTEWEBS }
     *     
     */
    public ZMMEBLOQCLIENTEWEBS getIBLOQCADASTRO() {
        return ibloqcadastro;
    }

    /**
     * Define o valor da propriedade ibloqcadastro.
     * 
     * @param value
     *     allowed object is
     *     {@link ZMMEBLOQCLIENTEWEBS }
     *     
     */
    public void setIBLOQCADASTRO(ZMMEBLOQCLIENTEWEBS value) {
        this.ibloqcadastro = value;
    }

    /**
     * Obtém o valor da propriedade ichacesso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICHACESSO() {
        return ichacesso;
    }

    /**
     * Define o valor da propriedade ichacesso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICHACESSO(String value) {
        this.ichacesso = value;
    }

}

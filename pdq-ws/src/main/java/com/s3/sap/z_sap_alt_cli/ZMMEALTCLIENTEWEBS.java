//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.04.09 às 04:50:31 PM BRT 
//


package com.s3.sap.z_sap_alt_cli;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ZMME_ALT_CLIENTE_WEBS complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZMME_ALT_CLIENTE_WEBS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TP_REGISTRO" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="CD_SAP" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="DC_CLIENTE" type="{urn:sap-com:document:sap:rfc:functions}char70"/&gt;
 *         &lt;element name="TERMO_PESQ" type="{urn:sap-com:document:sap:rfc:functions}char20"/&gt;
 *         &lt;element name="ENDERECO" type="{urn:sap-com:document:sap:rfc:functions}char60"/&gt;
 *         &lt;element name="NUMERO" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="COMPLEMENTO" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="RUA2" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="RUA3" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="RUA4" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="RUA5" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="BAIRRO" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="CEP" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="CIDADE" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="UF" type="{urn:sap-com:document:sap:rfc:functions}char3"/&gt;
 *         &lt;element name="PAIS" type="{urn:sap-com:document:sap:rfc:functions}char3"/&gt;
 *         &lt;element name="CAIXA_POSTAL" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="TELEFONE" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *         &lt;element name="RAMAL" type="{urn:sap-com:document:sap:rfc:functions}char10"/&gt;
 *         &lt;element name="CELULAR" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *         &lt;element name="INS_ESTADUAL" type="{urn:sap-com:document:sap:rfc:functions}char18"/&gt;
 *         &lt;element name="SUFRAMA" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *         &lt;element name="ZONA_FRANCA" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="EMAIL" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="EMAIL_NFE" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="EMAIL_BOLETO1" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="EMAIL_BOLETO2" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="EMAIL_BOLETO3" type="{urn:sap-com:document:sap:rfc:functions}char132"/&gt;
 *         &lt;element name="OBS" type="{urn:sap-com:document:sap:rfc:functions}char255"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZMME_ALT_CLIENTE_WEBS", propOrder = {
    "tpregistro",
    "cdsap",
    "dccliente",
    "termopesq",
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
    "caixapostal",
    "telefone",
    "ramal",
    "celular",
    "insestadual",
    "suframa",
    "zonafranca",
    "email",
    "emailnfe",
    "emailboleto1",
    "emailboleto2",
    "emailboleto3",
    "obs"
})
public class ZMMEALTCLIENTEWEBS {

    @XmlElement(name = "TP_REGISTRO", required = true)
    protected String tpregistro;
    @XmlElement(name = "CD_SAP", required = true)
    protected String cdsap;
    @XmlElement(name = "DC_CLIENTE", required = true)
    protected String dccliente;
    @XmlElement(name = "TERMO_PESQ", required = true)
    protected String termopesq;
    @XmlElement(name = "ENDERECO", required = true)
    protected String endereco;
    @XmlElement(name = "NUMERO", required = true)
    protected String numero;
    @XmlElement(name = "COMPLEMENTO", required = true)
    protected String complemento;
    @XmlElement(name = "RUA2", required = true)
    protected String rua2;
    @XmlElement(name = "RUA3", required = true)
    protected String rua3;
    @XmlElement(name = "RUA4", required = true)
    protected String rua4;
    @XmlElement(name = "RUA5", required = true)
    protected String rua5;
    @XmlElement(name = "BAIRRO", required = true)
    protected String bairro;
    @XmlElement(name = "CEP", required = true)
    protected String cep;
    @XmlElement(name = "CIDADE", required = true)
    protected String cidade;
    @XmlElement(name = "UF", required = true)
    protected String uf;
    @XmlElement(name = "PAIS", required = true)
    protected String pais;
    @XmlElement(name = "CAIXA_POSTAL", required = true)
    protected String caixapostal;
    @XmlElement(name = "TELEFONE", required = true)
    protected String telefone;
    @XmlElement(name = "RAMAL", required = true)
    protected String ramal;
    @XmlElement(name = "CELULAR", required = true)
    protected String celular;
    @XmlElement(name = "INS_ESTADUAL", required = true)
    protected String insestadual;
    @XmlElement(name = "SUFRAMA", required = true)
    protected String suframa;
    @XmlElement(name = "ZONA_FRANCA", required = true)
    protected String zonafranca;
    @XmlElement(name = "EMAIL", required = true)
    protected String email;
    @XmlElement(name = "EMAIL_NFE", required = true)
    protected String emailnfe;
    @XmlElement(name = "EMAIL_BOLETO1", required = true)
    protected String emailboleto1;
    @XmlElement(name = "EMAIL_BOLETO2", required = true)
    protected String emailboleto2;
    @XmlElement(name = "EMAIL_BOLETO3", required = true)
    protected String emailboleto3;
    @XmlElement(name = "OBS", required = true)
    protected String obs;

    /**
     * Obtém o valor da propriedade tpregistro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTPREGISTRO() {
        return tpregistro;
    }

    /**
     * Define o valor da propriedade tpregistro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTPREGISTRO(String value) {
        this.tpregistro = value;
    }

    /**
     * Obtém o valor da propriedade cdsap.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCDSAP() {
        return cdsap;
    }

    /**
     * Define o valor da propriedade cdsap.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCDSAP(String value) {
        this.cdsap = value;
    }

    /**
     * Obtém o valor da propriedade dccliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDCCLIENTE() {
        return dccliente;
    }

    /**
     * Define o valor da propriedade dccliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDCCLIENTE(String value) {
        this.dccliente = value;
    }

    /**
     * Obtém o valor da propriedade termopesq.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTERMOPESQ() {
        return termopesq;
    }

    /**
     * Define o valor da propriedade termopesq.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTERMOPESQ(String value) {
        this.termopesq = value;
    }

    /**
     * Obtém o valor da propriedade endereco.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENDERECO() {
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
    public void setENDERECO(String value) {
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
    public String getNUMERO() {
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
    public void setNUMERO(String value) {
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
    public String getCOMPLEMENTO() {
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
    public void setCOMPLEMENTO(String value) {
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
    public String getRUA2() {
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
    public void setRUA2(String value) {
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
    public String getRUA3() {
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
    public void setRUA3(String value) {
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
    public String getRUA4() {
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
    public void setRUA4(String value) {
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
    public String getRUA5() {
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
    public void setRUA5(String value) {
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
    public String getBAIRRO() {
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
    public void setBAIRRO(String value) {
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
    public String getCEP() {
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
    public void setCEP(String value) {
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
    public String getCIDADE() {
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
    public void setCIDADE(String value) {
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
    public String getUF() {
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
    public void setUF(String value) {
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
    public String getPAIS() {
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
    public void setPAIS(String value) {
        this.pais = value;
    }

    /**
     * Obtém o valor da propriedade caixapostal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCAIXAPOSTAL() {
        return caixapostal;
    }

    /**
     * Define o valor da propriedade caixapostal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCAIXAPOSTAL(String value) {
        this.caixapostal = value;
    }

    /**
     * Obtém o valor da propriedade telefone.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTELEFONE() {
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
    public void setTELEFONE(String value) {
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
    public String getRAMAL() {
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
    public void setRAMAL(String value) {
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
    public String getCELULAR() {
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
    public void setCELULAR(String value) {
        this.celular = value;
    }

    /**
     * Obtém o valor da propriedade insestadual.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINSESTADUAL() {
        return insestadual;
    }

    /**
     * Define o valor da propriedade insestadual.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINSESTADUAL(String value) {
        this.insestadual = value;
    }

    /**
     * Obtém o valor da propriedade suframa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSUFRAMA() {
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
    public void setSUFRAMA(String value) {
        this.suframa = value;
    }

    /**
     * Obtém o valor da propriedade zonafranca.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZONAFRANCA() {
        return zonafranca;
    }

    /**
     * Define o valor da propriedade zonafranca.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZONAFRANCA(String value) {
        this.zonafranca = value;
    }

    /**
     * Obtém o valor da propriedade email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEMAIL() {
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
    public void setEMAIL(String value) {
        this.email = value;
    }

    /**
     * Obtém o valor da propriedade emailnfe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEMAILNFE() {
        return emailnfe;
    }

    /**
     * Define o valor da propriedade emailnfe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEMAILNFE(String value) {
        this.emailnfe = value;
    }

    /**
     * Obtém o valor da propriedade emailboleto1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEMAILBOLETO1() {
        return emailboleto1;
    }

    /**
     * Define o valor da propriedade emailboleto1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEMAILBOLETO1(String value) {
        this.emailboleto1 = value;
    }

    /**
     * Obtém o valor da propriedade emailboleto2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEMAILBOLETO2() {
        return emailboleto2;
    }

    /**
     * Define o valor da propriedade emailboleto2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEMAILBOLETO2(String value) {
        this.emailboleto2 = value;
    }

    /**
     * Obtém o valor da propriedade emailboleto3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEMAILBOLETO3() {
        return emailboleto3;
    }

    /**
     * Define o valor da propriedade emailboleto3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEMAILBOLETO3(String value) {
        this.emailboleto3 = value;
    }

    /**
     * Obtém o valor da propriedade obs.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOBS() {
        return obs;
    }

    /**
     * Define o valor da propriedade obs.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOBS(String value) {
        this.obs = value;
    }

}

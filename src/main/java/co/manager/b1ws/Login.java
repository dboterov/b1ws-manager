
package co.manager.b1ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DatabaseServer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DatabaseName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DatabaseType" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="dst_MSSQL"/>
 *               &lt;enumeration value="dst_DB_2"/>
 *               &lt;enumeration value="dst_SYBASE"/>
 *               &lt;enumeration value="dst_MSSQL2005"/>
 *               &lt;enumeration value="dst_MAXDB"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CompanyUsername" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CompanyPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Language" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="ln_Hebrew"/>
 *               &lt;enumeration value="ln_Spanish_Ar"/>
 *               &lt;enumeration value="ln_English"/>
 *               &lt;enumeration value="ln_Polish"/>
 *               &lt;enumeration value="ln_English_Sg"/>
 *               &lt;enumeration value="ln_Spanish_Pa"/>
 *               &lt;enumeration value="ln_English_Gb"/>
 *               &lt;enumeration value="ln_German"/>
 *               &lt;enumeration value="ln_Serbian"/>
 *               &lt;enumeration value="ln_Danish"/>
 *               &lt;enumeration value="ln_Norwegian"/>
 *               &lt;enumeration value="ln_Italian"/>
 *               &lt;enumeration value="ln_Hungarian"/>
 *               &lt;enumeration value="ln_Chinese"/>
 *               &lt;enumeration value="ln_Dutch"/>
 *               &lt;enumeration value="ln_Finnish"/>
 *               &lt;enumeration value="ln_Greek"/>
 *               &lt;enumeration value="ln_Portuguese"/>
 *               &lt;enumeration value="ln_Swedish"/>
 *               &lt;enumeration value="ln_English_Cy"/>
 *               &lt;enumeration value="ln_French"/>
 *               &lt;enumeration value="ln_Spanish"/>
 *               &lt;enumeration value="ln_Russian"/>
 *               &lt;enumeration value="ln_Spanish_La"/>
 *               &lt;enumeration value="ln_Czech_Cz"/>
 *               &lt;enumeration value="ln_Slovak_Sk"/>
 *               &lt;enumeration value="ln_Korean_Kr"/>
 *               &lt;enumeration value="ln_Portuguese_Br"/>
 *               &lt;enumeration value="ln_Japanese_Jp"/>
 *               &lt;enumeration value="ln_Turkish_Tr"/>
 *               &lt;enumeration value="ln_TrdtnlChinese_Hk"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="LicenseServer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "databaseServer",
    "databaseName",
    "databaseType",
    "companyUsername",
    "companyPassword",
    "language",
    "licenseServer"
})
@XmlRootElement(name = "Login", namespace = "LoginService")
public class Login {

    @XmlElement(name = "DatabaseServer", namespace = "LoginService")
    protected String databaseServer;
    @XmlElement(name = "DatabaseName", namespace = "LoginService")
    protected String databaseName;
    @XmlElement(name = "DatabaseType", namespace = "LoginService")
    protected String databaseType;
    @XmlElement(name = "CompanyUsername", namespace = "LoginService")
    protected String companyUsername;
    @XmlElement(name = "CompanyPassword", namespace = "LoginService")
    protected String companyPassword;
    @XmlElement(name = "Language", namespace = "LoginService")
    protected String language;
    @XmlElement(name = "LicenseServer", namespace = "LoginService")
    protected String licenseServer;

    /**
     * Obtiene el valor de la propiedad databaseServer.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatabaseServer() {
        return databaseServer;
    }

    /**
     * Define el valor de la propiedad databaseServer.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatabaseServer(String value) {
        this.databaseServer = value;
    }

    /**
     * Obtiene el valor de la propiedad databaseName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatabaseName() {
        return databaseName;
    }

    /**
     * Define el valor de la propiedad databaseName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatabaseName(String value) {
        this.databaseName = value;
    }

    /**
     * Obtiene el valor de la propiedad databaseType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatabaseType() {
        return databaseType;
    }

    /**
     * Define el valor de la propiedad databaseType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatabaseType(String value) {
        this.databaseType = value;
    }

    /**
     * Obtiene el valor de la propiedad companyUsername.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyUsername() {
        return companyUsername;
    }

    /**
     * Define el valor de la propiedad companyUsername.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyUsername(String value) {
        this.companyUsername = value;
    }

    /**
     * Obtiene el valor de la propiedad companyPassword.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyPassword() {
        return companyPassword;
    }

    /**
     * Define el valor de la propiedad companyPassword.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyPassword(String value) {
        this.companyPassword = value;
    }

    /**
     * Obtiene el valor de la propiedad language.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Define el valor de la propiedad language.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Obtiene el valor de la propiedad licenseServer.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenseServer() {
        return licenseServer;
    }

    /**
     * Define el valor de la propiedad licenseServer.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenseServer(String value) {
        this.licenseServer = value;
    }

}

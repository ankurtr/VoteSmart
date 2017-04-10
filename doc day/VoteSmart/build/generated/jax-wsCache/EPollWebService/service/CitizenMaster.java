
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for citizenMaster complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="citizenMaster">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="areaMaster" type="{http://service/}areaMaster" minOccurs="0"/>
 *         &lt;element name="contactNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateOfBirth" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="faceImage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loginMaster" type="{http://www.w3.org/2001/XMLSchema}IDREF" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signatureImage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subWardMaster" type="{http://service/}subWardMaster" minOccurs="0"/>
 *         &lt;element name="thumbImage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}ID" minOccurs="0"/>
 *         &lt;element name="voterCardImage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wardMaster" type="{http://service/}wardMaster" minOccurs="0"/>
 *         &lt;element name="zoneMaster" type="{http://service/}zoneMaster" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "citizenMaster", propOrder = {
    "address",
    "areaMaster",
    "contactNo",
    "dateOfBirth",
    "faceImage",
    "loginMaster",
    "name",
    "signatureImage",
    "subWardMaster",
    "thumbImage",
    "userId",
    "voterCardImage",
    "wardMaster",
    "zoneMaster"
})
public class CitizenMaster {

    protected String address;
    protected AreaMaster areaMaster;
    protected String contactNo;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateOfBirth;
    protected String faceImage;
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object loginMaster;
    protected String name;
    protected String signatureImage;
    protected SubWardMaster subWardMaster;
    protected String thumbImage;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String userId;
    protected String voterCardImage;
    protected WardMaster wardMaster;
    protected ZoneMaster zoneMaster;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the areaMaster property.
     * 
     * @return
     *     possible object is
     *     {@link AreaMaster }
     *     
     */
    public AreaMaster getAreaMaster() {
        return areaMaster;
    }

    /**
     * Sets the value of the areaMaster property.
     * 
     * @param value
     *     allowed object is
     *     {@link AreaMaster }
     *     
     */
    public void setAreaMaster(AreaMaster value) {
        this.areaMaster = value;
    }

    /**
     * Gets the value of the contactNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactNo() {
        return contactNo;
    }

    /**
     * Sets the value of the contactNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactNo(String value) {
        this.contactNo = value;
    }

    /**
     * Gets the value of the dateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the value of the dateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOfBirth(XMLGregorianCalendar value) {
        this.dateOfBirth = value;
    }

    /**
     * Gets the value of the faceImage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaceImage() {
        return faceImage;
    }

    /**
     * Sets the value of the faceImage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaceImage(String value) {
        this.faceImage = value;
    }

    /**
     * Gets the value of the loginMaster property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getLoginMaster() {
        return loginMaster;
    }

    /**
     * Sets the value of the loginMaster property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setLoginMaster(Object value) {
        this.loginMaster = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the signatureImage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignatureImage() {
        return signatureImage;
    }

    /**
     * Sets the value of the signatureImage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignatureImage(String value) {
        this.signatureImage = value;
    }

    /**
     * Gets the value of the subWardMaster property.
     * 
     * @return
     *     possible object is
     *     {@link SubWardMaster }
     *     
     */
    public SubWardMaster getSubWardMaster() {
        return subWardMaster;
    }

    /**
     * Sets the value of the subWardMaster property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubWardMaster }
     *     
     */
    public void setSubWardMaster(SubWardMaster value) {
        this.subWardMaster = value;
    }

    /**
     * Gets the value of the thumbImage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThumbImage() {
        return thumbImage;
    }

    /**
     * Sets the value of the thumbImage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThumbImage(String value) {
        this.thumbImage = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Gets the value of the voterCardImage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoterCardImage() {
        return voterCardImage;
    }

    /**
     * Sets the value of the voterCardImage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoterCardImage(String value) {
        this.voterCardImage = value;
    }

    /**
     * Gets the value of the wardMaster property.
     * 
     * @return
     *     possible object is
     *     {@link WardMaster }
     *     
     */
    public WardMaster getWardMaster() {
        return wardMaster;
    }

    /**
     * Sets the value of the wardMaster property.
     * 
     * @param value
     *     allowed object is
     *     {@link WardMaster }
     *     
     */
    public void setWardMaster(WardMaster value) {
        this.wardMaster = value;
    }

    /**
     * Gets the value of the zoneMaster property.
     * 
     * @return
     *     possible object is
     *     {@link ZoneMaster }
     *     
     */
    public ZoneMaster getZoneMaster() {
        return zoneMaster;
    }

    /**
     * Sets the value of the zoneMaster property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZoneMaster }
     *     
     */
    public void setZoneMaster(ZoneMaster value) {
        this.zoneMaster = value;
    }

}

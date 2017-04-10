
package service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for candidateMaster complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="candidateMaster">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="areaMaster" type="{http://service/}areaMaster" minOccurs="0"/>
 *         &lt;element name="candidateId" type="{http://www.w3.org/2001/XMLSchema}ID" minOccurs="0"/>
 *         &lt;element name="dateOfBirth" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="electionMasterList" type="{http://www.w3.org/2001/XMLSchema}IDREF" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="image" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isActive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nationality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partyMaster" type="{http://service/}partyMaster" minOccurs="0"/>
 *         &lt;element name="phoneNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sex" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="subWardMaster" type="{http://service/}subWardMaster" minOccurs="0"/>
 *         &lt;element name="voteMasterList" type="{http://www.w3.org/2001/XMLSchema}IDREF" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "candidateMaster", propOrder = {
    "address",
    "areaMaster",
    "candidateId",
    "dateOfBirth",
    "electionMasterList",
    "email",
    "firstName",
    "image",
    "isActive",
    "lastName",
    "nationality",
    "partyMaster",
    "phoneNo",
    "sex",
    "subWardMaster",
    "voteMasterList",
    "wardMaster",
    "zoneMaster"
})
public class CandidateMaster {

    protected String address;
    protected AreaMaster areaMaster;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String candidateId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateOfBirth;
    @XmlElementRef(name = "electionMasterList", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> electionMasterList;
    protected String email;
    protected String firstName;
    protected String image;
    protected boolean isActive;
    protected String lastName;
    protected String nationality;
    protected PartyMaster partyMaster;
    protected String phoneNo;
    protected boolean sex;
    protected SubWardMaster subWardMaster;
    @XmlElementRef(name = "voteMasterList", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> voteMasterList;
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
     * Gets the value of the candidateId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCandidateId() {
        return candidateId;
    }

    /**
     * Sets the value of the candidateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCandidateId(String value) {
        this.candidateId = value;
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
     * Gets the value of the electionMasterList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the electionMasterList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElectionMasterList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<Object>> getElectionMasterList() {
        if (electionMasterList == null) {
            electionMasterList = new ArrayList<JAXBElement<Object>>();
        }
        return this.electionMasterList;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the image property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImage(String value) {
        this.image = value;
    }

    /**
     * Gets the value of the isActive property.
     * 
     */
    public boolean isIsActive() {
        return isActive;
    }

    /**
     * Sets the value of the isActive property.
     * 
     */
    public void setIsActive(boolean value) {
        this.isActive = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the nationality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Sets the value of the nationality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationality(String value) {
        this.nationality = value;
    }

    /**
     * Gets the value of the partyMaster property.
     * 
     * @return
     *     possible object is
     *     {@link PartyMaster }
     *     
     */
    public PartyMaster getPartyMaster() {
        return partyMaster;
    }

    /**
     * Sets the value of the partyMaster property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyMaster }
     *     
     */
    public void setPartyMaster(PartyMaster value) {
        this.partyMaster = value;
    }

    /**
     * Gets the value of the phoneNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * Sets the value of the phoneNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNo(String value) {
        this.phoneNo = value;
    }

    /**
     * Gets the value of the sex property.
     * 
     */
    public boolean isSex() {
        return sex;
    }

    /**
     * Sets the value of the sex property.
     * 
     */
    public void setSex(boolean value) {
        this.sex = value;
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
     * Gets the value of the voteMasterList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the voteMasterList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVoteMasterList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<Object>> getVoteMasterList() {
        if (voteMasterList == null) {
            voteMasterList = new ArrayList<JAXBElement<Object>>();
        }
        return this.voteMasterList;
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

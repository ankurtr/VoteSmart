
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


/**
 * <p>Java class for subWardMaster complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subWardMaster">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="areaMasterList" type="{http://www.w3.org/2001/XMLSchema}IDREF" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="candidateMasterList" type="{http://www.w3.org/2001/XMLSchema}IDREF" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="citizenMasterList" type="{http://www.w3.org/2001/XMLSchema}IDREF" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subWardId" type="{http://www.w3.org/2001/XMLSchema}ID" minOccurs="0"/>
 *         &lt;element name="subWardName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="voteMasterList" type="{http://www.w3.org/2001/XMLSchema}IDREF" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="wardMaster" type="{http://service/}wardMaster" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subWardMaster", propOrder = {
    "areaMasterList",
    "candidateMasterList",
    "citizenMasterList",
    "subWardId",
    "subWardName",
    "voteMasterList",
    "wardMaster"
})
public class SubWardMaster {

    @XmlElementRef(name = "areaMasterList", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> areaMasterList;
    @XmlElementRef(name = "candidateMasterList", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> candidateMasterList;
    @XmlElementRef(name = "citizenMasterList", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> citizenMasterList;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String subWardId;
    protected String subWardName;
    @XmlElementRef(name = "voteMasterList", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> voteMasterList;
    protected WardMaster wardMaster;

    /**
     * Gets the value of the areaMasterList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the areaMasterList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAreaMasterList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<Object>> getAreaMasterList() {
        if (areaMasterList == null) {
            areaMasterList = new ArrayList<JAXBElement<Object>>();
        }
        return this.areaMasterList;
    }

    /**
     * Gets the value of the candidateMasterList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the candidateMasterList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCandidateMasterList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<Object>> getCandidateMasterList() {
        if (candidateMasterList == null) {
            candidateMasterList = new ArrayList<JAXBElement<Object>>();
        }
        return this.candidateMasterList;
    }

    /**
     * Gets the value of the citizenMasterList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the citizenMasterList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCitizenMasterList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<Object>> getCitizenMasterList() {
        if (citizenMasterList == null) {
            citizenMasterList = new ArrayList<JAXBElement<Object>>();
        }
        return this.citizenMasterList;
    }

    /**
     * Gets the value of the subWardId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubWardId() {
        return subWardId;
    }

    /**
     * Sets the value of the subWardId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubWardId(String value) {
        this.subWardId = value;
    }

    /**
     * Gets the value of the subWardName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubWardName() {
        return subWardName;
    }

    /**
     * Sets the value of the subWardName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubWardName(String value) {
        this.subWardName = value;
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

}

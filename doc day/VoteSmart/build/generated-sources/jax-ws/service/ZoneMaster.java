
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
 * <p>Java class for zoneMaster complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="zoneMaster">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="candidateMasterList" type="{http://www.w3.org/2001/XMLSchema}IDREF" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="citizenMasterList" type="{http://www.w3.org/2001/XMLSchema}IDREF" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="cityMaster" type="{http://service/}cityMaster" minOccurs="0"/>
 *         &lt;element name="population" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="voteMasterList" type="{http://www.w3.org/2001/XMLSchema}IDREF" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="wardMasterList" type="{http://www.w3.org/2001/XMLSchema}IDREF" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="zoneId" type="{http://www.w3.org/2001/XMLSchema}ID" minOccurs="0"/>
 *         &lt;element name="zoneName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "zoneMaster", propOrder = {
    "candidateMasterList",
    "citizenMasterList",
    "cityMaster",
    "population",
    "voteMasterList",
    "wardMasterList",
    "zoneId",
    "zoneName"
})
public class ZoneMaster {

    @XmlElementRef(name = "candidateMasterList", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> candidateMasterList;
    @XmlElementRef(name = "citizenMasterList", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> citizenMasterList;
    protected CityMaster cityMaster;
    protected long population;
    @XmlElementRef(name = "voteMasterList", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> voteMasterList;
    @XmlElementRef(name = "wardMasterList", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> wardMasterList;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String zoneId;
    protected String zoneName;

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
     * Gets the value of the cityMaster property.
     * 
     * @return
     *     possible object is
     *     {@link CityMaster }
     *     
     */
    public CityMaster getCityMaster() {
        return cityMaster;
    }

    /**
     * Sets the value of the cityMaster property.
     * 
     * @param value
     *     allowed object is
     *     {@link CityMaster }
     *     
     */
    public void setCityMaster(CityMaster value) {
        this.cityMaster = value;
    }

    /**
     * Gets the value of the population property.
     * 
     */
    public long getPopulation() {
        return population;
    }

    /**
     * Sets the value of the population property.
     * 
     */
    public void setPopulation(long value) {
        this.population = value;
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
     * Gets the value of the wardMasterList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wardMasterList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWardMasterList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<Object>> getWardMasterList() {
        if (wardMasterList == null) {
            wardMasterList = new ArrayList<JAXBElement<Object>>();
        }
        return this.wardMasterList;
    }

    /**
     * Gets the value of the zoneId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZoneId() {
        return zoneId;
    }

    /**
     * Sets the value of the zoneId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZoneId(String value) {
        this.zoneId = value;
    }

    /**
     * Gets the value of the zoneName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZoneName() {
        return zoneName;
    }

    /**
     * Sets the value of the zoneName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZoneName(String value) {
        this.zoneName = value;
    }

}

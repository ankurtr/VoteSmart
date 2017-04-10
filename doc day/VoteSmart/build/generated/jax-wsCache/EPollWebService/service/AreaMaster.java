
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
 * <p>Java class for areaMaster complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="areaMaster">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="areaId" type="{http://www.w3.org/2001/XMLSchema}ID" minOccurs="0"/>
 *         &lt;element name="areaName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="candidateMasterList" type="{http://www.w3.org/2001/XMLSchema}IDREF" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="citizenMasterList" type="{http://www.w3.org/2001/XMLSchema}IDREF" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subWardMaster" type="{http://service/}subWardMaster" minOccurs="0"/>
 *         &lt;element name="voteMasterList" type="{http://www.w3.org/2001/XMLSchema}IDREF" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "areaMaster", propOrder = {
    "areaId",
    "areaName",
    "candidateMasterList",
    "citizenMasterList",
    "subWardMaster",
    "voteMasterList"
})
public class AreaMaster {

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String areaId;
    protected String areaName;
    @XmlElementRef(name = "candidateMasterList", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> candidateMasterList;
    @XmlElementRef(name = "citizenMasterList", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> citizenMasterList;
    protected SubWardMaster subWardMaster;
    @XmlElementRef(name = "voteMasterList", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> voteMasterList;

    /**
     * Gets the value of the areaId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * Sets the value of the areaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaId(String value) {
        this.areaId = value;
    }

    /**
     * Gets the value of the areaName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * Sets the value of the areaName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaName(String value) {
        this.areaName = value;
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

}


package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for voteMaster complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="voteMaster">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="areaMaster" type="{http://service/}areaMaster" minOccurs="0"/>
 *         &lt;element name="candidateMaster" type="{http://service/}candidateMaster" minOccurs="0"/>
 *         &lt;element name="electionMaster" type="{http://service/}electionMaster" minOccurs="0"/>
 *         &lt;element name="subWardMaster" type="{http://service/}subWardMaster" minOccurs="0"/>
 *         &lt;element name="voteDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="voteId" type="{http://www.w3.org/2001/XMLSchema}ID" minOccurs="0"/>
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
@XmlType(name = "voteMaster", propOrder = {
    "areaMaster",
    "candidateMaster",
    "electionMaster",
    "subWardMaster",
    "voteDateTime",
    "voteId",
    "wardMaster",
    "zoneMaster"
})
public class VoteMaster {

    protected AreaMaster areaMaster;
    protected CandidateMaster candidateMaster;
    protected ElectionMaster electionMaster;
    protected SubWardMaster subWardMaster;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar voteDateTime;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String voteId;
    protected WardMaster wardMaster;
    protected ZoneMaster zoneMaster;

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
     * Gets the value of the candidateMaster property.
     * 
     * @return
     *     possible object is
     *     {@link CandidateMaster }
     *     
     */
    public CandidateMaster getCandidateMaster() {
        return candidateMaster;
    }

    /**
     * Sets the value of the candidateMaster property.
     * 
     * @param value
     *     allowed object is
     *     {@link CandidateMaster }
     *     
     */
    public void setCandidateMaster(CandidateMaster value) {
        this.candidateMaster = value;
    }

    /**
     * Gets the value of the electionMaster property.
     * 
     * @return
     *     possible object is
     *     {@link ElectionMaster }
     *     
     */
    public ElectionMaster getElectionMaster() {
        return electionMaster;
    }

    /**
     * Sets the value of the electionMaster property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElectionMaster }
     *     
     */
    public void setElectionMaster(ElectionMaster value) {
        this.electionMaster = value;
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
     * Gets the value of the voteDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVoteDateTime() {
        return voteDateTime;
    }

    /**
     * Sets the value of the voteDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVoteDateTime(XMLGregorianCalendar value) {
        this.voteDateTime = value;
    }

    /**
     * Gets the value of the voteId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoteId() {
        return voteId;
    }

    /**
     * Sets the value of the voteId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoteId(String value) {
        this.voteId = value;
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

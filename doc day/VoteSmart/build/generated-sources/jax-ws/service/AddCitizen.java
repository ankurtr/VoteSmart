
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addCitizen complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addCitizen">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lm" type="{http://service/}loginMaster" minOccurs="0"/>
 *         &lt;element name="cm" type="{http://service/}citizenMaster" minOccurs="0"/>
 *         &lt;element name="zoneId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="wardId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="subwardId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="areaId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addCitizen", propOrder = {
    "lm",
    "cm",
    "zoneId",
    "wardId",
    "subwardId",
    "areaId"
})
public class AddCitizen {

    protected LoginMaster lm;
    protected CitizenMaster cm;
    protected Integer zoneId;
    protected Integer wardId;
    protected Integer subwardId;
    protected Integer areaId;

    /**
     * Gets the value of the lm property.
     * 
     * @return
     *     possible object is
     *     {@link LoginMaster }
     *     
     */
    public LoginMaster getLm() {
        return lm;
    }

    /**
     * Sets the value of the lm property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoginMaster }
     *     
     */
    public void setLm(LoginMaster value) {
        this.lm = value;
    }

    /**
     * Gets the value of the cm property.
     * 
     * @return
     *     possible object is
     *     {@link CitizenMaster }
     *     
     */
    public CitizenMaster getCm() {
        return cm;
    }

    /**
     * Sets the value of the cm property.
     * 
     * @param value
     *     allowed object is
     *     {@link CitizenMaster }
     *     
     */
    public void setCm(CitizenMaster value) {
        this.cm = value;
    }

    /**
     * Gets the value of the zoneId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getZoneId() {
        return zoneId;
    }

    /**
     * Sets the value of the zoneId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setZoneId(Integer value) {
        this.zoneId = value;
    }

    /**
     * Gets the value of the wardId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWardId() {
        return wardId;
    }

    /**
     * Sets the value of the wardId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWardId(Integer value) {
        this.wardId = value;
    }

    /**
     * Gets the value of the subwardId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSubwardId() {
        return subwardId;
    }

    /**
     * Sets the value of the subwardId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSubwardId(Integer value) {
        this.subwardId = value;
    }

    /**
     * Gets the value of the areaId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     * Sets the value of the areaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAreaId(Integer value) {
        this.areaId = value;
    }

}

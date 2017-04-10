
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateZone complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateZone">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="zone" type="{http://service/}zoneMaster" minOccurs="0"/>
 *         &lt;element name="newCityMasterId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateZone", propOrder = {
    "zone",
    "newCityMasterId"
})
public class UpdateZone {

    protected ZoneMaster zone;
    protected Integer newCityMasterId;

    /**
     * Gets the value of the zone property.
     * 
     * @return
     *     possible object is
     *     {@link ZoneMaster }
     *     
     */
    public ZoneMaster getZone() {
        return zone;
    }

    /**
     * Sets the value of the zone property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZoneMaster }
     *     
     */
    public void setZone(ZoneMaster value) {
        this.zone = value;
    }

    /**
     * Gets the value of the newCityMasterId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNewCityMasterId() {
        return newCityMasterId;
    }

    /**
     * Sets the value of the newCityMasterId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNewCityMasterId(Integer value) {
        this.newCityMasterId = value;
    }

}

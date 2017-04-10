
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateArea complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateArea">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="area" type="{http://service/}areaMaster" minOccurs="0"/>
 *         &lt;element name="newSubwardId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateArea", propOrder = {
    "area",
    "newSubwardId"
})
public class UpdateArea {

    protected AreaMaster area;
    protected Integer newSubwardId;

    /**
     * Gets the value of the area property.
     * 
     * @return
     *     possible object is
     *     {@link AreaMaster }
     *     
     */
    public AreaMaster getArea() {
        return area;
    }

    /**
     * Sets the value of the area property.
     * 
     * @param value
     *     allowed object is
     *     {@link AreaMaster }
     *     
     */
    public void setArea(AreaMaster value) {
        this.area = value;
    }

    /**
     * Gets the value of the newSubwardId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNewSubwardId() {
        return newSubwardId;
    }

    /**
     * Sets the value of the newSubwardId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNewSubwardId(Integer value) {
        this.newSubwardId = value;
    }

}


package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addArea complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addArea">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="area" type="{http://service/}areaMaster" minOccurs="0"/>
 *         &lt;element name="subwardId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addArea", propOrder = {
    "area",
    "subwardId"
})
public class AddArea {

    protected AreaMaster area;
    protected Integer subwardId;

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

}

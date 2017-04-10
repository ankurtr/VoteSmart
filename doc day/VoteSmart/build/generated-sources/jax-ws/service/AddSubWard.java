
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addSubWard complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addSubWard">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subward" type="{http://service/}subWardMaster" minOccurs="0"/>
 *         &lt;element name="wardId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addSubWard", propOrder = {
    "subward",
    "wardId"
})
public class AddSubWard {

    protected SubWardMaster subward;
    protected Integer wardId;

    /**
     * Gets the value of the subward property.
     * 
     * @return
     *     possible object is
     *     {@link SubWardMaster }
     *     
     */
    public SubWardMaster getSubward() {
        return subward;
    }

    /**
     * Sets the value of the subward property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubWardMaster }
     *     
     */
    public void setSubward(SubWardMaster value) {
        this.subward = value;
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

}

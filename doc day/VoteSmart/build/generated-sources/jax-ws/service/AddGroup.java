
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addGroup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gm" type="{http://service/}groupMaster" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addGroup", propOrder = {
    "gm"
})
public class AddGroup {

    protected GroupMaster gm;

    /**
     * Gets the value of the gm property.
     * 
     * @return
     *     possible object is
     *     {@link GroupMaster }
     *     
     */
    public GroupMaster getGm() {
        return gm;
    }

    /**
     * Sets the value of the gm property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupMaster }
     *     
     */
    public void setGm(GroupMaster value) {
        this.gm = value;
    }

}


package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addSecurity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addSecurity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sm" type="{http://service/}securityMaster" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addSecurity", propOrder = {
    "sm"
})
public class AddSecurity {

    protected SecurityMaster sm;

    /**
     * Gets the value of the sm property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityMaster }
     *     
     */
    public SecurityMaster getSm() {
        return sm;
    }

    /**
     * Sets the value of the sm property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityMaster }
     *     
     */
    public void setSm(SecurityMaster value) {
        this.sm = value;
    }

}

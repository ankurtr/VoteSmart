
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for xmlHashMapIL complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="xmlHashMapIL">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="map" type="{http://service/}xmlHashMapWrapperIL" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xmlHashMapIL", propOrder = {
    "map"
})
public class XmlHashMapIL {

    protected XmlHashMapWrapperIL map;

    /**
     * Gets the value of the map property.
     * 
     * @return
     *     possible object is
     *     {@link XmlHashMapWrapperIL }
     *     
     */
    public XmlHashMapWrapperIL getMap() {
        return map;
    }

    /**
     * Sets the value of the map property.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlHashMapWrapperIL }
     *     
     */
    public void setMap(XmlHashMapWrapperIL value) {
        this.map = value;
    }

}

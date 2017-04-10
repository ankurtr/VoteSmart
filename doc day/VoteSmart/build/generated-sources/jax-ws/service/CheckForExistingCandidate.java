
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkForExistingCandidate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkForExistingCandidate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cm" type="{http://service/}candidateMaster" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkForExistingCandidate", propOrder = {
    "cm"
})
public class CheckForExistingCandidate {

    protected CandidateMaster cm;

    /**
     * Gets the value of the cm property.
     * 
     * @return
     *     possible object is
     *     {@link CandidateMaster }
     *     
     */
    public CandidateMaster getCm() {
        return cm;
    }

    /**
     * Sets the value of the cm property.
     * 
     * @param value
     *     allowed object is
     *     {@link CandidateMaster }
     *     
     */
    public void setCm(CandidateMaster value) {
        this.cm = value;
    }

}

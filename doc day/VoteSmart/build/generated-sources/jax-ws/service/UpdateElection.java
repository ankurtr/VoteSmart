
package service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateElection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateElection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="elm" type="{http://service/}electionMaster" minOccurs="0"/>
 *         &lt;element name="electionTypeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="candidateIds" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateElection", propOrder = {
    "elm",
    "electionTypeId",
    "candidateIds"
})
public class UpdateElection {

    protected ElectionMaster elm;
    protected Integer electionTypeId;
    @XmlElement(type = Integer.class)
    protected List<Integer> candidateIds;

    /**
     * Gets the value of the elm property.
     * 
     * @return
     *     possible object is
     *     {@link ElectionMaster }
     *     
     */
    public ElectionMaster getElm() {
        return elm;
    }

    /**
     * Sets the value of the elm property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElectionMaster }
     *     
     */
    public void setElm(ElectionMaster value) {
        this.elm = value;
    }

    /**
     * Gets the value of the electionTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getElectionTypeId() {
        return electionTypeId;
    }

    /**
     * Sets the value of the electionTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setElectionTypeId(Integer value) {
        this.electionTypeId = value;
    }

    /**
     * Gets the value of the candidateIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the candidateIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCandidateIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getCandidateIds() {
        if (candidateIds == null) {
            candidateIds = new ArrayList<Integer>();
        }
        return this.candidateIds;
    }

}

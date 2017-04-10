
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for userGroupMaster complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userGroupMaster">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="groupMaster" type="{http://service/}groupMaster" minOccurs="0"/>
 *         &lt;element name="loginMaster" type="{http://service/}loginMaster" minOccurs="0"/>
 *         &lt;element name="userGroupMasterPK" type="{http://www.w3.org/2001/XMLSchema}ID" minOccurs="0"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userGroupMaster", propOrder = {
    "groupMaster",
    "loginMaster",
    "userGroupMasterPK",
    "username"
})
public class UserGroupMaster {

    protected GroupMaster groupMaster;
    protected LoginMaster loginMaster;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String userGroupMasterPK;
    protected String username;

    /**
     * Gets the value of the groupMaster property.
     * 
     * @return
     *     possible object is
     *     {@link GroupMaster }
     *     
     */
    public GroupMaster getGroupMaster() {
        return groupMaster;
    }

    /**
     * Sets the value of the groupMaster property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupMaster }
     *     
     */
    public void setGroupMaster(GroupMaster value) {
        this.groupMaster = value;
    }

    /**
     * Gets the value of the loginMaster property.
     * 
     * @return
     *     possible object is
     *     {@link LoginMaster }
     *     
     */
    public LoginMaster getLoginMaster() {
        return loginMaster;
    }

    /**
     * Sets the value of the loginMaster property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoginMaster }
     *     
     */
    public void setLoginMaster(LoginMaster value) {
        this.loginMaster = value;
    }

    /**
     * Gets the value of the userGroupMasterPK property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserGroupMasterPK() {
        return userGroupMasterPK;
    }

    /**
     * Sets the value of the userGroupMasterPK property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserGroupMasterPK(String value) {
        this.userGroupMasterPK = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

}

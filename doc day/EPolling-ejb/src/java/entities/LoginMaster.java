/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import adapters.IntegerAdapter;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author sai
 */
@Entity
@Table(name = "LoginMaster", catalog = "EPolling", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Username"})})
@NamedQueries({
    @NamedQuery(name = "LoginMaster.findAll", query = "SELECT l FROM LoginMaster l"),
    @NamedQuery(name = "LoginMaster.findByUserId", query = "SELECT l FROM LoginMaster l WHERE l.userId = :userId"),
    @NamedQuery(name = "LoginMaster.findByUsername", query = "SELECT l FROM LoginMaster l WHERE l.username LIKE :username"),
    @NamedQuery(name = "LoginMaster.findByPassword", query = "SELECT l FROM LoginMaster l WHERE l.password = :password"),
    @NamedQuery(name = "LoginMaster.findByUserType", query = "SELECT l FROM LoginMaster l WHERE l.userType = :userType"),
    @NamedQuery(name = "LoginMaster.findByIsActive", query = "SELECT l FROM LoginMaster l WHERE l.isActive = :isActive"),
    @NamedQuery(name = "LoginMaster.findByUsernameAndPassword", query = "SELECT l FROM LoginMaster l WHERE l.username = :username AND l.password = :password"),
    @NamedQuery(name = "LoginMaster.setCitizensActive", query = "UPDATE LoginMaster l SET l.isActive=true WHERE l.userType='citizen'"),
    @NamedQuery(name = "LoginMaster.setCitizensInActive", query = "UPDATE LoginMaster l SET l.isActive=false WHERE l.userType='citizen'")})
public class LoginMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserId", nullable = false)
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "Username", nullable = false, length = 30)
    private String username;
    @Basic(optional = false)
    @Column(name = "Password", nullable = false, length = 500)
    private String password;
    @Basic(optional = false)
    @Column(name = "UserType", nullable = false, length = 10)
    private String userType;
    @Basic(optional = false)
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loginMaster", fetch = FetchType.EAGER)
    private List<UserGroupMaster> userGroupMasterList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "loginMaster", fetch = FetchType.EAGER)
    private CitizenMaster citizenMaster;

    public LoginMaster() {
    }

    public LoginMaster(Integer userId) {
        this.userId = userId;
    }

    public LoginMaster(Integer userId, String username, String password, String userType, boolean isActive) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.isActive = isActive;
    }

    @XmlID
    @XmlJavaTypeAdapter(IntegerAdapter.class)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @XmlIDREF
    public List<UserGroupMaster> getUserGroupMasterList() {
        return userGroupMasterList;
    }

    public void setUserGroupMasterList(List<UserGroupMaster> userGroupMasterList) {
        this.userGroupMasterList = userGroupMasterList;
    }

    @XmlIDREF
    public CitizenMaster getCitizenMaster() {
        return citizenMaster;
    }

    public void setCitizenMaster(CitizenMaster citizenMaster) {
        this.citizenMaster = citizenMaster;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginMaster)) {
            return false;
        }
        LoginMaster other = (LoginMaster) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LoginMaster[userId=" + userId + "]";
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import adapters.UserGroupPKAdapter;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author sai
 */
@Entity
@Table(name = "UserGroupMaster", catalog = "EPolling", schema = "")
@NamedQueries({
    @NamedQuery(name = "UserGroupMaster.findAll", query = "SELECT u FROM UserGroupMaster u"),
    @NamedQuery(name = "UserGroupMaster.findByUserId", query = "SELECT u FROM UserGroupMaster u WHERE u.userGroupMasterPK.userId = :userId"),
    @NamedQuery(name = "UserGroupMaster.findByGroupName", query = "SELECT u FROM UserGroupMaster u WHERE u.userGroupMasterPK.groupName = :groupName"),
    @NamedQuery(name = "UserGroupMaster.findByUsername", query = "SELECT u FROM UserGroupMaster u WHERE u.username = :username")})
public class UserGroupMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserGroupMasterPK userGroupMasterPK;
    @Basic(optional = false)
    @Column(name = "Username", nullable = false, length = 30)
    private String username;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private LoginMaster loginMaster;
    @JoinColumn(name = "GroupName", referencedColumnName = "GroupName", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private GroupMaster groupMaster;

    public UserGroupMaster() {
    }

    public UserGroupMaster(UserGroupMasterPK userGroupMasterPK) {
        this.userGroupMasterPK = userGroupMasterPK;
    }

    public UserGroupMaster(UserGroupMasterPK userGroupMasterPK, String username) {
        this.userGroupMasterPK = userGroupMasterPK;
        this.username = username;
    }

    public UserGroupMaster(int userId, String groupName) {
        this.userGroupMasterPK = new UserGroupMasterPK(userId, groupName);
    }

    @XmlID
    @XmlJavaTypeAdapter(UserGroupPKAdapter.class)
    public UserGroupMasterPK getUserGroupMasterPK() {
        return userGroupMasterPK;
    }

    public void setUserGroupMasterPK(UserGroupMasterPK userGroupMasterPK) {
        this.userGroupMasterPK = userGroupMasterPK;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LoginMaster getLoginMaster() {
        return loginMaster;
    }

    public void setLoginMaster(LoginMaster loginMaster) {
        this.loginMaster = loginMaster;
    }

    public GroupMaster getGroupMaster() {
        return groupMaster;
    }

    public void setGroupMaster(GroupMaster groupMaster) {
        this.groupMaster = groupMaster;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userGroupMasterPK != null ? userGroupMasterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserGroupMaster)) {
            return false;
        }
        UserGroupMaster other = (UserGroupMaster) object;
        if ((this.userGroupMasterPK == null && other.userGroupMasterPK != null) || (this.userGroupMasterPK != null && !this.userGroupMasterPK.equals(other.userGroupMasterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserGroupMaster[userGroupMasterPK=" + userGroupMasterPK + "]";
    }

}

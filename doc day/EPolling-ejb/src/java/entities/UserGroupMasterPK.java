/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author sai
 */
@Embeddable
public class UserGroupMasterPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "UserId", nullable = false)
    private int userId;
    @Basic(optional = false)
    @Column(name = "GroupName", nullable = false, length = 30)
    private String groupName;

    public UserGroupMasterPK() {
    }

    public UserGroupMasterPK(int userId, String groupName) {
        this.userId = userId;
        this.groupName = groupName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (groupName != null ? groupName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserGroupMasterPK)) {
            return false;
        }
        UserGroupMasterPK other = (UserGroupMasterPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if ((this.groupName == null && other.groupName != null) || (this.groupName != null && !this.groupName.equals(other.groupName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserGroupMasterPK[userId=" + userId + ", groupName=" + groupName + "]";
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;

/**
 *
 * @author sai
 */
@Entity
@Table(name = "GroupMaster", catalog = "EPolling", schema = "")
@NamedQueries({
    @NamedQuery(name = "GroupMaster.findAll", query = "SELECT g FROM GroupMaster g"),
    @NamedQuery(name = "GroupMaster.findByGroupName", query = "SELECT g FROM GroupMaster g WHERE g.groupName = :groupName"),
    @NamedQuery(name = "GroupMaster.findByDescription", query = "SELECT g FROM GroupMaster g WHERE g.description = :description")})
public class GroupMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "GroupName", nullable = false, length = 30)
    private String groupName;
    @Column(name = "Description", length = 300)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupMaster", fetch = FetchType.EAGER)
    private List<UserGroupMaster> userGroupMasterList;

    public GroupMaster() {
    }

    public GroupMaster(String groupName) {
        this.groupName = groupName;
    }

    @XmlID
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlIDREF
    public List<UserGroupMaster> getUserGroupMasterList() {
        return userGroupMasterList;
    }

    public void setUserGroupMasterList(List<UserGroupMaster> userGroupMasterList) {
        this.userGroupMasterList = userGroupMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupName != null ? groupName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupMaster)) {
            return false;
        }
        GroupMaster other = (GroupMaster) object;
        if ((this.groupName == null && other.groupName != null) || (this.groupName != null && !this.groupName.equals(other.groupName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.GroupMaster[groupName=" + groupName + "]";
    }

}

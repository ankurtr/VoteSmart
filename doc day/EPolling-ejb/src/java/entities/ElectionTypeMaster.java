/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import adapters.IntegerAdapter;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author sai
 */
@Entity
@Table(name = "ElectionTypeMaster", catalog = "EPolling", schema = "")
@NamedQueries({
    @NamedQuery(name = "ElectionTypeMaster.findAll", query = "SELECT e FROM ElectionTypeMaster e"),
    @NamedQuery(name = "ElectionTypeMaster.findByElectionTypeId", query = "SELECT e FROM ElectionTypeMaster e WHERE e.electionTypeId = :electionTypeId"),
    @NamedQuery(name = "ElectionTypeMaster.findByTypeName", query = "SELECT e FROM ElectionTypeMaster e WHERE e.typeName = :typeName"),
    @NamedQuery(name = "ElectionTypeMaster.findByDescription", query = "SELECT e FROM ElectionTypeMaster e WHERE e.description = :description")})
public class ElectionTypeMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ElectionTypeId", nullable = false)
    private Integer electionTypeId;
    @Basic(optional = false)
    @Column(name = "TypeName", nullable = false, length = 30)
    private String typeName;
    @Basic(optional = false)
    @Column(name = "Description", nullable = false, length = 500)
    private String description;
    @OneToMany(mappedBy = "electionTypeMaster", fetch = FetchType.EAGER)
    private List<ElectionMaster> electionMasterList;

    public ElectionTypeMaster() {
    }

    public ElectionTypeMaster(Integer electionTypeId) {
        this.electionTypeId = electionTypeId;
    }

    public ElectionTypeMaster(Integer electionTypeId, String typeName, String description) {
        this.electionTypeId = electionTypeId;
        this.typeName = typeName;
        this.description = description;
    }

    @XmlID
    @XmlJavaTypeAdapter(IntegerAdapter.class)
    public Integer getElectionTypeId() {
        return electionTypeId;
    }

    public void setElectionTypeId(Integer electionTypeId) {
        this.electionTypeId = electionTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlIDREF
    public List<ElectionMaster> getElectionMasterList() {
        return electionMasterList;
    }

    public void setElectionMasterList(List<ElectionMaster> electionMasterList) {
        this.electionMasterList = electionMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (electionTypeId != null ? electionTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ElectionTypeMaster)) {
            return false;
        }
        ElectionTypeMaster other = (ElectionTypeMaster) object;
        if ((this.electionTypeId == null && other.electionTypeId != null) || (this.electionTypeId != null && !this.electionTypeId.equals(other.electionTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ElectionTypeMaster[electionTypeId=" + electionTypeId + "]";
    }

}

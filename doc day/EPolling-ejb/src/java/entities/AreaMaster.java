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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "AreaMaster", catalog = "EPolling", schema = "")
@NamedQueries({
    @NamedQuery(name = "AreaMaster.findAll", query = "SELECT a FROM AreaMaster a"),
    @NamedQuery(name = "AreaMaster.findByAreaId", query = "SELECT a FROM AreaMaster a WHERE a.areaId = :areaId"),
    @NamedQuery(name = "AreaMaster.findByAreaName", query = "SELECT a FROM AreaMaster a WHERE a.areaName LIKE :areaName")})
public class AreaMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AreaId", nullable = false)
    private Integer areaId;
    @Basic(optional = false)
    @Column(name = "AreaName", nullable = false, length = 30)
    private String areaName;
    @OneToMany(mappedBy = "areaMaster", fetch = FetchType.EAGER)
    private List<VoteMaster> voteMasterList;
    @JoinColumn(name = "SubWardId", referencedColumnName = "SubWardId", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SubWardMaster subWardMaster;
    @OneToMany(mappedBy = "areaMaster", fetch = FetchType.EAGER)
    private List<CandidateMaster> candidateMasterList;
    @OneToMany(mappedBy = "areaMaster", fetch = FetchType.EAGER)
    private List<CitizenMaster> citizenMasterList;

    public AreaMaster() {
    }

    public AreaMaster(Integer areaId) {
        this.areaId = areaId;
    }

    public AreaMaster(Integer areaId, String areaName) {
        this.areaId = areaId;
        this.areaName = areaName;
    }

    @XmlID
    @XmlJavaTypeAdapter(IntegerAdapter.class)
    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @XmlIDREF
    public List<VoteMaster> getVoteMasterList() {
        return voteMasterList;
    }

    public void setVoteMasterList(List<VoteMaster> voteMasterList) {
        this.voteMasterList = voteMasterList;
    }

    public SubWardMaster getSubWardMaster() {
        return subWardMaster;
    }

    public void setSubWardMaster(SubWardMaster subWardMaster) {
        this.subWardMaster = subWardMaster;
    }

    @XmlIDREF
    public List<CandidateMaster> getCandidateMasterList() {
        return candidateMasterList;
    }

    public void setCandidateMasterList(List<CandidateMaster> candidateMasterList) {
        this.candidateMasterList = candidateMasterList;
    }

    @XmlIDREF
    public List<CitizenMaster> getCitizenMasterList() {
        return citizenMasterList;
    }

    public void setCitizenMasterList(List<CitizenMaster> citizenMasterList) {
        this.citizenMasterList = citizenMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areaId != null ? areaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaMaster)) {
            return false;
        }
        AreaMaster other = (AreaMaster) object;
        if ((this.areaId == null && other.areaId != null) || (this.areaId != null && !this.areaId.equals(other.areaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AreaMaster[areaId=" + areaId + "]";
    }

}

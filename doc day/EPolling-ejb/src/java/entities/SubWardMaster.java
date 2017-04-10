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
@Table(name = "SubWardMaster", catalog = "EPolling", schema = "")
@NamedQueries({
    @NamedQuery(name = "SubWardMaster.findAll", query = "SELECT s FROM SubWardMaster s"),
    @NamedQuery(name = "SubWardMaster.findBySubWardId", query = "SELECT s FROM SubWardMaster s WHERE s.subWardId = :subWardId"),
    @NamedQuery(name = "SubWardMaster.findBySubWardName", query = "SELECT s FROM SubWardMaster s WHERE s.subWardName LIKE :subWardName")})
public class SubWardMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SubWardId", nullable = false)
    private Integer subWardId;
    @Basic(optional = false)
    @Column(name = "SubWardName", nullable = false, length = 30)
    private String subWardName;
    @OneToMany(mappedBy = "subWardMaster", fetch = FetchType.EAGER)
    private List<VoteMaster> voteMasterList;
    @JoinColumn(name = "WardId", referencedColumnName = "WardId")
    @ManyToOne(fetch = FetchType.EAGER)
    private WardMaster wardMaster;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subWardMaster", fetch = FetchType.EAGER)
    private List<AreaMaster> areaMasterList;
    @OneToMany(mappedBy = "subWardMaster", fetch = FetchType.EAGER)
    private List<CandidateMaster> candidateMasterList;
    @OneToMany(mappedBy = "subWardMaster", fetch = FetchType.EAGER)
    private List<CitizenMaster> citizenMasterList;

    public SubWardMaster() {
    }

    public SubWardMaster(Integer subWardId) {
        this.subWardId = subWardId;
    }

    public SubWardMaster(Integer subWardId, String subWardName) {
        this.subWardId = subWardId;
        this.subWardName = subWardName;
    }

    @XmlID
    @XmlJavaTypeAdapter(IntegerAdapter.class)
    public Integer getSubWardId() {
        return subWardId;
    }

    public void setSubWardId(Integer subWardId) {
        this.subWardId = subWardId;
    }

    public String getSubWardName() {
        return subWardName;
    }

    public void setSubWardName(String subWardName) {
        this.subWardName = subWardName;
    }

    @XmlIDREF
    public List<VoteMaster> getVoteMasterList() {
        return voteMasterList;
    }

    public void setVoteMasterList(List<VoteMaster> voteMasterList) {
        this.voteMasterList = voteMasterList;
    }

    public WardMaster getWardMaster() {
        return wardMaster;
    }

    public void setWardMaster(WardMaster wardMaster) {
        this.wardMaster = wardMaster;
    }

    @XmlIDREF
    public List<AreaMaster> getAreaMasterList() {
        return areaMasterList;
    }

    public void setAreaMasterList(List<AreaMaster> areaMasterList) {
        this.areaMasterList = areaMasterList;
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
        hash += (subWardId != null ? subWardId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubWardMaster)) {
            return false;
        }
        SubWardMaster other = (SubWardMaster) object;
        if ((this.subWardId == null && other.subWardId != null) || (this.subWardId != null && !this.subWardId.equals(other.subWardId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SubWardMaster[subWardId=" + subWardId + "]";
    }

}

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
@Table(name = "WardMaster", catalog = "EPolling", schema = "")
@NamedQueries({
    @NamedQuery(name = "WardMaster.findAll", query = "SELECT w FROM WardMaster w"),
    @NamedQuery(name = "WardMaster.findByWardId", query = "SELECT w FROM WardMaster w WHERE w.wardId = :wardId"),
    @NamedQuery(name = "WardMaster.findByWardName", query = "SELECT w FROM WardMaster w WHERE w.wardName LIKE :wardName")})
public class WardMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "WardId", nullable = false)
    private Integer wardId;
    @Basic(optional = false)
    @Column(name = "WardName", nullable = false, length = 30)
    private String wardName;
    @OneToMany(mappedBy = "wardMaster", fetch = FetchType.EAGER)
    private List<VoteMaster> voteMasterList;
    @OneToMany(mappedBy = "wardMaster", fetch = FetchType.EAGER)
    private List<SubWardMaster> subWardMasterList;
    @OneToMany(mappedBy = "wardMaster", fetch = FetchType.EAGER)
    private List<CandidateMaster> candidateMasterList;
    @JoinColumn(name = "ZoneId", referencedColumnName = "ZoneId")
    @ManyToOne(fetch = FetchType.EAGER)
    private ZoneMaster zoneMaster;
    @OneToMany(mappedBy = "wardMaster", fetch = FetchType.EAGER)
    private List<CitizenMaster> citizenMasterList;

    public WardMaster() {
    }

    public WardMaster(Integer wardId) {
        this.wardId = wardId;
    }

    public WardMaster(Integer wardId, String wardName) {
        this.wardId = wardId;
        this.wardName = wardName;
    }

    @XmlID
    @XmlJavaTypeAdapter(IntegerAdapter.class)
    public Integer getWardId() {
        return wardId;
    }

    public void setWardId(Integer wardId) {
        this.wardId = wardId;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    @XmlIDREF
    public List<VoteMaster> getVoteMasterList() {
        return voteMasterList;
    }

    public void setVoteMasterList(List<VoteMaster> voteMasterList) {
        this.voteMasterList = voteMasterList;
    }

    @XmlIDREF
    public List<SubWardMaster> getSubWardMasterList() {
        return subWardMasterList;
    }

    public void setSubWardMasterList(List<SubWardMaster> subWardMasterList) {
        this.subWardMasterList = subWardMasterList;
    }

    @XmlIDREF
    public List<CandidateMaster> getCandidateMasterList() {
        return candidateMasterList;
    }

    public void setCandidateMasterList(List<CandidateMaster> candidateMasterList) {
        this.candidateMasterList = candidateMasterList;
    }

    public ZoneMaster getZoneMaster() {
        return zoneMaster;
    }

    public void setZoneMaster(ZoneMaster zoneMaster) {
        this.zoneMaster = zoneMaster;
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
        hash += (wardId != null ? wardId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WardMaster)) {
            return false;
        }
        WardMaster other = (WardMaster) object;
        if ((this.wardId == null && other.wardId != null) || (this.wardId != null && !this.wardId.equals(other.wardId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.WardMaster[wardId=" + wardId + "]";
    }

}

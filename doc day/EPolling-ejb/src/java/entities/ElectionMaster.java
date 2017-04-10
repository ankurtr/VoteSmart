/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import adapters.IntegerAdapter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author sai
 */
@Entity
@Table(name = "ElectionMaster", catalog = "EPolling", schema = "")
@NamedQueries({
    @NamedQuery(name = "ElectionMaster.findAll", query = "SELECT e FROM ElectionMaster e"),
    @NamedQuery(name = "ElectionMaster.findByElectionId", query = "SELECT e FROM ElectionMaster e WHERE e.electionId = :electionId"),
    @NamedQuery(name = "ElectionMaster.findByName", query = "SELECT e FROM ElectionMaster e WHERE e.name LIKE :name"),
    @NamedQuery(name = "ElectionMaster.findByFinalDate", query = "SELECT e FROM ElectionMaster e WHERE e.finalDate = :finalDate"),
    @NamedQuery(name = "ElectionMaster.findByStartTime", query = "SELECT e FROM ElectionMaster e WHERE e.startTime = :startTime"),
    @NamedQuery(name = "ElectionMaster.findByEndTime", query = "SELECT e FROM ElectionMaster e WHERE e.endTime = :endTime"),
    @NamedQuery(name = "ElectionMaster.findByIsActive", query = "SELECT e FROM ElectionMaster e WHERE e.isActive = :isActive"),
    @NamedQuery(name = "ElectionMaster.findFutureElections", query = "SELECT e FROM ElectionMaster e WHERE e.finalDate >= :finalDate"),
    @NamedQuery(name = "ElectionMaster.findPastElections", query = "SELECT e FROM ElectionMaster e WHERE e.finalDate < :finalDate")})
public class ElectionMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ElectionId", nullable = false)
    private Integer electionId;
    @Basic(optional = false)
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Basic(optional = false)
    @Column(name = "FinalDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date finalDate;
    @Basic(optional = false)
    @Column(name = "StartTime", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Basic(optional = false)
    @Column(name = "EndTime", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @Basic(optional = false)
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @ManyToMany(mappedBy = "electionMasterList", fetch = FetchType.EAGER)
    private List<CandidateMaster> candidateMasterList;
    @OneToMany(mappedBy = "electionMaster", fetch = FetchType.EAGER)
    private List<VoteMaster> voteMasterList;
    @JoinColumn(name = "ElectionTypeId", referencedColumnName = "ElectionTypeId")
    @ManyToOne(fetch = FetchType.EAGER)
    private ElectionTypeMaster electionTypeMaster;

    public ElectionMaster() {
    }

    public ElectionMaster(Integer electionId) {
        this.electionId = electionId;
    }

    public ElectionMaster(Integer electionId, String name, Date finalDate, Date startTime, Date endTime, boolean isActive) {
        this.electionId = electionId;
        this.name = name;
        this.finalDate = finalDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isActive = isActive;
    }

    @XmlID
    @XmlJavaTypeAdapter(IntegerAdapter.class)
    public Integer getElectionId() {
        return electionId;
    }

    public void setElectionId(Integer electionId) {
        this.electionId = electionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @XmlIDREF
    public List<CandidateMaster> getCandidateMasterList() {
        return candidateMasterList;
    }

    public void setCandidateMasterList(List<CandidateMaster> candidateMasterList) {
        this.candidateMasterList = candidateMasterList;
    }

    @XmlIDREF
    public List<VoteMaster> getVoteMasterList() {
        return voteMasterList;
    }

    public void setVoteMasterList(List<VoteMaster> voteMasterList) {
        this.voteMasterList = voteMasterList;
    }

    public ElectionTypeMaster getElectionTypeMaster() {
        return electionTypeMaster;
    }

    public void setElectionTypeMaster(ElectionTypeMaster electionTypeMaster) {
        this.electionTypeMaster = electionTypeMaster;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (electionId != null ? electionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ElectionMaster)) {
            return false;
        }
        ElectionMaster other = (ElectionMaster) object;
        if ((this.electionId == null && other.electionId != null) || (this.electionId != null && !this.electionId.equals(other.electionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ElectionMaster[electionId=" + electionId + "]";
    }
}

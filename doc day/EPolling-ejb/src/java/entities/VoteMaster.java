/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import adapters.IntegerAdapter;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author sai
 */
@Entity
@Table(name = "VoteMaster", catalog = "EPolling", schema = "")
@NamedQueries({
    @NamedQuery(name = "VoteMaster.findAll", query = "SELECT v FROM VoteMaster v"),
    @NamedQuery(name = "VoteMaster.findByVoteId", query = "SELECT v FROM VoteMaster v WHERE v.voteId = :voteId"),
    @NamedQuery(name = "VoteMaster.findByVoteDateTime", query = "SELECT v FROM VoteMaster v WHERE v.voteDateTime = :voteDateTime")})
public class VoteMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VoteId", nullable = false)
    private Integer voteId;
    @Basic(optional = false)
    @Column(name = "VoteDateTime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date voteDateTime;
    @JoinColumn(name = "ZoneId", referencedColumnName = "ZoneId")
    @ManyToOne(fetch = FetchType.EAGER)
    private ZoneMaster zoneMaster;
    @JoinColumn(name = "WardId", referencedColumnName = "WardId")
    @ManyToOne(fetch = FetchType.EAGER)
    private WardMaster wardMaster;
    @JoinColumn(name = "SubwardId", referencedColumnName = "SubWardId")
    @ManyToOne(fetch = FetchType.EAGER)
    private SubWardMaster subWardMaster;
    @JoinColumn(name = "ElectionId", referencedColumnName = "ElectionId")
    @ManyToOne(fetch = FetchType.EAGER)
    private ElectionMaster electionMaster;
    @JoinColumn(name = "CandidateId", referencedColumnName = "CandidateId")
    @ManyToOne(fetch = FetchType.EAGER)
    private CandidateMaster candidateMaster;
    @JoinColumn(name = "AreaId", referencedColumnName = "AreaId")
    @ManyToOne(fetch = FetchType.EAGER)
    private AreaMaster areaMaster;

    public VoteMaster() {
    }

    public VoteMaster(Integer voteId) {
        this.voteId = voteId;
    }

    public VoteMaster(Integer voteId, Date voteDateTime) {
        this.voteId = voteId;
        this.voteDateTime = voteDateTime;
    }

    @XmlID
    @XmlJavaTypeAdapter(IntegerAdapter.class)
    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public Date getVoteDateTime() {
        return voteDateTime;
    }

    public void setVoteDateTime(Date voteDateTime) {
        this.voteDateTime = voteDateTime;
    }

    public ZoneMaster getZoneMaster() {
        return zoneMaster;
    }

    public void setZoneMaster(ZoneMaster zoneMaster) {
        this.zoneMaster = zoneMaster;
    }

    public WardMaster getWardMaster() {
        return wardMaster;
    }

    public void setWardMaster(WardMaster wardMaster) {
        this.wardMaster = wardMaster;
    }

    public SubWardMaster getSubWardMaster() {
        return subWardMaster;
    }

    public void setSubWardMaster(SubWardMaster subWardMaster) {
        this.subWardMaster = subWardMaster;
    }

    public ElectionMaster getElectionMaster() {
        return electionMaster;
    }

    public void setElectionMaster(ElectionMaster electionMaster) {
        this.electionMaster = electionMaster;
    }

    public CandidateMaster getCandidateMaster() {
        return candidateMaster;
    }

    public void setCandidateMaster(CandidateMaster candidateMaster) {
        this.candidateMaster = candidateMaster;
    }

    public AreaMaster getAreaMaster() {
        return areaMaster;
    }

    public void setAreaMaster(AreaMaster areaMaster) {
        this.areaMaster = areaMaster;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (voteId != null ? voteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VoteMaster)) {
            return false;
        }
        VoteMaster other = (VoteMaster) object;
        if ((this.voteId == null && other.voteId != null) || (this.voteId != null && !this.voteId.equals(other.voteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VoteMaster[voteId=" + voteId + "]";
    }

}

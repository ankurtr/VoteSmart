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
@Table(name = "ZoneMaster", catalog = "EPolling", schema = "")
@NamedQueries({
    @NamedQuery(name = "ZoneMaster.findAll", query = "SELECT z FROM ZoneMaster z"),
    @NamedQuery(name = "ZoneMaster.findByZoneId", query = "SELECT z FROM ZoneMaster z WHERE z.zoneId = :zoneId"),
    @NamedQuery(name = "ZoneMaster.findByZoneName", query = "SELECT z FROM ZoneMaster z WHERE z.zoneName LIKE :zoneName"),
    @NamedQuery(name = "ZoneMaster.findByPopulation", query = "SELECT z FROM ZoneMaster z WHERE z.population = :population")})
public class ZoneMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ZoneId", nullable = false)
    private Integer zoneId;
    @Basic(optional = false)
    @Column(name = "ZoneName", nullable = false, length = 30)
    private String zoneName;
    @Basic(optional = false)
    @Column(name = "Population", nullable = false)
    private long population;
    @OneToMany(mappedBy = "zoneMaster", fetch = FetchType.EAGER)
    private List<VoteMaster> voteMasterList;
    @OneToMany(mappedBy = "zoneMaster", fetch = FetchType.EAGER)
    private List<CandidateMaster> candidateMasterList;
    @JoinColumn(name = "CityId", referencedColumnName = "CityId")
    @ManyToOne(fetch = FetchType.EAGER)
    private CityMaster cityMaster;
    @OneToMany(mappedBy = "zoneMaster", fetch = FetchType.EAGER)
    private List<WardMaster> wardMasterList;
    @OneToMany(mappedBy = "zoneMaster", fetch = FetchType.EAGER)
    private List<CitizenMaster> citizenMasterList;

    public ZoneMaster() {
    }

    public ZoneMaster(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public ZoneMaster(Integer zoneId, String zoneName, long population) {
        this.zoneId = zoneId;
        this.zoneName = zoneName;
        this.population = population;
    }

    @XmlID
    @XmlJavaTypeAdapter(IntegerAdapter.class)
    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    @XmlIDREF
    public List<VoteMaster> getVoteMasterList() {
        return voteMasterList;
    }

    public void setVoteMasterList(List<VoteMaster> voteMasterList) {
        this.voteMasterList = voteMasterList;
    }

    @XmlIDREF
    public List<CandidateMaster> getCandidateMasterList() {
        return candidateMasterList;
    }

    public void setCandidateMasterList(List<CandidateMaster> candidateMasterList) {
        this.candidateMasterList = candidateMasterList;
    }

    public CityMaster getCityMaster() {
        return cityMaster;
    }

    public void setCityMaster(CityMaster cityMaster) {
        this.cityMaster = cityMaster;
    }

    @XmlIDREF
    public List<WardMaster> getWardMasterList() {
        return wardMasterList;
    }

    public void setWardMasterList(List<WardMaster> wardMasterList) {
        this.wardMasterList = wardMasterList;
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
        hash += (zoneId != null ? zoneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZoneMaster)) {
            return false;
        }
        ZoneMaster other = (ZoneMaster) object;
        if ((this.zoneId == null && other.zoneId != null) || (this.zoneId != null && !this.zoneId.equals(other.zoneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ZoneMaster[zoneId=" + zoneId + "]";
    }

}

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
import javax.persistence.JoinTable;
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
@Table(name = "CandidateMaster", catalog = "EPolling", schema = "")
@NamedQueries({
    @NamedQuery(name = "CandidateMaster.findAll", query = "SELECT c FROM CandidateMaster c"),
    @NamedQuery(name = "CandidateMaster.findByCandidateId", query = "SELECT c FROM CandidateMaster c WHERE c.candidateId = :candidateId"),
    @NamedQuery(name = "CandidateMaster.findByFirstName", query = "SELECT c FROM CandidateMaster c WHERE c.firstName LIKE :firstName"),
    @NamedQuery(name = "CandidateMaster.findByLastName", query = "SELECT c FROM CandidateMaster c WHERE c.lastName LIKE :lastName"),
    @NamedQuery(name = "CandidateMaster.findByEmail", query = "SELECT c FROM CandidateMaster c WHERE c.email = :email"),
    @NamedQuery(name = "CandidateMaster.findByDateOfBirth", query = "SELECT c FROM CandidateMaster c WHERE c.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "CandidateMaster.findByNationality", query = "SELECT c FROM CandidateMaster c WHERE c.nationality = :nationality"),
    @NamedQuery(name = "CandidateMaster.findBySex", query = "SELECT c FROM CandidateMaster c WHERE c.sex = :sex"),
    @NamedQuery(name = "CandidateMaster.findByAddress", query = "SELECT c FROM CandidateMaster c WHERE c.address = :address"),
    @NamedQuery(name = "CandidateMaster.findByPhoneNo", query = "SELECT c FROM CandidateMaster c WHERE c.phoneNo = :phoneNo"),
    @NamedQuery(name = "CandidateMaster.findByImage", query = "SELECT c FROM CandidateMaster c WHERE c.image = :image"),
    @NamedQuery(name = "CandidateMaster.findByIsActive", query = "SELECT c FROM CandidateMaster c WHERE c.isActive = :isActive"),
    @NamedQuery(name = "CandidateMaster.findExisting", query = "SELECT c FROM CandidateMaster c WHERE c.firstName= :firstName AND c.lastName= :lastName AND c.email= :email AND"
    + " c.dateOfBirth= :dateOfBirth AND c.nationality= :nationality AND c.sex= :sex AND c.address= :address AND c.phoneNo= :phoneNo AND"
    + " c.image= :image AND c.isActive= :isActive")})
public class CandidateMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CandidateId", nullable = false)
    private Integer candidateId;
    @Basic(optional = false)
    @Column(name = "FirstName", nullable = false, length = 30)
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LastName", nullable = false, length = 30)
    private String lastName;
    @Basic(optional = false)
    @Column(name = "Email", nullable = false, length = 30)
    private String email;
    @Basic(optional = false)
    @Column(name = "DateOfBirth", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Basic(optional = false)
    @Column(name = "Nationality", nullable = false, length = 20)
    private String nationality;
    @Basic(optional = false)
    @Column(name = "Sex", nullable = false)
    private boolean sex;
    @Basic(optional = false)
    @Column(name = "Address", nullable = false, length = 50)
    private String address;
    @Basic(optional = false)
    @Column(name = "PhoneNo", nullable = false, length = 20)
    private String phoneNo;
    @Basic(optional = false)
    @Column(name = "Image", nullable = false, length = 300)
    private String image;
    @Basic(optional = false)
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @JoinTable(name = "ElectionCandidateMaster", joinColumns = {
        @JoinColumn(name = "CandidateId", referencedColumnName = "CandidateId", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "ElectionId", referencedColumnName = "ElectionId", nullable = false)})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<ElectionMaster> electionMasterList;
    @OneToMany(mappedBy = "candidateMaster", fetch = FetchType.EAGER)
    private List<VoteMaster> voteMasterList;
    @JoinColumn(name = "ZoneId", referencedColumnName = "ZoneId")
    @ManyToOne(fetch = FetchType.EAGER)
    private ZoneMaster zoneMaster;
    @JoinColumn(name = "WardId", referencedColumnName = "WardId")
    @ManyToOne(fetch = FetchType.EAGER)
    private WardMaster wardMaster;
    @JoinColumn(name = "SubWardId", referencedColumnName = "SubWardId")
    @ManyToOne(fetch = FetchType.EAGER)
    private SubWardMaster subWardMaster;
    @JoinColumn(name = "PartyId", referencedColumnName = "PartyId")
    @ManyToOne(fetch = FetchType.EAGER)
    private PartyMaster partyMaster;
    @JoinColumn(name = "AreaId", referencedColumnName = "AreaId")
    @ManyToOne(fetch = FetchType.EAGER)
    private AreaMaster areaMaster;

    public CandidateMaster() {
    }

    public CandidateMaster(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public CandidateMaster(Integer candidateId, String firstName, String lastName, String email, Date dateOfBirth, String nationality, boolean sex, String address, String phoneNo, String image, boolean isActive) {
        this.candidateId = candidateId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.sex = sex;
        this.address = address;
        this.phoneNo = phoneNo;
        this.image = image;
        this.isActive = isActive;
    }

    @XmlID
    @XmlJavaTypeAdapter(IntegerAdapter.class)
    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @XmlIDREF
    public List<ElectionMaster> getElectionMasterList() {
        return electionMasterList;
    }

    public void setElectionMasterList(List<ElectionMaster> electionMasterList) {
        this.electionMasterList = electionMasterList;
    }

    @XmlIDREF
    public List<VoteMaster> getVoteMasterList() {
        return voteMasterList;
    }

    public void setVoteMasterList(List<VoteMaster> voteMasterList) {
        this.voteMasterList = voteMasterList;
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

    public PartyMaster getPartyMaster() {
        return partyMaster;
    }

    public void setPartyMaster(PartyMaster partyMaster) {
        this.partyMaster = partyMaster;
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
        hash += (candidateId != null ? candidateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CandidateMaster)) {
            return false;
        }
        CandidateMaster other = (CandidateMaster) object;
        if ((this.candidateId == null && other.candidateId != null) || (this.candidateId != null && !this.candidateId.equals(other.candidateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CandidateMaster[candidateId=" + candidateId + "]";
    }
}

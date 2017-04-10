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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "CitizenMaster", catalog = "EPolling", schema = "")
@NamedQueries({
    @NamedQuery(name = "CitizenMaster.findAll", query = "SELECT c FROM CitizenMaster c"),
    @NamedQuery(name = "CitizenMaster.findByUserId", query = "SELECT c FROM CitizenMaster c WHERE c.userId = :userId"),
    @NamedQuery(name = "CitizenMaster.findByName", query = "SELECT c FROM CitizenMaster c WHERE c.name LIKE :name"),
    @NamedQuery(name = "CitizenMaster.findByAddress", query = "SELECT c FROM CitizenMaster c WHERE c.address = :address"),
    @NamedQuery(name = "CitizenMaster.findByContactNo", query = "SELECT c FROM CitizenMaster c WHERE c.contactNo = :contactNo"),
    @NamedQuery(name = "CitizenMaster.findByThumbImage", query = "SELECT c FROM CitizenMaster c WHERE c.thumbImage = :thumbImage"),
    @NamedQuery(name = "CitizenMaster.findByVoterCardImage", query = "SELECT c FROM CitizenMaster c WHERE c.voterCardImage = :voterCardImage"),
    @NamedQuery(name = "CitizenMaster.findByFaceImage", query = "SELECT c FROM CitizenMaster c WHERE c.faceImage = :faceImage"),
    @NamedQuery(name = "CitizenMaster.findBySignatureImage", query = "SELECT c FROM CitizenMaster c WHERE c.signatureImage = :signatureImage"),
    @NamedQuery(name = "CitizenMaster.findByDateOfBirth", query = "SELECT c FROM CitizenMaster c WHERE c.dateOfBirth = :dateOfBirth")})
public class CitizenMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UserId", nullable = false)
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Basic(optional = false)
    @Column(name = "Address", nullable = false, length = 50)
    private String address;
    @Basic(optional = false)
    @Column(name = "ContactNo", nullable = false, length = 20)
    private String contactNo;
    @Basic(optional = false)
    @Column(name = "ThumbImage", nullable = false, length = 300)
    private String thumbImage;
    @Basic(optional = false)
    @Column(name = "VoterCardImage", nullable = false, length = 300)
    private String voterCardImage;
    @Basic(optional = false)
    @Column(name = "FaceImage", nullable = false, length = 300)
    private String faceImage;
    @Basic(optional = false)
    @Column(name = "SignatureImage", nullable = false, length = 300)
    private String signatureImage;
    @Basic(optional = false)
    @Column(name = "DateOfBirth", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @JoinColumn(name = "ZoneId", referencedColumnName = "ZoneId")
    @ManyToOne(fetch = FetchType.EAGER)
    private ZoneMaster zoneMaster;
    @JoinColumn(name = "WardId", referencedColumnName = "WardId")
    @ManyToOne(fetch = FetchType.EAGER)
    private WardMaster wardMaster;
    @JoinColumn(name = "SubWardId", referencedColumnName = "SubWardId")
    @ManyToOne(fetch = FetchType.EAGER)
    private SubWardMaster subWardMaster;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private LoginMaster loginMaster;
    @JoinColumn(name = "AreaId", referencedColumnName = "AreaId")
    @ManyToOne(fetch = FetchType.EAGER)
    private AreaMaster areaMaster;

    public CitizenMaster() {
    }

    public CitizenMaster(Integer userId) {
        this.userId = userId;
    }

    public CitizenMaster(Integer userId, String name, String address, String contactNo, String thumbImage, String voterCardImage, String faceImage, String signatureImage, Date dateOfBirth) {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.thumbImage = thumbImage;
        this.voterCardImage = voterCardImage;
        this.faceImage = faceImage;
        this.signatureImage = signatureImage;
        this.dateOfBirth = dateOfBirth;
    }

    @XmlID
    @XmlJavaTypeAdapter(IntegerAdapter.class)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getThumbImage() {
        return thumbImage;
    }

    public void setThumbImage(String thumbImage) {
        this.thumbImage = thumbImage;
    }

    public String getVoterCardImage() {
        return voterCardImage;
    }

    public void setVoterCardImage(String voterCardImage) {
        this.voterCardImage = voterCardImage;
    }

    public String getFaceImage() {
        return faceImage;
    }

    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage;
    }

    public String getSignatureImage() {
        return signatureImage;
    }

    public void setSignatureImage(String signatureImage) {
        this.signatureImage = signatureImage;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    @XmlIDREF
    public LoginMaster getLoginMaster() {
        return loginMaster;
    }

    public void setLoginMaster(LoginMaster loginMaster) {
        this.loginMaster = loginMaster;
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
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CitizenMaster)) {
            return false;
        }
        CitizenMaster other = (CitizenMaster) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CitizenMaster[userId=" + userId + "]";
    }

}

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
@Table(name = "PartyMaster", catalog = "EPolling", schema = "")
@NamedQueries({
    @NamedQuery(name = "PartyMaster.findAll", query = "SELECT p FROM PartyMaster p"),
    @NamedQuery(name = "PartyMaster.findByPartyId", query = "SELECT p FROM PartyMaster p WHERE p.partyId = :partyId"),
    @NamedQuery(name = "PartyMaster.findByPartyName", query = "SELECT p FROM PartyMaster p WHERE p.partyName LIKE :partyName"),
    @NamedQuery(name = "PartyMaster.findByPartyLogo", query = "SELECT p FROM PartyMaster p WHERE p.partyLogo = :partyLogo"),
    @NamedQuery(name = "PartyMaster.findByPartySlogan", query = "SELECT p FROM PartyMaster p WHERE p.partySlogan = :partySlogan"),
    @NamedQuery(name = "PartyMaster.findByDescription", query = "SELECT p FROM PartyMaster p WHERE p.description = :description")})
public class PartyMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PartyId", nullable = false)
    private Integer partyId;
    @Basic(optional = false)
    @Column(name = "PartyName", nullable = false, length = 30)
    private String partyName;
    @Basic(optional = false)
    @Column(name = "PartyLogo", nullable = false, length = 300)
    private String partyLogo;
    @Basic(optional = false)
    @Column(name = "PartySlogan", nullable = false, length = 300)
    private String partySlogan;
    @Basic(optional = false)
    @Column(name = "Description", nullable = false, length = 500)
    private String description;
    @OneToMany(mappedBy = "partyMaster", fetch = FetchType.EAGER)
    private List<CandidateMaster> candidateMasterList;

    public PartyMaster() {
    }

    public PartyMaster(Integer partyId) {
        this.partyId = partyId;
    }

    public PartyMaster(Integer partyId, String partyName, String partyLogo, String partySlogan, String description) {
        this.partyId = partyId;
        this.partyName = partyName;
        this.partyLogo = partyLogo;
        this.partySlogan = partySlogan;
        this.description = description;
    }

    @XmlID
    @XmlJavaTypeAdapter(IntegerAdapter.class)
    public Integer getPartyId() {
        return partyId;
    }

    public void setPartyId(Integer partyId) {
        this.partyId = partyId;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getPartyLogo() {
        return partyLogo;
    }

    public void setPartyLogo(String partyLogo) {
        this.partyLogo = partyLogo;
    }

    public String getPartySlogan() {
        return partySlogan;
    }

    public void setPartySlogan(String partySlogan) {
        this.partySlogan = partySlogan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlIDREF
    public List<CandidateMaster> getCandidateMasterList() {
        return candidateMasterList;
    }

    public void setCandidateMasterList(List<CandidateMaster> candidateMasterList) {
        this.candidateMasterList = candidateMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partyId != null ? partyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PartyMaster)) {
            return false;
        }
        PartyMaster other = (PartyMaster) object;
        if ((this.partyId == null && other.partyId != null) || (this.partyId != null && !this.partyId.equals(other.partyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PartyMaster[partyId=" + partyId + "]";
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import adapters.IntegerAdapter;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author sai
 */
@Entity
@Table(name = "SecurityMaster", catalog = "EPolling", schema = "")
@NamedQueries({
    @NamedQuery(name = "SecurityMaster.findAll", query = "SELECT s FROM SecurityMaster s"),
    @NamedQuery(name = "SecurityMaster.findBySecurityId", query = "SELECT s FROM SecurityMaster s WHERE s.securityId = :securityId"),
    @NamedQuery(name = "SecurityMaster.findBySecurityName", query = "SELECT s FROM SecurityMaster s WHERE s.securityName = :securityName"),
    @NamedQuery(name = "SecurityMaster.findByDescription", query = "SELECT s FROM SecurityMaster s WHERE s.description = :description"),
    @NamedQuery(name = "SecurityMaster.findByIsActive", query = "SELECT s FROM SecurityMaster s WHERE s.isActive = :isActive")})
public class SecurityMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SecurityId", nullable = false)
    private Integer securityId;
    @Basic(optional = false)
    @Column(name = "SecurityName", nullable = false, length = 50)
    private String securityName;
    @Basic(optional = false)
    @Column(name = "Description", nullable = false, length = 500)
    private String description;
    @Basic(optional = false)
    @Column(name = "isActive", nullable = false)
    private boolean isActive;

    public SecurityMaster() {
    }

    public SecurityMaster(Integer securityId) {
        this.securityId = securityId;
    }

    public SecurityMaster(Integer securityId, String securityName, String description, boolean isActive) {
        this.securityId = securityId;
        this.securityName = securityName;
        this.description = description;
        this.isActive = isActive;
    }

    @XmlID
    @XmlJavaTypeAdapter(IntegerAdapter.class)
    public Integer getSecurityId() {
        return securityId;
    }

    public void setSecurityId(Integer securityId) {
        this.securityId = securityId;
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (securityId != null ? securityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SecurityMaster)) {
            return false;
        }
        SecurityMaster other = (SecurityMaster) object;
        if ((this.securityId == null && other.securityId != null) || (this.securityId != null && !this.securityId.equals(other.securityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SecurityMaster[securityId=" + securityId + "]";
    }

}

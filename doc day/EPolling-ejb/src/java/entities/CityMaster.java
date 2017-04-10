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
@Table(name = "CityMaster", catalog = "EPolling", schema = "")
@NamedQueries({
    @NamedQuery(name = "CityMaster.findAll", query = "SELECT c FROM CityMaster c"),
    @NamedQuery(name = "CityMaster.findByCityId", query = "SELECT c FROM CityMaster c WHERE c.cityId = :cityId"),
    @NamedQuery(name = "CityMaster.findByCityName", query = "SELECT c FROM CityMaster c WHERE c.cityName = :cityName"),
    @NamedQuery(name = "CityMaster.findByStateId", query = "SELECT c FROM CityMaster c WHERE c.stateId = :stateId"),
    @NamedQuery(name = "CityMaster.findByCountryId", query = "SELECT c FROM CityMaster c WHERE c.countryId = :countryId")})
public class CityMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CityId", nullable = false)
    private Integer cityId;
    @Basic(optional = false)
    @Column(name = "CityName", nullable = false, length = 30)
    private String cityName;
    @Basic(optional = false)
    @Column(name = "StateId", nullable = false)
    private int stateId;
    @Basic(optional = false)
    @Column(name = "CountryId", nullable = false)
    private int countryId;
    @OneToMany(mappedBy = "cityMaster", fetch = FetchType.EAGER)
    private List<ZoneMaster> zoneMasterList;

    public CityMaster() {
    }

    public CityMaster(Integer cityId) {
        this.cityId = cityId;
    }

    public CityMaster(Integer cityId, String cityName, int stateId, int countryId) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.stateId = stateId;
        this.countryId = countryId;
    }

    @XmlID
    @XmlJavaTypeAdapter(IntegerAdapter.class)
    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @XmlIDREF
    public List<ZoneMaster> getZoneMasterList() {
        return zoneMasterList;
    }

    public void setZoneMasterList(List<ZoneMaster> zoneMasterList) {
        this.zoneMasterList = zoneMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityId != null ? cityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CityMaster)) {
            return false;
        }
        CityMaster other = (CityMaster) object;
        if ((this.cityId == null && other.cityId != null) || (this.cityId != null && !this.cityId.equals(other.cityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CityMaster[cityId=" + cityId + "]";
    }

}

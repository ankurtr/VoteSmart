/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.AreaMaster;
import entities.CandidateMaster;
import entities.CitizenMaster;
import entities.CityMaster;
import entities.LoginMaster;
import entities.PartyMaster;
import entities.SubWardMaster;
import entities.WardMaster;
import entities.ZoneMaster;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author root
 */
@Remote
public interface CoreBeanRemote {

    // <editor-fold defaultstate="collapsed" desc="CandidateMaster methods">
    public boolean addCandidate(CandidateMaster cm, Integer zoneId, Integer wardId, Integer subwardId, Integer areaId, Integer partyId);

    boolean checkForExistingCandidate(CandidateMaster cm);

    boolean updateCandidate(CandidateMaster cm, Integer zoneId, Integer wardId, Integer subwardId, Integer areaId, Integer partyId);

    CandidateMaster getCandidate(Integer candidateID);

    List<CandidateMaster> getAllCandidates();

    List<CandidateMaster> getAllActiveCandidates();

    List<CandidateMaster> getAllInActiveCandidates();

    boolean deleteCandidate(Integer candidateId);

// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CitizenMaster methods">
    boolean addCitizen(LoginMaster lm, CitizenMaster cm, Integer zoneId, Integer wardId, Integer subwardId, Integer areaId);

    boolean updateCitizen(LoginMaster lm, CitizenMaster cm, Integer zoneId, Integer wardId, Integer subwardId, Integer areaId);

    CitizenMaster getCitizenMaster(Integer citizenId);

    List<CitizenMaster> getAllCitizens();

    LoginMaster getLoginMaster(Integer userId);

    LoginMaster getLoginMaster(String username);

    boolean deleteCitizen(Integer citizenId);
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ZoneMaster methods">
    boolean addZone(ZoneMaster zone, Integer cityMasterId);

    boolean updateZone(ZoneMaster zone, Integer newCityMasterId);

    boolean deleteZone(Integer zoneId);

    ZoneMaster getZone(Integer zoneId);

    List<ZoneMaster> getAllZones();

    List<WardMaster> getWardsOfZone(Integer zoneId);

    List<CitizenMaster> getCitizensOfZone(Integer zoneId);

    List<CandidateMaster> getCandidatesOfZone(Integer zoneId);
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="WardMaster methods">
    boolean addWard(WardMaster ward, Integer zoneId);

    boolean updateWard(WardMaster ward, Integer newZoneId);

    boolean deleteWard(Integer wardId);

    WardMaster getWard(Integer wardId);

    List<WardMaster> getAllWards();

    List<SubWardMaster> getSubWardsOfWard(Integer wardId);

    List<CitizenMaster> getCitizensOfWard(Integer wardId);

    List<CandidateMaster> getCandidatesOfWard(Integer wardId);
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="SubWardMaster methods">
    boolean addSubWard(SubWardMaster subward, Integer wardId);

    boolean updateSubWard(SubWardMaster subward, Integer newWardId);

    boolean deleteSubWard(Integer subwardId);

    SubWardMaster getSubWard(Integer subwardId);

    List<SubWardMaster> getAllSubwards();

    List<AreaMaster> getAreaOfSubward(Integer subwardId);

    List<CitizenMaster> getCitizensOfSubward(Integer subwardId);

    List<CandidateMaster> getCandidatesOfSubward(Integer subwardId);

// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="AreaMaster methods">
    boolean addArea(AreaMaster area, Integer subwardId);

    boolean updateArea(AreaMaster area, Integer newSubwardId);

    boolean deleteArea(Integer areaId);

    AreaMaster getArea(Integer areaId);

    List<AreaMaster> getAllAreas();

    List<CitizenMaster> getCitizensOfArea(Integer areaId);

    List<CandidateMaster> getCandidatesOfArea(Integer areaId);
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PartyMaster methods">
    boolean addParty(PartyMaster pm);

    boolean checkForExistingParty(PartyMaster pm);

    PartyMaster getParty(Integer partyID);

    List<CandidateMaster> getActiveCandidatesOfParty(Integer partyID);

    boolean updateParty(PartyMaster pm);

    boolean deleteParty(Integer partyID);

    List<PartyMaster> getAllParties();
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CityMaster methods">
    boolean addCity(CityMaster cm);

    List<CityMaster> getAllCities();

    CityMaster getCity(Integer cityMasterId);

    List<ZoneMaster> getZonesOfCity(Integer cityId);
// </editor-fold>
}

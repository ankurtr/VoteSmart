/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ejb.CoreBeanRemote;
import ejb.ElectionSchedulerRemote;
import ejb.ResultBeanRemote;
import ejb.SearcherBeanRemote;
import ejb.SecurityBeanRemote;
import ejb.VoteBeanRemote;
import entities.AreaMaster;
import entities.CandidateMaster;
import entities.CitizenMaster;
import entities.CityMaster;
import entities.ElectionMaster;
import entities.ElectionTypeMaster;
import entities.GroupMaster;
import entities.LoginMaster;
import entities.PartyMaster;
import entities.SecurityMaster;
import entities.SubWardMaster;
import entities.WardMaster;
import entities.ZoneMaster;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import misc.XmlHashMapII;
import misc.XmlHashMapIL;

/**
 *
 * @author lenovo
 */
@WebService()
@Stateless
public class EPollWebService {

    @EJB
    private CoreBeanRemote coreBean;
    @EJB
    private ElectionSchedulerRemote electionScheduler;
    @EJB
    private SecurityBeanRemote securityBean;
    @EJB
    private VoteBeanRemote voteBean;
    @EJB
    private ResultBeanRemote resultBean;
    @EJB
    private SearcherBeanRemote searcherBean;

    /**
     * Web service operation
     */
    // <editor-fold defaultstate="collapsed" desc="candidate">    
    @WebMethod(operationName = "addCandidate")
    public boolean addCandidate(@WebParam(name = "cm") CandidateMaster cm, @WebParam(name = "zoneId") Integer zoneId, @WebParam(name = "wardId") Integer wardId, @WebParam(name = "subwardId") Integer subwardId, @WebParam(name = "areaId") Integer areaId, @WebParam(name = "partyId") Integer partyId) {
        return coreBean.addCandidate(cm, zoneId, wardId, subwardId, areaId, partyId);
    }

    @WebMethod(operationName = "checkForExistingCandidate")
    public boolean checkForExistingCandidate(@WebParam(name = "cm") CandidateMaster cm) {
        return coreBean.checkForExistingCandidate(cm);
    }

    @WebMethod(operationName = "updateCandidate")
    public boolean updateCandidate(@WebParam(name = "cm") CandidateMaster cm, @WebParam(name = "zoneId") Integer zoneId, @WebParam(name = "wardId") Integer wardId, @WebParam(name = "subwardId") Integer subwardId, @WebParam(name = "areaId") Integer areaId, @WebParam(name = "partyId") Integer partyId) {
        return coreBean.updateCandidate(cm, zoneId, wardId, subwardId, areaId, partyId);
    }

    @WebMethod(operationName = "getCandidate")
    public CandidateMaster getCandidate(@WebParam(name = "candidateID") Integer candidateID) {
        return coreBean.getCandidate(candidateID);
    }

    @WebMethod(operationName = "getAllCandidates")
    public List<CandidateMaster> getAllCandidates() {
        return coreBean.getAllCandidates();
    }

    @WebMethod(operationName = "deleteCandidate")
    public boolean deleteCandidate(@WebParam(name = "candidateId") Integer candidateId) {
        return coreBean.deleteCandidate(candidateId);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllActiveCandidates")
    public List<CandidateMaster> getAllActiveCandidates() {
        return coreBean.getAllActiveCandidates();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllInActiveCandidates")
    public List<CandidateMaster> getAllInActiveCandidates() {
        //TODO write your implementation code here:
        return coreBean.getAllInActiveCandidates();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="citizen">
    @WebMethod(operationName = "addCitizen")
    public boolean addCitizen(@WebParam(name = "lm") LoginMaster lm, @WebParam(name = "cm") CitizenMaster cm, @WebParam(name = "zoneId") Integer zoneId, @WebParam(name = "wardId") Integer wardId, @WebParam(name = "subwardId") Integer subwardId, @WebParam(name = "areaId") Integer areaId) {
        return coreBean.addCitizen(lm, cm, zoneId, wardId, subwardId, areaId);
    }

    @WebMethod(operationName = "updateCitizen")
    public boolean updateCitizen(@WebParam(name = "lm") LoginMaster lm, @WebParam(name = "cm") CitizenMaster cm, @WebParam(name = "zoneId") Integer zoneId, @WebParam(name = "wardId") Integer wardId, @WebParam(name = "subwardId") Integer subwardId, @WebParam(name = "areaId") Integer areaId) {
        return coreBean.updateCitizen(lm, cm, zoneId, wardId, subwardId, areaId);
    }

    @WebMethod(operationName = "getCitizenMaster")
    public CitizenMaster getCitizenMaster(@WebParam(name = "citizenId") Integer citizenId) {
        return coreBean.getCitizenMaster(citizenId);
    }

    @WebMethod(operationName = "getAllCitizens")
    public List<CitizenMaster> getAllCitizens() {
        return coreBean.getAllCitizens();
    }

    @WebMethod(operationName = "getLoginMaster")
    public LoginMaster getLoginMaster(@WebParam(name = "userId") Integer userId) {
        return coreBean.getLoginMaster(userId);
    }

    @WebMethod(operationName = "deleteCitizen")
    public boolean deleteCitizen(@WebParam(name = "citizenId") Integer citizenId) {
        return coreBean.deleteCitizen(citizenId);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="zone">
    @WebMethod(operationName = "addZone")
    public boolean addZone(@WebParam(name = "zone") ZoneMaster zone, @WebParam(name = "cityMasterId") Integer cityMasterId) {
        return coreBean.addZone(zone, cityMasterId);
    }

    @WebMethod(operationName = "updateZone")
    public boolean updateZone(@WebParam(name = "zone") ZoneMaster zone, @WebParam(name = "newCityMasterId") Integer newCityMasterId) {
        return coreBean.updateZone(zone, newCityMasterId);
    }

    @WebMethod(operationName = "deleteZone")
    public boolean deleteZone(@WebParam(name = "zoneId") Integer zoneId) {
        return coreBean.deleteZone(zoneId);
    }

    @WebMethod(operationName = "getZone")
    public ZoneMaster getZone(@WebParam(name = "zoneId") Integer zoneId) {
        return coreBean.getZone(zoneId);
    }

    @WebMethod(operationName = "getAllZones")
    public List<ZoneMaster> getAllZones() {
        return coreBean.getAllZones();
    }

    @WebMethod(operationName = "getWardsOfZone")
    public List<WardMaster> getWardsOfZone(@WebParam(name = "zoneId") Integer zoneId) {
        return coreBean.getWardsOfZone(zoneId);
    }

    @WebMethod(operationName = "getCitizensOfZone")
    public List<CitizenMaster> getCitizensOfZone(@WebParam(name = "zoneId") Integer zoneId) {
        return coreBean.getCitizensOfZone(zoneId);
    }

    @WebMethod(operationName = "getCandidatesOfZone")
    public List<CandidateMaster> getCandidatesOfZone(@WebParam(name = "zoneId") Integer zoneId) {
        return coreBean.getCandidatesOfZone(zoneId);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ward">
    @WebMethod(operationName = "addWard")
    public boolean addWard(@WebParam(name = "ward") WardMaster ward, @WebParam(name = "zoneId") Integer zoneId) {
        return coreBean.addWard(ward, zoneId);
    }

    @WebMethod(operationName = "updateWard")
    public boolean updateWard(@WebParam(name = "ward") WardMaster ward, @WebParam(name = "newZoneId") Integer newZoneId) {
        return coreBean.updateWard(ward, newZoneId);
    }

    @WebMethod(operationName = "deleteWard")
    public boolean deleteWard(@WebParam(name = "wardId") Integer wardId) {
        return coreBean.deleteWard(wardId);
    }

    @WebMethod(operationName = "getWard")
    public WardMaster getWard(@WebParam(name = "wardId") Integer wardId) {
        return coreBean.getWard(wardId);
    }

    @WebMethod(operationName = "getAllWards")
    public List<WardMaster> getAllWards() {
        return coreBean.getAllWards();
    }

    @WebMethod(operationName = "getSubWardsOfWard")
    public List<SubWardMaster> getSubWardsOfWard(@WebParam(name = "wardId") Integer wardId) {
        return coreBean.getSubWardsOfWard(wardId);
    }

    @WebMethod(operationName = "getCitizensOfWard")
    public List<CitizenMaster> getCitizensOfWard(@WebParam(name = "wardId") Integer wardId) {
        return coreBean.getCitizensOfWard(wardId);
    }

    @WebMethod(operationName = "getCandidatesOfWard")
    public List<CandidateMaster> getCandidatesOfWard(@WebParam(name = "wardId") Integer wardId) {
        return coreBean.getCandidatesOfWard(wardId);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="subward">
    @WebMethod(operationName = "addSubWard")
    public boolean addSubWard(@WebParam(name = "subward") SubWardMaster subward, @WebParam(name = "wardId") Integer wardId) {
        return coreBean.addSubWard(subward, wardId);
    }

    @WebMethod(operationName = "updateSubWard")
    public boolean updateSubWard(@WebParam(name = "subward") SubWardMaster subward, @WebParam(name = "newWardId") Integer newWardId) {
        return coreBean.updateSubWard(subward, newWardId);
    }

    @WebMethod(operationName = "deleteSubWard")
    public boolean deleteSubWard(@WebParam(name = "subwardId") Integer subwardId) {
        return coreBean.deleteSubWard(subwardId);
    }

    @WebMethod(operationName = "getSubWard")
    public SubWardMaster getSubWard(@WebParam(name = "subwardId") Integer subwardId) {
        return coreBean.getSubWard(subwardId);
    }

    @WebMethod(operationName = "getAllSubwards")
    public List<SubWardMaster> getAllSubwards() {
        return coreBean.getAllSubwards();
    }

    @WebMethod(operationName = "getAreaOfSubward")
    public List<AreaMaster> getAreaOfSubward(@WebParam(name = "subwardId") Integer subwardId) {
        return coreBean.getAreaOfSubward(subwardId);
    }

    @WebMethod(operationName = "getCitizensOfSubward")
    public List<CitizenMaster> getCitizensOfSubward(@WebParam(name = "subwardId") Integer subwardId) {
        return coreBean.getCitizensOfSubward(subwardId);
    }

    @WebMethod(operationName = "getCandidatesOfSubward")
    public List<CandidateMaster> getCandidatesOfSubward(@WebParam(name = "subwardId") Integer subwardId) {
        return coreBean.getCandidatesOfSubward(subwardId);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="area">
    @WebMethod(operationName = "addArea")
    public boolean addArea(@WebParam(name = "area") AreaMaster area, @WebParam(name = "subwardId") Integer subwardId) {
        return coreBean.addArea(area, subwardId);
    }

    @WebMethod(operationName = "updateArea")
    public boolean updateArea(@WebParam(name = "area") AreaMaster area, @WebParam(name = "newSubwardId") Integer newSubwardId) {
        return coreBean.updateArea(area, newSubwardId);
    }

    @WebMethod(operationName = "deleteArea")
    public boolean deleteArea(@WebParam(name = "areaId") Integer areaId) {
        return coreBean.deleteArea(areaId);
    }

    @WebMethod(operationName = "getArea")
    public AreaMaster getArea(@WebParam(name = "areaId") Integer areaId) {
        return coreBean.getArea(areaId);
    }

    @WebMethod(operationName = "getAllAreas")
    public List<AreaMaster> getAllAreas() {
        return coreBean.getAllAreas();
    }

    @WebMethod(operationName = "getCitizensOfArea")
    public List<CitizenMaster> getCitizensOfArea(@WebParam(name = "areaId") Integer areaId) {
        return coreBean.getCitizensOfArea(areaId);
    }

    @WebMethod(operationName = "getCandidatesOfArea")
    public List<CandidateMaster> getCandidatesOfArea(@WebParam(name = "areaId") Integer areaId) {
        return coreBean.getCandidatesOfArea(areaId);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="party">
    @WebMethod(operationName = "addParty")
    public boolean addParty(@WebParam(name = "pm") PartyMaster pm) {
        return coreBean.addParty(pm);
    }

    @WebMethod(operationName = "checkForExistingParty")
    public boolean checkForExistingParty(@WebParam(name = "pm") PartyMaster pm) {
        return coreBean.checkForExistingParty(pm);
    }

    @WebMethod(operationName = "getParty")
    public PartyMaster getParty(@WebParam(name = "partyID") Integer partyID) {
        return coreBean.getParty(partyID);
    }

    @WebMethod(operationName = "getActiveCandidatesOfParty")
    public List<CandidateMaster> getActiveCandidatesOfParty(@WebParam(name = "partyID") Integer partyID) {
        return coreBean.getActiveCandidatesOfParty(partyID);
    }

    @WebMethod(operationName = "updateParty")
    public boolean updateParty(@WebParam(name = "pm") PartyMaster pm) {
        return coreBean.updateParty(pm);
    }

    @WebMethod(operationName = "deleteParty")
    public boolean deleteParty(@WebParam(name = "partyID") Integer partyID) {
        return coreBean.deleteParty(partyID);
    }

    @WebMethod(operationName = "getAllParties")
    public List<PartyMaster> getAllParties() {
        return coreBean.getAllParties();
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="city">
    @WebMethod(operationName = "addCity")
    public boolean addCity(@WebParam(name = "cm") CityMaster cm) {
        return coreBean.addCity(cm);
    }

    @WebMethod(operationName = "getAllCities")
    public List<CityMaster> getAllCities() {
        return coreBean.getAllCities();
    }

    @WebMethod(operationName = "getCity")
    public CityMaster getCity(@WebParam(name = "cityMasterId") Integer cityMasterId) {
        return coreBean.getCity(cityMasterId);
    }

    @WebMethod(operationName = "getZonesOfCity")
    public List<ZoneMaster> getZonesOfCity(@WebParam(name = "cityId") Integer cityId) {
        return coreBean.getZonesOfCity(cityId);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="election">
    @WebMethod(operationName = "addElection")
    public boolean addElection(@WebParam(name = "elm") ElectionMaster elm, @WebParam(name = "electionTypeId") Integer electionTypeId, @WebParam(name = "candidateIds") List<Integer> candidateIds) {
        return electionScheduler.addElection(elm, electionTypeId, candidateIds);
    }

    @WebMethod(operationName = "scheduleElection")
    public boolean scheduleElection(@WebParam(name = "electionID") Integer electionID) {
        return electionScheduler.scheduleElection(electionID);
    }

    @WebMethod(operationName = "cancelElection")
    public boolean cancelElection(@WebParam(name = "electionID") Integer electionID) {
        return electionScheduler.cancelElection(electionID);
    }

    @WebMethod(operationName = "updateElection")
    public boolean updateElection(@WebParam(name = "elm") ElectionMaster elm, @WebParam(name = "electionTypeId") Integer electionTypeId, @WebParam(name = "candidateIds") List<Integer> candidateIds) {
        return electionScheduler.updateElection(elm, electionTypeId, candidateIds);
    }

    @WebMethod(operationName = "getAllElections")
    public List<ElectionMaster> getAllElections() {
        return electionScheduler.getAllElections();
    }

    @WebMethod(operationName = "getScheduledElections")
    public List<ElectionMaster> getScheduledElections() {
        return electionScheduler.getScheduledElections();
    }

    @WebMethod(operationName = "getElection")
    public ElectionMaster getElection(@WebParam(name = "electionId") Integer electionId) {
        return electionScheduler.getElection(electionId);
    }

    @WebMethod(operationName = "getAllElectionTypes")
    public List<ElectionTypeMaster> getAllElectionTypes() {
        return electionScheduler.getAllElectionTypes();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPastElections")
    public List<ElectionMaster> getPastElections() {
        return electionScheduler.getPastElections();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getFutureElections")
    public List<ElectionMaster> getFutureElections() {
        return electionScheduler.getFutureElections();
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="security and users">
    @WebMethod(operationName = "getLoginMasterFromUsername")
    public LoginMaster getLoginMasterFromUsername(@WebParam(name = "username") String username) {
        return coreBean.getLoginMaster(username);
    }

    @WebMethod(operationName = "addSecurity")
    public boolean addSecurity(@WebParam(name = "sm") SecurityMaster sm) {
        return securityBean.addSecurity(sm);
    }

    @WebMethod(operationName = "activateSecurity")
    public boolean activateSecurity(@WebParam(name = "securityId") Integer securityId) {
        return securityBean.activateSecurity(securityId);
    }

    @WebMethod(operationName = "deactivateSecurity")
    public boolean deactivateSecurity(@WebParam(name = "securityId") Integer securityId) {
        return securityBean.deactivateSecurity(securityId);
    }

    @WebMethod(operationName = "addGroup")
    public boolean addGroup(@WebParam(name = "gm") GroupMaster gm) {
        return securityBean.addGroup(gm);
    }

    @WebMethod(operationName = "getActiveSecurity")
    public SecurityMaster getActiveSecurity() {
        //TODO write your implementation code here:
        return securityBean.getActiveSecurity();
    }

    @WebMethod(operationName = "getAllSecurity")
    public List<SecurityMaster> getAllSecurity() {
        return securityBean.getAllSecurity();
    }

    @WebMethod(operationName = "getSecurity")
    public SecurityMaster getSecurity(@WebParam(name = "securityId") Integer securityId) {
        //TODO write your implementation code here:
        return securityBean.getSecurity(securityId);
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Voting">
    @WebMethod(operationName = "castVote")
    public boolean castVote(@WebParam(name = "citizenId") Integer citizenId, @WebParam(name = "candidateIds") List<Integer> candidateIds) {
        return voteBean.castVote(citizenId, candidateIds);
    }

    @WebMethod(operationName = "isValidToVote")
    public boolean isValidToVote(@WebParam(name = "citizenId") Integer citizenId) {
        return voteBean.isValidToVote(citizenId);
    }

    @WebMethod(operationName = "getActiveCandidatesWithPartyId")
    public XmlHashMapII getActiveCandidatesWithPartyId(@WebParam(name = "wardId") Integer wardId) {
        return voteBean.getActiveCandidatesWithPartyId(wardId);
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Result">
    @WebMethod(operationName = "getVoteCountForCandidate")
    public Long getVoteCountForCandidate(@WebParam(name = "candidateId") Integer candidateId, @WebParam(name = "electionId") Integer electionId) {
        return resultBean.getVoteCountForCandidate(candidateId, electionId);
    }

    @WebMethod(operationName = "getVoteCountsForElection")
    public Long getVoteCountsForElection(@WebParam(name = "electionId") Integer electionId) {
        return resultBean.getVoteCountsForElection(electionId);
    }

    @WebMethod(operationName = "getVoteCountForZone")
    public Long getVoteCountForZone(@WebParam(name = "zoneId") Integer zoneId, @WebParam(name = "electionId") Integer electionId) {
        return resultBean.getVoteCountForZone(zoneId, electionId);
    }

    @WebMethod(operationName = "getVoteCountForWard")
    public Long getVoteCountForWard(@WebParam(name = "wardId") Integer wardId, @WebParam(name = "electionId") Integer electionId) {
        return resultBean.getVoteCountForWard(wardId, electionId);
    }

    @WebMethod(operationName = "getVoteCountForSubward")
    public Long getVoteCountForSubward(@WebParam(name = "subwardId") Integer subwardId, @WebParam(name = "electionId") Integer electionId) {
        return resultBean.getVoteCountForSubward(subwardId, electionId);
    }

    @WebMethod(operationName = "getVoteCountForArea")
    public Long getVoteCountForArea(@WebParam(name = "areaId") Integer areaId, @WebParam(name = "electionId") Integer electionId) {
        return resultBean.getVoteCountForArea(areaId, electionId);
    }

    @WebMethod(operationName = "getVoteCountForParty")
    public Long getVoteCountForParty(@WebParam(name = "partyId") Integer partyId, @WebParam(name = "electionId") Integer electionId) {
        return resultBean.getVoteCountForParty(partyId, electionId);
    }

    @WebMethod(operationName = "getCandidateWiseVoteCountsForElection")
    public XmlHashMapIL getCandidateWiseVoteCountsForElection(@WebParam(name = "electionId") Integer electionId) {
        //TODO write your implementation code here:
        return resultBean.getCandidateWiseVoteCountsForElection(electionId);
    }

    @WebMethod(operationName = "getCandidateWiseVoteCountsForWard")
    public XmlHashMapIL getCandidateWiseVoteCountsForWard(@WebParam(name = "electionId") Integer electionId, @WebParam(name = "wardId") Integer wardId) {
        //TODO write your implementation code here:
        return resultBean.getCandidateWiseVoteCountsForWard(electionId, wardId);
    }

    @WebMethod(operationName = "getWardWiseVoteCountsForZone")
    public XmlHashMapIL getWardWiseVoteCountsForZone(@WebParam(name = "electionId") Integer electionId, @WebParam(name = "zoneId") Integer zoneId) {
        //TODO write your implementation code here:
        return resultBean.getWardWiseVoteCountsForZone(electionId, zoneId);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Searching">
    @WebMethod(operationName = "searchWardByName")
    public List<WardMaster> searchWardByName(@WebParam(name = "wardName") String wardName, @WebParam(name = "maxResults") Integer maxResults) {
        return searcherBean.searchWardByName(wardName, maxResults);
    }

    @WebMethod(operationName = "searchByZoneName")
    public List<ZoneMaster> searchByZoneName(@WebParam(name = "zoneName") String zoneName, @WebParam(name = "maxResults") Integer maxResults) {
        return searcherBean.searchByZoneName(zoneName, maxResults);
    }

    @WebMethod(operationName = "searchBySubWardName")
    public List<SubWardMaster> searchBySubWardName(@WebParam(name = "subwardName") String subwardName, @WebParam(name = "maxResults") Integer maxResults) {
        return searcherBean.searchBySubWardName(subwardName, maxResults);
    }

    @WebMethod(operationName = "searchByAreaName")
    public List<AreaMaster> searchByAreaName(@WebParam(name = "areaName") String areaName, @WebParam(name = "maxResults") Integer maxResults) {
        return searcherBean.searchByAreaName(areaName, maxResults);
    }

    @WebMethod(operationName = "searchCandidateByFirstName")
    public List<CandidateMaster> searchCandidateByFirstName(@WebParam(name = "firstName") String firstName, @WebParam(name = "maxResults") Integer maxResults) {
        return searcherBean.searchCandidateByFirstName(firstName, maxResults);
    }

    @WebMethod(operationName = "searchCandidateByLastName")
    public List<CandidateMaster> searchCandidateByLastName(@WebParam(name = "lastName") String lastName, @WebParam(name = "maxResults") Integer maxResults) {
        return searcherBean.searchCandidateByLastName(lastName, maxResults);
    }

    @WebMethod(operationName = "searchCandidateByDateOfBirthRange")
    public List<CandidateMaster> searchCandidateByDateOfBirthRange(@WebParam(name = "fromDate") Date fromDate, @WebParam(name = "toDate") Date toDate, @WebParam(name = "maxResults") Integer maxResults) {
        return searcherBean.searchCandidateByDateOfBirthRange(fromDate, toDate, maxResults);
    }

    @WebMethod(operationName = "searchCandidateByActiveStatus")
    public List<CandidateMaster> searchCandidateByActiveStatus(@WebParam(name = "isActive") boolean isActive, @WebParam(name = "maxResults") Integer maxResults) {
        return searcherBean.searchCandidateByActiveStatus(isActive, maxResults);
    }

    @WebMethod(operationName = "searchCitizenById")
    public List<CitizenMaster> searchCitizenById(@WebParam(name = "citizenId") Integer citizenId) {
        return searcherBean.searchCitizenById(citizenId);
    }

    @WebMethod(operationName = "searchElectionByName")
    public List<ElectionMaster> searchElectionByName(@WebParam(name = "electionName") String electionName, @WebParam(name = "maxResults") Integer maxResults) {
        return searcherBean.searchElectionByName(electionName, maxResults);
    }

    @WebMethod(operationName = "searchElectionByFinalDate")
    public ElectionMaster searchElectionByFinalDate(@WebParam(name = "date") Date date, @WebParam(name = "maxResults") Integer maxResults) {
        return searcherBean.searchElectionByFinalDate(date, maxResults);
    }

    @WebMethod(operationName = "searchElectionByDateRange")
    public List<ElectionMaster> searchElectionByDateRange(@WebParam(name = "fromDate") Date fromDate, @WebParam(name = "toDate") Date toDate, @WebParam(name = "maxResults") Integer maxResults) {
        return searcherBean.searchElectionByDateRange(fromDate, toDate, maxResults);
    }

    @WebMethod(operationName = "searchElectionByElectionType")
    public List<ElectionMaster> searchElectionByElectionType(@WebParam(name = "electionTypeId") Integer electionTypeId, @WebParam(name = "maxResults") Integer maxResults) {
        return searcherBean.searchElectionByElectionType(electionTypeId, maxResults);
    }

    @WebMethod(operationName = "searchCitizenByUsername")
    public List<CitizenMaster> searchCitizenByUsername(@WebParam(name = "username") String username, @WebParam(name = "maxResults") Integer maxResults) {
        return searcherBean.searchCitizenByUsername(username, maxResults);
    }

    @WebMethod(operationName = "searchPartyByPartyName")
    public List<PartyMaster> searchPartyByPartyName(@WebParam(name = "partyName") String partyName, @WebParam(name = "maxResults") Integer maxResults) {
        return searcherBean.searchPartyByPartyName(partyName, maxResults);
    }

    @WebMethod(operationName = "searchCitizenByName")
    public List<CitizenMaster> searchCitizenByName(@WebParam(name = "citizenName") String citizenName, @WebParam(name = "maxResults") Integer maxResults) {
        //TODO write your implementation code here:
        return searcherBean.searchCitizenByName(citizenName, maxResults);
    }
    // </editor-fold>

    @WebMethod(operationName = "sayHello")
    @Oneway
    public void sayHello(@WebParam(name = "message") String message) {
        voteBean.sayHello(message);
    }
    /**
     * Web service operation
     */
}

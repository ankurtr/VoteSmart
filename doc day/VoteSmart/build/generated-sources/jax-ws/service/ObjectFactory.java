
package service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _IsValidToVote_QNAME = new QName("http://service/", "isValidToVote");
    private final static QName _GetAllAreas_QNAME = new QName("http://service/", "getAllAreas");
    private final static QName _DeleteArea_QNAME = new QName("http://service/", "deleteArea");
    private final static QName _SearchCandidateByActiveStatus_QNAME = new QName("http://service/", "searchCandidateByActiveStatus");
    private final static QName _SearchCandidateByFirstNameResponse_QNAME = new QName("http://service/", "searchCandidateByFirstNameResponse");
    private final static QName _GetCandidatesOfZone_QNAME = new QName("http://service/", "getCandidatesOfZone");
    private final static QName _GetActiveCandidatesOfPartyResponse_QNAME = new QName("http://service/", "getActiveCandidatesOfPartyResponse");
    private final static QName _GetPastElections_QNAME = new QName("http://service/", "getPastElections");
    private final static QName _SearchCitizenByName_QNAME = new QName("http://service/", "searchCitizenByName");
    private final static QName _AddCitizen_QNAME = new QName("http://service/", "addCitizen");
    private final static QName _SearchElectionByDateRangeResponse_QNAME = new QName("http://service/", "searchElectionByDateRangeResponse");
    private final static QName _UpdateCandidateResponse_QNAME = new QName("http://service/", "updateCandidateResponse");
    private final static QName _DeleteWard_QNAME = new QName("http://service/", "deleteWard");
    private final static QName _SearchCitizenById_QNAME = new QName("http://service/", "searchCitizenById");
    private final static QName _AddParty_QNAME = new QName("http://service/", "addParty");
    private final static QName _AddAreaResponse_QNAME = new QName("http://service/", "addAreaResponse");
    private final static QName _GetCandidatesOfWardResponse_QNAME = new QName("http://service/", "getCandidatesOfWardResponse");
    private final static QName _AddArea_QNAME = new QName("http://service/", "addArea");
    private final static QName _SearchPartyByPartyNameResponse_QNAME = new QName("http://service/", "searchPartyByPartyNameResponse");
    private final static QName _GetArea_QNAME = new QName("http://service/", "getArea");
    private final static QName _DeleteZone_QNAME = new QName("http://service/", "deleteZone");
    private final static QName _AddGroupResponse_QNAME = new QName("http://service/", "addGroupResponse");
    private final static QName _AddElectionResponse_QNAME = new QName("http://service/", "addElectionResponse");
    private final static QName _SearchWardByNameResponse_QNAME = new QName("http://service/", "searchWardByNameResponse");
    private final static QName _DeleteSubWardResponse_QNAME = new QName("http://service/", "deleteSubWardResponse");
    private final static QName _GetAllSecurity_QNAME = new QName("http://service/", "getAllSecurity");
    private final static QName _SearchElectionByElectionType_QNAME = new QName("http://service/", "searchElectionByElectionType");
    private final static QName _SearchElectionByName_QNAME = new QName("http://service/", "searchElectionByName");
    private final static QName _GetAllZonesResponse_QNAME = new QName("http://service/", "getAllZonesResponse");
    private final static QName _GetPastElectionsResponse_QNAME = new QName("http://service/", "getPastElectionsResponse");
    private final static QName _SearchCitizenByUsername_QNAME = new QName("http://service/", "searchCitizenByUsername");
    private final static QName _DeleteCitizen_QNAME = new QName("http://service/", "deleteCitizen");
    private final static QName _GetAllWards_QNAME = new QName("http://service/", "getAllWards");
    private final static QName _AddZoneResponse_QNAME = new QName("http://service/", "addZoneResponse");
    private final static QName _GetActiveSecurity_QNAME = new QName("http://service/", "getActiveSecurity");
    private final static QName _AddZone_QNAME = new QName("http://service/", "addZone");
    private final static QName _GetAllCitizensResponse_QNAME = new QName("http://service/", "getAllCitizensResponse");
    private final static QName _GetWardWiseVoteCountsForZone_QNAME = new QName("http://service/", "getWardWiseVoteCountsForZone");
    private final static QName _SearchElectionByFinalDateResponse_QNAME = new QName("http://service/", "searchElectionByFinalDateResponse");
    private final static QName _GetAllSubwards_QNAME = new QName("http://service/", "getAllSubwards");
    private final static QName _SearchCandidateByDateOfBirthRangeResponse_QNAME = new QName("http://service/", "searchCandidateByDateOfBirthRangeResponse");
    private final static QName _GetSubWard_QNAME = new QName("http://service/", "getSubWard");
    private final static QName _AddCityResponse_QNAME = new QName("http://service/", "addCityResponse");
    private final static QName _GetCitizensOfZone_QNAME = new QName("http://service/", "getCitizensOfZone");
    private final static QName _GetWardsOfZone_QNAME = new QName("http://service/", "getWardsOfZone");
    private final static QName _AddPartyResponse_QNAME = new QName("http://service/", "addPartyResponse");
    private final static QName _AddElection_QNAME = new QName("http://service/", "addElection");
    private final static QName _GetCitizensOfSubward_QNAME = new QName("http://service/", "getCitizensOfSubward");
    private final static QName _GetLoginMasterFromUsernameResponse_QNAME = new QName("http://service/", "getLoginMasterFromUsernameResponse");
    private final static QName _GetVoteCountForArea_QNAME = new QName("http://service/", "getVoteCountForArea");
    private final static QName _GetAllZones_QNAME = new QName("http://service/", "getAllZones");
    private final static QName _AddCity_QNAME = new QName("http://service/", "addCity");
    private final static QName _GetElection_QNAME = new QName("http://service/", "getElection");
    private final static QName _DeleteCandidateResponse_QNAME = new QName("http://service/", "deleteCandidateResponse");
    private final static QName _GetCandidateWiseVoteCountsForWard_QNAME = new QName("http://service/", "getCandidateWiseVoteCountsForWard");
    private final static QName _GetCityResponse_QNAME = new QName("http://service/", "getCityResponse");
    private final static QName _DeleteCandidate_QNAME = new QName("http://service/", "deleteCandidate");
    private final static QName _AddCitizenResponse_QNAME = new QName("http://service/", "addCitizenResponse");
    private final static QName _GetCitizensOfWard_QNAME = new QName("http://service/", "getCitizensOfWard");
    private final static QName _GetActiveCandidatesOfParty_QNAME = new QName("http://service/", "getActiveCandidatesOfParty");
    private final static QName _GetVoteCountForSubward_QNAME = new QName("http://service/", "getVoteCountForSubward");
    private final static QName _SearchCitizenByNameResponse_QNAME = new QName("http://service/", "searchCitizenByNameResponse");
    private final static QName _SearchCandidateByActiveStatusResponse_QNAME = new QName("http://service/", "searchCandidateByActiveStatusResponse");
    private final static QName _GetCitizensOfSubwardResponse_QNAME = new QName("http://service/", "getCitizensOfSubwardResponse");
    private final static QName _SearchCandidateByFirstName_QNAME = new QName("http://service/", "searchCandidateByFirstName");
    private final static QName _SearchCandidateByLastNameResponse_QNAME = new QName("http://service/", "searchCandidateByLastNameResponse");
    private final static QName _GetZone_QNAME = new QName("http://service/", "getZone");
    private final static QName _GetCitizenMaster_QNAME = new QName("http://service/", "getCitizenMaster");
    private final static QName _ScheduleElection_QNAME = new QName("http://service/", "scheduleElection");
    private final static QName _SearchElectionByDateRange_QNAME = new QName("http://service/", "searchElectionByDateRange");
    private final static QName _GetVoteCountsForElectionResponse_QNAME = new QName("http://service/", "getVoteCountsForElectionResponse");
    private final static QName _SayHello_QNAME = new QName("http://service/", "sayHello");
    private final static QName _GetAreaOfSubward_QNAME = new QName("http://service/", "getAreaOfSubward");
    private final static QName _GetCandidateWiseVoteCountsForWardResponse_QNAME = new QName("http://service/", "getCandidateWiseVoteCountsForWardResponse");
    private final static QName _UpdateSubWardResponse_QNAME = new QName("http://service/", "updateSubWardResponse");
    private final static QName _AddCandidateResponse_QNAME = new QName("http://service/", "addCandidateResponse");
    private final static QName _GetAllElectionsResponse_QNAME = new QName("http://service/", "getAllElectionsResponse");
    private final static QName _GetVoteCountForParty_QNAME = new QName("http://service/", "getVoteCountForParty");
    private final static QName _UpdateWard_QNAME = new QName("http://service/", "updateWard");
    private final static QName _CheckForExistingCandidate_QNAME = new QName("http://service/", "checkForExistingCandidate");
    private final static QName _GetAllElectionTypesResponse_QNAME = new QName("http://service/", "getAllElectionTypesResponse");
    private final static QName _UpdateParty_QNAME = new QName("http://service/", "updateParty");
    private final static QName _UpdateCandidate_QNAME = new QName("http://service/", "updateCandidate");
    private final static QName _GetAllPartiesResponse_QNAME = new QName("http://service/", "getAllPartiesResponse");
    private final static QName _GetCandidatesOfWard_QNAME = new QName("http://service/", "getCandidatesOfWard");
    private final static QName _GetCitizensOfWardResponse_QNAME = new QName("http://service/", "getCitizensOfWardResponse");
    private final static QName _GetActiveCandidatesWithPartyIdResponse_QNAME = new QName("http://service/", "getActiveCandidatesWithPartyIdResponse");
    private final static QName _CheckForExistingCandidateResponse_QNAME = new QName("http://service/", "checkForExistingCandidateResponse");
    private final static QName _GetElectionResponse_QNAME = new QName("http://service/", "getElectionResponse");
    private final static QName _CastVoteResponse_QNAME = new QName("http://service/", "castVoteResponse");
    private final static QName _CastVote_QNAME = new QName("http://service/", "castVote");
    private final static QName _GetCandidate_QNAME = new QName("http://service/", "getCandidate");
    private final static QName _GetAllCitizens_QNAME = new QName("http://service/", "getAllCitizens");
    private final static QName _GetSubWardsOfWardResponse_QNAME = new QName("http://service/", "getSubWardsOfWardResponse");
    private final static QName _GetSubWardResponse_QNAME = new QName("http://service/", "getSubWardResponse");
    private final static QName _CheckForExistingParty_QNAME = new QName("http://service/", "checkForExistingParty");
    private final static QName _SearchByAreaName_QNAME = new QName("http://service/", "searchByAreaName");
    private final static QName _GetAllActiveCandidatesResponse_QNAME = new QName("http://service/", "getAllActiveCandidatesResponse");
    private final static QName _GetAllCities_QNAME = new QName("http://service/", "getAllCities");
    private final static QName _DeleteZoneResponse_QNAME = new QName("http://service/", "deleteZoneResponse");
    private final static QName _GetLoginMaster_QNAME = new QName("http://service/", "getLoginMaster");
    private final static QName _DeleteParty_QNAME = new QName("http://service/", "deleteParty");
    private final static QName _UpdateZone_QNAME = new QName("http://service/", "updateZone");
    private final static QName _UpdateArea_QNAME = new QName("http://service/", "updateArea");
    private final static QName _SearchElectionByElectionTypeResponse_QNAME = new QName("http://service/", "searchElectionByElectionTypeResponse");
    private final static QName _GetParty_QNAME = new QName("http://service/", "getParty");
    private final static QName _SearchByZoneNameResponse_QNAME = new QName("http://service/", "searchByZoneNameResponse");
    private final static QName _IsValidToVoteResponse_QNAME = new QName("http://service/", "isValidToVoteResponse");
    private final static QName _GetCity_QNAME = new QName("http://service/", "getCity");
    private final static QName _GetAreaResponse_QNAME = new QName("http://service/", "getAreaResponse");
    private final static QName _AddSecurityResponse_QNAME = new QName("http://service/", "addSecurityResponse");
    private final static QName _GetVoteCountForSubwardResponse_QNAME = new QName("http://service/", "getVoteCountForSubwardResponse");
    private final static QName _GetSecurity_QNAME = new QName("http://service/", "getSecurity");
    private final static QName _GetZonesOfCity_QNAME = new QName("http://service/", "getZonesOfCity");
    private final static QName _GetAllParties_QNAME = new QName("http://service/", "getAllParties");
    private final static QName _DeactivateSecurity_QNAME = new QName("http://service/", "deactivateSecurity");
    private final static QName _UpdateCitizen_QNAME = new QName("http://service/", "updateCitizen");
    private final static QName _GetCandidatesOfSubward_QNAME = new QName("http://service/", "getCandidatesOfSubward");
    private final static QName _GetFutureElections_QNAME = new QName("http://service/", "getFutureElections");
    private final static QName _GetVoteCountForCandidateResponse_QNAME = new QName("http://service/", "getVoteCountForCandidateResponse");
    private final static QName _UpdateAreaResponse_QNAME = new QName("http://service/", "updateAreaResponse");
    private final static QName _GetSubWardsOfWard_QNAME = new QName("http://service/", "getSubWardsOfWard");
    private final static QName _GetZonesOfCityResponse_QNAME = new QName("http://service/", "getZonesOfCityResponse");
    private final static QName _GetScheduledElectionsResponse_QNAME = new QName("http://service/", "getScheduledElectionsResponse");
    private final static QName _GetAllInActiveCandidatesResponse_QNAME = new QName("http://service/", "getAllInActiveCandidatesResponse");
    private final static QName _DeleteAreaResponse_QNAME = new QName("http://service/", "deleteAreaResponse");
    private final static QName _SearchElectionByNameResponse_QNAME = new QName("http://service/", "searchElectionByNameResponse");
    private final static QName _DeletePartyResponse_QNAME = new QName("http://service/", "deletePartyResponse");
    private final static QName _CancelElectionResponse_QNAME = new QName("http://service/", "cancelElectionResponse");
    private final static QName _GetAllInActiveCandidates_QNAME = new QName("http://service/", "getAllInActiveCandidates");
    private final static QName _DeleteSubWard_QNAME = new QName("http://service/", "deleteSubWard");
    private final static QName _GetActiveCandidatesWithPartyId_QNAME = new QName("http://service/", "getActiveCandidatesWithPartyId");
    private final static QName _SearchCitizenByUsernameResponse_QNAME = new QName("http://service/", "searchCitizenByUsernameResponse");
    private final static QName _GetCandidateResponse_QNAME = new QName("http://service/", "getCandidateResponse");
    private final static QName _GetAllCandidatesResponse_QNAME = new QName("http://service/", "getAllCandidatesResponse");
    private final static QName _GetWard_QNAME = new QName("http://service/", "getWard");
    private final static QName _GetCandidatesOfArea_QNAME = new QName("http://service/", "getCandidatesOfArea");
    private final static QName _SearchCandidateByDateOfBirthRange_QNAME = new QName("http://service/", "searchCandidateByDateOfBirthRange");
    private final static QName _GetVoteCountForWardResponse_QNAME = new QName("http://service/", "getVoteCountForWardResponse");
    private final static QName _GetPartyResponse_QNAME = new QName("http://service/", "getPartyResponse");
    private final static QName _GetLoginMasterFromUsername_QNAME = new QName("http://service/", "getLoginMasterFromUsername");
    private final static QName _GetVoteCountForCandidate_QNAME = new QName("http://service/", "getVoteCountForCandidate");
    private final static QName _GetAllElections_QNAME = new QName("http://service/", "getAllElections");
    private final static QName _ActivateSecurityResponse_QNAME = new QName("http://service/", "activateSecurityResponse");
    private final static QName _SearchWardByName_QNAME = new QName("http://service/", "searchWardByName");
    private final static QName _AddSubWard_QNAME = new QName("http://service/", "addSubWard");
    private final static QName _GetVoteCountForWard_QNAME = new QName("http://service/", "getVoteCountForWard");
    private final static QName _GetAllCandidates_QNAME = new QName("http://service/", "getAllCandidates");
    private final static QName _AddCandidate_QNAME = new QName("http://service/", "addCandidate");
    private final static QName _GetWardWiseVoteCountsForZoneResponse_QNAME = new QName("http://service/", "getWardWiseVoteCountsForZoneResponse");
    private final static QName _GetAreaOfSubwardResponse_QNAME = new QName("http://service/", "getAreaOfSubwardResponse");
    private final static QName _CheckForExistingPartyResponse_QNAME = new QName("http://service/", "checkForExistingPartyResponse");
    private final static QName _CancelElection_QNAME = new QName("http://service/", "cancelElection");
    private final static QName _AddGroup_QNAME = new QName("http://service/", "addGroup");
    private final static QName _AddWard_QNAME = new QName("http://service/", "addWard");
    private final static QName _GetCitizensOfZoneResponse_QNAME = new QName("http://service/", "getCitizensOfZoneResponse");
    private final static QName _GetCandidatesOfZoneResponse_QNAME = new QName("http://service/", "getCandidatesOfZoneResponse");
    private final static QName _SearchPartyByPartyName_QNAME = new QName("http://service/", "searchPartyByPartyName");
    private final static QName _GetWardResponse_QNAME = new QName("http://service/", "getWardResponse");
    private final static QName _GetLoginMasterResponse_QNAME = new QName("http://service/", "getLoginMasterResponse");
    private final static QName _GetSecurityResponse_QNAME = new QName("http://service/", "getSecurityResponse");
    private final static QName _SearchElectionByFinalDate_QNAME = new QName("http://service/", "searchElectionByFinalDate");
    private final static QName _UpdateElection_QNAME = new QName("http://service/", "updateElection");
    private final static QName _GetVoteCountForZone_QNAME = new QName("http://service/", "getVoteCountForZone");
    private final static QName _AddSecurity_QNAME = new QName("http://service/", "addSecurity");
    private final static QName _UpdateWardResponse_QNAME = new QName("http://service/", "updateWardResponse");
    private final static QName _AddWardResponse_QNAME = new QName("http://service/", "addWardResponse");
    private final static QName _GetScheduledElections_QNAME = new QName("http://service/", "getScheduledElections");
    private final static QName _GetAllSubwardsResponse_QNAME = new QName("http://service/", "getAllSubwardsResponse");
    private final static QName _GetCandidateWiseVoteCountsForElectionResponse_QNAME = new QName("http://service/", "getCandidateWiseVoteCountsForElectionResponse");
    private final static QName _SearchByZoneName_QNAME = new QName("http://service/", "searchByZoneName");
    private final static QName _GetCandidateWiseVoteCountsForElection_QNAME = new QName("http://service/", "getCandidateWiseVoteCountsForElection");
    private final static QName _GetAllCitiesResponse_QNAME = new QName("http://service/", "getAllCitiesResponse");
    private final static QName _GetAllElectionTypes_QNAME = new QName("http://service/", "getAllElectionTypes");
    private final static QName _DeactivateSecurityResponse_QNAME = new QName("http://service/", "deactivateSecurityResponse");
    private final static QName _GetAllAreasResponse_QNAME = new QName("http://service/", "getAllAreasResponse");
    private final static QName _DeleteWardResponse_QNAME = new QName("http://service/", "deleteWardResponse");
    private final static QName _GetFutureElectionsResponse_QNAME = new QName("http://service/", "getFutureElectionsResponse");
    private final static QName _SearchByAreaNameResponse_QNAME = new QName("http://service/", "searchByAreaNameResponse");
    private final static QName _UpdateSubWard_QNAME = new QName("http://service/", "updateSubWard");
    private final static QName _GetCandidatesOfSubwardResponse_QNAME = new QName("http://service/", "getCandidatesOfSubwardResponse");
    private final static QName _UpdatePartyResponse_QNAME = new QName("http://service/", "updatePartyResponse");
    private final static QName _ActivateSecurity_QNAME = new QName("http://service/", "activateSecurity");
    private final static QName _GetWardsOfZoneResponse_QNAME = new QName("http://service/", "getWardsOfZoneResponse");
    private final static QName _UpdateCitizenResponse_QNAME = new QName("http://service/", "updateCitizenResponse");
    private final static QName _UpdateZoneResponse_QNAME = new QName("http://service/", "updateZoneResponse");
    private final static QName _GetVoteCountForAreaResponse_QNAME = new QName("http://service/", "getVoteCountForAreaResponse");
    private final static QName _GetCitizenMasterResponse_QNAME = new QName("http://service/", "getCitizenMasterResponse");
    private final static QName _GetVoteCountsForElection_QNAME = new QName("http://service/", "getVoteCountsForElection");
    private final static QName _GetCitizensOfArea_QNAME = new QName("http://service/", "getCitizensOfArea");
    private final static QName _GetAllWardsResponse_QNAME = new QName("http://service/", "getAllWardsResponse");
    private final static QName _SearchCitizenByIdResponse_QNAME = new QName("http://service/", "searchCitizenByIdResponse");
    private final static QName _GetActiveSecurityResponse_QNAME = new QName("http://service/", "getActiveSecurityResponse");
    private final static QName _GetVoteCountForPartyResponse_QNAME = new QName("http://service/", "getVoteCountForPartyResponse");
    private final static QName _GetZoneResponse_QNAME = new QName("http://service/", "getZoneResponse");
    private final static QName _DeleteCitizenResponse_QNAME = new QName("http://service/", "deleteCitizenResponse");
    private final static QName _GetCandidatesOfAreaResponse_QNAME = new QName("http://service/", "getCandidatesOfAreaResponse");
    private final static QName _AddSubWardResponse_QNAME = new QName("http://service/", "addSubWardResponse");
    private final static QName _GetAllActiveCandidates_QNAME = new QName("http://service/", "getAllActiveCandidates");
    private final static QName _SearchBySubWardName_QNAME = new QName("http://service/", "searchBySubWardName");
    private final static QName _SearchCandidateByLastName_QNAME = new QName("http://service/", "searchCandidateByLastName");
    private final static QName _GetAllSecurityResponse_QNAME = new QName("http://service/", "getAllSecurityResponse");
    private final static QName _GetVoteCountForZoneResponse_QNAME = new QName("http://service/", "getVoteCountForZoneResponse");
    private final static QName _ScheduleElectionResponse_QNAME = new QName("http://service/", "scheduleElectionResponse");
    private final static QName _UpdateElectionResponse_QNAME = new QName("http://service/", "updateElectionResponse");
    private final static QName _SearchBySubWardNameResponse_QNAME = new QName("http://service/", "searchBySubWardNameResponse");
    private final static QName _GetCitizensOfAreaResponse_QNAME = new QName("http://service/", "getCitizensOfAreaResponse");
    private final static QName _SubWardMasterCitizenMasterList_QNAME = new QName("", "citizenMasterList");
    private final static QName _SubWardMasterVoteMasterList_QNAME = new QName("", "voteMasterList");
    private final static QName _SubWardMasterCandidateMasterList_QNAME = new QName("", "candidateMasterList");
    private final static QName _SubWardMasterAreaMasterList_QNAME = new QName("", "areaMasterList");
    private final static QName _CandidateMasterElectionMasterList_QNAME = new QName("", "electionMasterList");
    private final static QName _ZoneMasterWardMasterList_QNAME = new QName("", "wardMasterList");
    private final static QName _GroupMasterUserGroupMasterList_QNAME = new QName("", "userGroupMasterList");
    private final static QName _CityMasterZoneMasterList_QNAME = new QName("", "zoneMasterList");
    private final static QName _WardMasterSubWardMasterList_QNAME = new QName("", "subWardMasterList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCitizensOfSubwardResponse }
     * 
     */
    public GetCitizensOfSubwardResponse createGetCitizensOfSubwardResponse() {
        return new GetCitizensOfSubwardResponse();
    }

    /**
     * Create an instance of {@link UserGroupMaster }
     * 
     */
    public UserGroupMaster createUserGroupMaster() {
        return new UserGroupMaster();
    }

    /**
     * Create an instance of {@link CheckForExistingParty }
     * 
     */
    public CheckForExistingParty createCheckForExistingParty() {
        return new CheckForExistingParty();
    }

    /**
     * Create an instance of {@link GetArea }
     * 
     */
    public GetArea createGetArea() {
        return new GetArea();
    }

    /**
     * Create an instance of {@link GetAllZones }
     * 
     */
    public GetAllZones createGetAllZones() {
        return new GetAllZones();
    }

    /**
     * Create an instance of {@link AddZone }
     * 
     */
    public AddZone createAddZone() {
        return new AddZone();
    }

    /**
     * Create an instance of {@link GetActiveCandidatesOfPartyResponse }
     * 
     */
    public GetActiveCandidatesOfPartyResponse createGetActiveCandidatesOfPartyResponse() {
        return new GetActiveCandidatesOfPartyResponse();
    }

    /**
     * Create an instance of {@link SearchCitizenByUsername }
     * 
     */
    public SearchCitizenByUsername createSearchCitizenByUsername() {
        return new SearchCitizenByUsername();
    }

    /**
     * Create an instance of {@link SearchCitizenByNameResponse }
     * 
     */
    public SearchCitizenByNameResponse createSearchCitizenByNameResponse() {
        return new SearchCitizenByNameResponse();
    }

    /**
     * Create an instance of {@link GetCitizensOfSubward }
     * 
     */
    public GetCitizensOfSubward createGetCitizensOfSubward() {
        return new GetCitizensOfSubward();
    }

    /**
     * Create an instance of {@link GetElectionResponse }
     * 
     */
    public GetElectionResponse createGetElectionResponse() {
        return new GetElectionResponse();
    }

    /**
     * Create an instance of {@link AddCity }
     * 
     */
    public AddCity createAddCity() {
        return new AddCity();
    }

    /**
     * Create an instance of {@link GetPastElectionsResponse }
     * 
     */
    public GetPastElectionsResponse createGetPastElectionsResponse() {
        return new GetPastElectionsResponse();
    }

    /**
     * Create an instance of {@link AddCandidate }
     * 
     */
    public AddCandidate createAddCandidate() {
        return new AddCandidate();
    }

    /**
     * Create an instance of {@link AddSubWard }
     * 
     */
    public AddSubWard createAddSubWard() {
        return new AddSubWard();
    }

    /**
     * Create an instance of {@link GetVoteCountForZoneResponse }
     * 
     */
    public GetVoteCountForZoneResponse createGetVoteCountForZoneResponse() {
        return new GetVoteCountForZoneResponse();
    }

    /**
     * Create an instance of {@link SearchPartyByPartyNameResponse }
     * 
     */
    public SearchPartyByPartyNameResponse createSearchPartyByPartyNameResponse() {
        return new SearchPartyByPartyNameResponse();
    }

    /**
     * Create an instance of {@link GetPartyResponse }
     * 
     */
    public GetPartyResponse createGetPartyResponse() {
        return new GetPartyResponse();
    }

    /**
     * Create an instance of {@link DeleteZone }
     * 
     */
    public DeleteZone createDeleteZone() {
        return new DeleteZone();
    }

    /**
     * Create an instance of {@link GetSecurityResponse }
     * 
     */
    public GetSecurityResponse createGetSecurityResponse() {
        return new GetSecurityResponse();
    }

    /**
     * Create an instance of {@link UpdateSubWardResponse }
     * 
     */
    public UpdateSubWardResponse createUpdateSubWardResponse() {
        return new UpdateSubWardResponse();
    }

    /**
     * Create an instance of {@link GetAreaOfSubwardResponse }
     * 
     */
    public GetAreaOfSubwardResponse createGetAreaOfSubwardResponse() {
        return new GetAreaOfSubwardResponse();
    }

    /**
     * Create an instance of {@link AddCitizen }
     * 
     */
    public AddCitizen createAddCitizen() {
        return new AddCitizen();
    }

    /**
     * Create an instance of {@link ScheduleElectionResponse }
     * 
     */
    public ScheduleElectionResponse createScheduleElectionResponse() {
        return new ScheduleElectionResponse();
    }

    /**
     * Create an instance of {@link GetVoteCountForZone }
     * 
     */
    public GetVoteCountForZone createGetVoteCountForZone() {
        return new GetVoteCountForZone();
    }

    /**
     * Create an instance of {@link SearchCitizenByUsernameResponse }
     * 
     */
    public SearchCitizenByUsernameResponse createSearchCitizenByUsernameResponse() {
        return new SearchCitizenByUsernameResponse();
    }

    /**
     * Create an instance of {@link SearchElectionByNameResponse }
     * 
     */
    public SearchElectionByNameResponse createSearchElectionByNameResponse() {
        return new SearchElectionByNameResponse();
    }

    /**
     * Create an instance of {@link SearchByZoneName }
     * 
     */
    public SearchByZoneName createSearchByZoneName() {
        return new SearchByZoneName();
    }

    /**
     * Create an instance of {@link GetVoteCountForSubward }
     * 
     */
    public GetVoteCountForSubward createGetVoteCountForSubward() {
        return new GetVoteCountForSubward();
    }

    /**
     * Create an instance of {@link GetAreaOfSubward }
     * 
     */
    public GetAreaOfSubward createGetAreaOfSubward() {
        return new GetAreaOfSubward();
    }

    /**
     * Create an instance of {@link DeleteArea }
     * 
     */
    public DeleteArea createDeleteArea() {
        return new DeleteArea();
    }

    /**
     * Create an instance of {@link UpdateZoneResponse }
     * 
     */
    public UpdateZoneResponse createUpdateZoneResponse() {
        return new UpdateZoneResponse();
    }

    /**
     * Create an instance of {@link AddGroupResponse }
     * 
     */
    public AddGroupResponse createAddGroupResponse() {
        return new AddGroupResponse();
    }

    /**
     * Create an instance of {@link GetVoteCountForSubwardResponse }
     * 
     */
    public GetVoteCountForSubwardResponse createGetVoteCountForSubwardResponse() {
        return new GetVoteCountForSubwardResponse();
    }

    /**
     * Create an instance of {@link GetWardsOfZone }
     * 
     */
    public GetWardsOfZone createGetWardsOfZone() {
        return new GetWardsOfZone();
    }

    /**
     * Create an instance of {@link GetAllElectionTypesResponse }
     * 
     */
    public GetAllElectionTypesResponse createGetAllElectionTypesResponse() {
        return new GetAllElectionTypesResponse();
    }

    /**
     * Create an instance of {@link GetCandidateWiseVoteCountsForWardResponse }
     * 
     */
    public GetCandidateWiseVoteCountsForWardResponse createGetCandidateWiseVoteCountsForWardResponse() {
        return new GetCandidateWiseVoteCountsForWardResponse();
    }

    /**
     * Create an instance of {@link GetAllActiveCandidates }
     * 
     */
    public GetAllActiveCandidates createGetAllActiveCandidates() {
        return new GetAllActiveCandidates();
    }

    /**
     * Create an instance of {@link UpdateWard }
     * 
     */
    public UpdateWard createUpdateWard() {
        return new UpdateWard();
    }

    /**
     * Create an instance of {@link GetVoteCountForWardResponse }
     * 
     */
    public GetVoteCountForWardResponse createGetVoteCountForWardResponse() {
        return new GetVoteCountForWardResponse();
    }

    /**
     * Create an instance of {@link ElectionMaster }
     * 
     */
    public ElectionMaster createElectionMaster() {
        return new ElectionMaster();
    }

    /**
     * Create an instance of {@link IsValidToVoteResponse }
     * 
     */
    public IsValidToVoteResponse createIsValidToVoteResponse() {
        return new IsValidToVoteResponse();
    }

    /**
     * Create an instance of {@link UpdateElectionResponse }
     * 
     */
    public UpdateElectionResponse createUpdateElectionResponse() {
        return new UpdateElectionResponse();
    }

    /**
     * Create an instance of {@link GetAllCitizensResponse }
     * 
     */
    public GetAllCitizensResponse createGetAllCitizensResponse() {
        return new GetAllCitizensResponse();
    }

    /**
     * Create an instance of {@link GetAllCitizens }
     * 
     */
    public GetAllCitizens createGetAllCitizens() {
        return new GetAllCitizens();
    }

    /**
     * Create an instance of {@link VoteMaster }
     * 
     */
    public VoteMaster createVoteMaster() {
        return new VoteMaster();
    }

    /**
     * Create an instance of {@link SecurityMaster }
     * 
     */
    public SecurityMaster createSecurityMaster() {
        return new SecurityMaster();
    }

    /**
     * Create an instance of {@link GetVoteCountForCandidate }
     * 
     */
    public GetVoteCountForCandidate createGetVoteCountForCandidate() {
        return new GetVoteCountForCandidate();
    }

    /**
     * Create an instance of {@link DeleteWardResponse }
     * 
     */
    public DeleteWardResponse createDeleteWardResponse() {
        return new DeleteWardResponse();
    }

    /**
     * Create an instance of {@link GetCandidate }
     * 
     */
    public GetCandidate createGetCandidate() {
        return new GetCandidate();
    }

    /**
     * Create an instance of {@link AddPartyResponse }
     * 
     */
    public AddPartyResponse createAddPartyResponse() {
        return new AddPartyResponse();
    }

    /**
     * Create an instance of {@link SearchElectionByName }
     * 
     */
    public SearchElectionByName createSearchElectionByName() {
        return new SearchElectionByName();
    }

    /**
     * Create an instance of {@link ScheduleElection }
     * 
     */
    public ScheduleElection createScheduleElection() {
        return new ScheduleElection();
    }

    /**
     * Create an instance of {@link DeleteAreaResponse }
     * 
     */
    public DeleteAreaResponse createDeleteAreaResponse() {
        return new DeleteAreaResponse();
    }

    /**
     * Create an instance of {@link UpdateAreaResponse }
     * 
     */
    public UpdateAreaResponse createUpdateAreaResponse() {
        return new UpdateAreaResponse();
    }

    /**
     * Create an instance of {@link DeleteCandidateResponse }
     * 
     */
    public DeleteCandidateResponse createDeleteCandidateResponse() {
        return new DeleteCandidateResponse();
    }

    /**
     * Create an instance of {@link DeleteWard }
     * 
     */
    public DeleteWard createDeleteWard() {
        return new DeleteWard();
    }

    /**
     * Create an instance of {@link GetCandidateWiseVoteCountsForElection }
     * 
     */
    public GetCandidateWiseVoteCountsForElection createGetCandidateWiseVoteCountsForElection() {
        return new GetCandidateWiseVoteCountsForElection();
    }

    /**
     * Create an instance of {@link GetCitizensOfZone }
     * 
     */
    public GetCitizensOfZone createGetCitizensOfZone() {
        return new GetCitizensOfZone();
    }

    /**
     * Create an instance of {@link GetElection }
     * 
     */
    public GetElection createGetElection() {
        return new GetElection();
    }

    /**
     * Create an instance of {@link GetCandidateResponse }
     * 
     */
    public GetCandidateResponse createGetCandidateResponse() {
        return new GetCandidateResponse();
    }

    /**
     * Create an instance of {@link SearchElectionByDateRange }
     * 
     */
    public SearchElectionByDateRange createSearchElectionByDateRange() {
        return new SearchElectionByDateRange();
    }

    /**
     * Create an instance of {@link GetCity }
     * 
     */
    public GetCity createGetCity() {
        return new GetCity();
    }

    /**
     * Create an instance of {@link XmlHashMapHelperIL }
     * 
     */
    public XmlHashMapHelperIL createXmlHashMapHelperIL() {
        return new XmlHashMapHelperIL();
    }

    /**
     * Create an instance of {@link GetSubWardsOfWardResponse }
     * 
     */
    public GetSubWardsOfWardResponse createGetSubWardsOfWardResponse() {
        return new GetSubWardsOfWardResponse();
    }

    /**
     * Create an instance of {@link DeleteParty }
     * 
     */
    public DeleteParty createDeleteParty() {
        return new DeleteParty();
    }

    /**
     * Create an instance of {@link SearchCandidateByLastNameResponse }
     * 
     */
    public SearchCandidateByLastNameResponse createSearchCandidateByLastNameResponse() {
        return new SearchCandidateByLastNameResponse();
    }

    /**
     * Create an instance of {@link GetWardsOfZoneResponse }
     * 
     */
    public GetWardsOfZoneResponse createGetWardsOfZoneResponse() {
        return new GetWardsOfZoneResponse();
    }

    /**
     * Create an instance of {@link GetParty }
     * 
     */
    public GetParty createGetParty() {
        return new GetParty();
    }

    /**
     * Create an instance of {@link GetAllCandidatesResponse }
     * 
     */
    public GetAllCandidatesResponse createGetAllCandidatesResponse() {
        return new GetAllCandidatesResponse();
    }

    /**
     * Create an instance of {@link AddArea }
     * 
     */
    public AddArea createAddArea() {
        return new AddArea();
    }

    /**
     * Create an instance of {@link SearchCitizenByName }
     * 
     */
    public SearchCitizenByName createSearchCitizenByName() {
        return new SearchCitizenByName();
    }

    /**
     * Create an instance of {@link XmlHashMapWrapperII }
     * 
     */
    public XmlHashMapWrapperII createXmlHashMapWrapperII() {
        return new XmlHashMapWrapperII();
    }

    /**
     * Create an instance of {@link GetVoteCountForCandidateResponse }
     * 
     */
    public GetVoteCountForCandidateResponse createGetVoteCountForCandidateResponse() {
        return new GetVoteCountForCandidateResponse();
    }

    /**
     * Create an instance of {@link SearchByZoneNameResponse }
     * 
     */
    public SearchByZoneNameResponse createSearchByZoneNameResponse() {
        return new SearchByZoneNameResponse();
    }

    /**
     * Create an instance of {@link GetActiveCandidatesOfParty }
     * 
     */
    public GetActiveCandidatesOfParty createGetActiveCandidatesOfParty() {
        return new GetActiveCandidatesOfParty();
    }

    /**
     * Create an instance of {@link AddCandidateResponse }
     * 
     */
    public AddCandidateResponse createAddCandidateResponse() {
        return new AddCandidateResponse();
    }

    /**
     * Create an instance of {@link GetCitizensOfAreaResponse }
     * 
     */
    public GetCitizensOfAreaResponse createGetCitizensOfAreaResponse() {
        return new GetCitizensOfAreaResponse();
    }

    /**
     * Create an instance of {@link GetLoginMasterResponse }
     * 
     */
    public GetLoginMasterResponse createGetLoginMasterResponse() {
        return new GetLoginMasterResponse();
    }

    /**
     * Create an instance of {@link GetAreaResponse }
     * 
     */
    public GetAreaResponse createGetAreaResponse() {
        return new GetAreaResponse();
    }

    /**
     * Create an instance of {@link GetAllActiveCandidatesResponse }
     * 
     */
    public GetAllActiveCandidatesResponse createGetAllActiveCandidatesResponse() {
        return new GetAllActiveCandidatesResponse();
    }

    /**
     * Create an instance of {@link SearchElectionByFinalDate }
     * 
     */
    public SearchElectionByFinalDate createSearchElectionByFinalDate() {
        return new SearchElectionByFinalDate();
    }

    /**
     * Create an instance of {@link GetVoteCountForAreaResponse }
     * 
     */
    public GetVoteCountForAreaResponse createGetVoteCountForAreaResponse() {
        return new GetVoteCountForAreaResponse();
    }

    /**
     * Create an instance of {@link GetAllSubwardsResponse }
     * 
     */
    public GetAllSubwardsResponse createGetAllSubwardsResponse() {
        return new GetAllSubwardsResponse();
    }

    /**
     * Create an instance of {@link AddCityResponse }
     * 
     */
    public AddCityResponse createAddCityResponse() {
        return new AddCityResponse();
    }

    /**
     * Create an instance of {@link GetActiveSecurityResponse }
     * 
     */
    public GetActiveSecurityResponse createGetActiveSecurityResponse() {
        return new GetActiveSecurityResponse();
    }

    /**
     * Create an instance of {@link SearchBySubWardNameResponse }
     * 
     */
    public SearchBySubWardNameResponse createSearchBySubWardNameResponse() {
        return new SearchBySubWardNameResponse();
    }

    /**
     * Create an instance of {@link DeleteCitizen }
     * 
     */
    public DeleteCitizen createDeleteCitizen() {
        return new DeleteCitizen();
    }

    /**
     * Create an instance of {@link DeleteCandidate }
     * 
     */
    public DeleteCandidate createDeleteCandidate() {
        return new DeleteCandidate();
    }

    /**
     * Create an instance of {@link GetLoginMaster }
     * 
     */
    public GetLoginMaster createGetLoginMaster() {
        return new GetLoginMaster();
    }

    /**
     * Create an instance of {@link CastVote }
     * 
     */
    public CastVote createCastVote() {
        return new CastVote();
    }

    /**
     * Create an instance of {@link GetAllCities }
     * 
     */
    public GetAllCities createGetAllCities() {
        return new GetAllCities();
    }

    /**
     * Create an instance of {@link GetCityResponse }
     * 
     */
    public GetCityResponse createGetCityResponse() {
        return new GetCityResponse();
    }

    /**
     * Create an instance of {@link UpdateWardResponse }
     * 
     */
    public UpdateWardResponse createUpdateWardResponse() {
        return new UpdateWardResponse();
    }

    /**
     * Create an instance of {@link GetAllWards }
     * 
     */
    public GetAllWards createGetAllWards() {
        return new GetAllWards();
    }

    /**
     * Create an instance of {@link AddParty }
     * 
     */
    public AddParty createAddParty() {
        return new AddParty();
    }

    /**
     * Create an instance of {@link CancelElection }
     * 
     */
    public CancelElection createCancelElection() {
        return new CancelElection();
    }

    /**
     * Create an instance of {@link DeletePartyResponse }
     * 
     */
    public DeletePartyResponse createDeletePartyResponse() {
        return new DeletePartyResponse();
    }

    /**
     * Create an instance of {@link GetZonesOfCityResponse }
     * 
     */
    public GetZonesOfCityResponse createGetZonesOfCityResponse() {
        return new GetZonesOfCityResponse();
    }

    /**
     * Create an instance of {@link GetAllZonesResponse }
     * 
     */
    public GetAllZonesResponse createGetAllZonesResponse() {
        return new GetAllZonesResponse();
    }

    /**
     * Create an instance of {@link CheckForExistingCandidate }
     * 
     */
    public CheckForExistingCandidate createCheckForExistingCandidate() {
        return new CheckForExistingCandidate();
    }

    /**
     * Create an instance of {@link SearchByAreaName }
     * 
     */
    public SearchByAreaName createSearchByAreaName() {
        return new SearchByAreaName();
    }

    /**
     * Create an instance of {@link SearchElectionByDateRangeResponse }
     * 
     */
    public SearchElectionByDateRangeResponse createSearchElectionByDateRangeResponse() {
        return new SearchElectionByDateRangeResponse();
    }

    /**
     * Create an instance of {@link UpdateArea }
     * 
     */
    public UpdateArea createUpdateArea() {
        return new UpdateArea();
    }

    /**
     * Create an instance of {@link CheckForExistingCandidateResponse }
     * 
     */
    public CheckForExistingCandidateResponse createCheckForExistingCandidateResponse() {
        return new CheckForExistingCandidateResponse();
    }

    /**
     * Create an instance of {@link GetWardResponse }
     * 
     */
    public GetWardResponse createGetWardResponse() {
        return new GetWardResponse();
    }

    /**
     * Create an instance of {@link UpdateZone }
     * 
     */
    public UpdateZone createUpdateZone() {
        return new UpdateZone();
    }

    /**
     * Create an instance of {@link GetCandidateWiseVoteCountsForElectionResponse }
     * 
     */
    public GetCandidateWiseVoteCountsForElectionResponse createGetCandidateWiseVoteCountsForElectionResponse() {
        return new GetCandidateWiseVoteCountsForElectionResponse();
    }

    /**
     * Create an instance of {@link GetLoginMasterFromUsername }
     * 
     */
    public GetLoginMasterFromUsername createGetLoginMasterFromUsername() {
        return new GetLoginMasterFromUsername();
    }

    /**
     * Create an instance of {@link GetSubWardsOfWard }
     * 
     */
    public GetSubWardsOfWard createGetSubWardsOfWard() {
        return new GetSubWardsOfWard();
    }

    /**
     * Create an instance of {@link CancelElectionResponse }
     * 
     */
    public CancelElectionResponse createCancelElectionResponse() {
        return new CancelElectionResponse();
    }

    /**
     * Create an instance of {@link GetAllElectionTypes }
     * 
     */
    public GetAllElectionTypes createGetAllElectionTypes() {
        return new GetAllElectionTypes();
    }

    /**
     * Create an instance of {@link UpdateElection }
     * 
     */
    public UpdateElection createUpdateElection() {
        return new UpdateElection();
    }

    /**
     * Create an instance of {@link GetSecurity }
     * 
     */
    public GetSecurity createGetSecurity() {
        return new GetSecurity();
    }

    /**
     * Create an instance of {@link SearchBySubWardName }
     * 
     */
    public SearchBySubWardName createSearchBySubWardName() {
        return new SearchBySubWardName();
    }

    /**
     * Create an instance of {@link SearchCandidateByLastName }
     * 
     */
    public SearchCandidateByLastName createSearchCandidateByLastName() {
        return new SearchCandidateByLastName();
    }

    /**
     * Create an instance of {@link GetAllCitiesResponse }
     * 
     */
    public GetAllCitiesResponse createGetAllCitiesResponse() {
        return new GetAllCitiesResponse();
    }

    /**
     * Create an instance of {@link DeactivateSecurityResponse }
     * 
     */
    public DeactivateSecurityResponse createDeactivateSecurityResponse() {
        return new DeactivateSecurityResponse();
    }

    /**
     * Create an instance of {@link XmlHashMapWrapperIL }
     * 
     */
    public XmlHashMapWrapperIL createXmlHashMapWrapperIL() {
        return new XmlHashMapWrapperIL();
    }

    /**
     * Create an instance of {@link ZoneMaster }
     * 
     */
    public ZoneMaster createZoneMaster() {
        return new ZoneMaster();
    }

    /**
     * Create an instance of {@link GetCitizensOfWardResponse }
     * 
     */
    public GetCitizensOfWardResponse createGetCitizensOfWardResponse() {
        return new GetCitizensOfWardResponse();
    }

    /**
     * Create an instance of {@link UpdateCitizen }
     * 
     */
    public UpdateCitizen createUpdateCitizen() {
        return new UpdateCitizen();
    }

    /**
     * Create an instance of {@link UpdateCandidateResponse }
     * 
     */
    public UpdateCandidateResponse createUpdateCandidateResponse() {
        return new UpdateCandidateResponse();
    }

    /**
     * Create an instance of {@link GetAllSubwards }
     * 
     */
    public GetAllSubwards createGetAllSubwards() {
        return new GetAllSubwards();
    }

    /**
     * Create an instance of {@link ActivateSecurity }
     * 
     */
    public ActivateSecurity createActivateSecurity() {
        return new ActivateSecurity();
    }

    /**
     * Create an instance of {@link GetAllElectionsResponse }
     * 
     */
    public GetAllElectionsResponse createGetAllElectionsResponse() {
        return new GetAllElectionsResponse();
    }

    /**
     * Create an instance of {@link SearchPartyByPartyName }
     * 
     */
    public SearchPartyByPartyName createSearchPartyByPartyName() {
        return new SearchPartyByPartyName();
    }

    /**
     * Create an instance of {@link GetCitizensOfArea }
     * 
     */
    public GetCitizensOfArea createGetCitizensOfArea() {
        return new GetCitizensOfArea();
    }

    /**
     * Create an instance of {@link DeactivateSecurity }
     * 
     */
    public DeactivateSecurity createDeactivateSecurity() {
        return new DeactivateSecurity();
    }

    /**
     * Create an instance of {@link SearchCandidateByDateOfBirthRange }
     * 
     */
    public SearchCandidateByDateOfBirthRange createSearchCandidateByDateOfBirthRange() {
        return new SearchCandidateByDateOfBirthRange();
    }

    /**
     * Create an instance of {@link GetAllInActiveCandidatesResponse }
     * 
     */
    public GetAllInActiveCandidatesResponse createGetAllInActiveCandidatesResponse() {
        return new GetAllInActiveCandidatesResponse();
    }

    /**
     * Create an instance of {@link CityMaster }
     * 
     */
    public CityMaster createCityMaster() {
        return new CityMaster();
    }

    /**
     * Create an instance of {@link GetVoteCountForPartyResponse }
     * 
     */
    public GetVoteCountForPartyResponse createGetVoteCountForPartyResponse() {
        return new GetVoteCountForPartyResponse();
    }

    /**
     * Create an instance of {@link GetWard }
     * 
     */
    public GetWard createGetWard() {
        return new GetWard();
    }

    /**
     * Create an instance of {@link CheckForExistingPartyResponse }
     * 
     */
    public CheckForExistingPartyResponse createCheckForExistingPartyResponse() {
        return new CheckForExistingPartyResponse();
    }

    /**
     * Create an instance of {@link GetAllElections }
     * 
     */
    public GetAllElections createGetAllElections() {
        return new GetAllElections();
    }

    /**
     * Create an instance of {@link GetCandidatesOfZone }
     * 
     */
    public GetCandidatesOfZone createGetCandidatesOfZone() {
        return new GetCandidatesOfZone();
    }

    /**
     * Create an instance of {@link UpdatePartyResponse }
     * 
     */
    public UpdatePartyResponse createUpdatePartyResponse() {
        return new UpdatePartyResponse();
    }

    /**
     * Create an instance of {@link SearchWardByName }
     * 
     */
    public SearchWardByName createSearchWardByName() {
        return new SearchWardByName();
    }

    /**
     * Create an instance of {@link GetAllWardsResponse }
     * 
     */
    public GetAllWardsResponse createGetAllWardsResponse() {
        return new GetAllWardsResponse();
    }

    /**
     * Create an instance of {@link GroupMaster }
     * 
     */
    public GroupMaster createGroupMaster() {
        return new GroupMaster();
    }

    /**
     * Create an instance of {@link GetCandidateWiseVoteCountsForWard }
     * 
     */
    public GetCandidateWiseVoteCountsForWard createGetCandidateWiseVoteCountsForWard() {
        return new GetCandidateWiseVoteCountsForWard();
    }

    /**
     * Create an instance of {@link AddSubWardResponse }
     * 
     */
    public AddSubWardResponse createAddSubWardResponse() {
        return new AddSubWardResponse();
    }

    /**
     * Create an instance of {@link GetActiveCandidatesWithPartyId }
     * 
     */
    public GetActiveCandidatesWithPartyId createGetActiveCandidatesWithPartyId() {
        return new GetActiveCandidatesWithPartyId();
    }

    /**
     * Create an instance of {@link XmlHashMapII }
     * 
     */
    public XmlHashMapII createXmlHashMapII() {
        return new XmlHashMapII();
    }

    /**
     * Create an instance of {@link SearchCandidateByActiveStatus }
     * 
     */
    public SearchCandidateByActiveStatus createSearchCandidateByActiveStatus() {
        return new SearchCandidateByActiveStatus();
    }

    /**
     * Create an instance of {@link GetCandidatesOfSubwardResponse }
     * 
     */
    public GetCandidatesOfSubwardResponse createGetCandidatesOfSubwardResponse() {
        return new GetCandidatesOfSubwardResponse();
    }

    /**
     * Create an instance of {@link XmlHashMapIL }
     * 
     */
    public XmlHashMapIL createXmlHashMapIL() {
        return new XmlHashMapIL();
    }

    /**
     * Create an instance of {@link GetZone }
     * 
     */
    public GetZone createGetZone() {
        return new GetZone();
    }

    /**
     * Create an instance of {@link SearchCandidateByDateOfBirthRangeResponse }
     * 
     */
    public SearchCandidateByDateOfBirthRangeResponse createSearchCandidateByDateOfBirthRangeResponse() {
        return new SearchCandidateByDateOfBirthRangeResponse();
    }

    /**
     * Create an instance of {@link GetCitizenMaster }
     * 
     */
    public GetCitizenMaster createGetCitizenMaster() {
        return new GetCitizenMaster();
    }

    /**
     * Create an instance of {@link GetLoginMasterFromUsernameResponse }
     * 
     */
    public GetLoginMasterFromUsernameResponse createGetLoginMasterFromUsernameResponse() {
        return new GetLoginMasterFromUsernameResponse();
    }

    /**
     * Create an instance of {@link DeleteSubWardResponse }
     * 
     */
    public DeleteSubWardResponse createDeleteSubWardResponse() {
        return new DeleteSubWardResponse();
    }

    /**
     * Create an instance of {@link LoginMaster }
     * 
     */
    public LoginMaster createLoginMaster() {
        return new LoginMaster();
    }

    /**
     * Create an instance of {@link GetScheduledElectionsResponse }
     * 
     */
    public GetScheduledElectionsResponse createGetScheduledElectionsResponse() {
        return new GetScheduledElectionsResponse();
    }

    /**
     * Create an instance of {@link GetVoteCountForParty }
     * 
     */
    public GetVoteCountForParty createGetVoteCountForParty() {
        return new GetVoteCountForParty();
    }

    /**
     * Create an instance of {@link GetAllSecurityResponse }
     * 
     */
    public GetAllSecurityResponse createGetAllSecurityResponse() {
        return new GetAllSecurityResponse();
    }

    /**
     * Create an instance of {@link GetCandidatesOfAreaResponse }
     * 
     */
    public GetCandidatesOfAreaResponse createGetCandidatesOfAreaResponse() {
        return new GetCandidatesOfAreaResponse();
    }

    /**
     * Create an instance of {@link AreaMaster }
     * 
     */
    public AreaMaster createAreaMaster() {
        return new AreaMaster();
    }

    /**
     * Create an instance of {@link GetAllSecurity }
     * 
     */
    public GetAllSecurity createGetAllSecurity() {
        return new GetAllSecurity();
    }

    /**
     * Create an instance of {@link GetActiveCandidatesWithPartyIdResponse }
     * 
     */
    public GetActiveCandidatesWithPartyIdResponse createGetActiveCandidatesWithPartyIdResponse() {
        return new GetActiveCandidatesWithPartyIdResponse();
    }

    /**
     * Create an instance of {@link AddWardResponse }
     * 
     */
    public AddWardResponse createAddWardResponse() {
        return new AddWardResponse();
    }

    /**
     * Create an instance of {@link GetAllAreasResponse }
     * 
     */
    public GetAllAreasResponse createGetAllAreasResponse() {
        return new GetAllAreasResponse();
    }

    /**
     * Create an instance of {@link SearchElectionByElectionType }
     * 
     */
    public SearchElectionByElectionType createSearchElectionByElectionType() {
        return new SearchElectionByElectionType();
    }

    /**
     * Create an instance of {@link DeleteCitizenResponse }
     * 
     */
    public DeleteCitizenResponse createDeleteCitizenResponse() {
        return new DeleteCitizenResponse();
    }

    /**
     * Create an instance of {@link UpdateCandidate }
     * 
     */
    public UpdateCandidate createUpdateCandidate() {
        return new UpdateCandidate();
    }

    /**
     * Create an instance of {@link GetAllCandidates }
     * 
     */
    public GetAllCandidates createGetAllCandidates() {
        return new GetAllCandidates();
    }

    /**
     * Create an instance of {@link GetAllAreas }
     * 
     */
    public GetAllAreas createGetAllAreas() {
        return new GetAllAreas();
    }

    /**
     * Create an instance of {@link GetVoteCountForWard }
     * 
     */
    public GetVoteCountForWard createGetVoteCountForWard() {
        return new GetVoteCountForWard();
    }

    /**
     * Create an instance of {@link GetCitizensOfZoneResponse }
     * 
     */
    public GetCitizensOfZoneResponse createGetCitizensOfZoneResponse() {
        return new GetCitizensOfZoneResponse();
    }

    /**
     * Create an instance of {@link GetAllParties }
     * 
     */
    public GetAllParties createGetAllParties() {
        return new GetAllParties();
    }

    /**
     * Create an instance of {@link ActivateSecurityResponse }
     * 
     */
    public ActivateSecurityResponse createActivateSecurityResponse() {
        return new ActivateSecurityResponse();
    }

    /**
     * Create an instance of {@link SearchCitizenByIdResponse }
     * 
     */
    public SearchCitizenByIdResponse createSearchCitizenByIdResponse() {
        return new SearchCitizenByIdResponse();
    }

    /**
     * Create an instance of {@link GetCandidatesOfWardResponse }
     * 
     */
    public GetCandidatesOfWardResponse createGetCandidatesOfWardResponse() {
        return new GetCandidatesOfWardResponse();
    }

    /**
     * Create an instance of {@link SearchElectionByFinalDateResponse }
     * 
     */
    public SearchElectionByFinalDateResponse createSearchElectionByFinalDateResponse() {
        return new SearchElectionByFinalDateResponse();
    }

    /**
     * Create an instance of {@link GetZoneResponse }
     * 
     */
    public GetZoneResponse createGetZoneResponse() {
        return new GetZoneResponse();
    }

    /**
     * Create an instance of {@link GetFutureElectionsResponse }
     * 
     */
    public GetFutureElectionsResponse createGetFutureElectionsResponse() {
        return new GetFutureElectionsResponse();
    }

    /**
     * Create an instance of {@link SearchWardByNameResponse }
     * 
     */
    public SearchWardByNameResponse createSearchWardByNameResponse() {
        return new SearchWardByNameResponse();
    }

    /**
     * Create an instance of {@link AddSecurityResponse }
     * 
     */
    public AddSecurityResponse createAddSecurityResponse() {
        return new AddSecurityResponse();
    }

    /**
     * Create an instance of {@link SayHello }
     * 
     */
    public SayHello createSayHello() {
        return new SayHello();
    }

    /**
     * Create an instance of {@link AddZoneResponse }
     * 
     */
    public AddZoneResponse createAddZoneResponse() {
        return new AddZoneResponse();
    }

    /**
     * Create an instance of {@link DeleteZoneResponse }
     * 
     */
    public DeleteZoneResponse createDeleteZoneResponse() {
        return new DeleteZoneResponse();
    }

    /**
     * Create an instance of {@link CastVoteResponse }
     * 
     */
    public CastVoteResponse createCastVoteResponse() {
        return new CastVoteResponse();
    }

    /**
     * Create an instance of {@link GetVoteCountForArea }
     * 
     */
    public GetVoteCountForArea createGetVoteCountForArea() {
        return new GetVoteCountForArea();
    }

    /**
     * Create an instance of {@link GetActiveSecurity }
     * 
     */
    public GetActiveSecurity createGetActiveSecurity() {
        return new GetActiveSecurity();
    }

    /**
     * Create an instance of {@link GetVoteCountsForElectionResponse }
     * 
     */
    public GetVoteCountsForElectionResponse createGetVoteCountsForElectionResponse() {
        return new GetVoteCountsForElectionResponse();
    }

    /**
     * Create an instance of {@link SearchCitizenById }
     * 
     */
    public SearchCitizenById createSearchCitizenById() {
        return new SearchCitizenById();
    }

    /**
     * Create an instance of {@link CandidateMaster }
     * 
     */
    public CandidateMaster createCandidateMaster() {
        return new CandidateMaster();
    }

    /**
     * Create an instance of {@link GetPastElections }
     * 
     */
    public GetPastElections createGetPastElections() {
        return new GetPastElections();
    }

    /**
     * Create an instance of {@link XmlHashMapHelperII }
     * 
     */
    public XmlHashMapHelperII createXmlHashMapHelperII() {
        return new XmlHashMapHelperII();
    }

    /**
     * Create an instance of {@link SearchCandidateByFirstName }
     * 
     */
    public SearchCandidateByFirstName createSearchCandidateByFirstName() {
        return new SearchCandidateByFirstName();
    }

    /**
     * Create an instance of {@link DeleteSubWard }
     * 
     */
    public DeleteSubWard createDeleteSubWard() {
        return new DeleteSubWard();
    }

    /**
     * Create an instance of {@link SubWardMaster }
     * 
     */
    public SubWardMaster createSubWardMaster() {
        return new SubWardMaster();
    }

    /**
     * Create an instance of {@link GetCitizenMasterResponse }
     * 
     */
    public GetCitizenMasterResponse createGetCitizenMasterResponse() {
        return new GetCitizenMasterResponse();
    }

    /**
     * Create an instance of {@link GetZonesOfCity }
     * 
     */
    public GetZonesOfCity createGetZonesOfCity() {
        return new GetZonesOfCity();
    }

    /**
     * Create an instance of {@link GetScheduledElections }
     * 
     */
    public GetScheduledElections createGetScheduledElections() {
        return new GetScheduledElections();
    }

    /**
     * Create an instance of {@link GetVoteCountsForElection }
     * 
     */
    public GetVoteCountsForElection createGetVoteCountsForElection() {
        return new GetVoteCountsForElection();
    }

    /**
     * Create an instance of {@link GetWardWiseVoteCountsForZoneResponse }
     * 
     */
    public GetWardWiseVoteCountsForZoneResponse createGetWardWiseVoteCountsForZoneResponse() {
        return new GetWardWiseVoteCountsForZoneResponse();
    }

    /**
     * Create an instance of {@link GetSubWardResponse }
     * 
     */
    public GetSubWardResponse createGetSubWardResponse() {
        return new GetSubWardResponse();
    }

    /**
     * Create an instance of {@link GetCandidatesOfArea }
     * 
     */
    public GetCandidatesOfArea createGetCandidatesOfArea() {
        return new GetCandidatesOfArea();
    }

    /**
     * Create an instance of {@link AddGroup }
     * 
     */
    public AddGroup createAddGroup() {
        return new AddGroup();
    }

    /**
     * Create an instance of {@link AddElection }
     * 
     */
    public AddElection createAddElection() {
        return new AddElection();
    }

    /**
     * Create an instance of {@link AddSecurity }
     * 
     */
    public AddSecurity createAddSecurity() {
        return new AddSecurity();
    }

    /**
     * Create an instance of {@link UpdateSubWard }
     * 
     */
    public UpdateSubWard createUpdateSubWard() {
        return new UpdateSubWard();
    }

    /**
     * Create an instance of {@link ElectionTypeMaster }
     * 
     */
    public ElectionTypeMaster createElectionTypeMaster() {
        return new ElectionTypeMaster();
    }

    /**
     * Create an instance of {@link GetWardWiseVoteCountsForZone }
     * 
     */
    public GetWardWiseVoteCountsForZone createGetWardWiseVoteCountsForZone() {
        return new GetWardWiseVoteCountsForZone();
    }

    /**
     * Create an instance of {@link GetAllPartiesResponse }
     * 
     */
    public GetAllPartiesResponse createGetAllPartiesResponse() {
        return new GetAllPartiesResponse();
    }

    /**
     * Create an instance of {@link SearchElectionByElectionTypeResponse }
     * 
     */
    public SearchElectionByElectionTypeResponse createSearchElectionByElectionTypeResponse() {
        return new SearchElectionByElectionTypeResponse();
    }

    /**
     * Create an instance of {@link AddCitizenResponse }
     * 
     */
    public AddCitizenResponse createAddCitizenResponse() {
        return new AddCitizenResponse();
    }

    /**
     * Create an instance of {@link GetFutureElections }
     * 
     */
    public GetFutureElections createGetFutureElections() {
        return new GetFutureElections();
    }

    /**
     * Create an instance of {@link PartyMaster }
     * 
     */
    public PartyMaster createPartyMaster() {
        return new PartyMaster();
    }

    /**
     * Create an instance of {@link SearchCandidateByFirstNameResponse }
     * 
     */
    public SearchCandidateByFirstNameResponse createSearchCandidateByFirstNameResponse() {
        return new SearchCandidateByFirstNameResponse();
    }

    /**
     * Create an instance of {@link CitizenMaster }
     * 
     */
    public CitizenMaster createCitizenMaster() {
        return new CitizenMaster();
    }

    /**
     * Create an instance of {@link GetCitizensOfWard }
     * 
     */
    public GetCitizensOfWard createGetCitizensOfWard() {
        return new GetCitizensOfWard();
    }

    /**
     * Create an instance of {@link UpdateCitizenResponse }
     * 
     */
    public UpdateCitizenResponse createUpdateCitizenResponse() {
        return new UpdateCitizenResponse();
    }

    /**
     * Create an instance of {@link AddElectionResponse }
     * 
     */
    public AddElectionResponse createAddElectionResponse() {
        return new AddElectionResponse();
    }

    /**
     * Create an instance of {@link IsValidToVote }
     * 
     */
    public IsValidToVote createIsValidToVote() {
        return new IsValidToVote();
    }

    /**
     * Create an instance of {@link UpdateParty }
     * 
     */
    public UpdateParty createUpdateParty() {
        return new UpdateParty();
    }

    /**
     * Create an instance of {@link GetAllInActiveCandidates }
     * 
     */
    public GetAllInActiveCandidates createGetAllInActiveCandidates() {
        return new GetAllInActiveCandidates();
    }

    /**
     * Create an instance of {@link SearchByAreaNameResponse }
     * 
     */
    public SearchByAreaNameResponse createSearchByAreaNameResponse() {
        return new SearchByAreaNameResponse();
    }

    /**
     * Create an instance of {@link GetSubWard }
     * 
     */
    public GetSubWard createGetSubWard() {
        return new GetSubWard();
    }

    /**
     * Create an instance of {@link GetCandidatesOfWard }
     * 
     */
    public GetCandidatesOfWard createGetCandidatesOfWard() {
        return new GetCandidatesOfWard();
    }

    /**
     * Create an instance of {@link GetCandidatesOfZoneResponse }
     * 
     */
    public GetCandidatesOfZoneResponse createGetCandidatesOfZoneResponse() {
        return new GetCandidatesOfZoneResponse();
    }

    /**
     * Create an instance of {@link GetCandidatesOfSubward }
     * 
     */
    public GetCandidatesOfSubward createGetCandidatesOfSubward() {
        return new GetCandidatesOfSubward();
    }

    /**
     * Create an instance of {@link AddWard }
     * 
     */
    public AddWard createAddWard() {
        return new AddWard();
    }

    /**
     * Create an instance of {@link WardMaster }
     * 
     */
    public WardMaster createWardMaster() {
        return new WardMaster();
    }

    /**
     * Create an instance of {@link SearchCandidateByActiveStatusResponse }
     * 
     */
    public SearchCandidateByActiveStatusResponse createSearchCandidateByActiveStatusResponse() {
        return new SearchCandidateByActiveStatusResponse();
    }

    /**
     * Create an instance of {@link AddAreaResponse }
     * 
     */
    public AddAreaResponse createAddAreaResponse() {
        return new AddAreaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsValidToVote }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "isValidToVote")
    public JAXBElement<IsValidToVote> createIsValidToVote(IsValidToVote value) {
        return new JAXBElement<IsValidToVote>(_IsValidToVote_QNAME, IsValidToVote.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllAreas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllAreas")
    public JAXBElement<GetAllAreas> createGetAllAreas(GetAllAreas value) {
        return new JAXBElement<GetAllAreas>(_GetAllAreas_QNAME, GetAllAreas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteArea }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "deleteArea")
    public JAXBElement<DeleteArea> createDeleteArea(DeleteArea value) {
        return new JAXBElement<DeleteArea>(_DeleteArea_QNAME, DeleteArea.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCandidateByActiveStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchCandidateByActiveStatus")
    public JAXBElement<SearchCandidateByActiveStatus> createSearchCandidateByActiveStatus(SearchCandidateByActiveStatus value) {
        return new JAXBElement<SearchCandidateByActiveStatus>(_SearchCandidateByActiveStatus_QNAME, SearchCandidateByActiveStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCandidateByFirstNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchCandidateByFirstNameResponse")
    public JAXBElement<SearchCandidateByFirstNameResponse> createSearchCandidateByFirstNameResponse(SearchCandidateByFirstNameResponse value) {
        return new JAXBElement<SearchCandidateByFirstNameResponse>(_SearchCandidateByFirstNameResponse_QNAME, SearchCandidateByFirstNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCandidatesOfZone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCandidatesOfZone")
    public JAXBElement<GetCandidatesOfZone> createGetCandidatesOfZone(GetCandidatesOfZone value) {
        return new JAXBElement<GetCandidatesOfZone>(_GetCandidatesOfZone_QNAME, GetCandidatesOfZone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActiveCandidatesOfPartyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getActiveCandidatesOfPartyResponse")
    public JAXBElement<GetActiveCandidatesOfPartyResponse> createGetActiveCandidatesOfPartyResponse(GetActiveCandidatesOfPartyResponse value) {
        return new JAXBElement<GetActiveCandidatesOfPartyResponse>(_GetActiveCandidatesOfPartyResponse_QNAME, GetActiveCandidatesOfPartyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPastElections }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getPastElections")
    public JAXBElement<GetPastElections> createGetPastElections(GetPastElections value) {
        return new JAXBElement<GetPastElections>(_GetPastElections_QNAME, GetPastElections.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCitizenByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchCitizenByName")
    public JAXBElement<SearchCitizenByName> createSearchCitizenByName(SearchCitizenByName value) {
        return new JAXBElement<SearchCitizenByName>(_SearchCitizenByName_QNAME, SearchCitizenByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCitizen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addCitizen")
    public JAXBElement<AddCitizen> createAddCitizen(AddCitizen value) {
        return new JAXBElement<AddCitizen>(_AddCitizen_QNAME, AddCitizen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchElectionByDateRangeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchElectionByDateRangeResponse")
    public JAXBElement<SearchElectionByDateRangeResponse> createSearchElectionByDateRangeResponse(SearchElectionByDateRangeResponse value) {
        return new JAXBElement<SearchElectionByDateRangeResponse>(_SearchElectionByDateRangeResponse_QNAME, SearchElectionByDateRangeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCandidateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "updateCandidateResponse")
    public JAXBElement<UpdateCandidateResponse> createUpdateCandidateResponse(UpdateCandidateResponse value) {
        return new JAXBElement<UpdateCandidateResponse>(_UpdateCandidateResponse_QNAME, UpdateCandidateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteWard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "deleteWard")
    public JAXBElement<DeleteWard> createDeleteWard(DeleteWard value) {
        return new JAXBElement<DeleteWard>(_DeleteWard_QNAME, DeleteWard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCitizenById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchCitizenById")
    public JAXBElement<SearchCitizenById> createSearchCitizenById(SearchCitizenById value) {
        return new JAXBElement<SearchCitizenById>(_SearchCitizenById_QNAME, SearchCitizenById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddParty }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addParty")
    public JAXBElement<AddParty> createAddParty(AddParty value) {
        return new JAXBElement<AddParty>(_AddParty_QNAME, AddParty.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAreaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addAreaResponse")
    public JAXBElement<AddAreaResponse> createAddAreaResponse(AddAreaResponse value) {
        return new JAXBElement<AddAreaResponse>(_AddAreaResponse_QNAME, AddAreaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCandidatesOfWardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCandidatesOfWardResponse")
    public JAXBElement<GetCandidatesOfWardResponse> createGetCandidatesOfWardResponse(GetCandidatesOfWardResponse value) {
        return new JAXBElement<GetCandidatesOfWardResponse>(_GetCandidatesOfWardResponse_QNAME, GetCandidatesOfWardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddArea }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addArea")
    public JAXBElement<AddArea> createAddArea(AddArea value) {
        return new JAXBElement<AddArea>(_AddArea_QNAME, AddArea.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchPartyByPartyNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchPartyByPartyNameResponse")
    public JAXBElement<SearchPartyByPartyNameResponse> createSearchPartyByPartyNameResponse(SearchPartyByPartyNameResponse value) {
        return new JAXBElement<SearchPartyByPartyNameResponse>(_SearchPartyByPartyNameResponse_QNAME, SearchPartyByPartyNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetArea }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getArea")
    public JAXBElement<GetArea> createGetArea(GetArea value) {
        return new JAXBElement<GetArea>(_GetArea_QNAME, GetArea.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteZone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "deleteZone")
    public JAXBElement<DeleteZone> createDeleteZone(DeleteZone value) {
        return new JAXBElement<DeleteZone>(_DeleteZone_QNAME, DeleteZone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddGroupResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addGroupResponse")
    public JAXBElement<AddGroupResponse> createAddGroupResponse(AddGroupResponse value) {
        return new JAXBElement<AddGroupResponse>(_AddGroupResponse_QNAME, AddGroupResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddElectionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addElectionResponse")
    public JAXBElement<AddElectionResponse> createAddElectionResponse(AddElectionResponse value) {
        return new JAXBElement<AddElectionResponse>(_AddElectionResponse_QNAME, AddElectionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchWardByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchWardByNameResponse")
    public JAXBElement<SearchWardByNameResponse> createSearchWardByNameResponse(SearchWardByNameResponse value) {
        return new JAXBElement<SearchWardByNameResponse>(_SearchWardByNameResponse_QNAME, SearchWardByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteSubWardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "deleteSubWardResponse")
    public JAXBElement<DeleteSubWardResponse> createDeleteSubWardResponse(DeleteSubWardResponse value) {
        return new JAXBElement<DeleteSubWardResponse>(_DeleteSubWardResponse_QNAME, DeleteSubWardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSecurity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllSecurity")
    public JAXBElement<GetAllSecurity> createGetAllSecurity(GetAllSecurity value) {
        return new JAXBElement<GetAllSecurity>(_GetAllSecurity_QNAME, GetAllSecurity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchElectionByElectionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchElectionByElectionType")
    public JAXBElement<SearchElectionByElectionType> createSearchElectionByElectionType(SearchElectionByElectionType value) {
        return new JAXBElement<SearchElectionByElectionType>(_SearchElectionByElectionType_QNAME, SearchElectionByElectionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchElectionByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchElectionByName")
    public JAXBElement<SearchElectionByName> createSearchElectionByName(SearchElectionByName value) {
        return new JAXBElement<SearchElectionByName>(_SearchElectionByName_QNAME, SearchElectionByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllZonesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllZonesResponse")
    public JAXBElement<GetAllZonesResponse> createGetAllZonesResponse(GetAllZonesResponse value) {
        return new JAXBElement<GetAllZonesResponse>(_GetAllZonesResponse_QNAME, GetAllZonesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPastElectionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getPastElectionsResponse")
    public JAXBElement<GetPastElectionsResponse> createGetPastElectionsResponse(GetPastElectionsResponse value) {
        return new JAXBElement<GetPastElectionsResponse>(_GetPastElectionsResponse_QNAME, GetPastElectionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCitizenByUsername }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchCitizenByUsername")
    public JAXBElement<SearchCitizenByUsername> createSearchCitizenByUsername(SearchCitizenByUsername value) {
        return new JAXBElement<SearchCitizenByUsername>(_SearchCitizenByUsername_QNAME, SearchCitizenByUsername.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCitizen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "deleteCitizen")
    public JAXBElement<DeleteCitizen> createDeleteCitizen(DeleteCitizen value) {
        return new JAXBElement<DeleteCitizen>(_DeleteCitizen_QNAME, DeleteCitizen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllWards }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllWards")
    public JAXBElement<GetAllWards> createGetAllWards(GetAllWards value) {
        return new JAXBElement<GetAllWards>(_GetAllWards_QNAME, GetAllWards.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddZoneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addZoneResponse")
    public JAXBElement<AddZoneResponse> createAddZoneResponse(AddZoneResponse value) {
        return new JAXBElement<AddZoneResponse>(_AddZoneResponse_QNAME, AddZoneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActiveSecurity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getActiveSecurity")
    public JAXBElement<GetActiveSecurity> createGetActiveSecurity(GetActiveSecurity value) {
        return new JAXBElement<GetActiveSecurity>(_GetActiveSecurity_QNAME, GetActiveSecurity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddZone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addZone")
    public JAXBElement<AddZone> createAddZone(AddZone value) {
        return new JAXBElement<AddZone>(_AddZone_QNAME, AddZone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCitizensResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllCitizensResponse")
    public JAXBElement<GetAllCitizensResponse> createGetAllCitizensResponse(GetAllCitizensResponse value) {
        return new JAXBElement<GetAllCitizensResponse>(_GetAllCitizensResponse_QNAME, GetAllCitizensResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWardWiseVoteCountsForZone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getWardWiseVoteCountsForZone")
    public JAXBElement<GetWardWiseVoteCountsForZone> createGetWardWiseVoteCountsForZone(GetWardWiseVoteCountsForZone value) {
        return new JAXBElement<GetWardWiseVoteCountsForZone>(_GetWardWiseVoteCountsForZone_QNAME, GetWardWiseVoteCountsForZone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchElectionByFinalDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchElectionByFinalDateResponse")
    public JAXBElement<SearchElectionByFinalDateResponse> createSearchElectionByFinalDateResponse(SearchElectionByFinalDateResponse value) {
        return new JAXBElement<SearchElectionByFinalDateResponse>(_SearchElectionByFinalDateResponse_QNAME, SearchElectionByFinalDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSubwards }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllSubwards")
    public JAXBElement<GetAllSubwards> createGetAllSubwards(GetAllSubwards value) {
        return new JAXBElement<GetAllSubwards>(_GetAllSubwards_QNAME, GetAllSubwards.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCandidateByDateOfBirthRangeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchCandidateByDateOfBirthRangeResponse")
    public JAXBElement<SearchCandidateByDateOfBirthRangeResponse> createSearchCandidateByDateOfBirthRangeResponse(SearchCandidateByDateOfBirthRangeResponse value) {
        return new JAXBElement<SearchCandidateByDateOfBirthRangeResponse>(_SearchCandidateByDateOfBirthRangeResponse_QNAME, SearchCandidateByDateOfBirthRangeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubWard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getSubWard")
    public JAXBElement<GetSubWard> createGetSubWard(GetSubWard value) {
        return new JAXBElement<GetSubWard>(_GetSubWard_QNAME, GetSubWard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addCityResponse")
    public JAXBElement<AddCityResponse> createAddCityResponse(AddCityResponse value) {
        return new JAXBElement<AddCityResponse>(_AddCityResponse_QNAME, AddCityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitizensOfZone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCitizensOfZone")
    public JAXBElement<GetCitizensOfZone> createGetCitizensOfZone(GetCitizensOfZone value) {
        return new JAXBElement<GetCitizensOfZone>(_GetCitizensOfZone_QNAME, GetCitizensOfZone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWardsOfZone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getWardsOfZone")
    public JAXBElement<GetWardsOfZone> createGetWardsOfZone(GetWardsOfZone value) {
        return new JAXBElement<GetWardsOfZone>(_GetWardsOfZone_QNAME, GetWardsOfZone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPartyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addPartyResponse")
    public JAXBElement<AddPartyResponse> createAddPartyResponse(AddPartyResponse value) {
        return new JAXBElement<AddPartyResponse>(_AddPartyResponse_QNAME, AddPartyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddElection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addElection")
    public JAXBElement<AddElection> createAddElection(AddElection value) {
        return new JAXBElement<AddElection>(_AddElection_QNAME, AddElection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitizensOfSubward }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCitizensOfSubward")
    public JAXBElement<GetCitizensOfSubward> createGetCitizensOfSubward(GetCitizensOfSubward value) {
        return new JAXBElement<GetCitizensOfSubward>(_GetCitizensOfSubward_QNAME, GetCitizensOfSubward.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLoginMasterFromUsernameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getLoginMasterFromUsernameResponse")
    public JAXBElement<GetLoginMasterFromUsernameResponse> createGetLoginMasterFromUsernameResponse(GetLoginMasterFromUsernameResponse value) {
        return new JAXBElement<GetLoginMasterFromUsernameResponse>(_GetLoginMasterFromUsernameResponse_QNAME, GetLoginMasterFromUsernameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVoteCountForArea }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getVoteCountForArea")
    public JAXBElement<GetVoteCountForArea> createGetVoteCountForArea(GetVoteCountForArea value) {
        return new JAXBElement<GetVoteCountForArea>(_GetVoteCountForArea_QNAME, GetVoteCountForArea.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllZones }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllZones")
    public JAXBElement<GetAllZones> createGetAllZones(GetAllZones value) {
        return new JAXBElement<GetAllZones>(_GetAllZones_QNAME, GetAllZones.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addCity")
    public JAXBElement<AddCity> createAddCity(AddCity value) {
        return new JAXBElement<AddCity>(_AddCity_QNAME, AddCity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetElection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getElection")
    public JAXBElement<GetElection> createGetElection(GetElection value) {
        return new JAXBElement<GetElection>(_GetElection_QNAME, GetElection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCandidateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "deleteCandidateResponse")
    public JAXBElement<DeleteCandidateResponse> createDeleteCandidateResponse(DeleteCandidateResponse value) {
        return new JAXBElement<DeleteCandidateResponse>(_DeleteCandidateResponse_QNAME, DeleteCandidateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCandidateWiseVoteCountsForWard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCandidateWiseVoteCountsForWard")
    public JAXBElement<GetCandidateWiseVoteCountsForWard> createGetCandidateWiseVoteCountsForWard(GetCandidateWiseVoteCountsForWard value) {
        return new JAXBElement<GetCandidateWiseVoteCountsForWard>(_GetCandidateWiseVoteCountsForWard_QNAME, GetCandidateWiseVoteCountsForWard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCityResponse")
    public JAXBElement<GetCityResponse> createGetCityResponse(GetCityResponse value) {
        return new JAXBElement<GetCityResponse>(_GetCityResponse_QNAME, GetCityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCandidate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "deleteCandidate")
    public JAXBElement<DeleteCandidate> createDeleteCandidate(DeleteCandidate value) {
        return new JAXBElement<DeleteCandidate>(_DeleteCandidate_QNAME, DeleteCandidate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCitizenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addCitizenResponse")
    public JAXBElement<AddCitizenResponse> createAddCitizenResponse(AddCitizenResponse value) {
        return new JAXBElement<AddCitizenResponse>(_AddCitizenResponse_QNAME, AddCitizenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitizensOfWard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCitizensOfWard")
    public JAXBElement<GetCitizensOfWard> createGetCitizensOfWard(GetCitizensOfWard value) {
        return new JAXBElement<GetCitizensOfWard>(_GetCitizensOfWard_QNAME, GetCitizensOfWard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActiveCandidatesOfParty }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getActiveCandidatesOfParty")
    public JAXBElement<GetActiveCandidatesOfParty> createGetActiveCandidatesOfParty(GetActiveCandidatesOfParty value) {
        return new JAXBElement<GetActiveCandidatesOfParty>(_GetActiveCandidatesOfParty_QNAME, GetActiveCandidatesOfParty.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVoteCountForSubward }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getVoteCountForSubward")
    public JAXBElement<GetVoteCountForSubward> createGetVoteCountForSubward(GetVoteCountForSubward value) {
        return new JAXBElement<GetVoteCountForSubward>(_GetVoteCountForSubward_QNAME, GetVoteCountForSubward.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCitizenByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchCitizenByNameResponse")
    public JAXBElement<SearchCitizenByNameResponse> createSearchCitizenByNameResponse(SearchCitizenByNameResponse value) {
        return new JAXBElement<SearchCitizenByNameResponse>(_SearchCitizenByNameResponse_QNAME, SearchCitizenByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCandidateByActiveStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchCandidateByActiveStatusResponse")
    public JAXBElement<SearchCandidateByActiveStatusResponse> createSearchCandidateByActiveStatusResponse(SearchCandidateByActiveStatusResponse value) {
        return new JAXBElement<SearchCandidateByActiveStatusResponse>(_SearchCandidateByActiveStatusResponse_QNAME, SearchCandidateByActiveStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitizensOfSubwardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCitizensOfSubwardResponse")
    public JAXBElement<GetCitizensOfSubwardResponse> createGetCitizensOfSubwardResponse(GetCitizensOfSubwardResponse value) {
        return new JAXBElement<GetCitizensOfSubwardResponse>(_GetCitizensOfSubwardResponse_QNAME, GetCitizensOfSubwardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCandidateByFirstName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchCandidateByFirstName")
    public JAXBElement<SearchCandidateByFirstName> createSearchCandidateByFirstName(SearchCandidateByFirstName value) {
        return new JAXBElement<SearchCandidateByFirstName>(_SearchCandidateByFirstName_QNAME, SearchCandidateByFirstName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCandidateByLastNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchCandidateByLastNameResponse")
    public JAXBElement<SearchCandidateByLastNameResponse> createSearchCandidateByLastNameResponse(SearchCandidateByLastNameResponse value) {
        return new JAXBElement<SearchCandidateByLastNameResponse>(_SearchCandidateByLastNameResponse_QNAME, SearchCandidateByLastNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetZone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getZone")
    public JAXBElement<GetZone> createGetZone(GetZone value) {
        return new JAXBElement<GetZone>(_GetZone_QNAME, GetZone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitizenMaster }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCitizenMaster")
    public JAXBElement<GetCitizenMaster> createGetCitizenMaster(GetCitizenMaster value) {
        return new JAXBElement<GetCitizenMaster>(_GetCitizenMaster_QNAME, GetCitizenMaster.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ScheduleElection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "scheduleElection")
    public JAXBElement<ScheduleElection> createScheduleElection(ScheduleElection value) {
        return new JAXBElement<ScheduleElection>(_ScheduleElection_QNAME, ScheduleElection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchElectionByDateRange }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchElectionByDateRange")
    public JAXBElement<SearchElectionByDateRange> createSearchElectionByDateRange(SearchElectionByDateRange value) {
        return new JAXBElement<SearchElectionByDateRange>(_SearchElectionByDateRange_QNAME, SearchElectionByDateRange.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVoteCountsForElectionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getVoteCountsForElectionResponse")
    public JAXBElement<GetVoteCountsForElectionResponse> createGetVoteCountsForElectionResponse(GetVoteCountsForElectionResponse value) {
        return new JAXBElement<GetVoteCountsForElectionResponse>(_GetVoteCountsForElectionResponse_QNAME, GetVoteCountsForElectionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "sayHello")
    public JAXBElement<SayHello> createSayHello(SayHello value) {
        return new JAXBElement<SayHello>(_SayHello_QNAME, SayHello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAreaOfSubward }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAreaOfSubward")
    public JAXBElement<GetAreaOfSubward> createGetAreaOfSubward(GetAreaOfSubward value) {
        return new JAXBElement<GetAreaOfSubward>(_GetAreaOfSubward_QNAME, GetAreaOfSubward.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCandidateWiseVoteCountsForWardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCandidateWiseVoteCountsForWardResponse")
    public JAXBElement<GetCandidateWiseVoteCountsForWardResponse> createGetCandidateWiseVoteCountsForWardResponse(GetCandidateWiseVoteCountsForWardResponse value) {
        return new JAXBElement<GetCandidateWiseVoteCountsForWardResponse>(_GetCandidateWiseVoteCountsForWardResponse_QNAME, GetCandidateWiseVoteCountsForWardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateSubWardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "updateSubWardResponse")
    public JAXBElement<UpdateSubWardResponse> createUpdateSubWardResponse(UpdateSubWardResponse value) {
        return new JAXBElement<UpdateSubWardResponse>(_UpdateSubWardResponse_QNAME, UpdateSubWardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCandidateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addCandidateResponse")
    public JAXBElement<AddCandidateResponse> createAddCandidateResponse(AddCandidateResponse value) {
        return new JAXBElement<AddCandidateResponse>(_AddCandidateResponse_QNAME, AddCandidateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllElectionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllElectionsResponse")
    public JAXBElement<GetAllElectionsResponse> createGetAllElectionsResponse(GetAllElectionsResponse value) {
        return new JAXBElement<GetAllElectionsResponse>(_GetAllElectionsResponse_QNAME, GetAllElectionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVoteCountForParty }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getVoteCountForParty")
    public JAXBElement<GetVoteCountForParty> createGetVoteCountForParty(GetVoteCountForParty value) {
        return new JAXBElement<GetVoteCountForParty>(_GetVoteCountForParty_QNAME, GetVoteCountForParty.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateWard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "updateWard")
    public JAXBElement<UpdateWard> createUpdateWard(UpdateWard value) {
        return new JAXBElement<UpdateWard>(_UpdateWard_QNAME, UpdateWard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckForExistingCandidate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "checkForExistingCandidate")
    public JAXBElement<CheckForExistingCandidate> createCheckForExistingCandidate(CheckForExistingCandidate value) {
        return new JAXBElement<CheckForExistingCandidate>(_CheckForExistingCandidate_QNAME, CheckForExistingCandidate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllElectionTypesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllElectionTypesResponse")
    public JAXBElement<GetAllElectionTypesResponse> createGetAllElectionTypesResponse(GetAllElectionTypesResponse value) {
        return new JAXBElement<GetAllElectionTypesResponse>(_GetAllElectionTypesResponse_QNAME, GetAllElectionTypesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateParty }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "updateParty")
    public JAXBElement<UpdateParty> createUpdateParty(UpdateParty value) {
        return new JAXBElement<UpdateParty>(_UpdateParty_QNAME, UpdateParty.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCandidate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "updateCandidate")
    public JAXBElement<UpdateCandidate> createUpdateCandidate(UpdateCandidate value) {
        return new JAXBElement<UpdateCandidate>(_UpdateCandidate_QNAME, UpdateCandidate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPartiesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllPartiesResponse")
    public JAXBElement<GetAllPartiesResponse> createGetAllPartiesResponse(GetAllPartiesResponse value) {
        return new JAXBElement<GetAllPartiesResponse>(_GetAllPartiesResponse_QNAME, GetAllPartiesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCandidatesOfWard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCandidatesOfWard")
    public JAXBElement<GetCandidatesOfWard> createGetCandidatesOfWard(GetCandidatesOfWard value) {
        return new JAXBElement<GetCandidatesOfWard>(_GetCandidatesOfWard_QNAME, GetCandidatesOfWard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitizensOfWardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCitizensOfWardResponse")
    public JAXBElement<GetCitizensOfWardResponse> createGetCitizensOfWardResponse(GetCitizensOfWardResponse value) {
        return new JAXBElement<GetCitizensOfWardResponse>(_GetCitizensOfWardResponse_QNAME, GetCitizensOfWardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActiveCandidatesWithPartyIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getActiveCandidatesWithPartyIdResponse")
    public JAXBElement<GetActiveCandidatesWithPartyIdResponse> createGetActiveCandidatesWithPartyIdResponse(GetActiveCandidatesWithPartyIdResponse value) {
        return new JAXBElement<GetActiveCandidatesWithPartyIdResponse>(_GetActiveCandidatesWithPartyIdResponse_QNAME, GetActiveCandidatesWithPartyIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckForExistingCandidateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "checkForExistingCandidateResponse")
    public JAXBElement<CheckForExistingCandidateResponse> createCheckForExistingCandidateResponse(CheckForExistingCandidateResponse value) {
        return new JAXBElement<CheckForExistingCandidateResponse>(_CheckForExistingCandidateResponse_QNAME, CheckForExistingCandidateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetElectionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getElectionResponse")
    public JAXBElement<GetElectionResponse> createGetElectionResponse(GetElectionResponse value) {
        return new JAXBElement<GetElectionResponse>(_GetElectionResponse_QNAME, GetElectionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CastVoteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "castVoteResponse")
    public JAXBElement<CastVoteResponse> createCastVoteResponse(CastVoteResponse value) {
        return new JAXBElement<CastVoteResponse>(_CastVoteResponse_QNAME, CastVoteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CastVote }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "castVote")
    public JAXBElement<CastVote> createCastVote(CastVote value) {
        return new JAXBElement<CastVote>(_CastVote_QNAME, CastVote.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCandidate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCandidate")
    public JAXBElement<GetCandidate> createGetCandidate(GetCandidate value) {
        return new JAXBElement<GetCandidate>(_GetCandidate_QNAME, GetCandidate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCitizens }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllCitizens")
    public JAXBElement<GetAllCitizens> createGetAllCitizens(GetAllCitizens value) {
        return new JAXBElement<GetAllCitizens>(_GetAllCitizens_QNAME, GetAllCitizens.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubWardsOfWardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getSubWardsOfWardResponse")
    public JAXBElement<GetSubWardsOfWardResponse> createGetSubWardsOfWardResponse(GetSubWardsOfWardResponse value) {
        return new JAXBElement<GetSubWardsOfWardResponse>(_GetSubWardsOfWardResponse_QNAME, GetSubWardsOfWardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubWardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getSubWardResponse")
    public JAXBElement<GetSubWardResponse> createGetSubWardResponse(GetSubWardResponse value) {
        return new JAXBElement<GetSubWardResponse>(_GetSubWardResponse_QNAME, GetSubWardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckForExistingParty }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "checkForExistingParty")
    public JAXBElement<CheckForExistingParty> createCheckForExistingParty(CheckForExistingParty value) {
        return new JAXBElement<CheckForExistingParty>(_CheckForExistingParty_QNAME, CheckForExistingParty.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchByAreaName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchByAreaName")
    public JAXBElement<SearchByAreaName> createSearchByAreaName(SearchByAreaName value) {
        return new JAXBElement<SearchByAreaName>(_SearchByAreaName_QNAME, SearchByAreaName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllActiveCandidatesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllActiveCandidatesResponse")
    public JAXBElement<GetAllActiveCandidatesResponse> createGetAllActiveCandidatesResponse(GetAllActiveCandidatesResponse value) {
        return new JAXBElement<GetAllActiveCandidatesResponse>(_GetAllActiveCandidatesResponse_QNAME, GetAllActiveCandidatesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCities }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllCities")
    public JAXBElement<GetAllCities> createGetAllCities(GetAllCities value) {
        return new JAXBElement<GetAllCities>(_GetAllCities_QNAME, GetAllCities.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteZoneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "deleteZoneResponse")
    public JAXBElement<DeleteZoneResponse> createDeleteZoneResponse(DeleteZoneResponse value) {
        return new JAXBElement<DeleteZoneResponse>(_DeleteZoneResponse_QNAME, DeleteZoneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLoginMaster }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getLoginMaster")
    public JAXBElement<GetLoginMaster> createGetLoginMaster(GetLoginMaster value) {
        return new JAXBElement<GetLoginMaster>(_GetLoginMaster_QNAME, GetLoginMaster.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteParty }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "deleteParty")
    public JAXBElement<DeleteParty> createDeleteParty(DeleteParty value) {
        return new JAXBElement<DeleteParty>(_DeleteParty_QNAME, DeleteParty.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateZone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "updateZone")
    public JAXBElement<UpdateZone> createUpdateZone(UpdateZone value) {
        return new JAXBElement<UpdateZone>(_UpdateZone_QNAME, UpdateZone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateArea }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "updateArea")
    public JAXBElement<UpdateArea> createUpdateArea(UpdateArea value) {
        return new JAXBElement<UpdateArea>(_UpdateArea_QNAME, UpdateArea.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchElectionByElectionTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchElectionByElectionTypeResponse")
    public JAXBElement<SearchElectionByElectionTypeResponse> createSearchElectionByElectionTypeResponse(SearchElectionByElectionTypeResponse value) {
        return new JAXBElement<SearchElectionByElectionTypeResponse>(_SearchElectionByElectionTypeResponse_QNAME, SearchElectionByElectionTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetParty }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getParty")
    public JAXBElement<GetParty> createGetParty(GetParty value) {
        return new JAXBElement<GetParty>(_GetParty_QNAME, GetParty.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchByZoneNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchByZoneNameResponse")
    public JAXBElement<SearchByZoneNameResponse> createSearchByZoneNameResponse(SearchByZoneNameResponse value) {
        return new JAXBElement<SearchByZoneNameResponse>(_SearchByZoneNameResponse_QNAME, SearchByZoneNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsValidToVoteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "isValidToVoteResponse")
    public JAXBElement<IsValidToVoteResponse> createIsValidToVoteResponse(IsValidToVoteResponse value) {
        return new JAXBElement<IsValidToVoteResponse>(_IsValidToVoteResponse_QNAME, IsValidToVoteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCity")
    public JAXBElement<GetCity> createGetCity(GetCity value) {
        return new JAXBElement<GetCity>(_GetCity_QNAME, GetCity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAreaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAreaResponse")
    public JAXBElement<GetAreaResponse> createGetAreaResponse(GetAreaResponse value) {
        return new JAXBElement<GetAreaResponse>(_GetAreaResponse_QNAME, GetAreaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddSecurityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addSecurityResponse")
    public JAXBElement<AddSecurityResponse> createAddSecurityResponse(AddSecurityResponse value) {
        return new JAXBElement<AddSecurityResponse>(_AddSecurityResponse_QNAME, AddSecurityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVoteCountForSubwardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getVoteCountForSubwardResponse")
    public JAXBElement<GetVoteCountForSubwardResponse> createGetVoteCountForSubwardResponse(GetVoteCountForSubwardResponse value) {
        return new JAXBElement<GetVoteCountForSubwardResponse>(_GetVoteCountForSubwardResponse_QNAME, GetVoteCountForSubwardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSecurity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getSecurity")
    public JAXBElement<GetSecurity> createGetSecurity(GetSecurity value) {
        return new JAXBElement<GetSecurity>(_GetSecurity_QNAME, GetSecurity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetZonesOfCity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getZonesOfCity")
    public JAXBElement<GetZonesOfCity> createGetZonesOfCity(GetZonesOfCity value) {
        return new JAXBElement<GetZonesOfCity>(_GetZonesOfCity_QNAME, GetZonesOfCity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllParties }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllParties")
    public JAXBElement<GetAllParties> createGetAllParties(GetAllParties value) {
        return new JAXBElement<GetAllParties>(_GetAllParties_QNAME, GetAllParties.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeactivateSecurity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "deactivateSecurity")
    public JAXBElement<DeactivateSecurity> createDeactivateSecurity(DeactivateSecurity value) {
        return new JAXBElement<DeactivateSecurity>(_DeactivateSecurity_QNAME, DeactivateSecurity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCitizen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "updateCitizen")
    public JAXBElement<UpdateCitizen> createUpdateCitizen(UpdateCitizen value) {
        return new JAXBElement<UpdateCitizen>(_UpdateCitizen_QNAME, UpdateCitizen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCandidatesOfSubward }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCandidatesOfSubward")
    public JAXBElement<GetCandidatesOfSubward> createGetCandidatesOfSubward(GetCandidatesOfSubward value) {
        return new JAXBElement<GetCandidatesOfSubward>(_GetCandidatesOfSubward_QNAME, GetCandidatesOfSubward.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFutureElections }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getFutureElections")
    public JAXBElement<GetFutureElections> createGetFutureElections(GetFutureElections value) {
        return new JAXBElement<GetFutureElections>(_GetFutureElections_QNAME, GetFutureElections.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVoteCountForCandidateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getVoteCountForCandidateResponse")
    public JAXBElement<GetVoteCountForCandidateResponse> createGetVoteCountForCandidateResponse(GetVoteCountForCandidateResponse value) {
        return new JAXBElement<GetVoteCountForCandidateResponse>(_GetVoteCountForCandidateResponse_QNAME, GetVoteCountForCandidateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateAreaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "updateAreaResponse")
    public JAXBElement<UpdateAreaResponse> createUpdateAreaResponse(UpdateAreaResponse value) {
        return new JAXBElement<UpdateAreaResponse>(_UpdateAreaResponse_QNAME, UpdateAreaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubWardsOfWard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getSubWardsOfWard")
    public JAXBElement<GetSubWardsOfWard> createGetSubWardsOfWard(GetSubWardsOfWard value) {
        return new JAXBElement<GetSubWardsOfWard>(_GetSubWardsOfWard_QNAME, GetSubWardsOfWard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetZonesOfCityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getZonesOfCityResponse")
    public JAXBElement<GetZonesOfCityResponse> createGetZonesOfCityResponse(GetZonesOfCityResponse value) {
        return new JAXBElement<GetZonesOfCityResponse>(_GetZonesOfCityResponse_QNAME, GetZonesOfCityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetScheduledElectionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getScheduledElectionsResponse")
    public JAXBElement<GetScheduledElectionsResponse> createGetScheduledElectionsResponse(GetScheduledElectionsResponse value) {
        return new JAXBElement<GetScheduledElectionsResponse>(_GetScheduledElectionsResponse_QNAME, GetScheduledElectionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllInActiveCandidatesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllInActiveCandidatesResponse")
    public JAXBElement<GetAllInActiveCandidatesResponse> createGetAllInActiveCandidatesResponse(GetAllInActiveCandidatesResponse value) {
        return new JAXBElement<GetAllInActiveCandidatesResponse>(_GetAllInActiveCandidatesResponse_QNAME, GetAllInActiveCandidatesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAreaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "deleteAreaResponse")
    public JAXBElement<DeleteAreaResponse> createDeleteAreaResponse(DeleteAreaResponse value) {
        return new JAXBElement<DeleteAreaResponse>(_DeleteAreaResponse_QNAME, DeleteAreaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchElectionByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchElectionByNameResponse")
    public JAXBElement<SearchElectionByNameResponse> createSearchElectionByNameResponse(SearchElectionByNameResponse value) {
        return new JAXBElement<SearchElectionByNameResponse>(_SearchElectionByNameResponse_QNAME, SearchElectionByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePartyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "deletePartyResponse")
    public JAXBElement<DeletePartyResponse> createDeletePartyResponse(DeletePartyResponse value) {
        return new JAXBElement<DeletePartyResponse>(_DeletePartyResponse_QNAME, DeletePartyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelElectionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "cancelElectionResponse")
    public JAXBElement<CancelElectionResponse> createCancelElectionResponse(CancelElectionResponse value) {
        return new JAXBElement<CancelElectionResponse>(_CancelElectionResponse_QNAME, CancelElectionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllInActiveCandidates }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllInActiveCandidates")
    public JAXBElement<GetAllInActiveCandidates> createGetAllInActiveCandidates(GetAllInActiveCandidates value) {
        return new JAXBElement<GetAllInActiveCandidates>(_GetAllInActiveCandidates_QNAME, GetAllInActiveCandidates.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteSubWard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "deleteSubWard")
    public JAXBElement<DeleteSubWard> createDeleteSubWard(DeleteSubWard value) {
        return new JAXBElement<DeleteSubWard>(_DeleteSubWard_QNAME, DeleteSubWard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActiveCandidatesWithPartyId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getActiveCandidatesWithPartyId")
    public JAXBElement<GetActiveCandidatesWithPartyId> createGetActiveCandidatesWithPartyId(GetActiveCandidatesWithPartyId value) {
        return new JAXBElement<GetActiveCandidatesWithPartyId>(_GetActiveCandidatesWithPartyId_QNAME, GetActiveCandidatesWithPartyId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCitizenByUsernameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchCitizenByUsernameResponse")
    public JAXBElement<SearchCitizenByUsernameResponse> createSearchCitizenByUsernameResponse(SearchCitizenByUsernameResponse value) {
        return new JAXBElement<SearchCitizenByUsernameResponse>(_SearchCitizenByUsernameResponse_QNAME, SearchCitizenByUsernameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCandidateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCandidateResponse")
    public JAXBElement<GetCandidateResponse> createGetCandidateResponse(GetCandidateResponse value) {
        return new JAXBElement<GetCandidateResponse>(_GetCandidateResponse_QNAME, GetCandidateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCandidatesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllCandidatesResponse")
    public JAXBElement<GetAllCandidatesResponse> createGetAllCandidatesResponse(GetAllCandidatesResponse value) {
        return new JAXBElement<GetAllCandidatesResponse>(_GetAllCandidatesResponse_QNAME, GetAllCandidatesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getWard")
    public JAXBElement<GetWard> createGetWard(GetWard value) {
        return new JAXBElement<GetWard>(_GetWard_QNAME, GetWard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCandidatesOfArea }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCandidatesOfArea")
    public JAXBElement<GetCandidatesOfArea> createGetCandidatesOfArea(GetCandidatesOfArea value) {
        return new JAXBElement<GetCandidatesOfArea>(_GetCandidatesOfArea_QNAME, GetCandidatesOfArea.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCandidateByDateOfBirthRange }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchCandidateByDateOfBirthRange")
    public JAXBElement<SearchCandidateByDateOfBirthRange> createSearchCandidateByDateOfBirthRange(SearchCandidateByDateOfBirthRange value) {
        return new JAXBElement<SearchCandidateByDateOfBirthRange>(_SearchCandidateByDateOfBirthRange_QNAME, SearchCandidateByDateOfBirthRange.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVoteCountForWardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getVoteCountForWardResponse")
    public JAXBElement<GetVoteCountForWardResponse> createGetVoteCountForWardResponse(GetVoteCountForWardResponse value) {
        return new JAXBElement<GetVoteCountForWardResponse>(_GetVoteCountForWardResponse_QNAME, GetVoteCountForWardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPartyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getPartyResponse")
    public JAXBElement<GetPartyResponse> createGetPartyResponse(GetPartyResponse value) {
        return new JAXBElement<GetPartyResponse>(_GetPartyResponse_QNAME, GetPartyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLoginMasterFromUsername }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getLoginMasterFromUsername")
    public JAXBElement<GetLoginMasterFromUsername> createGetLoginMasterFromUsername(GetLoginMasterFromUsername value) {
        return new JAXBElement<GetLoginMasterFromUsername>(_GetLoginMasterFromUsername_QNAME, GetLoginMasterFromUsername.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVoteCountForCandidate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getVoteCountForCandidate")
    public JAXBElement<GetVoteCountForCandidate> createGetVoteCountForCandidate(GetVoteCountForCandidate value) {
        return new JAXBElement<GetVoteCountForCandidate>(_GetVoteCountForCandidate_QNAME, GetVoteCountForCandidate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllElections }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllElections")
    public JAXBElement<GetAllElections> createGetAllElections(GetAllElections value) {
        return new JAXBElement<GetAllElections>(_GetAllElections_QNAME, GetAllElections.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivateSecurityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "activateSecurityResponse")
    public JAXBElement<ActivateSecurityResponse> createActivateSecurityResponse(ActivateSecurityResponse value) {
        return new JAXBElement<ActivateSecurityResponse>(_ActivateSecurityResponse_QNAME, ActivateSecurityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchWardByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchWardByName")
    public JAXBElement<SearchWardByName> createSearchWardByName(SearchWardByName value) {
        return new JAXBElement<SearchWardByName>(_SearchWardByName_QNAME, SearchWardByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddSubWard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addSubWard")
    public JAXBElement<AddSubWard> createAddSubWard(AddSubWard value) {
        return new JAXBElement<AddSubWard>(_AddSubWard_QNAME, AddSubWard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVoteCountForWard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getVoteCountForWard")
    public JAXBElement<GetVoteCountForWard> createGetVoteCountForWard(GetVoteCountForWard value) {
        return new JAXBElement<GetVoteCountForWard>(_GetVoteCountForWard_QNAME, GetVoteCountForWard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCandidates }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllCandidates")
    public JAXBElement<GetAllCandidates> createGetAllCandidates(GetAllCandidates value) {
        return new JAXBElement<GetAllCandidates>(_GetAllCandidates_QNAME, GetAllCandidates.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCandidate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addCandidate")
    public JAXBElement<AddCandidate> createAddCandidate(AddCandidate value) {
        return new JAXBElement<AddCandidate>(_AddCandidate_QNAME, AddCandidate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWardWiseVoteCountsForZoneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getWardWiseVoteCountsForZoneResponse")
    public JAXBElement<GetWardWiseVoteCountsForZoneResponse> createGetWardWiseVoteCountsForZoneResponse(GetWardWiseVoteCountsForZoneResponse value) {
        return new JAXBElement<GetWardWiseVoteCountsForZoneResponse>(_GetWardWiseVoteCountsForZoneResponse_QNAME, GetWardWiseVoteCountsForZoneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAreaOfSubwardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAreaOfSubwardResponse")
    public JAXBElement<GetAreaOfSubwardResponse> createGetAreaOfSubwardResponse(GetAreaOfSubwardResponse value) {
        return new JAXBElement<GetAreaOfSubwardResponse>(_GetAreaOfSubwardResponse_QNAME, GetAreaOfSubwardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckForExistingPartyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "checkForExistingPartyResponse")
    public JAXBElement<CheckForExistingPartyResponse> createCheckForExistingPartyResponse(CheckForExistingPartyResponse value) {
        return new JAXBElement<CheckForExistingPartyResponse>(_CheckForExistingPartyResponse_QNAME, CheckForExistingPartyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelElection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "cancelElection")
    public JAXBElement<CancelElection> createCancelElection(CancelElection value) {
        return new JAXBElement<CancelElection>(_CancelElection_QNAME, CancelElection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddGroup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addGroup")
    public JAXBElement<AddGroup> createAddGroup(AddGroup value) {
        return new JAXBElement<AddGroup>(_AddGroup_QNAME, AddGroup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddWard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addWard")
    public JAXBElement<AddWard> createAddWard(AddWard value) {
        return new JAXBElement<AddWard>(_AddWard_QNAME, AddWard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitizensOfZoneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCitizensOfZoneResponse")
    public JAXBElement<GetCitizensOfZoneResponse> createGetCitizensOfZoneResponse(GetCitizensOfZoneResponse value) {
        return new JAXBElement<GetCitizensOfZoneResponse>(_GetCitizensOfZoneResponse_QNAME, GetCitizensOfZoneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCandidatesOfZoneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCandidatesOfZoneResponse")
    public JAXBElement<GetCandidatesOfZoneResponse> createGetCandidatesOfZoneResponse(GetCandidatesOfZoneResponse value) {
        return new JAXBElement<GetCandidatesOfZoneResponse>(_GetCandidatesOfZoneResponse_QNAME, GetCandidatesOfZoneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchPartyByPartyName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchPartyByPartyName")
    public JAXBElement<SearchPartyByPartyName> createSearchPartyByPartyName(SearchPartyByPartyName value) {
        return new JAXBElement<SearchPartyByPartyName>(_SearchPartyByPartyName_QNAME, SearchPartyByPartyName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getWardResponse")
    public JAXBElement<GetWardResponse> createGetWardResponse(GetWardResponse value) {
        return new JAXBElement<GetWardResponse>(_GetWardResponse_QNAME, GetWardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLoginMasterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getLoginMasterResponse")
    public JAXBElement<GetLoginMasterResponse> createGetLoginMasterResponse(GetLoginMasterResponse value) {
        return new JAXBElement<GetLoginMasterResponse>(_GetLoginMasterResponse_QNAME, GetLoginMasterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSecurityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getSecurityResponse")
    public JAXBElement<GetSecurityResponse> createGetSecurityResponse(GetSecurityResponse value) {
        return new JAXBElement<GetSecurityResponse>(_GetSecurityResponse_QNAME, GetSecurityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchElectionByFinalDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchElectionByFinalDate")
    public JAXBElement<SearchElectionByFinalDate> createSearchElectionByFinalDate(SearchElectionByFinalDate value) {
        return new JAXBElement<SearchElectionByFinalDate>(_SearchElectionByFinalDate_QNAME, SearchElectionByFinalDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateElection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "updateElection")
    public JAXBElement<UpdateElection> createUpdateElection(UpdateElection value) {
        return new JAXBElement<UpdateElection>(_UpdateElection_QNAME, UpdateElection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVoteCountForZone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getVoteCountForZone")
    public JAXBElement<GetVoteCountForZone> createGetVoteCountForZone(GetVoteCountForZone value) {
        return new JAXBElement<GetVoteCountForZone>(_GetVoteCountForZone_QNAME, GetVoteCountForZone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddSecurity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addSecurity")
    public JAXBElement<AddSecurity> createAddSecurity(AddSecurity value) {
        return new JAXBElement<AddSecurity>(_AddSecurity_QNAME, AddSecurity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateWardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "updateWardResponse")
    public JAXBElement<UpdateWardResponse> createUpdateWardResponse(UpdateWardResponse value) {
        return new JAXBElement<UpdateWardResponse>(_UpdateWardResponse_QNAME, UpdateWardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddWardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addWardResponse")
    public JAXBElement<AddWardResponse> createAddWardResponse(AddWardResponse value) {
        return new JAXBElement<AddWardResponse>(_AddWardResponse_QNAME, AddWardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetScheduledElections }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getScheduledElections")
    public JAXBElement<GetScheduledElections> createGetScheduledElections(GetScheduledElections value) {
        return new JAXBElement<GetScheduledElections>(_GetScheduledElections_QNAME, GetScheduledElections.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSubwardsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllSubwardsResponse")
    public JAXBElement<GetAllSubwardsResponse> createGetAllSubwardsResponse(GetAllSubwardsResponse value) {
        return new JAXBElement<GetAllSubwardsResponse>(_GetAllSubwardsResponse_QNAME, GetAllSubwardsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCandidateWiseVoteCountsForElectionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCandidateWiseVoteCountsForElectionResponse")
    public JAXBElement<GetCandidateWiseVoteCountsForElectionResponse> createGetCandidateWiseVoteCountsForElectionResponse(GetCandidateWiseVoteCountsForElectionResponse value) {
        return new JAXBElement<GetCandidateWiseVoteCountsForElectionResponse>(_GetCandidateWiseVoteCountsForElectionResponse_QNAME, GetCandidateWiseVoteCountsForElectionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchByZoneName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchByZoneName")
    public JAXBElement<SearchByZoneName> createSearchByZoneName(SearchByZoneName value) {
        return new JAXBElement<SearchByZoneName>(_SearchByZoneName_QNAME, SearchByZoneName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCandidateWiseVoteCountsForElection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCandidateWiseVoteCountsForElection")
    public JAXBElement<GetCandidateWiseVoteCountsForElection> createGetCandidateWiseVoteCountsForElection(GetCandidateWiseVoteCountsForElection value) {
        return new JAXBElement<GetCandidateWiseVoteCountsForElection>(_GetCandidateWiseVoteCountsForElection_QNAME, GetCandidateWiseVoteCountsForElection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCitiesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllCitiesResponse")
    public JAXBElement<GetAllCitiesResponse> createGetAllCitiesResponse(GetAllCitiesResponse value) {
        return new JAXBElement<GetAllCitiesResponse>(_GetAllCitiesResponse_QNAME, GetAllCitiesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllElectionTypes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllElectionTypes")
    public JAXBElement<GetAllElectionTypes> createGetAllElectionTypes(GetAllElectionTypes value) {
        return new JAXBElement<GetAllElectionTypes>(_GetAllElectionTypes_QNAME, GetAllElectionTypes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeactivateSecurityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "deactivateSecurityResponse")
    public JAXBElement<DeactivateSecurityResponse> createDeactivateSecurityResponse(DeactivateSecurityResponse value) {
        return new JAXBElement<DeactivateSecurityResponse>(_DeactivateSecurityResponse_QNAME, DeactivateSecurityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllAreasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllAreasResponse")
    public JAXBElement<GetAllAreasResponse> createGetAllAreasResponse(GetAllAreasResponse value) {
        return new JAXBElement<GetAllAreasResponse>(_GetAllAreasResponse_QNAME, GetAllAreasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteWardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "deleteWardResponse")
    public JAXBElement<DeleteWardResponse> createDeleteWardResponse(DeleteWardResponse value) {
        return new JAXBElement<DeleteWardResponse>(_DeleteWardResponse_QNAME, DeleteWardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFutureElectionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getFutureElectionsResponse")
    public JAXBElement<GetFutureElectionsResponse> createGetFutureElectionsResponse(GetFutureElectionsResponse value) {
        return new JAXBElement<GetFutureElectionsResponse>(_GetFutureElectionsResponse_QNAME, GetFutureElectionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchByAreaNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchByAreaNameResponse")
    public JAXBElement<SearchByAreaNameResponse> createSearchByAreaNameResponse(SearchByAreaNameResponse value) {
        return new JAXBElement<SearchByAreaNameResponse>(_SearchByAreaNameResponse_QNAME, SearchByAreaNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateSubWard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "updateSubWard")
    public JAXBElement<UpdateSubWard> createUpdateSubWard(UpdateSubWard value) {
        return new JAXBElement<UpdateSubWard>(_UpdateSubWard_QNAME, UpdateSubWard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCandidatesOfSubwardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCandidatesOfSubwardResponse")
    public JAXBElement<GetCandidatesOfSubwardResponse> createGetCandidatesOfSubwardResponse(GetCandidatesOfSubwardResponse value) {
        return new JAXBElement<GetCandidatesOfSubwardResponse>(_GetCandidatesOfSubwardResponse_QNAME, GetCandidatesOfSubwardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePartyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "updatePartyResponse")
    public JAXBElement<UpdatePartyResponse> createUpdatePartyResponse(UpdatePartyResponse value) {
        return new JAXBElement<UpdatePartyResponse>(_UpdatePartyResponse_QNAME, UpdatePartyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivateSecurity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "activateSecurity")
    public JAXBElement<ActivateSecurity> createActivateSecurity(ActivateSecurity value) {
        return new JAXBElement<ActivateSecurity>(_ActivateSecurity_QNAME, ActivateSecurity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWardsOfZoneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getWardsOfZoneResponse")
    public JAXBElement<GetWardsOfZoneResponse> createGetWardsOfZoneResponse(GetWardsOfZoneResponse value) {
        return new JAXBElement<GetWardsOfZoneResponse>(_GetWardsOfZoneResponse_QNAME, GetWardsOfZoneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCitizenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "updateCitizenResponse")
    public JAXBElement<UpdateCitizenResponse> createUpdateCitizenResponse(UpdateCitizenResponse value) {
        return new JAXBElement<UpdateCitizenResponse>(_UpdateCitizenResponse_QNAME, UpdateCitizenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateZoneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "updateZoneResponse")
    public JAXBElement<UpdateZoneResponse> createUpdateZoneResponse(UpdateZoneResponse value) {
        return new JAXBElement<UpdateZoneResponse>(_UpdateZoneResponse_QNAME, UpdateZoneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVoteCountForAreaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getVoteCountForAreaResponse")
    public JAXBElement<GetVoteCountForAreaResponse> createGetVoteCountForAreaResponse(GetVoteCountForAreaResponse value) {
        return new JAXBElement<GetVoteCountForAreaResponse>(_GetVoteCountForAreaResponse_QNAME, GetVoteCountForAreaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitizenMasterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCitizenMasterResponse")
    public JAXBElement<GetCitizenMasterResponse> createGetCitizenMasterResponse(GetCitizenMasterResponse value) {
        return new JAXBElement<GetCitizenMasterResponse>(_GetCitizenMasterResponse_QNAME, GetCitizenMasterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVoteCountsForElection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getVoteCountsForElection")
    public JAXBElement<GetVoteCountsForElection> createGetVoteCountsForElection(GetVoteCountsForElection value) {
        return new JAXBElement<GetVoteCountsForElection>(_GetVoteCountsForElection_QNAME, GetVoteCountsForElection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitizensOfArea }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCitizensOfArea")
    public JAXBElement<GetCitizensOfArea> createGetCitizensOfArea(GetCitizensOfArea value) {
        return new JAXBElement<GetCitizensOfArea>(_GetCitizensOfArea_QNAME, GetCitizensOfArea.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllWardsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllWardsResponse")
    public JAXBElement<GetAllWardsResponse> createGetAllWardsResponse(GetAllWardsResponse value) {
        return new JAXBElement<GetAllWardsResponse>(_GetAllWardsResponse_QNAME, GetAllWardsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCitizenByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchCitizenByIdResponse")
    public JAXBElement<SearchCitizenByIdResponse> createSearchCitizenByIdResponse(SearchCitizenByIdResponse value) {
        return new JAXBElement<SearchCitizenByIdResponse>(_SearchCitizenByIdResponse_QNAME, SearchCitizenByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActiveSecurityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getActiveSecurityResponse")
    public JAXBElement<GetActiveSecurityResponse> createGetActiveSecurityResponse(GetActiveSecurityResponse value) {
        return new JAXBElement<GetActiveSecurityResponse>(_GetActiveSecurityResponse_QNAME, GetActiveSecurityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVoteCountForPartyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getVoteCountForPartyResponse")
    public JAXBElement<GetVoteCountForPartyResponse> createGetVoteCountForPartyResponse(GetVoteCountForPartyResponse value) {
        return new JAXBElement<GetVoteCountForPartyResponse>(_GetVoteCountForPartyResponse_QNAME, GetVoteCountForPartyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetZoneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getZoneResponse")
    public JAXBElement<GetZoneResponse> createGetZoneResponse(GetZoneResponse value) {
        return new JAXBElement<GetZoneResponse>(_GetZoneResponse_QNAME, GetZoneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCitizenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "deleteCitizenResponse")
    public JAXBElement<DeleteCitizenResponse> createDeleteCitizenResponse(DeleteCitizenResponse value) {
        return new JAXBElement<DeleteCitizenResponse>(_DeleteCitizenResponse_QNAME, DeleteCitizenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCandidatesOfAreaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCandidatesOfAreaResponse")
    public JAXBElement<GetCandidatesOfAreaResponse> createGetCandidatesOfAreaResponse(GetCandidatesOfAreaResponse value) {
        return new JAXBElement<GetCandidatesOfAreaResponse>(_GetCandidatesOfAreaResponse_QNAME, GetCandidatesOfAreaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddSubWardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addSubWardResponse")
    public JAXBElement<AddSubWardResponse> createAddSubWardResponse(AddSubWardResponse value) {
        return new JAXBElement<AddSubWardResponse>(_AddSubWardResponse_QNAME, AddSubWardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllActiveCandidates }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllActiveCandidates")
    public JAXBElement<GetAllActiveCandidates> createGetAllActiveCandidates(GetAllActiveCandidates value) {
        return new JAXBElement<GetAllActiveCandidates>(_GetAllActiveCandidates_QNAME, GetAllActiveCandidates.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchBySubWardName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchBySubWardName")
    public JAXBElement<SearchBySubWardName> createSearchBySubWardName(SearchBySubWardName value) {
        return new JAXBElement<SearchBySubWardName>(_SearchBySubWardName_QNAME, SearchBySubWardName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCandidateByLastName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchCandidateByLastName")
    public JAXBElement<SearchCandidateByLastName> createSearchCandidateByLastName(SearchCandidateByLastName value) {
        return new JAXBElement<SearchCandidateByLastName>(_SearchCandidateByLastName_QNAME, SearchCandidateByLastName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSecurityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllSecurityResponse")
    public JAXBElement<GetAllSecurityResponse> createGetAllSecurityResponse(GetAllSecurityResponse value) {
        return new JAXBElement<GetAllSecurityResponse>(_GetAllSecurityResponse_QNAME, GetAllSecurityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVoteCountForZoneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getVoteCountForZoneResponse")
    public JAXBElement<GetVoteCountForZoneResponse> createGetVoteCountForZoneResponse(GetVoteCountForZoneResponse value) {
        return new JAXBElement<GetVoteCountForZoneResponse>(_GetVoteCountForZoneResponse_QNAME, GetVoteCountForZoneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ScheduleElectionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "scheduleElectionResponse")
    public JAXBElement<ScheduleElectionResponse> createScheduleElectionResponse(ScheduleElectionResponse value) {
        return new JAXBElement<ScheduleElectionResponse>(_ScheduleElectionResponse_QNAME, ScheduleElectionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateElectionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "updateElectionResponse")
    public JAXBElement<UpdateElectionResponse> createUpdateElectionResponse(UpdateElectionResponse value) {
        return new JAXBElement<UpdateElectionResponse>(_UpdateElectionResponse_QNAME, UpdateElectionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchBySubWardNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "searchBySubWardNameResponse")
    public JAXBElement<SearchBySubWardNameResponse> createSearchBySubWardNameResponse(SearchBySubWardNameResponse value) {
        return new JAXBElement<SearchBySubWardNameResponse>(_SearchBySubWardNameResponse_QNAME, SearchBySubWardNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitizensOfAreaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCitizensOfAreaResponse")
    public JAXBElement<GetCitizensOfAreaResponse> createGetCitizensOfAreaResponse(GetCitizensOfAreaResponse value) {
        return new JAXBElement<GetCitizensOfAreaResponse>(_GetCitizensOfAreaResponse_QNAME, GetCitizensOfAreaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "citizenMasterList", scope = SubWardMaster.class)
    @XmlIDREF
    public JAXBElement<Object> createSubWardMasterCitizenMasterList(Object value) {
        return new JAXBElement<Object>(_SubWardMasterCitizenMasterList_QNAME, Object.class, SubWardMaster.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "voteMasterList", scope = SubWardMaster.class)
    @XmlIDREF
    public JAXBElement<Object> createSubWardMasterVoteMasterList(Object value) {
        return new JAXBElement<Object>(_SubWardMasterVoteMasterList_QNAME, Object.class, SubWardMaster.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "candidateMasterList", scope = SubWardMaster.class)
    @XmlIDREF
    public JAXBElement<Object> createSubWardMasterCandidateMasterList(Object value) {
        return new JAXBElement<Object>(_SubWardMasterCandidateMasterList_QNAME, Object.class, SubWardMaster.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "areaMasterList", scope = SubWardMaster.class)
    @XmlIDREF
    public JAXBElement<Object> createSubWardMasterAreaMasterList(Object value) {
        return new JAXBElement<Object>(_SubWardMasterAreaMasterList_QNAME, Object.class, SubWardMaster.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "voteMasterList", scope = CandidateMaster.class)
    @XmlIDREF
    public JAXBElement<Object> createCandidateMasterVoteMasterList(Object value) {
        return new JAXBElement<Object>(_SubWardMasterVoteMasterList_QNAME, Object.class, CandidateMaster.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "electionMasterList", scope = CandidateMaster.class)
    @XmlIDREF
    public JAXBElement<Object> createCandidateMasterElectionMasterList(Object value) {
        return new JAXBElement<Object>(_CandidateMasterElectionMasterList_QNAME, Object.class, CandidateMaster.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "citizenMasterList", scope = ZoneMaster.class)
    @XmlIDREF
    public JAXBElement<Object> createZoneMasterCitizenMasterList(Object value) {
        return new JAXBElement<Object>(_SubWardMasterCitizenMasterList_QNAME, Object.class, ZoneMaster.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "voteMasterList", scope = ZoneMaster.class)
    @XmlIDREF
    public JAXBElement<Object> createZoneMasterVoteMasterList(Object value) {
        return new JAXBElement<Object>(_SubWardMasterVoteMasterList_QNAME, Object.class, ZoneMaster.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "candidateMasterList", scope = ZoneMaster.class)
    @XmlIDREF
    public JAXBElement<Object> createZoneMasterCandidateMasterList(Object value) {
        return new JAXBElement<Object>(_SubWardMasterCandidateMasterList_QNAME, Object.class, ZoneMaster.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "wardMasterList", scope = ZoneMaster.class)
    @XmlIDREF
    public JAXBElement<Object> createZoneMasterWardMasterList(Object value) {
        return new JAXBElement<Object>(_ZoneMasterWardMasterList_QNAME, Object.class, ZoneMaster.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "citizenMasterList", scope = AreaMaster.class)
    @XmlIDREF
    public JAXBElement<Object> createAreaMasterCitizenMasterList(Object value) {
        return new JAXBElement<Object>(_SubWardMasterCitizenMasterList_QNAME, Object.class, AreaMaster.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "voteMasterList", scope = AreaMaster.class)
    @XmlIDREF
    public JAXBElement<Object> createAreaMasterVoteMasterList(Object value) {
        return new JAXBElement<Object>(_SubWardMasterVoteMasterList_QNAME, Object.class, AreaMaster.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "candidateMasterList", scope = AreaMaster.class)
    @XmlIDREF
    public JAXBElement<Object> createAreaMasterCandidateMasterList(Object value) {
        return new JAXBElement<Object>(_SubWardMasterCandidateMasterList_QNAME, Object.class, AreaMaster.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "electionMasterList", scope = ElectionTypeMaster.class)
    @XmlIDREF
    public JAXBElement<Object> createElectionTypeMasterElectionMasterList(Object value) {
        return new JAXBElement<Object>(_CandidateMasterElectionMasterList_QNAME, Object.class, ElectionTypeMaster.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "voteMasterList", scope = ElectionMaster.class)
    @XmlIDREF
    public JAXBElement<Object> createElectionMasterVoteMasterList(Object value) {
        return new JAXBElement<Object>(_SubWardMasterVoteMasterList_QNAME, Object.class, ElectionMaster.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "candidateMasterList", scope = ElectionMaster.class)
    @XmlIDREF
    public JAXBElement<Object> createElectionMasterCandidateMasterList(Object value) {
        return new JAXBElement<Object>(_SubWardMasterCandidateMasterList_QNAME, Object.class, ElectionMaster.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "userGroupMasterList", scope = GroupMaster.class)
    @XmlIDREF
    public JAXBElement<Object> createGroupMasterUserGroupMasterList(Object value) {
        return new JAXBElement<Object>(_GroupMasterUserGroupMasterList_QNAME, Object.class, GroupMaster.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "userGroupMasterList", scope = LoginMaster.class)
    @XmlIDREF
    public JAXBElement<Object> createLoginMasterUserGroupMasterList(Object value) {
        return new JAXBElement<Object>(_GroupMasterUserGroupMasterList_QNAME, Object.class, LoginMaster.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "candidateMasterList", scope = PartyMaster.class)
    @XmlIDREF
    public JAXBElement<Object> createPartyMasterCandidateMasterList(Object value) {
        return new JAXBElement<Object>(_SubWardMasterCandidateMasterList_QNAME, Object.class, PartyMaster.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "zoneMasterList", scope = CityMaster.class)
    @XmlIDREF
    public JAXBElement<Object> createCityMasterZoneMasterList(Object value) {
        return new JAXBElement<Object>(_CityMasterZoneMasterList_QNAME, Object.class, CityMaster.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "citizenMasterList", scope = WardMaster.class)
    @XmlIDREF
    public JAXBElement<Object> createWardMasterCitizenMasterList(Object value) {
        return new JAXBElement<Object>(_SubWardMasterCitizenMasterList_QNAME, Object.class, WardMaster.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "voteMasterList", scope = WardMaster.class)
    @XmlIDREF
    public JAXBElement<Object> createWardMasterVoteMasterList(Object value) {
        return new JAXBElement<Object>(_SubWardMasterVoteMasterList_QNAME, Object.class, WardMaster.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "candidateMasterList", scope = WardMaster.class)
    @XmlIDREF
    public JAXBElement<Object> createWardMasterCandidateMasterList(Object value) {
        return new JAXBElement<Object>(_SubWardMasterCandidateMasterList_QNAME, Object.class, WardMaster.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "subWardMasterList", scope = WardMaster.class)
    @XmlIDREF
    public JAXBElement<Object> createWardMasterSubWardMasterList(Object value) {
        return new JAXBElement<Object>(_WardMasterSubWardMasterList_QNAME, Object.class, WardMaster.class, value);
    }

}

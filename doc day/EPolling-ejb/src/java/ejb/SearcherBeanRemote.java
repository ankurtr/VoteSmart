/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.AreaMaster;
import entities.CandidateMaster;
import entities.CitizenMaster;
import entities.ElectionMaster;
import entities.PartyMaster;
import entities.SubWardMaster;
import entities.WardMaster;
import entities.ZoneMaster;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author ankur
 */
@Remote
public interface SearcherBeanRemote {

    List<WardMaster> searchWardByName(String wardName,Integer maxResults);

    List<ZoneMaster> searchByZoneName(String zoneName,Integer maxResults);

    List<SubWardMaster> searchBySubWardName(String subwardName,Integer maxResults);

    List<AreaMaster> searchByAreaName(String areaName,Integer maxResults);

    List<CandidateMaster> searchCandidateByFirstName(String firstName,Integer maxResults);

    List<CandidateMaster> searchCandidateByLastName(String lastName,Integer maxResults);

    List<CandidateMaster> searchCandidateByDateOfBirthRange(Date fromDate, Date toDate,Integer maxResults);

    List<CandidateMaster> searchCandidateByActiveStatus(boolean isActive,Integer maxResults);

    List<CitizenMaster> searchCitizenById(Integer citizenId);

    List<ElectionMaster> searchElectionByName(String electionName,Integer maxResults);

    ElectionMaster searchElectionByFinalDate(Date date,Integer maxResults);

    List<ElectionMaster> searchElectionByDateRange(Date fromDate, Date toDate,Integer maxResults);

    List<ElectionMaster> searchElectionByElectionType(Integer electionTypeId,Integer maxResults);

    List<CitizenMaster> searchCitizenByUsername(String username,Integer maxResults);

    List<PartyMaster> searchPartyByPartyName(String partyName,Integer maxResults);

    List<CitizenMaster> searchCitizenByName(String citizenName,Integer maxResults);
}

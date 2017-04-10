/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import javax.ejb.Remote;
import misc.XmlHashMapIL;

/**
 *
 * @author ankur
 */
@Remote
public interface ResultBeanRemote {
    Long getVoteCountForCandidate(Integer candidateId,Integer electionId);

    Long getVoteCountsForElection(Integer electionId);

    Long getVoteCountForZone(Integer zoneId,Integer electionId);

    Long getVoteCountForWard(Integer wardId, Integer electionId);

    Long getVoteCountForSubward(Integer subwardId, Integer electionId);

    Long getVoteCountForArea(Integer areaId,Integer electionId);

    Long getVoteCountForParty(Integer partyId, Integer electionId);

    XmlHashMapIL getCandidateWiseVoteCountsForElection(Integer electionId);

    XmlHashMapIL getCandidateWiseVoteCountsForWard(Integer electionId, Integer wardId);

    XmlHashMapIL getWardWiseVoteCountsForZone(Integer electionId,Integer zoneId);
    
}

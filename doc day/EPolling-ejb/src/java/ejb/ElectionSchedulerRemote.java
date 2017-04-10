/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.ElectionMaster;
import entities.ElectionTypeMaster;
import java.util.List;
import javax.ejb.Remote;
import misc.XmlHashMapII;

/**
 *
 * @author milan
 */
@Remote
public interface ElectionSchedulerRemote {

    boolean addElection(ElectionMaster elm, Integer electionTypeId,List<Integer> candidateIds);

    boolean scheduleElection(Integer electionID);

    boolean cancelElection(Integer electionID);

    boolean updateElection(ElectionMaster elm,Integer electionTypeId,List<Integer> candidateIds);

    List<ElectionMaster> getFutureElections();
    
    List<ElectionMaster> getPastElections();

    List<ElectionMaster> getAllElections();

    List<ElectionMaster> getScheduledElections();

    ElectionMaster getElection(Integer electionId);

    List<ElectionTypeMaster> getAllElectionTypes();
    
    Integer getActiveElectionId();

//    boolean setCandidatesActive(List<Integer> candidateIds);
}

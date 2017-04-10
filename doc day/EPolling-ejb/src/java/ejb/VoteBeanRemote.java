/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;
import misc.XmlHashMapII;

/**
 *
 * @author root
 */
@Remote
public interface VoteBeanRemote {

    boolean castVote(Integer citizenId, List<Integer> candidateIds);

    boolean isValidToVote(Integer citizenId);

    XmlHashMapII getActiveCandidatesWithPartyId(Integer wardId);

    void sayHello(String message);
}

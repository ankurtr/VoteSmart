/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package comparators;

import java.util.Comparator;
import service.CandidateMaster;

/**
 *
 * @author ankur
 */
public class CandidateLastNameAsc  implements Comparator<CandidateMaster> {

    @Override
    public int compare(CandidateMaster o1, CandidateMaster o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }

}
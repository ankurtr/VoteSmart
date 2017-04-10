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
public class CandidateLastNameDesc  implements Comparator<CandidateMaster> {

    @Override
    public int compare(CandidateMaster o1, CandidateMaster o2) {
        return o2.getLastName().compareTo(o1.getLastName());
    }

}
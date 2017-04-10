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
public class CandidateFirstNameAsc implements Comparator<CandidateMaster> {

    @Override
    public int compare(CandidateMaster o1, CandidateMaster o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }

}

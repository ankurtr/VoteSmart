/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package comparators;

import java.util.Comparator;
import service.PartyMaster;

/**
 *
 * @author ankur
 */
public class PartyNameAsc implements Comparator<PartyMaster>{

    @Override
    public int compare(PartyMaster o1, PartyMaster o2) {
        return o1.getPartyName().compareTo(o2.getPartyName());
    }

}

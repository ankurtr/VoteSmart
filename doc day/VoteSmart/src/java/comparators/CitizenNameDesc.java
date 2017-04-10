/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package comparators;

import java.util.Comparator;
import service.CitizenMaster;

/**
 *
 * @author root
 */
public class CitizenNameDesc implements Comparator<CitizenMaster> {

    @Override
    public int compare(CitizenMaster o1, CitizenMaster o2) {
        return o2.getName().compareTo(o1.getName());
    }

}

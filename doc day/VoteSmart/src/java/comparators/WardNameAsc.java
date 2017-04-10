/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package comparators;

import java.util.Comparator;
import service.WardMaster;

/**
 *
 * @author ankur
 */
public class WardNameAsc implements Comparator<WardMaster>{

    @Override
    public int compare(WardMaster o1, WardMaster o2) {
        return o1.getWardName().compareTo(o2.getWardName());
    }

}

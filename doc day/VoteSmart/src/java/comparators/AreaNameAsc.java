/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package comparators;

import java.util.Comparator;
import service.AreaMaster;

/**
 *
 * @author ankur
 */
public class AreaNameAsc implements Comparator<AreaMaster> {

    @Override
    public int compare(AreaMaster o1, AreaMaster o2) {
        return o1.getAreaName().compareTo(o2.getAreaName());
    }

}

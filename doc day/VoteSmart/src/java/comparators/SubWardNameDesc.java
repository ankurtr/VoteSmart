/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package comparators;

import java.util.Comparator;
import service.SubWardMaster;

/**
 *
 * @author ankur
 */
public class SubWardNameDesc implements Comparator<SubWardMaster> {

    @Override
    public int compare(SubWardMaster o1, SubWardMaster o2) {
        return o2.getSubWardName().compareTo(o1.getSubWardName());
    }

}
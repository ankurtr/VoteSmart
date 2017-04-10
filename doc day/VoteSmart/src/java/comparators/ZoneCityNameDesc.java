/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package comparators;

import java.util.Comparator;
import service.ZoneMaster;

/**
 *
 * @author ankur
 */
public class ZoneCityNameDesc implements Comparator<ZoneMaster> {

    @Override
    public int compare(ZoneMaster o1, ZoneMaster o2) {
        return o2.getCityMaster().getCityName().compareTo(o1.getCityMaster().getCityName());
    }

}

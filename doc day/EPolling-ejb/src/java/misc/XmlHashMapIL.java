/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

import adapters.XmlHashMapAdapterIL;
import java.util.HashMap;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author ankur
 */
public class XmlHashMapIL {

    private HashMap<Integer, Long> map;

    @XmlJavaTypeAdapter(XmlHashMapAdapterIL.class)
    public HashMap<Integer, Long> getMap() {
        return map;
    }

    public void setMap(HashMap<Integer, Long> map) {
        this.map = map;
    }
}

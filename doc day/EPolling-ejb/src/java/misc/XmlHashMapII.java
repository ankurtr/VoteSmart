/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

import adapters.XmlHashMapAdapterII;
import java.util.HashMap;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Ankur Trapasiya
 *
 * This class is intended to be working as HashMap..  Here <A,T> means the key and value types that can be
 * given to your hash map. This is necessary because of Adapter's working purpose..
 */
public class XmlHashMapII {

    private HashMap<Integer,Integer> map;

    @XmlJavaTypeAdapter(XmlHashMapAdapterII.class)
    public HashMap<Integer,Integer> getMap() {
        return map;
    }

    public void setMap(HashMap<Integer,Integer> map) {
        this.map = map;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adapters;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import misc.XmlHashMapHelperII;
import misc.XmlHashMapWrapperII;

/**
 *
 * @author root
 */
public class XmlHashMapAdapterII extends XmlAdapter<XmlHashMapWrapperII, HashMap<Integer, Integer>> {

    @Override
    public HashMap<Integer, Integer> unmarshal(XmlHashMapWrapperII v) throws Exception {
        try {
            HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
            List<XmlHashMapHelperII> list = v.getListOfKeyValuePairs();
            if (list != null) {
                Iterator<XmlHashMapHelperII> iterator = list.iterator();
                while (iterator.hasNext()) {
                    XmlHashMapHelperII helper = iterator.next();
                    map.put(helper.key, helper.value);
                }
                return map;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getClass());
        }
        return null;
    }

    @Override
    public XmlHashMapWrapperII marshal(HashMap<Integer, Integer> v) throws Exception {
        try {
            //JOptionPane.showMessageDialog(null, "marshal coming");
            XmlHashMapWrapperII var = new XmlHashMapWrapperII();
            List<XmlHashMapHelperII> list = new Vector<XmlHashMapHelperII>();
            for (Map.Entry<Integer, Integer> m : v.entrySet()) {
                XmlHashMapHelperII helper = new XmlHashMapHelperII(m.getKey(), m.getValue());
                list.add(helper);
            }
            var.setListOfKeyValuePairs(list);
            return var;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getClass());
        }
        return null;
    }
}

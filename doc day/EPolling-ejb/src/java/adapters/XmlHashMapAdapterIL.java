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
import misc.XmlHashMapHelperIL;
import misc.XmlHashMapWrapperIL;

/**
 *
 * @author ankur
 */
public class XmlHashMapAdapterIL extends XmlAdapter<XmlHashMapWrapperIL, HashMap<Integer, Long>> {

    @Override
    public HashMap<Integer, Long> unmarshal(XmlHashMapWrapperIL v) throws Exception {
        try {
            HashMap<Integer, Long> map = new HashMap<Integer, Long>();
            List<XmlHashMapHelperIL> list = v.getListOfKeyValuePairs();
            if (list != null) {
                Iterator<XmlHashMapHelperIL> iterator = list.iterator();
                while (iterator.hasNext()) {
                    XmlHashMapHelperIL helper = iterator.next();
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
    public XmlHashMapWrapperIL marshal(HashMap<Integer, Long> v) throws Exception {
        try {
            //JOptionPane.showMessageDialog(null, "marshal coming");
            XmlHashMapWrapperIL var = new XmlHashMapWrapperIL();
            List<XmlHashMapHelperIL> list = new Vector<XmlHashMapHelperIL>();
            for (Map.Entry<Integer, Long> m : v.entrySet()) {
                XmlHashMapHelperIL helper = new XmlHashMapHelperIL(m.getKey(), m.getValue());
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

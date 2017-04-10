/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author root
 */
public class IntegerAdapter extends XmlAdapter<String, Integer>{

    @Override
    public Integer unmarshal(String v) throws Exception {
        return Integer.valueOf(v);
    }

    @Override
    public String marshal(Integer v) throws Exception {
        return v.toString();
    }

}

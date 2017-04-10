/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adapters;

import entities.UserGroupMasterPK;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author root
 */
public class UserGroupPKAdapter extends XmlAdapter<String, UserGroupMasterPK> {

    @Override
    public UserGroupMasterPK unmarshal(String v) throws Exception {
        UserGroupMasterPK ugm = new UserGroupMasterPK();
        ugm.setUserId(Integer.parseInt(v.substring(v.indexOf("="), v.indexOf(","))));
        ugm.setGroupName(v.substring(v.indexOf("=", v.indexOf(",")), v.indexOf("]")));
        return ugm;
    }

    @Override
    public String marshal(UserGroupMasterPK v) throws Exception {
        //JOptionPane.showMessageDialog(null, v.toString());
        return v.toString();
    }
}

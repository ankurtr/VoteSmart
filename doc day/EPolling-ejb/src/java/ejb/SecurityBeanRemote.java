/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entities.GroupMaster;
import entities.SecurityMaster;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author root
 */
@Remote
public interface SecurityBeanRemote {

    boolean addSecurity(SecurityMaster sm);

    boolean activateSecurity(Integer securityId);

    boolean deactivateSecurity(Integer securityId);

    boolean addGroup(GroupMaster gm);

    SecurityMaster getActiveSecurity();

    List<SecurityMaster> getAllSecurity();

    public SecurityMaster getSecurity(Integer securityId);
    
}

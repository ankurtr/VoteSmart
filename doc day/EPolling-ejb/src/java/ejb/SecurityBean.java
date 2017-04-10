/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.GroupMaster;
import entities.SecurityMaster;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author root
 */
@Stateless
@DeclareRoles({"admin", "citizen"})
@RolesAllowed({"admin"})
public class SecurityBean implements SecurityBeanRemote {

    @PersistenceContext(unitName = "EPolling-ejbPU")
    EntityManager em;
    SecurityMaster security;
    Logger logger;

    @PostConstruct
    public void initialise() {
        logger = Logger.getLogger(this.getClass());
        logger.setLevel(Level.WARN);
    }

    @Override
    public boolean addSecurity(SecurityMaster sm) {
        boolean result = false;
        try {
            em.persist(security);
            em.flush();
            result = true;
        } catch (Exception e) {
            logger.error("**SecurityBean.addSecurity**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    @Override
    public boolean activateSecurity(Integer securityId) {
        boolean result = false;
        try {
            security = em.find(SecurityMaster.class, securityId);
            if (security != null) {
                security.setIsActive(true);
                Query query = em.createNamedQuery("update SecurityMaster s set s.isActive=false where s.isActive=true");
                query.executeUpdate();
                em.merge(security);
                result = true;
            }
        } catch (Exception e) {
            logger.error("**SecurityBean.activateSecurity**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    @Override
    public boolean deactivateSecurity(Integer securityId) {
        boolean result = false;
        try {
            security = em.find(SecurityMaster.class, securityId);
            if (security != null) {
                security.setIsActive(false);
                em.merge(security);
                result = true;
            }
        } catch (Exception e) {
            logger.error("**SecurityBean.deactivateSecurity**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    @Override
    public boolean addGroup(GroupMaster gm) {
        boolean result = false;
        try {
            em.persist(gm);
            result = true;
        } catch (Exception e) {
            logger.error("**SecurityBean.addGroup**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    @Override
    @PermitAll
    public SecurityMaster getActiveSecurity() {
        SecurityMaster sm = null;
        try {
            sm = (SecurityMaster) em.createNamedQuery("SecurityMaster.findByIsActive").setParameter("isActive", true).getSingleResult();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getClass());
            logger.error("**SecurityBean.getActiveSecurity**" + e.getClass() + " " + e.getMessage());
        }
        return sm;
    }

    @Override
    public List<SecurityMaster> getAllSecurity() {
        List<SecurityMaster> listAllSecurity = null;
        try {
            listAllSecurity = em.createNamedQuery("SecurityMaster.findAll").getResultList();
        } catch (Exception e) {
            logger.error("**SecurityBean.getAllSecurity**" + e.getClass() + " " + e.getMessage());
        }
        return listAllSecurity;
    }

    @Override
    public SecurityMaster getSecurity(Integer securityId) {
        try {
            security = em.find(SecurityMaster.class, securityId);
            return security;
        } catch (Exception e) {
            logger.error("**SecurityBean.getSecurity**" + e.getClass() + " " + e.getMessage());
        }
        return null;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

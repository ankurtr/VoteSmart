/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.AreaMaster;
import entities.CandidateMaster;
import entities.CitizenMaster;
import entities.ElectionMaster;
import entities.PartyMaster;
import entities.SubWardMaster;
import entities.WardMaster;
import entities.ZoneMaster;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.swing.JOptionPane;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author ankur
 */
@Stateless
@DeclareRoles({"admin","citizen"})
@RolesAllowed({"admin"})
public class SearcherBean implements SearcherBeanRemote {

    @PersistenceContext(unitName = "EPolling-ejbPU")
    EntityManager em;
    Logger logger;

    @PostConstruct
    public void initialise() {
        logger = Logger.getLogger(this.getClass());
        logger.setLevel(Level.WARN);
    }

    @Override
    public List<ZoneMaster> searchByZoneName(String zoneName, Integer maxResults) {
        List<ZoneMaster> list = null;
        try {
            //JOptionPane.showMessageDialog(null, "zone");
            //Query q=em.createNamedQuery("ZoneMaster.findAll");
           // JOptionPane.showMessageDialog(null, q.getResultList());            
            Query query = em.createNamedQuery("ZoneMaster.findByZoneName");
            query.setParameter("zoneName", '%' + zoneName );
            //query.setMaxResults(maxResults);
            list = query.getResultList();
        } catch (Exception e) {
            logger.error("**SearcherBean.searchByZoneName**" + e.getClass() + " " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<WardMaster> searchWardByName(String wardName, Integer maxResults) {
        List<WardMaster> list = null;
        try {
            Query query = em.createNamedQuery("WardMaster.findByWardName");
            query.setParameter("wardName", '%' + wardName);
            //query.setMaxResults(maxResults);
            list = query.getResultList();
        } catch (Exception e) {
            logger.error("**SearcherBean.searchWardByName**" + e.getClass() + " " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<SubWardMaster> searchBySubWardName(String subwardName, Integer maxResults) {
        List<SubWardMaster> list = null;
        try {
            Query query = em.createNamedQuery("SubWardMaster.findBySubWardName");
            query.setParameter("subWardName", '%' + subwardName);
            //query.setMaxResults(maxResults);
            list = query.getResultList();
        } catch (Exception e) {
            logger.error("**SearcherBean.searchBySubWardName**" + e.getClass() + " " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<AreaMaster> searchByAreaName(String areaName, Integer maxResults) {
        List<AreaMaster> list = null;
        try {
            Query query = em.createNamedQuery("AreaMaster.findByAreaName");
            query.setParameter("areaName", '%' + areaName );
            //query.setMaxResults(maxResults);
            list = query.getResultList();
        } catch (Exception e) {
            logger.error("**SearcherBean.searchByAreaName**" + e.getClass() + " " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<CandidateMaster> searchCandidateByFirstName(String firstName, Integer maxResults) {
        List<CandidateMaster> list = null;
        try {
            Query query = em.createNamedQuery("CandidateMaster.findByFirstName");
            query.setParameter("firstName", '%' + firstName);
            //query.setMaxResults(maxResults);
            list = query.getResultList();
        } catch (Exception e) {
            logger.error("**SearcherBean.searchCandidateByFirstName**" + e.getClass() + " " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<CandidateMaster> searchCandidateByLastName(String lastName, Integer maxResults) {
        List<CandidateMaster> list = null;
        try {
            Query query = em.createNamedQuery("CandidateMaster.findByLastName");
            query.setParameter("lastName", '%' + lastName );
            //query.setMaxResults(maxResults);
            list = query.getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            logger.error("**SearcherBean.searchCandidateByLastName**" + e.getClass() + " " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<CandidateMaster> searchCandidateByDateOfBirthRange(Date fromDate, Date toDate, Integer maxResults) {
        List<CandidateMaster> list = null;
        try {
            Query query = em.createNativeQuery("select * from CandidateMaster where DateOfBirth >=" + fromDate + " AND DateOfBirth <=" + toDate,CandidateMaster.class);
            //query.setMaxResults(maxResults);
            list = query.getResultList();
            //JOptionPane.showMessageDialog(null, list);
        } catch (Exception e) {
            logger.error("**SearcherBean.searchCandidateByDateOfBirthRange**" + e.getClass() + " " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<CandidateMaster> searchCandidateByActiveStatus(boolean isActive, Integer maxResults) {
        List<CandidateMaster> list = null;
        try {
            Query query = em.createNamedQuery("CandidateMaster.findByIsActive");
            query.setParameter("isActive", isActive);
            query.setMaxResults(maxResults);
            list = query.getResultList();
        } catch (Exception e) {
            logger.error("**SearcherBean.searchCandidateByActiveStatus**" + e.getClass() + " " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<CitizenMaster> searchCitizenById(Integer citizenId) {
        List<CitizenMaster> list = null;
        try {
            Query query = em.createNamedQuery("CitizenMaster.findByUserId");
            query.setParameter("userId", citizenId);            
            list = query.getResultList();
        } catch (Exception e) {
            logger.error("**SearcherBean.searchCitizenById**" + e.getClass() + " " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<CitizenMaster> searchCitizenByUsername(String username, Integer maxResults) {
        List<CitizenMaster> list = null;
        try {
            Query query = em.createNamedQuery("LoginMaster.findByUsername");
            query.setParameter("username", '%' + username);
            //query.setMaxResults(maxResults);
            list = query.getResultList();
        } catch (Exception e) {
            logger.error("**SearcherBean.searchCitizenByUsername**" + e.getClass() + " " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<ElectionMaster> searchElectionByName(String electionName, Integer maxResults) {
        List<ElectionMaster> list = null;
        try {
            Query query = em.createNamedQuery("ElectionMaster.findByName");
            query.setParameter("name", '%' + electionName);
            //query.setMaxResults(maxResults);
            list = query.getResultList();
        } catch (Exception e) {
            logger.error("**SearcherBean.searchElectionByName**" + e.getClass() + " " + e.getMessage());
        }
        return list;
    }

    @Override
    public ElectionMaster searchElectionByFinalDate(Date date, Integer maxResults) {
        ElectionMaster elm = null;
        try {
            Query query = em.createNamedQuery("ElectionMaster.findByFinalDate");
            query.setParameter("finalDate", date, TemporalType.DATE);
            //query.setMaxResults(maxResults);
            elm = (ElectionMaster) query.getSingleResult();
        } catch (Exception e) {
            logger.error("**SearcherBean.searchElectionByFinalDate**" + e.getClass() + " " + e.getMessage());
        }
        return elm;
    }

    @Override
    public List<ElectionMaster> searchElectionByDateRange(Date fromDate, Date toDate, Integer maxResults) {
        List<ElectionMaster> list = null;
        try {
            Query query = em.createNativeQuery("select * from ElectionMaster where FinalDate >=" + fromDate + " AND FinalDate <=" + toDate,ElectionMaster.class);
            query.setMaxResults(maxResults);
            list = query.getResultList();
        } catch (Exception e) {
            logger.error("**SearcherBean.searchElectionByDateRange**" + e.getClass() + " " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<ElectionMaster> searchElectionByElectionType(Integer electionTypeId, Integer maxResults) {
        List<ElectionMaster> list = null;
        try {
            Query query = em.createNativeQuery("select * from ElectionMaster where ElectionTypeId=" + electionTypeId, ElectionMaster.class);
            list = query.getResultList();
        } catch (Exception e) {
            logger.error("**SearcherBean.searchElectionByElectionType**" + e.getClass() + " " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<PartyMaster> searchPartyByPartyName(String partyName, Integer maxResults) {
        List<PartyMaster> list = null;
        try {
            Query query = em.createNamedQuery("PartyMaster.findByPartyName");
            query.setParameter("partyName", '%' + partyName);
            //query.setMaxResults(maxResults);
            list = query.getResultList();
        } catch (Exception e) {
            logger.error("**SearcherBean.searchPartyByPartyName**" + e.getClass() + " " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<CitizenMaster> searchCitizenByName(String citizenName,Integer maxResults) {
        List<CitizenMaster> list=null;
        try {
            Query query = em.createNamedQuery("CitizenMaster.findByName");
            query.setParameter("name", "%" + citizenName);
            list=query.getResultList();
        } catch (Exception e) {
            logger.error("**SearcherBean.searchPartyByCitizen**" + e.getClass() + " " + e.getMessage());
        }
        return list;
    }


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

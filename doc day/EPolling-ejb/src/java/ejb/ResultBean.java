/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.AreaMaster;
import entities.CandidateMaster;
import entities.ElectionMaster;
import entities.PartyMaster;
import entities.SubWardMaster;
import entities.WardMaster;
import entities.ZoneMaster;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import misc.XmlHashMapIL;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author ankur
 */
@Stateless
@DeclareRoles({"admin","citizen"})
@RolesAllowed({"admin"})
public class ResultBean implements ResultBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "EPolling-ejbPU")
    EntityManager em;
    Logger logger;

    @PostConstruct
    public void initialise() {
        logger = Logger.getLogger(this.getClass());
        logger.setLevel(Level.WARN);
    }

    @Override
    public Long getVoteCountForCandidate(Integer candidateId, Integer electionId) {
        Long count = null;
        //CandidateMaster cm=null;
        //ElectionMaster elm=null;
        try {
            //Query query=em.createNamedQuery("VoteMaster.countByCandidateId");
            //query.setParameter("candidateId", candidateId);
            Query query = em.createNativeQuery("SELECT COUNT(*) FROM VoteMaster WHERE CandidateId=" + candidateId + " AND ElectionId=" + electionId);
            count = (Long) query.getSingleResult();
            //JOptionPane.showMessageDialog(null, "candidates votes :-" + count);
        } catch (Exception e) {
            logger.error("**ResultBean.getVoteCountForCandidate**" + e.getClass() + " " + e.getMessage());
            // e.printStackTrace();
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return count;
    }

    @Override
    public Long getVoteCountsForElection(Integer electionId) {
        Long count = null;
        ElectionMaster elm = null;
        try {
            //elm=em.find(ElectionMaster.class,electionId);
            //count=elm.getVoteMasterList().size();
            Query query = em.createNativeQuery("SELECT COUNT(*) FROM VoteMaster WHERE ElectionId=" + electionId);
            count = (Long) query.getSingleResult();
        } catch (Exception e) {
            logger.error("**ResultBean.getVoteCountsForElection**" + e.getClass() + " " + e.getMessage());
        }
        return count;
    }

    @Override
    public Long getVoteCountForWard(Integer wardId, Integer electionId) {
        Long count = null;
        ElectionMaster elm = null;
        try {
            //elm=em.find(ElectionMaster.class,electionId);
            //count=elm.getVoteMasterList().size();
            Query query = em.createNativeQuery("SELECT COUNT(*) FROM VoteMaster WHERE ElectionId=" + electionId + " AND WardId=" + wardId);
            count = (Long) query.getSingleResult();
        } catch (Exception e) {
            logger.error("**ResultBean.getVoteCountForWard**" + e.getClass() + " " + e.getMessage());
        }
        return count;
    }

    @Override
    public Long getVoteCountForSubward(Integer subwardId, Integer electionId) {
        Long count = null;
        SubWardMaster sm = null;
        try {
            //sm=em.find(SubWardMaster.class, subwardId);
            //count=sm.getVoteMasterList().size();
            Query query = em.createNativeQuery("SELECT COUNT(*) FROM VoteMaster WHERE ElectionId=" + electionId + " AND SubWardId=" + subwardId);
            count = (Long) query.getSingleResult();
        } catch (Exception e) {
            logger.error("**ResultBean.getVoteCountForSubward**" + e.getClass() + " " + e.getMessage());
        }
        return count;
    }

    @Override
    public Long getVoteCountForArea(Integer areaId, Integer electionId) {
        Long count = null;
        AreaMaster am = null;
        try {
            //am=em.find(AreaMaster.class, areaId);
            //count=am.getVoteMasterList().size();
            Query query = em.createNativeQuery("SELECT COUNT(*) FROM VoteMaster WHERE ElectionId=" + electionId + " AND AreaId=" + areaId);
            count = (Long) query.getSingleResult();
        } catch (Exception e) {
            logger.error("**ResultBean.getVoteCountForArea**" + e.getClass() + " " + e.getMessage());
        }
        return count;
    }

    @Override
    public Long getVoteCountForParty(Integer partyId, Integer electionId) {
        Long count = null;
        PartyMaster pm = null;
        try {
            //am=em.find(AreaMaster.class, areaId);
            //count=am.getVoteMasterList().size();
            Query query = em.createNativeQuery("SELECT COUNT(*) FROM VoteMaster WHERE CandidateId in(select c.CandidateId from CandidateMaster c,VoteMaster v where c.CandidateId=v.CandidateId and c.PartyId=" + partyId + " and v.ElectionId=" + electionId + " )");
            count = (Long) query.getSingleResult();
        } catch (Exception e) {
            logger.error("**ResultBean.getVoteCountForParty**" + e.getClass() + " " + e.getMessage());
        }
        return count;
    }

    @Override
    public Long getVoteCountForZone(Integer zoneId, Integer electionId) {
        Long count = null;
        ZoneMaster pm = null;
        try {
            //pm=em.find(ZoneMaster.class, zoneId);
            //count=pm.getVoteMasterList().size();
            Query query = em.createNativeQuery("SELECT COUNT(*) FROM VoteMaster WHERE ElectionId=" + electionId + " AND ZoneId=" + zoneId);
            count = (Long) query.getSingleResult();
        } catch (Exception e) {
            logger.error("**ResultBean.getVoteCountForZone**" + e.getClass() + " " + e.getMessage());
        }
        return count;
    }

    @Override
    public XmlHashMapIL getCandidateWiseVoteCountsForElection(Integer electionId) {
        XmlHashMapIL customMap = null;
        HashMap<Integer, Long> map = null;
        ElectionMaster elm = null;
        Long count = null;
        try {
            elm = em.find(ElectionMaster.class, electionId);
            List<CandidateMaster> listCandidates = elm.getCandidateMasterList();
            Iterator<CandidateMaster> iterator = listCandidates.iterator();
            while (iterator.hasNext()) {
                CandidateMaster cm = iterator.next();
                Query query = em.createNativeQuery("SELECT COUNT(*) FROM VoteMaster WHERE ElectionId=" + electionId + " AND CandidateId=" + cm.getCandidateId());
                count = (Long) query.getSingleResult();
                map.put(cm.getCandidateId(), count);
            }
            customMap = new XmlHashMapIL();
            customMap.setMap(map);
        } catch (Exception e) {
            logger.error("**ResultBean.getCandidateWiseVoteCountsForElection**" + e.getClass() + " " + e.getMessage());
        }
        return customMap;
    }

    @Override
    public XmlHashMapIL getCandidateWiseVoteCountsForWard(Integer electionId, Integer wardId) {
        XmlHashMapIL customMap = null;
        HashMap<Integer, Long> map = null;
        ElectionMaster elm = null;
        WardMaster wm = null;
        Long count = null;
        try {
            elm = em.find(ElectionMaster.class, electionId);

            List<CandidateMaster> listElectionCandidates = elm.getCandidateMasterList();
            Iterator<CandidateMaster> eiterator = listElectionCandidates.iterator();

            wm = em.find(WardMaster.class, wardId);
            map = new HashMap<Integer, Long>();
            while (eiterator.hasNext()) {
                CandidateMaster cm = eiterator.next();
                if (cm.getWardMaster().equals(wm)) {
                    Query query = em.createNativeQuery("SELECT COUNT(*) FROM VoteMaster WHERE ElectionId=" + electionId + " AND CandidateId=" + cm.getCandidateId());
                    count = (Long) query.getSingleResult();

                    map.put(cm.getCandidateId(), count);
                }
            }
            customMap = new XmlHashMapIL();
            customMap.setMap(map);
        } catch (Exception e) {
            //e.printStackTrace();
            //JOptionPane.showMessageDialog(null, e.getMessage());
            logger.error("**ResultBean.getCandidateWiseVoteCountsForWard**" + e.getClass() + " " + e.getMessage());
        }
        return customMap;
    }

    @Override
    public XmlHashMapIL getWardWiseVoteCountsForZone(Integer electionId, Integer zoneId) {
        XmlHashMapIL customMap = null;
        HashMap<Integer, Long> map = null;
        ZoneMaster zm = null;
        Long count = null;
        try {
            zm = em.find(ZoneMaster.class, zoneId);
            List<WardMaster> listWards = zm.getWardMasterList();
            Iterator<WardMaster> wIterator = listWards.iterator();

            while (wIterator.hasNext()) {
                WardMaster wm = wIterator.next();
                count = getVoteCountForWard(wm.getWardId(), electionId);
                map.put(wm.getWardId(), count);
            }
            customMap = new XmlHashMapIL();
            customMap.setMap(map);
        } catch (Exception e) {
            logger.error("**ResultBean.getWardWiseVoteCountsForZone**" + e.getClass() + " " + e.getMessage());
        }
        return customMap;
    }
}

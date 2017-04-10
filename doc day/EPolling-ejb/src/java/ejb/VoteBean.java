/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.JOptionPane;
import misc.XmlHashMapII;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author root
 */
@Stateless
@DeclareRoles({"admin","citizen"})
@RolesAllowed({"citizen","admin"})
public class VoteBean implements VoteBeanRemote {

    @PersistenceContext(unitName = "EPolling-ejbPU")
    EntityManager em;
    @EJB(mappedName = "ejb/ElectionSchedulerBean")
    ElectionSchedulerRemote esr;
    private Integer activeElectionId;
    Logger logger;

    @PostConstruct
    public void initialise() {
        try {
            //activeElectionId = esr.getActiveElectionId();
           // activeElectionId=1;
            logger = Logger.getLogger(this.getClass());
            logger.setLevel(Level.WARN);
        } catch (Exception e) {
        }
    }

    @Override
    public boolean castVote(Integer citizenId, List<Integer> candidateIds) {
        boolean result = false;
        try {

            ElectionMaster elm=(ElectionMaster) em.createNamedQuery("ElectionMaster.findByIsActive").setParameter("isActive", true).getSingleResult();

            activeElectionId = elm.getElectionId(); //#
            //activeElectionId = 1;
            JOptionPane.showMessageDialog(null, "active election" + activeElectionId);

            if (activeElectionId == null /*|| citizen.getIsActive()==false*/) {
                return false;
            }

            LoginMaster citizenLogin = em.find(LoginMaster.class, citizenId);
            CitizenMaster citizen = em.find(CitizenMaster.class, citizenId);

            Integer zoneId = null, wardId = null, areaId = null, subwardId = null;

            zoneId = citizen.getZoneMaster().getZoneId();
            wardId = citizen.getWardMaster().getWardId();
            areaId = citizen.getAreaMaster().getAreaId();
            subwardId = citizen.getSubWardMaster().getSubWardId();

            ZoneMaster zm = em.find(ZoneMaster.class, zoneId);
            WardMaster wm = em.find(WardMaster.class, wardId);
            SubWardMaster sm = em.find(SubWardMaster.class, subwardId);
            AreaMaster am = em.find(AreaMaster.class, areaId);
            //ElectionMaster elm = em.find(ElectionMaster.class, activeElectionId);

            for (Integer candidateId : candidateIds) {

                VoteMaster vote = new VoteMaster();

                CandidateMaster cm = em.find(CandidateMaster.class, candidateId);

                vote.setCandidateMaster(cm);

                vote.setElectionMaster(elm);

                vote.setZoneMaster(zm);

                vote.setWardMaster(wm);

                vote.setSubWardMaster(sm);

                vote.setAreaMaster(am);

                vote.setVoteDateTime(new Date());

                em.persist(vote);
                em.flush();

                //set the relationships
                //candidate-vote(1-many)
                List<VoteMaster> listCandidateVotes = cm.getVoteMasterList();
                listCandidateVotes.add(vote);
                cm.setVoteMasterList(listCandidateVotes);

                //election-vote(1-many)
                List<VoteMaster> listElectionVotes = elm.getVoteMasterList();
                listElectionVotes.add(vote);
                elm.setVoteMasterList(listElectionVotes);

                //zone-vote(1-many)
                List<VoteMaster> listZoneVotes = zm.getVoteMasterList();
                listZoneVotes.add(vote);
                zm.setVoteMasterList(listZoneVotes);

                //ward-vote(1-many)
                List<VoteMaster> listWardVotes = wm.getVoteMasterList();
                listWardVotes.add(vote);
                wm.setVoteMasterList(listWardVotes);

                //subward-vote(1-many)
                List<VoteMaster> listSubwardVotes = sm.getVoteMasterList();
                listSubwardVotes.add(vote);
                sm.setVoteMasterList(listSubwardVotes);

                //area-vote(1-many)
                List<VoteMaster> listAreaVotes = am.getVoteMasterList();
                listAreaVotes.add(vote);
                am.setVoteMasterList(listAreaVotes);

                em.merge(cm);
                em.merge(elm);
                em.merge(zm);
                em.merge(wm);
                em.merge(sm);
                em.merge(am);
                em.flush();
              JOptionPane.showMessageDialog(null, "candidates votes :-" + cm.getVoteMasterList());
            }

            citizenLogin.setIsActive(false);
            em.merge(citizen);

            result = true;
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e.getMessage());
            logger.error("**VoteBean.castVote**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    @Override
    public boolean isValidToVote(Integer citizenId) {
        boolean result = false;
        try {
            LoginMaster citizenLogin = em.find(LoginMaster.class, citizenId);
            result = citizenLogin.getIsActive();
        } catch (Exception e) {
            logger.error("**VoteBean.isValidToVote**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    // for active election
    @Override
    public XmlHashMapII getActiveCandidatesWithPartyId(Integer wardId) {
        HashMap<Integer, Integer> map = null;
        XmlHashMapII customMap = null;
        ElectionMaster elm = null;
        try {

            elm=(ElectionMaster) em.createNamedQuery("ElectionMaster.findByIsActive").setParameter("isActive",true).getSingleResult();
            activeElectionId=elm.getElectionId();
            
            JOptionPane.showMessageDialog(null,"active Election Id" +  activeElectionId);

            if (activeElectionId != null) { //#

                map = new HashMap<Integer, Integer>();

            //    elm = em.find(ElectionMaster.class, activeElectionId);//#
                 //elm = em.find(ElectionMaster.class, 13);

                if (elm.getIsActive()) { //#

                    List<CandidateMaster> listCandidates = elm.getCandidateMasterList();
                    Iterator<CandidateMaster> iterator = listCandidates.iterator();

                    while (iterator.hasNext()) {
                        CandidateMaster cm = iterator.next();
                        if (cm.getWardMaster().getWardId().equals(wardId)) {
                            map.put(cm.getCandidateId(), cm.getPartyMaster().getPartyId());
                        }
                    }

                }
            }
            customMap = new XmlHashMapII();
            customMap.setMap(map);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getClass());
            logger.error("**VoteBean.getActiveCandidatesWithPartyId**" + e.getClass() + " " + e.getMessage());
        }
        return customMap;
    }

    @Override
    public void sayHello(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}

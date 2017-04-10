/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.CandidateMaster;
import entities.ElectionMaster;
import entities.ElectionTypeMaster;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Singleton;
import javax.ejb.TimedObject;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.swing.JOptionPane;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author milan
 */
@Singleton(mappedName = "ejb/ElectionSchedulerBean")
@DeclareRoles({"admin","citizen"})
@RolesAllowed({"admin"})
public class ElectionSchedulerBean implements ElectionSchedulerRemote, TimedObject {

    @Resource
    TimerService timer;
    @PersistenceContext(unitName = "EPolling-ejbPU")
    EntityManager em;
    HashMap<Integer, ElectionMaster> scheduledElections;
    HashMap<String, Timer> scheduledTimers;
    public Integer activeElectionId;
    Logger logger;

    @PostConstruct
    public void initialise() {
        scheduledElections = new HashMap<Integer, ElectionMaster>();
        scheduledTimers = new HashMap<String, Timer>();
        logger = Logger.getLogger(this.getClass());
        logger.setLevel(Level.WARN);
    }

    @Override
    public boolean addElection(ElectionMaster elm, Integer electionTypeId, List<Integer> candidateIds) {
        boolean result = false;
        try {
            ElectionTypeMaster etm = em.find(ElectionTypeMaster.class, electionTypeId);
            //JOptionPane.showMessageDialog(null, electionTypeId);
            elm.setElectionTypeMaster(etm);

            List<ElectionMaster> electionList = etm.getElectionMasterList();
            electionList.add(elm);
            etm.setElectionMasterList(electionList);

            em.persist(elm);
            em.flush();
            em.merge(etm);

            for (Integer i : candidateIds) {
                CandidateMaster cm = em.find(CandidateMaster.class, i);

                List<ElectionMaster> listElections = cm.getElectionMasterList();
                listElections.add(elm);
                cm.setElectionMasterList(listElections);

                List<CandidateMaster> listCandidates = elm.getCandidateMasterList();
                if (listCandidates == null) {
                    listCandidates = new Vector<CandidateMaster>();
                }
                listCandidates.add(cm);
                elm.setCandidateMasterList(listCandidates);

                em.merge(elm);
                em.merge(cm);
            }

            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getClass());
            logger.error("**ElectionSchedulerBean.addElection**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    private boolean checkIfAlreadyScheduled(Integer electionID) {
        return scheduledElections.containsKey(electionID);
    }

    private boolean checkIfSimultaneousElections(Integer electionID) {
        boolean result = false;
        try {
            ElectionMaster elm = em.find(ElectionMaster.class, electionID);

            Calendar mcal = Calendar.getInstance(); // main calendar - mcal
            mcal.setTime(elm.getFinalDate());
            int dayOfMonth = mcal.get(Calendar.DAY_OF_MONTH);
            int month = mcal.get(Calendar.MONTH);
            int year = mcal.get(Calendar.YEAR);

            for (ElectionMaster election : scheduledElections.values()) {
                Calendar lcal = Calendar.getInstance(); //loop calendar -- lcal
                lcal.setTime(election.getFinalDate());

                int dd = lcal.get(Calendar.DAY_OF_MONTH);
                int mm = lcal.get(Calendar.MONTH);
                int yy = lcal.get(Calendar.YEAR);

                if (yy == year && mm == month && dd == dayOfMonth) {
                    result = true;
                    break;
                }
            }
        } catch (Exception e) {
            logger.error("**ElectionSchedulerBean.checkIfSimultaneousElections**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    @Override
    public boolean scheduleElection(Integer electionID) {
        boolean result = false;
        ElectionMaster election = null;
        Timer startTimer, endTimer;

        try {

            if (checkIfAlreadyScheduled(electionID) || checkIfSimultaneousElections(electionID)) {
                return false;
            }
            //JOptionPane.showMessageDialog(null, electionID);
            election = em.find(ElectionMaster.class, electionID);
            //JOptionPane.showMessageDialog(null, election);            

            Calendar cal = Calendar.getInstance();
            cal.setTime(election.getFinalDate());

            Calendar time = Calendar.getInstance();
            time.setTime(election.getStartTime());
            cal.set(Calendar.HOUR_OF_DAY, time.get(Calendar.HOUR_OF_DAY));
            cal.set(Calendar.MINUTE, time.get(Calendar.MINUTE));
            //JOptionPane.showMessageDialog(null, cal.getTime());

            startTimer = timer.createSingleActionTimer(cal.getTime(), new TimerConfig("startTimer" + electionID, true));
            

            time.setTime(election.getEndTime());
            cal.set(Calendar.HOUR_OF_DAY, time.get(Calendar.HOUR_OF_DAY));
            cal.set(Calendar.MINUTE, time.get(Calendar.MINUTE));
            //JOptionPane.showMessageDialog(null, cal.getTime());

            endTimer = timer.createSingleActionTimer(cal.getTime(), new TimerConfig("endTimer" + electionID, true));
            

            scheduledTimers.put("startTimer" + electionID, startTimer);
            scheduledTimers.put("endTimer" + electionID, endTimer);
            scheduledElections.put(electionID, election);
                        
            result = true;
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e.getClass());
            logger.error("**ElectionSchedulerBean.scheduleElection**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    @Override
    public boolean cancelElection(Integer electionID) {
        boolean result = false;
        try {
            ElectionMaster election = scheduledElections.get(electionID);
            if (election != null) {
                Timer startTimer = scheduledTimers.get("startTimer" + electionID);
                Timer endTimer = scheduledTimers.get("endTimer" + electionID);
                if (startTimer != null) {
                    startTimer.cancel();
                    scheduledTimers.remove("startTimer" + electionID);
                    scheduledElections.remove(election.getElectionId());
                }
                if (endTimer != null) {
                    endTimer.cancel();
                    scheduledTimers.remove("endTimer" + electionID);
                    scheduledElections.remove(election.getElectionId());
                }
            }
            result = true;
        } catch (Exception e) {
            logger.error("**ElectionSchedulerBean.cancelElection**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    @Override
    public boolean updateElection(ElectionMaster elm, Integer electionTypeId, List<Integer> candidateIds) {
        boolean result = false;
        try {
            ElectionMaster election = em.find(ElectionMaster.class, elm.getElectionId());

            List<CandidateMaster> listElectionCandidates = election.getCandidateMasterList();
            for (CandidateMaster cm : listElectionCandidates) {
                if (!candidateIds.contains(cm.getCandidateId())) {

                    List<ElectionMaster> listCandidateElections = cm.getElectionMasterList();
                    listCandidateElections.remove(election);
                    cm.setElectionMasterList(listCandidateElections);
                    em.merge(cm);

                    listElectionCandidates.remove(cm);
                    election.setCandidateMasterList(listElectionCandidates);
                    em.merge(election);
                }
            }

            for (Integer i : candidateIds) {
                CandidateMaster cm = em.find(CandidateMaster.class, i);
                List<ElectionMaster> listElections = cm.getElectionMasterList();
                if (!listElections.contains(election)) {

                    listElections.add(election);
                    cm.setElectionMasterList(listElections);

                    listElectionCandidates.add(cm);
                    election.setCandidateMasterList(listElectionCandidates);

                    em.merge(cm);
                    em.merge(election);
                }
            }
            ElectionTypeMaster electionType = em.find(ElectionTypeMaster.class, electionTypeId);
            election.setElectionTypeMaster(electionType);
            election.setStartTime(elm.getStartTime());
            election.setEndTime(elm.getEndTime());
            election.setFinalDate(elm.getFinalDate());
            election.setIsActive(elm.getIsActive());
            election.setName(elm.getName());

            em.merge(election);
            em.flush();
            result = true;
        } catch (Exception e) {
            logger.error("**ElectionSchedulerBean.updateElection**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    private int setAllCitizenActive() {
        int returnValue = -1;
        try {
            JOptionPane.showMessageDialog(null, "here + citizen active");
            Query query = em.createNamedQuery("LoginMaster.setCitizensActive");            
            returnValue = query.executeUpdate();
            //em.refresh();
            //JOptionPane.showMessageDialog(null, returnValue);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"set citizens active "+ e.getClass());
            logger.error("**ElectionSchedulerBean.setAllCitizenActive**" + e.getClass() + " " + e.getMessage());
            JOptionPane.showMessageDialog(null, e.getClass());
        }
        return returnValue;
    }

    private int setAllCitizenInActive() {
        int returnValue = -1;
        try {
            JOptionPane.showMessageDialog(null, "here + citizen Inactive");
            Query query = em.createNamedQuery("LoginMaster.setCitizensInActive");
            returnValue = query.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "citizens inactive " + e.getClass());
            logger.error("**ElectionSchedulerBean.setAllCitizenInActive**" + e.getClass() + " " + e.getMessage());
        }
        return returnValue;

    }

    private boolean notifyCitizens() {
        boolean result = true;
        //code for sending emails
       // JOptionPane.showMessageDialog(null, "here + notify citizen");
        return result;
    }

    private boolean setElectionActive(Integer electionId) {
        boolean result = true;
        try {
            JOptionPane.showMessageDialog(null, "here + election active");
            Query query = em.createNamedQuery("ElectionMaster.findByElectionId");
            query.setParameter("electionId", electionId);

            ElectionMaster election = (ElectionMaster) query.getSingleResult();
            election.setIsActive(true);
            em.merge(election);
            result = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"set election active "+ e.getClass());
            logger.error("**ElectionSchedulerBean.setElectionActive**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    private void setElectionInActive(Integer electionId) {
        try {
            JOptionPane.showMessageDialog(null, "here + election in active");
            Query query = em.createNamedQuery("ElectionMaster.findByElectionId");
            JOptionPane.showMessageDialog(null, "election id :- " + electionId);
            query.setParameter("electionId", electionId);

            ElectionMaster election = (ElectionMaster) query.getSingleResult();
            election.setIsActive(false);
            em.merge(election);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"set election In active "+ e.getClass());
            logger.error("**ElectionSchedulerBean.setElectionInActive**" + e.getClass() + " " + e.getMessage());
            //JOptionPane.showMessageDialog(null, e.getClass());
        }
    }

    @Override
    public List<ElectionMaster> getFutureElections() {
        List listOfAllElections = null;
        try {
            Query q = em.createNamedQuery("ElectionMaster.findFutureElections");
            q.setParameter("finalDate", new java.util.Date(), TemporalType.DATE);
            listOfAllElections = q.getResultList();
        } catch (Exception e) {
            logger.error("**ElectionSchedulerBean.findFutureElections**" + e.getClass() + " " + e.getMessage());
            //JOptionPane.showMessageDialog(null, "error " + e.getClass());
        }
        return listOfAllElections;
    }

    @Override
    public void ejbTimeout(Timer timer) {
        JOptionPane.showMessageDialog(null, "coming");
        try {
            String timerName = timer.getInfo().toString();
            Integer electionId = null;
//            JOptionPane.showMessageDialog(null, timerName);
//            JOptionPane.showMessageDialog(null, scheduledElections);
//            JOptionPane.showMessageDialog(null, scheduledTimers);
            Timer expiredTimer = scheduledTimers.get(timerName);
            //JOptionPane.showMessageDialog(null, timerName);
            if (expiredTimer != null) {
                if (timerName.contains("startTimer")) {
                    electionId = Integer.parseInt(timerName.substring(10));

                    //set active election which can be accessed via other ejbs
                    //when election has been started.
                    activeElectionId = electionId;
                    JOptionPane.showMessageDialog(null, activeElectionId);

                    setAllCitizenActive();
                    setElectionActive(electionId);
                    //notifyCitizens();

                    scheduledTimers.remove("startTimer" + electionId);

                } else if (timerName.contains("endTimer")) {

                    electionId = Integer.parseInt(timerName.substring(8));

                    JOptionPane.showMessageDialog(null, activeElectionId);

                    activeElectionId = null;

                    setAllCitizenInActive();
                    setElectionInActive(electionId);
                    setAllCandidatesInActive();
                    
                    scheduledElections.remove(electionId);    
                    scheduledTimers.remove("endTimer" + electionId);
                }
            }
        } catch (Exception e) {
            logger.error("**ElectionSchedulerBean.TimeOut**" + e.getClass() + " " + e.getMessage());
        }
    }

    @Override
    public List<ElectionMaster> getScheduledElections() {
        List<ElectionMaster> listScheduledElections = null;
        try {
            listScheduledElections = new ArrayList<ElectionMaster>(scheduledElections.values());
        } catch (Exception e) {
            logger.error("**ElectionSchedulerBean.getScheduledElections**" + e.getClass() + " " + e.getMessage());
        }
        return listScheduledElections;
    }

    @Override
    public ElectionMaster getElection(Integer electionId) {
        ElectionMaster election = null;
        try {
            election = em.find(ElectionMaster.class, electionId);
        } catch (Exception e) {
            logger.error("**ElectionSchedulerBean.getElection**" + e.getClass() + " " + e.getMessage());
        }
        return election;
    }

    @Override
    public List<ElectionTypeMaster> getAllElectionTypes() {
        List<ElectionTypeMaster> listAllElectionTypes = null;
        try {
            listAllElectionTypes = em.createNamedQuery("ElectionTypeMaster.findAll").getResultList();
        } catch (Exception e) {
            logger.error("**ElectionSchedulerBean.getAllElectionTypes**" + e.getClass() + " " + e.getMessage());
        }
        return listAllElectionTypes;
    }

    /**
     * Once the election is over the candidates who participated in the election needs to be
     * inactive thereby maintaining the system in the correct state.
     */
    private int setAllCandidatesInActive() {
        int value = -1;
        try {
            //JOptionPane.showMessageDialog(null, "set all candidates in active");
            Query query = em.createQuery("update CandidateMaster c set c.isActive= :isActive");
            query.setParameter("isActive", false);
            value = query.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"candiddate in active" +  e.getClass());
            logger.error("**ElectionSchedulerBean.setAllCandidatesInActive**" + e.getClass() + " " + e.getMessage());
        }
        return value;
    }

    @Override
    public Integer getActiveElectionId() {
        return activeElectionId;

    }

    @Override
    public List<ElectionMaster> getPastElections() {
        List listOfAllElections = null;
        try {
            Query q = em.createNamedQuery("ElectionMaster.findPastElections");
            q.setParameter("finalDate", new java.util.Date(), TemporalType.DATE);
            listOfAllElections = q.getResultList();
        } catch (Exception e) {
            logger.error("**ElectionSchedulerBean.getPastElections**" + e.getClass() + " " + e.getMessage());
            //JOptionPane.showMessageDialog(null, "error " + e.getClass());
        }
        return listOfAllElections;
    }

    @Override
    public List<ElectionMaster> getAllElections() {
        List listOfAllElections = null;
        try {
            listOfAllElections = em.createNamedQuery("ElectionMaster.findAll").getResultList();
        } catch (Exception e) {
            logger.error("**ElectionSchedulerBean.getAllElections**" + e.getClass() + " " + e.getMessage());
            //JOptionPane.showMessageDialog(null, "error " + e.getClass());
        }
        return listOfAllElections;
    }
    /*public boolean setCandidatesActive(List<Integer> candidateIds) {

    }*/
}

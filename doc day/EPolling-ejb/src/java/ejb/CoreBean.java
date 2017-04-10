/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.AreaMaster;
import entities.CandidateMaster;
import entities.CitizenMaster;
import entities.CityMaster;
import entities.GroupMaster;
import entities.LoginMaster;
import entities.PartyMaster;
import entities.SubWardMaster;
import entities.UserGroupMaster;
import entities.UserGroupMasterPK;
import entities.WardMaster;
import entities.ZoneMaster;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
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
@Stateless(mappedName = "ejb/CoreBean")
@DeclareRoles({"admin", "citizen"})
@RolesAllowed({"admin", "citizen"})
public class CoreBean implements CoreBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "EPolling-ejbPU")
    EntityManager em;
    private CandidateMaster candidate;
    private CitizenMaster citizen;
    private ZoneMaster zone;
    private WardMaster ward;
    private SubWardMaster subward;
    private AreaMaster area;
    private PartyMaster party;
    private List<CandidateMaster> candidateList;
    private LoginMaster loginMaster;
    Logger logger;

    @PostConstruct
    public void initialise() {
        logger = Logger.getLogger(this.getClass());
        logger.setLevel(Level.WARN);
    }

    // <editor-fold defaultstate="collapsed" desc="Candidate Code">
    @Override
    public boolean addCandidate(CandidateMaster cm, Integer zoneId, Integer wardId, Integer subwardId, Integer areaId, Integer partyId) {
        boolean result = false;
        try {

            PartyMaster pm = em.find(PartyMaster.class, partyId);
            ZoneMaster zm = em.find(ZoneMaster.class, zoneId);
            WardMaster wm = em.find(WardMaster.class, wardId);
            SubWardMaster sm = em.find(SubWardMaster.class, subwardId);
            AreaMaster am = em.find(AreaMaster.class, areaId);

            // party-candidate(1-many)
            List<CandidateMaster> partyCandidates = pm.getCandidateMasterList();
            if (!partyCandidates.contains(cm)) {
                partyCandidates.add(cm);
                pm.setCandidateMasterList(partyCandidates);
            }


            // zone-candidate (1-many)
            List<CandidateMaster> zoneCandidates = zm.getCandidateMasterList();
            if (!zoneCandidates.contains(cm)) {
                zoneCandidates.add(cm);
                zm.setCandidateMasterList(zoneCandidates);
            }

            // ward-candidate (1-many)
            List<CandidateMaster> wardCandidates = wm.getCandidateMasterList();
            if (!wardCandidates.contains(cm)) {
                wardCandidates.add(cm);
                wm.setCandidateMasterList(wardCandidates);
            }

            //subward-candidates (1-many)
            List<CandidateMaster> subwardCandidates = sm.getCandidateMasterList();
            if (!subwardCandidates.contains(cm)) {
                subwardCandidates.add(cm);
                sm.setCandidateMasterList(subwardCandidates);
            }

            // area-candidate (1-many)
            List<CandidateMaster> areaCandidates = am.getCandidateMasterList();
            if (!areaCandidates.contains(cm)) {
                areaCandidates.add(cm);
                am.setCandidateMasterList(areaCandidates);
            }

            cm.setPartyMaster(pm);
            cm.setZoneMaster(zm);
            cm.setWardMaster(wm);
            cm.setSubWardMaster(sm);
            cm.setAreaMaster(am);
            em.persist(cm);
            em.flush();

         //   JOptionPane.showMessageDialog(null, cm.getCandidateId());
            WardMaster wm1 = em.find(WardMaster.class, wardId);
           // JOptionPane.showMessageDialog(null, wm1.getCandidateMasterList());

            em.merge(pm);
            em.merge(zm);
            em.merge(wm);
            em.merge(sm);
            em.merge(am);
            //JOptionPane.showMessageDialog(null, partyCandidates);
            //JOptionPane.showMessageDialog(null, zoneCandidates);
            //JOptionPane.showMessageDialog(null, wardCandidates);
            //JOptionPane.showMessageDialog(null, subwardCandidates);
            //JOptionPane.showMessageDialog(null, areaCandidates);

            result = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return result;
    }

    @Override
    public boolean checkForExistingCandidate(CandidateMaster cm) {
        boolean result = false;
        candidate = null;
        try {
            // JOptionPane.showMessageDialog(null, cm.getFirstName());
            // here some extra params have to be specified
            Query query = em.createNamedQuery("CandidateMaster.findExisting");
            query.setParameter("firstName", cm.getFirstName());
            query.setParameter("lastName", cm.getLastName());
            query.setParameter("email", cm.getEmail());
            query.setParameter("dateOfBirth", cm.getDateOfBirth());
            query.setParameter("nationality", cm.getNationality());
            query.setParameter("sex", cm.getSex());
            query.setParameter("address", cm.getAddress());
            query.setParameter("phoneNo", cm.getPhoneNo());
            query.setParameter("image", cm.getImage());
            query.setParameter("isActive", cm.getIsActive());

            candidate = (CandidateMaster) query.getSingleResult();
            // JOptionPane.showMessageDialog(null,candidate);
            result = true;

        } catch (Exception e) {
            logger.error("**CoreBean.checkForExistingCandidate**" + e.getClass() + " " + e.getMessage());
            //e.printStackTrace();
            //JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            candidate = null;
        }
        return result;
    }

    @Override
    public boolean updateCandidate(CandidateMaster cm, Integer zoneId, Integer wardId, Integer subwardId, Integer areaId, Integer partyId) {
        boolean result = false;
        try {

            candidate = em.find(CandidateMaster.class, cm.getCandidateId());

            candidate.setFirstName(cm.getFirstName());
            candidate.setLastName(cm.getLastName());
            candidate.setAddress(cm.getAddress());
            candidate.setPhoneNo(cm.getPhoneNo());
            candidate.setImage(cm.getImage());
            candidate.setDateOfBirth(cm.getDateOfBirth());
            candidate.setEmail(cm.getEmail());
            //candidate.setNationality(cm.getNationality());

            // party-candidate (1-many)
            PartyMaster pmd = candidate.getPartyMaster(); //from database
            PartyMaster pmu = em.find(PartyMaster.class, partyId); //from updated view
            if (!pmd.equals(pmu)) {
                //remove candidate from old party
                List<CandidateMaster> partyCandidatesdb = pmd.getCandidateMasterList();
                if (partyCandidatesdb.contains(candidate)) {
                    partyCandidatesdb.remove(candidate);
                    pmd.setCandidateMasterList(partyCandidatesdb);
                }
                //add to new party which came from view
                List<CandidateMaster> partyCandidatesup = pmu.getCandidateMasterList();
                if (!partyCandidatesup.contains(candidate)) {
                    partyCandidatesup.add(candidate);
                    pmu.setCandidateMasterList(partyCandidatesup);
                }
                candidate.setPartyMaster(pmu);
            }

            // zone-candidate (1-many)
            ZoneMaster zmd = candidate.getZoneMaster(); //from database
            ZoneMaster zmu = em.find(ZoneMaster.class, zoneId); // from updated view
            if (!zmd.equals(zmu)) {
                //remove candidate from old ward
                List<CandidateMaster> zoneCandidatesdb = zmd.getCandidateMasterList();
                if (zoneCandidatesdb.contains(candidate)) {
                    zoneCandidatesdb.remove(candidate);
                    zmd.setCandidateMasterList(zoneCandidatesdb);
                }

                //add to new ward which came from view
                List<CandidateMaster> zoneCandidatesup = zmu.getCandidateMasterList();
                if (!zoneCandidatesup.contains(candidate)) {
                    zoneCandidatesup.add(candidate);
                    zmu.setCandidateMasterList(zoneCandidatesup);
                }
                candidate.setZoneMaster(zmu);
            }

            // ward-candidate (1-many)
            WardMaster wmd = candidate.getWardMaster(); //from database
            WardMaster wmu = em.find(WardMaster.class, wardId); // from updated view
            if (!wmd.equals(wmu)) {
                //remove candidate from old ward
                List<CandidateMaster> wardCandidatesdb = wmd.getCandidateMasterList();
                if (wardCandidatesdb.contains(candidate)) {
                    wardCandidatesdb.remove(candidate);
                    wmd.setCandidateMasterList(wardCandidatesdb);
                }

                //add to new ward which came from view
                List<CandidateMaster> wardCandidatesup = wmu.getCandidateMasterList();
                if (!wardCandidatesup.contains(candidate)) {
                    wardCandidatesup.add(candidate);
                    wmu.setCandidateMasterList(wardCandidatesup);
                }
                candidate.setWardMaster(wmu);
            }

            // subward-candidate (1-many)
            SubWardMaster smd = candidate.getSubWardMaster(); //from database
            SubWardMaster smu = em.find(SubWardMaster.class, subwardId); // from updated view
            if (!smd.equals(smu)) {
                //remove candidate from old ward
                List<CandidateMaster> subwardCandidatesdb = smd.getCandidateMasterList();
                if (subwardCandidatesdb.contains(candidate)) {
                    subwardCandidatesdb.remove(candidate);
                    smd.setCandidateMasterList(subwardCandidatesdb);
                }

                //add to new ward which came from view
                List<CandidateMaster> subwardCandidatesup = smu.getCandidateMasterList();
                if (!subwardCandidatesup.contains(candidate)) {
                    subwardCandidatesup.add(candidate);
                    wmu.setCandidateMasterList(subwardCandidatesup);
                }
                candidate.setSubWardMaster(smu);
            }

            // area-candidate (1-many)
            AreaMaster amd = candidate.getAreaMaster(); // from database
            AreaMaster amu = em.find(AreaMaster.class, areaId); //from updated view
            if (!amd.equals(amu)) {
                //remove candidate from old area
                List<CandidateMaster> areaCandidatesdb = amd.getCandidateMasterList();
                if (areaCandidatesdb.contains(candidate)) {
                    areaCandidatesdb.remove(candidate);
                    amd.setCandidateMasterList(areaCandidatesdb);
                }

                //add to new area came from view
                List<CandidateMaster> areaCandidateup = amu.getCandidateMasterList();
                if (!areaCandidateup.contains(candidate)) {
                    areaCandidateup.add(candidate);
                    amu.setCandidateMasterList(areaCandidateup);
                }
                candidate.setAreaMaster(amu);
            }

            //JOptionPane.showMessageDialog(null, pmd.getCandidateMasterList());
            //JOptionPane.showMessageDialog(null, pmu.getCandidateMasterList());
            //JOptionPane.showMessageDialog(null, wmd.getCandidateMasterList());
            //JOptionPane.showMessageDialog(null, wmu.getCandidateMasterList());
            //JOptionPane.showMessageDialog(null, amd.getCandidateMasterList());
            //JOptionPane.showMessageDialog(null, amu.getCandidateMasterList());

            em.merge(candidate);
            em.merge(pmd);
            em.merge(pmu);
            em.merge(zmd);
            em.merge(zmu);
            em.merge(wmd);
            em.merge(wmu);
            em.merge(smd);
            em.merge(smu);
            em.merge(amd);
            em.merge(amu);
            em.flush();
            result = true;
        } catch (Exception e) {
            logger.error("**CoreBean.updateCandidate**" + e.getClass() + " " + e.getMessage());
            JOptionPane.showMessageDialog(null, e.getClass());
        }
        return result;

    }

    @Override
    public CandidateMaster getCandidate(Integer candidateID) {
        candidate = null;
        try {
            candidate = em.find(CandidateMaster.class, candidateID);
        } catch (Exception e) {
            logger.error("**CoreBean.getCandidate**" + e.getClass() + " " + e.getMessage());
        }
        return candidate;
    }

    @Override
    public List<CandidateMaster> getAllCandidates() {
        List<CandidateMaster> listAllCandidates = null;
        try {
            listAllCandidates = em.createNamedQuery("CandidateMaster.findAll").getResultList();
        } catch (Exception e) {
            logger.error("**CoreBean.getAllCandidates**" + e.getClass() + " " + e.getMessage());
        }
        return listAllCandidates;
    }

    @Override
    public List<CandidateMaster> getAllActiveCandidates() {
        List<CandidateMaster> retval = null;
        try {
            retval = em.createNamedQuery("CandidateMaster.findByIsActive").setParameter("isActive", true).getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getClass());
        }
        return retval;
    }

    @Override
    public List<CandidateMaster> getAllInActiveCandidates() {
        List<CandidateMaster> retval = null;
        try {
            retval = em.createNamedQuery("CandidateMaster.findByIsActive").setParameter("isActive", false).getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getClass());
        }
        return retval;
    }

    @Override
    public boolean deleteCandidate(Integer candidateId) {
        boolean result = false;
        try {
            CandidateMaster cm = em.find(CandidateMaster.class, candidateId);
            em.remove(cm);
            result = true;
        } catch (Exception e) {
            logger.error("**CoreBean.deleteCandidate**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Citizen Code">
    @Override
    public boolean addCitizen(LoginMaster lm, CitizenMaster cm, Integer zoneId, Integer wardId, Integer subwardId, Integer areaId) {
        GroupMaster gm = null;
        boolean result = false;
        try {
            //JOptionPane.showMessageDialog(null, "coming here");
            //  lm.setCitizenMaster(cm);

            em.persist(lm);
            em.flush();
            cm.setLoginMaster(lm);
            cm.setUserId(lm.getUserId());
            //JOptionPane.showMessageDialog(null, lm.getUserId());            
            //JOptionPane.showMessageDialog(null, lm.getUserId());

            //setting login master for citizen child record
            //cm.setLoginMaster(lm);

            //find record from GroupMaster
            if (lm.getUserType().equals("admin")) {
                gm = em.find(GroupMaster.class, "admin");
            } else if (lm.getUserType().equals("citizen")) {
                gm = em.find(GroupMaster.class, "citizen");
            }

            //adding entry to UserGroupMaster
            UserGroupMasterPK pk = new UserGroupMasterPK(lm.getUserId(), gm.getGroupName());
            UserGroupMaster ugm = new UserGroupMaster(pk);
            ugm.setGroupMaster(gm);
            ugm.setLoginMaster(lm);
            ugm.setUsername(lm.getUsername());

            em.persist(ugm);
            em.flush();

            //set the relationships

            // zone-citizens (1-many)            
            ZoneMaster zmd = em.find(ZoneMaster.class, zoneId);
            List<CitizenMaster> zoneCitizens = zmd.getCitizenMasterList();
            if (!zoneCitizens.contains(cm)) {
                zoneCitizens.add(cm);
                //JOptionPane.showMessageDialog(null, zoneCitizens);
                zmd.setCitizenMasterList(zoneCitizens);
                cm.setZoneMaster(zmd);
            }

            // ward-citizens (1-many)
            WardMaster wmd = em.find(WardMaster.class, wardId);
            List<CitizenMaster> wardCitizens = wmd.getCitizenMasterList();
            if (!wardCitizens.contains(cm)) {
                wardCitizens.add(cm);
                //JOptionPane.showMessageDialog(null, wardCitizens);
                wmd.setCitizenMasterList(wardCitizens);
                cm.setWardMaster(wmd);
            }

            //subward-citizens(1-many)
            SubWardMaster smd = em.find(SubWardMaster.class, subwardId);
            List<CitizenMaster> subwardCitizens = smd.getCitizenMasterList();
            if (!subwardCitizens.contains(cm)) {
                subwardCitizens.add(cm);
                //JOptionPane.showMessageDialog(null, subwardCitizens);
                smd.setCitizenMasterList(subwardCitizens);
                cm.setSubWardMaster(smd);
            }

            //area-citizens(1-many)
            AreaMaster amd = em.find(AreaMaster.class, areaId);
            List<CitizenMaster> areaCitizens = amd.getCitizenMasterList();
            if (!areaCitizens.contains(cm)) {
                areaCitizens.add(cm);
                //JOptionPane.showMessageDialog(null, areaCitizens);
                amd.setCitizenMasterList(areaCitizens);
                cm.setAreaMaster(amd);
            }

            em.persist(cm);
            em.flush();
            lm.setCitizenMaster(cm);
            em.merge(lm);
            //em.merge(cm);
            em.merge(zmd);
            em.merge(wmd);
            em.merge(smd);
            em.merge(amd);
            result = true;
        } catch (Exception e) {
            logger.error("**CoreBean.addCitizen**" + e.getClass() + " " + e.getMessage());
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return result;
    }

    @Override
    public boolean updateCitizen(LoginMaster lm, CitizenMaster cm, Integer zoneId, Integer wardId, Integer subwardId, Integer areaId) {
        boolean result = false;
        loginMaster = null;
        citizen = null;
        try {
            loginMaster = em.find(LoginMaster.class, lm.getUserId());
            loginMaster.setUsername(lm.getUsername());
            loginMaster.setPassword(lm.getPassword());
            loginMaster.setIsActive(lm.getIsActive());
            loginMaster.setUserType(lm.getUserType());

            citizen = em.find(CitizenMaster.class, cm.getUserId());
            citizen.setAddress(cm.getAddress());
            citizen.setContactNo(cm.getContactNo());
            citizen.setDateOfBirth(cm.getDateOfBirth());
            citizen.setFaceImage(cm.getFaceImage());
            citizen.setSignatureImage(cm.getSignatureImage());
            citizen.setThumbImage(cm.getThumbImage());
            citizen.setVoterCardImage(cm.getVoterCardImage());
            citizen.setName(cm.getName());
            //citizen.setIsActive(cm.getIsActive());

            //loginMaster.setCitizenMaster(citizen);

            //set the relationships

            //citizen-zone(many-1)
            ZoneMaster zmd = citizen.getZoneMaster(); //from database
            JOptionPane.showMessageDialog(null, "zone :- " + zmd);

            ZoneMaster zmu = em.find(ZoneMaster.class, zoneId); // from updated view
            if (!zmd.equals(zmu)) {
                //remove citizen from old zone
                List<CitizenMaster> zoneCitizensdb = zmd.getCitizenMasterList();
                if (zoneCitizensdb.contains(citizen)) {
                    zoneCitizensdb.remove(citizen);
                    zmd.setCitizenMasterList(zoneCitizensdb);
                }

                //add to new zone which came from view
                List<CitizenMaster> zoneCitizensup = zmu.getCitizenMasterList();
                if (!zoneCitizensup.contains(citizen)) {
                    zoneCitizensup.add(citizen);
                    zmu.setCitizenMasterList(zoneCitizensup);
                }
                citizen.setZoneMaster(zmu);
            }

            // ward-citizen (1-many)
            WardMaster wmd = citizen.getWardMaster(); //from database
            WardMaster wmu = em.find(WardMaster.class, wardId); // from updated view
            if (!wmd.equals(wmu)) {
                //remove citizen from old ward
                List<CitizenMaster> wardCitizensdb = wmd.getCitizenMasterList();
                if (wardCitizensdb.contains(citizen)) {
                    wardCitizensdb.remove(citizen);
                    wmd.setCitizenMasterList(wardCitizensdb);
                }

                //add to new ward which came from view
                List<CitizenMaster> wardCitizensup = wmu.getCitizenMasterList();
                if (!wardCitizensup.contains(citizen)) {
                    wardCitizensup.add(citizen);
                    wmu.setCitizenMasterList(wardCitizensup);
                }
                citizen.setWardMaster(wmu);
            }

            // subward-citizen (1-many)
            SubWardMaster smd = citizen.getSubWardMaster(); //from database
            SubWardMaster smu = em.find(SubWardMaster.class, subwardId); // from updated view
            if (!smd.equals(smu)) {
                //remove citizen from old ward
                List<CitizenMaster> subwardCitizensdb = smd.getCitizenMasterList();
                if (subwardCitizensdb.contains(citizen)) {
                    subwardCitizensdb.remove(citizen);
                    smd.setCitizenMasterList(subwardCitizensdb);
                }

                //add to new ward which came from view
                List<CitizenMaster> subwardCitizensup = smu.getCitizenMasterList();
                if (!subwardCitizensup.contains(citizen)) {
                    subwardCitizensup.add(citizen);
                    wmu.setCitizenMasterList(subwardCitizensup);
                }
                citizen.setSubWardMaster(smu);
            }

            // area-citizen (1-many)
            AreaMaster amd = citizen.getAreaMaster(); // from database
            AreaMaster amu = em.find(AreaMaster.class, areaId); //from updated view
            if (!amd.equals(amu)) {
                //remove citizen from old area
                List<CitizenMaster> areaCitizensdb = amd.getCitizenMasterList();
                if (areaCitizensdb.contains(citizen)) {
                    areaCitizensdb.remove(citizen);
                    amd.setCitizenMasterList(areaCitizensdb);
                }

                //add to new area came from view
                List<CitizenMaster> areaCitizenup = amu.getCitizenMasterList();
                if (!areaCitizenup.contains(citizen)) {
                    areaCitizenup.add(citizen);
                    amu.setCitizenMasterList(areaCitizenup);
                }
                citizen.setAreaMaster(amu);
            }

            em.merge(citizen);
            em.merge(loginMaster);
            em.merge(zmd);
            em.merge(zmu);
            em.merge(wmd);
            em.merge(wmu);
            em.merge(smd);
            em.merge(smu);
            em.merge(amd);
            em.merge(amu);
            em.flush();
            result = true;
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e.getMessage() + e.getClass());
            logger.error("**CoreBean.updateCitizen**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    @Override
    public CitizenMaster getCitizenMaster(Integer citizenId) {
        CitizenMaster cm = null;
        try {
            cm = em.find(CitizenMaster.class, citizenId);
        } catch (Exception e) {
            logger.error("**CoreBean.getCitizenMaster**" + e.getClass() + " " + e.getMessage());
        }
        return cm;
    }

    @Override
    public List<CitizenMaster> getAllCitizens() {
        List<CitizenMaster> listAllCitizens = null;
        try {
            listAllCitizens = em.createNamedQuery("CitizenMaster.findAll").getResultList();
        } catch (Exception e) {
            logger.error("**CoreBean.getAllCitizens**" + e.getClass() + " " + e.getMessage());
        }
        return listAllCitizens;
    }

    @Override
    public LoginMaster getLoginMaster(Integer userId) {
        LoginMaster lm = null;
        try {
            lm = em.find(LoginMaster.class, userId);
        } catch (Exception e) {
            logger.error("**CoreBean.getLoginMaster**" + e.getClass() + " " + e.getMessage());
        }
        return lm;
    }

    @Override
    @PermitAll
    public LoginMaster getLoginMaster(String username) {
        LoginMaster lm = null;
        try {
            String q = "select * from LoginMaster where Username='" + username + "'";
            //JOptionPane.showMessageDialog(null, q);
            Query query = em.createNativeQuery(q, LoginMaster.class);
            lm = (LoginMaster) query.getSingleResult();
            //JOptionPane.showMessageDialog(null, lm);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e.getMessage());
            logger.error("**CoreBean.getLoginMaster**" + e.getClass() + " " + e.getMessage());
        }
        return lm;
    }

    @Override
    public boolean deleteCitizen(Integer citizenId) {
        boolean result = false;
        try {
//            UserGroupMaster ugm
//            LoginMaster lm=em.find(LoginMaster.class, citizenId);
//            lm.setCitizenMaster(null);
//            lm.getUserGroupMasterList()
            CitizenMaster cm = em.find(CitizenMaster.class, citizenId);
            //cm.setLoginMaster(null);
            em.remove(cm);
            result = true;
        } catch (Exception e) {
            logger.error("**CoreBean.deleteCitizen**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Zone Code">
    @Override
    public boolean addZone(ZoneMaster zone, Integer cityMasterId) {
        boolean result = false;
        CityMaster cm = null;
        try {
            //scxt.getUserTransaction().begin();
            //CityMaster cm = zone.getCityMaster();
            //JOptionPane.showMessageDialog(null, "ejbs");
            cm = em.find(CityMaster.class, cityMasterId);
            //JOptionPane.showMessageDialog(null, cm);            
            //JOptionPane.showMessageDialog(null, "zoneInCity==null?" + zoneInCity == null);
            //if(zoneInCity==null)
            //{
            //zoneInCity=new ArrayList<ZoneMaster>();
            //}
            //if (!zoneInCity.contains(zone)) {            
            zone.setCityMaster(cm);
            em.persist(zone);
            em.flush();
            //JOptionPane.showMessageDialog(null, zone.getPopulation());
            List<ZoneMaster> zoneInCity = cm.getZoneMasterList();
            if (!zoneInCity.contains(zone)) {
                zoneInCity.add(zone);
                cm.setZoneMasterList(zoneInCity);
            }
            // em.persist(zone);
            em.merge(cm);
            em.flush();
            // em.refresh(cm);
            //JOptionPane.showMessageDialog(null, "after update " + cm.getZoneMasterList());
            result = true;
            //scxt.getUserTransaction().commit();
            //}
        } catch (Exception e) {
            // JOptionPane.showMessageDialog(null, "CoreBean:addZone" + e.getClass());
            logger.error("**CoreBean.addZone**" + e.getClass() + " " + e.getMessage());
        }
        //JOptionPane.showMessageDialog(null, "after update " + zone.getZoneId());
        //JOptionPane.showMessageDialog(null, "after update " + cm.getZoneMasterList());
        return result;
    }

    @Override
    public boolean updateZone(ZoneMaster zone, Integer newCityMasterId) {
        boolean result = false;
        try {

            this.zone = em.find(ZoneMaster.class, zone.getZoneId());

            this.zone.setPopulation(zone.getPopulation());
            this.zone.setZoneName(zone.getZoneName());

            // when updated city is different than the old one.
            if (!this.zone.getCityMaster().getCityId().equals(newCityMasterId)) {
                //remove previous city from database
                CityMaster cmd = em.find(CityMaster.class, this.zone.getCityMaster().getCityId());
                List<ZoneMaster> listZonesdb = cmd.getZoneMasterList();
                if (listZonesdb.contains(this.zone)) {
                    listZonesdb.remove(this.zone);
                    cmd.setZoneMasterList(listZonesdb);
                }

                //add new city to updated data
                CityMaster cmu = em.find(CityMaster.class, newCityMasterId);
                List<ZoneMaster> listZonesup = cmu.getZoneMasterList();
                if (!listZonesup.contains(this.zone)) {
                    listZonesup.add(this.zone);
                    cmu.setZoneMasterList(listZonesup);
                }
                this.zone.setCityMaster(cmu);
                em.merge(cmu);
                em.merge(cmd);
                //JOptionPane.showMessageDialog(null, "from database" + cmd.getZoneMasterList());
                //JOptionPane.showMessageDialog(null, "from updated " +  cmu.getZoneMasterList());
            }
            em.merge(this.zone);
            em.flush();
//            em.merge(cm);
            result = true;
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e.getClass());
            logger.error("**CoreBean.updateZone**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    @Override
    public boolean deleteZone(Integer zoneId) {
        try {
            zone = em.find(ZoneMaster.class, zoneId);

            //city-zone (1-many)
            CityMaster cm = zone.getCityMaster();
            List<ZoneMaster> listZones = cm.getZoneMasterList();
            if (listZones.contains(zone)) {
                listZones.remove(zone);
                cm.setZoneMasterList(listZones);
            }

            em.merge(cm);
            em.remove(zone);
            em.flush();
            //  JOptionPane.showMessageDialog(null, cm.getZoneMasterList());
            return true;
        } catch (Exception e) {
            logger.error("**CoreBean.deleteZone**" + e.getClass() + " " + e.getMessage());
        }
        return false;
    }

    @Override
    public List<ZoneMaster> getAllZones() {
        List<ZoneMaster> listAllZones = null;
        try {
            listAllZones = em.createNamedQuery("ZoneMaster.findAll").getResultList();
        } catch (Exception e) {
            logger.error("**CoreBean.getAllZones**" + e.getClass() + " " + e.getMessage());
        }
        return listAllZones;
    }

    @Override
    public ZoneMaster getZone(Integer zoneId) {
        try {
            zone = em.find(ZoneMaster.class, zoneId);
            return zone;
        } catch (Exception e) {
            logger.error("**CoreBean.getZone**" + e.getClass() + " " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<WardMaster> getWardsOfZone(Integer zoneId) {
        List<WardMaster> listWards = null;
        try {
            ZoneMaster zm = em.find(ZoneMaster.class, zoneId);
            listWards = zm.getWardMasterList();
        } catch (Exception e) {
            logger.error("**CoreBean.getWardsOfZone**" + e.getClass() + " " + e.getMessage());
        }
        return listWards;
    }

    @Override
    public List<CitizenMaster> getCitizensOfZone(Integer zoneId) {
        List<CitizenMaster> listCitizens = null;
        try {
            ZoneMaster zm = em.find(ZoneMaster.class, zoneId);
            listCitizens = zm.getCitizenMasterList();
        } catch (Exception e) {
            logger.error("**CoreBean.getCitizensOfZone**" + e.getClass() + " " + e.getMessage());
        }
        return listCitizens;
    }

    @Override
    public List<CandidateMaster> getCandidatesOfZone(Integer zoneId) {
        List<CandidateMaster> listCandidates = null;
        try {
            ZoneMaster zm = em.find(ZoneMaster.class, zoneId);
            listCandidates = zm.getCandidateMasterList();
        } catch (Exception e) {
            logger.error("**CoreBean.getCandidatesOfZone**" + e.getClass() + " " + e.getMessage());
        }
        return listCandidates;
    }

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Ward Code">
    @Override
    public boolean addWard(WardMaster ward, Integer zoneId) {
        boolean result = false;
        try {
            zone = em.find(ZoneMaster.class, zoneId);
            //JOptionPane.showMessageDialog(null, zone);
            List<WardMaster> wardInZone = zone.getWardMasterList();
            //JOptionPane.showMessageDialog(null, wardInZone);
            if (!wardInZone.contains(ward)) {
                //JOptionPane.showMessageDialog(null, "coming");
                wardInZone.add(ward);
                ward.setZoneMaster(zone);
                zone.setWardMasterList(wardInZone);
                em.persist(ward);
                em.flush();
                em.merge(zone);
                em.flush();
                //JOptionPane.showMessageDialog(null, zone.getWardMasterList());
                result = true;
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e.getClass());
            logger.error("**CoreBean.addWard**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    @Override
    public boolean updateWard(WardMaster ward, Integer newZoneId) {
        boolean result = false;
        try {
            this.ward = em.find(WardMaster.class, ward.getWardId());
            if (!ward.getZoneMaster().getZoneId().equals(newZoneId)) {
                //remove old from database

                JOptionPane.showMessageDialog(null, ward);
                ZoneMaster zmd = em.find(ZoneMaster.class, ward.getZoneMaster().getZoneId());
                //JOptionPane.showMessageDialog(null, zmd);
                List<WardMaster> listWardsdb = zmd.getWardMasterList();
                //JOptionPane.showMessageDialog(null, listWardsdb);
                if (listWardsdb.contains(this.ward)) {
                    listWardsdb.remove(this.ward);
                }

                //add new from updated
                ZoneMaster zmu = em.find(ZoneMaster.class, newZoneId);
                //JOptionPane.showMessageDialog(null, zmu);
                List<WardMaster> listWardsup = zmu.getWardMasterList();
                //JOptionPane.showMessageDialog(null, listWardsup);
                if (!listWardsup.contains(ward)) {
                    listWardsup.add(ward);
                    zmu.setWardMasterList(listWardsup);
                }
                em.merge(zmu);
                em.merge(zmd);
                //JOptionPane.showMessageDialog(null, listWardsdb);
                //JOptionPane.showMessageDialog(null, listWardsup);
                this.ward.setZoneMaster(zmu);
            }

            this.ward.setWardName(ward.getWardName());

            em.merge(this.ward);
            em.flush();
            result = true;
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e.getClass());
            logger.error("**CoreBean.updateWard**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    @Override
    public boolean deleteWard(Integer wardId) {
        boolean result = false;
        try {
            ward = em.find(WardMaster.class, wardId);

            //zone-ward (1-many)
            ZoneMaster zm = ward.getZoneMaster();
            List<WardMaster> listWards = zm.getWardMasterList();
            //JOptionPane.showMessageDialog(null, listWards);
            if (listWards.contains(ward)) {
                listWards.remove(ward);
                zm.setWardMasterList(listWards);
            }

            em.merge(zm);
            em.remove(ward);
            em.flush();
            //JOptionPane.showMessageDialog(null, zm.getWardMasterList());
            result = true;
        } catch (Exception e) {
            logger.error("**CoreBean.deleteWard**" + e.getClass() + " " + e.getMessage());
            //JOptionPane.showMessageDialog(null, e.getClass());
        }
        return result;
    }

    @Override
    public List<WardMaster> getAllWards() {
        List<WardMaster> listAllWards = null;
        try {
            listAllWards = em.createNamedQuery("WardMaster.findAll").getResultList();
        } catch (Exception e) {
            logger.error("**CoreBean.getAllWards**" + e.getClass() + " " + e.getMessage());
        }
        return listAllWards;
    }

    @Override
    public WardMaster getWard(Integer wardId) {
        try {
            ward = em.find(WardMaster.class, wardId);
            return ward;
        } catch (Exception e) {
            logger.error("**CoreBean.getWard**" + e.getClass() + " " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<SubWardMaster> getSubWardsOfWard(Integer wardId) {
        List listSubwards = null;
        try {
            this.ward = em.find(WardMaster.class, wardId);
            listSubwards = this.ward.getSubWardMasterList();
        } catch (Exception e) {
            logger.error("**CoreBean.getSubWardsOfWard**" + e.getClass() + " " + e.getMessage());
        }
        return listSubwards;
    }

    @Override
    public List<CitizenMaster> getCitizensOfWard(Integer wardId) {
        List<CitizenMaster> listCitizens = null;
        try {
            WardMaster wm = em.find(WardMaster.class, wardId);
            listCitizens = wm.getCitizenMasterList();
        } catch (Exception e) {
            logger.error("**CoreBean.getCitizensOfWard**" + e.getClass() + " " + e.getMessage());
        }
        return listCitizens;
    }

    @Override
    public List<CandidateMaster> getCandidatesOfWard(Integer wardId) {
        List<CandidateMaster> listCandidates = null;
        try {
            WardMaster wm = em.find(WardMaster.class, wardId);
            listCandidates = wm.getCandidateMasterList();
        } catch (Exception e) {
            logger.error("**CoreBean.getCandidatesOfWard**" + e.getClass() + " " + e.getMessage());
        }
        return listCandidates;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="SubWard Code">
    @Override
    public boolean addSubWard(SubWardMaster subward, Integer wardId) {
        boolean result = false;
        try {
            this.ward = em.find(WardMaster.class, wardId);
            //JOptionPane.showMessageDialog(null, ward);
            List<SubWardMaster> subwardInWard = ward.getSubWardMasterList();
            if (!subwardInWard.contains(subward)) {
                subwardInWard.add(subward);
                subward.setWardMaster(ward);
                ward.setSubWardMasterList(subwardInWard);
                em.persist(subward);
                em.flush();
                em.merge(this.ward);
                em.flush();
                result = true;
                // JOptionPane.showMessageDialog(null, subwardInWard);
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e.getClass());
            logger.error("**CoreBean.addSubWard**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    @Override
    public boolean updateSubWard(SubWardMaster subward, Integer newWardId) {
        boolean result = false;
        try {

            //remove old from db
            this.subward = em.find(SubWardMaster.class, subward.getSubWardId());
            WardMaster wmd = this.subward.getWardMaster();
            if (!wmd.getWardId().equals(newWardId)) {

                List<SubWardMaster> listSubWarddb = wmd.getSubWardMasterList();
                //JOptionPane.showMessageDialog(null, listSubWarddb);
                if (listSubWarddb.contains(this.subward)) {
                    listSubWarddb.remove(this.subward);
                    wmd.setSubWardMasterList(listSubWarddb);
                }

                //add new to updated data
                WardMaster wmu = em.find(WardMaster.class, newWardId);
                List<SubWardMaster> listSubWardup = wmu.getSubWardMasterList();
                //JOptionPane.showMessageDialog(null, listSubWardup);
                if (!listSubWardup.contains(this.subward)) {
                    listSubWardup.add(this.subward);
                    wmu.setSubWardMasterList(listSubWardup);
                }
                em.merge(wmd);
                em.merge(wmu);
                //JOptionPane.showMessageDialog(null, "after " + listSubWarddb);
                //JOptionPane.showMessageDialog(null, "after " + listSubWardup);
                this.subward.setWardMaster(wmu);
            }

            this.subward.setSubWardName(subward.getSubWardName());
            em.merge(this.subward);
            em.flush();
            result = true;
        } catch (Exception e) {
            logger.error("**CoreBean.updateSubWard**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    @Override
    public SubWardMaster getSubWard(Integer subwardId) {
        subward = null;
        try {
            subward = em.find(SubWardMaster.class, subwardId);
        } catch (Exception e) {
            logger.error("**CoreBean.getSubWard**" + e.getClass() + " " + e.getMessage());
        }
        return subward;
    }

    @Override
    public boolean deleteSubWard(Integer subwardId) {
        boolean result = false;
        try {
            subward = em.find(SubWardMaster.class, subwardId);
            //ward-subward (1-many)
            WardMaster wm = subward.getWardMaster();
            List<SubWardMaster> listSubWards = wm.getSubWardMasterList();
            //JOptionPane.showMessageDialog(null, listSubWards);
            if (listSubWards.contains(subward)) {
                listSubWards.remove(subward);
                wm.setSubWardMasterList(listSubWards);
            }
            em.remove(subward);
            em.merge(wm);
            em.flush();
            //JOptionPane.showMessageDialog(null, wm.getSubWardMasterList());
            result = true;
        } catch (Exception e) {
            logger.error("**CoreBean.deleteSubWard**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    @Override
    public List<SubWardMaster> getAllSubwards() {
        List<SubWardMaster> listAllSubwards = null;
        try {
            listAllSubwards = em.createNamedQuery("SubWardMaster.findAll").getResultList();
        } catch (Exception e) {
            logger.error("**CoreBean.getAllSubwards**" + e.getClass() + " " + e.getMessage());
        }
        return listAllSubwards;
    }

    @Override
    public List<AreaMaster> getAreaOfSubward(Integer subwardId) {
        List<AreaMaster> listAreas = null;
        try {
            subward = em.find(SubWardMaster.class, subwardId);
            listAreas = subward.getAreaMasterList();
        } catch (Exception e) {
            logger.error("**CoreBean.getAreaOfSubward**" + e.getClass() + " " + e.getMessage());
        }
        return listAreas;
    }

    @Override
    public List<CandidateMaster> getCandidatesOfSubward(Integer subwardId) {
        List<CandidateMaster> listCandidates = null;
        try {
            SubWardMaster sm = em.find(SubWardMaster.class, subwardId);
            listCandidates = sm.getCandidateMasterList();
        } catch (Exception e) {
            logger.error("**CoreBean.getCandidatesOfSubward**" + e.getClass() + " " + e.getMessage());
        }
        return listCandidates;
    }

    @Override
    public List<CitizenMaster> getCitizensOfSubward(Integer subwardId) {
        List<CitizenMaster> listCitizens = null;
        try {
            SubWardMaster sm = em.find(SubWardMaster.class, subwardId);
            listCitizens = sm.getCitizenMasterList();
        } catch (Exception e) {
            logger.error("**CoreBean.getCitizensOfSubward**" + e.getClass() + " " + e.getMessage());
        }
        return listCitizens;
    }

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Area Code">
    @Override
    public boolean addArea(AreaMaster area, Integer subwardId) {
        boolean result = false;
        try {
            this.subward = em.find(SubWardMaster.class, subwardId);
            List<AreaMaster> areaInSubward = this.subward.getAreaMasterList();
            if (!areaInSubward.contains(area)) {
                areaInSubward.add(area);
                area.setSubWardMaster(this.subward);
                this.subward.setAreaMasterList(areaInSubward);
                em.persist(area);
                em.flush();
                em.merge(this.subward);
                em.flush();
                result = true;
                //JOptionPane.showMessageDialog(null, areaInSubward);
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e.getClass());
            logger.error("**CoreBean.addArea**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    @Override
    public boolean updateArea(AreaMaster area, Integer newSubwardId) {
        boolean result = false;
        try {
            this.area = em.find(AreaMaster.class, area.getAreaId());
            //JOptionPane.showMessageDialog(null, newSubwardId);
            //JOptionPane.showMessageDialog(null, this.area.getSubWardMaster().getSubWardId());

            SubWardMaster sbd = this.area.getSubWardMaster();
            if (!sbd.getSubWardId().equals(newSubwardId)) {

                //remove old from db
                List<AreaMaster> listAreadb = sbd.getAreaMasterList();
                //JOptionPane.showMessageDialog(null, "before db" + listAreadb);
                if (listAreadb.contains(this.area)) {
                    //JOptionPane.showMessageDialog(null, "contains-remove then");
                    listAreadb.remove(this.area);
                    sbd.setAreaMasterList(listAreadb);
                }

                //add new to updated
                SubWardMaster sbu = em.find(SubWardMaster.class, newSubwardId);
                List<AreaMaster> listAreaup = sbu.getAreaMasterList();
                //JOptionPane.showMessageDialog(null, "before up" + listAreaup);
                if (!listAreaup.contains(this.area)) {
                    //JOptionPane.showMessageDialog(null, "doesnot contains-add then");
                    listAreaup.add(this.area);
                    sbu.setAreaMasterList(listAreaup);
                }
                em.merge(sbd);
                em.merge(sbu);
                this.area.setSubWardMaster(sbu);
                //JOptionPane.showMessageDialog(null, listAreadb);
                //JOptionPane.showMessageDialog(null, listAreaup);
            }

            this.area.setAreaName(area.getAreaName());
            em.merge(this.area);
            em.flush();
            //em.refresh(this.area);
            // JOptionPane.showMessageDialog(null, "success");
            result = true;
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e.getClass());
            logger.error("**CoreBean.updateArea**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    @Override
    public boolean deleteArea(Integer areaId) {
        boolean result = false;
        try {
            area = em.find(AreaMaster.class, areaId);
            SubWardMaster sb = area.getSubWardMaster();
            List<AreaMaster> listAreas = sb.getAreaMasterList();
            if (listAreas.contains(area)) {
                listAreas.remove(area);
                sb.setAreaMasterList(listAreas);
            }
            em.remove(area);
            em.merge(sb);
            em.flush();
            //       JOptionPane.showMessageDialog(null, sb.getAreaMasterList());
            result = true;
        } catch (Exception e) {
            logger.error("**CoreBean.deleteArea**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    @Override
    public AreaMaster getArea(Integer areaId) {
        try {
            area = em.find(AreaMaster.class, areaId);
            return area;
        } catch (Exception e) {
            logger.error("**CoreBean.getArea**" + e.getClass() + " " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<AreaMaster> getAllAreas() {
        List<AreaMaster> listAllAreas = null;
        try {
            listAllAreas = em.createNamedQuery("AreaMaster.findAll").getResultList();
        } catch (Exception e) {
            logger.error("**CoreBean.getAllAreas**" + e.getClass() + " " + e.getMessage());
        }
        return listAllAreas;
    }

    @Override
    public List<CandidateMaster> getCandidatesOfArea(Integer areaId) {
        List<CandidateMaster> listCandidates = null;
        try {
            AreaMaster am = em.find(AreaMaster.class, areaId);
            listCandidates = am.getCandidateMasterList();
        } catch (Exception e) {
            logger.error("**CoreBean.getCandidatesOfArea**" + e.getClass() + " " + e.getMessage());
        }
        return listCandidates;
    }

    @Override
    public List<CitizenMaster> getCitizensOfArea(Integer areaId) {
        List<CitizenMaster> listCitizens = null;
        try {
            AreaMaster am = em.find(AreaMaster.class, areaId);
            listCitizens = am.getCitizenMasterList();
        } catch (Exception e) {
            logger.error("**CoreBean.getCitizensOfArea**" + e.getClass() + " " + e.getMessage());
        }
        return listCitizens;
    }

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="PartyMaster code">
    @Override
    public boolean addParty(PartyMaster pm) {
        boolean result = false;
        try {
            if (checkForExistingParty(pm) == true) {
                return result;
            }
            em.persist(pm);
            em.flush();
            result = true;
        } catch (Exception e) {
            logger.error("**CoreBean.addParty**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    @Override
    public boolean checkForExistingParty(PartyMaster pm) {
        boolean result = false;
        try {
            // JOptionPane.showMessageDialog(null, pm);
            party = (PartyMaster) em.createNamedQuery("PartyMaster.findByPartyName").setParameter("partyName", pm.getPartyName()).getSingleResult();
            // JOptionPane.showMessageDialog(null, party);
            result = true;
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e.getClass());
            logger.error("**CoreBean.checkForExistingParty**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    @Override
    public PartyMaster getParty(Integer partyID) {
        PartyMaster party = null;
        try {
            party = em.find(PartyMaster.class, partyID);
        } catch (Exception e) {
            logger.error("**CoreBean.getParty**" + e.getClass() + " " + e.getMessage());
        }
        return party;
    }

    @Override
    public List<CandidateMaster> getActiveCandidatesOfParty(Integer partyID) {
        List<CandidateMaster> returnList = null;
        try {
            //JOptionPane.showMessageDialog(null, "coming candidates of party");
            party = em.find(PartyMaster.class, partyID);
            List<CandidateMaster> allCandidatesOfParty = party.getCandidateMasterList();
            returnList = new Vector<CandidateMaster>();
            Iterator<CandidateMaster> iterator = allCandidatesOfParty.iterator();
            while (iterator.hasNext()) {
                CandidateMaster candidate = iterator.next();
                if (candidate.getIsActive()) {
                    returnList.add(candidate);
                }
            }
        } catch (Exception e) {
            logger.error("**CoreBean.getCandidatesOfParty**" + e.getClass() + " " + e.getMessage());
        }
        return returnList;
    }

    @Override
    public boolean updateParty(PartyMaster pm) {
        boolean result = false;
        try {
            party = em.find(PartyMaster.class, pm.getPartyId());
            party.setPartyName(pm.getPartyName());
            party.setDescription(pm.getDescription());
            party.setPartySlogan(pm.getPartySlogan());
            party.setPartyLogo(pm.getPartyLogo());
            em.merge(party);
            em.flush();
            result = true;
        } catch (Exception e) {
            logger.error("**CoreBean.updateParty**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    @Override
    public boolean deleteParty(Integer partyID) {
        boolean result = false;
        try {
            party = em.find(PartyMaster.class, partyID);
            em.remove(party);
            em.flush();
            result = true;
        } catch (Exception e) {
            logger.error("**CoreBean.deleteParty**" + e.getClass() + " " + e.getMessage());
        }
        return result;
    }

    @Override
    public List<PartyMaster> getAllParties() {
        List<PartyMaster> listAllParties = null;
        try {
            listAllParties = em.createNamedQuery("PartyMaster.findAll").getResultList();
        } catch (Exception e) {
            logger.error("**CoreBean.getAllParties**" + e.getClass() + " " + e.getMessage());
        }
        return listAllParties;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CityMaster">
    @Override
    public boolean addCity(CityMaster cm) {
        try {
            em.persist(cm);
            em.flush();
            return true;
        } catch (Exception e) {
            logger.error("**CoreBean.addCity**" + e.getClass() + " " + e.getMessage());
        }
        return false;
    }

    @Override
    public List<CityMaster> getAllCities() {
        try {
            //JOptionPane.showMessageDialog(null, "getall");
            List<CityMaster> cityList = em.createNamedQuery("CityMaster.findAll").getResultList();
            // JOptionPane.showMessageDialog(null, cityList);
            return cityList;
        } catch (Exception e) {
            logger.error("**CoreBean.getAllCities**" + e.getClass() + " " + e.getMessage());
        }
        return null;
    }

    @Override
    public CityMaster getCity(Integer cityMasterId) {
        try {
            //JOptionPane.showMessageDialog(null, "ejb" + cityMasterId);
            CityMaster cm = em.find(CityMaster.class, cityMasterId);
            //JOptionPane.showMessageDialog(null, "ejb" + cm);
            return cm;
        } catch (Exception e) {
            logger.error("**CoreBean.getCity**" + e.getClass() + " " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<ZoneMaster> getZonesOfCity(Integer cityId) {
        List<ZoneMaster> listZones = null;
        try {
            CityMaster cm = em.find(CityMaster.class, cityId);
            listZones = cm.getZoneMasterList();
        } catch (Exception e) {
            logger.error("**CoreBean.getZonesOfCity**" + e.getClass() + " " + e.getMessage());
        }
        return listZones;
    }
    // </editor-fold>
}

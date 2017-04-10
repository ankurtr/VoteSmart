/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenbeans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import service.CandidateMaster;
import service.CitizenMaster;
import service.EPollWebService;
import service.EPollWebServiceService;
import service.PartyMaster;
import service.XmlHashMapHelperII;
import service.XmlHashMapII;
import service.XmlHashMapWrapperII;

/**
 *
 * @author root
 */
public class VoteBean {

    private List<CandidateMaster> candidateList;
    private List<PartyMaster> partyList;
    private EPollWebServiceService service;
    private EPollWebService port;
    private Integer wardId;
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;
    private Map<Integer, List<CandidateMaster>> map = new HashMap<Integer, List<CandidateMaster>>();
    private Map<String, Boolean> partyChecked = new HashMap<String, Boolean>();
    private Map<String, Boolean> checked = new HashMap<String, Boolean>();
    private Set<Integer> selectedCandidates;
    private CitizenMaster cm;

    /** Creates a new instance of VoteBean */
    public VoteBean() {
    }

    public Map<String, Boolean> getChecked() {
        return checked;
    }

    public void setChecked(Map<String, Boolean> checked) {
        //JOptionPane.showMessageDialog(null,"check " + checked);
        this.checked = checked;
    }

    public Map<String, Boolean> getPartyChecked() {
        return partyChecked;
    }

    public void setPartyChecked(Map<String, Boolean> partyChecked) {
        //JOptionPane.showMessageDialog(null,"set check party" +  partyChecked);
        this.partyChecked = partyChecked;
    }

    @PostConstruct
    public void initialise() {
        try {

            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            session = request.getSession();

//            if(session.getAttribute("bioidentified")!= null && session.getAttribute("bioidentified").equals("true"))
//            {
//                JOptionPane.showMessageDialog(null, "you are not identified by biometric security");
//                request.logout();
//                session.invalidate();
//                response.sendRedirect("/VoteSmart/LoginPage.jsf");
//            }
            //wardId=session.get
            Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
            partyList = new ArrayList<PartyMaster>();
            selectedCandidates = new HashSet<Integer>();

            //service = new EPollWebServiceService();
            //port = service.getEPollWebServicePort();
            port = (EPollWebService) session.getAttribute("port");
            cm = (CitizenMaster) session.getAttribute("citizenmaster");

            //JOptionPane.showMessageDialog(null, cm.getWardMaster().getWardId());
            XmlHashMapII xmap = port.getActiveCandidatesWithPartyId(Integer.valueOf(cm.getWardMaster().getWardId()));

            //JOptionPane.showMessageDialog(null, map);
            XmlHashMapWrapperII mapWrapper = xmap.getMap();
            List<XmlHashMapHelperII> list = mapWrapper.getListOfKeyValuePairs();
            Iterator<XmlHashMapHelperII> iterator = list.iterator();
            while (iterator.hasNext()) {
                XmlHashMapHelperII ii = iterator.next();
                tempMap.put(ii.getKey(), ii.getValue());
            }

            HashSet<Integer> set = new HashSet<Integer>(tempMap.values());

            Iterator<Integer> pIterator = set.iterator();
            while (pIterator.hasNext()) {
                Integer partyId = pIterator.next();
                PartyMaster party = port.getParty(partyId);
                partyList.add(party);

                List<CandidateMaster> cList = new ArrayList<CandidateMaster>();
                Set<Integer> cset = tempMap.keySet();
                Iterator<Integer> it = cset.iterator();
                while (it.hasNext()) {
                    Integer candidateId = it.next();
                    if (tempMap.get(candidateId).equals(partyId)) {
                        cList.add(port.getCandidate(candidateId));
                    }
                }
                //   JOptionPane.showMessageDialog(null, cList);
                map.put(partyId, cList);
            }
            //JOptionPane.showMessageDialog(null, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<PartyMaster> getPartyList() {
        return partyList;
    }

    public void setPartyList(List<PartyMaster> partyList) {
        this.partyList = partyList;
    }

    public Integer getWardId() {
        return wardId;
    }

    public void setWardId(Integer wardId) {
        this.wardId = wardId;
    }

    public List<CandidateMaster> fetchCandidateOfParty(Integer partyId) {
        //JOptionPane.showMessageDialog(null, map.get(partyId));
        return map.get(partyId);
    }

    public String castVote() {
        String retval = null;
        try {
//            JOptionPane.showMessageDialog(null, partyChecked);
//            JOptionPane.showMessageDialog(null, checked);
//            
            for (Map.Entry<String, Boolean> val : partyChecked.entrySet()) {
                if (val.getValue()) {
                    List<CandidateMaster> tempList = fetchCandidateOfParty(Integer.valueOf(val.getKey()));
                    Iterator<CandidateMaster> iterator = tempList.iterator();
                    while (iterator.hasNext()) {
                        selectedCandidates.add(Integer.valueOf(iterator.next().getCandidateId()));
                    }
                }
            }
            for (Map.Entry<String, Boolean> val : checked.entrySet()) {
                if (val.getValue()) {
                    selectedCandidates.add(Integer.valueOf(val.getKey()));
                }
            }
            //JOptionPane.showMessageDialog(null, "selected all :-" + selectedCandidates);
            if (selectedCandidates.size() > 3) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please select 3 candidates only", "Please select 3 candidates only");
                FacesContext.getCurrentInstance().addMessage("msg", msg);
            } else if (selectedCandidates.size() < 3) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please select 3 candidates", "Please select 3 candidates");
                FacesContext.getCurrentInstance().addMessage("msg", msg);
            } else {
                if (port.isValidToVote(Integer.valueOf(cm.getUserId()))) {
                    boolean result = port.castVote(Integer.valueOf(cm.getUserId()), new ArrayList<Integer>(selectedCandidates));
                    if (result) {
                        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Your vote saved successfully", "Your vote saved successfully");
                        FacesContext.getCurrentInstance().addMessage("msg", msg);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getClass());
        }
        return retval;
    }
}

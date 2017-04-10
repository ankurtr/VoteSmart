/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adminbeans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.xml.datatype.XMLGregorianCalendar;
import service.CandidateMaster;
import service.EPollWebService;
import service.ElectionMaster;
import service.ElectionTypeMaster;
import service.WardMaster;
import service.ZoneMaster;

/**
 *
 * @author ankur
 */
public class ElectionBean {

    private EPollWebService port;
    private Integer electionId;
    private String name;
    private XMLGregorianCalendar finalDate;
    private XMLGregorianCalendar startTime;
    private XMLGregorianCalendar endTime;
    private Integer electionTypeId;
    private boolean isActive;
    private ElectionMaster electionObj;
    private List<ElectionMaster> electionList;
    private List<ElectionTypeMaster> electionTypeList;
    private List<CandidateMaster> candidateList;
    private List<ZoneMaster> zoneList;
    private List<WardMaster> wardList;
    private Integer selectedZone;
    private Integer selectedWard;
    private Set<Integer> selectedCandidates;
    private Set<Integer> allSelectedCandidates;
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;
    private int currentPage = 0;
    private int pageRows = 5;
    private int totalPages;
    private String pageList;
    private String searchText;
    private Integer maxResults = 2;
    private Integer firstPage = 0;
    private String msg;
    private Map<String, Boolean> checked = new HashMap<String, Boolean>();
    private Integer selectedElection;

    /** Creates a new instance of ElectionBean */
    public ElectionBean() {
    }

    public Integer getSelectedElection() {
        return selectedElection;
    }

    public void setSelectedElection(Integer selectedElection) {
        this.selectedElection = selectedElection;
    }

    @PostConstruct
    public void initialise() {
        try {
            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            session = request.getSession(false);
            port = (EPollWebService) session.getAttribute("port");

            electionList = port.getAllElections();
            electionTypeList = port.getAllElectionTypes();
            zoneList = port.getAllZones();
            wardList = port.getAllWards();
            allSelectedCandidates = new HashSet<Integer>();
            selectedCandidates = new HashSet<Integer>();

            totalPages = electionList.size() / pageRows;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public void change(AjaxBehaviorEvent e) {
        pageRows = Integer.valueOf(pageList);
        totalPages = electionList.size() / pageRows;
    }

    public void next(AjaxBehaviorEvent e) {
        if (currentPage != totalPages) {
            currentPage = currentPage + 1;
            firstPage = (currentPage * pageRows);
        }
    }

    public void first(AjaxBehaviorEvent e) {
        firstPage = currentPage = 0;
    }

    public void previous(AjaxBehaviorEvent e) {
        if (currentPage != 0) {
            currentPage = currentPage - 1;
            firstPage = (currentPage * pageRows);
        }
    }

    public void last(AjaxBehaviorEvent e) {
        currentPage = totalPages;
        firstPage = (currentPage * pageRows);
    }

    public String save() {
        boolean result = false;
        String retval = null;
        Calendar cal = null;
        XMLGregorianCalendar xcal = null;
        List<Integer> list = null;
        try {
            if (electionId == null) {
                cal = Calendar.getInstance();

                electionObj = new ElectionMaster();
                electionObj.setName(name);

                electionObj.setFinalDate(finalDate);

                electionObj.setStartTime(startTime);

                electionObj.setEndTime(endTime);

                electionObj.setIsActive(false);
                list = new ArrayList<Integer>(allSelectedCandidates);
                result = port.addElection(electionObj, electionTypeId, list);
                msg = "Record is Added Successfully";
                retval = "electionSaved";
            } else {
                electionObj = port.getElection(electionId);
                electionObj.setName(name);

                electionObj.setFinalDate(finalDate);

                electionObj.setStartTime(startTime);

                electionObj.setEndTime(endTime);

                electionObj.setIsActive(false);
                list = new ArrayList<Integer>(allSelectedCandidates);

                result = port.updateElection(electionObj, electionTypeId, list);

                msg = "Record is Updated Successfully";
                retval = "electionSaved";
            }
            electionList = port.getAllElections();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "save" + e.getMessage() + " " + e.getClass());
        } finally {
            electionObj = null;
        }
        return retval;
    }

    public String add() {
        // JOptionPane.showMessageDialog(null, "add");
        name = null;
        finalDate = null;
        startTime =null;
        endTime = null;
        electionTypeId = null;
        isActive = false;
        allSelectedCandidates=null;
        return "addNewElection";
    }

    public String edit() {
        String retval = null;
        //JOptionPane.showMessageDialog(null, "edit");
        try {
            electionObj = port.getElection(electionId);
            name = electionObj.getName();
            finalDate = electionObj.getFinalDate();
            startTime = electionObj.getStartTime();
            endTime = electionObj.getEndTime();
            electionTypeId = Integer.valueOf(electionObj.getElectionTypeMaster().getElectionTypeId());
            isActive = electionObj.isIsActive();
            retval = "editElection";
        } catch (Exception e) {
        }
        return retval;
    }

    public void sort() {
    }

    public String search() {
        try {
            if (searchText != null) {
                electionList = port.searchElectionByName(searchText, maxResults);
            }
        } catch (Exception e) {
        }
        return "search";
    }

    public void selectCandidates() {
        JOptionPane.showMessageDialog(null, checked);
        for (Map.Entry<String, Boolean> m : checked.entrySet()) {
            if (m.getValue()) {
                selectedCandidates.add(Integer.valueOf(m.getKey()));
            } else if (selectedCandidates.contains(Integer.valueOf(m.getKey()))) {
                selectedCandidates.remove(Integer.valueOf(m.getKey()));
            }
        }
        if(allSelectedCandidates==null)
        {
            allSelectedCandidates=new HashSet<Integer>();
        }
        allSelectedCandidates.addAll(selectedCandidates);
        //JOptionPane.showMessageDialog(null, selectedCandidates);
    }

    public void zoneSelectionChanged(AjaxBehaviorEvent e) {
        wardList = port.getWardsOfZone(selectedZone);
    }

    public void wardSelectionChanged(AjaxBehaviorEvent e) {
        try {
            //JOptionPane.showMessageDialog(null, "coming here" + selectedWard);
            candidateList = port.getCandidatesOfWard(selectedWard);
            //JOptionPane.showMessageDialog(null, "coming here" + candidateList);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void viewAllElections() {
        electionList = port.getAllElections();
    }

    public String scheduleElection() {
        String retval = null;
        boolean result = false;
        try {
            result = port.scheduleElection(selectedElection);
            List<ElectionMaster> list = port.getScheduledElections();
            JOptionPane.showMessageDialog(null, list);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getClass());
        }
        return "scheduleElection";
    }

    public void electionSelectionChanged(AjaxBehaviorEvent e) {
        electionObj = null;
        try {
            electionObj = port.getElection(selectedElection);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getClass());
        }
    }

    public String getClientId() {
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot root = context.getViewRoot();

        final String componentId = "electionDetails";
        UIComponent c = findComponent(root, componentId);
        if (c != null) {
            JOptionPane.showMessageDialog(null, c);
            c.setRendered(true);
        }
        return c.getClientId(context);
    }

    /**
     * Finds component with the given id
     */
    private UIComponent findComponent(UIComponent c, String id) {
        if (id.equals(c.getId())) {
            return c;
        }
        Iterator<UIComponent> kids = c.getFacetsAndChildren();
        while (kids.hasNext()) {
            UIComponent found = findComponent(kids.next(), id);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc="properties">
    public Map<String, Boolean> getChecked() {
        return checked;
    }

    public void setChecked(Map<String, Boolean> checked) {
        JOptionPane.showMessageDialog(null, checked);
        this.checked = checked;
    }

    public List<CandidateMaster> getCandidateList() {
        return candidateList;
    }

    public void setCandidateList(List<CandidateMaster> candidateList) {
        this.candidateList = candidateList;
    }

    public Integer getSelectedWard() {
        return selectedWard;
    }

    public void setSelectedWard(Integer selectedWard) {
        this.selectedWard = selectedWard;
    }

    public Integer getSelectedZone() {
        return selectedZone;
    }

    public void setSelectedZone(Integer selectedZone) {
        this.selectedZone = selectedZone;
    }

    public List<ElectionMaster> getElectionList() {
        return electionList;
    }

    public void setElectionList(List<ElectionMaster> electionList) {
        this.electionList = electionList;
    }

    public List<ElectionTypeMaster> getElectionTypeList() {
        return electionTypeList;
    }

    public void setElectionTypeList(List<ElectionTypeMaster> electionTypeList) {
        this.electionTypeList = electionTypeList;
    }

    public Integer getElectionId() {
        return electionId;
    }

    public void setElectionId(Integer electionId) {
        this.electionId = electionId;
    }

    public Integer getElectionTypeId() {
        return electionTypeId;
    }

    public void setElectionTypeId(Integer electionTypeId) {
        this.electionTypeId = electionTypeId;
    }

    public XMLGregorianCalendar getEndTime() {
        return endTime;
    }

    public void setEndTime(XMLGregorianCalendar endTime) {
        this.endTime = endTime;
    }

    public XMLGregorianCalendar getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(XMLGregorianCalendar finalDate) {
        this.finalDate = finalDate;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public XMLGregorianCalendar getStartTime() {
        return startTime;
    }

    public void setStartTime(XMLGregorianCalendar startTime) {
        this.startTime = startTime;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(Integer firstPage) {
        this.firstPage = firstPage;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    public String getPageList() {
        return pageList;
    }

    public void setPageList(String pageList) {
        this.pageList = pageList;
    }

    public int getPageRows() {
        return pageRows;
    }

    public void setPageRows(int pageRows) {
        this.pageRows = pageRows;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public ElectionMaster getElectionObj() {
        return electionObj;
    }

    public void setElectionObj(ElectionMaster electionObj) {
        this.electionObj = electionObj;
    }

    public Set<Integer> getSelectedCandidates() {
        return selectedCandidates;
    }

    public void setSelectedCandidates(Set<Integer> selectedCandidates) {
        this.selectedCandidates = selectedCandidates;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<WardMaster> getWardList() {
        return wardList;
    }

    public void setWardList(List<WardMaster> wardList) {
        this.wardList = wardList;
    }

    public List<ZoneMaster> getZoneList() {
        return zoneList;
    }

    public void setZoneList(List<ZoneMaster> zoneList) {
        this.zoneList = zoneList;
    }
    // </editor-fold>    
}

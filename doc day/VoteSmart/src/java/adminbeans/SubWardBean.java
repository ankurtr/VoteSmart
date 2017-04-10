/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adminbeans;

import comparators.SubWardNameAsc;
import comparators.SubWardNameDesc;
import comparators.SubWardWardNameAsc;
import comparators.SubWardWardNameDesc;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.xml.ws.WebServiceRef;
import service.WardMaster;
import service.EPollWebService;
import service.EPollWebServiceService;
import service.SubWardMaster;
import service.ZoneMaster;

/**
 *
 * @author ankur
 */
public class SubWardBean {

    private EPollWebService port;
    private List<SubWardMaster> subWardList;
    private List<WardMaster> wardList;
    private String msg;
    private Integer selectedWard;
    private String subWardName;
    private Integer subWardId;
    private SubWardMaster subWardObj;
    private Map<Integer, Boolean> checked = new HashMap<Integer, Boolean>();    
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
    private FacesContext context = null;
    private FacesMessage message = null;

    /** Creates a new instance of SubWardBean */
    public SubWardBean() {
    }

    @PostConstruct
    public void initialise() {
        try {
            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            session = request.getSession(false);
            port = (EPollWebService) session.getAttribute("port");
            // port = service.getEPollWebServicePort();

//            if (request.getQueryString()!=null) {
//                if (request.getParameter("action") != null) {
//                    if (request.getParameter("action").equals("edit")) {
//                        subWardId = Integer.valueOf(request.getParameter("id"));
//                        if (subWardId != null) {
//                            subWardObj = port.getSubWard(subWardId);
//                            subWardName = subWardObj.getSubWardName();
//                            wardId = Integer.valueOf(subWardObj.getWardMaster().getWardId());
//                        }
//                    } else if (request.getParameter("action").equals("delete")) {
//                        subWardId = Integer.valueOf(request.getParameter("id"));
//                        deleteFromLink();
//                    }
//                }
//            }

            loadAllSubWard();
            wardList = port.getAllWards();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public void change(AjaxBehaviorEvent e) {
        pageRows = Integer.valueOf(pageList);
        totalPages = subWardList.size() / pageRows;
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

    public String delete() {
        boolean result = false;
        String retval = null;
        context = FacesContext.getCurrentInstance();
        int answer = JOptionPane.showConfirmDialog(null, "Are you sure want to delete?", "ALERT", JOptionPane.YES_NO_OPTION);
        try {
            if (answer == 0) {
                Iterator<SubWardMaster> i = subWardList.iterator();
                for (SubWardMaster item : subWardList) {
                    if (checked.get(Integer.valueOf(item.getSubWardId()))) {
                        port.deleteSubWard(Integer.valueOf(item.getSubWardId()));
                    }
                }
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "SubWard Deleted Successfully", "SubWard Deleted Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while deleting the SubWard", "Some error occured while deleting the SubWard");
                }
                context.addMessage("msg", message);
                loadAllSubWard();
                retval = "subWardDeleted";
            }
        } catch (Exception e) {
        }
        return retval;
    }

    public String deleteFromLink() {
        boolean result = false;
        String retval = null;
        context = FacesContext.getCurrentInstance();
        int answer = JOptionPane.showConfirmDialog(null, "Are you sure want to delete?", "ALERT", JOptionPane.YES_NO_OPTION);
        try {
            if (answer == 0) {
                result = port.deleteSubWard(subWardId);
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "SubWard Deleted Successfully", "SubWard Deleted Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while deleting the subward", "Some error occured while deleting the subward");
                }
                context.addMessage("msg", message);
                loadAllSubWard();
                retval = "subWardDeleted";
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return retval;
    }

    public String save() {
        boolean result = false;
        String retval = null;
        try {
            if (subWardId == null) {
                subWardObj = new SubWardMaster();
                subWardObj.setSubWardName(subWardName);
                result = port.addSubWard(subWardObj, selectedWard);
                //msg = "Record is Added Successfully";
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "SubWard Saved Successfully", "SubWard Saved Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while saving the subward", "Some error occured while saving the subward");
                }
                retval = "subWardSaved";
            } else {
                subWardObj = port.getSubWard(subWardId);
                subWardObj.setSubWardName(subWardName);
                result = port.updateSubWard(subWardObj, selectedWard);
                //msg = "Record is Updated Successfully";
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "SubWard Updated Successfully", "SubWard Updated Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while updating the subward", "Some error occured while updating the subward");
                }
                retval = "subWardSaved";
            }
            loadAllSubWard();
        } catch (Exception e) {
        }
        return retval;
    }

    public String edit() {
        subWardId = Integer.valueOf(subWardObj.getSubWardId());
        subWardName = subWardObj.getSubWardName();
        selectedWard = Integer.valueOf(subWardObj.getWardMaster().getWardId());
        return "editSubWard";
    }

    public String add() {

        subWardId = null;
        subWardName = null;
        selectedWard = null;
        return "addNewSubWard";
    }

    public void sort() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String by = req.getParameter("by");
        String order = req.getParameter("order");
        //JOptionPane.showMessageDialog(null, "by " + req.getParameter("by"));
        //JOptionPane.showMessageDialog(null, "order " + req.getParameter("order"));
        if (order.equals("asc")) {
            if (by.equals("subWardName")) {
                Collections.sort(subWardList, new SubWardNameAsc());
            } else if (by.equals("wardName")) {
                Collections.sort(subWardList, new SubWardWardNameAsc());
            }
        } else if (order.equals("desc")) {
            if (by.equals("subWardName")) {
                Collections.sort(subWardList, new SubWardNameDesc());
            } else if (by.equals("wardName")) {
                Collections.sort(subWardList, new SubWardWardNameDesc());
            }
        }
    }

    public String search() {
        try {
            if (searchText != null) {
                subWardList = port.searchBySubWardName(searchText, maxResults);
            }
        } catch (Exception e) {
        }
        return "search";
    }

    public void loadAllSubWard() {
        subWardList = port.getAllSubwards();
        totalPages = subWardList.size() / pageRows;
    }

    // <editor-fold defaultstate="collapsed" desc="properties">
    public Integer getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(Integer firstPage) {
        this.firstPage = firstPage;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getPageList() {
        return pageList;
    }

    public void setPageList(String pageList) {
        this.pageList = pageList;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPageRows() {
        return pageRows;
    }

    public void setPageRows(int pageRows) {
        this.pageRows = pageRows;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public Map<Integer, Boolean> getChecked() {
        return checked;
    }

    public void setChecked(Map<Integer, Boolean> checked) {
        this.checked = checked;
    }

    public Integer getSubWardId() {
        return subWardId;
    }

    public void setSubWardId(Integer subWardId) {
        this.subWardId = subWardId;
    }

    public Integer getSelectedWard() {
        return selectedWard;
    }

    public void setSelectedWard(Integer selectedWard) {
        this.selectedWard = selectedWard;
    }

    public SubWardMaster getSubWardObj() {
        return subWardObj;
    }

    public void setSubWardObj(SubWardMaster subWardObj) {
        this.subWardObj = subWardObj;
    }

    public String getSubWardName() {
        return subWardName;
    }

    public void setSubWardName(String subWardName) {
        this.subWardName = subWardName;
    }

    public List<SubWardMaster> getSubWardList() {
        return subWardList;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setSubWardList(List<SubWardMaster> subWardList) {
        this.subWardList = subWardList;
    }

    public List<WardMaster> getWardList() {
        return wardList;
    }

    public void setWardList(List<WardMaster> wardList) {
        this.wardList = wardList;
    }// </editor-fold>
}

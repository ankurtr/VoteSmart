/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adminbeans;

import comparators.AreaNameAsc;
import comparators.AreaNameDesc;
import comparators.AreaSubWardNameAsc;
import comparators.AreaSubWardNameDesc;
import java.io.Serializable;
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
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.xml.ws.WebServiceRef;
import service.SubWardMaster;
import service.EPollWebService;
import service.EPollWebServiceService;
import service.AreaMaster;

/**
 *
 * @author ankur
 */
public class AreaBean implements Serializable {

    private EPollWebService port;
    private List<AreaMaster> areaList;
    private List<SubWardMaster> subwardList;
    private String msg;
    private Integer selectedSubWard;
    private String areaName;
    private Integer areaId;
    private AreaMaster areaObj;
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
    private FacesContext context;
    private FacesMessage message;

    /** Creates a new instance of AreaBean */
    public AreaBean() {
    }

    @PostConstruct
    public void initialise() {
        try {
            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            session = request.getSession(false);
            port = (EPollWebService) session.getAttribute("port");
            //port = service.getEPollWebServicePort();

//            if (request.getQueryString() != null) {
//                if (request.getParameter("action") != null) {
//                    if (request.getParameter("action").equals("edit")) {
//                        AreaId = Integer.valueOf(request.getParameter("id"));
//                        if (AreaId != null) {
//                            AreaObj = port.getArea(AreaId);
//                            AreaName = AreaObj.getAreaName();
//                            SubWardId = Integer.valueOf(AreaObj.getSubWardMaster().getSubWardId());
//                        }
//                    } else if (request.getParameter("action").equals("delete")) {
//                        AreaId = Integer.valueOf(request.getParameter("id"));
//                        deleteFromLink();
//                    }
//                }
//            }

            loadAllArea();
            subwardList = port.getAllSubwards();



        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public void change(AjaxBehaviorEvent e) {
        pageRows = Integer.valueOf(pageList);
        totalPages = areaList.size() / pageRows;
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
                Iterator<AreaMaster> i = areaList.iterator();
                for (AreaMaster item : areaList) {
                    if (checked.get(Integer.valueOf(item.getAreaId()))) {
                        result = port.deleteArea(Integer.valueOf(item.getAreaId()));
                    }
                }
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Area Deleted Successfully", "Area Deleted Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while deleting the areas", "Some error occured while deleting the areas");
                }
                context.addMessage("msg", message);
                loadAllArea();
                retval = "areaDeleted";
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
                result = port.deleteArea(areaId);
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Area Deleted Successfully", "Area Deleted Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while deleting the area", "Some error occured while deleting the area");
                }
                context.addMessage("msg", message);
                retval = "areaDeleted";
                loadAllArea();
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
        context = FacesContext.getCurrentInstance();
        try {
            if (areaId == null) {
                areaObj = new AreaMaster();
                areaObj.setAreaName(areaName);
                result = port.addArea(areaObj, selectedSubWard);
                //msg = "Record is Added Successfully";
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Area Saved Successfully", "Area Saved Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while saving the area", "Some error occured while saving the area");
                }
                retval = "areaSaved";
            } else {
                areaObj = port.getArea(areaId);
                areaObj.setAreaName(areaName);
                result = port.updateArea(areaObj, selectedSubWard);
                //msg = "Record is Updated Successfully";
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Area Updated Successfully", "Area Updated Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while updating the area", "Some error occured while updating the area");
                }
                retval = "areaSaved";
            }
            loadAllArea();
        } catch (Exception e) {
        }
        return retval;
    }

    public String edit() {
        areaId = Integer.valueOf(areaObj.getAreaId());
        areaName = areaObj.getAreaName();
        selectedSubWard = Integer.valueOf(areaObj.getSubWardMaster().getSubWardId());
        return "editArea";
    }

    public String add() {
        areaId = null;
        areaName = null;
        selectedSubWard = null;
        return "addNewArea";
    }

    public void sort() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String by = req.getParameter("by");
        String order = req.getParameter("order");
        //JOptionPane.showMessageDialog(null, "by " + req.getParameter("by"));
        //JOptionPane.showMessageDialog(null, "order " + req.getParameter("order"));
        if (order.equals("asc")) {
            if (by.equals("areaName")) {
                Collections.sort(areaList,new AreaNameAsc());
            } else if (by.equals("subWardName")) {
                Collections.sort(areaList,new AreaSubWardNameAsc());
            }
        } else if (order.equals("desc")) {
            if (by.equals("areaName")) {
                Collections.sort(areaList,new AreaNameDesc());
            } else if (by.equals("subWardName")) {
                Collections.sort(areaList,new AreaSubWardNameDesc());
            }
        }
    }

    public String search() {
        try {
            if (searchText != null) {
                areaList = port.searchByAreaName(searchText, maxResults);
            }
        } catch (Exception e) {
        }
        return "search";
    }

    public void loadAllArea() {
        areaList = port.getAllAreas();
        totalPages = areaList.size() / pageRows;
    }

    // <editor-fold defaultstate="collapsed" desc="properties">
    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public List<AreaMaster> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<AreaMaster> areaList) {
        this.areaList = areaList;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public AreaMaster getAreaObj() {
        return areaObj;
    }

    public void setAreaObj(AreaMaster areaObj) {
        this.areaObj = areaObj;
    }

    public Map<Integer, Boolean> getChecked() {
        return checked;
    }

    public void setChecked(Map<Integer, Boolean> checked) {
        this.checked = checked;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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

    public Integer getSelectedSubWard() {
        return selectedSubWard;
    }

    public void setSelectedSubWard(Integer selectedSubWard) {
        this.selectedSubWard = selectedSubWard;
    }

    public List<SubWardMaster> getSubwardList() {
        return subwardList;
    }

    public void setSubwardList(List<SubWardMaster> subwardList) {
        this.subwardList = subwardList;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    // </editor-fold>
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adminbeans;

import comparators.WardNameAsc;
import comparators.WardNameDesc;
import comparators.WardZoneNameAsc;
import comparators.WardZoneNameDesc;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import service.ZoneMaster;
import service.EPollWebService;
import service.WardMaster;

/**
 *
 * @author ankur
 */
public class WardBean {

    private EPollWebService port;
    private List<WardMaster> wardList;
    private List<ZoneMaster> zoneList;
    private String msg;
    private Integer zoneId;
    private String wardName;
    private Integer wardId;
    private WardMaster wardObj;
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

    /** Creates a new instance of WardBean */
    public WardBean() {
    }

    @PostConstruct
    public void initialise() {
        try {
            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            session = request.getSession(false);
            port = (EPollWebService) session.getAttribute("port");
            //    port = service.getEPollWebServicePort();

            /* if (request.getQueryString()!=null) {
            if (request.getParameter("action") != null) {
            if (request.getParameter("action").equals("edit")) {
            wardId = Integer.valueOf(request.getParameter("id"));
            if (wardId != null) {
            wardObj = port.getWard(wardId);

            wardName = wardObj.getWardName();
            zoneId = Integer.valueOf(wardObj.getZoneMaster().getZoneId());
            }
            } else if (request.getParameter("action").equals("delete")) {
            wardId = Integer.valueOf(request.getParameter("id"));
            deleteFromLink();
            }
            }
            }*/

            loadAllWards();
            zoneList = port.getAllZones();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public void change(AjaxBehaviorEvent e) {
        pageRows = Integer.valueOf(pageList);
        totalPages = wardList.size() / pageRows;
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

    public String edit() {
        wardId = Integer.valueOf(wardObj.getWardId());
        wardName=wardObj.getWardName();
        zoneId=Integer.valueOf(wardObj.getZoneMaster().getZoneId());
        return "editWard";
    }

    public String delete() {
        boolean result = false;
        String retval = null;
        context = FacesContext.getCurrentInstance();
        int answer = JOptionPane.showConfirmDialog(null, "Are you sure want to delete?", "ALERT", JOptionPane.YES_NO_OPTION);
        try {
            if (answer == 0) {
                Iterator<WardMaster> i = wardList.iterator();
                for (WardMaster item : wardList) {

                    if (checked.get(Integer.valueOf(item.getWardId()))) {
                        result=port.deleteWard(Integer.valueOf(item.getWardId()));
                    }
                }
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Zone Deleted Successfully", "Zone Deleted Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while deleting the zones", "Some error occured while deleting the zones");
                }
                context.addMessage("msg", message);                
                retval = "wardDeleted";
                loadAllWards();
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
                result = port.deleteWard(wardId);
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Zone Deleted Successfully", "Zone Deleted Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while deleting the zone", "Some error occured while deleting the zone");
                }
                context.addMessage("msg", message);
                retval = "wardDeleted";
                loadAllWards();
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
            if (wardId == null) {
                wardObj = new WardMaster();
                wardObj.setWardName(wardName);
                result = port.addWard(wardObj, zoneId);
                //msg = "Record is Added Successfully";
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ward Saved Successfully", "Ward Saved Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while saving the ward", "Some error occured while saving the ward");
                }
                retval = "wardSaved";
            } else {
                wardObj = port.getWard(wardId);
                wardObj.setWardName(wardName);
                result = port.updateWard(wardObj, zoneId);
//                msg = "Record is Updated Successfully";
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ward Updated Successfully", "Ward Updated Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while updating the ward", "Some error occured while updating the ward");
                }
                retval = "wardSaved";
            }
            context.addMessage("msg", message);
            loadAllWards();
        } catch (Exception e) {
        }
        return retval;
    }

    public String add() {
        wardId=null;
        wardName=null;
        zoneId=null;
        return "addNewWard";
    }

    public void sort() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String by = req.getParameter("by");
        String order = req.getParameter("order");
        //JOptionPane.showMessageDialog(null, "by " + req.getParameter("by"));
        //JOptionPane.showMessageDialog(null, "order " + req.getParameter("order"));
        if (order.equals("asc")) {
            if (by.equals("wardName")) {
                Collections.sort(wardList,new WardNameAsc());
            } else if (by.equals("zoneName")) {
                Collections.sort(wardList,new WardZoneNameAsc());
            }
        } else if (order.equals("desc")) {
            if (by.equals("zoneName")) {
                Collections.sort(wardList,new WardZoneNameDesc());
            } else if (by.equals("wardName")) {
                Collections.sort(wardList,new WardNameDesc());
            }
        }
    }

    public String search() {
        try {
            if (searchText != null) {
                wardList = port.searchWardByName(searchText, maxResults);
            }
        } catch (Exception e) {
        }
        return "search";
    }

    public void loadAllWards() {
        wardList = port.getAllWards();
        totalPages = wardList.size() / pageRows;        
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

    public Integer getWardId() {
        return wardId;
    }

    public void setWardId(Integer wardId) {
        this.wardId = wardId;
    }

    public Integer getzoneId() {
        //zoneId=2;
        return zoneId;
    }

    public void setzoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public WardMaster getWardObj() {
        return wardObj;
    }

    public void setWardObj(WardMaster wardObj) {
        this.wardObj = wardObj;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public List<WardMaster> getWardList() {
        return wardList;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setWardList(List<WardMaster> wardList) {
        this.wardList = wardList;
    }

    public List<ZoneMaster> getzoneList() {
        return zoneList;
    }

    public void setzoneList(List<ZoneMaster> zoneList) {
        this.zoneList = zoneList;
    }// </editor-fold>
}

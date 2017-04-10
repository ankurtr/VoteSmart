/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adminbeans;

import comparators.ZoneCityNameAsc;
import comparators.ZoneCityNameDesc;
import comparators.ZoneNameAsc;
import comparators.ZoneNameDesc;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
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
import service.CityMaster;
import service.EPollWebService;
import service.ZoneMaster;

/**
 *
 * @author ankur
 */
public class ZoneBean implements Serializable {

    private transient EPollWebService port;
    private List<ZoneMaster> zoneList;
    private List<CityMaster> cityList;
    private String msg;
    private Integer cityId;
    private String zoneName;
    private Long population;
    private Integer zoneId;
    private ZoneMaster zoneObj;
    private Map<Integer, Boolean> checked = new HashMap<Integer, Boolean>();
    HttpServletRequest request;
    HttpServletResponse response;
    transient HttpSession session;
    private int currentPage = 0;
    private int pageRows = 5;
    private int totalPages;
    private String pageList;
    private String searchText;
    private Integer maxResults = 2;
    private Integer firstPage = 0;
    private FacesMessage message;
    private FacesContext context;

    /** Creates a new instance of ZoneBean */
    public ZoneBean() {
    }

    @PostConstruct
    public void initialise() {
        try {
            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            session = request.getSession(false);
            port = (EPollWebService) session.getAttribute("port");
            // port = service.getEPollWebServicePort();            

            /*if (request.getQueryString() != null) {
            if (request.getParameter("action") != null) {
            if (request.getParameter("action").equals("edit")) {
            zoneId = Integer.valueOf(request.getParameter("id"));
            if (zoneId != null) {
            zoneObj = port.getZone(zoneId);
            zoneName = zoneObj.getZoneName();
            population = zoneObj.getPopulation();
            cityId = Integer.valueOf(zoneObj.getCityMaster().getCityId());
            }
            } else if (request.getParameter("action").equals("delete")) {
            zoneId = Integer.valueOf(request.getParameter("id"));
            deleteFromLink();
            }
            }
            }*/

            loadAllZones();
            cityList = port.getAllCities();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public void change(AjaxBehaviorEvent e) {
        pageRows = Integer.valueOf(pageList);
        totalPages = zoneList.size() / pageRows;
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
        zoneId = Integer.valueOf(zoneObj.getZoneId());
        zoneName = zoneObj.getZoneName();
        population = zoneObj.getPopulation();
        cityId=Integer.valueOf(zoneObj.getCityMaster().getCityId());
        return "editZone";
    }

    public String delete() {
        boolean result = false;
        String retval = null;
        context = FacesContext.getCurrentInstance();
        int answer = JOptionPane.showConfirmDialog(null, "Are you sure want to delete?", "ALERT", JOptionPane.YES_NO_OPTION);
        try {
            if (answer == 0) {
                Iterator<ZoneMaster> i = zoneList.iterator();
                for (ZoneMaster item : zoneList) {
                    if (checked.get(Integer.valueOf(item.getZoneId())) != null && checked.get(Integer.valueOf(item.getZoneId()))) {
                        result = port.deleteZone(Integer.valueOf(item.getZoneId()));
                    }
                }
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Zone Deleted Successfully", "Zone Deleted Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while deleting the zones", "Some error occured while deleting the zones");
                }
                context.addMessage("msg", message);
                retval = "zoneDeleted";
                loadAllZones();
            }
        } catch (Exception e) {
            e.printStackTrace();
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
                result = port.deleteZone(zoneId);
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Zone Deleted Successfully", "Zone Deleted Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while deleting the zone", "Some error occured while deleting the zone");
                }
                context.addMessage("msg", message);
                retval = "zoneDeleted";
                loadAllZones();
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
            if (zoneId == null) {
                zoneObj = new ZoneMaster();
                zoneObj.setZoneName(zoneName);
                zoneObj.setPopulation(population);
                result = port.addZone(zoneObj, cityId);
                //msg = "Record is Added Successfully";
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Zone Saved Successfully", "Zone Saved Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while saving the zone", "Some error occured while saving the zone");
                }
                retval = "zoneSaved";
            } else {
                zoneObj = port.getZone(zoneId);
                zoneObj.setZoneName(zoneName);
                zoneObj.setPopulation(population);
                result = port.updateZone(zoneObj, cityId);
                //msg = "Record is Updated Successfully";
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Zone Updated Successfully", "Zone Updated Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while updating the zone", "Some error occured while updating the zone");
                }
                retval = "zoneSaved";
            }
            context.addMessage("msg", message);
            loadAllZones();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return retval;
    }

    public String add() {
        zoneId = null;
        zoneName = null;
        population = null;
        cityId=null;
        return "addNewZone";
    }

    public void sort() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String by = req.getParameter("by");
        String order = req.getParameter("order");
        //JOptionPane.showMessageDialog(null, "by " + req.getParameter("by"));
        //JOptionPane.showMessageDialog(null, "order " + req.getParameter("order"));
        if (order.equals("asc")) {
            if (by.equals("zoneName")) {
                Collections.sort(zoneList,new ZoneNameAsc());
            } else if (by.equals("cityName")) {
                Collections.sort(zoneList,new ZoneCityNameAsc());
            }
        } else if (order.equals("desc")) {
            if (by.equals("zoneName")) {
                Collections.sort(zoneList,new ZoneNameDesc());
            } else if (by.equals("cityName")) {
                Collections.sort(zoneList,new ZoneCityNameDesc());
            }
        }        
    }

    public String search() {
        try {
            if (searchText != null) {
                zoneList = port.searchByZoneName(searchText, maxResults);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "search";
    }   

    public void loadAllZones() {
        zoneList = port.getAllZones();
        totalPages = zoneList.size() / pageRows;
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

    public Integer getZoneId() {
        return zoneId;


    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;


    }

    public Integer getCityId() {
        //cityId=2;
        return cityId;


    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;


    }

    public ZoneMaster getZoneObj() {
        return zoneObj;


    }

    public void setZoneObj(ZoneMaster zoneObj) {
        this.zoneObj = zoneObj;


    }

    public String getZoneName() {
        return zoneName;


    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;


    }

    public Long getPopulation() {
        return population;


    }

    public void setPopulation(Long population) {
        this.population = population;


    }

    public List<ZoneMaster> getZoneList() {
        return zoneList;


    }

    public String getMsg() {
        return msg;


    }

    public void setMsg(String msg) {
        this.msg = msg;


    }

    public void setZoneList(List<ZoneMaster> zoneList) {
        this.zoneList = zoneList;


    }

    public List<CityMaster> getCityList() {
        return cityList;


    }

    public void setCityList(List<CityMaster> cityList) {
        this.cityList = cityList;

    }// </editor-fold>
}

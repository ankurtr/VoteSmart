/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adminbeans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import service.EPollWebService;
import service.SecurityMaster;

/**
 *
 * @author ankur
 */
public class SecurityBean {

    private EPollWebService port;
    private List<SecurityMaster> securityList;    
    private String securityName;
    private String description;
    private boolean isActive;
    private Integer securityId;
    private SecurityMaster securityObj;
    //private Map<Integer, Boolean> checked = new HashMap<Integer, Boolean>();    
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;    

    /** Creates a new instance of SecurityBean */
    public SecurityBean() {
    }

    @PostConstruct
    public void initialise() {
        try {
            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            session = request.getSession(false);
            port = (EPollWebService) session.getAttribute("port");
            //port = service.getEPollWebServicePort();

            if (request.getQueryString() != null) {
                if (request.getParameter("action") != null) {
                    if (request.getParameter("action").equals("edit")) {
                        securityId = Integer.valueOf(request.getParameter("id"));
                        if (securityId != null) {
                            securityObj = port.getSecurity(securityId);
                            securityName = securityObj.getSecurityName();
                            description = securityObj.getDescription();
                            isActive = securityObj.isIsActive();
                        }
                    } else if (request.getParameter("action").equals("deactivate")) {
                        securityId = Integer.valueOf(request.getParameter("id"));
                        deactivateSecurity();
                    }
                }
            }
            securityList = port.getAllSecurity();            

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String deactivateSecurity() {
        boolean result = false;
        String retval = null;
        try {
            result = port.deactivateSecurity(securityId);
            retval = "securityDeactivated";
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
            securityObj = new SecurityMaster();
            securityObj.setSecurityName(securityName);
            securityObj.setDescription(description);
            securityObj.setIsActive(isActive);
            result = port.addSecurity(securityObj);
            //msg = "Record is Added Successfully";
            retval = "securitySaved";
        } catch (Exception e) {
        }
        return retval;
    }

    public String add() {
        return "addNewSecurity";
    }

    public void viewAllSecurity() {
        securityList = port.getAllSecurity();
    }

    // <editor-fold defaultstate="collapsed" desc="properties">

    public Integer getSecurityId() {
        return securityId;
    }

    public void setSecurityId(Integer securityId) {
        this.securityId = securityId;
    }

    public SecurityMaster getSecurityObj() {
        return securityObj;
    }

    public void setSecurityObj(SecurityMaster securityObj) {
        this.securityObj = securityObj;
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }

    public List<SecurityMaster> getSecurityList() {
        return securityList;
    }

    public void setSecurityList(List<SecurityMaster> securityList) {
        this.securityList = securityList;
    }
}

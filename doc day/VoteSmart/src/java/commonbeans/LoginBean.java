/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commonbeans;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.xml.ws.BindingProvider;
import service.CitizenMaster;
import service.EPollWebService;
import service.EPollWebServiceService;
import service.LoginMaster;

/**
 *
 * @author raj
 */
public class LoginBean {

    private String username;
    private String password;
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;
    private String errorMessage;

    /** Creates a new instance of LoginBean */
    public LoginBean() {
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String login() {
        String retval = null;
        try {
            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            session = request.getSession();
            LoginMaster lm = null;
            CitizenMaster cm = null;

//            if (session.getAttribute("login") != null) {
//                return "client/CastVote.jsf";
//            }

            request.login(username, password);                
            EPollWebServiceService service = new EPollWebServiceService();
            EPollWebService port = service.getEPollWebServicePort();

            ((BindingProvider) port).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:15658/EPollWebServiceService/EPollWebService?wsdl");
            ((BindingProvider) port).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, username);
            ((BindingProvider) port).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, password);

            lm = port.getLoginMasterFromUsername(username);

            if (request.isUserInRole("admin")) {
                retval = "admin";
            } else if (request.isUserInRole("citizen")) {                
                cm = port.getCitizenMaster(Integer.valueOf(lm.getUserId()));
                retval = "citizen";
            }

            if (!lm.isIsActive()) {
                request.logout();
                session.invalidate();
                errorMessage = "You are not authorised to access the system";
                return "LoginPage.jsf";
            }

            session.setAttribute("port", port);
            session.setAttribute("login", true);
            session.setAttribute("username", username);
            session.setAttribute("userid", lm.getUserId());
            session.setAttribute("loginmaster", lm);
            session.setAttribute("citizenmaster", cm);
            //JOptionPane.showMessageDialog(null, port.getValue());
            //JOptionPane.showMessageDialog(null, session);

        } catch (Exception e) {
            e.printStackTrace();
            //FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Authentication Failed", "Possible Wrong Username or Password");
            //FacesContext.getCurrentInstance().addMessage("loginForm:msgs", msg);
           JOptionPane.showMessageDialog(null, e.getClass());            
            errorMessage = "Authentication Failed";
            return null;
            //throw new ValidatorException(msg);
            //return "failure";
        }
        return retval;
    }

    public String logout() {
        try {
            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            request.logout();
            request.getSession().invalidate();
            //JOptionPane.showMessageDialog(null, "cmong");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "log out error" + e.getClass());
            return null;
        }
        return "logout";
    }
}

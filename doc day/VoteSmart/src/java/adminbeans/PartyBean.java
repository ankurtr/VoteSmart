/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adminbeans;

import comparators.PartyNameAsc;
import comparators.PartyNameDesc;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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
import javax.xml.ws.BindingProvider;
import misc.RandomNameGenerator;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import service.EPollWebService;
import service.EPollWebServiceService;
import service.PartyMaster;

/**
 *
 * @author ankur
 */
public class PartyBean {

    private EPollWebService port;
    private List<PartyMaster> partyList;
    private String msg;
    private Integer partyId;
    private String partyName;
    private String partyLogo;
    private String partySlogan;
    private String description;
    private PartyMaster partyObj;
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
    private UploadedFile uFilePartyLogoImage;
    private String realPath; //to images folder
    private FacesContext context;
    private FacesMessage message;

    /** Creates a new instance of PartyBean */
    public PartyBean() {
    }

    @PostConstruct
    public void initialise() {
        try {
            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            session = request.getSession(false);
            port = (EPollWebService) session.getAttribute("port");

            /* EPollWebServiceService service = new EPollWebServiceService();
            port = service.getEPollWebServicePort();
            ((BindingProvider) port).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8080/EPollWebServiceService/EPollWebService?wsdl");
            ((BindingProvider) port).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "milan");
            ((BindingProvider) port).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "a");*/

            realPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("images/img");

//            String real2=FacesContext.getCurrentInstance().getExternalContext().getRealPath("images/img/hsm1_38564_35574.jpg");
//            File f=new File(real2);
//            JOptionPane.showMessageDialog(null,f.getAbsolutePath());
//            JOptionPane.showMessageDialog(null,f.exists());
//            JOptionPane.showMessageDialog(null, real2);
            loadAllParty();


        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public void change(AjaxBehaviorEvent e) {
        pageRows = Integer.valueOf(pageList);
        totalPages = partyList.size() / pageRows;
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
                Iterator<PartyMaster> i = partyList.iterator();
                for (PartyMaster item : partyList) {
                    if (checked.get(Integer.valueOf(item.getPartyId()))) {
                        result = port.deleteParty(Integer.valueOf(item.getPartyId()));
                    }
                }
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Party Deleted Successfully", "Party Deleted Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while deleting the parties", "Some error occured while deleting the parties");
                }
                context.addMessage("msg", message);
                loadAllParty();
                retval = "partyDeleted";
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
                result = port.deleteParty(partyId);
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Party Deleted Successfully", "Party Deleted Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while deleting the party ", "Some error occured while deleting the party");
                }
                context.addMessage("msg", message);
                loadAllParty();
                retval = "partyDeleted";
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
            if (partyId == null) {
                partyObj = new PartyMaster();
                partyObj.setPartyName(partyName);
                partyObj.setPartyLogo(partyLogo);
                partyObj.setPartySlogan(partySlogan);
                partyObj.setDescription(description);
                result = port.addParty(partyObj);
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Party Saved Successfully", "Party Saved Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while saving the Party", "Some error occured while saving the Party");
                }
                //JOptionPane.showMessageDialog(null, "done");
                //msg = "Record is Added Successfully";
            } else {
                //JOptionPane.showMessageDialog(null, "in edit");
                partyObj = port.getParty(partyId);
                partyObj.setPartyName(partyName);
                partyObj.setPartyLogo(partyLogo);
                partyObj.setPartySlogan(partySlogan);
                partyObj.setDescription(description);
                result = port.updateParty(partyObj);
                //msg = "Record is Updated Successfully";
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Party Updated Successfully", "Party Updated Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while updating the Party", "Some error occured while updating the Party");
                }

            }
            context.addMessage("msg", message);
            retval = "partySaved";
            loadAllParty();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return retval;
    }

    public String add() {
        partyId = null;
        partyName = null;
        partySlogan = null;
        partyLogo = null;
        description = null;
        return "addNewParty";
    }

    public void sort() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String by = req.getParameter("by");
        String order = req.getParameter("order");
        //JOptionPane.showMessageDialog(null, "by " + req.getParameter("by"));
        //JOptionPane.showMessageDialog(null, "order " + req.getParameter("order"));
        if (order.equals("asc")) {
            if (by.equals("partyName")) {
                Collections.sort(partyList, new PartyNameAsc());
            }
        } else if (order.equals("desc")) {
            if (by.equals("partyName")) {
                Collections.sort(partyList, new PartyNameDesc());
            }
        }
    }

    public String search() {
        try {
            if (searchText != null) {
                partyList = port.searchPartyByPartyName(searchText, maxResults);
                JOptionPane.showMessageDialog(null, partyList);
            }
        } catch (Exception e) {
        }
        return "search";
    }

    public void loadAllParty() {
        partyList = port.getAllParties();
        totalPages = partyList.size() / pageRows;
    }

    public void uploadLogoImage() {

        String contentType = uFilePartyLogoImage.getContentType();

        long size = uFilePartyLogoImage.getSize();
        String test = null;

        String fileName = null;
        if (contentType.contains("jpeg") && size <= 5120000) {

            fileName = new Date() + uFilePartyLogoImage.getName();

            //String prefix = FilenameUtils.getBaseName(uFilePartyLogoImage.getName());
            String prefix = RandomNameGenerator.getRandomString();
            String suffix = FilenameUtils.getExtension(uFilePartyLogoImage.getName());

            File file = null;
            OutputStream output = null;

            try {

                // Create file with unique name in upload folder and write to it.
                file = File.createTempFile(prefix + "_", "." + suffix, new File(realPath));
                output = new FileOutputStream(file);

                IOUtils.copy(uFilePartyLogoImage.getInputStream(), output);

                partyLogo = file.getName();
                // JOptionPane.showMessageDialog(null, f.exists());

                // Show succes message.
                FacesContext.getCurrentInstance().addMessage("f1", new FacesMessage(
                        FacesMessage.SEVERITY_INFO, "File upload succeed!", null));


            } catch (IOException e) {
                // Cleanup.
                if (file != null) {
                    file.delete();
                }

                // Show error message.
                FacesContext.getCurrentInstance().addMessage("uploadForm", new FacesMessage(
                        FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", null));

                // Always log stacktraces (with a real logger).
                e.printStackTrace();
            } finally {
                IOUtils.closeQuietly(output);
            }
        }
    }

    public String edit() {
        String retval = null;
        try {
            partyId = Integer.valueOf(partyObj.getPartyId());
            partyName = partyObj.getPartyName();
            partySlogan = partyObj.getPartySlogan();
            partyLogo = partyObj.getPartyLogo();
            description = partyObj.getDescription();
            retval = "editParty";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "edit" + e);
        }
        return retval;
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

    public Integer getPartyId() {
        return partyId;
    }

    public void setPartyId(Integer partyId) {
        this.partyId = partyId;
    }

    public PartyMaster getPartyObj() {
        return partyObj;
    }

    public void setPartyObj(PartyMaster partyObj) {
        this.partyObj = partyObj;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public List<PartyMaster> getPartyList() {
        return partyList;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setPartyList(List<PartyMaster> partyList) {
        this.partyList = partyList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPartyLogo() {
//        try {
//            //File f = new File(realPath + "/" + partyLogo);
//            //JOptionPane.showMessageDialog(null, f.getAbsolutePath());
//        } catch (Exception e) {
//        }
        return partyLogo;
    }

    public void setPartyLogo(String partyLogo) {
        this.partyLogo = partyLogo;
    }

    public String getPartySlogan() {
        return partySlogan;
    }

    public void setPartySlogan(String partySlogan) {
        this.partySlogan = partySlogan;
    }

    public UploadedFile getuFilePartyLogoImage() {
        return uFilePartyLogoImage;
    }

    public void setuFilePartyLogoImage(UploadedFile uFilePartyLogoImage) {
        this.uFilePartyLogoImage = uFilePartyLogoImage;
    }// </editor-fold>
}

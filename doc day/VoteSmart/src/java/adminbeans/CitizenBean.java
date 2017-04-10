/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adminbeans;

import comparators.CitizenNameAsc;
import comparators.CitizenNameDesc;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
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
import javax.xml.datatype.XMLGregorianCalendar;
import misc.MD5Impl;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import service.AreaMaster;
import service.CitizenMaster;
import service.EPollWebService;
import service.EPollWebServiceService;
import service.LoginMaster;
import service.SubWardMaster;
import service.WardMaster;
import service.ZoneMaster;

/**
 *
 * @author milan
 */
public class CitizenBean {

    private EPollWebServiceService service;
    private String username;
    private Integer userId;
    private String password;
    private String userType;
    private boolean isActive;
    private String name;
    private String address;
    private String contactNumber;
    private String thumbImage;
    private String voterCardImage;
    private String faceImage;
    private String signatureImage;
    private XMLGregorianCalendar birthDate;
    private String selectedUserType;
    private Integer selectedZone;
    private Integer selectedWard;
    private Integer selectedSubward;
    private Integer selectedArea;
    private Integer selectedCandidate;
    private List<ZoneMaster> zoneList;
    private List<WardMaster> wardList;
    private List<SubWardMaster> subwardList;
    private List<AreaMaster> areaList;
    private Integer selectedCitizen;
    private UploadedFile uFileVoterCard;
    private UploadedFile uFileSignature;
    private UploadedFile uFileThumb;
    private UploadedFile uFileFace;
    EPollWebService port;
    private String realPath;
    private int pageRows = 5;
    private int totalPages;
    private int page;
    private String pageList;
    private int currentPage = 0;
    private Map<Integer, Boolean> checked = new HashMap<Integer, Boolean>();
    private HtmlDataTable dataTable;
    private List<CitizenMaster> citizenList;
    private Integer maxResults = 2;
    private Integer firstPage = 0;
    private String searchText;
    private CitizenMaster objCitizen;
    private LoginMaster objLoginMaster;
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;
    private FacesContext context;
    private FacesMessage message;

    @PostConstruct
    public void initialise() {
        try {
            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            session = request.getSession(false);
            port = (EPollWebService) session.getAttribute("port");
            realPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("images/img");

            citizenList = port.getAllCitizens();
            zoneList = port.getAllZones();
            wardList = port.getAllWards();
            subwardList = port.getAllSubwards();
            areaList = port.getAllAreas();

            totalPages = citizenList.size() / pageRows;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    /** Creates a new instance of tryBean */
    public CitizenBean() {
    }

    // <editor-fold defaultstate="collapsed" desc="combo code">
    public void zoneSelectionChanged(AjaxBehaviorEvent event) {
        wardList = port.getWardsOfZone(selectedZone);
    }

    public void wardSelectionChanged(AjaxBehaviorEvent event) {
        subwardList = port.getSubWardsOfWard(selectedWard);
    }

    public void subwardSelectionChanged(AjaxBehaviorEvent event) {
        areaList = port.getAreaOfSubward(selectedSubward);
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="property code">
    public CitizenMaster getObjCitizen() {
        return objCitizen;
    }

    public void setObjCitizen(CitizenMaster objCitizen) {
        this.objCitizen = objCitizen;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public List<CitizenMaster> getCitizenList() {
        return citizenList;
    }

    public void setCitizenList(List<CitizenMaster> citizenList) {
        this.citizenList = citizenList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public XMLGregorianCalendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(XMLGregorianCalendar birthDate) {
        this.birthDate = birthDate;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getFaceImage() {
        return faceImage;
    }

    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSelectedUserType() {
        return selectedUserType;
    }

    public void setSelectedUserType(String selectedUserType) {
        this.selectedUserType = selectedUserType;
    }

    public String getSignatureImage() {
        return signatureImage;
    }

    public void setSignatureImage(String signatureImage) {
        this.signatureImage = signatureImage;
    }

    public String getThumbImage() {
        return thumbImage;
    }

    public void setThumbImage(String thumbImage) {
        this.thumbImage = thumbImage;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVoterCardImage() {
        return voterCardImage;
    }

    public void setVoterCardImage(String voterCardImage) {
        this.voterCardImage = voterCardImage;
    }

    public Integer getSelectedCitizen() {
        return selectedCitizen;
    }

    public void setSelectedCitizen(Integer selectedCitizen) {
        this.selectedCitizen = selectedCitizen;
    }

    public UploadedFile getuFileVoterCard() {
        return uFileVoterCard;
    }

    public void setuFileVoterCard(UploadedFile uFileVoterCard) {
        this.uFileVoterCard = uFileVoterCard;
    }

    public UploadedFile getuFileSignature() {
        return uFileSignature;
    }

    public void setuFileSignature(UploadedFile uFileSignature) {
        this.uFileSignature = uFileSignature;
    }

    public UploadedFile getuFileFace() {
        return uFileFace;
    }

    public void setuFileFace(UploadedFile uFileFace) {
        this.uFileFace = uFileFace;
    }

    public UploadedFile getuFileThumb() {
        return uFileThumb;
    }

    public void setuFileThumb(UploadedFile uFileThumb) {
        this.uFileThumb = uFileThumb;
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

    public Map<Integer, Boolean> getChecked() {
        return checked;
    }

    public void setChecked(Map<Integer, Boolean> checked) {
        this.checked = checked;
    }

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable dataTable) {
        this.dataTable = dataTable;
    }

    public String getPageList() {
        return pageList;
    }

    public void setPageList(String pageList) {
        this.pageList = pageList;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageRows() {
        return pageRows;
    }

    public void setPageRows(int pageRows) {
        this.pageRows = pageRows;
    }

    public int getTotalPages() {
        totalPages = port.getAllCitizens().size() / pageRows;
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<AreaMaster> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<AreaMaster> areaList) {
        this.areaList = areaList;
    }

    public Integer getSelectedArea() {
        return selectedArea;
    }

    public void setSelectedArea(Integer selectedArea) {
        this.selectedArea = selectedArea;
    }

    public Integer getSelectedCandidate() {
        return selectedCandidate;
    }

    public void setSelectedCandidate(Integer selectedCandidate) {
        this.selectedCandidate = selectedCandidate;
    }

    public Integer getSelectedSubward() {
        return selectedSubward;
    }

    public void setSelectedSubward(Integer selectedSubward) {
        this.selectedSubward = selectedSubward;
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

    public List<SubWardMaster> getSubwardList() {
        return subwardList;
    }

    public void setSubwardList(List<SubWardMaster> subwardList) {
        this.subwardList = subwardList;
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

    // <editor-fold defaultstate="collapsed" desc="Function code">
    public String search() {
        try {
            if (searchText != null) {
                citizenList = port.searchCitizenByName(searchText, maxResults);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "search";
    }

    public String delete() {
        boolean result = false;
        String retval = null;
        context = FacesContext.getCurrentInstance();
        int answer = JOptionPane.showConfirmDialog(null, "Are you sure want to delete?", "ALERT", JOptionPane.YES_NO_OPTION);
        try {
            if (answer == 0) {
                Iterator<CitizenMaster> i = citizenList.iterator();
                for (CitizenMaster item : citizenList) {
                    if (checked.get(Integer.valueOf(item.getUserId())) != null && checked.get(Integer.valueOf(item.getUserId()))) {
                        result = port.deleteZone(Integer.valueOf(item.getUserId()));
                    }
                }
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Citizen Deleted Successfully", "Citizen Deleted Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while deleting the citizens", "Some error occured while deleting the citizens");
                }
                context.addMessage("msg", message);
                retval = "citizenDeleted";
                loadAllCandidates();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retval;
    }

    public String add() {
        objCitizen = null;
        objLoginMaster = null;
        username = null;
        password = null;
        selectedUserType = userType = null;
        isActive = false;

        name = null;
        address = null;
        contactNumber = null;
        birthDate = null;
        voterCardImage = null;
        signatureImage = null;
        faceImage = null;
        thumbImage = null;
        selectedZone = null;
        selectedWard = null;
        selectedSubward = null;
        selectedArea = null;
        return "addNewCitizen";
    }

    public String addCitizen() {
        boolean result = false;
        String retval = null;
        context = FacesContext.getCurrentInstance();
        try {
            if (userId == null) {
                LoginMaster lm = new LoginMaster();
                lm.setUsername(username);
                lm.setPassword(MD5Impl.getMD5(password));
                lm.setUserType(selectedUserType);
                lm.setIsActive(false);

                CitizenMaster cm = new CitizenMaster();
                cm.setName(name);
                cm.setAddress(address);
                cm.setContactNo(contactNumber);
                cm.setThumbImage(thumbImage);
                cm.setVoterCardImage(voterCardImage);
                cm.setFaceImage(faceImage);
                cm.setSignatureImage(signatureImage);
                cm.setDateOfBirth(birthDate);
                result = port.addCitizen(lm, cm, selectedZone, selectedWard, selectedSubward, selectedArea);

                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Citizen Saved Successfully", "Citizen Saved Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while saving the citizen", "Some error occured while saving the citizen");
                }

            } else {
                LoginMaster lm = new LoginMaster();
                lm.setUsername(username);
                lm.setPassword(MD5Impl.getMD5(password));
                lm.setUserType(selectedUserType);
                lm.setIsActive(false);

                CitizenMaster cm = port.getCitizenMaster(userId);
                cm.setName(name);
                cm.setAddress(address);
                cm.setContactNo(contactNumber);
                cm.setThumbImage(thumbImage);
                cm.setVoterCardImage(voterCardImage);
                cm.setFaceImage(faceImage);
                cm.setSignatureImage(signatureImage);
                cm.setDateOfBirth(birthDate);
                result = port.updateCitizen(lm, cm, selectedZone, selectedWard, selectedSubward, selectedArea);
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Citizen Updated Successfully", "Citizen Updated Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while updating the citizen", "Some error occured while updating the citizen");
                }
            }
            retval = "citizenSaved";
            context.addMessage("msg", message);
            loadAllCandidates();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return "citizenSaved";
    }

//    public void updateCitizen() {
//        try {
//            LoginMaster lm = port.getLoginMaster(selectedCitizen);
//            lm.setUsername(username);
//            lm.setPassword(MD5Impl.getMD5(password));
//            lm.setUserType(selectedUserType);
//            lm.setIsActive(isActive);
//
//            CitizenMaster cm = port.getCitizenMaster(selectedCitizen);
//            cm.setName(name);
//            cm.setAddress(address);
//            cm.setContactNo(contactNumber);
//            cm.setThumbImage(thumbImage);
//            cm.setVoterCardImage(voterCardImage);
//            cm.setFaceImage(faceImage);
//            cm.setSignatureImage(signatureImage);
//            cm.setDateOfBirth(birthDate);
//            port.updateCitizen(lm, cm, selectedZone, selectedWard, selectedSubward, selectedArea);
//        } catch (Exception e) {
//        }
//    }
    public void uploadVoterCardImage() {
//        JOptionPane.showMessageDialog(null, "cmn in voterimage");
        String contentType = uFileVoterCard.getContentType();
        long size = uFileVoterCard.getSize();
        String fileName = null;
        if (contentType.contains("jpeg") && size <= 5120000) {
            String prefix = FilenameUtils.getBaseName(uFileVoterCard.getName());
            String suffix = FilenameUtils.getExtension(uFileVoterCard.getName());

            File file = null;
            OutputStream output = null;

            try {

                // Create file with unique name in upload folder and write to it.
                file = File.createTempFile(prefix + "_", "." + suffix, new File(realPath));
                output = new FileOutputStream(file);

                IOUtils.copy(uFileVoterCard.getInputStream(), output);
                output.flush();

                voterCardImage = file.getName();
                // JOptionPane.showMessageDialog(null, voterCardImage);

                // Show succes message.
                /*FacesContext.getCurrentInstance().addMessage("uploadForm", new FacesMessage(
                FacesMessage.SEVERITY_INFO, "File upload succeed!", null));*/


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

    public void uploadSignatureImage() {
//        JOptionPane.showMessageDialog(null, "cmn in voterimage");
        String contentType = uFileSignature.getContentType();
        long size = uFileSignature.getSize();
        String fileName = null;
        if (contentType.contains("jpeg") && size <= 5120000) {


            String prefix = FilenameUtils.getBaseName(uFileSignature.getName());
            String suffix = FilenameUtils.getExtension(uFileSignature.getName());

            File file = null;
            OutputStream output = null;

            try {

                // Create file with unique name in upload folder and write to it.
                file = File.createTempFile(prefix + "_", "." + suffix, new File(realPath));
                output = new FileOutputStream(file);

                IOUtils.copy(uFileSignature.getInputStream(), output);
                output.flush();

                signatureImage = file.getName();
                //JOptionPane.showMessageDialog(null, signatureImage);

                // Show succes message.
                /*FacesContext.getCurrentInstance().addMessage("uploadForm", new FacesMessage(
                FacesMessage.SEVERITY_INFO, "File upload succeed!", null));*/


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

    public void uploadThumbImage() {
//        JOptionPane.showMessageDialog(null, "cmn in voterimage");
        String contentType = uFileThumb.getContentType();
        long size = uFileThumb.getSize();
        String fileName = null;

        String prefix = FilenameUtils.getBaseName(uFileThumb.getName());
        String suffix = FilenameUtils.getExtension(uFileThumb.getName());

        File file = null;
        OutputStream output = null;

        try {

            // Create file with unique name in upload folder and write to it.
            file = File.createTempFile(prefix + "_", "." + suffix, new File(realPath));
            output = new FileOutputStream(file);

            IOUtils.copy(uFileThumb.getInputStream(), output);
            output.flush();

            thumbImage = file.getName();
            //JOptionPane.showMessageDialog(null, thumbImage);

            // Show succes message.
                /*FacesContext.getCurrentInstance().addMessage("uploadForm", new FacesMessage(
            FacesMessage.SEVERITY_INFO, "File upload succeed!", null));*/


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

    public void uploadFaceImage() {
//        JOptionPane.showMessageDialog(null, "cmn in voterimage");
        String contentType = uFileFace.getContentType();
        long size = uFileFace.getSize();
        String fileName = null;
        if (contentType.contains("jpeg") && size <= 5120000) {

            String prefix = FilenameUtils.getBaseName(uFileFace.getName());
            String suffix = FilenameUtils.getExtension(uFileFace.getName());

            File file = null;
            OutputStream output = null;

            try {

                // Create file with unique name in upload folder and write to it.
                file = File.createTempFile(prefix + "_", "." + suffix, new File(realPath));
                output = new FileOutputStream(file);

                IOUtils.copy(uFileFace.getInputStream(), output);
                output.flush();

                faceImage = file.getName();
                //JOptionPane.showMessageDialog(null, faceImage);

                // Show succes message.
                /*FacesContext.getCurrentInstance().addMessage("uploadForm", new FacesMessage(
                FacesMessage.SEVERITY_INFO, "File upload succeed!", null));*/


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

    public String deleteFromLink() {
        boolean result = false;
        String retval = null;
        context = FacesContext.getCurrentInstance();
        int answer = JOptionPane.showConfirmDialog(null, "Are you sure want to delete?", "ALERT", JOptionPane.YES_NO_OPTION);
        try {
            if (answer == 0) {
                result = port.deleteCitizen(userId);
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Citizen Deleted Successfully", "Citizen Deleted Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while deleting the citizen", "Some error occured while deleting the citizen");
                }
                context.addMessage("msg", message);
                retval = "candidateDeleted";
                loadAllCandidates();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return retval;
    }

    //  </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="navigation">
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

    public void viewAllCitizen() {
        citizenList = port.getAllCitizens();
    }// </editor-fold>

    public String edit() {
        String retval = null;
        try {
            objCitizen = port.getCitizenMaster(userId);
            objLoginMaster = port.getLoginMaster(userId);
            username = objLoginMaster.getUsername();
            password = objLoginMaster.getPassword();
            selectedUserType = userType = objLoginMaster.getUserType();
            isActive = objLoginMaster.isIsActive();

            name = objCitizen.getName();
            address = objCitizen.getAddress();
            contactNumber = objCitizen.getContactNo();
            birthDate = objCitizen.getDateOfBirth();
            voterCardImage = objCitizen.getVoterCardImage();
            signatureImage = objCitizen.getSignatureImage();
            faceImage = objCitizen.getFaceImage();
            thumbImage = objCitizen.getThumbImage();
            selectedZone = Integer.valueOf(objCitizen.getZoneMaster().getZoneId());
            selectedWard = Integer.valueOf(objCitizen.getWardMaster().getWardId());
            selectedSubward = Integer.valueOf(objCitizen.getSubWardMaster().getSubWardId());
            selectedArea = Integer.valueOf(objCitizen.getAreaMaster().getAreaId());
            retval = "editCitizen";
        } catch (Exception e) {
        }
        return retval;
    }

    public void checkUser(AjaxBehaviorEvent event) {
        LoginMaster lm = null;
        //JOptionPane.showMessageDialog(null, "check user");
        context = FacesContext.getCurrentInstance();
        try {
            //login=em.createNamedQuery("")
            lm = port.getLoginMasterFromUsername(username);
            if (lm != null) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "user exist", "user exist");
//                        throw new ValidatorException(msg);
                //msg="exist";
                context.addMessage("usernameMessage", msg);
               // JOptionPane.showMessageDialog(null, "exist");
                //msg="<div style = 'color:red'>Username already exists</div>";
            } else {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "username available", "username available");
//                        throw new ValidatorException(msg);
//                msg="not exist";
                context.addMessage("usernameMessage", msg);
                //JOptionPane.showMessageDialog(null, "not exist");
            }
        } catch (Exception ex) {
        }

    }

    public void sort() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String by = req.getParameter("by");
        String order = req.getParameter("order");
        //JOptionPane.showMessageDialog(null, "by " + req.getParameter("by"));
        //JOptionPane.showMessageDialog(null, "order " + req.getParameter("order"));
        if (order.equals("asc")) {
            if (by.equals("name")) {
                Collections.sort(citizenList, new CitizenNameAsc());
            }
        } else if (order.equals("desc")) {
            if (by.equals("name")) {
                Collections.sort(citizenList, new CitizenNameDesc());
            }
        }
    }

    public void loadAllCandidates() {
        citizenList = port.getAllCitizens();
        totalPages = citizenList.size() / pageRows;
    }
}

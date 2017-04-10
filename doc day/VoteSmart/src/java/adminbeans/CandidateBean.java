/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adminbeans;

import comparators.CandidateFirstNameAsc;
import comparators.CandidateFirstNameDesc;
import comparators.CandidateLastNameAsc;
import comparators.CandidateLastNameDesc;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Date;
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
import javax.xml.datatype.XMLGregorianCalendar;
import misc.RandomNameGenerator;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import service.AreaMaster;
import service.CandidateMaster;
import service.EPollWebService;
import service.EPollWebServiceService;
import service.PartyMaster;
import service.SubWardMaster;
import service.WardMaster;
import service.ZoneMaster;

/**
 *
 * @author root
 */
public class CandidateBean {

    private EPollWebServiceService service;
    private Integer candidateId;
    private String firstName;
    private String lastName;
    private String email;
    private XMLGregorianCalendar birthDate;
    private String nationality;
    private boolean sex;
    private String address;
    private String phoneNumber;
    private Integer wardId;
    private Integer partyId;
    private Integer areaId;
    private String image;
    private boolean isActive;
    private Integer selectedZone;
    private Integer selectedWard;
    private Integer selectedSubward;
    private Integer selectedArea;
    private Integer selectedParty;
    private Integer selectedCandidate;
    private List<ZoneMaster> zoneList;
    private List<WardMaster> wardList;
    private List<SubWardMaster> subwardList;
    private List<AreaMaster> areaList;
    private List<PartyMaster> partyList;
    private List<CandidateMaster> candidateList;
    private Map<String, Boolean> checked = new HashMap<String, Boolean>();
    private int page = 0;
    private int pageRows = 5;
    private int totalPages;
    private String pageList;
    private String searchText;
    private Integer maxResults = 2;
    private CandidateMaster candidateObj;
    private UploadedFile uFileCandidateImage;
    private String realPath; //to images folder
    private int currentPage = 0;
    private Integer firstPage = 0;
    EPollWebService port;
    Date d;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private String searchBy;
    private String viewCandidates;
    private FacesContext context;
    private FacesMessage message;

    /** Creates a new instance of CandidateBean */
    public CandidateBean() {
    }

    @PostConstruct
    public void initialise() {
        try {
            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            session = request.getSession(false);
            port = (EPollWebService) session.getAttribute("port");
            realPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("images/img");

            loadAllCandidates();
            zoneList = port.getAllZones();
            wardList = port.getAllWards();
            subwardList = port.getAllSubwards();
            areaList = port.getAllAreas();
            partyList = port.getAllParties();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "post cons" + e);
        }
    }

    public void loadAllCandidates() {
        candidateList = port.getAllCandidates();
        totalPages = candidateList.size() / pageRows;
    }

    public String addCandidate() {
        String retval = null;
        boolean result = false;
        context = FacesContext.getCurrentInstance();
        try {
            if (candidateId == null) {
                candidateObj = new CandidateMaster();
                candidateObj.setFirstName(firstName);
                candidateObj.setLastName(lastName);
                candidateObj.setEmail(email);
                candidateObj.setDateOfBirth(birthDate);
                candidateObj.setNationality("INDIAN");
                candidateObj.setSex(sex);
                candidateObj.setAddress(address);
                candidateObj.setPhoneNo(phoneNumber);
                //JOptionPane.showMessageDialog(null, image);
                candidateObj.setImage(image);
                candidateObj.setIsActive(isActive);
                result = port.addCandidate(candidateObj, selectedZone, selectedWard, selectedSubward, selectedArea, selectedParty);
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Candidate Saved Successfully", "Candidate Saved Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while saving the Candidate", "Some error occured while saving the Candidate");
                }
//                JOptionPane.showMessageDialog(null, "done");
            } else {
                candidateObj = port.getCandidate(candidateId);
                candidateObj.setFirstName(firstName);
                candidateObj.setLastName(lastName);
                candidateObj.setEmail(email);
                candidateObj.setDateOfBirth(birthDate);
                candidateObj.setNationality("INDIAN");
                candidateObj.setSex(sex);
                candidateObj.setAddress(address);
                candidateObj.setPhoneNo(phoneNumber);
                candidateObj.setImage(image);
                candidateObj.setIsActive(isActive);
                result = port.updateCandidate(candidateObj, selectedZone, selectedWard, selectedSubward, selectedArea, selectedParty);
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Candidate Updated Successfully", "Candidate Updated Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while updating the Candidate", "Some error occured while updating the Candidate");
                }
            }
            context.addMessage("msg", message);
            retval = "candidateSaved";
            loadAllCandidates();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "edit" + e);
        } finally {
            candidateObj = null;
        }
        return retval;
    }

    public String showGender(boolean value) {
        if (value) {
            return "MALE";
        }
        return "FEMALE";
    }

    public String add() {
        candidateId = null;
        firstName = null;
        lastName = null;
        email = null;
        birthDate = null;
        nationality = null;
        sex = false;
        address = null;
        phoneNumber = null;
        selectedParty = null;
        selectedZone = null;
        selectedWard = null;
        selectedSubward = null;
        selectedArea = null;
        image = null;
        isActive = false;
        return "addNewCandidate";
    }

    public String delete() {
        boolean result = false;
        String retval = null;
        context = FacesContext.getCurrentInstance();
        int answer = JOptionPane.showConfirmDialog(null, "Are you sure want to delete?", "ALERT", JOptionPane.YES_NO_OPTION);
        try {
            if (answer == 0) {
                Iterator<CandidateMaster> i = candidateList.iterator();
                for (CandidateMaster item : candidateList) {
                    if (checked.get(item.getCandidateId())) {
                        port.deleteCandidate(Integer.valueOf(item.getCandidateId()));
                    }
                }
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Candidate Deleted Successfully", "Candidate Deleted Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while deleting the candidates", "Some error occured while deleting the candidates");
                }
                context.addMessage("msg", message);
                loadAllCandidates();
                retval = "candidateDeleted";
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
                result = port.deleteCandidate(candidateId);
                if (result) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Candidate Deleted Successfully", "Candidate Deleted Successfully");
                } else {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Some error occured while deleting the candidate", "Some error occured while deleting the candidate");
                }
                context.addMessage("msg", message);
                loadAllCandidates();
                retval = "candidateDeleted";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return retval;
    }

    public String edit() {
        String retval = null;
        try {
            candidateObj=port.getCandidate(candidateId);
            //candidateId = Integer.valueOf(candidateObj.getCandidateId());
            //JOptionPane.showMessageDialog(null, candidateObj.getZoneMaster());
            firstName = candidateObj.getFirstName();
            lastName = candidateObj.getLastName();
            email = candidateObj.getEmail();
            birthDate = candidateObj.getDateOfBirth();
            nationality = candidateObj.getNationality();
            sex = candidateObj.isSex();
            address = candidateObj.getAddress();
            phoneNumber = candidateObj.getPhoneNo();
            selectedParty = Integer.valueOf(candidateObj.getPartyMaster().getPartyId());
            selectedZone = Integer.valueOf(candidateObj.getZoneMaster().getZoneId());
            selectedWard = Integer.valueOf(candidateObj.getWardMaster().getWardId());
            selectedSubward = Integer.valueOf(candidateObj.getSubWardMaster().getSubWardId());
            selectedArea = Integer.valueOf(candidateObj.getAreaMaster().getAreaId());
            image = candidateObj.getImage();
            isActive = candidateObj.isIsActive();
            retval = "editCandidate";

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "edit" + e);
        }
        return retval;
    }

    public void zoneSelectionChanged(AjaxBehaviorEvent event) {
        wardList = port.getWardsOfZone(selectedZone);
    }

    public void wardSelectionChanged(AjaxBehaviorEvent event) {
        subwardList = port.getSubWardsOfWard(selectedWard);
    }

    public void subwardSelectionChanged(AjaxBehaviorEvent event) {
        areaList = port.getAreaOfSubward(selectedSubward);
    }

    public void uploadCandidateImage() {
        String contentType = uFileCandidateImage.getContentType();
        long size = uFileCandidateImage.getSize();
        String fileName = null;
        if (contentType.contains("jpeg") && size <= 5120000) {

            fileName = RandomNameGenerator.getRandomString();

//            String prefix = FilenameUtils.getBaseName(uFileCandidateImage.getName());
            String suffix = FilenameUtils.getExtension(uFileCandidateImage.getName());

            File file = null;
            OutputStream output = null;

            try {

                // Create file with unique name in upload folder and write to it.
                file = File.createTempFile(fileName, "." + suffix, new File(realPath));
                output = new FileOutputStream(file);

                IOUtils.copy(uFileCandidateImage.getInputStream(), output);

                image = file.getName();
                // JOptionPane.showMessageDialog(null, image);

                // Show succes message.
                /*FacesContext.getCurrentInstance().addMessage("uploadForm", new FacesMessage(
                FacesMessage.SEVERITY_INFO, "File upload succeed!", null));*/


            } catch (IOException e) {
                // Cleanup.
                if (file != null) {
                    file.delete();
                }

                // Show error message.
//                FacesContext.getCurrentInstance().addMessage("uploadForm", new FacesMessage(
//                        FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", null));

                // Always log stacktraces (with a real logger).
                e.printStackTrace();
            } finally {
                IOUtils.closeQuietly(output);
            }
        }
    }

    public String search() {
        try {
            if (searchText != null) {
                if (searchBy.equals("FirstName")) {
                    candidateList = port.searchCandidateByFirstName(searchText, maxResults);
                } else if (searchBy.equals("LastName")) {
                    candidateList = port.searchCandidateByLastName(searchText, maxResults);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return "search";
    }

    public void sort() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String by = req.getParameter("by");
        String order = req.getParameter("order");
        //JOptionPane.showMessageDialog(null, "by " + req.getParameter("by"));
        //JOptionPane.showMessageDialog(null, "order " + req.getParameter("order"));
        if (order.equals("asc")) {
            if (by.equals("firstName")) {
                Collections.sort(candidateList, new CandidateFirstNameAsc());
            } else if (by.equals("lastName")) {
                Collections.sort(candidateList, new CandidateLastNameAsc());
            }
        } else if (order.equals("desc")) {
            if (by.equals("firstName")) {
                Collections.sort(candidateList, new CandidateFirstNameDesc());
            } else if (by.equals("lastName")) {
                Collections.sort(candidateList, new CandidateLastNameDesc());
            }
        }
    }

    public void viewCandidatesByStatus(AjaxBehaviorEvent e) {
        try {
            if (viewCandidates.equals("1")) {
                candidateList=port.getAllCandidates();
            } else if (viewCandidates.equals("2")) {
                candidateList=port.getAllActiveCandidates();
            } else if (viewCandidates.equals("3")) {
                candidateList=port.getAllInActiveCandidates();
            }
        } catch (Exception ex) {
        }
    }

    // <editor-fold defaultstate="collapsed" desc="properties">
    public CandidateMaster getCandidateObj() {
        return candidateObj;
    }

    public void setCandidateObj(CandidateMaster candidateObj) {
        this.candidateObj = candidateObj;
    }

    public String getViewCandidates() {
        return viewCandidates;
    }

    public void setViewCandidates(String viewCandidates) {
        this.viewCandidates = viewCandidates;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(String searchBy) {
        this.searchBy = searchBy;
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

    public UploadedFile getuFileCandidateImage() {
        return uFileCandidateImage;
    }

    public void setuFileCandidateImage(UploadedFile uFileCandidateImage) {
        this.uFileCandidateImage = uFileCandidateImage;
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public Map<String, Boolean> getChecked() {
        return checked;
    }

    public void setChecked(Map<String, Boolean> checked) {
        this.checked = checked;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
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

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<CandidateMaster> getCandidateList() {
        return candidateList;
    }

    public List<ZoneMaster> getZoneList() {
        return zoneList;
    }

    public List<SubWardMaster> getSubwardList() {
        return subwardList;
    }

    public void setSubwardList(List<SubWardMaster> subwardList) {
        this.subwardList = subwardList;
    }

    public void setZoneList(List<ZoneMaster> zoneList) {
        this.zoneList = zoneList;
    }

    public Integer getSelectedZone() {
        return selectedZone;
    }

    public void setSelectedZone(Integer selectedZone) {
        this.selectedZone = selectedZone;
    }

    public void setCandidateList(List<CandidateMaster> candidateList) {
        this.candidateList = candidateList;
    }

    public Integer getSelectedSubward() {
        return selectedSubward;
    }

    public void setSelectedSubward(Integer selectedSubward) {
        this.selectedSubward = selectedSubward;
    }

    public List<PartyMaster> getPartyList() {
        return partyList;
    }

    public void setPartyList(List<PartyMaster> partyList) {
        this.partyList = partyList;
    }

    public List<WardMaster> getWardList() {
        return wardList;
    }

    public void setWardList(List<WardMaster> wardList) {
        this.wardList = wardList;
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

    public Integer getSelectedParty() {
        return selectedParty;
    }

    public void setSelectedParty(Integer selectedParty) {
        this.selectedParty = selectedParty;
    }

    public Integer getSelectedWard() {
        return selectedWard;
    }

    public void setSelectedWard(Integer selectedWard) {
        this.selectedWard = selectedWard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public XMLGregorianCalendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(XMLGregorianCalendar birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return "INDIAN";
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getPartyId() {
        return partyId;
    }

    public void setPartyId(Integer partyId) {
        this.partyId = partyId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Integer getWardId() {
        return wardId;
    }

    public void setWardId(Integer wardId) {
        this.wardId = wardId;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="navigation">
    public void change(AjaxBehaviorEvent e) {
        pageRows = Integer.valueOf(pageList);
        totalPages = candidateList.size() / pageRows;
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
    }// </editor-fold>
}

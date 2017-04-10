/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenbeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import misc.FaceImageCompareAlgo;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import service.CitizenMaster;

/**
 *
 * @author ankur
 */
public class FaceRecognitionBean {

    private String realPath;
    private String tempPath;
    private UploadedFile uploadedFile;
    private String message;
    HttpSession session = null;
    HttpServletRequest request = null;
    HttpServletResponse response = null;
    private CitizenMaster cm = null;

    /** Creates a new instance of FaceRecognitionBean */
    public FaceRecognitionBean() {
    }

    @PostConstruct
    public void initialise() {
        try {
            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            session = request.getSession();

            cm = (CitizenMaster) session.getAttribute("citizenmaster");
            realPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images");
            tempPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/temp");
        } catch (Exception e) {
        }
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String uploadImage() {
        String retval = null;
        String contentType = uploadedFile.getContentType();
        long size = uploadedFile.getSize();
        String fileName = null;
        if (contentType.contains("jpeg") && size <= 5120000) {

            fileName = new Date() + uploadedFile.getName();

            String prefix = FilenameUtils.getBaseName(uploadedFile.getName());
            String suffix = FilenameUtils.getExtension(uploadedFile.getName());

            JOptionPane.showMessageDialog(null, prefix);
            JOptionPane.showMessageDialog(null, suffix);

            File file = null;
            OutputStream output = null;

            try {

                // Create file with unique name in upload folder and write to it.
                file = File.createTempFile(prefix + "_", "." + suffix, new File(tempPath));

                output = new FileOutputStream(file);

                IOUtils.copy(uploadedFile.getInputStream(), output);

                fileName = file.getName();
                //JOptionPane.showMessageDialog(null, file.getName());                

                String path1 = file.getAbsolutePath();
                String path2 = realPath + "/" + cm.getFaceImage();
                boolean result = FaceImageCompareAlgo.compare(path1, path2);
                if (result) {
                    message = "Your face has been verified successfully";                    
                    session.setAttribute("bioidentified", true);
                    retval="success";
                } else {
                    message="Sorry... Your image does not match";
                    retval="failure";
                }

                file.delete();
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
        return retval;
    }
}

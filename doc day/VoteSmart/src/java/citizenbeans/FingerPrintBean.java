/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenbeans;

import Biometrics.CFingerPrint;
import Biometrics.CFingerPrintGraphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import misc.RandomNameGenerator;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import service.CitizenMaster;

/**
 *
 * @author root
 */
public class FingerPrintBean {

    private UploadedFile uploadedFile;
    private CFingerPrint m_finger1 = new CFingerPrint();
    private CFingerPrint m_finger2 = new CFingerPrint();
    private CFingerPrintGraphics m_fingergfx = new CFingerPrintGraphics();
    private BufferedImage m_bimage1 = new BufferedImage(m_finger1.FP_IMAGE_WIDTH, m_finger1.FP_IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
    private BufferedImage m_bimage2 = new BufferedImage(m_finger2.FP_IMAGE_WIDTH, m_finger2.FP_IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
    private double finger1[] = new double[m_finger1.FP_TEMPLATE_MAX_SIZE];
    private double finger2[] = new double[m_finger2.FP_TEMPLATE_MAX_SIZE];
    private String realPath; //to images folder
    private String message;
    HttpSession session = null;
    HttpServletRequest request = null;
    HttpServletResponse response = null;
    private CitizenMaster cm = null;
    private String tempPath;
    String path1;
    String path2;

    @PostConstruct
    public void initialise() {
        try {
            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            session = request.getSession();

            cm = (CitizenMaster) session.getAttribute("citizenmaster");
            realPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/img");
            tempPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/temp");
            //JOptionPane.showMessageDialog(null, tempPath);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getClass());
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    /** Creates a new instance of FingerPrintBean */
    public FingerPrintBean() {
    }

    public String uploadImage() {
        String retval = null;
        String contentType = uploadedFile.getContentType();
        long size = uploadedFile.getSize();
        String fileName = null;

        fileName = new Date() + uploadedFile.getName();

        String prefix = FilenameUtils.getBaseName(uploadedFile.getName());
        String suffix = FilenameUtils.getExtension(uploadedFile.getName());

        File file = null;
        OutputStream output = null;

        try {

            // Create file with unique name in upload folder and write to it.
            file = File.createTempFile(prefix + "_", "." + suffix, new File(tempPath));

            output = new FileOutputStream(file);

            IOUtils.copy(uploadedFile.getInputStream(), output);

            fileName = file.getName();
//            JOptionPane.showMessageDialog(null, file.getName());
            //retval = "fingerPrintUploaded";

            // Show succes message.
                /*FacesContext.getCurrentInstance().addMessage("uploadForm", new FacesMessage(
            FacesMessage.SEVERITY_INFO, "File upload succeed!", null));*/

            path1 = file.getAbsolutePath();
//            JOptionPane.showMessageDialog(null, path1);
            path2 = realPath + "/" + cm.getThumbImage();
//            JOptionPane.showMessageDialog(null, path1);
//            JOptionPane.showMessageDialog(null, path2);

            int result = matchImages();
            String match = Double.toString(result);
            //JOptionPane.showMessageDialog(null, match);
            message = match + "% match found";
            session.setAttribute("message", message);
            session.setAttribute("match", result);
//            ((HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse()).sendRedirect("FingerPrintTemplates.jsf");
            retval="showTemplates";
            file.delete();

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
        return retval;
    }

    public int matchImages() {
        int retval = 0;
        try {
            //picture1
            // m_bimage1 = ImageIO.read(new File(realPath + "/biometrics/ProcessedSample1.bmp"));
            m_bimage1 = ImageIO.read(new File(path1));
            //Send image for skeletinization
            m_finger1.setFingerPrintImage(m_bimage1);
            finger1 = m_finger1.getFingerPrintTemplate();
            //See what skeletinized image looks like
            m_bimage1 = m_finger1.getFingerPrintImageDetail();

            File f1 = new File(tempPath + "/" + RandomNameGenerator.getRandomString());
            session.setAttribute("path1", f1.getName());
            ImageIO.write(m_bimage1, "jpg", f1);

            //picture2
            //m_bimage2 = ImageIO.read(new File(realPath + "/biometrics/ProcessedSample1.bmp"));
            m_bimage2 = ImageIO.read(new File(path2));
            //Send image for skeletinization
            m_finger2.setFingerPrintImage(m_bimage2);
            finger2 = m_finger2.getFingerPrintTemplate();
            //See what skeletinized image looks like
            m_bimage2 = m_finger2.getFingerPrintImageDetail();
            File f2 = new File(tempPath + "/" + RandomNameGenerator.getRandomString());
            session.setAttribute("path2", f2.getName());
            ImageIO.write(m_bimage1, "jpg", f2);

            retval = m_finger1.Match(finger1, finger2, 65, false);

            /*HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            request.setAttribute("image1", m_bimage1);
            RequestDispatcher rd = request.getRequestDispatcher("FingerPrintTemplates.jsf");
            rd.forward(request, response);*/
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return retval;
    }

    public String goToVotePage() {
        String retval=null;
        try {
            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            session = request.getSession(false);
            if (session.getAttribute("match") != null) {
                Integer match = Integer.valueOf(session.getAttribute("match").toString());
                if (match >= 85) {
                    //response.sendRedirect("/client/CastVote.jsf");
                    session.setAttribute("bioauthenticated", true);
                    retval="castVote";
                } else {
                    request.logout();
                    session.invalidate();
                    //response.sendRedirect("/LoginPage.jsf");
                    retval="sendToLogin";
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getClass());
        }
        return retval;
    }
}

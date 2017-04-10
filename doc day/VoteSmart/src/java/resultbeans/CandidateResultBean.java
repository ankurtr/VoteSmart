/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resultbeans;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.primefaces.component.chart.series.ChartSeries;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.PieChartModel;
import service.CandidateMaster;
import service.EPollWebService;
import service.ElectionMaster;
import service.WardMaster;
import service.XmlHashMapHelperIL;
import service.XmlHashMapIL;
import service.XmlHashMapWrapperIL;
import service.ZoneMaster;

/**
 *
 * @author milan
 */
public class CandidateResultBean implements Serializable {

    private CartesianChartModel cartesianModel;
    EPollWebService port;
    private PieChartModel pieModel;
    private List<ElectionMaster> electionList;
    private List<WardMaster> wardList;
    private Integer electionId;
    private List<ZoneMaster> zoneList;
    private Integer zoneId;
    private Integer wardId;
    private List<ZoneMaster> tzoneList;
    private HtmlDataTable dataTable1;
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;
    private Long count;

    public CandidateResultBean() {
    }

    @PostConstruct
    public void initialise() {
        request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        session = request.getSession(false);
        port = (EPollWebService) session.getAttribute("port");

        electionList = port.getAllElections();

        //     JOptionPane.showMessageDialog(null, "e size : " + electionList.size());
        zoneList = port.getAllZones();
//        electionList = port.getAllElections();
        //       JOptionPane.showMessageDialog(null, electionList.size());

        //   createPieModel();
        wardId=1;
        createCartesianModel();

    }

    public HtmlDataTable getDataTable1() {
        return dataTable1;
    }

    public void setDataTable1(HtmlDataTable dataTable1) {
        this.dataTable1 = dataTable1;
    }

    public Long getCount() {
        ZoneMaster z = (ZoneMaster) dataTable1.getRowData();
        count = port.getVoteCountForZone(Integer.valueOf(z.getZoneId()), 1);
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<ZoneMaster> getTzoneList() {
        return tzoneList;
    }

    public void setTzoneList(List<ZoneMaster> tzoneList) {
        this.tzoneList = tzoneList;
    }

    public CartesianChartModel getCartesianModel() {
        return cartesianModel;
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public Integer getWardId() {
        return wardId;
    }

    public void setWardId(Integer wardId) {
        this.wardId = wardId;
    }

    public List<WardMaster> getWardList() {
        return wardList;
    }

    public void setWardList(List<WardMaster> wardList) {
        this.wardList = wardList;
    }

    public void change() {
        wardList = port.getWardsOfZone(zoneId);

    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public List<ZoneMaster> getZoneList() {
        return port.getAllZones();
    }

    public void setZoneList(List<ZoneMaster> zoneList) {
        this.zoneList = zoneList;
    }

    public Integer getElectionId() {
        return electionId;
    }

    public void setElectionId(Integer electionId) {
        this.electionId = electionId;
    }

    public List<ElectionMaster> getElectionList() {
        return electionList;
    }

    public void setElectionList(List<ElectionMaster> electionList) {
        this.electionList = electionList;
    }

    public void createCandidateChart() {
    }

    public void createCartesianModel() {
        try {
            JOptionPane.showMessageDialog(null, "hhello" + wardId);
            cartesianModel = new CartesianChartModel();

            ChartSeries candidate = new ChartSeries();
            candidate.setLabel("");

            List<CandidateMaster> cList = port.getCandidatesOfWard(wardId);
            Iterator<CandidateMaster> it = cList.iterator();

            XmlHashMapIL map = port.getCandidateWiseVoteCountsForWard(1, wardId);
            XmlHashMapWrapperIL wrap = map.getMap();
            List<XmlHashMapHelperIL> list = wrap.getListOfKeyValuePairs();
            Iterator<XmlHashMapHelperIL> iterator = list.iterator();
            while (iterator.hasNext()) {
                XmlHashMapHelperIL il = iterator.next();
                // tempMap.put(ii.getKey(), ii.getValue());
                CandidateMaster cm = port.getCandidate(il.getKey());
                candidate.set(cm.getFirstName(), il.getValue());
            }
            cartesianModel.addSeries(candidate);
        } catch (Exception e) {
            e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public void createPieModel() {

        try {
            //    XmlHashMapIL candidateList = port.getCandidateWiseVoteCountsForElection(1);
            //    XmlHashMapWrapperIL it = candidateList.getMap();
            //  List list=it.getListOfKeyValuePairs();
            //  HashMap<Integer,Long> hash= new HashMap<Integer, Long>();

            // ListIterator ite=  list.listIterator();


            pieModel = new PieChartModel();
            //   long count = port.getVoteCountForCandidate(1, 1);
            List<CandidateMaster> candidateList = port.getCandidatesOfWard(1);

            Iterator<CandidateMaster> it = candidateList.iterator();

            while (it.hasNext()) {
                CandidateMaster cm = it.next();
                pieModel.set(cm.getFirstName(), port.getVoteCountForCandidate(Integer.valueOf(cm.getCandidateId()), 1));
                //          pieMAP.put(cm.getFirstName(), port.getVoteCountForCandidate(Integer.valueOf(cm.getCandidateId()), 1));
            }
//            pieModel.set("Ankur", port.getVoteCountForCandidate(1, 1));
//
//            pieModel.set("Milan", port.getVoteCountForCandidate(6, 1));
//            pieModel.set("Shanshank", port.getVoteCountForCandidate(5, 1));
//            pieModel.set("Raj", 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }
}

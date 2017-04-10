/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resultbeans;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.primefaces.component.chart.series.ChartSeries;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.PieChartModel;
import service.EPollWebService;
import service.ElectionMaster;
import service.PartyMaster;
import org.primefaces.component.datatable.DataTable;

/**
 *
 * @author milan
 */
@ViewScoped
public class PartyBean implements Serializable {

    private CartesianChartModel cartesianModel;
    EPollWebService port;
    private PieChartModel pieModel;
    private List<ElectionMaster> electionList;
    private Integer electionId;
    private HtmlDataTable dataTable1;
    private List<PartyMaster> partyList;
    private Long count;
    private DataTable pDT;
    private Long primeCount;
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;

    public PartyBean() {
    }

    @PostConstruct
    public void initialise() {
        request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        session = request.getSession(false);
        port = (EPollWebService) session.getAttribute("port");

        electionList = port.getAllElections();

        //     JOptionPane.showMessageDialog(null, "e size : " + electionList.size());
//        electionList = port.getAllElections();
        //       JOptionPane.showMessageDialog(null, electionList.size());
        partyList = port.getAllParties();
        createPieModel();
        createCartesianModel();
    }

    public DataTable getpDT() {
        return pDT;

    }

    public void setpDT(DataTable pDT) {
        this.pDT = pDT;
    }

    public List<PartyMaster> getPartyList() {
        return partyList;
    }

    public void setPartyList(List<PartyMaster> partyList) {
        this.partyList = partyList;
    }

    public HtmlDataTable getDataTable1() {
        return dataTable1;
    }

    public void setDataTable1(HtmlDataTable dataTable1) {
        this.dataTable1 = dataTable1;
    }

    public Long getPrimeCount() {
        PartyMaster p = (PartyMaster) pDT.getRowData();
        primeCount = port.getVoteCountForParty(Integer.valueOf(p.getPartyId()), 1);
        return primeCount;
    }

    public void setPrimeCount(Long primeCount) {
        this.primeCount = primeCount;
    }

    public Long getCount() {
        PartyMaster p = (PartyMaster) dataTable1.getRowData();
        count = port.getVoteCountForParty(Integer.valueOf(p.getPartyId()), 1);
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public CartesianChartModel getCartesianModel() {
        return cartesianModel;
    }

    public PieChartModel getPieModel() {
        return pieModel;
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

    private void createCartesianModel() {
        try {
            cartesianModel = new CartesianChartModel();

            ChartSeries party = new ChartSeries();
            party.setLabel("Party");


            //  List<ZoneMaster> tz = new ArrayList<ZoneMaster>();
            //  tz=port.getAllZones();
            Iterator<PartyMaster> it = partyList.iterator();


            //     JOptionPane.showMessageDialog(null, zoneList.size());
            while (it.hasNext()) {
                PartyMaster pm = it.next();
                party.set(pm.getPartyName(), port.getVoteCountForParty(Integer.valueOf(pm.getPartyId()), 1));
                //   tzoneList.add(zm);
            }

            //  boys.set("2004", 120);
            //   boys.set("2005", 100);
            //   boys.set("2006", 44);
            //   boys.set("2007", 150);
            //   boys.set("2008", 25);

            cartesianModel.addSeries(party);
            //  cartesianModel.addSeries(girls);
        } catch (Exception e) {
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

            Iterator<PartyMaster> it = partyList.iterator();

            while (it.hasNext()) {
                PartyMaster pm = it.next();
                pieModel.set(pm.getPartyName(), port.getVoteCountForParty(Integer.valueOf(pm.getPartyId()), 1));
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

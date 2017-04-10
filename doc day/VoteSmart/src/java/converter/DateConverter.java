/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.swing.JOptionPane;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author root
 */
public class DateConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        XMLGregorianCalendar xcal = null;
        Date date=null;
        Calendar cal=null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            date = sdf.parse(value);
            cal=Calendar.getInstance();
            cal.setTime(date);
            xcal=DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar)cal);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "date converter GAO" + e);
        }
        return xcal;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String retval = null;
        Date date=null;
        try {            
            if (value instanceof XMLGregorianCalendarImpl) {
                XMLGregorianCalendarImpl xcal=(XMLGregorianCalendarImpl) value;
                date=xcal.toGregorianCalendar().getTime();                
            } else if (value instanceof Date) {
                date=(Date) value;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            retval = sdf.format(date);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "date converter GAS" + e);
        }
        return retval;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adminbeans;

import java.util.Locale;
import javax.faces.context.FacesContext;

/**
 *
 * @author root
 */
public class ChangeLocaleBean {

    //private String language;
    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    public void setLanguage(String language) {
        locale=new Locale(language,"IN");
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }

    
    /** Creates a new instance of ChangeLocaleBean */
    public ChangeLocaleBean() {
    }

//    public void changeLanguage() {
//        Locale locale = null;
//        if (!selectedLocale.equals("en")) {
//            locale = new Locale(selectedLocale, "IN");
//        } else if (selectedLocale.equals("en")) {
//            locale = new Locale("en", "US");
//        }
//        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
//    }
}

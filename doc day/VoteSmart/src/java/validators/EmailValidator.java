/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.swing.JOptionPane;

/**
 *
 * @author ankur
 */
public class EmailValidator implements Validator {

    private String regex = "[a-z0-9_\\.]+@.+\\..+";
    Pattern p = Pattern.compile(regex);
    Matcher m;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        m = p.matcher((String) value);
        String svalue = ((EditableValueHolder) component).getSubmittedValue().toString();
        //JOptionPane.showMessageDialog(null, value);
        System.out.println("String value :-" + svalue);
        if (!m.matches()) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email is not valid one", "*Invalid Email");
            context.addMessage(component.getClientId(context), msg);
            // throw new ValidatorException(msg);
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 *
 * @author ankur
 */
public class XmlHashMapHelperIL {

    @XmlAttribute
    public Integer key;
    @XmlValue
    public Long value;

    public XmlHashMapHelperIL() {
    }

    public XmlHashMapHelperIL(Integer key, Long value) {
        this.key = key;
        this.value = value;
    }
}

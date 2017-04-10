/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 *
 * @author Ankur Trapasiya
 *
 * This class is one type of helper class which specifies the data type of Key and Value Objects in your
 * Map. They must be object.
 */
public class XmlHashMapHelperII {

    @XmlAttribute
    public Integer key;
    @XmlValue
    public Integer value;

    public XmlHashMapHelperII() {
    }

    public XmlHashMapHelperII(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package misc;

import java.util.List;

/**
 *
 * @author Ankur Trapasiya
 *
 * This class wraps your HashMap in List<T>. Here T means your XmlHashMapHelperII class in which your key
 * and value data type has been specified..
 */
public class XmlHashMapWrapperII {

    private List<XmlHashMapHelperII> listOfKeyValuePairs;

    public List<XmlHashMapHelperII> getListOfKeyValuePairs() {
        return listOfKeyValuePairs;
    }

    public void setListOfKeyValuePairs(List<XmlHashMapHelperII> listOfKeyValuePairs) {
        this.listOfKeyValuePairs = listOfKeyValuePairs;
    }

}

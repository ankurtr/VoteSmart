/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author ankur
 */
public class RandomNameGenerator {

    public static String getRandomString() {
        String fileName = new Date().toString();
        fileName = fileName.replaceAll("[\\s,:]", "");
        return fileName;
    }
}

/**
 * @author: Leung, Leonhard
 * Date: 10/04/2023
 */

package util;

import list.LinkedList;
import java.io.*;

public class Export {
    public void exportTo(LinkedList<Object> list, String filename) throws IOException {
        String defaultDirectory = "csv_exports/";

        File file = new File(defaultDirectory + filename + ".csv");

        PrintWriter printWriter = new PrintWriter(file);

        for (int i = 0; i < list.size(); i++) {
            printWriter.println(list.get(i).toString());
        }

        printWriter.close();
    } // end of exportTo method
} // end of Exporter class

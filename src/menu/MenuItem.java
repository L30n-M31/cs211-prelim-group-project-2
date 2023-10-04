/**
 * @author: Leung, Leonhard
 * Date: 10/04/2023
 */

package menu;

import java.io.IOException;

public interface MenuItem {
    int size();
    Object getData(Object data);
    Object getData(int index);
    void addToList(Object data);
    void removeFromList(Object data);
    void updateDetails(Object currentData, Object newData);
    void exportList(String filename) throws IOException;
} // end of MenuItem interface

/**
 * @author: Leung, Leonhard
 * Date: 10/04/2023
 */

package gui.tools;

import java.io.IOException;

public interface GuiOperations {
    void view();
    void add();
    void remove();
    void update();
    void export() throws IOException;
} // end of GuiOperations interface

/**
 * @author: Leung, Leonhard
 * Date: 10/04/2023
 */

package gui.panels;

import javax.swing.*;
import java.awt.*;

public class HomepagePanel {
    JPanel panel;
    JLabel homepage;

    public HomepagePanel() {
        panel = new JPanel();
        homepage = new JLabel();
        createPanel();
    } // end of default constructor

    public void createPanel() {
        Color beige = Color.decode("#DDC3A5");
        panel.setLayout(null);
        panel.setLocation(340, 40);
        panel.setSize(1100, 680);
        panel.setBackground(beige);

        homepage.setIcon(new ImageIcon("res/Welcome Student!.png"));
        homepage.setBounds(-1,-160,1252,1000);

        panel.add(homepage);
    } // end of createPanel method

    public JPanel getPanel() {
        return panel;
    } // end of getPanel method
} // end of HomepagePanel class
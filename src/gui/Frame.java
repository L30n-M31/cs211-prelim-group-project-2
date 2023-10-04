/**
 * @author: Leung, Leonhard
 * Date: 10/04/2023
 */

package gui;

import javax.swing.*;

public class Frame {
    SidePanel sidePanel;
    JFrame frame;

    public Frame() {
        frame = new JFrame("Cedarwood Academy Portal Prototype");
    } // end of constructor

    public void loadGUI() {
        sidePanel = new SidePanel(frame);
        createFrame();
        setAppIcon();
    } // end of loadGUI method

    public void createFrame() {
        frame.setLayout(null);
        frame.setSize(1500, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    } // end of createFrame method

    public void setAppIcon() {
        ImageIcon img = new ImageIcon("res/logo.png");
        frame.setIconImage(img.getImage());
    } // end of setAppIcon method
} // end of Frame class

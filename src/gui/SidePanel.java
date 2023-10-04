/**
 * @author: Leung, Leonhard
 * Date: 10/04/2023
 */

package gui;

import gui.tools.CardPanel;
import list.NestedList;
import menu.CurriculumChecklist;
import menu.MySchedule;
import menu.TranscriptOfRecords;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SidePanel implements ActionListener {
    private final NestedList nestedList = new NestedList();
    private final CurriculumChecklist curriculumChecklist = new CurriculumChecklist(nestedList);
    private final TranscriptOfRecords transcriptOfRecords = new TranscriptOfRecords(nestedList);
    private final MySchedule mySchedule = new MySchedule(nestedList);

    private final CardPanel cardPanel = new CardPanel(curriculumChecklist, transcriptOfRecords, mySchedule);

    private final JPanel sidePanel;
    private JButton homepageButton, curriculumChecklistButton, transcriptOfRecordsButton, myScheduleButton, personalDetailsButton;

    public SidePanel(JFrame frame) {
        sidePanel = new JPanel();
        createSidePanelButtons();
        createSidePanel();

        frame.add(sidePanel);
        frame.add(cardPanel.getCardPanel());
    } // end of constructor;

    public void createSidePanel() {
        Color tan = Color.decode("#E0A96D");
        sidePanel.setLayout(null);
        sidePanel.setBounds(0,0,300,800);
        sidePanel.setBackground(tan);

        JLabel panelColor = new JLabel();
        panelColor.setIcon(new ImageIcon("res/panelColor.png"));
        panelColor.setBounds(25,20,600,800);

        JLabel schoolLogo = new JLabel();
        schoolLogo.setIcon(new ImageIcon("res/logo2.png"));
        schoolLogo.setBounds(94,35,212,300);

        JLabel schoolName = new JLabel();
        schoolName.setIcon(new ImageIcon("res/panelSchoolName.png"));
        schoolName.setBounds(24,5,300,79);

        sidePanel.add(schoolName);
        sidePanel.add(schoolLogo);
        sidePanel.add(panelColor);
    } // end of createSidePanel method

    public void createSidePanelButtons() {
        homepageButton = new JButton();
        homepageButton.setIcon(new ImageIcon("res/homepage.png"));
        homepageButton.setContentAreaFilled(false);
        homepageButton.setBorderPainted(false);
        curriculumChecklistButton = new JButton();
        curriculumChecklistButton.setIcon(new ImageIcon("res/curriculumChecklist.png"));
        curriculumChecklistButton.setContentAreaFilled(false);
        curriculumChecklistButton.setBorderPainted(false);
        transcriptOfRecordsButton = new JButton();
        transcriptOfRecordsButton.setIcon(new ImageIcon("res/transcriptsofRecords.png"));
        transcriptOfRecordsButton.setContentAreaFilled(false);
        transcriptOfRecordsButton.setBorderPainted(false);
        myScheduleButton = new JButton();
        myScheduleButton.setIcon(new ImageIcon("res/mySchedule.png"));
        myScheduleButton.setContentAreaFilled(false);
        myScheduleButton.setBorderPainted(false);

        personalDetailsButton = new JButton();
        personalDetailsButton.setIcon(new ImageIcon("res/personalDetails.png"));
        personalDetailsButton.setContentAreaFilled(false);
        personalDetailsButton.setBorderPainted(false);

        homepageButton.setBounds(75, 280, 150, 70);
        curriculumChecklistButton.setBounds(75, 370, 150, 70);
        transcriptOfRecordsButton.setBounds(75, 470, 150, 70);
        myScheduleButton.setBounds(75, 570, 150, 70);
        personalDetailsButton.setBounds(75, 670, 150, 50);

        sidePanel.add(homepageButton);
        sidePanel.add(curriculumChecklistButton);
        sidePanel.add(transcriptOfRecordsButton);
        sidePanel.add(myScheduleButton);
        sidePanel.add(personalDetailsButton);

        homepageButton.addActionListener(this);
        curriculumChecklistButton.addActionListener(this);
        transcriptOfRecordsButton.addActionListener(this);
        myScheduleButton.addActionListener(this);
        personalDetailsButton.addActionListener(this);
    } // end of createSidePanelButtons method

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homepageButton) {
            cardPanel.getC1().show(cardPanel.getCardPanel(), "1");
        }
        if (e.getSource() == curriculumChecklistButton) {
            cardPanel.getC1().show(cardPanel.getCardPanel(), "2");
        }
        if (e.getSource() == transcriptOfRecordsButton) {
            cardPanel.getC1().show(cardPanel.getCardPanel(), "3");
        }
        if (e.getSource() == myScheduleButton) {
            cardPanel.getC1().show(cardPanel.getCardPanel(), "4");
        }
        if (e.getSource() == personalDetailsButton) {
            cardPanel.getC1().show(cardPanel.getCardPanel(), "5");
        }
    } // end of actionPerformed method
} // end of SidePanel class

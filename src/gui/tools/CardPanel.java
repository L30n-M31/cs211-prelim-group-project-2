/**
 * @author: Leung, Leonhard
 * Date: 10/04/2023
 */

package gui.tools;

import gui.panels.*;
import menu.CurriculumChecklist;
import menu.MySchedule;
import menu.TranscriptOfRecords;
import javax.swing.*;
import java.awt.*;

public class CardPanel {
    private final CurriculumChecklist curriculumChecklist;
    private final TranscriptOfRecords transcriptOfRecords;
    private final MySchedule mySchedule;

    private final CardLayout c1;
    private final JPanel cardPanel;

    public CardPanel(CurriculumChecklist curriculumChecklist, TranscriptOfRecords transcriptOfRecords, MySchedule mySchedule) {
        this.curriculumChecklist = curriculumChecklist;
        this.transcriptOfRecords = transcriptOfRecords;
        this.mySchedule = mySchedule;

        cardPanel = new JPanel();
        c1 = new CardLayout();
        createCardPanel();
        populateCardPanel();
    } // end of default constructor

    public void createCardPanel() {
        cardPanel.setLayout(c1);
        cardPanel.setLocation(340, 40);
        cardPanel.setSize(1100, 680);
    } // end of createCartPanel method

    public void populateCardPanel() {
        HomepagePanel homepagePanel = new HomepagePanel();
        CurriculumChecklistPanel curriculumChecklistPanel = new CurriculumChecklistPanel(curriculumChecklist);
        TranscriptOfRecordsPanel transcriptOfRecordsPanel = new TranscriptOfRecordsPanel(transcriptOfRecords);
        MySchedulePanel mySchedulePanel = new MySchedulePanel(mySchedule);
        PersonalDetailsPanel personalDetailsPanel = new PersonalDetailsPanel();

        cardPanel.add(homepagePanel.getPanel(), "1");
        cardPanel.add(curriculumChecklistPanel.getPanel(), "2");
        cardPanel.add(transcriptOfRecordsPanel.getPanel(), "3");
        cardPanel.add(mySchedulePanel.getPanel(), "4");
        cardPanel.add(personalDetailsPanel.getPanel(), "5");
    } // end of populateCardPanel method

    public JPanel getCardPanel() {
        return cardPanel;
    }

    public CardLayout getC1() {
        return c1;
    }
} // end of CardPanel class
/**
 * @author: Leung, Leonhard
 * Date: 10/04/2023
 */

package gui.tools;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class GraphicEditor {
    //------------------------------------------------< Color Scheme >--------------------------------------------------
    private final Color darkBrown = new Color(32, 30, 32);
    private final Color tan = new Color(224, 169, 109);
    private final Color beige = new Color(221, 195, 165);
    private final Color softGray = new Color(224, 224, 224);

    //-------------------------------------------< Panel bounds and design >--------------------------------------------
    public void setPanelBounds(JPanel panel) {
        panel.setLayout(null);
        panel.setLocation(340, 40);
        panel.setSize(1100, 680);
    } // end of setPanelBounds method

    public void setSubPanelBounds(JPanel panel) {
        panel.setLayout(null);
        panel.setLocation(20, 20);
        panel.setSize(1060, 600);
    } // end of setSubPanelBounds method

    public void setPanelDesign(JPanel panel) {
        panel.setBackground(darkBrown);
    } // end of setPanelDesign method

    public void setSubPanelDesign(JPanel panel) {
        panel.setBackground(beige);
    } // end of setSubPanelDesign

    //------------------------------------------------< Buttons >-------------------------------------------------------
    public void setPanelButtons(JPanel panel, JButton viewButton, JButton addButton, JButton removeButton,
                                JButton updateButton, JButton exportButton) {

        viewButton.setBounds(41, 636, 175, 30);
        addButton.setBounds(252, 636, 175, 30);
        removeButton.setBounds(465, 636, 175, 30);
        updateButton.setBounds(677, 636, 175, 30);
        exportButton.setBounds(890, 636, 175, 30);

        setFontFormat(viewButton);
        setFontFormat(addButton);
        setFontFormat(removeButton);
        setFontFormat(updateButton);
        setFontFormat(exportButton);

        panel.add(viewButton);
        panel.add(addButton);
        panel.add(removeButton);
        panel.add(updateButton);
        panel.add(exportButton);
    } // end of setPanelButtons method

    public void setPanelButtons(JPanel panel, JButton viewButton, JButton updateButton) {
        viewButton.setBounds(351, 636, 175, 30);
        updateButton.setBounds(561, 636, 175, 30);

        setFontFormat(viewButton);
        setFontFormat(updateButton);

        panel.add(viewButton);
        panel.add(updateButton);
    } // end of setPanelButtons method

    public void setSubPanelButton(JPanel panel, JButton button) {
        button.setBounds(430, 510, 200, 60);
        button.setFont(new Font("Monospaced", Font.BOLD, 25));
        button.setForeground(tan);
        button.setBackground(darkBrown);
        panel.add(button);
    } // end of setSubPanelButton method

    public void setTableSubPanelButton(JPanel panel, JButton button) {
        button.setBounds(390, 540, 280, 30);
        button.setFont(new Font("Monospaced", Font.BOLD, 20));
        button.setForeground(tan);
        button.setBackground(darkBrown);
        panel.add(button);
    } // end of setTableSubPanelButton method

    //-----------------------------------------------< Card Panel >-----------------------------------------------------
    public void setSubCardPanel(JPanel cardPanel, CardLayout c1) {
        cardPanel.setLayout(c1);
        cardPanel.setLocation(20, 20);
        cardPanel.setSize(1060, 600);
    } // end of setSubCardPanel method

    public void populateCardPanel(JPanel panel, JPanel cardPanel, JPanel viewPanel, JPanel addPanel, JPanel removePanel,
                                  JPanel updatePanel, JPanel exportPanel, int panelNumber) {
        String view = ".1";
        String add = ".2";
        String remove = ".3";
        String update = ".4";
        String export = ".5";

        cardPanel.add(viewPanel, panelNumber + view);
        cardPanel.add(addPanel, panelNumber + add);
        cardPanel.add(removePanel, panelNumber + remove);
        cardPanel.add(updatePanel, panelNumber + update);
        cardPanel.add(exportPanel, panelNumber + export);
        panel.add(cardPanel);
    } // end of populateCardPanel method

    public void populateCardPanel(JPanel panel, JPanel cardPanel, JPanel viewPanel, JPanel updatePanel, int panelNumber) {
        String view = ".1";
        String update = ".2";

        cardPanel.add(viewPanel, (panelNumber + view));
        cardPanel.add(updatePanel, (panelNumber + update));
        panel.add(cardPanel);
    } // end of populateCardPanel method

    //-------------------------< Font Style, Color, and Size for TextFields and Labels >--------------------------------
    public void setFontFormat(JButton button) {
        button.setFont(new Font("Monospaced", Font.BOLD, 15));
        button.setHorizontalAlignment(JLabel.CENTER);
        button.setBackground(beige);
        button.setForeground(darkBrown);
    } // end of setFontFormat method

    public void setFontFormat(JLabel label) {
        label.setFont(new Font("Monospaced", Font.BOLD, 25));
        label.setHorizontalAlignment(JLabel.CENTER);
    } // end of setFontFormat method

    public void setFontFormat(JTextField textField) {
        textField.setFont(new Font("Monospaced", Font.BOLD, 25));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setBackground(tan);
    } // end of setFontFormat method

    public void setTitleFormat(JLabel title) {
        title.setBounds(0, 20, 1060, 60);
        title.setFont(new Font("Monospaced", Font.BOLD, 55));
        title.setHorizontalAlignment(JLabel.CENTER);
    } // end of setTitleFormat method

    public void setTitlePersonalDetailsFormat(JLabel title) {
        title.setBounds(80, 40, 1060, 30);
        title.setFont(new Font("Monospaced", Font.BOLD, 27));
        title.setHorizontalAlignment(JLabel.LEFT);
    } // end of setTitlePersonalDetailsPanelFormat method

    public void setJComboBoxFormat(JComboBox<Object> jComboBox) {
        jComboBox.setFont(new Font("Monospaced", Font.BOLD, 17));
        jComboBox.setBackground(tan);
        jComboBox.setForeground(darkBrown);
    } // end of setJComboBoxFormat method

    //--------------------------------------< Curriculum Checklist Components >-----------------------------------------
    public void setCurriculumComboBoxFormat(JPanel panel, JComboBox<Object> jComboBox, JLabel jComboBoxLB) {
        jComboBox.setBounds(35, 248, 300, 45);
        jComboBoxLB.setBounds(35, 283, 300, 60);

        setFontFormat(jComboBoxLB);
        setJComboBoxFormat(jComboBox);

        DefaultListCellRenderer listCellRenderer = new DefaultListCellRenderer();
        listCellRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        jComboBox.setRenderer(listCellRenderer);

        panel.add(jComboBox);
        panel.add(jComboBoxLB);
    } // end of setCurriculumComboBoxFormat

    public void setCurriculumUpdateButton(JPanel panel, JButton button) {
        button.setBounds(85, 480, 200, 60);
        button.setFont(new Font("Monospaced", Font.BOLD, 25));
        button.setForeground(tan);
        button.setBackground(darkBrown);
        panel.add(button);
    } // end of setCurriculumUpdateButton method

    public void setCurriculumViewPanelTableFormat(JTable table, JScrollPane scrollPane) {
        table.setOpaque(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        scrollPane.setBounds(20, 20, 1020, 500);
        table.setSize(1020, 500);

        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        table.getTableHeader().setFont(new Font("Monospaced", Font.BOLD, 14));
        table.setFont(new Font("Monospaced", Font.PLAIN, 13));

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(200);
        columnModel.getColumn(1).setPreferredWidth(90);
        columnModel.getColumn(2).setPreferredWidth(90);
        columnModel.getColumn(3).setPreferredWidth(180);
        columnModel.getColumn(4).setPreferredWidth(90);
        columnModel.getColumn(5).setPreferredWidth(90);
        columnModel.getColumn(6).setPreferredWidth(90);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < 7; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        table.setBackground(tan);
        table.setForeground(darkBrown);
        table.getTableHeader().setBackground(darkBrown);
        table.getTableHeader().setForeground(tan);
        scrollPane.getViewport().setBackground(softGray);
        scrollPane.getVerticalScrollBar().setBackground(tan);
    } // end of setCurriculumViewPanelTableFormat method

    public void setCurriculumAddPanelTF(JPanel panel, JTextField courseName, JTextField courseCode, JTextField classCode,
                                        JTextField instructor, JTextField year, JTextField semester,
                                        JTextField units) {

        courseName.setBounds(35, 120, 300, 60);
        courseCode.setBounds(380, 120, 300, 60);
        classCode.setBounds(725, 120, 300, 60);
        instructor.setBounds(35, 250, 300, 60);
        year.setBounds(380, 250, 300, 60);
        semester.setBounds(725, 250, 300, 60);
        units.setBounds(380, 380, 300, 60);

        setFontFormat(courseName);
        setFontFormat(courseCode);
        setFontFormat(classCode);
        setFontFormat(instructor);
        setFontFormat(year);
        setFontFormat(semester);
        setFontFormat(units);

        panel.add(courseName);
        panel.add(courseCode);
        panel.add(classCode);
        panel.add(instructor);
        panel.add(year);
        panel.add(semester);
        panel.add(units);
    } // end of curriculumAddPanelTF method

    public void setCurriculumAddPanelLB(JPanel panel, JLabel title, JLabel courseName, JLabel courseCode, JLabel classCode,
                                        JLabel instructor, JLabel year, JLabel semester, JLabel units) {

        title.setBounds(0, 20, 1060, 60);
        courseName.setBounds(35, 170, 300, 60);
        courseCode.setBounds(380, 170, 300, 60);
        classCode.setBounds(725, 170, 300, 60);
        instructor.setBounds(35, 300, 300, 60);
        year.setBounds(380, 300, 300, 60);
        semester.setBounds(725, 300, 300, 60);
        units.setBounds(380, 430, 300, 60);

        setTitleFormat(title);
        setFontFormat(courseName);
        setFontFormat(courseCode);
        setFontFormat(classCode);
        setFontFormat(instructor);
        setFontFormat(year);
        setFontFormat(semester);
        setFontFormat(units);

        panel.add(title);
        panel.add(courseName);
        panel.add(courseCode);
        panel.add(classCode);
        panel.add(instructor);
        panel.add(year);
        panel.add(semester);
        panel.add(units);
    } // end of setCurriculumAddPaneLB method

    public void setCurriculumRemovePanelTF(JPanel panel, JTextField courseCode, JTextField classCode) {
        courseCode.setBounds(150, 250, 300, 60);
        classCode.setBounds(600, 250, 300, 60);

        setFontFormat(courseCode);
        setFontFormat(classCode);

        panel.add(courseCode);
        panel.add(classCode);
    } // end of setCurriculumRemovePanelTF method

    public void setCurriculumRemovePanelLB(JPanel panel, JLabel title, JLabel courseCode, JLabel classCode) {
        title.setBounds(0, 20, 1060, 60);
        courseCode.setBounds(150, 300, 300, 60);
        classCode.setBounds(600, 300, 300, 60);

        setTitleFormat(title);
        setFontFormat(courseCode);
        setFontFormat(classCode);

        panel.add(title);
        panel.add(courseCode);
        panel.add(classCode);
    } // end of setCurriculumRemovePanelLB method

    public void setCurriculumUpdateTF(JPanel panel, JTextField courseName, JTextField courseCode,
                                      JTextField classCode, JTextField instructor, JTextField year, JTextField semester,
                                      JTextField units) {

        courseName.setBounds(380, 120, 300, 60);
        courseCode.setBounds(725, 120, 300, 60);
        classCode.setBounds(380, 240, 300, 60);
        instructor.setBounds(725, 240, 300, 60);
        year.setBounds(380, 360, 300, 60);
        semester.setBounds(725, 360, 300, 60);
        units.setBounds(553, 480, 300, 60);

        setFontFormat(courseName);
        setFontFormat(courseCode);
        setFontFormat(classCode);
        setFontFormat(instructor);
        setFontFormat(year);
        setFontFormat(semester);
        setFontFormat(units);

        panel.add(courseName);
        panel.add(courseCode);
        panel.add(classCode);
        panel.add(instructor);
        panel.add(year);
        panel.add(semester);
        panel.add(units);
    } // end of setCurriculumUpdateTF method

    public void setCurriculumUpdateLB(JPanel panel, JLabel title, JLabel courseName, JLabel courseCode, JLabel classCode,
                                      JLabel instructor, JLabel year, JLabel semester, JLabel units) {

        title.setBounds(0, 20, 1060, 60);
        courseName.setBounds(380, 170, 300, 60);
        courseCode.setBounds(725, 170, 300, 60);
        classCode.setBounds(380, 290, 300, 60);
        instructor.setBounds(725, 290, 300, 60);
        year.setBounds(380, 410, 300, 60);
        semester.setBounds(725, 410, 300, 60);
        units.setBounds(553, 530, 300, 60);

        setTitleFormat(title);
        setFontFormat(courseName);
        setFontFormat(courseCode);
        setFontFormat(classCode);
        setFontFormat(instructor);
        setFontFormat(year);
        setFontFormat(semester);
        setFontFormat(units);

        panel.add(title);
        panel.add(courseName);
        panel.add(courseCode);
        panel.add(classCode);
        panel.add(instructor);
        panel.add(year);
        panel.add(semester);
        panel.add(units);
    } // end of setCurriculumUpdateLB method

    public void setCurriculumExportPanelTF(JPanel panel, JTextField exportTF) {
        exportTF.setBounds(380, 300, 300, 60);
        setFontFormat(exportTF);
        panel.add(exportTF);
    } // end of setCurriculumExportPanelTF method

    public void setCurriculumExportPanelLB(JPanel panel, JLabel title, JLabel description, JLabel fileNameLB) {
        title.setBounds(0, 20, 1060, 60);
        description.setBounds(0, 170, 1060, 60);
        fileNameLB.setBounds(0, 350, 1060, 60);

        setTitleFormat(title);
        setFontFormat(description);
        setFontFormat(fileNameLB);

        panel.add(title);
        panel.add(description);
        panel.add(fileNameLB);
    } // end of setCurriculumExportPanelLB method

    //-----------------------------------< Transcript of Records Components >-------------------------------------------
    public void setTranscriptComboBoxFormat(JPanel panel, JComboBox<Object> jComboBox, JLabel jComboBoxLB) {
        jComboBox.setBounds(35, 255, 300, 45);
        jComboBoxLB.setBounds(35, 290, 300, 60);

        setFontFormat(jComboBoxLB);
        setJComboBoxFormat(jComboBox);

        DefaultListCellRenderer listCellRenderer = new DefaultListCellRenderer();
        listCellRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        jComboBox.setRenderer(listCellRenderer);

        panel.add(jComboBox);
        panel.add(jComboBoxLB);
    } // end of setTranscriptComboBoxFormat

    public void setTranscriptViewPanelTableFormat(JTable table, JScrollPane scrollPane) {
        table.setOpaque(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        scrollPane.setBounds(20, 20, 1020, 500);
        table.setSize(1020, 500);

        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        table.getTableHeader().setFont(new Font("Monospaced", Font.BOLD, 14));
        table.setFont(new Font("Monospaced", Font.PLAIN, 13));

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(200);
        columnModel.getColumn(1).setPreferredWidth(90);
        columnModel.getColumn(2).setPreferredWidth(90);
        columnModel.getColumn(3).setPreferredWidth(90);
        columnModel.getColumn(4).setPreferredWidth(160);
        columnModel.getColumn(5).setPreferredWidth(90);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < 6; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        table.setBackground(tan);
        table.setForeground(darkBrown);
        table.getTableHeader().setBackground(darkBrown);
        table.getTableHeader().setForeground(tan);
        scrollPane.getViewport().setBackground(softGray);
        scrollPane.getVerticalScrollBar().setBackground(tan);
    } // end of setTranscriptViewPanelTableFormat method

    public void setTranscriptAddPanelTF(JPanel panel, JTextField courseName, JTextField courseCode,
                                        JTextField prelimGrade, JTextField midtermGrade, JTextField tentativeFinalGrade,
                                        JTextField finalGrade) {

        courseName.setBounds(120, 185, 350, 60);
        courseCode.setBounds(145, 335, 300, 60);
        prelimGrade.setBounds(610, 110, 70, 60);
        midtermGrade.setBounds(610, 210, 70, 60);
        tentativeFinalGrade.setBounds(610, 310, 70, 60);
        finalGrade.setBounds(610, 410, 70, 60);

        setFontFormat(courseName);
        setFontFormat(courseCode);
        setFontFormat(prelimGrade);
        setFontFormat(midtermGrade);
        setFontFormat(tentativeFinalGrade);
        setFontFormat(finalGrade);

        panel.add(courseName);
        panel.add(courseCode);
        panel.add(prelimGrade);
        panel.add(midtermGrade);
        panel.add(tentativeFinalGrade);
        panel.add(finalGrade);
    } // end of setTranscriptAddPanelTF method

    public void setTranscriptAddPanelLB(JPanel panel, JLabel title, JLabel courseName, JLabel courseCode,
                                        JLabel prelimGrade, JLabel midtermGrade, JLabel tentativeFinalGrade, JLabel finalGrade) {

        title.setBounds(0, 20, 1060, 60);
        courseName.setBounds(120, 235, 350, 60);
        courseCode.setBounds(145, 385, 300, 60);
        prelimGrade.setBounds(630, 110, 300, 60);
        midtermGrade.setBounds(635, 210, 300, 60);
        tentativeFinalGrade.setBounds(685, 310, 320, 60);
        finalGrade.setBounds(620, 410, 300, 60);


        setTitleFormat(title);
        setFontFormat(courseName);
        setFontFormat(courseCode);
        setFontFormat(prelimGrade);
        setFontFormat(midtermGrade);
        setFontFormat(tentativeFinalGrade);
        setFontFormat(finalGrade);

        panel.add(title);
        panel.add(courseName);
        panel.add(courseCode);
        panel.add(prelimGrade);
        panel.add(midtermGrade);
        panel.add(tentativeFinalGrade);
        panel.add(finalGrade);
    } // end of setTranscriptAddPanelLB method

    public void setTranscriptRemovePanelTF(JPanel panel, JTextField courseName, JTextField courseCode) {
        courseName.setBounds(150, 250, 300, 60);
        courseCode.setBounds(600, 250, 300, 60);

        setFontFormat(courseName);
        setFontFormat(courseCode);

        panel.add(courseName);
        panel.add(courseCode);
    } // end of setTranscriptRemovePanelTF method

    public void setTranscriptRemovePanelLB(JPanel panel, JLabel title, JLabel courseName, JLabel courseCode) {
        title.setBounds(0, 20, 1060, 60);
        courseName.setBounds(150, 300, 300, 60);
        courseCode.setBounds(600, 300, 300, 60);

        setTitleFormat(title);
        setFontFormat(courseName);
        setFontFormat(courseCode);

        panel.add(title);
        panel.add(courseName);
        panel.add(courseCode);
    } // end of setTranscriptRemovePanelLB method

    public void setTranscriptUpdatePanelTF(JPanel panel, JTextField prelimGrade, JTextField midtermGrade, JTextField tentativeFinalGrade, JTextField finalGrade) {
        prelimGrade.setBounds(380, 180, 300, 60);
        midtermGrade.setBounds(725, 180, 300, 60);
        tentativeFinalGrade.setBounds(380, 310, 300, 60);
        finalGrade.setBounds(725, 310, 300, 60);

        setFontFormat(prelimGrade);
        setFontFormat(midtermGrade);
        setFontFormat(tentativeFinalGrade);
        setFontFormat(finalGrade);

        panel.add(prelimGrade);
        panel.add(midtermGrade);
        panel.add(tentativeFinalGrade);
        panel.add(finalGrade);
    } // end of setTranscriptUpdateTF method

    public void setTranscriptUpdatePanelLB(JPanel panel, JLabel title, JLabel prelimGrade, JLabel midtermGrade,
                                           JLabel tentativeFinalGrade, JLabel finalGrade) {

        title.setBounds(0, 20, 1060, 60);
        prelimGrade.setBounds(380, 230, 300, 60);
        midtermGrade.setBounds(725, 230, 300, 60);
        tentativeFinalGrade.setBounds(280, 360, 500, 60);
        finalGrade.setBounds(725, 360, 300, 60);

        setTitleFormat(title);
        setFontFormat(prelimGrade);
        setFontFormat(midtermGrade);
        setFontFormat(tentativeFinalGrade);
        setFontFormat(finalGrade);

        panel.add(title);
        panel.add(prelimGrade);
        panel.add(midtermGrade);
        panel.add(tentativeFinalGrade);
        panel.add(finalGrade);
    } // end of setTranscriptUpdatePanelLB method

    public void setTranscriptExportPanelTF(JPanel panel, JTextField exportTF) {
        exportTF.setBounds(380, 300, 300, 60);
        setFontFormat(exportTF);
        panel.add(exportTF);
    } // end of setTranscriptExportPanelTF method

    public void setTranscriptExportPanelLB(JPanel panel, JLabel title, JLabel description, JLabel filenameLB) {
        title.setBounds(0, 20, 1060, 60);
        description.setBounds(0, 170, 1060, 60);
        filenameLB.setBounds(0, 350, 1060, 60);

        setTitleFormat(title);
        setFontFormat(description);
        setFontFormat(filenameLB);

        panel.add(title);
        panel.add(description);
        panel.add(filenameLB);
    } // end of setTranscriptExportPanelLB method

    //-----------------------------------------< My Schedule Components >-----------------------------------------------
    public void setMyScheduleComboBoxFormat(JPanel panel, JComboBox<Object> jComboBox, JLabel jComboBoxLB) {
        jComboBox.setBounds(35, 255, 300, 45);
        jComboBoxLB.setBounds(35, 290, 300, 60);

        setFontFormat(jComboBoxLB);
        setJComboBoxFormat(jComboBox);

        DefaultListCellRenderer listCellRenderer = new DefaultListCellRenderer();
        listCellRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        jComboBox.setRenderer(listCellRenderer);

        panel.add(jComboBox);
        panel.add(jComboBoxLB);
    } // end of setMyScheduleComboBoxFormat method

    public void setMyScheduleViewPanelTableFormat(JTable table, JScrollPane scrollPane) {
        table.setOpaque(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        scrollPane.setBounds(20, 20, 1020, 500);
        table.setSize(1020, 500);

        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        table.getTableHeader().setFont(new Font("Monospaced", Font.BOLD, 14));
        table.setFont(new Font("Monospaced", Font.PLAIN, 13));

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(200);
        columnModel.getColumn(1).setPreferredWidth(90);
        columnModel.getColumn(2).setPreferredWidth(90);
        columnModel.getColumn(3).setPreferredWidth(90);
        columnModel.getColumn(4).setPreferredWidth(160);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < 5; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        table.setBackground(tan);
        table.setForeground(darkBrown);
        table.getTableHeader().setBackground(darkBrown);
        table.getTableHeader().setForeground(tan);
        scrollPane.getViewport().setBackground(softGray);
        scrollPane.getVerticalScrollBar().setBackground(tan);
    } // end of setMyScheduleViewPanelTableFormat method

    public void setMyScheduleAddPanelTF(JPanel panel, JTextField courseName, JTextField courseCode, JTextField startTime,
                                      JTextField endTime, JTextField days, JTextField roomNumber) {

        courseName.setBounds(35, 160, 300, 60);
        courseCode.setBounds(380, 160, 300, 60);
        startTime.setBounds(725, 160, 300, 60);
        endTime.setBounds(35, 310, 300, 60);
        days.setBounds(380, 310, 300, 60);
        roomNumber.setBounds(725, 310, 300, 60);

        setFontFormat(courseName);
        setFontFormat(courseCode);
        setFontFormat(startTime);
        setFontFormat(endTime);
        setFontFormat(days);
        setFontFormat(roomNumber);

        panel.add(courseName);
        panel.add(courseCode);
        panel.add(startTime);
        panel.add(endTime);
        panel.add(days);
        panel.add(roomNumber);
    } // end of setScheduleAddPanelTF method

    public void setMyScheduleAddPanelLB(JPanel panel, JLabel title, JLabel courseName, JLabel courseCode, JLabel
            startTime, JLabel endTime, JLabel days, JLabel roomNumber) {

        title.setBounds(0, 20, 1060, 60);
        courseName.setBounds(35, 210, 300, 60);
        courseCode.setBounds(380, 210, 300, 60);
        startTime.setBounds(725, 210, 300, 60);
        endTime.setBounds(35, 360, 300, 60);
        days.setBounds(385, 360, 300, 60);
        roomNumber.setBounds(725, 360, 300, 60);

        setTitleFormat(title);
        setFontFormat(courseName);
        setFontFormat(courseCode);
        setFontFormat(startTime);
        setFontFormat(endTime);
        setFontFormat(days);
        setFontFormat(roomNumber);

        panel.add(title);
        panel.add(courseName);
        panel.add(courseCode);
        panel.add(startTime);
        panel.add(endTime);
        panel.add(days);
        panel.add(roomNumber);
    } // end of setScheduleAddPanelLB method

    public void setMyScheduleRemovePanelTF(JPanel panel, JTextField courseName, JTextField courseCode) {
        courseName.setBounds(150, 250, 300, 60);
        courseCode.setBounds(600, 250, 300, 60);

        setFontFormat(courseName);
        setFontFormat(courseCode);

        panel.add(courseName);
        panel.add(courseCode);
    } // end of setMyScheduleRemovePanelTF method

    public void setMyScheduleRemovePanelLB(JPanel panel, JLabel title, JLabel courseName, JLabel courseCode) {
        title.setBounds(0, 20, 1060, 60);
        courseName.setBounds(150, 300, 300, 60);
        courseCode.setBounds(600, 300, 300, 60);

        setTitleFormat(title);
        setFontFormat(courseName);
        setFontFormat(courseCode);

        panel.add(title);
        panel.add(courseName);
        panel.add(courseCode);
    } // end of setMyScheduleRemovePanelLB method

    public void setMyScheduleUpdatePanelTF(JPanel panel, JTextField startTime, JTextField endTime, JTextField days, JTextField roomNumber) {
        startTime.setBounds(380, 180, 300, 60);
        endTime.setBounds(725, 180, 300, 60);
        days.setBounds(380, 310, 300, 60);
        roomNumber.setBounds(725, 310, 300, 60);

        setFontFormat(startTime);
        setFontFormat(endTime);
        setFontFormat(days);
        setFontFormat(roomNumber);

        panel.add(startTime);
        panel.add(endTime);
        panel.add(days);
        panel.add(roomNumber);
    } // end of setMyScheduleUpdatePanelTF method

    public void setMyScheduleUpdatePanelLB(JPanel panel, JLabel title, JLabel startTime, JLabel endTime, JLabel days, JLabel roomNumber) {
        title.setBounds(0, 20, 1060, 60);
        startTime.setBounds(380, 230, 300, 60);
        endTime.setBounds(725, 230, 300, 60);
        days.setBounds(280, 360, 500, 60);
        roomNumber.setBounds(725, 360, 300, 60);

        setTitleFormat(title);
        setFontFormat(startTime);
        setFontFormat(endTime);
        setFontFormat(days);
        setFontFormat(roomNumber);

        panel.add(title);
        panel.add(startTime);
        panel.add(endTime);
        panel.add(days);
        panel.add(roomNumber);
    } // end of setMyScheduleUpdatePanelLB method

    public void setMyScheduleExportPanelTF(JPanel panel, JTextField exportTF) {
        exportTF.setBounds(380, 300, 300, 60);
        setFontFormat(exportTF);
        panel.add(exportTF);
    } // end of setMyScheduleExportPanelTF method

    public void setMyScheduleExportPanelLB(JPanel panel, JLabel title, JLabel description, JLabel filenameLB) {
        title.setBounds(0, 20, 1060, 60);
        description.setBounds(0, 170, 1060, 60);
        filenameLB.setBounds(0, 350, 1060, 60);

        setTitleFormat(title);
        setFontFormat(description);
        setFontFormat(filenameLB);

        panel.add(title);
        panel.add(description);
        panel.add(filenameLB);
    } // end of setMyScheduleExportPanelLB method

    //-----------------------------------------< Personal Details Components >------------------------------------------
    public void setPersonalDetailsViewPanelTF(JPanel panel, JTextField firstNameField, JTextField lastNameField, JTextField genderField,
                                           JTextField IDNumberField, JTextField birthdayField, JTextField contactField) {

        firstNameField.setBounds(420, 120, 250, 50);
        lastNameField.setBounds(740, 120, 250, 50);
        birthdayField.setBounds(420, 280, 250, 50);
        IDNumberField.setBounds(740, 280, 250, 50);
        genderField.setBounds(420, 440, 250, 50);
        contactField.setBounds(740, 440, 250, 50);

        setFontFormat(firstNameField);
        setFontFormat(lastNameField);
        setFontFormat(birthdayField);
        setFontFormat(IDNumberField);
        setFontFormat(genderField);
        setFontFormat(contactField);

        panel.add(firstNameField);
        panel.add(lastNameField);
        panel.add(birthdayField);
        panel.add(IDNumberField);
        panel.add(genderField);
        panel.add(contactField);

        firstNameField.setEnabled(false);
        lastNameField.setEnabled(false);
        birthdayField.setEnabled(false);
        IDNumberField.setEnabled(false);
        genderField.setEnabled(false);
        contactField.setEnabled(false);

        firstNameField.setDisabledTextColor(darkBrown);
        lastNameField.setDisabledTextColor(darkBrown);
        birthdayField.setDisabledTextColor(darkBrown);
        IDNumberField.setDisabledTextColor(darkBrown);
        genderField.setDisabledTextColor(darkBrown);
        contactField.setDisabledTextColor(darkBrown);
    } // end of setPersonalDetailsViewPanelTF method

    public void setPersonalDetailsViewPanelLB(JPanel panel, JLabel title, JLabel firstName, JLabel lastName, JLabel
            birthday, JLabel IDNumber, JLabel gender, JLabel contactNumber, JLabel personalIcon) {

        title.setBounds(0, 20, 1060, 60);
        firstName.setBounds(420, 170, 250, 50);
        lastName.setBounds(740, 170, 250, 50);
        gender.setBounds(420, 330, 250, 50);
        IDNumber.setBounds(740, 330, 250, 50);
        birthday.setBounds(420, 490, 250, 50);
        contactNumber.setBounds(740, 490, 250, 50);
        personalIcon.setBounds(100, 160, 300, 300);

        setTitlePersonalDetailsFormat(title);
        setFontFormat(firstName);
        setFontFormat(lastName);
        setFontFormat(gender);
        setFontFormat(IDNumber);
        setFontFormat(birthday);
        setFontFormat(contactNumber);

        panel.add(title);
        panel.add(firstName);
        panel.add(lastName);
        panel.add(gender);
        panel.add(IDNumber);
        panel.add(birthday);
        panel.add(contactNumber);
        panel.add(personalIcon);
    } // end of setPersonalDetailsViewPanelLB

    public void setPersonalDetailsUpdatePanelTF(JPanel panel, JTextField firstName, JTextField
            lastName, JTextField birthday, JTextField IDNumber, JTextField gender, JTextField contactNumber) {

        firstName.setBounds(35, 150, 300, 60);
        lastName.setBounds(380, 150, 300, 60);
        birthday.setBounds(725, 150, 300, 60);
        IDNumber.setBounds(35, 300, 300, 60);
        gender.setBounds(380, 300, 300, 60);
        contactNumber.setBounds(725, 300, 300, 60);

        setFontFormat(firstName);
        setFontFormat(lastName);
        setFontFormat(birthday);
        setFontFormat(IDNumber);
        setFontFormat(gender);
        setFontFormat(contactNumber);

        panel.add(firstName);
        panel.add(lastName);
        panel.add(birthday);
        panel.add(IDNumber);
        panel.add(gender);
        panel.add(contactNumber);
    } // end of setPersonalDetailsUpdatePanelTF method

    public void setPersonalDetailsUpdatePanelLB(JPanel panel, JLabel title, JLabel firstName, JLabel lastName,
                                             JLabel birthday, JLabel IDNumber, JLabel gender, JLabel contactNumber) {

        title.setBounds(0, 20, 1060, 60);
        firstName.setBounds(35, 200, 300, 60);
        lastName.setBounds(380, 200, 300, 60);
        birthday.setBounds(725, 200, 300, 60);
        IDNumber.setBounds(35, 350, 300, 60);
        gender.setBounds(380, 350, 300, 60);
        contactNumber.setBounds(725, 350, 300, 60);

        setTitleFormat(title);
        setFontFormat(firstName);
        setFontFormat(lastName);
        setFontFormat(gender);
        setFontFormat(birthday);
        setFontFormat(IDNumber);
        setFontFormat(contactNumber);

        panel.add(title);
        panel.add(firstName);
        panel.add(lastName);
        panel.add(gender);
        panel.add(birthday);
        panel.add(IDNumber);
        panel.add(contactNumber);
    } // end of setPersonalDetailsUpdatePanelLB method
} // end of PanelStructure class

/**
 * @author: Leung, Leonhard
 * Date: 10/04/2023
 */

package gui.panels;

import academics.Grade;
import gui.tools.GraphicEditor;
import gui.tools.GuiOperations;
import menu.TranscriptOfRecords;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class TranscriptOfRecordsPanel implements ActionListener {
    private final TranscriptOfRecords transcriptOfRecords;
    private final GraphicEditor edit = new GraphicEditor();
    private SubTranscriptOfRecordsPanel subPanel;
    private JPanel panel;
    private final JButton viewButton = new JButton("View Record");
    private final JButton addButton = new JButton("Add Grades");
    private final JButton removeButton = new JButton("Remove Grades");
    private final JButton updateButton = new JButton("Update Grades");
    private final JButton exportButton = new JButton("Export");

    public TranscriptOfRecordsPanel(TranscriptOfRecords transcriptOfRecords) {
        this.transcriptOfRecords = transcriptOfRecords;
        initializePanels();
        setPanelStructure();
        subPanel.run(panel);
    } // end of constructor

    public void initializePanels() {
        panel = new JPanel();
        subPanel = new SubTranscriptOfRecordsPanel(this.transcriptOfRecords);
    } // end of initializePanels method

    public void setPanelStructure() {
        edit.setPanelBounds(panel);
        edit.setPanelDesign(panel);
        edit.setPanelButtons(panel, viewButton, addButton, removeButton, updateButton, exportButton);
        setButtonActions();
    } // end of setPanelStructure method

    public void setButtonActions() {
        viewButton.addActionListener(this);
        addButton.addActionListener(this);
        removeButton.addActionListener(this);
        updateButton.addActionListener(this);
        exportButton.addActionListener(this);
    } // end of setButtonActions method

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewButton) {
            subPanel.getC1().show(subPanel.getCardPanel(), "3.1");
        }
        if (e.getSource() == addButton) {
            subPanel.getC1().show(subPanel.getCardPanel(), "3.2");
        }
        if (e.getSource() == removeButton) {
            subPanel.getC1().show(subPanel.getCardPanel(), "3.3");
        }
        if (e.getSource() == updateButton) {
            subPanel.getC1().show(subPanel.getCardPanel(), "3.4");
        }
        if (e.getSource() == exportButton) {
            subPanel.getC1().show(subPanel.getCardPanel(), "3.5");
        }
    } // end of actionPerformed method

    public JPanel getPanel() {
        return panel;
    } // end of getPanel method

    private static class SubTranscriptOfRecordsPanel implements GuiOperations, ActionListener {
        private final TranscriptOfRecords list;
        private final GraphicEditor edit = new GraphicEditor();
        private final CardLayout c1 = new CardLayout();
        private JPanel cardPanel, viewPanel, addPanel, removePanel, updatePanel, exportPanel;
        private final JButton viewButton = new JButton("VIEW UPDATED TABLE");
        private final JButton addButton = new JButton("ADD");
        private final JButton removeButton = new JButton("REMOVE");
        private final JButton updateButton = new JButton("UPDATE");
        private final JButton exportButton = new JButton("EXPORT");
        private JTextField addCourseNameTF, addCourseCodeTF, addPrelimGradeTF, addMidtermGradeTF, addTentativeFinalGradeTF, addFinalGradeTF;
        private JTextField removeCourseNameTF, removeCourseCodeTF, exportTF;
        private JTextField updatePrelimGradeTF, updateMidtermGradeTF, updateTentativeGradeTF, updateFinalGradeTF;
        private JLabel atitle, rTitle, uTitle, eTitle, description;
        private JLabel addCourseNameLB, addCourseCodeLB, addPrelimGradeLB, addMidtermGradeLB, addTentativeFinalGradeLB, addFinalGradeLB;
        private JLabel removeCourseNameLB, removeCourseCodeLB, exportLB, updateJComboBoxLB;
        private JLabel updatePrelimGradeLB, updateMidtermGradeLB, updateTentativeFinalGradeLB, updateFinalGradeLB;
        private JComboBox<Object> gradeList;

        public SubTranscriptOfRecordsPanel(TranscriptOfRecords transcriptOfRecords) {
            list = transcriptOfRecords;
            initializeComponents();
            setLabels();
            setPanelStructure();
        } // end of constructor

        public void run(JPanel panel) {
            edit.setSubPanelBounds(panel);
            edit.setSubCardPanel(cardPanel, c1);
            edit.populateCardPanel(panel, cardPanel, viewPanel, addPanel, removePanel, updatePanel, exportPanel, 3);
        } // end of run method

        public void initializeComponents() {
            cardPanel = new JPanel();
            viewPanel = new JPanel();
            addPanel = new JPanel();
            removePanel = new JPanel();
            updatePanel = new JPanel();
            exportPanel = new JPanel();

            addCourseNameTF = new JTextField();
            addCourseCodeTF = new JTextField();
            addPrelimGradeTF = new JTextField();
            addMidtermGradeTF = new JTextField();
            addTentativeFinalGradeTF = new JTextField();
            addFinalGradeTF = new JTextField();

            removeCourseCodeTF = new JTextField();
            removeCourseNameTF = new JTextField();
            updatePrelimGradeTF = new JTextField();
            updateMidtermGradeTF = new JTextField();
            updateTentativeGradeTF = new JTextField();
            updateFinalGradeTF = new JTextField();

            exportTF = new JTextField();

            atitle = new JLabel();
            rTitle = new JLabel();
            eTitle = new JLabel();
            uTitle = new JLabel();

            addCourseNameLB = new JLabel();
            addCourseCodeLB = new JLabel();
            addPrelimGradeLB = new JLabel();
            addMidtermGradeLB = new JLabel();
            addTentativeFinalGradeLB = new JLabel();
            addFinalGradeLB = new JLabel();

            removeCourseCodeLB = new JLabel();
            removeCourseNameLB = new JLabel();
            updatePrelimGradeLB = new JLabel();
            updateMidtermGradeLB = new JLabel();
            updateTentativeFinalGradeLB = new JLabel();
            updateFinalGradeLB = new JLabel();

            updateJComboBoxLB = new JLabel();
            description = new JLabel();
            exportLB = new JLabel();
            gradeList = new JComboBox<>();
        } // end of initializeComponents method

        public void setLabels() {
            atitle.setText("ADD A GRADE");
            rTitle.setText("REMOVE A GRADE");
            eTitle.setText("EXPORT RECORD");
            uTitle.setText("UPDATE A GRADE");

            addCourseNameLB.setText("COURSE NAME");
            addCourseCodeLB.setText("COURSE CODE");
            addPrelimGradeLB.setText("PRELIM GRADE");
            addMidtermGradeLB.setText("MIDTERM GRADE");
            addTentativeFinalGradeLB.setText("TENTATIVE FINAL GRADE");
            addFinalGradeLB.setText("FINAL GRADE");

            removeCourseNameLB.setText("COURSE NAME");
            removeCourseCodeLB.setText("COURSE CODE");

            updateJComboBoxLB.setText("SELECT COURSE");
            updatePrelimGradeLB.setText("PRELIM GRADE");
            updateMidtermGradeLB.setText("MIDTERM GRADE");
            updateTentativeFinalGradeLB.setText("TENTATIVE FINAL GRADE");
            updateFinalGradeLB.setText("FINAL GRADE");

            description.setText("This exports your current record");
            exportLB.setText("FILENAME");
        } // end of setLabels method

        public void clearTextFields() {
            addCourseNameTF.setText(null);
            addCourseCodeTF.setText(null);
            addPrelimGradeTF.setText(null);
            addMidtermGradeTF.setText(null);
            addTentativeFinalGradeTF.setText(null);
            addFinalGradeTF.setText(null);

            removeCourseNameTF.setText(null);
            removeCourseCodeTF.setText(null);

            updatePrelimGradeTF.setText(null);
            updateMidtermGradeTF.setText(null);
            updateTentativeGradeTF.setText(null);
            updateFinalGradeTF.setText(null);

            exportTF.setText(null);
        } // end of clearTextFields method

        public void setTable(JPanel panel, TranscriptOfRecords list) {
            String[] column = {"Course Name", "Course Code", "Prelim Grade", "Midterm Grade", "Tentative Final Grade",
                    "Final Grade"};

            Object[][] data = new Object[list.size()][column.length];
            for (int i = 0; i < list.size(); i++) {
                Grade grade = (Grade) list.getData(i);
                data[i][0] = grade.getCourseName();
                data[i][1] = grade.getCourseCode();
                data[i][2] = grade.getPrelimGrade();
                data[i][3] = grade.getMidtermGrade();
                data[i][4] = grade.getTentativeFinalGrade();
                data[i][5] = grade.getFinalGrade();
            }

            DefaultTableModel model = new DefaultTableModel(data, column) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);

            edit.setTranscriptViewPanelTableFormat(table, scrollPane);

            panel.add(scrollPane);
        } // end of setTable method

        public void setComboBox(JComboBox<Object> gradeList) {
            ArrayList<String> array = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Grade grade = (Grade) list.getData(i);
                array.add(grade.getCourseName());
            }
            gradeList.setModel(new DefaultComboBoxModel<>(array.toArray(new String[0])));
        } // end of setComboBox method

        public void setPanelStructure() {
            // view panel
            edit.setSubPanelBounds(viewPanel);
            edit.setSubPanelDesign(viewPanel);
            edit.setTableSubPanelButton(viewPanel, viewButton);
            setTable(viewPanel, list);
            viewButton.addActionListener(this);

            // add panel
            edit.setSubPanelBounds(addPanel);
            edit.setSubPanelDesign(addPanel);
            edit.setSubPanelButton(addPanel, addButton);
            edit.setTranscriptAddPanelTF(addPanel, addCourseNameTF, addCourseCodeTF, addPrelimGradeTF, addMidtermGradeTF, addTentativeFinalGradeTF, addFinalGradeTF);
            edit.setTranscriptAddPanelLB(addPanel, atitle, addCourseNameLB, addCourseCodeLB, addPrelimGradeLB, addMidtermGradeLB, addTentativeFinalGradeLB, addFinalGradeLB);
            addButton.addActionListener(this);

            // remove panel
            edit.setSubPanelBounds(removePanel);
            edit.setSubPanelDesign(removePanel);
            edit.setSubPanelButton(removePanel, removeButton);
            edit.setTranscriptRemovePanelTF(removePanel, removeCourseNameTF, removeCourseCodeTF);
            edit.setTranscriptRemovePanelLB(removePanel, rTitle, removeCourseNameLB, removeCourseCodeLB);
            removeButton.addActionListener(this);

            // update panel
            edit.setSubPanelBounds(updatePanel);
            edit.setSubPanelDesign(updatePanel);
            edit.setTranscriptComboBoxFormat(updatePanel, gradeList, updateJComboBoxLB);
            edit.setSubPanelButton(updatePanel, updateButton);
            edit.setTranscriptUpdatePanelTF(updatePanel, updatePrelimGradeTF, updateMidtermGradeTF, updateTentativeGradeTF, updateFinalGradeTF);
            edit.setTranscriptUpdatePanelLB(updatePanel, uTitle, updatePrelimGradeLB, updateMidtermGradeLB, updateTentativeFinalGradeLB, updateFinalGradeLB);
            updateButton.addActionListener(this);

            // export panel
            edit.setSubPanelBounds(exportPanel);
            edit.setSubPanelDesign(exportPanel);
            edit.setSubPanelButton(exportPanel, exportButton);
            edit.setTranscriptExportPanelTF(exportPanel, exportTF);
            edit.setTranscriptExportPanelLB(exportPanel, eTitle, description, exportLB);
            exportButton.addActionListener(this);
        } // end of setPanelStructure method

        @Override
        public void view() {
            setTable(viewPanel, list);
        } // end of view method

        @Override
        public void add() {
            String courseName = addCourseNameTF.getText();
            String courseCode = addCourseCodeTF.getText();
            int prelimGrade = Integer.parseInt(addPrelimGradeTF.getText());
            int midtermGrade = Integer.parseInt(addMidtermGradeTF.getText());
            int tentativeFinalGrade = Integer.parseInt(addTentativeFinalGradeTF.getText());
            int finalGrade = Integer.parseInt(addFinalGradeTF.getText());

            Grade grade = new Grade(courseName, courseCode, prelimGrade, midtermGrade, tentativeFinalGrade, finalGrade);

            list.addToList(grade);
        } // end of add method

        @Override
        public void remove() {
            String courseName = removeCourseNameTF.getText();
            String courseCode = removeCourseCodeTF.getText();

            Grade grade = (Grade) list.getData(new Grade(courseName, courseCode, 0, 0, 0, 0));

            list.removeFromList(grade);
        } // end of remove method

        @Override
        public void update() {
            int i = gradeList.getSelectedIndex();
            Grade currentGrade = (Grade) list.getData(i);

            String courseName = currentGrade.getCourseName();
            String courseCode = currentGrade.getCourseCode();

            int prelimGrade, midtermGrade, tentativeFinalGrade, finalGrade;

            if (updatePrelimGradeTF.getText().isEmpty()) {
                prelimGrade = currentGrade.getPrelimGrade();
            } else {
                prelimGrade = Integer.parseInt(updatePrelimGradeTF.getText());
            }

            if (updateMidtermGradeTF.getText().isEmpty()) {
                midtermGrade = currentGrade.getMidtermGrade();
            } else {
                midtermGrade = Integer.parseInt(updateMidtermGradeTF.getText());
            }

            if (updateTentativeGradeTF.getText().isEmpty()) {
                tentativeFinalGrade = currentGrade.getTentativeFinalGrade();
            } else {
                tentativeFinalGrade = Integer.parseInt(updateTentativeGradeTF.getText());
            }

            if (updateFinalGradeTF.getText().isEmpty()) {
                finalGrade = currentGrade.getFinalGrade();
            } else {
                finalGrade = Integer.parseInt(updateFinalGradeTF.getText());
            }

            Grade newGrade = new Grade(courseName, courseCode, prelimGrade, midtermGrade, tentativeFinalGrade, finalGrade);

            list.updateDetails(currentGrade, newGrade);
        } // end of update method

        @Override
        public void export() throws IOException {
            list.exportList(exportTF.getText());
        } // end of export method

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewButton) {
                view();
            }
            if (e.getSource() == addButton) {
                add();
                JOptionPane.showMessageDialog(null, "Grade Added");
            }
            if (e.getSource() == removeButton) {
                remove();
                JOptionPane.showMessageDialog(null, "Grade Removed");
            }
            if (e.getSource() == updateButton) {
                update();
                JOptionPane.showMessageDialog(null, "Grade Updated");
            }
            if (e.getSource() == exportButton) {
                try {
                    export();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Unexpected error during exporting the data \n Process aborted");
                }
            }
            setComboBox(gradeList);
            clearTextFields();
        } // end of actionPerformed method

        public JPanel getCardPanel() {
            return cardPanel;
        }

        public CardLayout getC1() {
            return c1;
        }
    } // end of SubTranscriptOfRecordsPanel
} // end of TranscriptOfRecordsPanel class

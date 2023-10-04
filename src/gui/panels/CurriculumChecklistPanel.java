/**
 * @author: Leung, Leonhard
 * Date: 10/04/2023
 */

package gui.panels;

import academics.Course;
import gui.tools.GraphicEditor;
import gui.tools.GuiOperations;
import menu.CurriculumChecklist;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class CurriculumChecklistPanel implements ActionListener {
    private final CurriculumChecklist curriculumChecklist;
    private final GraphicEditor edit = new GraphicEditor();
    private SubCurriculumChecklistPanel subPanel;
    private JPanel panel;
    private final JButton viewButton = new JButton("View Course");
    private final JButton addButton = new JButton("Add Course");
    private final JButton removeButton = new JButton("Remove Course");
    private final JButton updateButton = new JButton("Update Course");
    private final JButton exportButton = new JButton("Export");

    public CurriculumChecklistPanel(CurriculumChecklist curriculumChecklist) {
        this.curriculumChecklist = curriculumChecklist;

        initializePanels();
        setPanelStructure();
        subPanel.run(panel);
    } // end of constructor

    public void initializePanels() {
        panel = new JPanel();
        subPanel = new SubCurriculumChecklistPanel(this.curriculumChecklist);
    } // end of initializePanels method

    public void setPanelStructure() {
        edit.setPanelBounds(panel);
        edit.setPanelDesign(panel);
        edit.setPanelButtons(panel, viewButton, addButton, removeButton, updateButton, exportButton);
        setButtonActions();
    }

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
            subPanel.getC1().show(subPanel.getCardPanel(), "2.1");
        }
        if (e.getSource() == addButton) {
            subPanel.getC1().show(subPanel.getCardPanel(), "2.2");
        }
        if (e.getSource() == removeButton) {
            subPanel.getC1().show(subPanel.getCardPanel(), "2.3");
        }
        if (e.getSource() == updateButton) {
            subPanel.getC1().show(subPanel.getCardPanel(), "2.4");
        }
        if (e.getSource() == exportButton) {
            subPanel.getC1().show(subPanel.getCardPanel(), "2.5");
        }
    } // end of actionPerformed method

    public JPanel getPanel() {
        return panel;
    } // end of getPanel method

    private static class SubCurriculumChecklistPanel implements GuiOperations, ActionListener {
        private final GraphicEditor edit = new GraphicEditor();
        private final CardLayout c1 = new CardLayout();
        private JPanel cardPanel, viewPanel, addPanel, removePanel, updatePanel, exportPanel;
        private final CurriculumChecklist list;
        private final JButton viewButton = new JButton("VIEW UPDATED TABLE");
        private final JButton addButton = new JButton("ADD");
        private final JButton removeButton = new JButton("REMOVE");
        private final JButton updateButton = new JButton("UPDATE");
        private final JButton exportButton = new JButton("EXPORT");
        private JTextField addCourseNameTF, addCourseCodeTF, addClassCodeTF, addInstructorTF, addYearTF, addSemesterTF,
                addUnitsTF;
        private JTextField removeCourseCodeTF, removeClassCodeTF, exportTF;
        private JTextField updateCourseNameTF, updateCourseCodeTF, updateClassCodeTF, updateInstructorTF, updateYearTF,
                updateSemesterTF, updateUnitsTF;
        private JLabel addCourseNameLB, addCourseCodeLB, addClassCodeLB, addInstructorLB, addYearLB, addSemesterLB,
                addUnitsLB;
        private JLabel aTitle, rTitle, uTitle, eTitle, description;
        private JLabel removeCourseCodeLB, removeClassCodeLB, exportLB, updateJComboBoxLB;
        private JLabel updateCourseNameLB, updateCourseCodeLB,
                updateClassCodeLB, updateInstructorLB, updateYearLB, updateSemesterLB, updateUnitsLB;
        private JComboBox<Object> courseList;

        public SubCurriculumChecklistPanel(CurriculumChecklist curriculumChecklist) {
            list = curriculumChecklist;
            initializeComponents();
            setLabels();
            setPanelStructure();
        } // end of constructor

        public void run(JPanel panel) {
            edit.setSubPanelBounds(panel);
            edit.setSubCardPanel(cardPanel, c1);
            edit.populateCardPanel(panel, cardPanel, viewPanel, addPanel, removePanel, updatePanel, exportPanel, 2);
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
            addClassCodeTF = new JTextField();
            addInstructorTF = new JTextField();
            addYearTF = new JTextField();
            addSemesterTF = new JTextField();
            addUnitsTF = new JTextField();

            removeCourseCodeTF = new JTextField();
            removeClassCodeTF = new JTextField();

            updateCourseNameTF = new JTextField();
            updateCourseCodeTF = new JTextField();
            updateClassCodeTF = new JTextField();
            updateInstructorTF = new JTextField();
            updateYearTF = new JTextField();
            updateSemesterTF = new JTextField();
            updateUnitsTF = new JTextField();

            exportTF = new JTextField();

            aTitle = new JLabel();
            rTitle = new JLabel();
            uTitle = new JLabel();
            eTitle = new JLabel();

            addCourseNameLB = new JLabel();
            addCourseCodeLB = new JLabel();
            addClassCodeLB = new JLabel();
            addInstructorLB = new JLabel();
            addYearLB = new JLabel();
            addSemesterLB = new JLabel();
            addUnitsLB = new JLabel();

            removeCourseCodeLB = new JLabel();
            removeClassCodeLB = new JLabel();

            updateCourseNameLB = new JLabel();
            updateCourseCodeLB = new JLabel();
            updateClassCodeLB = new JLabel();
            updateInstructorLB = new JLabel();
            updateYearLB = new JLabel();
            updateSemesterLB = new JLabel();
            updateUnitsLB = new JLabel();

            updateJComboBoxLB = new JLabel();
            description = new JLabel();
            exportLB = new JLabel();
            courseList = new JComboBox<>();
        } // end of initializeComponents method

        public void setLabels() {
            aTitle.setText("ADD A COURSE");
            rTitle.setText("REMOVE A COURSE");
            uTitle.setText("UPDATE A COURSE");
            eTitle.setText("EXPORT CHECKLIST");

            addCourseNameLB.setText("COURSE NAME");
            addCourseCodeLB.setText("COURSE CODE");
            addClassCodeLB.setText("CLASS CODE");
            addInstructorLB.setText("INSTRUCTOR");
            addYearLB.setText("YEAR");
            addSemesterLB.setText("SEMESTER");
            addUnitsLB.setText("UNITS");

            removeCourseCodeLB.setText("COURSE CODE");
            removeClassCodeLB.setText("CLASS CODE");

            updateJComboBoxLB.setText("SELECT COURSE");
            updateCourseNameLB.setText("COURSE NAME");
            updateCourseCodeLB.setText("COURSE CODE");
            updateClassCodeLB.setText("CLASS CODE");
            updateInstructorLB.setText("INSTRUCTOR");
            updateYearLB.setText("YEAR");
            updateSemesterLB.setText("SEMESTER");
            updateUnitsLB.setText("UNITS");

            description.setText("This exports your current checklist");
            exportLB.setText("FILENAME");
        } // end of setLabels method

        public void clearTextFields() {
            addCourseNameTF.setText(null);
            addCourseCodeTF.setText(null);
            addClassCodeTF.setText(null);
            addInstructorTF.setText(null);
            addYearTF.setText(null);
            addSemesterTF.setText(null);
            addUnitsTF.setText(null);

            removeCourseCodeTF.setText(null);
            removeClassCodeTF.setText(null);

            updateCourseNameTF.setText(null);
            updateCourseCodeTF.setText(null);
            updateClassCodeTF.setText(null);
            updateInstructorTF.setText(null);
            updateYearTF.setText(null);
            updateSemesterTF.setText(null);
            updateUnitsTF.setText(null);

            exportTF.setText(null);
        } // end of clearTextFields method

        public void setTable(JPanel panel, CurriculumChecklist list) {
            String[] column = {"Course Name", "Course Code", "Class Code", "Instructor", "Year", "Semester", "Units"};

            Object[][] data = new Object[list.size()][column.length];
            for (int i = 0; i < list.size(); i++) {
                Course course = (Course) list.getData(i);
                data[i][0] = course.getCourseName();
                data[i][1] = course.getCourseCode();
                data[i][2] = course.getClassCode();
                data[i][3] = course.getInstructor();
                data[i][4] = course.getYear();
                data[i][5] = course.getSemester();
                data[i][6] = course.getUnits();
            }

            DefaultTableModel model = new DefaultTableModel(data, column) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);

            edit.setCurriculumViewPanelTableFormat(table, scrollPane);

            panel.add(scrollPane);
        } // end of setTable method

        public void setComboBox(JComboBox<Object> courseList) {
            ArrayList<String> array = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Course course = (Course) list.getData(i);
                array.add(course.getCourseName());
            }
            courseList.setModel(new DefaultComboBoxModel<>(array.toArray(new String[0])));
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
            edit.setCurriculumAddPanelTF(addPanel, addCourseNameTF, addCourseCodeTF, addClassCodeTF, addInstructorTF, addYearTF, addSemesterTF, addUnitsTF);
            edit.setCurriculumAddPanelLB(addPanel, aTitle, addCourseNameLB, addCourseCodeLB, addClassCodeLB, addInstructorLB, addYearLB, addSemesterLB, addUnitsLB);
            addButton.addActionListener(this);

            // remove panel
            edit.setSubPanelBounds(removePanel);
            edit.setSubPanelDesign(removePanel);
            edit.setSubPanelButton(removePanel, removeButton);
            edit.setCurriculumRemovePanelTF(removePanel, removeCourseCodeTF, removeClassCodeTF);
            edit.setCurriculumRemovePanelLB(removePanel, rTitle, removeCourseCodeLB, removeClassCodeLB);
            removeButton.addActionListener(this);

            // update panel
            edit.setSubPanelBounds(updatePanel);
            edit.setSubPanelDesign(updatePanel);
            edit.setCurriculumComboBoxFormat(updatePanel, courseList, updateJComboBoxLB);
            edit.setCurriculumUpdateButton(updatePanel, updateButton);
            edit.setCurriculumUpdateTF(updatePanel, updateCourseNameTF, updateCourseCodeTF, updateClassCodeTF, updateInstructorTF, updateYearTF, updateSemesterTF, updateUnitsTF);
            edit.setCurriculumUpdateLB(updatePanel, uTitle, updateCourseNameLB, updateCourseCodeLB, updateClassCodeLB, updateInstructorLB, updateYearLB, updateSemesterLB, updateUnitsLB);
            updateButton.addActionListener(this);

            // export panel
            edit.setSubPanelBounds(exportPanel);
            edit.setSubPanelDesign(exportPanel);
            edit.setSubPanelButton(exportPanel, exportButton);
            edit.setCurriculumExportPanelTF(exportPanel, exportTF);
            edit.setCurriculumExportPanelLB(exportPanel, eTitle, description, exportLB);
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
            String classCode = addClassCodeTF.getText();
            String instructor = addInstructorTF.getText();
            int year = Integer.parseInt(addYearTF.getText());
            String semester = addSemesterTF.getText();
            double units = Double.parseDouble(addUnitsTF.getText());

            Course course = new Course(courseName, courseCode, classCode, instructor, year, semester, units);

            list.addToList(course);
        } // end of add method

        @Override
        public void remove() {
            String courseCode = removeCourseCodeTF.getText();
            String classCode = removeClassCodeTF.getText();

            Course course = (Course) list.getData(new Course(null, courseCode, classCode, null, 0, null, 0.0));

            list.removeFromList(course);
        } // end of remove method

        @Override
        public void update() {
            int i = courseList.getSelectedIndex();
            Course currentCourse = (Course) list.getData(i);

            String courseName, courseCode, classCode, instructor, semester;
            int year;
            double units;

            if (updateCourseNameTF.getText().isEmpty()) {
                courseName = currentCourse.getCourseName();
            } else {
                courseName = updateCourseNameTF.getText();
            }

            if (updateCourseCodeTF.getText().isEmpty()) {
                courseCode = currentCourse.getCourseCode();
            } else {
                courseCode = updateCourseCodeTF.getText();
            }

            if (updateClassCodeTF.getText().isEmpty()) {
                classCode = currentCourse.getClassCode();
            } else {
                classCode = updateClassCodeTF.getText();
            }

            if (updateInstructorTF.getText().isEmpty()) {
                instructor = currentCourse.getInstructor();
            } else {
                instructor = updateInstructorTF.getText();
            }

            if (updateYearTF.getText().isEmpty()) {
                year = currentCourse.getYear();
            } else {
                year = Integer.parseInt(updateYearTF.getText());
            }

            if (updateSemesterTF.getText().isEmpty()) {
                semester = currentCourse.getSemester();
            } else {
                semester = updateSemesterTF.getText();
            }

            if (updateUnitsTF.getText().isEmpty()) {
                units = currentCourse.getUnits();
            } else {
                units = Double.parseDouble(updateUnitsTF.getText());
            }

            Course newCourse = new Course(courseName, courseCode, classCode, instructor, year, semester, units);

            list.updateDetails(currentCourse, newCourse);
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
                JOptionPane.showMessageDialog(null, "Course Added");
            }
            if (e.getSource() == removeButton) {
                remove();
                JOptionPane.showMessageDialog(null, "Course Removed");
            }
            if (e.getSource() == updateButton) {
                update();
                JOptionPane.showMessageDialog(null, "Course Updated");
            }
            if (e.getSource() == exportButton) {
                try {
                    export();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Unexpected error during exporting the data \n Process aborted");
                }
            }
            setComboBox(courseList);
            clearTextFields();
        } // end of actionPerformed method

        public JPanel getCardPanel() {
            return cardPanel;
        }

        public CardLayout getC1() {
            return c1;
        }
    } // end of SubCurriculumChecklistPanel class
} // end of CurriculumChecklistPanel class
/**
 * @author: Leung, Leonhard
 * Date: 10/04/2023
 */

package gui.panels;

import academics.Schedule;
import gui.tools.GraphicEditor;
import gui.tools.GuiOperations;
import menu.MySchedule;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class MySchedulePanel implements ActionListener {
    private final MySchedule mySchedule;
    private final GraphicEditor edit = new GraphicEditor();
    private SubMySchedulePanel subPanel;
    private JPanel panel;
    private final JButton viewButton = new JButton("View Schedule");
    private final JButton addButton = new JButton("Add Schedule");
    private final JButton removeButton = new JButton("Remove Schedule");
    private final JButton updateButton = new JButton("Update Schedule");
    private final JButton exportButton = new JButton("Export");

    public MySchedulePanel(MySchedule mySchedule) {
        this.mySchedule = mySchedule;
        initializePanels();
        setPanelStructure();
        subPanel.run(panel);
    } // end of constructor

    public void initializePanels() {
        panel = new JPanel();
        subPanel = new SubMySchedulePanel(this.mySchedule);
    } // end of initializePanels method

    public void setPanelStructure() {
        edit.setPanelBounds(panel);
        edit.setPanelDesign(panel);
        edit.setPanelButtons(panel, viewButton, addButton, removeButton, updateButton, exportButton);
        setButtonAction();
    } // end of setPanelStructure method

    public void setButtonAction() {
        viewButton.addActionListener(this);
        addButton.addActionListener(this);
        removeButton.addActionListener(this);
        updateButton.addActionListener(this);
        exportButton.addActionListener(this);
    } // end of setButtonAction method

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewButton) {
            subPanel.getC1().show(subPanel.getCardPanel(), "4.1");
        }
        if (e.getSource() == addButton) {
            subPanel.getC1().show(subPanel.getCardPanel(), "4.2");
        }
        if (e.getSource() == removeButton) {
            subPanel.getC1().show(subPanel.getCardPanel(), "4.3");
        }
        if (e.getSource() == updateButton) {
            subPanel.getC1().show(subPanel.getCardPanel(), "4.4");
        }
        if (e.getSource() == exportButton) {
            subPanel.getC1().show(subPanel.getCardPanel(), "4.5");
        }
    } // end of actionPerformed method

    public JPanel getPanel() {
        return panel;
    } // end of getPanel method

    private static class SubMySchedulePanel implements GuiOperations, ActionListener {
        private final MySchedule list;
        private final GraphicEditor edit = new GraphicEditor();
        private final CardLayout c1 = new CardLayout();
        private JPanel cardPanel, viewPanel, addPanel, removePanel, updatePanel, exportPanel;
        private final JButton viewButton = new JButton("VIEW UPDATED TABLE");
        private final JButton addButton = new JButton("ADD");
        private final JButton removeButton = new JButton("REMOVE");
        private final JButton updateButton = new JButton("UPDATE");

        private final JButton exportButton = new JButton("EXPORT");
        private JTextField  addCourseNameTF, addCourseCodeTF, addStartTimeTF, addEndTimeTF, addDaysTF, addRoomNumberTF;
        private JTextField removeCourseNameTF, removeCourseCodeTF, exportTF;
        private JTextField updateStartTimeTF, updateEndTimeTF, updateDaysTF, updateRoomNumberTF;
        private JLabel aTitle, rTitle, uTitle, eTitle, description;
        private JLabel addCourseNameLB, addCourseCodeLB, addStartTimeLB, addEndTimeLB, addDaysLB, addRoomNumberLB;
        private JLabel removeCourseNameLB, removeCourseCodeLB, exportLB, updateJComboBoxLB;
        private JLabel updateStartTimeLB, updateEndTimeLB, updateDaysLB, updateRoomNumberLB;
        private JComboBox<Object> scheduleList;

        public SubMySchedulePanel(MySchedule mySchedule) {
            list = mySchedule;
            initializeComponents();
            setLabels();
            setPanelStructure();
        } // end of constructor

        public void run(JPanel panel) {
            edit.setSubPanelBounds(panel);
            edit.setSubCardPanel(cardPanel, c1);
            edit.populateCardPanel(panel, cardPanel, viewPanel, addPanel, removePanel, updatePanel, exportPanel, 4);
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
            addStartTimeTF = new JTextField();
            addEndTimeTF = new JTextField();
            addDaysTF = new JTextField();
            addRoomNumberTF = new JTextField();

            removeCourseNameTF = new JTextField();
            removeCourseCodeTF = new JTextField();

            updateStartTimeTF = new JTextField();
            updateEndTimeTF = new JTextField();
            updateDaysTF = new JTextField();
            updateRoomNumberTF = new JTextField();

            exportTF = new JTextField();

            aTitle = new JLabel();
            rTitle = new JLabel();
            uTitle = new JLabel();
            eTitle = new JLabel();

            addCourseNameLB = new JLabel();
            addCourseCodeLB = new JLabel();
            addStartTimeLB = new JLabel();
            addEndTimeLB = new JLabel();
            addDaysLB = new JLabel();
            addRoomNumberLB = new JLabel();

            removeCourseNameLB = new JLabel();
            removeCourseCodeLB = new JLabel();

            updateStartTimeLB = new JLabel();
            updateEndTimeLB = new JLabel();
            updateDaysLB = new JLabel();
            updateRoomNumberLB = new JLabel();

            updateJComboBoxLB = new JLabel();
            description = new JLabel();
            exportLB = new JLabel();
            scheduleList = new JComboBox<>();
        } // end of initializeComponents method

        public void setLabels() {
            aTitle.setText("ADD A SCHEDULE");
            rTitle.setText("REMOVE A SCHEDULE");
            uTitle.setText("UPDATE A SCHEDULE");
            eTitle.setText("EXPORT SCHEDULE");

            addCourseNameLB.setText("COURSE NAME");
            addCourseCodeLB.setText("COURSE CODE");
            addStartTimeLB.setText("START TIME");
            addEndTimeLB.setText("END TIME");
            addDaysLB.setText("DAYS");
            addRoomNumberLB.setText("ROOM NUMBER");

            removeCourseNameLB.setText("COURSE NAME");
            removeCourseCodeLB.setText("COURSE CODE");

            updateJComboBoxLB.setText("SELECT COURSE");
            updateStartTimeLB.setText("START TIME");
            updateEndTimeLB.setText("END TIME");
            updateDaysLB.setText("DAYS");
            updateRoomNumberLB.setText("ROOM NUMBER");

            description.setText("This exports your current schedule");
            exportLB.setText("FILENAME");
        } // end of setLabels method

        public void clearTextFields() {
            addCourseNameTF.setText(null);
            addCourseCodeTF.setText(null);
            addStartTimeTF.setText(null);
            addEndTimeTF.setText(null);
            addDaysTF.setText(null);
            addRoomNumberTF.setText(null);

            removeCourseNameTF.setText(null);
            removeCourseCodeTF.setText(null);

            updateStartTimeTF.setText(null);
            updateEndTimeTF.setText(null);
            updateDaysTF.setText(null);
            updateRoomNumberTF.setText(null);

            exportTF.setText(null);
        } // end of clearTextFields method

        public void setTable(JPanel panel, MySchedule list) {
            String[] column = { "Course Name", "Course Code", "Time", "Days", "Room Number"};

            Object[][] data = new Object[list.size()][column.length];
            for (int i = 0; i < list.size(); i++) {
                Schedule schedule = (Schedule) list.getData(i);
                data[i][0] = schedule.getCourseName();
                data[i][1] = schedule.getCourseCode();
                data[i][2] = schedule.getStartTime() + " - " + schedule.getEndTime();
                data[i][3] = schedule.getDays();
                data[i][4] = schedule.getRoomNumber();
            }

            DefaultTableModel model = new DefaultTableModel(data, column) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);

            edit.setMyScheduleViewPanelTableFormat(table, scrollPane);

            panel.add(scrollPane);
        } // end of setTable method

        public void setComboBox(JComboBox<Object> scheduleList) {
            ArrayList<String> array = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Schedule schedule = (Schedule) list.getData(i);
                array.add(schedule.getCourseName());
            }
            scheduleList.setModel(new DefaultComboBoxModel<>(array.toArray(new String[0])));
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
            edit.setMyScheduleAddPanelTF(addPanel, addCourseNameTF,addCourseCodeTF,addStartTimeTF, addEndTimeTF, addDaysTF, addRoomNumberTF);
            edit.setMyScheduleAddPanelLB(addPanel, aTitle, addCourseNameLB,addCourseCodeLB,addStartTimeLB, addEndTimeLB, addDaysLB, addRoomNumberLB);
            addButton.addActionListener(this);

            // remove panel
            edit.setSubPanelBounds(removePanel);
            edit.setSubPanelDesign(removePanel);
            edit.setSubPanelButton(removePanel, removeButton);
            edit.setMyScheduleRemovePanelTF(removePanel, removeCourseNameTF, removeCourseCodeTF);
            edit.setMyScheduleRemovePanelLB(removePanel, rTitle, removeCourseNameLB,removeCourseCodeLB);
            removeButton.addActionListener(this);

            // update panel
            edit.setSubPanelBounds(updatePanel);
            edit.setSubPanelDesign(updatePanel);
            edit.setSubPanelButton(updatePanel, updateButton);
            edit.setMyScheduleComboBoxFormat(updatePanel, scheduleList, updateJComboBoxLB);
            edit.setMyScheduleUpdatePanelTF(updatePanel, updateStartTimeTF, updateEndTimeTF, updateDaysTF, updateRoomNumberTF);
            edit.setMyScheduleUpdatePanelLB(updatePanel, uTitle, updateStartTimeLB, updateEndTimeLB, updateDaysLB, updateRoomNumberLB);
            updateButton.addActionListener(this);

            // export panel
            edit.setSubPanelBounds(exportPanel);
            edit.setSubPanelDesign(exportPanel);
            edit.setSubPanelButton(exportPanel, exportButton);
            edit.setMyScheduleExportPanelTF(exportPanel, exportTF);
            edit.setMyScheduleExportPanelLB(exportPanel, eTitle, description, exportLB);
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
            String startTime = addStartTimeTF.getText();
            String endTime = addEndTimeTF.getText();
            String days = addDaysTF.getText();
            String roomNumber = addRoomNumberTF.getText();

            Schedule schedule = new Schedule(courseName, courseCode, startTime, endTime, days, roomNumber);

            list.addToList(schedule);
        } // end of add method

        @Override
        public void remove() {
            String courseName = removeCourseNameTF.getText();
            String courseCode = removeCourseCodeTF.getText();

            Schedule schedule = (Schedule) list.getData(new Schedule(courseName, courseCode, null, null, null, null));

            list.removeFromList(schedule);
        } // end of remove method

        @Override
        public void update() {
            int i = scheduleList.getSelectedIndex();
            Schedule currentSchedule = (Schedule) list.getData(i);

            String courseName = currentSchedule.getCourseName();
            String courseCode = currentSchedule.getCourseCode();

            String startTime, endTime, days, roomNumber;

            if (updateStartTimeTF.getText().isEmpty()) {
                startTime = currentSchedule.getStartTime();
            } else {
                startTime = updateStartTimeTF.getText();
            }

            if (updateEndTimeTF.getText().isEmpty()) {
                endTime = currentSchedule.getEndTime();
            } else {
                endTime = updateEndTimeTF.getText();
            }

            if (updateDaysTF.getText().isEmpty()) {
                days = currentSchedule.getDays();
            } else {
                days = updateDaysTF.getText();
            }

            if (updateRoomNumberTF.getText().isEmpty()) {
                roomNumber = currentSchedule.getRoomNumber();
            } else {
                roomNumber = updateRoomNumberTF.getText();
            }

            Schedule newSchedule = new Schedule(courseName, courseCode, startTime, endTime, days, roomNumber);

            list.updateDetails(currentSchedule, newSchedule);
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
                JOptionPane.showMessageDialog(null, "Schedule Added");
            }
            if (e.getSource() == removeButton) {
                remove();
                JOptionPane.showMessageDialog(null, "Schedule Removed");
            }
            if (e.getSource() == updateButton) {
                update();
                JOptionPane.showMessageDialog(null, "Schedule Updated");
            }
            if (e.getSource() == exportButton) {
                try {
                    export();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Unexpected error during exporting the data \n Process aborted");
                }
            }
            setComboBox(scheduleList);
            clearTextFields();
        } // end of actionPerformed method

        public JPanel getCardPanel() {
            return cardPanel;
        }

        public CardLayout getC1() {
            return c1;
        }
    } // end of SubMySchedulePanel class
} // end of MySchedulePanelNewVersion class

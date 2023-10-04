/**
 * @author: Leung, Leonhard
 * Date: 10/04/2023
 */

package gui.panels;

import gui.tools.GraphicEditor;
import gui.tools.GuiOperations;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonalDetailsPanel implements ActionListener {
    GraphicEditor edit = new GraphicEditor();

    SubPersonalDetailsPanel subPanel;
    private JPanel panel;
    private final JButton viewButton = new JButton("View Details");
    private final JButton updateButton = new JButton("Update Info");

    public PersonalDetailsPanel() {
        initializePanels();
        setPanelStructure();
        subPanel.run(panel);
    } // end of constructor

    public void initializePanels() {
        panel = new JPanel();
        subPanel = new SubPersonalDetailsPanel();
    } // end of initializePanels method

    public void setPanelStructure() {
        edit.setPanelBounds(panel);
        edit.setPanelDesign(panel);
        edit.setPanelButtons(panel, viewButton, updateButton);
        setButtonActions();
    } // end of setPanelStructure method

    public void setButtonActions() {
        viewButton.addActionListener(this);
        updateButton.addActionListener(this);
    } // end of setButtonActions method

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewButton) {
            subPanel.getC1().show(subPanel.getCardPanel(), "4.1");
        }
        if (e.getSource() == updateButton) {
            subPanel.getC1().show(subPanel.getCardPanel(), "4.2");
        }
    } // end of actionPerformed method

    public JPanel getPanel() {
        return panel;
    } // end of getPanel method

    private static class SubPersonalDetailsPanel implements GuiOperations, ActionListener {
        GraphicEditor edit = new GraphicEditor();
        private final CardLayout c1 = new CardLayout();
        private final JButton updateButton = new JButton("UPDATE");
        private JPanel cardPanel, viewPanel, updatePanel;
        private JTextField firstNameField,lastNameField,birthdayField,IDNumberField,genderField,contactField;
        private JTextField firstNameTF,lastNameTF, birthdayTF, IDNumberTF, genderTF,contactTF;
        private JLabel viewFNameLB,viewLNameLB,viewBDayLB,viewIDNumberLB,viewGenderLB,viewContactLB,vTitle,uTitle;
        private JLabel firstNameLB, lastNameLB, birthdayLB, IDNumberLB, genderLB, contactLB;
        private JLabel personalIcon ;


        public SubPersonalDetailsPanel() {
            initializeComponents();
            setLabels();
            setPanelStructure();
        }

        public void run(JPanel panel) {
            edit.setSubPanelBounds(panel);
            edit.setSubCardPanel(cardPanel, c1);
            edit.populateCardPanel(panel, cardPanel, viewPanel, updatePanel,  4);
        } // end of run method

        public void initializeComponents() {
            cardPanel = new JPanel();
            viewPanel = new JPanel();
            updatePanel = new JPanel();

            firstNameField = new JTextField();
            lastNameField = new JTextField();
            genderField = new JTextField();
            birthdayField = new JTextField();
            IDNumberField = new JTextField();
            contactField = new JTextField();

            firstNameTF = new JTextField();
            lastNameTF = new JTextField();
            genderTF = new JTextField();
            birthdayTF = new JTextField();
            IDNumberTF = new JTextField();
            contactTF = new JTextField();

            personalIcon = new JLabel();
            vTitle = new JLabel();
            viewFNameLB = new JLabel();
            viewLNameLB = new JLabel();
            viewBDayLB = new JLabel();
            viewGenderLB = new JLabel();
            viewIDNumberLB = new JLabel();
            viewContactLB = new JLabel();

            uTitle = new JLabel();
            firstNameLB = new JLabel();
            lastNameLB = new JLabel();
            genderLB = new JLabel();
            birthdayLB = new JLabel();
            IDNumberLB = new JLabel();
            contactLB = new JLabel();
        } // end of initializeComponents method

        public void setLabels(){
            vTitle.setText("PERSONAL INFORMATION");
            viewFNameLB.setText("FIRST NAME");
            viewLNameLB.setText("LAST NAME");
            viewBDayLB.setText("BIRTHDAY");
            viewContactLB.setText("CONTACT NUMBER");
            viewGenderLB.setText("GENDER");
            viewIDNumberLB.setText("ID NUMBER");
            personalIcon.setIcon(new ImageIcon("res/personal_Icon.png"));
            uTitle.setText("UPDATE PERSONAL DETAILS");
            firstNameLB.setText("FIRST NAME");
            lastNameLB.setText("LAST NAME");
            IDNumberLB.setText("ID NUMBER");
            genderLB.setText("GENDER");
            contactLB.setText("CONTACT NUMBER");
            birthdayLB.setText("BIRTHDAY");
        }

        public void clearTextFields() {
            firstNameTF.setText(null);
            lastNameTF.setText(null);
            birthdayTF.setText(null);
            IDNumberTF.setText(null);
            genderTF.setText(null);
            contactTF.setText(null);
        } // end of clearTextFields method

        public void setPanelStructure() {
            // view panel
            edit.setSubPanelBounds(viewPanel);
            edit.setSubPanelDesign(viewPanel);
            edit.setPersonalDetailsViewPanelTF(viewPanel, firstNameField, lastNameField, birthdayField, IDNumberField, genderField, contactField);
            edit.setPersonalDetailsViewPanelLB(viewPanel, vTitle, viewFNameLB, viewLNameLB, viewBDayLB, viewIDNumberLB, viewGenderLB, viewContactLB, personalIcon);

            // update panel
            edit.setSubPanelBounds(updatePanel);
            edit.setSubPanelDesign(updatePanel);
            edit.setSubPanelButton(updatePanel, updateButton);
            edit.setPersonalDetailsUpdatePanelTF(updatePanel, firstNameTF,lastNameTF,birthdayTF,IDNumberTF,genderTF,contactTF);
            edit.setPersonalDetailsUpdatePanelLB(updatePanel,uTitle,firstNameLB,lastNameLB,birthdayLB,IDNumberLB,genderLB,contactLB);
            updateButton.addActionListener(this);
        } // end of setPanelStructure method

        @Override
        public void view() {}

        @Override
        public void add() {}

        @Override
        public void remove() {}

        @Override
        public void update() {
            firstNameField.setText(firstNameTF.getText());
            lastNameField.setText(lastNameTF.getText());
            birthdayField.setText(birthdayTF.getText());
            IDNumberField.setText(IDNumberTF.getText());
            genderField.setText(genderTF.getText());
            contactField.setText(contactTF.getText());
        } // end of update method

        @Override
        public void export() {}

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == updateButton) {
                update();
                clearTextFields();
            }
        } // end of actionPerformed method

        public JPanel getCardPanel() {
            return cardPanel;
        }

        public CardLayout getC1() {
            return c1;
        }
    } // end of SubPersonalDetailsPanel class
} // end of PersonalDetailsPanel class

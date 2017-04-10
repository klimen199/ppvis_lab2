package Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.AddStudentDialog;


public class AddStudentListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog add = new AddStudentDialog().getDialog();
        add.setSize(555,500);
        add.setVisible(true);
        add.setLocationRelativeTo(null);
    }
}

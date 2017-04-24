package Controller;


import View.DeleteStudentDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DeleteStudentListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog del = new DeleteStudentDialog().getDialog();
        del.setSize(700,250);
        del.setVisible(true);
        del.setLocationRelativeTo(null);
    }
}

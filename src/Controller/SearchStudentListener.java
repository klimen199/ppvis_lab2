package Controller;

import View.SearchStudentDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 11.04.2017.
 */
public class SearchStudentListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog search = new SearchStudentDialog().getDialog();
        search.setSize(770,500);
        search.setVisible(true);
        search.setLocationRelativeTo(null);
    }
}

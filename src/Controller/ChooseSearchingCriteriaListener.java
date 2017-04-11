package Controller;

import View.SearchStudentDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChooseSearchingCriteriaListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        int choice = chooseCriteria.getSelectedIndex();
        switch (choice){
            case 0:{
                mainBox.remove(2);
                mainBox.add(Box.createVerticalStrut(1));
                mainBox.revalidate();
                break;
            }
            case 1:{
                mainBox.remove(2);
                mainBox.add(studentFIOBox(),2);
                mainBox.revalidate();
                break;
            }
            case 2:{
                mainBox.remove(2);
                mainBox.add(parentFIOBox(),2);
                mainBox.revalidate();
                break;
            }
            case 3:{
                mainBox.remove(2);
                mainBox.add(brotherSisterBox(), 2);
                mainBox.revalidate();
                break;
            }
            case 4:{
                mainBox.remove(2);
                mainBox.add(parentSalaryBox(), 2);
                mainBox.revalidate();
                break;
            }
            default:break;
        }
    }
}

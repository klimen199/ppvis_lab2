package View;

import Controller.*;
import Model.DataBase;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DeleteStudentDialog extends BaseForStudentDialog {
    private DataBase dataBase;
    JDialog dialog;


    JTextField dadFirstName;
    JTextField dadSecondName;
    JTextField dadSurName;
    JTextField mumFirstName;
    JTextField mumSecondName;
    JTextField mumSurName;
    JTextField dadSalaryMin;
    JTextField dadSalaryMax;
    JTextField mumSalaryMin;
    JTextField mumSalaryMax;
    JTextField numOfBrothersMin;
    JTextField numOfBrothersMax;
    JTextField numOfSistersMin;
    JTextField numOfSistersMax;
    private String key = "delete";
    public Box mainBox;


    public DeleteStudentDialog(DataBase dataBase){
        this.dataBase = dataBase;
        dialog = new JDialog();
        mainBox = Box.createVerticalBox();
        mainBox.add(delHeadBox());
        mainBox.add(Box.createVerticalStrut(7));
        mainBox.add(Box.createVerticalStrut(150));
        mainBox.add(Box.createVerticalStrut(70));

        dialog.add(mainBox);
    }

    private Box delHeadBox(){
        JLabel searchLabel = new JLabel("Выберите критерий удаления:");
        String[] delCritarion = {"","ФИО студента", "ФИО родителя", "Число братьев/сестер", "З/п родителя"};
        JComboBox<String> chooseCriteria = new JComboBox<>(delCritarion);
        chooseCriteria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChooseCriteria temp = new ChooseCriteria();
                mainBox = temp.addCriteria(mainBox,chooseCriteria,
                        studentFIOBox(key,dataBase, null),
                        parentFIOBox(key,dataBase, null),
                        brotherSisterBox(key,dataBase, null),
                        parentSalaryBox(key,dataBase, null));
            }
        });


        Box criteriaBox = Box.createHorizontalBox();
        criteriaBox.add(Box.createHorizontalStrut(100));
        criteriaBox.add(searchLabel);
        criteriaBox.add(Box.createHorizontalStrut(50));
        criteriaBox.add(chooseCriteria);
        criteriaBox.add(Box.createHorizontalStrut(150));

        return criteriaBox;
    }

    public JDialog getDialog(){
        return dialog;
    }
}

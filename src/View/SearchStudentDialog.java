package View;

import Controller.*;
import Model.DataBase;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SearchStudentDialog extends BaseForStudentDialog{
    private DataBase dataBase;
    JDialog dialog;
    TablePanel tablePanel;

    JTextField dadSalaryMin;
    JTextField dadSalaryMax;
    JTextField mumSalaryMin;
    JTextField mumSalaryMax;
    JTextField numOfBrothersMin;
    JTextField numOfBrothersMax;
    JTextField numOfSistersMin;
    JTextField numOfSistersMax;
    private String key = "search";
    public Box mainBox;

    public SearchStudentDialog(DataBase dataBase){
        this.dataBase = dataBase;

        tablePanel = new TablePanel(dataBase.studentList, dataBase.fatherList, dataBase.motherList);

        dialog = new JDialog();
        mainBox = Box.createVerticalBox();
        mainBox.add(searchHeadBox());
        mainBox.add(Box.createVerticalStrut(7));
        mainBox.add(Box.createVerticalStrut(1));
        mainBox.add(Box.createVerticalStrut(20));
        mainBox.add(searchTableBox());

        dialog.add(mainBox);
    }

    private Box searchHeadBox(){
        JLabel searchLabel = new JLabel("Выберите критерий поиска:");
        String[] searchCritarion = {"","ФИО студента", "ФИО родителя", "Число братьев/сестер", "З/п родителя"};
        JComboBox<String> chooseCriteria = new JComboBox<>(searchCritarion);
        chooseCriteria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChooseCriteria temp = new ChooseCriteria();
                mainBox = temp.addCriteria(mainBox,chooseCriteria,
                        studentFIOBox(key,dataBase,tablePanel),
                        parentFIOBox(key, dataBase,tablePanel),
                        brotherSisterBox(key, dataBase,tablePanel),
                        parentSalaryBox(key, dataBase,tablePanel));
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

    private Box searchTableBox(){
        Box tableBox = Box.createHorizontalBox();
        tableBox.add(Box.createHorizontalStrut(20));
        tableBox.add(tablePanel);
        tableBox.add(Box.createHorizontalStrut(20));
        return tableBox;
    }

    public JDialog getDialog(){
        return dialog;
    }
}

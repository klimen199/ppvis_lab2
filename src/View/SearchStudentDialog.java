package View;

import Controller.ChooseSearchingCriteriaListener;
import Model.Parent;
import Model.Student;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;


public class SearchStudentDialog {

    JDialog dialog;
    TablePanel tablePanel;

    JTextField studentFirstName;
    JTextField studentSecondName;
    JTextField studentSurName;
    JTextField dadFirstName;
    JTextField dadSecondName;
    JTextField dadSurName;
    JTextField mumFirstName;
    JTextField mumSecondName;
    JTextField mumSurName;
    JTextField dadSalary;
    JTextField mumSalary;
    JTextField numOfBrothers;
    JTextField numOfSisters;
    public Box mainBox;

    public SearchStudentDialog(){
        List<Student> studentsSearchList = new ArrayList<>(35);
        studentsSearchList = Student.studentsList;
        List<Parent> fathersSearchList = new ArrayList<>(35);
        fathersSearchList = Parent.fathersList;
        List<Parent> mothersSearchList = new ArrayList<>(35);
        mothersSearchList = Parent.mothersList;

        tablePanel = new TablePanel(studentsSearchList, fathersSearchList,mothersSearchList);
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
        chooseCriteria.addActionListener(new ChooseSearchingCriteriaListener());


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
    private Box studentFIOBox(){
        studentSurName = new JTextField(10);
        studentSurName.setBorder(new TitledBorder("Фамилия"));
        studentFirstName = new JTextField(10);
        studentFirstName.setBorder(new TitledBorder("Имя"));
        studentSecondName = new JTextField(10);
        studentSecondName.setBorder(new TitledBorder("Отчество"));

        Box studentFIObox = Box.createVerticalBox();
        Box txtLine1 = Box.createHorizontalBox();
        txtLine1.add(studentSurName);
        txtLine1.add((Box.createHorizontalStrut(10)));
        txtLine1.add(studentFirstName);
        txtLine1.add((Box.createHorizontalStrut(10)));
        txtLine1.add(studentSecondName);

        studentFIObox.add(txtLine1);
        studentFIObox.setBorder(new TitledBorder("ФИО студента"));

        return studentFIObox;
    }
    private Box parentFIOBox(){
        dadSurName = new JTextField(10);
        dadSurName.setBorder(new TitledBorder("Фамилия"));
        dadFirstName = new JTextField(10);
        dadFirstName.setBorder(new TitledBorder("Имя"));
        dadSecondName = new JTextField(10);
        dadSecondName.setBorder(new TitledBorder("Отчество"));

        mumSurName = new JTextField(10);
        mumSurName.setBorder(new TitledBorder("Фамилия"));
        mumFirstName = new JTextField(10);
        mumFirstName.setBorder(new TitledBorder("Имя"));
        mumSecondName = new JTextField(10);
        mumSecondName.setBorder(new TitledBorder("Отчество"));

        Box parentFIOBox = Box.createVerticalBox();

        Box txtLine1 = Box.createHorizontalBox();
        txtLine1.add(dadSurName);
        txtLine1.add((Box.createHorizontalStrut(10)));
        txtLine1.add(dadFirstName);
        txtLine1.add((Box.createHorizontalStrut(10)));
        txtLine1.add(dadSecondName);
        txtLine1.setBorder(new TitledBorder("ФИО отца"));

        Box txtLine2 = Box.createHorizontalBox();
        txtLine2.add(mumSurName);
        txtLine2.add((Box.createHorizontalStrut(10)));
        txtLine2.add(mumFirstName);
        txtLine2.add((Box.createHorizontalStrut(10)));
        txtLine2.add(mumSecondName);
        txtLine2.setBorder(new TitledBorder("ФИО матери"));

        parentFIOBox.add(txtLine1);
        parentFIOBox.add(txtLine2);

        return parentFIOBox;
    }
    private Box brotherSisterBox(){
        numOfBrothers = new JTextField(5);
        numOfBrothers.setBorder(new TitledBorder("Кол-во братьев"));
        numOfSisters = new JTextField(5);
        numOfSisters.setBorder(new TitledBorder("Кол-во сестер"));
        Box brotherSisterBox = Box.createHorizontalBox();
        brotherSisterBox.add(Box.createHorizontalStrut(110));
        brotherSisterBox.add(numOfBrothers);
        brotherSisterBox.add(Box.createHorizontalStrut(30));
        brotherSisterBox.add(numOfSisters);
        brotherSisterBox.add(Box.createHorizontalStrut(110));
        return brotherSisterBox;
    }
    private Box parentSalaryBox(){
        dadSalary = new JTextField(8);
        dadSalary.setBorder(new TitledBorder("З/п отца (BYN)"));
        mumSalary = new JTextField(8);
        mumSalary.setBorder(new TitledBorder("З/п матери (BYN)"));
        Box parentSalaryBox = Box.createHorizontalBox();
        parentSalaryBox.add(Box.createHorizontalStrut(110));
        parentSalaryBox.add(dadSalary);
        parentSalaryBox.add(Box.createHorizontalStrut(30));
        parentSalaryBox.add(mumSalary);
        parentSalaryBox.add(Box.createHorizontalStrut(110));
        return parentSalaryBox;
    }


    public JDialog getDialog(){
        return dialog;
    }
}

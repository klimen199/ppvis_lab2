package View;

import Controller.*;
import Model.DataBase;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


abstract class BaseForStudentDialog {

    Box studentFIOBox(String key, DataBase dataBase, TablePanel tablePanel){
        JTextField studentSurName = new JTextField(10);
        studentSurName.setBorder(new TitledBorder("Фамилия"));
        JTextField studentFirstName = new JTextField(10);
        studentFirstName.setBorder(new TitledBorder("Имя"));
        JTextField studentSecondName = new JTextField(10);
        studentSecondName.setBorder(new TitledBorder("Отчество"));
        JButton okBtn = new JButton("OK");
        if (key.equals("delete")){
            okBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DeleteStudentFIO temp = new DeleteStudentFIO(dataBase,
                            studentSurName.getText(),studentFirstName.getText(),studentSecondName.getText());
                }
            });
        }
        if (key.equals("search")){
            okBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SearchStudentFIO temp = new SearchStudentFIO(dataBase,
                            studentSurName.getText(),studentFirstName.getText(),studentSecondName.getText());
                    tablePanel.setStudents(temp.getSearchStudList(),temp.getSearchDadList(),temp.getSearchMumList());
                    tablePanel.updateTable();
                }
            });
        }

        Box unityBox = Box.createVerticalBox();
        Box studentFIObox = Box.createVerticalBox();
        Box txtLine1 = Box.createHorizontalBox();
        txtLine1.add(studentSurName);
        txtLine1.add((Box.createHorizontalStrut(10)));
        txtLine1.add(studentFirstName);
        txtLine1.add((Box.createHorizontalStrut(10)));
        txtLine1.add(studentSecondName);
        studentFIObox.add(txtLine1);
        studentFIObox.setBorder(new TitledBorder("ФИО студента"));

        unityBox.add(studentFIObox);
        unityBox.add(okBtn);

        return unityBox;
    }
    Box parentFIOBox(String key, DataBase dataBase, TablePanel tablePanel){
        JTextField dadSurName = new JTextField(10);
        dadSurName.setBorder(new TitledBorder("Фамилия"));
        JTextField dadFirstName = new JTextField(10);
        dadFirstName.setBorder(new TitledBorder("Имя"));
        JTextField dadSecondName = new JTextField(10);
        dadSecondName.setBorder(new TitledBorder("Отчество"));

        JTextField mumSurName = new JTextField(10);
        mumSurName.setBorder(new TitledBorder("Фамилия"));
        JTextField mumFirstName = new JTextField(10);
        mumFirstName.setBorder(new TitledBorder("Имя"));
        JTextField mumSecondName = new JTextField(10);
        mumSecondName.setBorder(new TitledBorder("Отчество"));

        JButton okBtn = new JButton("OK");
        if (key.equals("delete")){
            okBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DeleteParentFIO temp = new DeleteParentFIO(dataBase,
                            dadSurName.getText(),dadFirstName.getText(),dadSecondName.getText(),
                            mumSurName.getText(),mumFirstName.getText(),mumSecondName.getText());
                }
            });
        }
        if (key.equals("search")) {
            okBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SearchParentFIO temp = new SearchParentFIO(dataBase,
                            dadSurName.getText(), dadFirstName.getText(), dadSecondName.getText(),
                            mumSurName.getText(), mumFirstName.getText(), mumSecondName.getText());
                    tablePanel.setStudents(temp.getSearchStudList(), temp.getSearchDadList(), temp.getSearchMumList());
                    tablePanel.updateTable();
                }
            });
        }
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
        parentFIOBox.add(okBtn);

        return parentFIOBox;
    }
    Box brotherSisterBox(String key, DataBase dataBase, TablePanel tablePanel){
        Box brothNum = Box.createHorizontalBox();
        JTextField numOfBrothersMin = new JTextField(5);
        JTextField numOfBrothersMax = new JTextField(5);
        brothNum.add(new JLabel("От: "));
        brothNum.add(numOfBrothersMin);
        brothNum.add(Box.createHorizontalStrut(8));
        brothNum.add(new JLabel("до: "));
        brothNum.add(numOfBrothersMax);
        brothNum.setBorder(new TitledBorder("Кол-во братьев"));

        Box sistNum = Box.createHorizontalBox();
        JTextField numOfSistersMin = new JTextField(5);
        JTextField numOfSistersMax = new JTextField(5);
        sistNum.add(new JLabel("От: "));
        sistNum.add(numOfSistersMin);
        sistNum.add(Box.createHorizontalStrut(8));
        sistNum.add(new JLabel("до: "));
        sistNum.add(numOfSistersMax);
        sistNum.setBorder(new TitledBorder("Кол-во сестер"));


        JButton okBtn = new JButton("OK");
        if (key.equals("search")){
            okBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SearchBrotherSister temp = new SearchBrotherSister(dataBase,
                            numOfBrothersMin.getText(), numOfBrothersMax.getText(),
                            numOfSistersMin.getText(),numOfSistersMax.getText());
                    tablePanel.setStudents(temp.getSearchStudList(),temp.getSearchDadList(),temp.getSearchMumList());
                    tablePanel.updateTable();
                }
            });
        }
        if (key.equals("delete")) {
            okBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DeleteBrotherSister temp = new DeleteBrotherSister(dataBase,
                            numOfBrothersMin.getText(), numOfBrothersMax.getText(),
                            numOfSistersMin.getText(), numOfSistersMax.getText());
                }
            });
        }
        Box unityBox = Box.createVerticalBox();
        Box brotherSisterBox = Box.createHorizontalBox();
        brotherSisterBox.add(Box.createHorizontalStrut(50));
        brotherSisterBox.add(brothNum);
        brotherSisterBox.add(Box.createHorizontalStrut(30));
        brotherSisterBox.add(sistNum);
        brotherSisterBox.add(Box.createHorizontalStrut(50));

        unityBox.add(brotherSisterBox);
        unityBox.add(okBtn);

        return unityBox;
    }
    Box parentSalaryBox(String key, DataBase dataBase, TablePanel tablePanel){
        Box dadSalary = Box.createHorizontalBox();
        JTextField dadSalaryMin = new JTextField(8);
        JTextField dadSalaryMax = new JTextField(8);
        dadSalary.add(new JLabel("От: "));
        dadSalary.add(dadSalaryMin);
        dadSalary.add(Box.createHorizontalStrut(8));
        dadSalary.add(new JLabel("до: "));
        dadSalary.add(dadSalaryMax);
        dadSalary.setBorder(new TitledBorder("З/п отца (BYN)"));

        Box mumSalary = Box.createHorizontalBox();
        JTextField mumSalaryMin = new JTextField(8);
        JTextField mumSalaryMax = new JTextField(8);
        mumSalary.add(new JLabel("От: "));
        mumSalary.add(mumSalaryMin);
        mumSalary.add(Box.createHorizontalStrut(8));
        mumSalary.add(new JLabel("до: "));
        mumSalary.add(mumSalaryMax);
        mumSalary.setBorder(new TitledBorder("З/п матери (BYN)"));

        JButton okBtn = new JButton("OK");
        if (key.equals("search")) {
            okBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SearchParentSalary temp = new SearchParentSalary(dataBase,
                            dadSalaryMin.getText(), dadSalaryMax.getText(),
                            mumSalaryMin.getText(), mumSalaryMax.getText());
                    tablePanel.setStudents(temp.getSearchStudList(), temp.getSearchDadList(), temp.getSearchMumList());
                    tablePanel.updateTable();
                }
            });
        }
        if (key.equals("delete")){
            okBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DeleteParentSalary temp = new DeleteParentSalary(dataBase,
                            dadSalaryMin.getText(), dadSalaryMax.getText(),
                            mumSalaryMin.getText(),mumSalaryMax.getText());
                }
            });
        }
        Box unityBox = Box.createVerticalBox();
        Box parentSalaryBox = Box.createHorizontalBox();
        parentSalaryBox.add(Box.createHorizontalStrut(50));
        parentSalaryBox.add(dadSalary);
        parentSalaryBox.add(Box.createHorizontalStrut(30));
        parentSalaryBox.add(mumSalary);
        parentSalaryBox.add(Box.createHorizontalStrut(50));

        unityBox.add(parentSalaryBox);
        unityBox.add(okBtn);

        return unityBox;
    }
}

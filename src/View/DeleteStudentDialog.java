package View;

import Controller.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DeleteStudentDialog {
    JDialog dialog;

    JTextField studentFirstName;
    JTextField studentSecondName;
    JTextField studentSurName;
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
    public Box mainBox;


    public DeleteStudentDialog(){
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
                        studentFIOBox(), parentFIOBox(), brotherSisterBox(), parentSalaryBox());
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


    private Box studentFIOBox(){
        studentSurName = new JTextField(10);
        studentSurName.setBorder(new TitledBorder("Фамилия"));
        studentFirstName = new JTextField(10);
        studentFirstName.setBorder(new TitledBorder("Имя"));
        studentSecondName = new JTextField(10);
        studentSecondName.setBorder(new TitledBorder("Отчество"));

        JButton okBtn = new JButton("OK");
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteStudentFIO temp = new DeleteStudentFIO(studentSurName.getText(),studentFirstName.getText(),studentSecondName.getText());

            }
        });
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

        JButton okBtn = new JButton("OK");
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteParentFIO temp = new DeleteParentFIO(dadSurName.getText(),dadFirstName.getText(),dadSecondName.getText(),
                        mumSurName.getText(),mumFirstName.getText(),mumSecondName.getText());
            }
        });
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
    private Box brotherSisterBox(){
        Box brothNum = Box.createHorizontalBox();
        numOfBrothersMin = new JTextField(5);
        numOfBrothersMax = new JTextField(5);
        brothNum.add(new JLabel("От: "));
        brothNum.add(numOfBrothersMin);
        brothNum.add(Box.createHorizontalStrut(8));
        brothNum.add(new JLabel("до: "));
        brothNum.add(numOfBrothersMax);
        brothNum.setBorder(new TitledBorder("Кол-во братьев"));

        Box sistNum = Box.createHorizontalBox();
        numOfSistersMin = new JTextField(5);
        numOfSistersMax = new JTextField(5);
        sistNum.add(new JLabel("От: "));
        sistNum.add(numOfSistersMin);
        sistNum.add(Box.createHorizontalStrut(8));
        sistNum.add(new JLabel("до: "));
        sistNum.add(numOfSistersMax);
        sistNum.setBorder(new TitledBorder("Кол-во сестер"));


        JButton okBtn = new JButton("OK");
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteBrotherSister temp = new DeleteBrotherSister(numOfBrothersMin.getText(),
                        numOfBrothersMax.getText(), numOfSistersMin.getText(),numOfSistersMax.getText());
            }
        });
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
    private Box parentSalaryBox(){
        Box dadSalary = Box.createHorizontalBox();
        dadSalaryMin = new JTextField(8);
        dadSalaryMax = new JTextField(8);
        dadSalary.add(new JLabel("От: "));
        dadSalary.add(dadSalaryMin);
        dadSalary.add(Box.createHorizontalStrut(8));
        dadSalary.add(new JLabel("до: "));
        dadSalary.add(dadSalaryMax);
        dadSalary.setBorder(new TitledBorder("З/п отца (BYN)"));

        Box mumSalary = Box.createHorizontalBox();
        mumSalaryMin = new JTextField(8);
        mumSalaryMax = new JTextField(8);
        mumSalary.add(new JLabel("От: "));
        mumSalary.add(mumSalaryMin);
        mumSalary.add(Box.createHorizontalStrut(8));
        mumSalary.add(new JLabel("до: "));
        mumSalary.add(mumSalaryMax);
        mumSalary.setBorder(new TitledBorder("З/п матери (BYN)"));

        JButton okBtn = new JButton("OK");
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteParentSalary temp = new DeleteParentSalary(dadSalaryMin.getText(),
                        dadSalaryMax.getText(), mumSalaryMin.getText(),mumSalaryMax.getText());
            }
        });
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

    public JDialog getDialog(){
        return dialog;
    }
}
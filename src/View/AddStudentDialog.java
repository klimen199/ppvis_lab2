package View;


import Controller.OkBtnInAdding;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentDialog {

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
    JTextField dadSalary;
    JTextField mumSalary;
    JTextField numOfBrothers;
    JTextField numOfSisters;

    public AddStudentDialog(){

        dialog = new JDialog();

        Box studentForm = Box.createVerticalBox();
        Box txtLine1 = Box.createHorizontalBox();

        Font fontMain = new Font("Times New Roman", Font.BOLD, 18);
        JLabel info = new JLabel("Заполните информацию о студенте:");
        info.setFont(fontMain);

        numOfBrothers = new JTextField(5);
        numOfBrothers.setBorder(new TitledBorder("Кол-во братьев"));
        numOfSisters = new JTextField(5);
        numOfSisters.setBorder(new TitledBorder("Кол-во сестер"));

        JButton okBtn = new JButton("OK");
        //okBtn.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OkBtnInAdding temp = new OkBtnInAdding();
                temp.addNewStudentInfo(getStudentSurName(), getStudentFirstName(), getStudentSecondName(),
                        getDadSurName(),getDadFirstName(),getDadSecondName(),getDadSalary(),
                        getMumSurName(),getMumFirstName(),getMumSecondName(),getMumSalary(),
                        getBrotherNum(),getSisterNum());

                ViewEntryPoint.tablePanel.updateTable();
            }
        });

        txtLine1.add(Box.createHorizontalStrut(110));
        txtLine1.add(numOfBrothers);
        txtLine1.add(Box.createHorizontalStrut(30));
        txtLine1.add(numOfSisters);
        txtLine1.add(Box.createHorizontalStrut(110));

        studentForm.add(Box.createVerticalStrut(10));
        studentForm.add(info);
        studentForm.add(Box.createVerticalStrut(10));
        studentForm.add(studentFIOBox());
        studentForm.add(Box.createVerticalStrut(10));
        studentForm.add(txtLine1);
        studentForm.add(Box.createVerticalStrut(10));
        studentForm.add(dadInfoBox());
        studentForm.add(Box.createVerticalStrut(10));
        studentForm.add(mumInfoBox());
        studentForm.add(Box.createVerticalStrut(10));
        studentForm.add(okBtn);
        studentForm.add(Box.createVerticalStrut(10));
        dialog.add(studentForm);
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
    private Box dadInfoBox(){
        dadSurName = new JTextField(10);
        dadSurName.setBorder(new TitledBorder("Фамилия"));
        dadFirstName = new JTextField(10);
        dadFirstName.setBorder(new TitledBorder("Имя"));
        dadSecondName = new JTextField(10);
        dadSecondName.setBorder(new TitledBorder("Отчество"));
        dadSalary = new JTextField(8);
        dadSalary.setBorder(new TitledBorder("З/п отца (BYN)"));

        Box dadFIObox = Box.createVerticalBox();
        Box txtLine1 = Box.createHorizontalBox();
        txtLine1.add(dadSurName);
        txtLine1.add((Box.createHorizontalStrut(10)));
        txtLine1.add(dadFirstName);
        txtLine1.add((Box.createHorizontalStrut(10)));
        txtLine1.add(dadSecondName);
        Box txtLine2 = Box.createHorizontalBox();
        txtLine2.add((Box.createHorizontalStrut(170)));
        txtLine2.add(dadSalary);
        txtLine2.add((Box.createHorizontalStrut(170)));


        dadFIObox.add(txtLine1);
        dadFIObox.add(Box.createVerticalStrut(10));
        dadFIObox.add(txtLine2);
        dadFIObox.setBorder(new TitledBorder("Инофрмация об отце"));

        return dadFIObox;
    }
    private Box mumInfoBox(){

        mumSurName = new JTextField(10);
        mumSurName.setBorder(new TitledBorder("Фамилия"));
        mumFirstName = new JTextField(10);
        mumFirstName.setBorder(new TitledBorder("Имя"));
        mumSecondName = new JTextField(10);
        mumSecondName.setBorder(new TitledBorder("Отчество"));
        mumSalary = new JTextField(8);
        mumSalary.setBorder(new TitledBorder("З/п матери (BYN)"));

        Box mumFIObox = Box.createVerticalBox();
        Box txtLine1 = Box.createHorizontalBox();
        txtLine1.add(mumSurName);
        txtLine1.add((Box.createHorizontalStrut(10)));
        txtLine1.add(mumFirstName);
        txtLine1.add((Box.createHorizontalStrut(10)));
        txtLine1.add(mumSecondName);
        Box txtLine2 = Box.createHorizontalBox();
        txtLine2.add((Box.createHorizontalStrut(170)));
        txtLine2.add(mumSalary);
        txtLine2.add((Box.createHorizontalStrut(170)));


        mumFIObox.add(txtLine1);
        mumFIObox.add(Box.createVerticalStrut(10));
        mumFIObox.add(txtLine2);
        mumFIObox.setBorder(new TitledBorder("Информация о матери"));

        return mumFIObox;
    }

    public String getStudentSurName(){return studentSurName.getText();}
    public String getStudentFirstName(){return studentFirstName.getText();}
    public String getStudentSecondName(){return studentSecondName.getText();}
    public String getDadSurName(){return dadSurName.getText();}
    public String getDadFirstName(){return dadFirstName.getText();}
    public String getDadSecondName(){return dadSecondName.getText();}
    public String getMumSurName(){return mumSurName.getText();}
    public String getMumFirstName(){return mumFirstName.getText();}
    public String getMumSecondName(){return mumSecondName.getText();}
    public String getDadSalary(){return  dadSalary.getText();}
    public String getMumSalary(){return  mumSalary.getText();}
    public String getBrotherNum(){return numOfBrothers.getText();}
    public String getSisterNum(){return numOfSisters.getText();}

    public JDialog getDialog(){return dialog;}
}

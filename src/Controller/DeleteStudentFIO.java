package Controller;

import Model.DataBase;
import Model.Parent;
import Model.Student;
import View.ViewEntryPoint;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class DeleteStudentFIO {
    private DataBase dataBase;
    private List<String> deletedStud = new ArrayList<>(35);

    public DeleteStudentFIO(DataBase dataBase, String surName, String firstName, String secName){
        this.dataBase = dataBase;
        if (surName.equals("")){
            JOptionPane.showMessageDialog(null, "Fill student's Surname.");
            return;
        }
        if((!firstName.equals("") && secName.equals("")) || (firstName.equals("") && !secName.equals(""))){
            JOptionPane.showMessageDialog(null, "Fill student's Full FIO.");
            return;
        }
        if (firstName.equals("") && secName.equals("")){
            for (int i = 0; i < dataBase.size(); i++){
                if (surName.equals(dataBase.getStud(i).getSurName())){
                    removeThisStudent(i);
                    i--;
                }
            }
            deleteInfo();
            return;
        }
        if (!(firstName.equals("") && secName.equals(""))){
            for (int i = 0; i < dataBase.size();i++){
                if (surName.equals(dataBase.getStud(i).getSurName()) &&
                        firstName.equals(dataBase.getStud(i).getFirstName()) &&
                        secName.equals(dataBase.getStud(i).getSecondName())){
                    removeThisStudent(i);
                    i--;
                }
            }
            deleteInfo();
        }
    }


    private void removeThisStudent(int i){
        deletedStud.add(dataBase.getStud(i).getSurName() + " " +
                dataBase.getStud(i).getFirstName() + " " +
                dataBase.getStud(i).getSecondName());
        dataBase.delStud(i);
        dataBase.delDad(i);
        dataBase.delMum(i);
    }
    private void deleteInfo(){
        String output="";
        for (String s : deletedStud) {
            output+=s+"\n";
        }
        if (output.equals("")) {
            JOptionPane.showMessageDialog(null, "По данному запросу студентов не найдено");
        }
        else {
            JOptionPane.showMessageDialog(null, "Удален(ы)\n"+output);
        }
        ViewEntryPoint.tablePanel.updateTable();
    }
}

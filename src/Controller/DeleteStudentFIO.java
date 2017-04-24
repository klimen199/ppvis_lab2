package Controller;

import Model.Parent;
import Model.Student;
import View.ViewEntryPoint;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class DeleteStudentFIO {

    private List<String> deletedStud = new ArrayList<>(35);

    public DeleteStudentFIO(String surName, String firstName, String secName){
        if (surName.equals("")){
            JOptionPane.showMessageDialog(null, "Fill student's Surname.");
            return;
        }
        if((!firstName.equals("") && secName.equals("")) || (firstName.equals("") && !secName.equals(""))){
            JOptionPane.showMessageDialog(null, "Fill student's Full FIO.");
            return;
        }
        if (firstName.equals("") && secName.equals("")){
            for (int i = 0; i < Student.studentsList.size(); i++){
                if (surName.equals(Student.studentsList.get(i).getSurName())){
                    removeThisStudent(i);
                    i--;
                }
            }
            deleteInfo();
            return;
        }
        if (!(firstName.equals("") && secName.equals(""))){
            for (int i = 0; i < Student.studentsList.size();i++){
                if (surName.equals(Student.studentsList.get(i).getSurName()) &&
                        firstName.equals(Student.studentsList.get(i).getFirstName()) &&
                        secName.equals(Student.studentsList.get(i).getSecondName())){
                    removeThisStudent(i);
                    i--;
                }
            }
            deleteInfo();
        }
    }


    private void removeThisStudent(int i){
        deletedStud.add(Student.studentsList.get(i).getSurName() + " " +
                Student.studentsList.get(i).getFirstName() + " " +
                Student.studentsList.get(i).getSecondName());
        Student.studentsList.remove(i);
        Parent.fathersList.remove(i);
        Parent.mothersList.remove(i);
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

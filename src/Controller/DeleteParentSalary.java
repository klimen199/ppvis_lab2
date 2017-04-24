package Controller;


import Model.Parent;
import Model.Student;
import View.ViewEntryPoint;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DeleteParentSalary {
    int dadMinInt;
    int dadMaxInt;
    int momMinInt;
    int momMaxInt;
    private List<String> deletedStud = new ArrayList<>(35);


    public DeleteParentSalary(String dadMin, String dadMax,
                              String momMin, String momMax){
        if (dadMin.equals("") && dadMax.equals("") && momMin.equals("") && momMax.equals("")){
            JOptionPane.showMessageDialog(null, "Fill search fields.");
            return;
        }

        processInput(dadMin, dadMax, momMin, momMax);


        for (int i = 0; i < Student.studentsList.size(); i++){
            if (dadMinInt <= Parent.fathersList.get(i).getSalary()
                    && dadMaxInt >= Parent.fathersList.get(i).getSalary()
                    && momMinInt <= Parent.mothersList.get(i).getSalary()
                    && momMaxInt >= Parent.mothersList.get(i).getSalary()){
                removeThisStudent(i);
                i--;
            }
        }
        deleteInfo();
    }



    private void processInput(String dadMin, String dadMax,
                              String momMin, String momMax){
        try{
            dadMinInt = Integer.parseInt(dadMin);
        }
        catch (NumberFormatException e){
            dadMinInt = 0;
        }
        try{
            dadMaxInt = Integer.parseInt(dadMax);
        }
        catch (NumberFormatException e){
            dadMaxInt =Integer.MAX_VALUE;
        }
        try{
            momMinInt = Integer.parseInt(momMin);
        }
        catch (NumberFormatException e){
            momMinInt = 0;
        }
        try{
            momMaxInt = Integer.parseInt(momMax);
        }
        catch (NumberFormatException e){
            momMaxInt = Integer.MAX_VALUE;
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

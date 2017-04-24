package Controller;

import Model.DataBase;
import Model.Parent;
import Model.Student;
import View.ViewEntryPoint;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 24.04.2017.
 */
public class DeleteBrotherSister {
    private DataBase dataBase;
    int brothMinInt;
    int brothMaxInt;
    int sistMinInt;
    int sistMaxInt;

    private List<String> deletedStud = new ArrayList<>(35);


    public DeleteBrotherSister(DataBase dataBase,
                               String brothMin, String brothMax,
                               String sistMin, String sistMax){
        this.dataBase = dataBase;
        if (brothMin.equals("") && brothMax.equals("") && sistMin.equals("") && sistMax.equals("")){
            JOptionPane.showMessageDialog(null, "Fill search fields.");
            return;
        }

        processInput(brothMin, brothMax, sistMin, sistMax);


        for (int i = 0; i < dataBase.size(); i++){
            if (brothMinInt <= dataBase.getStud(i).getBrotherNum()
                    && brothMaxInt >= dataBase.getStud(i).getBrotherNum()
                    && sistMinInt <= dataBase.getStud(i).getSisterNum()
                    && sistMaxInt >= dataBase.getStud(i).getSisterNum()){
                removeThisStudent(i);
                i--;
            }
        }
        deleteInfo();


    }

    private void processInput(String brothMin, String brothMax,
                              String sistMin, String sistMax){
        try{
            brothMinInt = Integer.parseInt(brothMin);
        }
        catch (NumberFormatException e){
            brothMinInt = 0;
        }
        try{
            brothMaxInt = Integer.parseInt(brothMax);
        }
        catch (NumberFormatException e){
            brothMaxInt = Integer.MAX_VALUE;
        }
        try{
            sistMinInt = Integer.parseInt(sistMin);
        }
        catch (NumberFormatException e){
            sistMinInt = 0;
        }
        try{
            sistMaxInt = Integer.parseInt(sistMax);
        }
        catch (NumberFormatException e){
            sistMaxInt = Integer.MAX_VALUE;
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

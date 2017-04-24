package Controller;

import Model.DataBase;
import Model.Parent;
import Model.Student;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 12.04.2017.
 */
public class SearchParentSalary {
    private DataBase dataBase;
    List<Student> studentsSearchList = new ArrayList<>(35);
    List<Parent> fathersSearchList = new ArrayList<>(35);
    List<Parent> mothersSearchList = new ArrayList<>(35);
    int dadMinInt;
    int dadMaxInt;
    int momMinInt;
    int momMaxInt;

    public SearchParentSalary (DataBase dataBase,
                               String dadMin, String dadMax,
                               String momMin, String momMax){
        this.dataBase = dataBase;
        if (dadMin.equals("") && dadMax.equals("") && momMin.equals("") && momMax.equals("")){
            JOptionPane.showMessageDialog(null, "Fill search fields.");
            notChangeTable();
            return;
        }

        processInput(dadMin, dadMax, momMin, momMax);


            for (int i = 0; i < dataBase.size(); i++){
                if (dadMinInt <= dataBase.getDad(i).getSalary()
                        && dadMaxInt >= dataBase.getDad(i).getSalary()
                        && momMinInt <= dataBase.getMum(i).getSalary()
                        && momMaxInt >= dataBase.getMum(i).getSalary()){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();


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


    private void notChangeTable(){
        studentsSearchList = dataBase.studentList;
        fathersSearchList = dataBase.fatherList;
        mothersSearchList = dataBase.motherList;
    }

    private void addThisStudent(int i){
        studentsSearchList.add(dataBase.getStud(i));
        fathersSearchList.add(dataBase.getDad(i));
        mothersSearchList.add(dataBase.getMum(i));
    }

    private void checkIsEmpty(){
        if (studentsSearchList.size() == 0){
            JOptionPane.showMessageDialog(null, "Don't find such students.");
            notChangeTable();
        }
    }

    public List getSearchStudList(){
        return studentsSearchList;
    }
    public List getSearchDadList(){
        return fathersSearchList;
    }
    public List getSearchMumList(){
        return mothersSearchList;
    }
}

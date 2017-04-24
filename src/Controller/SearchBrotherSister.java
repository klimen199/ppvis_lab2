package Controller;

import Model.DataBase;
import Model.Parent;
import Model.Student;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SearchBrotherSister {
    private DataBase dataBase;
    List<Student> studentsSearchList = new ArrayList<>(35);
    List<Parent> fathersSearchList = new ArrayList<>(35);
    List<Parent> mothersSearchList = new ArrayList<>(35);
    int brothMinInt;
    int brothMaxInt;
    int sistMinInt;
    int sistMaxInt;

    public SearchBrotherSister (DataBase dataBase,
                                String brothMin, String brothMax,
                                String sistMin, String sistMax){
        this.dataBase = dataBase;
        if (brothMin.equals("") && brothMax.equals("") && sistMin.equals("") && sistMax.equals("")){
            JOptionPane.showMessageDialog(null, "Fill search fields.");
            notChangeTable();
            return;
        }

        processInput(brothMin, brothMax, sistMin, sistMax);


            for (int i = 0; i < dataBase.size(); i++){
                if (brothMinInt <= dataBase.getStud(i).getBrotherNum()
                        && brothMaxInt >= dataBase.getStud(i).getBrotherNum()
                        && sistMinInt <= dataBase.getStud(i).getSisterNum()
                        && sistMaxInt >= dataBase.getStud(i).getSisterNum()){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();


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
//        System.out.println(brothMin + " " + brothMax + " " + sistMin + " " + sistMax);
//        System.out.println(brothMinInt + " " + brothMaxInt + " " + sistMinInt + " " + sistMaxInt);

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

package Controller;

import Model.Parent;
import Model.Student;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SearchBrotherSister {
    List<Student> studentsSearchList = new ArrayList<>(35);
    List<Parent> fathersSearchList = new ArrayList<>(35);
    List<Parent> mothersSearchList = new ArrayList<>(35);
    int brothMinInt;
    int brothMaxInt;
    int sistMinInt;
    int sistMaxInt;

    public SearchBrotherSister (String brothMin, String brothMax,
                                String sistMin, String sistMax){
        if (brothMin.equals("") && brothMax.equals("") && sistMin.equals("") && sistMax.equals("")){
            JOptionPane.showMessageDialog(null, "Fill search fields.");
            notChangeTable();
            return;
        }

        processInput(brothMin, brothMax, sistMin, sistMax);


            for (int i = 0; i < Student.studentsList.size(); i++){
                if (brothMinInt <= Student.studentsList.get(i).getBrotherNum()
                        && brothMaxInt >= Student.studentsList.get(i).getBrotherNum()
                        && sistMinInt <= Student.studentsList.get(i).getSisterNum()
                        && sistMaxInt >= Student.studentsList.get(i).getSisterNum()){
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
        studentsSearchList = Student.studentsList;
        fathersSearchList = Parent.fathersList;
        mothersSearchList = Parent.mothersList;
    }

    private void addThisStudent(int i){
        studentsSearchList.add(Student.studentsList.get(i));
        fathersSearchList.add(Parent.fathersList.get(i));
        mothersSearchList.add(Parent.mothersList.get(i));
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

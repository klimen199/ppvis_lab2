package Controller;

import Model.Parent;
import Model.Student;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 12.04.2017.
 */
public class SearchParentSalary {
    List<Student> studentsSearchList = new ArrayList<>(35);
    List<Parent> fathersSearchList = new ArrayList<>(35);
    List<Parent> mothersSearchList = new ArrayList<>(35);
    int dadMinInt;
    int dadMaxInt;
    int momMinInt;
    int momMaxInt;

    public SearchParentSalary (String dadMin, String dadMax,
                               String momMin, String momMax){
        if (dadMin.equals("") && dadMax.equals("") && momMin.equals("") && momMax.equals("")){
            JOptionPane.showMessageDialog(null, "Fill search fields.");
            notChangeTable();
            return;
        }

        processInput(dadMin, dadMax, momMin, momMax);


        if (!dadMin.equals("") && !dadMax.equals("") && !momMin.equals("") && !momMax.equals("")){
            for (int i = 0; i < Student.studentsList.size(); i++){
                if (dadMinInt <= Parent.fathersList.get(i).getSalary()
                        && dadMaxInt >= Parent.fathersList.get(i).getSalary()
                        && momMinInt <= Parent.mothersList.get(i).getSalary()
                        && momMaxInt >= Parent.mothersList.get(i).getSalary()){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();
            return;
        }

        if (!dadMin.equals("") && dadMax.equals("") && momMin.equals("") && momMax.equals("")){
            for (int i = 0; i < Student.studentsList.size(); i++){
                if (dadMinInt <= Parent.fathersList.get(i).getSalary()){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();
            return;
        }
        if (!dadMin.equals("") && dadMax.equals("") && !momMin.equals("") && momMax.equals("")){
            for (int i = 0; i < Student.studentsList.size(); i++){
                if (dadMinInt <= Parent.fathersList.get(i).getSalary()
                        && momMinInt <= Parent.mothersList.get(i).getSalary()){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();
            return;
        }
        if (dadMin.equals("") && !dadMax.equals("") && momMin.equals("") && !momMax.equals("")){
            for (int i = 0; i < Student.studentsList.size(); i++){
                if (dadMaxInt >= Parent.fathersList.get(i).getSalary()
                        && momMaxInt >= Parent.mothersList.get(i).getSalary()){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();
            return;
        }

        if (!dadMin.equals("") && dadMax.equals("") && momMin.equals("") && !momMax.equals("")){
            for (int i = 0; i < Student.studentsList.size(); i++){
                if (dadMinInt <= Parent.fathersList.get(i).getSalary()
                        && momMaxInt >= Parent.mothersList.get(i).getSalary()){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();
            return;
        }
        if (dadMin.equals("") && !dadMax.equals("") && !momMin.equals("") && momMax.equals("")){
            for (int i = 0; i < Student.studentsList.size(); i++){
                if (dadMaxInt >= Parent.fathersList.get(i).getSalary()
                        && momMinInt <= Parent.mothersList.get(i).getSalary()){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();
            return;
        }
        if (dadMin.equals("") && !dadMax.equals("") && momMin.equals("") && momMax.equals("")){
            for (int i = 0; i < Student.studentsList.size(); i++){
                if (dadMaxInt >= Parent.fathersList.get(i).getSalary()){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();
            return;
        }
        if (!dadMin.equals("") && !dadMax.equals("") && momMin.equals("") && momMax.equals("")){
            for (int i = 0; i < Student.studentsList.size(); i++){
                if (dadMinInt <= Parent.fathersList.get(i).getSalary()
                        && dadMaxInt >= Parent.fathersList.get(i).getSalary()){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();
            return;
        }
        if (!dadMin.equals("") && !dadMax.equals("") && momMin.equals("") && !momMax.equals("")){
            for (int i = 0; i < Student.studentsList.size(); i++){
                if (dadMinInt <= Parent.fathersList.get(i).getSalary()
                        && dadMaxInt >= Parent.fathersList.get(i).getSalary()
                        && momMaxInt >= Parent.mothersList.get(i).getSalary()){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();
            return;
        }
        if (!dadMin.equals("") && !dadMax.equals("") && !momMin.equals("") && momMax.equals("")){
            for (int i = 0; i < Student.studentsList.size(); i++){
                if (dadMinInt <= Parent.fathersList.get(i).getSalary()
                        && dadMaxInt >= Parent.fathersList.get(i).getSalary()
                        && momMinInt <= Parent.mothersList.get(i).getSalary()){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();
            return;
        }
        if (dadMin.equals("") && dadMax.equals("") && !momMin.equals("") && momMax.equals("")){
            for (int i = 0; i < Student.studentsList.size();i++){
                if (momMinInt <= Parent.mothersList.get(i).getSalary()){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();
            return;
        }
        if (dadMin.equals("") && dadMax.equals("") && momMin.equals("") && !momMax.equals("")){
            for (int i = 0; i < Student.studentsList.size();i++){
                if (momMaxInt >= Parent.mothersList.get(i).getSalary()){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();
            return;
        }
        if (dadMin.equals("") && dadMax.equals("") && !momMin.equals("") && !momMax.equals("")){
            for (int i = 0; i < Student.studentsList.size();i++){
                if (momMinInt <= Parent.mothersList.get(i).getSalary()
                        && momMaxInt >= Parent.mothersList.get(i).getSalary()){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();
            return;
        }
        if (dadMin.equals("") && !dadMax.equals("") && !momMin.equals("") && !momMax.equals("")){
            for (int i = 0; i < Student.studentsList.size();i++){
                if (dadMaxInt >= Parent.fathersList.get(i).getSalary()
                        && momMinInt <= Parent.mothersList.get(i).getSalary()
                        && momMaxInt >= Parent.mothersList.get(i).getSalary()){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();
            return;
        }
        if (!dadMin.equals("") && dadMax.equals("") && !momMin.equals("") && !momMax.equals("")){
            for (int i = 0; i < Student.studentsList.size();i++){
                if (dadMinInt <= Parent.fathersList.get(i).getSalary()
                        && momMinInt <= Parent.mothersList.get(i).getSalary()
                        && momMaxInt >= Parent.mothersList.get(i).getSalary()){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();
            return;
        }
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
            dadMaxInt =0;
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
            momMaxInt = 0;
        }
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
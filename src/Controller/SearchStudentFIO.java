package Controller;

import Model.DataBase;
import Model.Parent;
import Model.Student;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class SearchStudentFIO {
    private DataBase dataBase;
    List<Student> studentsSearchList = new ArrayList<>(35);
    List<Parent> fathersSearchList = new ArrayList<>(35);
    List<Parent> mothersSearchList = new ArrayList<>(35);

    public SearchStudentFIO (DataBase dataBase, String surName, String firstName, String secName){
        this.dataBase = dataBase;
        if (surName.equals("")){
            JOptionPane.showMessageDialog(null, "Fill student's Surname.");
            notChangeTable();
            return;
        }
        if((!firstName.equals("") && secName.equals("")) || (firstName.equals("") && !secName.equals(""))){
            JOptionPane.showMessageDialog(null, "Fill student's Full FIO.");
            notChangeTable();
            return;
        }
        if (firstName.equals("") && secName.equals("")){
            for (int i = 0; i < dataBase.size();i++){
                if (surName.equals(dataBase.getStud(i).getSurName())){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();
            return;
        }
        if (!(firstName.equals("") && secName.equals(""))){
            for (int i = 0; i < dataBase.size();i++){
                if (surName.equals(dataBase.getStud(i).getSurName()) &&
                        firstName.equals(dataBase.getStud(i).getFirstName()) &&
                        secName.equals(dataBase.getStud(i).getSecondName())){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();
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

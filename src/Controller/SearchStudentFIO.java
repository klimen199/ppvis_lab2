package Controller;

import Model.Parent;
import Model.Student;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class SearchStudentFIO {
    List<Student> studentsSearchList = new ArrayList<>(35);
    List<Parent> fathersSearchList = new ArrayList<>(35);
    List<Parent> mothersSearchList = new ArrayList<>(35);

    public SearchStudentFIO (String surName, String firstName, String secName){
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
            for (int i = 0; i < Student.studentsList.size();i++){
                if (surName.equals(Student.studentsList.get(i).getSurName())){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();
            return;
        }
        if (!(firstName.equals("") && secName.equals(""))){
            for (int i = 0; i < Student.studentsList.size();i++){
                if (surName.equals(Student.studentsList.get(i).getSurName()) &&
                        firstName.equals(Student.studentsList.get(i).getFirstName()) &&
                        secName.equals(Student.studentsList.get(i).getSecondName())){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();
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

package Controller;

import Model.DataBase;
import Model.Parent;
import Model.Student;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SearchParentFIO {
    private DataBase dataBase;
    List<Student> studentsSearchList = new ArrayList<>(35);
    List<Parent> fathersSearchList = new ArrayList<>(35);
    List<Parent> mothersSearchList = new ArrayList<>(35);

    public SearchParentFIO (DataBase dataBase,
                            String dadSurName, String dadFirstName, String dadSecName,
                            String mumSurName, String mumFirstName, String mumSecName){
        this.dataBase = dataBase;
        boolean goNext = false;
        if (!(dadSurName.equals("") || dadFirstName.equals("") || dadSecName.equals(""))){
            goNext = true;
        }
        if (!(mumSurName.equals("") || mumFirstName.equals("") || mumSecName.equals(""))){
            goNext = true;
        }
        if (!goNext){
            JOptionPane.showMessageDialog(null, "Fill one parent Full FIO.");
            notChangeTable();
            return;
        }
        if (!(dadSurName.equals("") && dadFirstName.equals("") && dadSecName.equals("")) &&
                (mumSurName.equals("") || mumFirstName.equals("") || mumSecName.equals(""))){
            for (int i = 0; i < dataBase.size(); i++){
                if(dadSurName.equals(dataBase.getDad(i).getSurName()) &&
                        dadFirstName.equals(dataBase.getDad(i).getFirstName()) &&
                        dadSecName.equals(dataBase.getDad(i).getSecondName())){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();
            return;
        }
        if (!(mumSurName.equals("") && mumFirstName.equals("") && mumSecName.equals("")) &&
                (dadSurName.equals("") || dadFirstName.equals("") || dadSecName.equals(""))){
            for (int i = 0; i < dataBase.size(); i++){
                Parent mum = dataBase.getMum(i);
                if(mumSurName.equals(mum.getSurName()) &&
                        mumFirstName.equals(mum.getFirstName()) &&
                        mumSecName.equals(mum.getSecondName())){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();
            return;
        }
        if (!("".equals(mumSurName) && mumFirstName.equals("") && mumSecName.equals("")) &&
                !(dadSurName.equals("") && dadFirstName.equals("") && dadSecName.equals(""))){
            for (int i = 0; i < dataBase.size(); i++){
                if(mumSurName.equals(dataBase.getMum(i).getSurName()) &&
                        mumFirstName.equals(dataBase.getMum(i).getFirstName()) &&
                        mumSecName.equals(dataBase.getMum(i).getSecondName()) &&
                        dadSurName.equals(dataBase.getDad(i).getSurName()) &&
                        dadFirstName.equals(dataBase.getDad(i).getFirstName()) &&
                        dadSecName.equals(dataBase.getDad(i).getSecondName())){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();
        }
    }


    private void addThisStudent(int i){
        studentsSearchList.add(dataBase.getStud(i));
        fathersSearchList.add(dataBase.getDad(i));
        mothersSearchList.add(dataBase.getMum(i));
    }

    private void notChangeTable(){
        studentsSearchList = dataBase.studentList;
        fathersSearchList = dataBase.fatherList;
        mothersSearchList = dataBase.motherList;
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

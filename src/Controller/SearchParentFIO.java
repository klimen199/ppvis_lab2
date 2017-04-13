package Controller;

import Model.Parent;
import Model.Student;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SearchParentFIO {
    List<Student> studentsSearchList = new ArrayList<>(35);
    List<Parent> fathersSearchList = new ArrayList<>(35);
    List<Parent> mothersSearchList = new ArrayList<>(35);

    public SearchParentFIO (String dadSurName, String dadFirstName, String dadSecName,
                            String mumSurName, String mumFirstName, String mumSecName){

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
            for (int i = 0; i < Parent.fathersList.size(); i++){
                if(dadSurName.equals(Parent.fathersList.get(i).getSurName()) &&
                        dadFirstName.equals(Parent.fathersList.get(i).getFirstName()) &&
                        dadSecName.equals(Parent.fathersList.get(i).getSecondName())){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();
            return;
        }
        if (!(mumSurName.equals("") && mumFirstName.equals("") && mumSecName.equals("")) &&
                (dadSurName.equals("") || dadFirstName.equals("") || dadSecName.equals(""))){
            for (int i = 0; i < Parent.mothersList.size(); i++){
                if(mumSurName.equals(Parent.mothersList.get(i).getSurName()) &&
                        mumFirstName.equals(Parent.mothersList.get(i).getFirstName()) &&
                        mumSecName.equals(Parent.mothersList.get(i).getSecondName())){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();
            return;
        }
        if (!(mumSurName.equals("") && mumFirstName.equals("") && mumSecName.equals("")) &&
                !(dadSurName.equals("") && dadFirstName.equals("") && dadSecName.equals(""))){
            for (int i = 0; i < Parent.mothersList.size(); i++){
                if(mumSurName.equals(Parent.mothersList.get(i).getSurName()) &&
                        mumFirstName.equals(Parent.mothersList.get(i).getFirstName()) &&
                        mumSecName.equals(Parent.mothersList.get(i).getSecondName()) &&
                        dadSurName.equals(Parent.fathersList.get(i).getSurName()) &&
                        dadFirstName.equals(Parent.fathersList.get(i).getFirstName()) &&
                        dadSecName.equals(Parent.fathersList.get(i).getSecondName())){
                    addThisStudent(i);
                }
            }
            checkIsEmpty();
        }
    }


    private void addThisStudent(int i){
        studentsSearchList.add(Student.studentsList.get(i));
        fathersSearchList.add(Parent.fathersList.get(i));
        mothersSearchList.add(Parent.mothersList.get(i));
    }

    private void notChangeTable(){
        studentsSearchList = Student.studentsList;
        fathersSearchList = Parent.fathersList;
        mothersSearchList = Parent.mothersList;
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

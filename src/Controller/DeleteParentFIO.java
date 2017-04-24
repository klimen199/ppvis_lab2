package Controller;

import Model.Parent;
import Model.Student;
import View.ViewEntryPoint;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 24.04.2017.
 */
public class DeleteParentFIO {

    private List<String> deletedStud = new ArrayList<>(35);


    public DeleteParentFIO(String dadSurName, String dadFirstName, String dadSecName,
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
            return;
        }
        if (!(dadSurName.equals("") && dadFirstName.equals("") && dadSecName.equals("")) &&
                (mumSurName.equals("") || mumFirstName.equals("") || mumSecName.equals(""))){
            for (int i = 0; i < Parent.fathersList.size(); i++){
                if(dadSurName.equals(Parent.fathersList.get(i).getSurName()) &&
                        dadFirstName.equals(Parent.fathersList.get(i).getFirstName()) &&
                        dadSecName.equals(Parent.fathersList.get(i).getSecondName())){
                    removeThisStudent(i);
                    i--;
                }
            }
            deleteInfo();
            return;
        }
        if (!(mumSurName.equals("") && mumFirstName.equals("") && mumSecName.equals("")) &&
                (dadSurName.equals("") || dadFirstName.equals("") || dadSecName.equals(""))){
            for (int i = 0; i < Parent.mothersList.size(); i++){
                if(mumSurName.equals(Parent.mothersList.get(i).getSurName()) &&
                        mumFirstName.equals(Parent.mothersList.get(i).getFirstName()) &&
                        mumSecName.equals(Parent.mothersList.get(i).getSecondName())){
                    removeThisStudent(i);
                    i--;
                }
            }
            deleteInfo();
            return;
        }
        if (!("".equals(mumSurName) && mumFirstName.equals("") && mumSecName.equals("")) &&
                !(dadSurName.equals("") && dadFirstName.equals("") && dadSecName.equals(""))){
            for (int i = 0; i < Parent.mothersList.size(); i++){
                if(mumSurName.equals(Parent.mothersList.get(i).getSurName()) &&
                        mumFirstName.equals(Parent.mothersList.get(i).getFirstName()) &&
                        mumSecName.equals(Parent.mothersList.get(i).getSecondName()) &&
                        dadSurName.equals(Parent.fathersList.get(i).getSurName()) &&
                        dadFirstName.equals(Parent.fathersList.get(i).getFirstName()) &&
                        dadSecName.equals(Parent.fathersList.get(i).getSecondName())){
                    removeThisStudent(i);
                    i--;
                }
            }
            deleteInfo();
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

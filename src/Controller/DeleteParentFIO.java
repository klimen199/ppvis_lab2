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
public class DeleteParentFIO {
    private DataBase dataBase;
    private List<String> deletedStud = new ArrayList<>(35);


    public DeleteParentFIO(DataBase dataBase,
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
            return;
        }
        if (!(dadSurName.equals("") && dadFirstName.equals("") && dadSecName.equals("")) &&
                (mumSurName.equals("") || mumFirstName.equals("") || mumSecName.equals(""))){
            for (int i = 0; i < dataBase.size(); i++){
                if(dadSurName.equals(dataBase.getDad(i).getSurName()) &&
                        dadFirstName.equals(dataBase.getDad(i).getFirstName()) &&
                        dadSecName.equals(dataBase.getDad(i).getSecondName())){
                    removeThisStudent(i);
                    i--;
                }
            }
            deleteInfo();
            return;
        }
        if (!(mumSurName.equals("") && mumFirstName.equals("") && mumSecName.equals("")) &&
                (dadSurName.equals("") || dadFirstName.equals("") || dadSecName.equals(""))){
            for (int i = 0; i < dataBase.size(); i++){
                if(mumSurName.equals(dataBase.getMum(i).getSurName()) &&
                        mumFirstName.equals(dataBase.getMum(i).getFirstName()) &&
                        mumSecName.equals(dataBase.getMum(i).getSecondName())){
                    removeThisStudent(i);
                    i--;
                }
            }
            deleteInfo();
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
                    removeThisStudent(i);
                    i--;
                }
            }
            deleteInfo();
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

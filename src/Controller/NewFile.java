package Controller;

import Model.DataBase;
import View.ViewEntryPoint;


public class NewFile {
    public DataBase dataBase;

    public NewFile(DataBase dataBase){
        this.dataBase = dataBase;

        dataBase.studentList.clear();
        dataBase.fatherList.clear();
        dataBase.motherList.clear();
        ViewEntryPoint.tablePanel.updateTable();
    }
}

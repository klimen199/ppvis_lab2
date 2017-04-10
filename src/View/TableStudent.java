package View;

import Model.Student;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableStudent extends AbstractTableModel {

    List<Student> students;

    TableStudent(List<Student> studentList){
        super();
        this.students = studentList;
    }

    public void add(Student stud){
        students.add(stud);
    }

    public void removeRow(int row){
        students.remove(row);
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ФИО студента";
            case 1:
                return "ФИО отца";
            case 2:
                return "З/п отца";
            case 3:
                return "ФИО матери";
            case 4:
                return "З/п матери";
            case 5:
                return "Кол-во братьев";
            case 6:
                return "Кол-во сестер";
            default:
                return "Other column";
        }
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch (col){
            case 0:
                return Student.studentsList.get(row).getSurName();
            case 5:
                return Student.studentsList.get(row).getBrotherNum();
            case 6:
                return Student.studentsList.get(row).getSisterNum();
            default:
                return "lol, zapolni";
        }
    }
}

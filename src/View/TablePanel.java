package View;

import Model.Student;

import javax.swing.*;
import java.awt.*;
import java.util.List;


/**
 * Created by user on 09.04.2017.
 */
public class TablePanel extends JPanel{
    private List<Student> studentsList;
    private int countStudOnPage = 20;
    private int currentPage = 1;


    public TablePanel(List<Student> studentsList){
        this.studentsList = studentsList;
        setLayout(new BorderLayout());
        add(new JScrollPane(makeTable(studentsList)));
        add(makeTableToolBar(), BorderLayout.SOUTH);
    }

    public JTable makeTable(List<Student> studentsList){
        JTable tableWithStudents = new JTable(new Object[countStudOnPage][7], new String[]
                {"ФИО студента", "ФИО отца","Заработок отца","ФИО матери","Заработок матери","Число братьев","Число сестер"});
        tableWithStudents.setEnabled(false);

        for(int i = 0; i < studentsList.size(); i++){
            tableWithStudents.setValueAt(studentsList.get(i).getSurName() +
                    " " + studentsList.get(i).getFirstName() +
                    " " + studentsList.get(i).getSecondName(),i,0);
            tableWithStudents.setValueAt(studentsList.get(i).getBrotherNum(),i,5);
        }

        return tableWithStudents;
    }

    private JPanel makeTableToolBar(){
        JPanel panelToolBar = new JPanel();
        JButton firstButton = new JButton("Первая");
        panelToolBar.add(firstButton);
        JButton prevButton = new JButton("Предыдущая");
        panelToolBar.add(prevButton);
        JButton nextButton = new JButton("Следующая");
        panelToolBar.add(nextButton);
        JButton lastButton = new JButton("Последняя");
        panelToolBar.add(lastButton);
        return panelToolBar;
    }

    public void updateTable(){
        removeAll();
        updateUI();
        add(new JScrollPane(makeTable(studentsList)));
        add(makeTableToolBar(), BorderLayout.SOUTH);
        revalidate();
        repaint();
    }
}

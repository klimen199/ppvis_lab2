package View;

import Model.Parent;
import Model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;


public class TablePanel extends JPanel{
    private List<Student> studentsList;
    private List<Parent> dadsList;
    private List<Parent> momsList;
    private int countStudOnPage = 10;
    private int currentPage = 1;

    private int getNumberofMaxPage(){
        return ((studentsList.size()-1)/countStudOnPage + 1);
    }

    public TablePanel(List<Student> studentsList, List<Parent> fathersList, List<Parent> mothersList){
        this.studentsList = studentsList;
        this.dadsList = fathersList;
        this.momsList = mothersList;
        setLayout(new BorderLayout());
        add(new JScrollPane(makeTable(studentsList, fathersList, mothersList)));
        add(makeTableToolBar(), BorderLayout.SOUTH);
    }

    public JTable makeTable(List<Student> studentsList, List<Parent> fathersList, List<Parent> mothersList){
        JTable tableWithStudents = new JTable(new Object[countStudOnPage][7], new String[]
                {"ФИО студента", "ФИО отца","Заработок отца","ФИО матери","Заработок матери","Число братьев","Число сестер"});
        tableWithStudents.setEnabled(false);

        int firstStudOnPage = countStudOnPage*(currentPage-1);
        for(int position = 0, stud = firstStudOnPage; position < countStudOnPage && stud < studentsList.size(); position++, stud++){
            tableWithStudents.setValueAt(studentsList.get(stud).getSurName() +
                    " " + studentsList.get(stud).getFirstName() +
                    " " + studentsList.get(stud).getSecondName(),position,0);
            tableWithStudents.setValueAt(fathersList.get(stud).getSurName() +
                    " " + fathersList.get(stud).getFirstName() +
                    " " + fathersList.get(stud).getSecondName(),position,1);
            tableWithStudents.setValueAt(fathersList.get(stud).getSalary(),position,2);
            tableWithStudents.setValueAt(mothersList.get(stud).getSurName() +
                    " " + mothersList.get(stud).getFirstName() +
                    " " + mothersList.get(stud).getSecondName(),position,3);
            tableWithStudents.setValueAt(mothersList.get(stud).getSalary(),position,4);
            tableWithStudents.setValueAt(studentsList.get(stud).getBrotherNum(),position,5);
            tableWithStudents.setValueAt(studentsList.get(stud).getSisterNum(),position,6);
        }
        return tableWithStudents;
    }

    private JPanel makeTableToolBar(){
        JPanel panelToolBar = new JPanel();
        JButton firstPageButton = new JButton("Первая");
        panelToolBar.add(firstPageButton);

        firstPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPage = 1;
                updateTable();
            }
        });

        JButton prevPageButton = new JButton("Предыдущая");
        panelToolBar.add(prevPageButton);

        prevPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(currentPage > 1){
                    currentPage--;
                    updateTable();
                }
                else
                    JOptionPane.showMessageDialog(null, "It's the begining.");
            }
        });

        String pageInfoStr = "Страница " + currentPage + " из " + getNumberofMaxPage();
        JLabel pageInfo = new JLabel(pageInfoStr);
        panelToolBar.add(pageInfo);
        JButton nextPageButton = new JButton("Следующая");
        panelToolBar.add(nextPageButton);

        ///
        ///     ASK
        ///
        nextPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(currentPage < getNumberofMaxPage()){
                    currentPage++;
                    updateTable();
                }
                else
                    JOptionPane.showMessageDialog(null, "It's the end of the list.");
            }
        });


        JButton lastPageButton = new JButton("Последняя");
        panelToolBar.add(lastPageButton);

        lastPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPage = getNumberofMaxPage();
                updateTable();
            }
        });

        JLabel jlab = new JLabel("  Cтрок на странице:");
        panelToolBar.add(jlab);
        String[] numberDisplayingStudents = {"5", "10", "20", "30", "40", "50"};
        JComboBox<String> checkNumberToDisplay = new JComboBox<>(numberDisplayingStudents);
        checkNumberToDisplay.setSelectedIndex(Arrays.asList(numberDisplayingStudents).indexOf(Integer.toString(countStudOnPage)));
        checkNumberToDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (countStudOnPage != Integer.parseInt(checkNumberToDisplay.getSelectedItem().toString())){
                    countStudOnPage = Integer.parseInt(checkNumberToDisplay.getSelectedItem().toString());
                    updateTable();
                }
            }
        });
        panelToolBar.add(checkNumberToDisplay);
        return panelToolBar;
    }

    public void updateTable(){
        removeAll();
        updateUI();
        add(new JScrollPane(makeTable(studentsList, dadsList, momsList)));
        add(makeTableToolBar(), BorderLayout.SOUTH);
        revalidate();
        repaint();
    }
}

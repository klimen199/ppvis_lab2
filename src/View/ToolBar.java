package View;

import Model.DataBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToolBar {
    private DataBase dataBase;
    public JToolBar toolBar;

    public ToolBar(DataBase dataBase){
        this.dataBase = dataBase;
        ImageIcon newFileIcon = new ImageIcon(".\\src\\View\\images\\addFileIcon.png");
        JButton addNewFile = new JButton(newFileIcon);

        ImageIcon openFileIcon = new ImageIcon(".\\src\\View\\images\\openFileIcon.png");
        JButton openFile = new JButton(openFileIcon);

        ImageIcon saveFileIcon = new ImageIcon(".\\src\\View\\images\\saveFileIcon.png");
        JButton saveFile = new JButton(saveFileIcon);

        JLabel jlabel1 = new JLabel("Students:");

        ImageIcon addSudentIcon = new ImageIcon(".\\src\\View\\images\\addStudentIcon.png");
        JButton addStudent = new JButton(addSudentIcon);

        ImageIcon deleteSudentIcon = new ImageIcon(".\\src\\View\\images\\deleteStudentIcon.png");
        JButton deleteStudent = new JButton(deleteSudentIcon);

        ImageIcon searchSudentIcon = new ImageIcon(".\\src\\View\\images\\searchStudentIcon.png");
        JButton searchStudent = new JButton(searchSudentIcon);


        toolBar = new JToolBar();
        toolBar.add(addNewFile);
        toolBar.add(openFile);
        toolBar.add(saveFile);
        toolBar.addSeparator();
        toolBar.addSeparator();
        toolBar.addSeparator();
        toolBar.add(jlabel1);
        toolBar.addSeparator();
        toolBar.add(addStudent);
        toolBar.add(deleteStudent);
        toolBar.add(searchStudent);

        addStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog add = new AddStudentDialog(dataBase).getDialog();
                add.setSize(555,500);
                add.setVisible(true);
                add.setLocationRelativeTo(null);
             }
        });
        deleteStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog del = new DeleteStudentDialog(dataBase).getDialog();
                del.setSize(700,250);
                del.setVisible(true);
                del.setLocationRelativeTo(null);
            }
        });
        searchStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog search = new SearchStudentDialog(dataBase).getDialog();
                search.setSize(770,500);
                search.setVisible(true);
                search.setLocationRelativeTo(null);
            }
        });


        toolBar.addSeparator();

    }

    public JToolBar getToolBar(){
        return toolBar;
    }
}

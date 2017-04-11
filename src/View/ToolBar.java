package View;

import Controller.AddStudentListener;
import Controller.SearchStudentListener;

import javax.swing.*;
import java.awt.*;


public class ToolBar {
    public JToolBar toolBar;

    public ToolBar(){

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

        addStudent.addActionListener(new AddStudentListener());
        searchStudent.addActionListener(new SearchStudentListener());


        toolBar.addSeparator();

    }

    public JToolBar getToolBar(){
        return toolBar;
    }
}

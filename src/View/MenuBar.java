package View;

import javax.swing.*;
import Controller.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar {

    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem newFile;
    JMenuItem openFile;
    JMenuItem saveFile;
    JMenuItem exitItem;

    JMenu toolsMenu;
    JMenuItem addStudentTool;
    JMenuItem deleteStudentTool;
    JMenuItem searchStudentTool;

    public MenuBar(){
        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        newFile = new JMenuItem("New");
        fileMenu.add(newFile);
        openFile = new JMenuItem("Open");
        fileMenu.add(openFile);
        saveFile = new JMenuItem("Save");
        fileMenu.add(saveFile);
        fileMenu.addSeparator();
        exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);

        toolsMenu = new JMenu("Tools");
        addStudentTool = new JMenuItem("Add");
        toolsMenu.add(addStudentTool);
        deleteStudentTool = new JMenuItem("Delete");
        toolsMenu.add(deleteStudentTool);
        searchStudentTool = new JMenuItem("Search");
        toolsMenu.add(searchStudentTool);

        exitItem.addActionListener(new ExitProgramListener());

        addStudentTool.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog add = new AddStudentDialog().getDialog();
                add.setSize(555,500);
                add.setVisible(true);
                add.setLocationRelativeTo(null);
            }
        });
        deleteStudentTool.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog del = new DeleteStudentDialog().getDialog();
                del.setSize(700,250);
                del.setVisible(true);
                del.setLocationRelativeTo(null);
            }
        });
        searchStudentTool.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog search = new SearchStudentDialog().getDialog();
                search.setSize(770,500);
                search.setVisible(true);
                search.setLocationRelativeTo(null);
            }
        });

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
    }

    public JMenuBar getMenuBar(){
        return menuBar;
    }

}

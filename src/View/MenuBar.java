package View;

import javax.swing.*;
import Controller.*;

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

        addStudentTool.addActionListener(new AddStudentListener());
        deleteStudentTool.addActionListener(new DeleteStudentListener());
        searchStudentTool.addActionListener(new SearchStudentListener());

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
    }

    public JMenuBar getMenuBar(){
        return menuBar;
    }

}

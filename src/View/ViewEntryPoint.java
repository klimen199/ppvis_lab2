package View;

import Model.DataBase;
import Model.Parent;
import Model.Student;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewEntryPoint {
    public DataBase dataBase = new DataBase();
    private JFrame frame = new JFrame();
    public static TablePanel tablePanel;

    public ViewEntryPoint(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MenuBar myMenuBar = new MenuBar(dataBase);
        ToolBar myToolBar = new ToolBar(dataBase);
        tablePanel = new TablePanel(dataBase.studentList, dataBase.fatherList, dataBase.motherList);


        frame.add(tablePanel, BorderLayout.CENTER);
        frame.add(myToolBar.getToolBar(), BorderLayout.NORTH);
        frame.setJMenuBar(myMenuBar.getMenuBar());

    }

    public JFrame getFrame(String name){
        frame.setName(name);
        return frame;
    }
}

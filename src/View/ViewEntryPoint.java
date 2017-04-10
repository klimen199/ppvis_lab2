package View;

import Model.Student;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewEntryPoint {
    private JFrame frame = new JFrame();
    public static TablePanel tablePanel;

    public ViewEntryPoint(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MenuBar myMenuBar = new MenuBar();
        ToolBar myToolBar = new ToolBar();
        tablePanel = new TablePanel(Student.studentsList);
        JPanel centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(900,900));
        centerPanel.add(tablePanel);


        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(myToolBar.getToolBar(), BorderLayout.NORTH);
        frame.setJMenuBar(myMenuBar.getMenuBar());

    }

    public JFrame getFrame(String name){
        frame.setName(name);
        return frame;
    }
}

import View.ViewEntryPoint;

import javax.swing.*;

public class Main {
    public static void main(String [] args){
        JFrame myWindow = new ViewEntryPoint().getFrame("PPvIS - 2");
        myWindow.setSize(1000, 600);
        myWindow.setVisible(true);
        myWindow.setLocationRelativeTo(null);
    }
}

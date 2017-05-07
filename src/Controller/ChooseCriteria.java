package Controller;


import javax.swing.*;


public class ChooseCriteria {


    public Box addCriteria(Box mainBox, JComboBox criteria,
                           Box studentFIOBox, Box parentFIOBox, Box brotherSisterBox, Box parentSalaryBox) {
        String choice = (String)criteria.getSelectedItem();
        switch (choice){
            case "":{
                mainBox.remove(2);
                mainBox.add(Box.createVerticalStrut(1),2);
                mainBox.revalidate();
                break;
            }
            case "ФИО студента":{
                mainBox.remove(2);
                mainBox.add(studentFIOBox,2);
                mainBox.revalidate();
                break;
            }
            case "ФИО родителя":{
                mainBox.remove(2);
                mainBox.add(parentFIOBox,2);
                mainBox.revalidate();
                break;
            }
            case "Число братьев/сестер":{
                mainBox.remove(2);
                mainBox.add(brotherSisterBox, 2);
                mainBox.revalidate();
                break;
            }
            case "З/п родителя":{
                mainBox.remove(2);
                mainBox.add(parentSalaryBox, 2);
                mainBox.revalidate();
                break;
            }
            default:break;
        }

        return mainBox;
    }
}

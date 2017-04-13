package Controller;


import javax.swing.*;


public class ChooseSearchingCriteria {


    public Box addSearchCriteria(Box mainBox, JComboBox criteria,
                                 Box studentFIOBox, Box parentFIOBox, Box brotherSisterBox, Box parentSalaryBox) {
        int choice = criteria.getSelectedIndex();
        switch (choice){
            case 0:{
                mainBox.remove(2);
                mainBox.add(Box.createVerticalStrut(1),2);
                mainBox.revalidate();
                break;
            }
            case 1:{
                mainBox.remove(2);
                mainBox.add(studentFIOBox,2);
                mainBox.revalidate();
                break;
            }
            case 2:{
                mainBox.remove(2);
                mainBox.add(parentFIOBox,2);
                mainBox.revalidate();
                break;
            }
            case 3:{
                mainBox.remove(2);
                mainBox.add(brotherSisterBox, 2);
                mainBox.revalidate();
                break;
            }
            case 4:{
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

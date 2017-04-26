package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 02.04.2017.
 */
public class Parent {
    String surName;
    String firstName;
    String secondName;
    int salary;

    public Parent(String sName, String fstName, String secName, int sal){
        this.surName = sName;
        this.firstName = fstName;
        this.secondName = secName;
        this.salary = sal;
    }

    public String getSurName(){return surName;}
    public String getFirstName(){return firstName;}
    public String getSecondName(){return secondName;}
    public String getFullName(){
        return (surName + firstName + secondName);
    }
    public int getSalary(){return salary;}
}

package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Student {
    String surName;
    String firstName;
    String secondName;
    int brotherNum;
    int sisterNum;

    public Student(String sName, String fstName, String secName, int brothNum, int sistNum){
        this.surName = sName;
        this.firstName = fstName;
        this.secondName = secName;
        this.brotherNum = brothNum;
        this.sisterNum = sistNum;
    }

    public String getSurName(){return surName;}
    public String getFirstName(){return firstName;}
    public String getSecondName(){return secondName;}
    public int getBrotherNum(){return brotherNum;}
    public int getSisterNum(){return sisterNum;}
}

package Model;


import java.util.ArrayList;

public class DataBase {
    public ArrayList<Student> studentList = new ArrayList<>(35);
    public ArrayList<Parent> fatherList = new ArrayList<>(35);
    public ArrayList<Parent> motherList = new ArrayList<>(35);


    public void addStud(Student student) {
        studentList.add(student);
    }
    public void addDad(Parent dad) {
        fatherList.add(dad);
    }
    public void addMum(Parent mum) {
        motherList.add(mum);
    }

    public void delStud(int index)
    {
        studentList.remove(index);
    }
    public void delDad(int index)
    {
        fatherList.remove(index);
    }
    public void delMum(int index)
    {
        motherList.remove(index);
    }

    public int size() {
        return studentList.size();
    }

    public Student getStud(int index) {
        return studentList.get(index);
    }
    public Parent getDad(int index) {
        return fatherList.get(index);
    }
    public Parent getMum(int index) {
        return motherList.get(index);
    }
}

package Controller;

import Model.DataBase;
import Model.Parent;
import Model.Student;

import java.util.ArrayList;


public class AddRandomNote {

    String[] surnames = {"Zhyk", "Klimets", "Mamaiko", "Sinelnikov", "Makedon", "Minchik", "Molodoi", "Krivets",
            "Kushko", "Kotovich", "Lesun", "Akylovich", "Ryppel", "Kostukevich", "Bogumilik", "Kovalchuk",
            "Artemko", "Andronov", "Izmer", "Ianukovich", "Timoshenko", "Best", "Lobach", "Purenok", "Melencevich",
            "Sochivko", "Sevko", "Rodko", "Stelmachonok", "Navrosuk", "Shundrik"};
    String[] mNames = {"Vladislav", "Ivan", "Evgeni", "Anton", "John", "Vladimir", "Ian", "Ioan", "Artem", "Pavel",
            "Aleksander", "Eduard", "Muzhchina", "Stephan", "Korch", "Maksim", "Misha", "Vitalia", "Grigoriu", "Akakiu",
            "Lol", "Petr", "Sergey"};
    String[] wNames = {"Evgenia", "Katia", "Tatiana", "Masha", "Angelina", "Iana", "Veronika", "Aleksandra",
            "Ludmila", "Dasha", "Anna", "Stephania", "Milana", "Anastasia", "Ahzhelina", "Galina", "Valentina"};

    public AddRandomNote(DataBase dataBase){
        String surname = surnames[(int)(Math.random() * surnames.length)];
        for (int i = 0; i < 3; i++){
            dataBase.addStud(new Student(surname,
                    mNames[(int)(Math.random() * mNames.length)],
                    mNames[(int)(Math.random() * mNames.length)],
                    (int)(Math.random() * 5),
                    (int)(Math.random() * 5)));
            dataBase.addDad(new Parent(surname,
                    mNames[(int)(Math.random() * mNames.length)],
                    mNames[(int)(Math.random() * mNames.length)],
                    (int)(300 + Math.random() * 1000)));
            dataBase.addMum(new Parent(surname,
                    wNames[(int)(Math.random() * mNames.length)],
                    mNames[(int)(Math.random() * mNames.length)],
                    (int)(300 + Math.random() * 1000)));
        }
    }
}

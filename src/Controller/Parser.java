package Controller;

import Model.DataBase;
import Model.Parent;
import Model.Student;
import View.ViewEntryPoint;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.crypto.Data;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileInputStream;
import java.io.FileWriter;

/**
 * Created by user on 25.04.2017.
 */
public class Parser {
    private DataBase dataBase;

    public Parser(DataBase dataBase){
        this.dataBase = dataBase;
    }

    public void saveFile(DataBase dataBase){
        DataBase dataBase1 = dataBase;
        try {
            JFileChooser fSave = new JFileChooser();
            if (fSave.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
                XMLOutputFactory output = XMLOutputFactory.newInstance();
                XMLStreamWriter writer = output.createXMLStreamWriter(new FileWriter(fSave.getSelectedFile() + "." + "xml"));
                writer.writeStartDocument("UTF-8", "1.0");

                writer.writeStartElement("students");

                for (int i = 0; i < dataBase1.studentList.size(); i++){
                    writer.writeStartElement("student");

                    writer.writeAttribute(ParserConsts.STUDSURNAME, dataBase1.getStud(i).getSurName());
                    writer.writeAttribute(ParserConsts.STUDFNAME, dataBase1.getStud(i).getFirstName());
                    writer.writeAttribute(ParserConsts.STUDSNAME, dataBase1.getStud(i).getSecondName());

                    writer.writeAttribute(ParserConsts.DADSURNAME, dataBase1.getDad(i).getSurName());
                    writer.writeAttribute(ParserConsts.DADFNAME, dataBase1.getDad(i).getFirstName());
                    writer.writeAttribute(ParserConsts.DADSNAME, dataBase1.getDad(i).getSecondName());
                    writer.writeAttribute(ParserConsts.DADSALARY, String.valueOf(dataBase1.getDad(i).getSalary()));

                    writer.writeAttribute(ParserConsts.MUMSURNAME, dataBase1.getMum(i).getSurName());
                    writer.writeAttribute(ParserConsts.MUMFNAME, dataBase1.getMum(i).getFirstName());
                    writer.writeAttribute(ParserConsts.MUMSNAME, dataBase1.getMum(i).getSecondName());
                    writer.writeAttribute(ParserConsts.MUMSALARY, String.valueOf(dataBase1.getMum(i).getSalary()));

                    writer.writeAttribute(ParserConsts.BROTHNUM, String.valueOf(dataBase1.getStud(i).getBrotherNum()));
                    writer.writeAttribute(ParserConsts.SISTNUM, String.valueOf(dataBase1.getStud(i).getSisterNum()));

                    writer.writeEndElement();
                }
                writer.writeEndElement();
                writer.writeEndDocument();
                writer.flush();
            }
        }catch (Exception eSave){
            JOptionPane.showMessageDialog(null, "Can't save file", "Error:", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void openFile(DataBase dataBase){
        DataBase dataBase2 = dataBase;
        try{
            JFileChooser fOpen = new JFileChooser();
            fOpen.setFileFilter(new FileNameExtensionFilter(".xml", "xml"));
            if (fOpen.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                String fileName = fOpen.getSelectedFile().getPath();

                String studSurname = "";
                String studFirName = "";
                String studSecName = "";
                String dadSurname = "";
                String dadFirName = "";
                String dadSecName = "";
                String dadSalary = "";
                String mumSurname = "";
                String mumFirName = "";
                String mumSecName = "";
                String mumSalary = "";
                String brotherNum = "";
                String sisterNum = "";
                dataBase2.studentList.clear();
                dataBase2.fatherList.clear();
                dataBase2.motherList.clear();
                ViewEntryPoint.tablePanel.updateTable();
                XMLStreamReader xmlReader = XMLInputFactory.newInstance()
                        .createXMLStreamReader(fileName, new FileInputStream(fileName));
                while (xmlReader.hasNext()){
                    xmlReader.next();
                    if (xmlReader.isStartElement()){
                        if (xmlReader.getLocalName().equals("student")){
                            studSurname = xmlReader.getAttributeValue(null, ParserConsts.STUDSURNAME);
                            studFirName = xmlReader.getAttributeValue(null,ParserConsts.STUDFNAME);
                            studSecName = xmlReader.getAttributeValue(null, ParserConsts.STUDSNAME);
                            dadSurname = xmlReader.getAttributeValue(null,ParserConsts.DADSURNAME);
                            dadFirName = xmlReader.getAttributeValue(null,ParserConsts.DADFNAME);
                            dadSecName = xmlReader.getAttributeValue(null,ParserConsts.DADSNAME);
                            dadSalary = xmlReader.getAttributeValue(null,ParserConsts.DADSALARY);
                            mumSurname = xmlReader.getAttributeValue(null,ParserConsts.MUMSURNAME);
                            mumFirName = xmlReader.getAttributeValue(null,ParserConsts.MUMFNAME);
                            mumSecName = xmlReader.getAttributeValue(null,ParserConsts.MUMSNAME);
                            mumSalary = xmlReader.getAttributeValue(null,ParserConsts.MUMSALARY);
                            brotherNum = xmlReader.getAttributeValue(null,ParserConsts.BROTHNUM);
                            sisterNum = xmlReader.getAttributeValue(null,ParserConsts.SISTNUM);
                            Student student = new Student(studSurname,studFirName,studSecName,
                                    Integer.parseInt(brotherNum),Integer.parseInt(sisterNum));
                            dataBase2.addStud(student);
                            Parent father = new Parent(dadSurname,dadFirName,dadSecName,Integer.parseInt(dadSalary));
                            dataBase2.addDad(father);
                            Parent mother = new Parent(mumSurname,mumFirName,mumSecName,Integer.parseInt(mumSalary));
                            dataBase2.addMum(mother);
                        }
                    }
                }



            }
        }catch (Exception e){
            JOptionPane.showMessageDialog
                    (null, "Can't open file", "Error:", JOptionPane.ERROR_MESSAGE);
        }
    }


}

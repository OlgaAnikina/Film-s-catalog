package model;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;


public class Model extends DefaultTableModel {
    MyTableModel tableModel = new MyTableModel();
    Parser parser = new Parser();
    JTextField namefilm = new JTextField(10);
    JTextField style = new JTextField(10);
    JTextField dateOfRelease = new JTextField(10);
    JTextField producer = new JTextField(10);
    JTextField rank = new JTextField(10);

    public Model(ArrayList<Film> list) {
        tableModel.init(list);
    }

    public MyTableModel getTableModel() {
        return this.tableModel;
    }

    public Model() {}

    public void addFilm(JTextField namefilm, JTextField style, JTextField dataOfRelease, JTextField producer) {
        Film film = new Film("3", namefilm.toString(), style.toString(), dateOfRelease.toString(), producer.toString());
        tableModel.addRow(film);
    }

}




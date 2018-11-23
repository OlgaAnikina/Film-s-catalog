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

    public Model() {
    }

    public void addFilm(JTextField nameFilm, JTextField style, JTextField dataofRelease, JTextField produc) {
        int id =tableModel.getRowCount() + 1;
        Film film = new Film("" + id, nameFilm.getText(), style.getText(), dataofRelease.getText(), produc.getText());
        tableModel.addRow(film);
    }

}




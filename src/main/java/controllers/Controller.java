package controllers;

import model.Film;
import model.Model;


import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.table.TableModel;


public class Controller {//implements ActionListener {

    private Model model;
    private JTextField searchField;

    public Controller(JTextField searchField) {
        this.model = new Model();
        this.searchField = searchField;
    }


    public void addFilm(JTextField nameFilm, JTextField style,
                        JTextField dataOfRelease, JTextField producer, JTextField rank) {
        model.addFilm(nameFilm.getText(), style.getText(), dataOfRelease.getText(), producer.getText(), rank.getText());
    }

     public void search(JTextField value) {
        ArrayList<Film> films = model.searchFilm(value);
        model.getTableModel().updateTable(films);
     }

    public TableModel getTableModel() {
        return model.getTableModel();
    }

    public void refreshTableModel(){
        model.refreshTableModel();
    }

    public void removeData(int selectedRow) {
        model.removeRow(selectedRow);
        model.refreshTableModel();
    }
}

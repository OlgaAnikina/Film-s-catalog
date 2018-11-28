package controllers;

import model.Film;
import model.Model;


import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.table.TableModel;


public class Controller {

    private Model model;
    private JTextField searchField;

    public Controller(JTextField searchField) {
        this.model = new Model();
        this.searchField = searchField;
    }




    public void addFilm(JTextField nameFilm,JTextField producer ,
                        JTextField dataOfRelease, String style, String rank) {
        model.addFilm(nameFilm.getText(), producer.getText(), dataOfRelease.getText(), style, rank);
    }

    public void search(JTextField value) {
        ArrayList<Film> films = model.searchFilm(value);
        model.getTableModel().updateTable(films);
    }

    public TableModel getTableModel() {
        return model.getTableModel();
    }

    public void refreshTableModel() {
        model.refreshTableModel();
    }

    public void removeData(int selectedRow) {
        model.removeRow(selectedRow);
        model.refreshTableModel();
    }
}

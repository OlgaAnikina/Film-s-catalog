package model;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;


public class Model extends DefaultTableModel {
    MyTableModel tableModel = new MyTableModel();
    DataAdapter parser = new DataAdapter();

    IdGenerator generator = new IdGenerator(parser);

    DataAdapter readXMLFile = new DataAdapter();

    public Model() {
        tableModel.init(getData());
    }

    public MyTableModel getTableModel() {
        return this.tableModel;
    }


    public void addFilm(String nameFilm, String style,
                        String dataofRelease, String produc, String ranks) {
        int id = generator.getId();
        Film film = new Film("" + id, nameFilm,
                style, dataofRelease, produc, ranks);
        tableModel.addRow(film);
    }

    public ArrayList<Film> searchFilm(JTextField value) {
        ArrayList<Film> result = new ArrayList<>();
        ArrayList<Film> currentData = getData();
        for(Film film: currentData ) {
            if(film.getRank().equals(value.getText()))
                result.add(film);
        }
        return result;
    }

    public ArrayList<Film> getData(){
        return (ArrayList<Film>) readXMLFile.getFilms();
    }

    @Override
    public void removeRow(int i) {
        Film film = getData().get(i);
        readXMLFile.removeData(film);
    }

    public void refreshTableModel() {
        tableModel.updateTable(getData());
    }



}




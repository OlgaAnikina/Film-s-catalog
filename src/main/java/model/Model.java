package model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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


    public void addFilm(String nameFilm, String produc,
                        String dataofRelease, String style, String ranks) {
        int id = generator.getId();
        Film film = new Film("" + id, nameFilm,
                produc, dataofRelease, style, ranks);
        tableModel.addRow(film);
    }

    public ArrayList<Film> searchFilm(JTextField value) {
        ArrayList<Film> result = new ArrayList<>();
        ArrayList<Film> currentData = getData();
        for (Film film : currentData) {
            if (film.getRank().equals(value.getText())) {
                result.add(film);
                continue;
            }
            if (film.getName().equals(value.getText())) {
                result.add(film);
                continue;
            }
            if (film.getDateOfRelease().equals(value.getText())) {
                result.add(film);
                continue;
            }
            if (film.getProducer().equals(value.getText())) {
                result.add(film);
                continue;
            }
            if (film.getStyle().equals(value.getText())) {
                result.add(film);
                continue;
            }

        }
        return result;
    }

    public ArrayList<Film> getData() {
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




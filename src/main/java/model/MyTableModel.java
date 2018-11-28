package model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MyTableModel extends AbstractTableModel {
    DataAdapter parser = new DataAdapter();
    private String[] columnNames = {"ID", "Film's name", "Producer",
            "Year", "Style", "Rank"};
    ArrayList<Film> list = null;

    public MyTableModel() {
    }

    public MyTableModel(ArrayList<Film> list) {
        this.list = list;
    }

    public void init(ArrayList<Film> list) {
        this.list = list;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return list.size();
    }

    public void addRow(Film film) {
        this.list.add(film);
        for (int i = 0; i < this.getRowCount(); i++) {
            for (int j = 0; j < this.getColumnCount(); j++) {
                fireTableCellUpdated(i, j);
            }
        }
        parser.addNewBook(film);

    }

    public void updateTable(ArrayList<Film> films) {
        list.clear();
        list.addAll(films);
        fireTableDataChanged();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {

        Film object = list.get(row);

        switch (col) {
            case 0:
                return object.id;
            case 1:
                return object.name;
            case 2:
                return object.producer;
            case 3:
                return object.dateOfRelease;
            case 4:
                return object.style;
            case 5:
                return object.rank;
            default:
                return "unknown";
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    boolean[] canEdit = new boolean[]{
            true, true, true, true, true, true
    };

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
    }

    public void setValueAt(Object value, int row, int col) {


        switch (col) {
            case 0:
                // maybe id;
            case 1:
                list.get(row).setName((String) value);
                break;
            case 2:
                list.get(row).setProducer((String) value);
                break;
            case 3:
                list.get(row).setDateOfRelease((String) value);
                break;
            case 4:
                list.get(row).setStyle((String) value);
                break;
            case 5:
                list.get(row).setRank((String) value);
                break;

        }
        fireTableCellUpdated(row, col);

    }

    public String getRow(int row) {
        String result = "";
        for (int i = 0; i < this.getColumnCount() - 1; i++) {
            result += this.getValueAt(row, i).toString();
        }
        return result;
    }


}

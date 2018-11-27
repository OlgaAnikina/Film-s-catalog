package view;

import controllers.Controller;
import model.Film;
import model.Model;

import model.Parser;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class View {

    public View() {

        JTextField searchTermTextField = new JTextField(26);
        JButton filterButton = new JButton("Filter");
        JButton addButton = new JButton("Add film");
        Parser readXMLFile = new Parser();

        ArrayList<Film> list = (ArrayList<Film>) readXMLFile.getFilms();
        Model model = new Model(list);

        JTable table = new JTable(model.getTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(200, 200));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);

        table.setModel(model.getTableModel());

        Controller controller = new Controller(model);
        filterButton.addActionListener(controller);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AddFilm addFilm = new AddFilm(controller);
            }

        });

        JPanel ctrlPane = new JPanel();
        ctrlPane.add(searchTermTextField);
        ctrlPane.add(filterButton);
        ctrlPane.add(addButton);


        scrollPane.setPreferredSize(new Dimension(700, 250));

        scrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "All films", TitledBorder.CENTER, TitledBorder.TOP));

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollPane, ctrlPane);
        splitPane.setDividerLocation(250);
        splitPane.setEnabled(false);


        JFrame frame = new JFrame("Catalog of films");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(splitPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}




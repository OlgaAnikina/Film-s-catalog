package view;

import controllers.Controller;

import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class View {

    public View() {

        JTextField searchTermTextField = new JTextField(26);
        JButton filterButton = new JButton("Filter");
        JButton addButton = new JButton("Add film");
        JButton deleteButton = new JButton("Remove film");

        Controller controller = new Controller(searchTermTextField);

        JTable table = new JTable(controller.getTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(200, 200));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);

        table.setModel(controller.getTableModel());

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddFilm addFilm = new AddFilm(controller);
                controller.refreshTableModel();
            }

        });

        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.search(searchTermTextField);

            }

        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int selectedRow = table.getSelectedRow();
                controller.removeData(selectedRow);
            }
        });

        JPanel ctrlPane = new JPanel();
        ctrlPane.add(searchTermTextField);
        ctrlPane.add(filterButton);
        ctrlPane.add(addButton);
        ctrlPane.add(deleteButton);


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




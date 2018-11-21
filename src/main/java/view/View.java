package view;

import controllers.Controller;
import model.Film;
import model.Model;
import model.MyTableModel;
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



        // Create views swing UI components
        JTextField searchTermTextField = new JTextField(26);
        JButton filterButton = new JButton("Filter");
        JButton addButton = new JButton("Add film");
    //    JTable table = new JTable();

        Parser readXMLFile = new Parser();


         //  super(new GridLayout(1, 0));


            ArrayList<Film> list = (ArrayList<Film>) readXMLFile.getFilms();
        // Create table model
        Model model = new Model(list);





           // JTable table = new JTable(new MyTableModel(list));

            JTable table = new JTable(model.getTableModel());
            table.setPreferredScrollableViewportSize(new Dimension(200, 200));
            table.setFillsViewportHeight(true);
       //     table.isCellEditable(0, 0);
            JScrollPane scrollPane = new JScrollPane(table);
//            table.add(scrollPane);


        //table.setModel(model);
        table.setModel(model.getTableModel());


        // Create controller
       // Controller controller = new Controller(searchTermTextField, model);
        Controller controller = new Controller(model);
        filterButton.addActionListener(controller);
        //addButton.addActionListener(controller);
        addButton.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {
              // controller.addFilm(e);
               AddFilm addFilm = new AddFilm(controller);
           }

        });



        // Set the view layout
        JPanel ctrlPane = new JPanel();
        ctrlPane.add(searchTermTextField);
        ctrlPane.add(filterButton);
        ctrlPane.add(addButton);


      //  JScrollPane tableScrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(700, 250));

        scrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "All films", TitledBorder.CENTER, TitledBorder.TOP));


     //   JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tableScrollPane, ctrlPane);
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollPane, ctrlPane);
        splitPane.setDividerLocation(250);
        splitPane.setEnabled(false);



        // Display it all in a scrolling window and make the window appear
        JFrame frame = new JFrame("Catalog of films");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(splitPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}




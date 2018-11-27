package view;

import controllers.Controller;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFilm extends JDialog {
    Controller controller;
    JLabel name = new JLabel("Name: ");
    JLabel styleL = new JLabel("Style: ");
    JLabel dateL = new JLabel("Date of release: ");
    JLabel producerL = new JLabel("Producer's name: ");
    JLabel rankL = new JLabel("Rank: ");
    JTextField namefilm = new JTextField(10);
    JTextField style = new JTextField(10);
    JTextField dateOfRelease = new JTextField(10);
    JTextField producer = new JTextField(10);
    JTextField rank = new JTextField(10);
    JButton add = new JButton("Add");
    JButton cancel = new JButton("Cancel");

    public AddFilm(Controller controller) {
        this.controller = controller;

        JPanel ctrlPane = new JPanel();
        ctrlPane.add(name);
        ctrlPane.add(namefilm);
        ctrlPane.add(styleL);
        ctrlPane.add(style);
        ctrlPane.add(dateL);
        ctrlPane.add(dateOfRelease);
        ctrlPane.add(producerL);
        ctrlPane.add(producer);
        ctrlPane.add(rankL);
        ctrlPane.add(rank);
        add.setEnabled(true);


        JPanel grid = new JPanel(new GridLayout(1, 2, 5, 0));
        grid.add(add);
        grid.add(cancel);

        JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        flow.add(grid);
        add(flow, BorderLayout.SOUTH);
        setVisible(true);

        ctrlPane.add(flow);

        JFrame frame = new JFrame("Catalog of films");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(ctrlPane);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isInputFormValid().equals("")) {
                    controller.addFilm(namefilm, style, dateOfRelease, producer, rank);
                    frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "You don't input " + isInputFormValid());
                }
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setVisible(false);
            }
        });
    }

    private String isInputFormValid() {
        String result = "";

        if (namefilm.getText().isEmpty()) {
            result += "film's name ";
        }
        if (producer.getText().isEmpty()) {
            result += " producer's name ";
        }
        if (style.getText().isEmpty()) {
            result += " style ";
        }
        if (dateOfRelease.getText().isEmpty()) {
            result += " data of release ";
        } else {
            try {
                Integer.parseInt(dateOfRelease.getText());
            } catch (NumberFormatException nfe) {
                result = " correct data of release";
            }
        }
        if (rank.getText().isEmpty()) {
            result += " rank ";
        } else {
            try {
                Integer.parseInt(rank.getText());
            } catch (NumberFormatException nfe) {
                result = " correct rank";
            }
        }
        return result;

    }


}

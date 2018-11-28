package view;

import controllers.Controller;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class AddFilm extends JDialog {
    Controller controller;
    JLabel name = new JLabel("Name:");
    JLabel styleL = new JLabel("Style:");
    JLabel dateL = new JLabel("Date of release:");
    JLabel producerL = new JLabel("Producer's name:");
    JLabel rankL = new JLabel("Rank:               ");
    JTextField namefilm = new JTextField(5);
    JTextField dateOfRelease = new JTextField(5);
    JTextField producer = new JTextField(5);
    JButton add = new JButton("Add");
    JButton cancel = new JButton("Cancel");
    JSlider slider = new JSlider();
    String[] styles = {
            "", "Horror ", "Comedy", "Thriller", "Romance", "Musical"

    };
    JComboBox stylesBox = new JComboBox(styles);

    private void initSlider() {
        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        Hashtable position = new Hashtable();
        position.put(0, new JLabel("0"));
        position.put(10, new JLabel("25"));
        position.put(25, new JLabel("50"));
        position.put(75, new JLabel("75"));
        position.put(100, new JLabel("100"));

        slider.setLabelTable(position);
    }

    public AddFilm(Controller controller) {
        this.controller = controller;
        initSlider();

        JPanel ctrlPane = new JPanel();
        ctrlPane.add(name);
        ctrlPane.add(namefilm);
        ctrlPane.add(producerL);
        ctrlPane.add(producer);
        ctrlPane.add(dateL);
        ctrlPane.add(dateOfRelease);
        ctrlPane.add(styleL);
        ctrlPane.add(stylesBox);
        ctrlPane.add(rankL);
        ctrlPane.add(slider);


        add.setEnabled(true);


        JPanel grid = new JPanel(new GridLayout(1, 0, 0, 0));
        grid.add(add);
        grid.add(cancel);
        ctrlPane.add(grid);

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
                    String rank = "" + slider.getValue();
                    controller.addFilm(namefilm, producer, dateOfRelease, (String) stylesBox.getSelectedItem(), rank);
                    frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "You don't input " + isInputFormValid());
                }
            }
        });

        slider.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                rankL.setText("Rank: " + ((JSlider)e.getSource()).getValue());

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
        if (dateOfRelease.getText().isEmpty()) {
            result += " data of release ";
        } else {
            try {
                Integer.parseInt(dateOfRelease.getText());
            } catch (NumberFormatException nfe) {
                result = " correct data of release";
            }
        }
        if ((stylesBox.getSelectedItem()).equals("")) {
            result += "style";
        }

        return result;

    }


}

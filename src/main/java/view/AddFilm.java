package view;

import controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFilm extends JDialog {
    Controller controller;

    public AddFilm(Controller controller) {
        this.controller = controller;
        JTextField namefilm = new JTextField(10);
        JTextField style = new JTextField(10);
        JTextField dateOfRelease = new JTextField(10);
        JTextField producer = new JTextField(10);
        JTextField rank = new JTextField(10);
        JPanel ctrlPane = new JPanel();

        ctrlPane.add(namefilm);
        ctrlPane.add(style);
        ctrlPane.add(dateOfRelease);
        ctrlPane.add(producer);
        ctrlPane.add(rank);
        JButton add = new JButton("Add");
        JButton cancel = new JButton("Cancel");
        add.setEnabled(false);

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
                if (isEmpty(namefilm, style)){add.setEnabled(true);}

                controller.addFilm(namefilm, style, dateOfRelease, producer);
                frame.setVisible(false);
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setVisible(false);
            }
        });
    }

    private boolean isEmpty (JTextField name, JTextField style ){
        if (name.getText().equals("") || style.getText().equals("")) return false;
        else return true;
    }


}

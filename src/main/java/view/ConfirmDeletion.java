package view;

import controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmDeletion extends JDialog {
    int selectRow;
    Controller controller;
    public ConfirmDeletion(JFrame owner)
    {
        super(owner, "Confirm the deletion", true);
        super.setLocationRelativeTo(null);

        add(new JLabel(
                        "Do you really want to remove this movie from the catalog?"),
                BorderLayout.CENTER);

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setVisible(false);
            }
        });

        JButton ok = new JButton("Ok");
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                controller.removeData(selectRow);
                setVisible(false);
            }
        });


        JPanel panel = new JPanel();
        panel.add(ok);
        panel.add(cancel);
        add(panel, BorderLayout.SOUTH);
        setSize(400, 200);
    }

    public void setRow(int selectRow, Controller controller) {
        this.selectRow = selectRow;
        this.controller = controller;

    }
}

package controllers;

import model.Model;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Controller implements ActionListener {

    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,
                "Search film", "Error",
                JOptionPane.ERROR_MESSAGE);
    }


    public void addFilm(ActionEvent e) {

        JOptionPane.showMessageDialog(null,
                "Hello ", "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public void addFilm(JTextField nameFilm, JTextField style,
                        JTextField dataOfRelease, JTextField producer, JTextField rank) {
        model.addFilm(nameFilm, style, dataOfRelease, producer, rank);
    }


}

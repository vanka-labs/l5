package com.company;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame implements ActionListener {
    protected static JLabel empty = new JLabel("");
    private JButton show = new JButton("Show");
    private JButton edit = new JButton("Input series");
    private JButton sum = new JButton("Sum");
    private JButton save = new JButton("Save in output.txt");
    private JRadioButton but1 = new JRadioButton("Liner");
    private JRadioButton but2 = new JRadioButton("Exponential");
    private Liner a;
    private Exponential b;

    public Frame(String title, Liner a, Exponential b) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
        this.a = a;
        this.b = b;

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2, 2));
        ButtonGroup group = new ButtonGroup();
        group.add(but1);
        group.add(but2);
        container.add(but1);
        but1.setSelected(true);
        container.add(but2);
        container.add(save);
        save.addActionListener(this);
        show.addActionListener(this);
        container.add(show);
        edit.addActionListener(this);
        container.add(edit);
        container.add(sum);
        sum.addActionListener(this);
        pack();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == show) {
            String title = but1.isSelected() ? but1.getText() : but2.getText();
            String message = but1.isSelected() ? a.toString() : b.toString();
            JOptionPane.showMessageDialog(this, message, title, JOptionPane.PLAIN_MESSAGE);
        } else if (e.getSource() == edit)
            new Dialog(this, but1.isSelected() ? but1.getText() : but2.getText(), but1.isSelected() ? a : b);
        else if (e.getSource() == sum) {
            StringBuffer s1 = new StringBuffer();
            StringBuffer s2 = new StringBuffer();
            s1.append(a.sum());
            s2.append(b.sum());
            String message = but1.isSelected() ? s1.toString() : s2.toString();
            String title = but1.isSelected() ? but1.getText() : but2.getText();
            JOptionPane.showMessageDialog(this, message, title, JOptionPane.PLAIN_MESSAGE);
        }
        else if (e.getSource() == save) {

                if (but1.isSelected())
                    a.save();
                else
                    b.save();

        }

    }
}


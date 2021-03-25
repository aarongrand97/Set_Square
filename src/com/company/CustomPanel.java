package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

// BASE CLASS FOR THE SQUARES IN THE GRID
public class CustomPanel extends JPanel {
    JTextField tf;
    public CustomPanel(){
        this.setEnabled(true);
        this.setPreferredSize(new Dimension(50, 50));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }

    protected void addTextField(Color color){
        // need text field to display the number/operator
        tf = new JTextField(){
            // no border
            @Override public void setBorder(Border border) {

            }
        };
        // general appearance of text
        tf.setPreferredSize(new Dimension(40,40));
        tf.setFont(new Font("SansSerif", Font.BOLD, 20));
        tf.setHorizontalAlignment(JTextField.CENTER);
        tf.setBackground(color);
        this.add(tf);
    }
}

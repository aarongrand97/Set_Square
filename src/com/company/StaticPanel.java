package com.company;

import java.awt.*;

public class StaticPanel extends CustomPanel {
    // EQUAL SIGN FLAGS WHETHER PANEL SHOULD SHOW '='
    public StaticPanel(boolean equalSign){
        super();
        this.setBackground(Color.GRAY);
        if(equalSign){
            addTextField(Color.GRAY);
            tf.setText("=");
            tf.setEditable(false);
        }
    }
}

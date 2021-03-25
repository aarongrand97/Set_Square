package com.company;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OperatorPanel extends CustomPanel{
    String[] operatorCycleArray = {"+", "-", "*", "/"}; // cycles through these when clicked
    int currentOperatorIndex = -1;
    public OperatorPanel(){
        super();
        this.setBackground(Color.YELLOW);
        addTextField(Color.YELLOW);
        tf.getCaret().setVisible(false);

        tf.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentOperatorIndex += 1;
                currentOperatorIndex %= 4;
                tf.setText(operatorCycleArray[currentOperatorIndex]);
                tf.getCaret().setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

}

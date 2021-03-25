package com.company;

import javax.swing.*;
import java.awt.*;

// PANEL THAT HOLDS THE GRID
public class GridPanel extends JPanel {
    CustomPanel[][] panelHolder = new CustomPanel[7][7]; // use to store the panels in order when creating grid

    public GridPanel() {

        setLayout(new GridLayout(7, 7));

        storePanelTypes();

        for (int row = 0; row < 7; row++) {
            for(int col = 0; col < 7; col++){
                add(panelHolder[row][col]);
            }

        }
    }

    // SET THE PANEL TYPE (NUMBER/OPERATOR/STATIC) AND STORE TO BE PUT IN IN ORDER
    private void storePanelTypes(){
        /*
          0 1 2 3 4 5 6
        0 N|O|N|O|N|S|N
        1 O|S|O|S|O|S|S
        2 N|O|N|O|N|S|N
        3 O|S|O|S|O|S|S
        4 N|O|N|O|N|S|N
        5 S|S|S|S|S|S|S
        6 N|S|N|S|N|S|S
         */
        for(int row = 0; row < 5; row++){
            if(row % 2 == 0) {
                for (int col = 0; col < 7; col++) {
                    if (col % 2 == 0) {
                        panelHolder[row][col] = new NumberPanel();
                    } else if (col < 4) {
                        panelHolder[row][col] = new OperatorPanel();
                    } else {
                        panelHolder[row][col] = new StaticPanel(true);
                    }
                }
            }
            else{
                for (int col = 0; col < 7; col++) {
                    if(col % 2 == 0 && col < 5){
                        panelHolder[row][col] = new OperatorPanel();
                    }
                    else{
                        panelHolder[row][col] = new StaticPanel(false);
                    }
                }
            }
        }
        for(int col = 0; col < 7; col++){
            if(col < 5 && col % 2 ==0){
                panelHolder[5][col] = new StaticPanel(true);
                panelHolder[6][col] = new NumberPanel();

            }
            else{
                panelHolder[5][col] = new StaticPanel(false);
                panelHolder[6][col] = new StaticPanel(false);
            }
        }
    }

    // RETURN THE GRID VALUES
    public int[][] getGrid(){
        int[][] ret = new int[3][3];

        for(int row = 0; row < 5; row += 2){
            for(int col = 0; col < 5; col += 2){
                String str = panelHolder[row][col].tf.getText();
                if(!str.isEmpty()) {
                    ret[row/2][col/2] = Integer.valueOf(str);
                }
            }
        }

        return ret;
    }

    // GET THE TARGET VALUES FOR EACH ROW
    public int[] getRowValues(){
        int[] ret = new int[3];
        for(int row = 0; row < 5; row += 2){
            String str = panelHolder[row][6].tf.getText();
            ret[row/2] = Integer.valueOf(str);
        }
        return ret;
    }
    // GET THE TARGET VALUES FOR EACH COLUMN
    public int[] getColValues() {
        int [] ret = new int[3];
        for(int col = 0; col < 5; col+=2){
            String str = panelHolder[6][col].tf.getText();
            ret[col/2] = Integer.valueOf(str);
        }
        return ret;
    }

    public Operator[][] getRowOperators() {
        Operator[][] ret = new Operator[3][2];
        for(int row = 0; row < 5; row += 2){
            ret[row/2][0] = convertStringToOperator(panelHolder[row][1].tf.getText());
            ret[row/2][1] = convertStringToOperator(panelHolder[row][3].tf.getText());
        }
        return ret;
    }

    public Operator[][] getColOperators() {
        Operator[][] ret  = new Operator[2][3];
        for(int col = 0; col < 5; col += 2){
            ret[0][col/2] = convertStringToOperator(panelHolder[1][col].tf.getText());
            ret[1][col/2] = convertStringToOperator(panelHolder[3][col].tf.getText());
        }
        return ret;
    }

    private Operator convertStringToOperator(String str){
        switch (str)
        {
            case "+":
                return Operator.ADDITION;
            case "-":
                return Operator.SUBTRACTION;
            case "*":
                return Operator.MULTIPLY;
            case "/":
                return Operator.DIVIDE;
        }

        return null;
    }

    // SET GRID VALUES GIVEN AN ARRAY
    public void setGrid(int[][] grid) {
        for(int row = 0; row < 5; row += 2){
            for(int col = 0; col < 5; col += 2){
                panelHolder[row][col].tf.setText(Integer.toString(grid[row/2][col/2]));
            }
        }
    }
}


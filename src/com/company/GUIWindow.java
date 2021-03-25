package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIWindow extends JPanel{

    JButton solveButton = new JButton("SOLVE");
    GridBagConstraints gbc = new GridBagConstraints();
    GridPanel grid = new GridPanel();

    GUIWindow(){
        setLayout(new GridBagLayout());

        gbc.insets = new Insets(10,10,10,10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(grid, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(solveButton, gbc);

        solveButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int[][] gridVals = grid.getGrid();      // gets the values within the grid
                int[] rowVals = grid.getRowValues();    // gets the target values for each row
                int[] colVals = grid.getColValues();    // gets the target values for each column
                Operator[][] rowOperators = grid.getRowOperators(); // get the operators for each row
                Operator[][] colOperators = grid.getColOperators(); // get the operators for each column

                // create the solver and solve
                Solver solver = new Solver(gridVals, rowVals, colVals, rowOperators, colOperators);
                solver.solve();

                // display the solution
                grid.setGrid(solver.grid);
            }
        });
    }
}

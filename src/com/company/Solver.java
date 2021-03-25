package com.company;

import java.util.ArrayList;

public class Solver {
    int[][] grid;
    int[] rowValues; int[] colValues;
    Operator[][] rowOperators; Operator[][] colOperators;

    public Solver(int[][] grid, int[] rowValues, int[] colValues,
                  Operator[][] rowOperators, Operator[][] colOperators){
        this.grid = grid;
        this.rowValues = rowValues;
        this.colValues = colValues;
        this.rowOperators = rowOperators;
        this.colOperators = colOperators;
    }

    // CALLED RECURSIVELY
    public boolean solve(){
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                if(grid[row][col] == 0){
                    for(int number = 1; number <= 9; number++){
                        if(isAllowed(number, row, col)){
                            grid[row][col] = number;
                            if(solve()){
                                return true;
                            }
                            else{
                                grid[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isAllowed(int number, int row, int col){
        if(gridContainsNumber(number)){ // check if grid already has number in it
            return false;
        }
        else if(calculationIsIllegal(number, row, col)){ // check if the calculation is okay
            return false;
        }
        return true;
    }

    // check if grid already has number in it
    private boolean gridContainsNumber(int number){
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++) {
                if(grid[row][col] == number){
                    return true;
                }
            }
        }
        return false;
    }

    // CHECK ROW/COL CALCULATES CORRECTLY
    private boolean calculationIsIllegal(int number, int row, int col){
        if(!checkRowIncomplete(row)){ // if row not filled out, don't check the row calculation
            if(rowCalculationIsIllegal(number, row, col)){ // if number not okay in row, calculation is illegal
                return true;
            }
        }
        if(!checkColIncomplete(col)){ // if col not filled out, don't check the col calculation
            if(colCalculationIsIllegal(number, row, col)){
                return true;
            }
        }
        return false;
    }

    // check if row is incomplete, if input will complete the row, return false
    private boolean checkRowIncomplete(int row){
        for(int i = 0; i < 2; i++){
            if(grid[row][i] == 0){
                return true;
            }
        }
        return false;
    }
    // check if col is incomplete, if input will complete the col, return false
    private boolean checkColIncomplete(int col){
        for(int i = 0; i < 2; i++){
            if(grid[i][col] == 0){
                return true;
            }
        }
        return false;
    }

    private boolean rowCalculationIsIllegal(int number, int row, int col){
        int a = grid[row][0];
        int b = grid[row][1];
        int c = grid[row][2];
        // there will be a blank so need to find out where we are prospectively placing a number
        if(col == 0){
            a = number;
        }
        else if(col == 1){
            b = number;
        }
        else{
            c = number;
        }
        int temp = rowOperators[row][0].apply(a, b);
        int calc = rowOperators[row][1].apply(temp,c);
        if(calc == rowValues[row]){
            return false;
        }
        else{
            return true;
        }
    }

    private boolean colCalculationIsIllegal(int number, int row, int col){
        int a = grid[0][col];
        int b = grid[1][col];
        int c = grid[2][col];
        // there will be a blank so need to find out where we are prospectively placing a number
        if(row == 0){
            a = number;
        }
        else if(row == 1){
            b = number;
        }
        else{
            c = number;
        }
        int temp = colOperators[0][col].apply(a, b);
        int calc = colOperators[1][col].apply(temp,c);
        if(calc == colValues[col]){
            return false;
        }
        else{
            return true;
        }
    }
}

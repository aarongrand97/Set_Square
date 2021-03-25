package com.company;

public enum Operator {
    ADDITION() {
        @Override public int apply(int x1, int x2) {
            return x1 + x2;
        }
    },
    SUBTRACTION() {
        @Override public int apply(int x1, int x2) {
            return x1 - x2;
        }
    },
    MULTIPLY(){
        @Override public int apply(int x1, int x2){
            return x1 * x2;
        }
    },
    DIVIDE(){
        @Override public int apply(int x1, int x2){
            return x1 / x2;
        }
    };



    private Operator() {

    }

    // ABSTRACT METHOD TO DO THE MATHS GIVEN TWO NUMBERS
    public abstract int apply(int x1, int x2);

}

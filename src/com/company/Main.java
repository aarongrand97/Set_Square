package com.company;

import javax.swing.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Create UI window
        GUIWindow window = new GUIWindow();
        JFrame jf = new JFrame();
        jf.setTitle("Set Square Solver");
        jf.setSize(500,500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.add(window);
        
    }

}

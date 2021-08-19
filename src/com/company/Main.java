package com.company;

import javax.swing.*;

public class Main extends JFrame {

    public Main(){
        super.setTitle("Chicken Screensaver");
        super.setSize(900, 600);
        super.setLocation(100, 50);
        super.add(new Contents());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    public static void main(String[] args) {
	// write your code here
        new Main();

    }
}

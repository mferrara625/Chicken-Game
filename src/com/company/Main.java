package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Main extends JFrame {



    public Main(){
        super.setTitle("Chicken Game - Get to the other side!");
        super.setSize(900, 600);
        super.setLocation(100, 50);
        super.add(new Contents());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);

    }

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();

        Contents.button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Contents.xV == 3){
                    Contents.xV = -3;
                } else if (Contents.xV == -3 || Contents.xV == 0){
                    Contents.xV = 3;
                }
            }
        });
    }
}

package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Contents extends JPanel implements ActionListener {

    private Image image;
    private int x = 100, y = 100;
    private Timer t;

    public Contents(){
        super.setDoubleBuffered(true);
        t = new Timer(7, this);
        t.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ImageIcon ii = new ImageIcon(this.getClass().getResource("chicken.png"));
        image = ii.getImage();
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, x, y, this);
    }

    int xV = 1;
    int yV = 1;

    public void move(){
        x = x + xV;
        y = y + yV;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();

        if(x == 0){
            xV = 1;
        } else if (x == 770){
            xV = -1;
        }

        if(y == 0){
            yV = 1;
        } else if (y == 450){
            yV = -1;
        }

        repaint();
    }
}

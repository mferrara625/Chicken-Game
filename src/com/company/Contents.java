package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Contents extends JPanel implements ActionListener {

    private Image image;
    private int x = 100, y = 200, z = 0;
    int randNum;
    int randX = (int)((Math.random()*500) + 200);
    int score = 0;
    boolean reachedEnd;

    private Timer t;
    static JButton button = new JButton("⇄");

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
        button.setBounds(800, 475, 50, 50);
        add(button);
        g2d.drawString("Score: " + score, 800, 25);
        randNum = (int) (Math.random() * 4);
        if(randNum == 2)
            g2d.fillRect(randX, z, 50, 50);
    }

    public static int xV = 1;
    public static int yV = 0;
    public static int zV = 5;

    public void move(){
        x = x + xV;
        y = y + yV;
        if(randNum == 2)
        z = z + zV;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();

        if(x == 0){
            xV = 1;
            if(reachedEnd)
            score += 50;
            reachedEnd = false;
        } else if (x == 770){
            xV = -1;
            if(!reachedEnd)
            score += 50;
            reachedEnd = true;
        }

        if(y == 0){
            yV = 1;
        } else if (y == 450){
            yV = -1;
        }

        if(z == 600){
            z = 0;
            randX = (int)((Math.random()*500) + 200);
        }

        if(randX >= x - 25 && randX <= x + 100 && z >= y - 25 && z <= y + 100){
            yV = 0;
            xV = 0;
            score--;
        }

        repaint();
    }
}
package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Contents extends JPanel implements ActionListener {

    private Image image;
    private int x = 100, y = 300, z = 0;
    int randNum = (int) (Math.random() * 4);
    int randX = (int)((Math.random()*450) + 200);
    int score = 0;
    int eggsCollected = 0;
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
        g2d.drawRect(200, -1, 500, 600);
        g2d.drawLine(450, 0, 450, 50);
        g2d.drawLine(450, 100, 450, 150);
        g2d.drawLine(450, 200, 450, 250);
        g2d.drawLine(450, 300, 450, 350);
        g2d.drawLine(450, 400, 450, 450);
        g2d.drawLine(450, 500, 450, 550);
        g2d.drawImage(image, x, y, this);
        button.setBounds(800, 475, 50, 50);
        add(button);
        g2d.drawString("Score: " + score, 800, 25);
        g2d.drawString("Eggs Collected: " + eggsCollected, 780, 45);
        if(randNum == 2)
            g2d.fillRect(randX, z, 50, 50);
        if(!reachedEnd) {
            g2d.setColor(Color.red);
            g2d.fillRect(875, 300, 25, 100);
        }
            else if(reachedEnd){
                g2d.setColor(Color.red);
                g2d.fillRect(0, 300, 12, 100);
                g2d.setColor(Color.black);
                g2d.drawOval(x + 120, 330, 15, 25);
            }

    }

    public static int xV = 2;
    public static int yV = 0;
    public static int zV = 4;

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
            xV = 2;
            if(reachedEnd)
            score += 50;
            eggsCollected++;
            reachedEnd = false;
        } else if (x == 770){
            xV = -2;
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
            randX = (int)((Math.random()*450) + 200);
        }

        if(randX >= x - 25 && randX <= x + 100 && z >= y - 25 && z <= y + 100){
            yV = 0;
            xV = 0;
            if(reachedEnd){
                reachedEnd = false;
            }
            score--;
        }

        if(z == 0){
            randNum = (int) (Math.random() * 4);
        }

        repaint();
    }
}
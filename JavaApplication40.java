package javaapplication40;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JavaApplication40 extends JPanel implements Runnable {

    private int x = 0;
    private int velx = 5;
    private int vely = 3;
    private int rightBound = 540;
    private int bottomBound = 540;
    private int y = 0;

    public void paint(Graphics g) {
        g.setColor(Color.blue);
       
       g.fillOval(x, y, 60, 60);
   
        
    }
    public void move(){
         x += velx;
          y +=vely;
          if(x<0){
              x = 0;
             velx = -velx;
          }
          else if(x >rightBound){
            x = rightBound;
            velx= -velx;
        }
          if(y<0){
              y= 0;
              vely= -vely;
          }
          else if(y >bottomBound){
            y = bottomBound;
            vely= -vely;
        }

    }
    ActionListener listener = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
           // if(x != 540 && y !=540){
           // x +=5;
          //  y +=5;
          //  System.out.println(x + " " + y);
          move();
         repaint();
           
        }
    };

    public JavaApplication40() {

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                System.out.println(me);
                Timer timer = new Timer(20, listener);
                timer.start();
            }
        });

    }

    public static void main(String[] args) {
      Thread test = new Thread(new JavaApplication40());
      test.start();
    }

    @Override
    public void run() {
          JFrame frame = new JFrame();
        frame.getContentPane().add(new JavaApplication40());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
       // frame.setBounds(600, 600, 600, 600);
        frame.setVisible(true);
    }
}

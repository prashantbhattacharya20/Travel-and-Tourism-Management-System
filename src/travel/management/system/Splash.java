package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements  Runnable{
    Thread thread;
    Splash() {
//        setSize(1200, 600);
//        setLocation(200, 100);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image img = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img);
        JLabel image = new JLabel(i2);
        add(image);

        setVisible(true);
        thread = new Thread(this);
        thread.start();
    }

    public void run(){
        try {
            Thread.sleep(5000);
            new Login();
            setVisible(false);
        } catch (Exception e){

        }
    }

    public static void main(String[] args){
       Splash frame =  new Splash();

       int x = 1;
       for(int i = 1; i <= 500; x+=7, i+=6){
           frame.setLocation(750 - (x + i)/2,400 - (i/2));
           frame.setSize(x + i, i);
           try {
               Thread.sleep(10);
           } catch (Exception e) {}

       }


    }
}

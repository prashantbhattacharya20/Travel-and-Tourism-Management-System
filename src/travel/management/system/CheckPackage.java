package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame {

    CheckPackage(){
        setBounds(450,200,900,600);

        String[] package1 = {"SILVER PACKAGE", "4 Days and 5 Nights", "Airport Assistance", "Half Day City Tour", "Daily Lunch Buffet", "Welcome Drinks On Arrival", "Stay in 4 Star Hotel", "Any One Sports Activity", "BOOK NOW", "Rs 18000/-", "package1.jpg"};
        String[] package2 = {"GOLD PACKAGE", "5 Days and 6 Nights", "Meet and Greet in Airport", "Full Day Tour and Sightseeing", "All Meals Buffet", "Welcome Drinks On Arrival", "Stay in 5 Star Hotel", "Five Sports Activity Combo", "BOOK NOW", "Rs 32000/-", "package2.jpg"};
        String[] package3 = {"PLATINUM PACKAGE", "6 Days and 7 Nights", "Return Airfare", "Free Clubbing", "All Meals Buffet with Drinks", "Welcome Drinks On Arrival", "Stay in 5 Star Resort", "Night Safari with 5 Sports Activity", "BOOK NOW", "Rs 50000/-", "package3.jpg"};

        JTabbedPane tab = new JTabbedPane();
        JPanel p1 = createPackage(package1);
        tab.addTab("Silver Package",null,p1);

        JPanel p2 = createPackage(package2);
        tab.addTab("Gold Package",null,p2);

        JPanel p3 = createPackage(package3);
        tab.addTab("Platinum Package",null,p3);

        add(tab);

        setVisible(true);
    }

    public JPanel createPackage(String[] pack) {
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.white);

        JLabel l1 = new JLabel(pack[0]);
        l1.setBounds(40,5,500,50);
        l1.setForeground(new Color(107, 107, 107));
        l1.setFont(new Font("Tahoma", Font.BOLD,40));
        p1.add(l1);

        JLabel l2 = new JLabel(pack[1]);
        l2.setBounds(30,85,300,30);
        l2.setForeground(new Color(250, 0, 0));
        l2.setFont(new Font("Tahoma", Font.BOLD,20));
        p1.add(l2);

        JLabel l3 = new JLabel(pack[2]);
        l3.setBounds(30,135,300,30);
        l3.setForeground(new Color(0, 71, 231));
        l3.setFont(new Font("Tahoma", Font.BOLD,20));
        p1.add(l3);

        JLabel l4 = new JLabel(pack[3]);
        l4.setBounds(30,185,330,30);
        l4.setForeground(new Color(250, 0, 0));
        l4.setFont(new Font("Tahoma", Font.BOLD,20));
        p1.add(l4);

        JLabel l5 = new JLabel(pack[4]);
        l5.setBounds(30,235,300,30);
        l5.setForeground(new Color(0, 71, 231));
        l5.setFont(new Font("Tahoma", Font.BOLD,20));
        p1.add(l5);

        JLabel l6 = new JLabel(pack[5]);
        l6.setBounds(30,285,300,30);
        l6.setForeground(new Color(250, 0, 0));
        l6.setFont(new Font("Tahoma", Font.BOLD,20));
        p1.add(l6);

        JLabel l7 = new JLabel(pack[6]);
        l7.setBounds(30,335,300,30);
        l7.setForeground(new Color(0, 71, 231));
        l7.setFont(new Font("Tahoma", Font.BOLD,20));
        p1.add(l7);

        JLabel l8 = new JLabel(pack[7]);
        l8.setBounds(30,385,400,30);
        l8.setForeground(new Color(250, 0, 0));
        l8.setFont(new Font("Tahoma", Font.BOLD,20));
        p1.add(l8);

        JLabel l9 = new JLabel(pack[8]);
        l9.setBounds(30,450,300,35);
        l9.setForeground(new Color(0, 71, 231));
        l9.setFont(new Font("Tahoma", Font.BOLD,30));
        p1.add(l9);

        JLabel l10 = new JLabel(pack[9]);
        l10.setBounds(680,475,300,35);
        l10.setForeground(new Color(250, 0, 0));
        l10.setFont(new Font("Tahoma", Font.BOLD,30));
        p1.add(l10);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/" + pack[10]));
        Image img = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img);
        JLabel image = new JLabel(i2);
        image.setBounds(350,90,500,300);
        p1.add(image);

        return p1;
    }

    public static void main(String[] args){
        new CheckPackage();
    }
}

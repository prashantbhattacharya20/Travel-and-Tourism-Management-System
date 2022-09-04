package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener {

    JButton pay, back;

    Payment(){
        setBounds(215,120,1074,600);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpg"));
        Image img = i1.getImage().getScaledInstance(1074,600,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img);
        JLabel image = new JLabel(i2);
        image.setBounds(0,0,1074,600);
        add(image);

        pay = new JButton("Pay");
        pay.setBounds(460,0,80,40);
        pay.setBorder(BorderFactory.createEmptyBorder());
        pay.addActionListener(this);
        image.add(pay);

        back = new JButton("Back");
        back.setBounds(560,0,80,40);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(this);
        image.add(back);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == pay){
            setVisible(false);
            new Paytm();
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new Payment();
    }
}

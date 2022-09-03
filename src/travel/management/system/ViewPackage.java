package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class ViewPackage extends JFrame implements ActionListener {

    JButton back;
    JLabel labelUsername, labelPackage, labelTotalPersons, labelId, labelNumber, labelPhone, labelPrice;
    String username;
    ViewPackage(String username){
        this.username = username;

        setBounds(450,200,900,450);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD,25));
        text.setBounds(270,0,380,35);
        add(text);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30,50,150,25);
        add(lblUsername);

        labelUsername = new JLabel();
        labelUsername.setBounds(220,50,150,25);
        add(labelUsername);

        JLabel lblPackage = new JLabel("Package");
        lblPackage.setBounds(30,90,150,25);
        add(lblPackage);

        labelPackage = new JLabel();
        labelPackage.setBounds(220,90,150,25);
        add(labelPackage);

        JLabel lblTotalPersons = new JLabel("Total Persons");
        lblTotalPersons.setBounds(30,130,150,25);
        add(lblTotalPersons);

        labelTotalPersons = new JLabel();
        labelTotalPersons.setBounds(220,130,150,25);
        add(labelTotalPersons);

        JLabel lblId = new JLabel("Id");
        lblId.setBounds(30,170,150,25);
        add(lblId);

        labelId = new JLabel();
        labelId.setBounds(220,170,150,25);
        add(labelId);

        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(30,210,150,25);
        add(lblNumber);

        labelNumber = new JLabel();
        labelNumber.setBounds(220,210,150,25);
        add(labelNumber);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(30,250,150,25);
        add(lblPhone);

        labelPhone = new JLabel();
        labelPhone.setBounds(220,250,150,25);
        add(labelPhone);

        JLabel lblPrice = new JLabel("Price");
        lblPrice.setBounds(30,290,150,25);
        add(lblPrice);

        labelPrice = new JLabel();
        labelPrice.setBounds(220,290,150,25);
        add(labelPrice);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(130,350,100,25);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookDetails.jpg"));
        Image img = i1.getImage().getScaledInstance(445,250, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img);
        JLabel image = new JLabel(i2);
        image.setBounds(400,65,445,250);
        add(image);

        try{
            Conn c = new Conn();
            String query = "select * from bookpackage where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);

            while(rs.next()){
                labelUsername.setText(rs.getString("username"));
                labelId.setText(rs.getString("id"));
                labelNumber.setText(rs.getString("number"));
                labelPackage.setText(rs.getString("package"));
                labelTotalPersons.setText(rs.getString("persons"));
                labelPhone.setText(rs.getString("phone"));
                labelPrice.setText(rs.getString("price"));
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
        }
    }


    public static void main(String[] args){
        new ViewPackage("");
    }
}

package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class ViewBookedHotel extends JFrame implements ActionListener {

    JButton back;
    JLabel labelUsername, labelHotel, labelTotalPersons, labelDays, labelAc, labelFood, labelId, labelNumber, labelPhone, labelPrice;
    String username;
    ViewBookedHotel(String username){
        this.username = username;

        setBounds(450,200,1000,600);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD,25));
        text.setBounds(270,0,500,35);
        add(text);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30,50,150,25);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD,15));
        add(lblUsername);

        labelUsername = new JLabel();
        labelUsername.setBounds(220,50,150,25);
        labelUsername.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelUsername);

        JLabel lblHotel = new JLabel("Hotel Name");
        lblHotel.setBounds(30,90,150,25);
        lblHotel.setFont(new Font("Tahoma", Font.BOLD,15));
        add(lblHotel);

        labelHotel = new JLabel();
        labelHotel.setBounds(220,90,150,25);
        labelHotel.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelHotel);

        JLabel lblTotalPersons = new JLabel("Total Persons");
        lblTotalPersons.setBounds(30,130,150,25);
        lblTotalPersons.setFont(new Font("Tahoma", Font.BOLD,15));
        add(lblTotalPersons);

        labelTotalPersons = new JLabel();
        labelTotalPersons.setBounds(220,130,150,25);
        labelTotalPersons.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelTotalPersons);

        JLabel lblDays = new JLabel("Total No. of Days");
        lblDays.setBounds(30,170,150,25);
        lblDays.setFont(new Font("Tahoma", Font.BOLD,15));
        add(lblDays);

        labelDays = new JLabel();
        labelDays.setBounds(220,170,150,25);
        labelDays.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelDays);

        JLabel lblAc = new JLabel("AC/ Non-AC Room");
        lblAc.setBounds(30,210,150,25);
        lblAc.setFont(new Font("Tahoma", Font.BOLD,15));
        add(lblAc);

        labelAc = new JLabel();
        labelAc.setBounds(220,210,150,25);
        labelAc.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelAc);

        JLabel lblFood = new JLabel("Food Included");
        lblFood.setBounds(30,250,150,25);
        lblFood.setFont(new Font("Tahoma", Font.BOLD,15));
        add(lblFood);

        labelFood = new JLabel();
        labelFood.setBounds(220,250,150,25);
        labelFood.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelFood);

        JLabel lblId = new JLabel("ID");
        lblId.setBounds(30,290,150,25);
        lblId.setFont(new Font("Tahoma", Font.BOLD,15));
        add(lblId);

        labelId = new JLabel();
        labelId.setBounds(220,290,150,25);
        labelId.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelId);

        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(30,330,150,25);
        lblNumber.setFont(new Font("Tahoma", Font.BOLD,15));
        add(lblNumber);

        labelNumber = new JLabel();
        labelNumber.setBounds(220,330,150,25);
        labelNumber.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelNumber);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(30,370,150,25);
        lblPhone.setFont(new Font("Tahoma", Font.BOLD,15));
        add(lblPhone);

        labelPhone = new JLabel();
        labelPhone.setBounds(220,370,150,25);
        labelPhone.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelPhone);

        JLabel lblPrice = new JLabel("Total Cost");
        lblPrice.setBounds(30,410,150,25);
        lblPrice.setFont(new Font("Tahoma", Font.BOLD,15));
        add(lblPrice);

        labelPrice = new JLabel();
        labelPrice.setBounds(220,410,150,25);
        labelPrice.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelPrice);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(130,480,100,25);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel5.jpg"));
        Image img = i1.getImage().getScaledInstance(495,280, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img);
        JLabel image = new JLabel(i2);
        image.setBounds(430,85,495,280);
        add(image);

        try{
            Conn c = new Conn();
            String query = "select * from bookhotel where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);

            while(rs.next()){
                labelUsername.setText(rs.getString("username"));
                labelHotel.setText(rs.getString("name"));
                labelTotalPersons.setText(rs.getString("persons"));
                labelDays.setText(rs.getString("days"));
                labelAc.setText(rs.getString("ac"));
                labelFood.setText(rs.getString("food"));
                labelId.setText(rs.getString("id"));
                labelNumber.setText(rs.getString("number"));
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
        new ViewBookedHotel("");
    }
}

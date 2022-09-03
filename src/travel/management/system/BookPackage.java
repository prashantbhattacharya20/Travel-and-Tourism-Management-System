package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener {

    JLabel labelUsername, labelId, labelNumber, labelPhone, labelPrice;
    JComboBox selectPack;
    JTextField tfTotalPersons;

    JButton checkPrice, bookPackage, back;
    String username;
    BookPackage(String username) {
        this.username = username;

        setBounds(350,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(350,10,200,35);
        text.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(text);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(40,70,150,25);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblUsername);

        labelUsername = new JLabel();
        labelUsername.setBounds(250,70,150,25);
        labelUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelUsername);

        JLabel selectPackage = new JLabel("Select Package");
        selectPackage.setBounds(40,110,150,25);
        selectPackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(selectPackage);

        selectPack = new JComboBox(new String [] {"SILVER PACKAGE", "GOLD PACKAGE", "PLATINUM PACKAGE"});
        selectPack.setBounds(250,110,150,25);
        selectPack.setBackground(Color.white);
        add(selectPack);

        JLabel totalPersons = new JLabel("Total Persons");
        totalPersons.setBounds(40,150,150,25);
        totalPersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(totalPersons);

        tfTotalPersons = new JTextField("1");
        tfTotalPersons.setBounds(250,150,150,25);
        add(tfTotalPersons);

        JLabel lblId = new JLabel("Id");
        lblId.setBounds(40,190,150,25);
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblId);

        labelId = new JLabel();
        labelId.setBounds(250,190,150,25);
        labelId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelId);

        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(40,230,150,25);
        lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblNumber);

        labelNumber = new JLabel();
        labelNumber.setBounds(250,230,150,25);
        labelNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelNumber);

        JLabel lblPhone = new JLabel("Phone Number");
        lblPhone.setBounds(40,270,150,25);
        lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblPhone);

        labelPhone = new JLabel();
        labelPhone.setBounds(250,270,150,25);
        labelPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelPhone);

        JLabel totalPrice = new JLabel("Total Price");
        totalPrice.setBounds(40,310,150,25);
        totalPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(totalPrice);

        labelPrice = new JLabel();
        labelPrice.setBounds(250,310,150,25);
        labelPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelPrice);

        checkPrice = new JButton("Check Price");
        checkPrice.setBackground(Color.BLACK);
        checkPrice.setForeground(Color.white);
        checkPrice.setBorder(BorderFactory.createEmptyBorder());
        checkPrice.setBounds(50,370,100,25);
        checkPrice.addActionListener(this);
        add(checkPrice);

        bookPackage = new JButton("Book Package");
        bookPackage.setBackground(Color.BLACK);
        bookPackage.setForeground(Color.white);
        bookPackage.setBorder(BorderFactory.createEmptyBorder());
        bookPackage.setBounds(220,370,100,25);
        bookPackage.addActionListener(this);
        add(bookPackage);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setBounds(390,370,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image img = i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img);
        JLabel image = new JLabel(i2);
        image.setBounds(530,70,500,300);
        add(image);

        try{
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);

            while(rs.next()){
                labelUsername.setText(rs.getString("username"));
                labelId.setText(rs.getString("id"));
                labelNumber.setText(rs.getString("number"));
                labelPhone.setText(rs.getString("phone"));
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkPrice){
            String pack = (String) selectPack.getSelectedItem();
            if(pack.equals("SILVER PACKAGE")) {
                int cost = 0;
                cost = Integer.parseInt(tfTotalPersons.getText()) * 18000;
                labelPrice.setText("Rs " + String.valueOf(cost));
            } else if (pack.equals("GOLD PACKAGE")) {
                int cost = 0;
                cost = Integer.parseInt(tfTotalPersons.getText()) * 32000;
                labelPrice.setText("Rs " + String.valueOf(cost));
            } else {
                int cost = 0;
                cost = Integer.parseInt(tfTotalPersons.getText()) * 50000;
                labelPrice.setText("Rs " + String.valueOf(cost));
            }
        } else if (ae.getSource() == bookPackage) {
                try {
                    Conn c = new Conn();
                    c.s.executeUpdate("insert into bookpackage values('"+labelUsername.getText()+"', '"+selectPack.getSelectedItem()+"', '"+tfTotalPersons.getText()+"', '"+labelId.getText()+"', '"+labelNumber.getText()+"', '"+labelPhone.getText()+"', '"+labelPrice.getText()+"')");

                    JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                    setVisible(false);
                } catch(Exception e){
                    e.printStackTrace();
                }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new BookPackage("");
    }
}

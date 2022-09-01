package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewCustomer extends JFrame implements ActionListener {

    JButton back;
    JLabel labelUsername, labelId, labelNumber, labelName, labelGender, labelCountry, labelAddress, labelPhone, labelMail;
    String username;
    ViewCustomer(String username){
        this.username = username;

        setBounds(450,180,870,625);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30,50,150,25);
        add(lblUsername);

        labelUsername = new JLabel();
        labelUsername.setBounds(220,50,150,25);
        add(labelUsername);

        JLabel lblId = new JLabel("Id");
        lblId.setBounds(30,110,150,25);
        add(lblId);

        labelId = new JLabel();
        labelId.setBounds(220,110,150,25);
        add(labelId);

        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(30,170,150,25);
        add(lblNumber);

        labelNumber = new JLabel();
        labelNumber.setBounds(220,170,150,25);
        add(labelNumber);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30,230,150,25);
        add(lblName);

        labelName = new JLabel();
        labelName.setBounds(220,230,150,25);
        add(labelName);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(30,290,150,25);
        add(lblGender);

        labelGender = new JLabel();
        labelGender.setBounds(220,290,150,25);
        add(labelGender);

        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(440,50,150,25);
        add(lblCountry);

        labelCountry = new JLabel();
        labelCountry.setBounds(630,50,150,25);
        add(labelCountry);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(440,110,150,25);
        add(lblAddress);

        labelAddress = new JLabel();
        labelAddress.setBounds(630,110,150,25);
        add(labelAddress);

        JLabel lblPhone = new JLabel("Phone Number");
        lblPhone.setBounds(440,170,150,25);
        add(lblPhone);

        labelPhone = new JLabel();
        labelPhone.setBounds(630,170,150,25);
        add(labelPhone);

        JLabel lblMail = new JLabel("Mail");
        lblMail.setBounds(440,230,150,25);
        add(lblMail);

        labelMail = new JLabel();
        labelMail.setBounds(630,230,200,25);
        add(labelMail);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(350,350,100,25);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image img = i1.getImage().getScaledInstance(600,200, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img);
        JLabel image = new JLabel(i2);
        image.setBounds(20,400,600,200);
        add(image);

        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image img1 = i3.getImage().getScaledInstance(600,200, Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(img1);
        JLabel image1 = new JLabel(i4);
        image1.setBounds(600,400,600,200);
        add(image1);

        try{
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);

            while(rs.next()){
                labelUsername.setText(rs.getString("username"));
                labelId.setText(rs.getString("id"));
                labelNumber.setText(rs.getString("number"));
                labelName.setText(rs.getString("name"));
                labelGender.setText(rs.getString("gender"));
                labelCountry.setText(rs.getString("country"));
                labelAddress.setText(rs.getString("address"));
                labelPhone.setText(rs.getString("phone"));
                labelMail.setText(rs.getString("email"));

            }

        } catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Dashboard(username);
        }
    }

    public static void main(String[] args){
        new ViewCustomer("");
    }
}

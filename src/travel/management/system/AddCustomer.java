package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel labelUsername,labelName;
    JComboBox comboId;
    JTextField tfNumber,tfCountry,tfAdd,tfMail,tfPhone;
    JRadioButton rMale,rFemale;
    JButton add,back;
    String username;

    AddCustomer(String username){
        this.username = username;

        setBounds(450,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30,50,150,25);
        add(lblUsername);

        labelUsername = new JLabel();
        labelUsername.setBounds(220,50,150,25);
        add(labelUsername);

        JLabel lblId = new JLabel("Id");
        lblId.setBounds(30,90,150,25);
        add(lblId);

        comboId = new JComboBox(new String [] {"Passport", "Aadhar Card", "Pan Card", "Ration Card"});
        comboId.setBounds(220,90,150,25);
        comboId.setBackground(Color.white);
        add(comboId);

        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(30,130,150,25);
        add(lblNumber);

        tfNumber = new JTextField();
        tfNumber.setBounds(220,130,150,25);
        add(tfNumber);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30,170,150,25);
        add(lblName);

        labelName = new JLabel();
        labelName.setBounds(220,170,150,25);
        add(labelName);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(30,210,150,25);
        add(lblGender);

        rMale = new JRadioButton("Male");
        rMale.setBounds(220,210,70,25);
        rMale.setBackground(Color.white);
        add(rMale);

        rFemale = new JRadioButton("Female");
        rFemale.setBounds(300,210,70,25);
        rFemale.setBackground(Color.white);
        add(rFemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rFemale);
        bg.add(rMale);

        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(30,250,150,25);
        add(lblCountry);

        tfCountry = new JTextField();
        tfCountry.setBounds(220,250,150,25);
        add(tfCountry);

        JLabel lblAdd = new JLabel("Address");
        lblAdd.setBounds(30,290,150,25);
        add(lblAdd);

        tfAdd = new JTextField();
        tfAdd.setBounds(220,290,150,25);
        add(tfAdd);

        JLabel lblMail = new JLabel("Email");
        lblMail.setBounds(30,330,150,25);
        add(lblMail);

        tfMail = new JTextField();
        tfMail.setBounds(220,330,150,25);
        add(tfMail);

        JLabel lblPhone = new JLabel("Phone Number");
        lblPhone.setBounds(30,370,150,25);
        add(lblPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(220,370,150,25);
        add(tfPhone);

        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.setBorder(BorderFactory.createEmptyBorder());
        add.setBounds(70,430,100,25);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image img = i1.getImage().getScaledInstance(400,500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img);
        JLabel image = new JLabel(i2);
        image.setBounds(400,10,400,500);
        add(image);

        try{
           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select * from account where username = 'prashant'");
            while (rs.next()){
                labelUsername.setText(rs.getString("username"));
                labelName.setText(rs.getString("name"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){
            String username = labelUsername.getText();
            String id = (String) comboId.getSelectedItem();
            String number = tfNumber.getText();
            String name = labelName.getText();
            String gender = null;
            if(rMale.isSelected()){
                gender = "Male";
            } else {
                gender = "Female";
            }
            String country = tfCountry.getText();
            String address = tfAdd.getText();
            String phone = tfPhone.getText();
            String mail = tfMail.getText();

            try{
                Conn c = new Conn();
                String query = "insert into customer values('"+username+"', '"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"', '"+mail+"' )";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new AddCustomer("");
    }
}

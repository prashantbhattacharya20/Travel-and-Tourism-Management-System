package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateCustomer extends JFrame implements ActionListener {

    JLabel labelUsername,labelName;
    JComboBox comboId;
    JTextField tfId,tfNumber,tfGender,tfCountry,tfAdd,tfMail,tfPhone;
    JRadioButton rMale,rFemale;
    JButton update,back;
    String username;

    UpdateCustomer(String username){
        this.username = username;

        setBounds(500,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(250,0,300,25);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30,50,150,25);
        add(lblUsername);

        labelUsername = new JLabel();
        labelUsername.setBounds(220,50,150,25);
        add(labelUsername);

        JLabel lblId = new JLabel("Id");
        lblId.setBounds(30,90,150,25);
        add(lblId);

        tfId = new JTextField();
        tfId.setBounds(220,90,150,25);
        add(tfId);

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

        tfGender = new JTextField();
        tfGender.setBounds(220,210,150,25);
        add(tfGender);

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

        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        update.setBorder(BorderFactory.createEmptyBorder());
        update.setBounds(70,430,100,25);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image img = i1.getImage().getScaledInstance(200,300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img);
        JLabel image = new JLabel(i2);
        image.setBounds(400,100,400,300);
        add(image);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while (rs.next()){
                labelUsername.setText(rs.getString("username"));
                labelName.setText(rs.getString("name"));
                tfId.setText(rs.getString("id"));
                tfNumber.setText(rs.getString("number"));
                tfGender.setText(rs.getString("gender"));
                tfCountry.setText(rs.getString("country"));
                tfAdd.setText(rs.getString("address"));
                tfPhone.setText(rs.getString("phone"));
                tfMail.setText(rs.getString("email"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == update){
            String username = labelUsername.getText();
            String id = tfId.getText();
            String number = tfNumber.getText();
            String name = labelName.getText();
            String gender = tfGender.getText();
            String country = tfCountry.getText();
            String address = tfAdd.getText();
            String phone = tfPhone.getText();
            String mail = tfMail.getText();

            try{
                Conn c = new Conn();
                String query = "update customer set username = '"+username+"', id = '"+id+"', number= '"+number+"', name = '"+name+"', gender = '"+gender+"', country = '"+country+"', address = '"+address+"', phone = '"+phone+"', email = '"+mail+"' ";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new UpdateCustomer("");
    }

}

package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener {

    JLabel labelUsername, labelId, labelNumber, labelPhone, labelPrice;
    Choice selectHtl,cAc,cFood;
    JTextField tfTotalPersons,tfDays;

    JButton checkPrice, bookHotel, back;
    String username;
    BookHotel(String username) {
        this.username = username;

        setBounds(250,150,1100,600);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("BOOK HOTEL");
        text.setBounds(400,10,200,35);
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

        JLabel selectHotel = new JLabel("Select Hotel");
        selectHotel.setBounds(40,110,150,25);
        selectHotel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(selectHotel);

        selectHtl = new Choice();
        selectHtl.setBounds(250,110,150,25);
        selectHtl.setBackground(Color.white);
        add(selectHtl);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while (rs.next()){
                selectHtl.add(rs.getString("name"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        JLabel totalPersons = new JLabel("Total Persons");
        totalPersons.setBounds(40,150,150,25);
        totalPersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(totalPersons);

        tfTotalPersons = new JTextField("1");
        tfTotalPersons.setBounds(250,150,150,25);
        add(tfTotalPersons);

        JLabel totalDays = new JLabel("Total No. of Days");
        totalDays.setBounds(40,190,150,25);
        totalDays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(totalDays);

        tfDays = new JTextField("1");
        tfDays.setBounds(250,190,150,25);
        add(tfDays);

        JLabel lblAc = new JLabel("AC/ Non-AC ROOM");
        lblAc.setBounds(40,230,150,25);
        lblAc.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAc);

        cAc = new Choice();
        cAc.add("AC");
        cAc.add("Non-AC");
        cAc.setBounds(250,230,150,25);
        cAc.setBackground(Color.white);
        add(cAc);

        JLabel lblFood = new JLabel("Food Included");
        lblFood.setBounds(40,270,150,25);
        lblFood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblFood);

        cFood = new Choice();
        cFood.add("Yes");
        cFood.add("No");
        cFood.setBounds(250,270,150,25);
        cFood.setBackground(Color.white);
        add(cFood);

        JLabel lblId = new JLabel("Id");
        lblId.setBounds(40,310,150,25);
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblId);

        labelId = new JLabel();
        labelId.setBounds(250,310,150,25);
        labelId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelId);

        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(40,350,150,25);
        lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblNumber);

        labelNumber = new JLabel();
        labelNumber.setBounds(250,350,150,25);
        labelNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelNumber);

        JLabel lblPhone = new JLabel("Phone Number");
        lblPhone.setBounds(40,390,150,25);
        lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblPhone);

        labelPhone = new JLabel();
        labelPhone.setBounds(250,390,150,25);
        labelPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelPhone);

        JLabel totalPrice = new JLabel("Total Price");
        totalPrice.setBounds(40,430,150,25);
        totalPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(totalPrice);

        labelPrice = new JLabel();
        labelPrice.setBounds(250,430,150,25);
        labelPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelPrice);

        checkPrice = new JButton("Check Price");
        checkPrice.setBackground(Color.BLACK);
        checkPrice.setForeground(Color.white);
        checkPrice.setBorder(BorderFactory.createEmptyBorder());
        checkPrice.setBounds(50,490,100,25);
        checkPrice.addActionListener(this);
        add(checkPrice);

        bookHotel = new JButton("Book Hotel");
        bookHotel.setBackground(Color.BLACK);
        bookHotel.setForeground(Color.white);
        bookHotel.setBorder(BorderFactory.createEmptyBorder());
        bookHotel.setBounds(200,490,100,25);
        bookHotel.addActionListener(this);
        add(bookHotel);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setBounds(350,490,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel1.jpg"));
        Image img = i1.getImage().getScaledInstance(600,350, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img);
        JLabel image = new JLabel(i2);
        image.setBounds(450,70,600,350);
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

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name = '" + selectHtl.getSelectedItem() + "'");
                while (rs.next()){
                   int cost = Integer.parseInt(rs.getString("costperperson"));
                   int food = Integer.parseInt(rs.getString("foodincluded"));
                   int ac = Integer.parseInt(rs.getString("acroom"));

                   int persons = Integer.parseInt(tfTotalPersons.getText());
                   int days = Integer.parseInt(tfDays.getText());

                   String acSelected = cAc.getSelectedItem();
                   String foodSelected = cFood.getSelectedItem();

                   if(persons * days > 0){
                       int total = 0;
                       total += acSelected.equals("AC") ? ac : 0;
                       total += foodSelected.equals("Yes") ? food : 0;
                       total += cost;
                       total = total * persons * days;
                       labelPrice.setText(String.valueOf(total));
                   } else {
                       JOptionPane.showMessageDialog(null, "Please Enter a Valid Number");
                   }
                }
            } catch(Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource() == bookHotel) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+labelUsername.getText()+"', '"+selectHtl.getSelectedItem()+"', '"+tfTotalPersons.getText()+"', '"+tfDays.getText()+"', '"+cAc.getSelectedItem()+"', '"+cFood.getSelectedItem()+"', '"+labelId.getText()+"', '"+labelNumber.getText()+"', '"+labelPhone.getText()+"', '"+labelPrice.getText()+"')");

                JOptionPane.showMessageDialog(null,"Hotel Booked Successfully");
                setVisible(false);
            } catch(Exception e){
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new BookHotel("");
    }
}

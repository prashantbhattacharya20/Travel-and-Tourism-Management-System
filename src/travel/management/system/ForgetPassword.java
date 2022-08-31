package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener {

    JTextField tfUsername, tfName, tfQuestion, tfAnswer, tfPassword;
    JButton search,retrieve,back;

    ForgetPassword(){
        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.png"));
        Image img = i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img);
        JLabel image = new JLabel(i2);
        image.setBounds(580,70,200,200);
        add(image);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280);
        add(p1);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(40,20,100,25);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD,14));
        p1.add(lblUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(220,20,150,25);
        tfUsername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfUsername);

        search = new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.white);
        search.setBounds(380,20,100,25);
        search.addActionListener(this);
        p1.add(search);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(40,60,100,25);
        p1.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(220,60,150,25);
        tfName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfName);

        JLabel lblQuestion = new JLabel("Your Security Question");
        lblQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblQuestion.setBounds(40,100,180,25);
        p1.add(lblQuestion);

        tfQuestion = new JTextField();
        tfQuestion.setBounds(220,100,150,25);
        tfQuestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfQuestion);

        JLabel lblAnswer = new JLabel("Answer");
        lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAnswer.setBounds(40,140,150,25);
        p1.add(lblAnswer);

        tfAnswer = new JTextField();
        tfAnswer.setBounds(220,140,150,25);
        tfAnswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfAnswer);

        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.white);
        retrieve.setBounds(380,140,100,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setBounds(40,180,150,25);
        p1.add(lblPassword);

        tfPassword = new JTextField();
        tfPassword.setBounds(220,180,150,25);
        tfPassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfPassword);

        back = new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.white);
        back.setBounds(150,230,100,25);
        back.addActionListener(this);
        p1.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == search){
            try{
                String query = "select * from account where username = '"+tfUsername.getText()+"'";
                Conn c = new Conn();

                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    tfName.setText(rs.getString("name"));
                    tfQuestion.setText(rs.getString("security"));
                }
            } catch(Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource() == retrieve){
            try{
                String query = "select * from account where answer = '"+tfAnswer.getText()+"' AND username = '"+tfUsername.getText()+"'";
                Conn c = new Conn();

                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    tfPassword.setText(rs.getString("password"));
                }
            } catch(Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args){
        new ForgetPassword();
    }
}

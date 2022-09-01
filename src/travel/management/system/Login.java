package travel.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signUp, fPassword;
    JTextField tfUsername;
    JPasswordField tfPassword;

    Login(){
        setSize(900,500);
        setLocation(350,165);
        setLayout(null);

        getContentPane().setBackground(Color.white);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(2, 150, 169));
        p1.setBounds(0, 0, 400,500);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image img = i1.getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img);
        JLabel image = new JLabel(i2);
        image.setBounds(50,70,300,300);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,0, 500,500);
        add(p2);

        JLabel username = new JLabel("USERNAME");
        username.setBounds(60,70,200,25);
        username.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(username);

        tfUsername = new JTextField();
        tfUsername.setBounds(60, 110, 300, 30);
        tfUsername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfUsername);

        JLabel password = new JLabel("PASSWORD");
        password.setBounds(60,150,200,25);
        password.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(password);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(60, 180, 300, 30);
        tfPassword.setBorder(BorderFactory.createEmptyBorder());
        tfPassword.setEchoChar('*');
        p2.add(tfPassword);

        login = new JButton("LOGIN");
        login.setBounds(60,240,130,30);
        login.setBackground(new Color(2, 150, 169));
        login.setForeground(Color.white);
        login.setBorder(new LineBorder(new Color(2, 150, 169)));
        login.addActionListener(this);
        p2.add(login);

        signUp = new JButton("SIGN UP");
        signUp.setBounds(235,240,130,30);
        signUp.setBackground(new Color(2, 150, 169));
        signUp.setForeground(Color.white);
        signUp.setBorder(new LineBorder(new Color(2, 150, 169)));
        signUp.addActionListener(this);
        p2.add(signUp);

        fPassword = new JButton("FORGET PASSWORD");
        fPassword.setBounds(140,290,150,30);
        fPassword.setBackground(new Color(2, 150, 169));
        fPassword.setForeground(Color.white);
        fPassword.setBorder(new LineBorder(new Color(2, 150, 169)));
        fPassword.addActionListener(this);
        p2.add(fPassword);

        JLabel trouble = new JLabel("(Trouble in login..)");
        trouble.setBounds(158,330,200,25);
        trouble.setForeground(Color.red);
        trouble.setFont(new Font("SAN SERIF", Font.PLAIN, 15));
        p2.add(trouble);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == login){
            try{
                String username = tfUsername.getText();
                String pass = String.valueOf(tfPassword.getPassword());

                String query = "select * from account where username = '"+username+"' AND password = '"+pass+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Loading(username);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                }

            } catch(Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == signUp) {
            setVisible(false);
            new Signup();

        } else {
            setVisible(false);
            new ForgetPassword();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}

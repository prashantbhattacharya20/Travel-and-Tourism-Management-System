package travel.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Login extends JFrame {

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

        JTextField tfUsername = new JTextField();
        tfUsername.setBounds(60, 110, 300, 30);
        tfUsername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfUsername);

        JLabel password = new JLabel("PASSWORD");
        password.setBounds(60,150,200,25);
        password.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(password);

        JTextField tfPassword = new JTextField();
        tfPassword.setBounds(60, 180, 300, 30);
        tfPassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfPassword);

        JButton login = new JButton("LOGIN");
        login.setBounds(60,240,130,30);
        login.setBackground(new Color(2, 150, 169));
        login.setForeground(Color.white);
        login.setBorder(new LineBorder(new Color(2, 150, 169)));
        p2.add(login);

        JButton signUp = new JButton("SIGN UP");
        signUp.setBounds(235,240,130,30);
        signUp.setBackground(new Color(2, 150, 169));
        signUp.setForeground(Color.white);
        signUp.setBorder(new LineBorder(new Color(2, 150, 169)));
        p2.add(signUp);

        JButton fPassword = new JButton("FORGET PASSWORD");
        fPassword.setBounds(140,290,150,30);
        fPassword.setBackground(new Color(2, 150, 169));
        fPassword.setForeground(Color.white);
        fPassword.setBorder(new LineBorder(new Color(2, 150, 169)));
        p2.add(fPassword);

        JLabel trouble = new JLabel("(Trouble in login..)");
        trouble.setBounds(158,330,200,25);
        trouble.setForeground(Color.red);
        trouble.setFont(new Font("SAN SERIF", Font.PLAIN, 15));
        p2.add(trouble);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}

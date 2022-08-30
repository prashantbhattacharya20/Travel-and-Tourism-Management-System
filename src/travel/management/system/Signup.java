package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Signup extends JFrame {

    Signup(){
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(2, 150, 169));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);

        JLabel lblUsername = new JLabel("USERNAME");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUsername.setBounds(50,20,125,25);
        p1.add(lblUsername);

        JTextField tfUsername = new JTextField();
        tfUsername.setBounds(200,20,180,25);
        tfUsername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfUsername);

        JLabel lblName = new JLabel("NAME");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(50,60,125,25);
        p1.add(lblName);

        JTextField tfName = new JTextField();
        tfName.setBounds(200,60,180,25);
        tfName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfName);

        JLabel lblPassword = new JLabel("PASSWORD");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setBounds(50,100,125,25);
        p1.add(lblPassword);

        JTextField tfPassword = new JTextField();
        tfPassword.setBounds(200,100,180,25);
        tfPassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfPassword);

        JLabel lblSecurity = new JLabel("Security Question");
        lblSecurity.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSecurity.setBounds(50,140,150,25);
        p1.add(lblSecurity);

        Choice security = new Choice();
        security.add("Fav Marvel Super Hero");
        security.add("Captain America or Iron Man");
        security.add("High School Name");
        security.add("Nick Name");
        security.add("Your Lucky Number");
        security.setBounds(200,140,180,25);
        p1.add(security);

        JLabel lblAnswer = new JLabel("ANSWER");
        lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAnswer.setBounds(50,180,125,25);
        p1.add(lblAnswer);

        JTextField tfAnswer = new JTextField();
        tfAnswer.setBounds(200,180,180,25);
        tfAnswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfAnswer);

        JButton create = new JButton("CREATE");
        create.setBackground(Color.white);
        create.setForeground(new Color(2, 150, 169));
        create.setFont(new Font("Tahoma",Font.BOLD, 14));
        create.setBounds(80,250,100,30);
        p1.add(create);

        JButton back = new JButton("BACK");
        back.setBackground(Color.white);
        back.setForeground(new Color(2, 150, 169));
        back.setFont(new Font("Tahoma",Font.BOLD, 14));
        back.setBounds(250,250,100,30);
        p1.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image img = i1.getImage().getScaledInstance(250,250, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img);
        JLabel image = new JLabel(i2);
        image.setBounds(580,40,250,250);
        add(image);

        setVisible(true);
    }
    public static void main(String[] args){
        new Signup();
    }
}

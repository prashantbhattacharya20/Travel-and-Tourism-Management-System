package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    Dashboard(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(10, 75, 102));
        p1.setBounds(0,0,1550, 65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image img1 = i1.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img1);
        JLabel icon = new JLabel(i2);
        icon.setBounds(5,0,70,70);
        p1.add(icon);

        JLabel heading = new JLabel("DASHBOARD");
        heading.setBounds(100,10,300,40);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(59, 153, 203));
        p2.setBounds(0,65,300, 800);
        add(p2);

        JButton addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,300,49);
        addPersonalDetails.setBackground(new Color(59, 153, 203));
        addPersonalDetails.setForeground(Color.BLACK);
        addPersonalDetails.setFont(new Font("Tahoma", Font.BOLD,20));
        addPersonalDetails.setMargin(new Insets(0,0,0,60));
        addPersonalDetails.setBorder(BorderFactory.createLineBorder(new Color(10, 75, 102)));
        p2.add(addPersonalDetails);

        JButton updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,49,300,50);
        updatePersonalDetails.setBackground(new Color(59, 153, 203));
        updatePersonalDetails.setForeground(Color.BLACK);
        updatePersonalDetails.setFont(new Font("Tahoma", Font.BOLD,20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,60));
        updatePersonalDetails.setBorder(BorderFactory.createLineBorder(new Color(10, 75, 102)));
        p2.add(updatePersonalDetails);

        JButton deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0,98,300,50);
        deletePersonalDetails.setBackground(new Color(59, 153, 203));
        deletePersonalDetails.setForeground(Color.BLACK);
        deletePersonalDetails.setFont(new Font("Tahoma", Font.BOLD,20));
        deletePersonalDetails.setMargin(new Insets(0,0,0,60));
        deletePersonalDetails.setBorder(BorderFactory.createLineBorder(new Color(10, 75, 102)));
        p2.add(deletePersonalDetails);

        JButton viewPersonalDetails = new JButton("View Personal Details");
        viewPersonalDetails.setBounds(0,147,300,50);
        viewPersonalDetails.setBackground(new Color(59, 153, 203));
        viewPersonalDetails.setForeground(Color.BLACK);
        viewPersonalDetails.setFont(new Font("Tahoma", Font.BOLD,20));
        viewPersonalDetails.setMargin(new Insets(0,0,0,60));
        viewPersonalDetails.setBorder(BorderFactory.createLineBorder(new Color(10, 75, 102)));
        p2.add(viewPersonalDetails);

        JButton checkPackage = new JButton("Check Package");
        checkPackage.setBounds(0,196,300,50);
        checkPackage.setBackground(new Color(59, 153, 203));
        checkPackage.setForeground(Color.BLACK);
        checkPackage.setFont(new Font("Tahoma", Font.BOLD,20));
        checkPackage.setMargin(new Insets(0,0,0,60));
        checkPackage.setBorder(BorderFactory.createLineBorder(new Color(10, 75, 102)));
        p2.add(checkPackage);

        JButton bookPackage = new JButton("Book Package");
        bookPackage.setBounds(0,245,300,50);
        bookPackage.setBackground(new Color(59, 153, 203));
        bookPackage.setForeground(Color.BLACK);
        bookPackage.setFont(new Font("Tahoma", Font.BOLD,20));
        bookPackage.setMargin(new Insets(0,0,0,60));
        bookPackage.setBorder(BorderFactory.createLineBorder(new Color(10, 75, 102)));
        p2.add(bookPackage);

        JButton viewPackage = new JButton("View Package");
        viewPackage.setBounds(0,294,300,50);
        viewPackage.setBackground(new Color(59, 153, 203));
        viewPackage.setForeground(Color.BLACK);
        viewPackage.setFont(new Font("Tahoma", Font.BOLD,20));
        viewPackage.setMargin(new Insets(0,0,0,60));
        viewPackage.setBorder(BorderFactory.createLineBorder(new Color(10, 75, 102)));
        p2.add(viewPackage);

        JButton viewHotels = new JButton("View Hotels");
        viewHotels.setBounds(0,343,300,50);
        viewHotels.setBackground(new Color(59, 153, 203));
        viewHotels.setForeground(Color.BLACK);
        viewHotels.setFont(new Font("Tahoma", Font.BOLD,20));
        viewHotels.setMargin(new Insets(0,0,0,60));
        viewHotels.setBorder(BorderFactory.createLineBorder(new Color(10, 75, 102)));
        p2.add(viewHotels);

        JButton bookHotel = new JButton("Book Hotel");
        bookHotel.setBounds(0,392,300,50);
        bookHotel.setBackground(new Color(59, 153, 203));
        bookHotel.setForeground(Color.BLACK);
        bookHotel.setFont(new Font("Tahoma", Font.BOLD,20));
        bookHotel.setMargin(new Insets(0,0,0,60));
        bookHotel.setBorder(BorderFactory.createLineBorder(new Color(10, 75, 102)));
        p2.add(bookHotel);

        JButton viewBookedHotel = new JButton("View Booked Hotel");
        viewBookedHotel.setBounds(0,441,300,50);
        viewBookedHotel.setBackground(new Color(59, 153, 203));
        viewBookedHotel.setForeground(Color.BLACK);
        viewBookedHotel.setFont(new Font("Tahoma", Font.BOLD,20));
        viewBookedHotel.setMargin(new Insets(0,0,0,60));
        viewBookedHotel.setBorder(BorderFactory.createLineBorder(new Color(10, 75, 102)));
        p2.add(viewBookedHotel);

        JButton destinations = new JButton("Destinations");
        destinations.setBounds(0,490,300,50);
        destinations.setBackground(new Color(59, 153, 203));
        destinations.setForeground(Color.BLACK);
        destinations.setFont(new Font("Tahoma", Font.BOLD,20));
        destinations.setMargin(new Insets(0,0,0,60));
        destinations.setBorder(BorderFactory.createLineBorder(new Color(10, 75, 102)));
        p2.add(destinations);

        JButton payment = new JButton("Payment");
        payment.setBounds(0,539,300,50);
        payment.setBackground(new Color(59, 153, 203));
        payment.setForeground(Color.BLACK);
        payment.setFont(new Font("Tahoma", Font.BOLD,20));
        payment.setMargin(new Insets(0,0,0,60));
        payment.setBorder(BorderFactory.createLineBorder(new Color(10, 75, 102)));
        p2.add(payment);

        JButton calculator = new JButton("Calculator");
        calculator.setBounds(0,588,300,50);
        calculator.setBackground(new Color(59, 153, 203));
        calculator.setForeground(Color.BLACK);
        calculator.setFont(new Font("Tahoma", Font.BOLD,20));
        calculator.setMargin(new Insets(0,0,0,60));
        calculator.setBorder(BorderFactory.createLineBorder(new Color(10, 75, 102)));
        p2.add(calculator);

        JButton notepad = new JButton("Notepad");
        notepad.setBounds(0,637,300,50);
        notepad.setBackground(new Color(59, 153, 203));
        notepad.setForeground(Color.BLACK);
        notepad.setFont(new Font("Tahoma", Font.BOLD,20));
        notepad.setMargin(new Insets(0,0,0,60));
        notepad.setBorder(BorderFactory.createLineBorder(new Color(10, 75, 102)));
        p2.add(notepad);

        JButton about = new JButton("About");
        about.setBounds(0,686,300,50);
        about.setBackground(new Color(59, 153, 203));
        about.setForeground(Color.BLACK);
        about.setFont(new Font("Tahoma", Font.BOLD,20));
        about.setMargin(new Insets(0,0,0,60));
        about.setBorder(BorderFactory.createLineBorder(new Color(10, 75, 102)));
        p2.add(about);

        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image img2 = i3.getImage().getScaledInstance(1550,1000, Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(img2);
        JLabel image =  new JLabel(i4);
        image.setBounds(300,65,1250,800);
        add(image);

        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(90,20,1200,70);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Raleway", Font.BOLD, 40));
        image.add(text);


        setVisible(true);
    }

    public static void main (String[] args){
        new Dashboard();
    }
}

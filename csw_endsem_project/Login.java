package csw_endsem_project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login implements ActionListener {
    JFrame lf = new JFrame();
    JLabel testlabel = new JLabel("CHOOSE THE ACCESS TYPE");
    JButton exitButton = new JButton("EXIT");
    JButton adminButton = new JButton("ADMINISTRATOR");
    JButton userButton = new JButton("STANDARD USER");
    JLabel loginlabel = new JLabel();
    ImageIcon loginimage = new ImageIcon("img/login.png");
    ImageIcon icon = new ImageIcon("img/logo.png");
    Login() {
        // Setting the login frame
        lf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lf.setUndecorated(true);
        lf.setResizable(false);
        lf.setSize(500, 500);
        lf.setVisible(true);
        lf.setLocationRelativeTo(null);
        lf.setTitle("Login Type");
        lf.getContentPane().setBackground(new Color(0x1d1d1d));
        lf.setLayout(null);
        lf.setIconImage(icon.getImage());

        // Setting the labels and buttons
        testlabel.setBounds(33, 33, 500, 41);
        testlabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        testlabel.setForeground(new Color(0xEEEDE7));

        //Setting exitButton
        exitButton.setBounds(371, 450, 90, 36);
        exitButton.setBackground(new Color(0x1d1b1b));
        exitButton.setFocusable(false);
        exitButton.setFont(new Font("Calibri", Font.PLAIN, 19));
        exitButton.setForeground(new Color(0xEEEDE7));
        exitButton.addActionListener(this);

        //Admin and user button
        adminButton.setBounds(263, 195, 201, 54);
        adminButton.setBackground(new Color(0x1d1b1b));
        adminButton.setFocusable(false);
        adminButton.setFont(new Font("Calibri", Font.PLAIN, 23));
        adminButton.setForeground(new Color(0xEEEDE7));
        adminButton.addActionListener(this);

        userButton.setBounds(263, 270, 201, 54);
        userButton.setBackground(new Color(0x1d1b1b));
        userButton.setFocusable(false);
        userButton.setFont(new Font("Calibri", Font.PLAIN, 23));
        userButton.setForeground(new Color(0xEEEDE7));
        userButton.addActionListener(this);

        // Setting loginlabel
        loginlabel.setBounds(60, 117, 400, 300);

        
        // Adding frame components
        lf.add(testlabel);
        lf.add(exitButton);
        lf.add(adminButton);
        lf.add(userButton);
        lf.add(loginlabel);
        loginlabel.setIcon(loginimage);
    }

    @Override
    //Onlick button actions
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exitButton){
            System.exit(0);
        }
        if(e.getSource()==adminButton){
            lf.setVisible(false);
            new AdminLogin();
        }
        if(e.getSource()==userButton){
            lf.setVisible(false);
            new UserLogin();
        }
    }
}
package csw_endsem_project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AdminLogin implements ActionListener {
    JFrame alf = new JFrame();
    JButton backButton = new JButton("< BACK");
    JButton loginButton = new JButton("LOGIN");
    JButton hintButton = new JButton("HINT");
    JLabel hintLabel = new JLabel();
    JLabel adminLabel = new JLabel("ADMIN LOGIN PORTAL");
    ImageIcon icon = new ImageIcon("img/logo.png");
    JTextField userfield = new JTextField();
    JPasswordField passfield = new JPasswordField();
    JLabel adminLabel2 = new JLabel();
    ImageIcon adminimage = new ImageIcon("img/admin.png");
    AdminLogin(){
        alf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        alf.setUndecorated(true);
        alf.setResizable(false);
        alf.setSize(500, 500);
        alf.setVisible(true);
        alf.setLocationRelativeTo(null);
        alf.setTitle("Admin Login");
        alf.getContentPane().setBackground(new Color(0x1d1d1d));
        alf.setLayout(null);
        alf.setIconImage(icon.getImage());
        //select user button setup
        backButton.setBounds(280, 450, 110, 36);
        backButton.setBackground(new Color(0x1d1b1b));
        backButton.setFocusable(false);
        backButton.setFont(new Font("Calibri", Font.PLAIN, 20));
        backButton.setForeground(new Color(0xEEEDE7));
        backButton.addActionListener(this);

        //login button setup
        loginButton.setBounds(123, 300, 270, 36);
        loginButton.setBackground(new Color(0x1d1b1b));
        loginButton.setFocusable(false);
        loginButton.setFont(new Font("Calibri", Font.PLAIN, 20));
        loginButton.setForeground(new Color(0xEEEDE7));
        loginButton.addActionListener(this);

        //HInt button setup
        hintButton.setBounds(123, 350, 70, 25);
        hintButton.setBackground(new Color(0x1d1b1b));
        hintButton.setFocusable(false);
        hintButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        hintButton.setForeground(new Color(0xEEEDE7));
        hintButton.addActionListener(this);
        
        //text fields
        userfield.setBounds(123,200,270,36);
        passfield.setBounds(123,250,270,36);
        userfield.setFont(new Font("Calibri", Font.PLAIN,20));
        passfield.setFont(new Font("Calibri", Font.PLAIN,20));
        userfield.setBorder(null);
        passfield.setBorder(null);

        //hint label
        hintLabel.setBounds(227, 347, 200, 36);
        hintLabel.setFont(new Font("Calibri", Font.PLAIN,14));
        hintLabel.setForeground(new Color(0xffff1b));

        //admin login label
        adminLabel.setBounds(65, 27, 400, 40);
        adminLabel.setFont(new Font("Calibri", Font.PLAIN,40));
        adminLabel.setForeground(new Color(0xEEEDE7));
        adminLabel2.setBounds(210, 90, 100, 100);

        //adding frame components
        alf.add(backButton);
        alf.add(loginButton);
        alf.add(hintButton);
        alf.add(userfield);
        alf.add(passfield);
        alf.add(hintLabel);
        alf.add(adminLabel);
        alf.add(adminLabel2);
        adminLabel2.setIcon(adminimage);
    }

    @Override
    //Button onclick events
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            alf.setVisible(false);
            new Login();
        }
        if(e.getSource()==hintButton){
            hintLabel.setText("Default user & pass is 'admin' ");
        }
        if(e.getSource()==loginButton){
            if(userfield.getText().equals("admin") && passfield.getText().equals("admin")){
                alf.setVisible(false);
                new Admin();
            }
            else{
                JOptionPane.showMessageDialog(null,"Login Failed, Incorrect Username or Password. Please Try Again!");
            }
        }
    }
}
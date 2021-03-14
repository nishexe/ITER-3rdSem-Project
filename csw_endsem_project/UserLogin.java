package csw_endsem_project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class UserLogin implements ActionListener {
    //Init of required JFrame components
    JFrame ulf = new JFrame();
    JButton backButton = new JButton("< BACK");
    JButton loginButton = new JButton("LOGIN");
    JButton hintButton = new JButton("HINT");
    JLabel hintLabel = new JLabel();
    JLabel userLabel = new JLabel("USER LOGIN PORTAL");
    ImageIcon icon = new ImageIcon("img/logo.png");
    JTextField userfield = new JTextField();
    JPasswordField passfield = new JPasswordField();
    JLabel userLabel2 = new JLabel();
    ImageIcon userimage = new ImageIcon("img/user.png");
    UserLogin() {
        //Setting up the JFRAME
        ulf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ulf.setUndecorated(true);
        ulf.setResizable(false);
        ulf.setSize(500, 500);
        ulf.setVisible(true);
        ulf.setLocationRelativeTo(null);
        ulf.setTitle("User Login");
        ulf.getContentPane().setBackground(new Color(0x1d1d1d));
        ulf.setLayout(null);
        ulf.setIconImage(icon.getImage());

        //Back buton (select user)setup
        backButton.setBounds(280, 450, 110, 36);
        backButton.setBackground(new Color(0x1d1b1b));
        backButton.setFocusable(false);
        backButton.setFont(new Font("Calibri", Font.PLAIN, 20));
        backButton.setForeground(new Color(0xEEEDE7));
        backButton.addActionListener(this);

        //Login button setup
        loginButton.setBounds(123, 300, 270, 36);
        loginButton.setBackground(new Color(0x1d1b1b));
        loginButton.setFocusable(false);
        loginButton.setFont(new Font("Calibri", Font.PLAIN, 20));
        loginButton.setForeground(new Color(0xEEEDE7));
        loginButton.addActionListener(this);

        //Hint button setup
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

        //user login label
        userLabel.setBounds(85, 27, 400, 40);
        userLabel.setFont(new Font("Calibri", Font.PLAIN,40));
        userLabel.setForeground(new Color(0xEEEDE7));
        userLabel2.setBounds(210, 90, 100, 100);

        //adding frame components
        ulf.add(backButton);
        ulf.add(loginButton);
        ulf.add(hintButton);
        ulf.add(userfield);
        ulf.add(passfield);
        ulf.add(hintLabel);
        ulf.add(userLabel);
        ulf.add(userLabel2);
        userLabel2.setIcon(userimage);
    }

    @Override
    //Button onclick actions
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            ulf.setVisible(false);
            new Login();
        }
        if(e.getSource()==hintButton){
            hintLabel.setText("Default user & pass is 'user' ");
        }
        if(e.getSource()==loginButton){
            if(userfield.getText().equals("user") && passfield.getText().equals("user")){
                ulf.setVisible(false);
                new LoadDBUser();
            }
            else{
                JOptionPane.showMessageDialog(null,"Login Failed, Incorrect Username or Password. Please Try Again!");
            }
        }
    }
}
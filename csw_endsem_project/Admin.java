package csw_endsem_project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Admin implements ActionListener {
    //Initializing JFRAME and its components
    JFrame af = new JFrame();
    ImageIcon icon = new ImageIcon("img/logo.png");
    JButton exitButton = new JButton("EXIT");
    JButton backButton = new JButton("< BACK");
    JButton addButton = new JButton("ADD DATA");
    JButton showButton = new JButton("SHOW DATA");
    JButton modifyButton = new JButton("MODIFY DATA");
    JButton deleteButton = new JButton("DELETE DATA");
    JLabel adminFuncLabel = new JLabel("AVAILABLE ADMIN FUNCTIONS");
    JLabel adminLabel2 = new JLabel();
    ImageIcon adminimage = new ImageIcon("img/icon300.png");
    JLabel showlLabel = new JLabel();
    ImageIcon showImage = new ImageIcon("img/show.png");
    JLabel addlLabel = new JLabel();
    ImageIcon addImage = new ImageIcon("img/add.png");
    JLabel deletelLabel = new JLabel();
    ImageIcon deleteImage = new ImageIcon("img/delete.png");
    JLabel modifylLabel = new JLabel();
    ImageIcon modifyImage = new ImageIcon("img/modify.png");
    Admin(){
        //Settin up the JFRAME
        af.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        af.setUndecorated(true);
        af.setResizable(false);
        af.setSize(700, 475);
        af.setVisible(true);
        af.setLocationRelativeTo(null);
        af.setTitle("Admin");
        af.getContentPane().setBackground(new Color(0x1d1d1d));
        af.setLayout(null);
        af.setIconImage(icon.getImage());

        //Exit button setup
        exitButton.setBounds(555, 420, 90, 36);
        exitButton.setBackground(new Color(0x1d1b1b));
        exitButton.setFocusable(false);
        exitButton.setFont(new Font("Calibri", Font.PLAIN, 19));
        exitButton.setForeground(new Color(0xEEEDE7));
        exitButton.addActionListener(this);

        //Show button setup
        showButton.setBounds(50, 105, 171, 45);
        showButton.setBackground(new Color(0x1d1b1b));
        showButton.setFocusable(false);
        showButton.setFont(new Font("Calibri", Font.PLAIN, 22));
        showButton.setForeground(new Color(0xEEEDE7));
        showButton.addActionListener(this);

        //Add button setup
        addButton.setBounds(50, 160, 171, 45);
        addButton.setBackground(new Color(0x1d1b1b));
        addButton.setFocusable(false);
        addButton.setFont(new Font("Calibri", Font.PLAIN, 22));
        addButton.setForeground(new Color(0xEEEDE7));
        addButton.addActionListener(this);

        //Delete button setup
        deleteButton.setBounds(50, 215, 171, 45);
        deleteButton.setBackground(new Color(0x1d1b1b));
        deleteButton.setFocusable(false);
        deleteButton.setFont(new Font("Calibri", Font.PLAIN, 22));
        deleteButton.setForeground(new Color(0xEEEDE7));
        deleteButton.addActionListener(this);

        //Modify button setup
        modifyButton.setBounds(50, 270, 171, 45);
        modifyButton.setBackground(new Color(0x1d1b1b));
        modifyButton.setFocusable(false);
        modifyButton.setFont(new Font("Calibri", Font.PLAIN, 22));
        modifyButton.setForeground(new Color(0xEEEDE7));
        modifyButton.addActionListener(this);

        //Back button setup
        backButton.setBounds(50, 420, 90, 36);
        backButton.setBackground(new Color(0x1d1b1b));
        backButton.setFocusable(false);
        backButton.setFont(new Font("Calibri", Font.PLAIN, 19));
        backButton.setForeground(new Color(0xEEEDE7));
        backButton.addActionListener(this);

        //Admin label setup
        adminFuncLabel.setBounds(96, 27, 590, 40);
        adminFuncLabel.setFont(new Font("Calibri", Font.PLAIN,40));
        adminFuncLabel.setForeground(new Color(0xEEEDE7));

        //Icon labels
        adminLabel2.setBounds(350, 90, 300, 300);
        showlLabel.setBounds(228,113,32,32);
        addlLabel.setBounds(228,167,32,32);
        deletelLabel.setBounds(228,222,32,32);
        modifylLabel.setBounds(228,277,32,32);

        //Adding components to the JFRAME
        af.add(exitButton);
        af.add(addButton);
        af.add(showButton);
        af.add(modifyButton);
        af.add(deleteButton);
        af.add(backButton);
        af.add(adminFuncLabel);
        af.add(adminLabel2);
        af.add(showlLabel);
        af.add(addlLabel);
        af.add(deletelLabel);
        af.add(modifylLabel);

        //Setting icons to the labels
        adminLabel2.setIcon(adminimage);
        showlLabel.setIcon(showImage);
        addlLabel.setIcon(addImage);
        deletelLabel.setIcon(deleteImage);
        modifylLabel.setIcon(modifyImage);
    }
    @Override
    //Setting up the Button on click action performed
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exitButton){
            System.exit(0);
        }
        if(e.getSource()==backButton){
            af.setVisible(false);
            new AdminLogin();
        }
        //Main function buttons
        if(e.getSource()==showButton){
            af.setVisible(false);
            new LoadDBAdmin();
        }
        if(e.getSource()==addButton){
            af.setVisible(false);
            new Add();
        }
        if(e.getSource()==deleteButton){
            af.setVisible(false);
            new Delete();
        }
        if(e.getSource()==modifyButton){
            af.setVisible(false);
            new Modify();
        }
    }
}
package csw_endsem_project;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
public class LoadDBUser implements ActionListener {
    Connection connection = null;
    JFrame uf = new JFrame();
    ImageIcon icon = new ImageIcon("img/logo.png");
    JButton exitButton = new JButton("EXIT");
    JButton backButton = new JButton("< BACK");
    JButton loadButton = new JButton("LOAD DATA");
    JButton exportButton = new JButton("EXPORT DATA");
    JScrollPane scrollPane = new JScrollPane();
    JTable table = new JTable();
    JLabel showlLabel = new JLabel();
    ImageIcon showImage = new ImageIcon("img/show.png");
    JLabel exportLabel = new JLabel();
    ImageIcon exportImage = new ImageIcon("img/export.png");
    
    LoadDBUser(){
        //Setting up the JFRAME.
        uf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        uf.setUndecorated(true);
        uf.setResizable(false);
        uf.setSize(700, 500);
        uf.setVisible(true);
        uf.setLocationRelativeTo(null);
        uf.setTitle("Load DB(User)");
        uf.getContentPane().setBackground(new Color(0x1d1d1d));
        uf.setLayout(null);
        uf.setIconImage(icon.getImage());

        //Setting up the exit button
        exitButton.setBounds(590, 450, 90, 36);
        exitButton.setBackground(new Color(0x1d1b1b));
        exitButton.setFocusable(false);
        exitButton.setFont(new Font("Calibri", Font.PLAIN, 19));
        exitButton.setForeground(new Color(0xEEEDE7));
        exitButton.addActionListener(this);

        //Setting up the back button
        backButton.setBounds(20, 450, 110, 36);
        backButton.setBackground(new Color(0x1d1b1b));
        backButton.setFocusable(false);
        backButton.setFont(new Font("Calibri", Font.PLAIN, 20));
        backButton.setForeground(new Color(0xEEEDE7));
        backButton.addActionListener(this);

        //Setting up the load button
        loadButton.setBounds(20, 20, 200, 45);
        loadButton.setBackground(new Color(0x1d1b1b));
        loadButton.setFocusable(false);
        loadButton.setFont(new Font("Calibri", Font.PLAIN, 20));
        loadButton.setForeground(new Color(0xEEEDE7));
        loadButton.addActionListener(this);
        //Setting up the export button
        exportButton.setBounds(445, 20, 200, 45);
        exportButton.setBackground(new Color(0x1d1b1b));
        exportButton.setFocusable(false);
        exportButton.setFont(new Font("Calibri", Font.PLAIN, 20));
        exportButton.setForeground(new Color(0xEEEDE7));
        exportButton.addActionListener(this);

        //Setting up the table
        table.setBackground(new Color(0x121212));
        table.setForeground(new Color(0xEEEDE7));

        //Setting up the scroll pane
        scrollPane.setBounds(20,90,659,350);
        scrollPane.getViewport().setBackground(new Color(0x404040));
        scrollPane.setViewportView(table);

        //Setting up the showlabel/exportlabel image
        showlLabel.setBounds(227,27,32,32);
        showlLabel.setIcon(showImage);

        exportLabel.setBounds(650,27,32,32);
        exportLabel.setIcon(exportImage);

        //Adding components to JFRAME
        uf.add(exitButton);
        uf.add(backButton);
        uf.add(loadButton);
        uf.add(exportButton);
        uf.add(scrollPane);
        uf.add(showlLabel);
        uf.add(exportLabel);

        connection = sqliteConnection.dbConnector(); //Getting the sqlite conection.
        //Below, When the frame loads, pop up message is shown to the user, idicating to click the load button to show the DB.
        JOptionPane.showMessageDialog(null, "Click LOAD DATA to view the DATABASE");
    }
    //SETTING UP THE BUTTON CLICK EVENTS
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exitButton){
            System.exit(0);
        }
        if(e.getSource()==backButton){
            uf.setVisible(false);
            new UserLogin();
        }
        if(e.getSource()==loadButton){
            try{
                String query = "select * from Information";
                PreparedStatement pst = connection.prepareStatement(query);
                ResultSet rs = pst.executeQuery();

                table.setModel(DbUtils.resultSetToTableModel(rs));

            }catch(Exception a){
                a.printStackTrace();
            }
        }
        if(e.getSource()==exportButton){
            if(table.getRowCount()==0){
                JOptionPane.showMessageDialog(null,"LOAD DATABASE FIRST!");
            }
            else{
                String osname = System.getProperty("os.name");
                String username = System.getProperty("user.name");
                if(osname.charAt(0)=='W'){ // W for windows, if L(inux) then file path changes
                    try{
                        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\"+username+"\\Desktop\\output.txt"));
                        bw.write("--------------------------------------------------------------------------------------------------------------\n");
                        bw.write("ID     |     " + "Name          |" + "        DOB        |" + "     Occupation      |" + "     FamilyType      |" + "       Status \n");
                        bw.write("--------------------------------------------------------------------------------------------------------------\n");

                        for(int i = 0;i<table.getRowCount();i++){
                            String id = (table.getValueAt(i,0).toString());
                            String name = (table.getValueAt(i,1).toString());
                            String dob = (table.getValueAt(i,2).toString());
                            String oc = (table.getValueAt(i,3).toString());
                            String ft = (table.getValueAt(i,4).toString());
                            String st = (table.getValueAt(i,5).toString());
                            bw.write(id + "   " + name + "           " + dob + "          "+ oc + "               " + ft + "             "+ st + "\n");
                        }
                        JOptionPane.showMessageDialog(null,"SUCCESSFULLY EXPORTED DATA TO DESKTOP!");
                        bw.close();
                    }
                    catch(Exception ex){
                        ex.getStackTrace();
                    }
                }
                else if(osname.charAt(0)=='L'){
                    try{
                        BufferedWriter bw = new BufferedWriter(new FileWriter("/home/"+username+"/Desktop/output.txt"));
                        bw.write("--------------------------------------------------------------------------------------------------------------\n");
                        bw.write("ID     |     " + "Name          |" + "        DOB        |" + "     Occupation      |" + "     FamilyType      |" + "       Status \n");
                        bw.write("--------------------------------------------------------------------------------------------------------------\n");

                        for(int i = 0;i<table.getRowCount();i++){
                            String id = (table.getValueAt(i,0).toString());
                            String name = (table.getValueAt(i,1).toString());
                            String dob = (table.getValueAt(i,2).toString());
                            String oc = (table.getValueAt(i,3).toString());
                            String ft = (table.getValueAt(i,4).toString());
                            String st = (table.getValueAt(i,5).toString());
                            bw.write(id + "   " + name + "           " + dob + "          "+ oc + "               " + ft + "             "+ st + "\n");
                        }
                        JOptionPane.showMessageDialog(null,"SUCCESSFULLY EXPORTED DATA TO DESKTOP!");
                        bw.close();
                    }
                    catch(Exception ex){
                        ex.getStackTrace();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Cant export data on MacOS");
                }
            } 
        }
    }
}
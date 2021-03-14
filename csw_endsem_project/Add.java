package csw_endsem_project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
public class Add implements ActionListener{
    Connection connection = null; // SQL connection, set to null initially.
    //Initializing required components
    JFrame adf = new JFrame();
    ImageIcon icon = new ImageIcon("img/add.png");
    JButton backButton = new JButton("< BACK");
    JButton saveButton = new JButton("SAVE");
    JLabel mainLabel = new JLabel("ADD INFORMATION TO THE DATABASE");
    JLabel currentLabel = new JLabel("CURRENT ENTRIES");
    JLabel newEntryLabel = new JLabel("ADD NEW ENTRY");
    JLabel idLabel = new JLabel("ID:");
    JLabel nameLabel = new JLabel("Name:");
    JLabel dobLabel = new JLabel("DOB(DD/MM/YYY):");
    JLabel ocLabel = new JLabel("OCCUPATION:");
    JLabel ftLabel = new JLabel("FAMILY TYPE:");
    JLabel statusLabel = new JLabel("STATUS:");
    JTextField idField = new JTextField();
    JTextField nameField = new JTextField();
    JTextField dobField = new JTextField();
    JTextField ocField = new JTextField();
    String statusArr[] = {"Active","Deceased"};
    JComboBox statusBox = new JComboBox<String>(statusArr);
    String famArr[] = {"Single","Joint"};
    JComboBox famBox = new JComboBox<String>(famArr);
    JScrollPane scrollPane = new JScrollPane();
    JTable table = new JTable();
    JSeparator lineSep = new JSeparator();
    Add(){
    //Setting up the JFRAME
    adf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    adf.setUndecorated(true);
    adf.setResizable(false);
    adf.setSize(1200, 560);
    adf.setVisible(true);
    adf.setLocationRelativeTo(null);
    adf.setTitle("ADD");
    adf.getContentPane().setBackground(new Color(0x1d1d1d));
    adf.setLayout(null);
    adf.setIconImage(icon.getImage());

    //setting up Back Button
    backButton.setBounds(50, 473, 90, 36);
    backButton.setBackground(new Color(0x1d1b1b));
    backButton.setFocusable(false);
    backButton.setFont(new Font("Calibri", Font.PLAIN, 19));
    backButton.setForeground(new Color(0xEEEDE7));
    backButton.addActionListener(this);

    //Setting up Save Button
    saveButton.setBounds(390, 473, 90, 36);
    saveButton.setBackground(new Color(0x1d1b1b));
    saveButton.setFocusable(false);
    saveButton.setFont(new Font("Calibri", Font.PLAIN, 19));
    saveButton.setForeground(new Color(0xEEEDE7));
    saveButton.addActionListener(this);
    
    //Setting up main label ("ADD INFO TO DB")
    mainLabel.setBounds(310, 27, 590, 40);
    mainLabel.setFont(new Font("Calibri", Font.PLAIN,36));
    mainLabel.setForeground(new Color(0xEEEDE7));
    
    //Setting up current label ("CURRENT ENTRIES")
    currentLabel.setBounds(720, 127, 270, 31);
    currentLabel.setFont(new Font("Calibri", Font.PLAIN,30));
    currentLabel.setForeground(new Color(0xEEEDE7));
    
    //Settin up new entry label ("ADD A ENTRY")
    newEntryLabel.setBounds(196, 127, 270, 31);
    newEntryLabel.setFont(new Font("Calibri", Font.PLAIN,30));
    newEntryLabel.setForeground(new Color(0xEEEDE7));
    
    //Setting up other labels
    idLabel.setBounds(100, 200, 30, 21);
    idLabel.setFont(new Font("Calibri", Font.PLAIN,21));
    idLabel.setForeground(new Color(0xEEEDE7));

    nameLabel.setBounds(100, 240, 90, 21);
    nameLabel.setFont(new Font("Calibri", Font.PLAIN,21));
    nameLabel.setForeground(new Color(0xEEEDE7));

    dobLabel.setBounds(100, 280, 165, 21);
    dobLabel.setFont(new Font("Calibri", Font.PLAIN,21));
    dobLabel.setForeground(new Color(0xEEEDE7));

    ocLabel.setBounds(100, 320, 125, 21);
    ocLabel.setFont(new Font("Calibri", Font.PLAIN,21));
    ocLabel.setForeground(new Color(0xEEEDE7));

    ftLabel.setBounds(100, 360, 120, 21);
    ftLabel.setFont(new Font("Calibri", Font.PLAIN,21));
    ftLabel.setForeground(new Color(0xEEEDE7));

    statusLabel.setBounds(100, 400, 99, 21);
    statusLabel.setFont(new Font("Calibri", Font.PLAIN,21));
    statusLabel.setForeground(new Color(0xEEEDE7));

    idField.setBounds(277,195,200,21);
    idField.setFont(new Font("Calibri", Font.PLAIN,21));
    idField.setBorder(null);
    idField.setText(Integer.toString(idGen())); //Setting 5 Digit Unique ID from the idGen() function

    nameField.setBounds(277,235,200,21);
    nameField.setFont(new Font("Calibri", Font.PLAIN,21));
    nameField.setBorder(null);

    dobField.setBounds(277,275,200,21);
    dobField.setFont(new Font("Calibri", Font.PLAIN,21));
    dobField.setBorder(null);

    ocField.setBounds(277,315,200,21);
    ocField.setFont(new Font("Calibri", Font.PLAIN,21));
    ocField.setBorder(null);

    famBox.setBounds(277,355,200,21);
    statusBox.setBounds(277,397,200,21);
    
    //Settin up the JTABLE and scroll pane
    table.setBackground(new Color(0x121212));
    table.setForeground(new Color(0xEEEDE7));
    scrollPane.setBounds(520,180,650,330);
    scrollPane.getViewport().setBackground(new Color(0x404040));
    scrollPane.setViewportView(table);
    
    //Adding a line sepatator for aeshthetic purposes
    lineSep.setOrientation(SwingConstants.VERTICAL);
    lineSep.setBounds(500,115,120,420);

    //Adding components to the JFRAME
    adf.add(lineSep);
    adf.add(scrollPane);
    adf.add(mainLabel);
    adf.add(currentLabel);
    adf.add(newEntryLabel);
    adf.add(backButton);
    adf.add(saveButton);
    adf.add(idLabel);
    adf.add(nameLabel);
    adf.add(dobLabel);
    adf.add(ocLabel);
    adf.add(ftLabel);
    adf.add(statusLabel);
    adf.add(idField);
    adf.add(nameField);
    adf.add(dobField);
    adf.add(ocField);
    adf.add(statusBox);
    adf.add(famBox);
    
    connection = sqliteConnection.dbConnector(); //Settin up the connection to SQLite

    //Below query loads the DB as soon as the frame is loaded and sets the JTABLE to show CURRENT ENTRIES
    try{
        String query = "select * from Information";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        table.setModel(DbUtils.resultSetToTableModel(rs));

    }
    catch(Exception a){
        a.printStackTrace();
    }
}   
    //Function to generate 5 digit UINIQUE ID
    public int idGen(){
        int randomNumber = new Random().nextInt(90000) + 10000;
        return randomNumber;
    }

    @Override
    //Adding Onlick action events to the Buttons
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            adf.setVisible(false);
            new Admin();
        }
        if(e.getSource()==saveButton){
            if(idField.getText().length()!=5){
                JOptionPane.showMessageDialog(null,"Please enter 5 digit Unique ID!");
            }
            else if(nameField.getText().equals("") || dobField.getText().equals("") || (ocField.getText().equals(""))){
                JOptionPane.showMessageDialog(null,"Please fill all the particulars");
            }
            else{
                try{
                    String query="INSERT INTO Information(ID,Name,DOB,Occupation,FamilyType,Status) VALUES (?,?,?,?,?,?)";
                        PreparedStatement ps = connection.prepareStatement(query);
                        ps.setString(1, idField.getText());
                        ps.setString(2, nameField.getText());
                        ps.setString(3, dobField.getText());
                        ps.setString(4, ocField.getText());
                        ps.setString(5, (String)famBox.getSelectedItem());
                        ps.setString(6, (String)statusBox.getSelectedItem());
                        
                        ps.execute();
                        ps.close();

                        String query2 = "select * from Information";
                        PreparedStatement pst = connection.prepareStatement(query2);
                        ResultSet rs = pst.executeQuery();
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                        JOptionPane.showMessageDialog(null,"Data Saved Successfully!");
                }
                catch(Exception a){
                    JOptionPane.showMessageDialog(null, "Entered ID was not unique. Generating 5 Digit Unique ID...");
                    idField.setText(Integer.toString(idGen()));
                }
            }   
        }
    }   
}
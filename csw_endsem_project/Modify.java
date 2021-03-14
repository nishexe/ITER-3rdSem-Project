package csw_endsem_project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
public class Modify implements ActionListener{
    Connection connection = null;
    JFrame mf = new JFrame();
    ImageIcon icon = new ImageIcon("img/modify.png");
    JButton backButton = new JButton("< BACK");
    JButton saveButton = new JButton("SAVE");
    JLabel mainLabel = new JLabel("MODIFY INFORMATION OF THE DATABASE");
    JLabel currentLabel = new JLabel("CURRENT ENTRIES");
    JLabel newEntryLabel = new JLabel("MODIFY A ENTRY");
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
    
    Modify(){
    mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mf.setUndecorated(true);
    mf.setResizable(false);
    mf.setSize(1200, 560);
    mf.setVisible(true);
    mf.setLocationRelativeTo(null);
    mf.setTitle("MODIFY");
    mf.getContentPane().setBackground(new Color(0x1d1d1d));
    mf.setLayout(null);
    mf.setIconImage(icon.getImage());

    backButton.setBounds(50, 473, 90, 36);
    backButton.setBackground(new Color(0x1d1b1b));
    backButton.setFocusable(false);
    backButton.setFont(new Font("Calibri", Font.PLAIN, 19));
    backButton.setForeground(new Color(0xEEEDE7));
    backButton.addActionListener(this);

    saveButton.setBounds(390, 473, 90, 36);
    saveButton.setBackground(new Color(0x1d1b1b));
    saveButton.setFocusable(false);
    saveButton.setFont(new Font("Calibri", Font.PLAIN, 19));
    saveButton.setForeground(new Color(0xEEEDE7));
    saveButton.addActionListener(this);

    
    mainLabel.setBounds(290, 27, 700, 40);
    mainLabel.setFont(new Font("Calibri", Font.PLAIN,36));
    mainLabel.setForeground(new Color(0xEEEDE7));

    currentLabel.setBounds(720, 127, 270, 31);
    currentLabel.setFont(new Font("Calibri", Font.PLAIN,30));
    currentLabel.setForeground(new Color(0xEEEDE7));

    newEntryLabel.setBounds(196, 127, 270, 31);
    newEntryLabel.setFont(new Font("Calibri", Font.PLAIN,30));
    newEntryLabel.setForeground(new Color(0xEEEDE7));


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
    
    table.setBackground(new Color(0x121212));
    table.setForeground(new Color(0xEEEDE7));
    scrollPane.setBounds(520,180,650,330);
    scrollPane.getViewport().setBackground(new Color(0x404040));
    scrollPane.setViewportView(table);

    lineSep.setOrientation(SwingConstants.VERTICAL);
    lineSep.setBounds(500,115,120,420);


    mf.add(lineSep);
    mf.add(scrollPane);
    mf.add(mainLabel);
    mf.add(currentLabel);
    mf.add(newEntryLabel);
    mf.add(backButton);
    mf.add(saveButton);
    mf.add(idLabel);
    mf.add(nameLabel);
    mf.add(dobLabel);
    mf.add(ocLabel);
    mf.add(ftLabel);
    mf.add(statusLabel);
    mf.add(idField);
    mf.add(nameField);
    mf.add(dobField);
    mf.add(ocField);
    mf.add(statusBox);
    mf.add(famBox);

    connection = sqliteConnection.dbConnector();
    try{
        String query = "select * from Information";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        table.setModel(DbUtils.resultSetToTableModel(rs));

    }catch(Exception a){
        a.printStackTrace();
    }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            mf.setVisible(false);
            new Admin();
        }
        if(e.getSource()==saveButton){
            if(idField.getText().length()!=5){
                JOptionPane.showMessageDialog(null,"Please enter a valid ID from the database!");
            }
            else if(nameField.getText().equals("") || dobField.getText().equals("") || (ocField.getText().equals(""))){
                JOptionPane.showMessageDialog(null,"Please fill all the particulars");
            }
            else{
                try {
                    String query="UPDATE Information SET Name='"+nameField.getText()+"',DOB='"+dobField.getText()+"',Occupation='"+ocField.getText()+"',FamilyType='"+(String)famBox.getSelectedItem()+"',Status='"+(String)statusBox.getSelectedItem()+"' WHERE ID='"+idField.getText()+"'"; 
                    PreparedStatement pst=connection.prepareStatement(query);
                    pst.execute();
                    
                    pst.close();
                    String query2 = "select * from Information";
                    PreparedStatement pst2 = connection.prepareStatement(query2);
                    ResultSet rs = pst2.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    JOptionPane.showMessageDialog(null,"Data was modified Successfully!");
                }
                catch(Exception g) {
                    JOptionPane.showMessageDialog(null, "Failed to modify data");
                    g.printStackTrace();
                }
            }   
        }
    }   
}
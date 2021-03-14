package csw_endsem_project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
public class Delete implements ActionListener{
    Connection connection = null; //Setting initial connection to null
    JFrame df = new JFrame();
    JButton deleteButton = new JButton("DELETE");
    JButton backButton = new JButton("< BACK");
    ImageIcon icon = new ImageIcon("img/delete.png");
    JLabel mainLabel = new JLabel("DELETE ENTRY FROM DATABASE");
    JLabel currentLabel = new JLabel("CURRENT ENTRIES");
    JScrollPane scrollPane = new JScrollPane();
    JTable table = new JTable();
    Delete(){
    //Setting up the JFRAME
    df.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    df.setUndecorated(true);
    df.setResizable(false);
    df.setSize(700, 560);
    df.setVisible(true);
    df.setLocationRelativeTo(null);
    df.setTitle("Delete");
    df.getContentPane().setBackground(new Color(0x1d1d1d));
    df.setLayout(null);
    df.setIconImage(icon.getImage());

    //Setting up the main label
    mainLabel.setBounds(81, 27, 590, 40);
    mainLabel.setFont(new Font("Calibri", Font.PLAIN,40));
    mainLabel.setForeground(new Color(0xEEEDE7));

    //Setting up the current label
    currentLabel.setBounds(230, 99, 270, 31);
    currentLabel.setFont(new Font("Calibri", Font.PLAIN,30));
    currentLabel.setForeground(new Color(0xEEEDE7));

    //Setting up the back button
    backButton.setBounds(25, 499, 90, 36);
    backButton.setBackground(new Color(0x1d1b1b));
    backButton.setFocusable(false);
    backButton.setFont(new Font("Calibri", Font.PLAIN, 19));
    backButton.setForeground(new Color(0xEEEDE7));
    backButton.addActionListener(this);

    //Setting up the delete button
    deleteButton.setBounds(556, 499, 120, 36);
    deleteButton.setBackground(new Color(0x1d1b1b));
    deleteButton.setFocusable(false);
    deleteButton.setFont(new Font("Calibri", Font.PLAIN, 19));
    deleteButton.setForeground(new Color(0xEEEDE7));
    deleteButton.addActionListener(this);

    //Seting up the JTABLE and JScroll Pane
    table.setBackground(new Color(0x121212));
    table.setForeground(new Color(0xEEEDE7));
    scrollPane.setBounds(26,160,650,330);
    scrollPane.getViewport().setBackground(new Color(0x404040));
    scrollPane.setViewportView(table);

    //Adding components to the JFRAME
    df.add(deleteButton);
    df.add(backButton);
    df.add(mainLabel);
    df.add(currentLabel);
    df.add(scrollPane);

    connection = sqliteConnection.dbConnector(); //Getting connection from SQLite
    //Below query loads as soon as the frame is loaded, fetches the DB and populates the Jtable
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
    @Override
    //Button onclick actions
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            df.setVisible(false);
            new Admin();
        }
        if(e.getSource()==deleteButton){
            try {

                int column = 0;
                int row = table.getSelectedRow();
                String idtext = table.getModel().getValueAt(row, column).toString();

                String query="DELETE FROM Information WHERE ID='"+idtext+"' ";
                PreparedStatement pst=connection.prepareStatement(query);
                pst.execute();
                pst.close();

                String query2 = "select * from Information";
                PreparedStatement pst2 = connection.prepareStatement(query2);
                ResultSet rs = pst2.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));

                JOptionPane.showMessageDialog(null,"Successfully deleted the data!");
                
            }
            catch(Exception e1) {
                JOptionPane.showMessageDialog(null,"Please select a row from the entry first!");
            }  
        }
    }
}
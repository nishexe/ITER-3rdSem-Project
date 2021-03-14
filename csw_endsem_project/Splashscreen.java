package csw_endsem_project;
import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
public class Splashscreen{
    //Init of required components
    JFrame sf = new JFrame();
    JLabel createdby = new JLabel("CREATED BY: ");
    JLabel name = new JLabel("MANISH BAG - CSE-C");
    JLabel reg = new JLabel("REG: 1941012293");
    JLabel imagelabel = new JLabel();
    ImageIcon dbimageicon = new ImageIcon("img/newimage.png");
    JLabel municipalLabel = new JLabel("MUNICIPAL DATABASE SYSTEM");
    JProgressBar bar = new JProgressBar();
    ImageIcon icon = new ImageIcon("img/logo.png");
    Splashscreen(){
    //This ordering is necessary, it messes up some things otherwise.
    sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    sf.setUndecorated(true);
    sf.setSize(600,370);
    sf.setTitle("Municipal DBMS");
    sf.setVisible(true);
    sf.setResizable(false);
    sf.setLocationRelativeTo(null);
    sf.setLayout(null);
    sf.getContentPane().setBackground(new Color(0x1d1d1d));  //Dark mode is love
    sf.setIconImage(icon.getImage());

    //Setting detes(name, reg, sec) bounds
    reg.setBounds(473, 300, 120, 120);
    name.setBounds(333, 300,400, 120);
    createdby.setBounds(501, 285, 120, 120);

    //Setting dbimage and teamimage and other labels
    imagelabel.setBounds(133, 16, 400, 300);
    municipalLabel.setBounds(15,0,700,100);
    bar.setBounds(77,285,450,18);

    //Theming lables
    reg.setFont(new Font("Calibri",Font.PLAIN,16));
    name.setFont(new Font("Calibri",Font.PLAIN,16));
    createdby.setFont(new Font("Calibri",Font.PLAIN,16));
    municipalLabel.setFont(new Font("Calibri",Font.PLAIN,45));
    municipalLabel.setForeground(new Color(0xEEEDE7));

    //adding detes lebels to the frame
    sf.add(reg);
    sf.add(name);
    sf.add(createdby);

    //adding image/other labels
    sf.add(municipalLabel);
    sf.add(imagelabel);
    imagelabel.setIcon(dbimageicon);

    //setting up progress bar
    sf.add(bar);
    bar.setBorder(null);
    bar.setBackground(new Color(0x023047)); //Progressbar BG
    bar.setForeground(new Color(0xEEEDE7)); //Progressbar FG
    bar.setBorderPainted(false);

    //Progress bar fill animation
    try{
        for(int i=0;i<=100;i++){
            Thread.sleep(54);
            bar.setValue(i);
            if(i==100){
                sf.setVisible(false);
                new Login();
            }
        }
    }catch(Exception e){};
}
}
/*NAME: Manish Bag
  REG NO.: 1941012293
  BRANCH: CSE, SEC: C
  DATE OF EDITING: 16/02/2021
 */
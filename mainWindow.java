import java.awt.Color;
import java.awt.Font;
import java.math.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class mainWindow {
    public static void main(String[] args) {
        //#region mainWindow
        JFrame mainWindow = new JFrame();
        mainWindow.setTitle("ML gui");//change this later
        mainWindow.setSize(1440,1020);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLayout(null);
//#endregion
        
//#region titleLabel
        JLabel titleLabel = new JLabel();
        Border titleBorder = BorderFactory.createLineBorder(Color.red,2);
        ImageIcon titleIcon = new ImageIcon("Images/titleIcon.png"); 

        int titleLabel_width = 500;
        int titleLabel_height = 150;
        int titleLabel_xpos =  mainWindow.getWidth() / 2 - titleLabel_width/2;
        int titleLabel_ypos = (int)(mainWindow.getHeight() - (mainWindow.getHeight() * 0.95));

        titleLabel.setBorder(titleBorder);
        titleLabel.setBounds(titleLabel_xpos, titleLabel_ypos, titleLabel_width, titleLabel_height);
        titleLabel.setText("Emotional Speech Recognition");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setIcon(titleIcon);
        titleLabel.setBackground(Color.gray);
        titleLabel.setOpaque(true);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.TOP);
//#endregion

//#region fileExplorer

        JLabel fileExplorerLabel = new JLabel();
        ImageIcon fileExplorerIcon = new ImageIcon("Images/fileExplorerIcon.png");
        Border fileExplorerBorder = BorderFactory.createLineBorder(Color.black, 1);
        
        int fileExplorerLabel_width = 150;
        int fileExplorerLabel_height = 20;
        int fileExplorerLabel_xpos = 100;
        int fileExplorerLabel_ypos = 300;
        
        fileExplorerLabel.setBorder(fileExplorerBorder);
        fileExplorerLabel.setBounds(fileExplorerLabel_xpos, fileExplorerLabel_ypos, fileExplorerLabel_width, fileExplorerLabel_height);
        fileExplorerLabel.setText("File Explorer");
        fileExplorerLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        fileExplorerLabel.setIcon(fileExplorerIcon);
        fileExplorerLabel.setBackground(Color.LIGHT_GRAY);
        fileExplorerLabel.setOpaque(true);

        
//#endregion
        mainWindow.add(titleLabel);
        mainWindow.add(fileExplorerLabel);
        mainWindow.setVisible(true);
        
        
        //frame.add(lblFileExplorer);
    }
}

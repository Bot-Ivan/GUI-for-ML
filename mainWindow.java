import java.awt.Color;
import java.math.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class mainWindow {
    public static void main(String[] args) {
        // JFrame = a GUI window to add components to
        JFrame mainWindow = new JFrame();
        mainWindow.setTitle("ML gui");//change this later
        //#region
        mainWindow.setSize(1000,1000);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLayout(null);
        Border titleBorder = BorderFactory.createLineBorder(Color.red,1);
        

        ImageIcon titleIcon = new ImageIcon("Images/titleIcon.png"); 
        JLabel titleLabel = new JLabel();

        int titleLabel_width = 200;
        int titleLabel_height = 200;

        int titleLabel_xpos =  mainWindow.getWidth() / 2 - titleLabel_width/2;
        int titleLabel_ypos = (int)(mainWindow.getHeight() - (mainWindow.getHeight() * 0.95));


        titleLabel.setBorder(titleBorder);
        titleLabel.setBounds(titleLabel_xpos, titleLabel_ypos, titleLabel_width, titleLabel_height);
        titleLabel.setText("Emotional Speech Recognition");
        titleLabel.setIcon(titleIcon);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.TOP);

        JLabel lblFileExplorer = new JLabel();
        lblFileExplorer.setText("File Explorer");


        mainWindow.setVisible(true);
        mainWindow.add(titleLabel);
        //frame.add(lblFileExplorer);
    }
}

import java.awt.Color;
import java.awt.Font;
import java.math.*;

import javax.swing.border.Border;

import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class mainWindow extends JFrame implements ActionListener{

        JButton FEbutton;
    public static void main(String[] args) {
        new mainWindow();
    }

    public mainWindow(){

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
        ImageIcon titleIcon = new ImageIcon("C:\\Users\\Ivan\\Desktop\\Java ML gui\\GUI-for-ML\\images\\titleIcon.png"); 

        int titleLabel_width = 500;
        int titleLabel_height = 150;
        int titleLabel_xpos =  mainWindow.getWidth() / 2 - titleLabel_width/2;
        int titleLabel_ypos = (int)(mainWindow.getHeight() - (mainWindow.getHeight() * 0.95));

        titleLabel.setBorder(titleBorder);
        titleLabel.setBounds(titleLabel_xpos, titleLabel_ypos, titleLabel_width, titleLabel_height);
        titleLabel.setText("Emotional Speech Recognition");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setIcon(titleIcon);
        titleLabel.setBackground(Color.lightGray);
        titleLabel.setOpaque(true);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.TOP);
//#endregion

//#region fileExplorer

        JLabel fileExplorerLabel = new JLabel();
        Border fileExplorerBorder = BorderFactory.createLineBorder(Color.black, 1);
        ImageIcon fileExplorerIcon = new ImageIcon("C:\\Users\\Ivan\\Desktop\\Java ML gui\\GUI-for-ML\\images\\fileExplorerIcon.png");
        
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
        //region FEbutton
        FEbutton = new JButton("Select Dataset");
        FEbutton.setBounds(100, 350, 150, 30);
        FEbutton.addActionListener(this);
//#endregion
        mainWindow.add(titleLabel);
        mainWindow.add(fileExplorerLabel);
        mainWindow.add(FEbutton);
        mainWindow.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button click action here
        System.out.println("Button Clicked");
        if(e.getSource()==FEbutton){
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                        File selectedFolder = fileChooser.getSelectedFile();
                        System.out.println("Selected Folder: " + selectedFolder.getAbsolutePath());
                }
        }
    }
}

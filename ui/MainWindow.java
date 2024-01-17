package ui;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import filehandling.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MainWindow extends JFrame implements ActionListener {

    Path currPath = Paths.get(System.getProperty("user.dir"));
    private JButton FEbutton;

    // Use a relative path for the datasetinfo directory
    private String datasetinfo_dir = "datasetinfo/datasetinfo.txt";
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> new MainWindow());
    }

    public MainWindow() {
        System.out.println(datasetinfo_dir);
        initializeUI();
    }

    private void initializeUI(){
        this.setTitle("ML gui");
        this.setSize(1440, 1020);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        JLabel titleLabel = createTitleLabel("Machine learning gui", 500, 150, getWidth()/2-500/2, (int) (getHeight() - (getHeight() * 0.95)));
        FEbutton = createSelectDatasetButton();

        this.add(titleLabel);
        this.add(FEbutton);
        this.setVisible(true);
    }

    private JLabel createTitleLabel(String text, int width, int height, int xPos, int yPos) {
        JLabel label = new JLabel(text);
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        ImageIcon titleIcon = new ImageIcon("C:\\Users\\Ivan\\Desktop\\Java ML gui\\GUI-for-ML\\images\\titleIcon.png");
        label.setBorder(border);
        label.setBounds(xPos, yPos, width, height);
        label.setText(text);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setIcon(titleIcon);
        label.setBackground(Color.lightGray);
        label.setOpaque(true);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        return label;
    }

    private JButton createSelectDatasetButton() {
        JButton button = new JButton("Select Dataset");
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == FEbutton) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int result = fileChooser.showOpenDialog(null);
            
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFolder = fileChooser.getSelectedFile();
                System.out.println("Selected Folder: " + selectedFolder);

                FileHandler filehandler = new FileHandler();
                filehandler.writeToFile(datasetinfo_dir, selectedFolder.getAbsolutePath());
            }

    
    }


}

}
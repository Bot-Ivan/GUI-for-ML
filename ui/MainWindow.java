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
    private JButton SD_button;
    private JLabel title_Label;
    private String datasetinfo_dir = "datasetinfo/datasetinfo.txt";
    private JLabel metadataLabel;
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> new MainWindow());
        
    }

    public MainWindow() {
        initializeUI();
    }

    private void initializeUI(){
        this.setTitle("ML gui");
        this.setSize(1440, 1020);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.black);

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setBackground(Color.gray);

        JPanel westPanel = new JPanel(new BorderLayout());
        westPanel.setPreferredSize(new Dimension(400, 200));
        westPanel.setBackground(Color.lightGray);

        JPanel westPanel_metadata = new JPanel(new BorderLayout());
        title_Label = createTitleLabel();
        SD_button = createSelectDatasetButton(); // select dataset button
        metadataLabel = createmetadataLabel();

        westPanel.add(SD_button, BorderLayout.NORTH);
        westPanel_metadata.add(metadataLabel, BorderLayout.NORTH);
        westPanel.add(westPanel_metadata, BorderLayout.CENTER);
        

        topPanel.add(title_Label);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(westPanel, BorderLayout.WEST);
        
        this.add(mainPanel);
        this.setVisible(true);

    }

    private JLabel createmetadataLabel(){
        JLabel label = new JLabel();
        Border border = BorderFactory.createLineBorder(Color.black, 2);
        ImageIcon metadataicon = new ImageIcon("images\\metadataicon.png");
        label.setBorder(border);
        label.setIcon(metadataicon);
        label.setBackground(Color.white);
        label.setOpaque(true);
        label.setVisible(true);
        label.setText("Testesttasfasetetset\\nfasdfasdfsadfasdfasdf\\ntestestetsetstetestetste\\ntestetestestestestest\\ntestestetsetet");

        return label;
    }

    private JLabel createTitleLabel() {
        JLabel label = new JLabel();
        Border border = BorderFactory.createLineBorder(Color.black, 2);
        ImageIcon titleIcon = new ImageIcon("images\\titleIcon.png");
        label.setBorder(border);
        label.setText("Machine learning gui");
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
        //Insets margins = new Insets(5, 5, 5, 5);

        JButton button = new JButton("Select Dataset");
        Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
        ImageIcon fileExplorerIcon = new ImageIcon("images\\fileExplorerIcon.png");

       //button.setMargin(margins);
        button.setBorder(border);
        button.setIcon(fileExplorerIcon);
        button.setBackground(Color.lightGray);
        button.setOpaque(true);
        button.addActionListener(this);
        button.setAlignmentX(CENTER_ALIGNMENT);
        
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == SD_button) {
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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class mainWindow {
    public static void main(String[] args) {
        // JFrame = a GUI window to add components to
        JFrame frame = new JFrame();
        frame.setTitle("ML gui");//change this later
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        ImageIcon titleIcon = new ImageIcon("Images/titleIcon.png");
        JLabel titleLabel = new JLabel();
        titleLabel.setText("Emotional Speech Recognition");
        titleLabel.setIcon(titleIcon);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.TOP);
        frame.add(titleLabel);
        frame.setVisible(true);
    }
}

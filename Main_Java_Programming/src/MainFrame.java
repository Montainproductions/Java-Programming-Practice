import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.JButton;
//import javax.swing.WindowConstants;

//https://www.tabnine.com/code/java/classes/javax.swing.JFrame

public class MainFrame extends JFrame{
    JFrame myFrame = new JFrame("Math/Life Calculator");

    int buttonWidth = 95;
    int buttonHeight = 30;
    /* Set up pop up window */
    public void init(){
        //Create popup and have it full screen and close when pressing X
        myFrame.setPreferredSize(new Dimension(600, 500));
        myFrame.pack();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        starterPage();

        myFrame.setLayout(null);
        myFrame.setVisible(true);
    }

    public void starterPage(){
        JButton enterButton = new JButton("Enter");
        enterButton.setFocusable(false);
        enterButton.setBounds(180,400,buttonWidth,buttonHeight); //setBounds(X Coordinates, Y Coordinates, Width, Height)
        myFrame.add(enterButton);

        String[] possibleMethods = {"", "Balloon Inflation", "Internet Plan", "Minimum", "Mixed Fraction", "Range"};
        final JComboBox<String> reasonEntering = new JComboBox<String>(possibleMethods);
        reasonEntering.setBounds(200, 150, 200, 30);
        myFrame.add(reasonEntering);

        enterButton.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {       
                System.out.println("Programming language Selected: " + reasonEntering.getItemAt(reasonEntering.getSelectedIndex()));
                //label.setText(data);
            }
        });
        closeButton();
    }

    public void enterButton() {
        //Enter button
        JButton enterButton = new JButton("Enter");
        enterButton.setFocusable(false);
        enterButton.setBounds(180,400,buttonWidth,buttonHeight); //setBounds(X Coordinates, Y Coordinates, Width, Height)
        myFrame.add(enterButton);
        enterButton.addActionListener(e -> {myFrame.dispose();});
    }

    public void closeButton() {
        //Close button
        JButton closeButton = new JButton("Close");
        closeButton.setFocusable(false);
        closeButton.setBounds(330,400,buttonWidth,buttonHeight); //setBounds(X Coordinates, Y Coordinates, Width, Height)
        myFrame.add(closeButton);
        closeButton.addActionListener(e -> {myFrame.dispose();});
    }
}

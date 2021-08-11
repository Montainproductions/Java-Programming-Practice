import javax.swing.*;
import java.awt.*;
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
        //myFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        myFrame.setPreferredSize(new Dimension(600, 500));
        myFrame.pack();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        reasonEntering();

        /*JTextField t1,t2;  
        t1=new JTextField("Welcome to Javatpoint.");  
        t1.setBounds(50,100, 200,30);  
        t2=new JTextField("AWT Tutorial");  
        t2.setBounds(50,150, 200,30);  
        myFrame.add(t1); myFrame.add(t2);*/

        enterButton();
        closeButton();

        myFrame.setLayout(null);
        myFrame.setVisible(true);
    }

    public void reasonEntering() {
        String[] possibleMethods = {"", "Internet Plan", "Balloon Inflation", "Mixed Fraction", "Minimum", "Range"};

        final JComboBox<String> reasonEntering = new JComboBox<String>(possibleMethods);
        reasonEntering.setBounds(50, 100, 200, 30);
        myFrame.add(reasonEntering);
    }

    public void enterButton() {
        //Enter button
        JButton enterButton = new JButton("Enter");
        enterButton.setFocusable(false);
        enterButton.setBounds(180,400,buttonWidth,buttonHeight); //setBounds(X Coordinates, Y Coordinates, Width, Height)
        myFrame.add(enterButton);
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

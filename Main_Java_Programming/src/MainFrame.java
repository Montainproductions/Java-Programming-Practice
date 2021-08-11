import javax.swing.*;
import java.awt.*;
//import javax.swing.JButton;
//import javax.swing.WindowConstants;

//https://www.tabnine.com/code/java/classes/javax.swing.JFrame

public class MainFrame extends JFrame{
    JFrame myFrame = new JFrame();

    int buttonWidth = 95;
    int buttonHeight = 30;
    /* Set up pop up window */
    public void initPopUp(){
        //Create popup and have it full screen and close when pressing X
        //myFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        myFrame.setPreferredSize(new Dimension(600, 500));
        myFrame.pack();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        enterButton();
        closeButton();

        myFrame.setLayout(null);
        myFrame.setVisible(true);
    }


    public void enterButton() {
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

import javax.swing.*;
//import javax.swing.JButton;
//import javax.swing.WindowConstants;

//https://www.tabnine.com/code/java/classes/javax.swing.JFrame

public class MainFrame extends JFrame{
    JFrame myFrame = new JFrame();

    /* Set up pop up window */
    public void initPopUp(){
        
        myFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        String[] buttonsToMake = {"Close", "Enter"};
        button(buttonsToMake);
        myFrame.setLayout(null);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }

    public void button(String[] buttonNames) {
        for (int i = 0; i < buttonNames.length - 1; i++) {
            JButton newButton = new JButton(buttonNames[i]);
            newButton.setFocusable(false);
            newButton.setBounds(50,100,95,30);
            myFrame.add(newButton);
        }
    }
}

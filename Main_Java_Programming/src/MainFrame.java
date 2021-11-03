import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class MainFrame extends JFrame{
    JFrame myFrame = new JFrame("Math/Life Calculator");
    App mainApp = new App();

    //Button sizes
    int buttonWidth = 95;
    int buttonHeight = 30;

    //Array of all possible methods that can be chossen and used by the user.
    String[] possibleMethods = {"", "Balloon Inflation", "Internet Plan", "Minimum", "Mixed Fraction", "Range", "Stirlings Aproximation"};
    final JComboBox<String> reasonEntering = new JComboBox<String>(possibleMethods);

    //Balloon inflation variables
    JTextField ballonAmount = new JTextField();
    JTextField gasAmount = new JTextField();

    /* Set up pop up window */
    public void init(){
        //Create popup and have it full screen and close when pressing X
        myFrame.setPreferredSize(new Dimension(600, 600));
        myFrame.pack();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        starterPage();

        //Allow the gui to be closed through a butten.
        closeButton();
        myFrame.setLayout(null);
        myFrame.setVisible(true);
    }

    public void starterPage(){
        //Gives user the options that they can choose.
        reasonEntering.setFocusable(false);
        reasonEntering.setBounds(240, 0, 130, buttonHeight);
        myFrame.add(reasonEntering);
        methodChoosen();
    }

    public void nextPageSetUp(String problemToSolve){
        switch (problemToSolve) {
            case "Balloon Inflation":
                ballonInflationScreen();
                break;
            
            case "Internet Plan":
                internetPlanScreen();
                break;
            
            case "Minimum":
                minimumScreen();
                break;

            case "Mixed Fraction":
                mixedFractionScreen();
                break;

            case "Range":
                rangeScreen();
                break;

            case "Stirlings Aproximation":
                stirlingsApproximationScreen();
                break;

            default:
                System.out.println("You have not choosen a method. Choose one before continuing.");
                break;
        }
    }

    public void ballonInflationScreen(){
        myFrame.getContentPane().removeAll();
        myFrame.repaint();

        //Create new items
        JLabel ballonAmountText = new JLabel("Amount of Ballons");
        JLabel gasAmountText = new JLabel("Amount of Gas for Ballons");

        //Placement positions for items
        ballonAmountText.setBounds(67, 110, 120, 50);
        gasAmountText.setBounds(317, 110, 150, 50);
        ballonAmount.setBounds(65, 150, 200, 30);
        gasAmount.setBounds(315, 150, 200, 30);
        
        myFrame.add(ballonAmountText);
        myFrame.add(gasAmountText);
        myFrame.add(ballonAmount);
        myFrame.add(gasAmount);

        ballonInflationSendingInfo();

        //Close App
        closeButton();
    }

    public void internetPlanScreen(){}

    public void minimumScreen(){}

    public void mixedFractionScreen(){}

    public void rangeScreen(){}

    public void stirlingsApproximationScreen(){}

    public void ballonInflationSendingInfo(){
        //Will grab the strings in the two text entries and send them to the corrisponding ballon inglation method in the other file.
        JButton enterButton = new JButton("Enter");
        enterButton.setFocusable(false);
        enterButton.setBounds(180,400,buttonWidth,buttonHeight); //setBounds(X Coordinates, Y Coordinates, Width, Height)
        myFrame.add(enterButton);

        enterButton.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
                String currentBallonAmount = ballonAmount.getText();
                //Checks if a ballon amount has been given else it sends a message.
                if(currentBallonAmount == ""){
                    System.out.println("You have not placed the amount of ballons.");
                }else{
                    String currentGasAmount = gasAmount.getText();
                    if(currentGasAmount == ""){
                        System.out.println("You have not placed the amount of gas.");
                    }else{
                        String currentGasAmountArray[] = currentGasAmount.split(",");
                        ArrayList<String> A = new ArrayList<>(Arrays.asList(currentGasAmountArray));
                        
                        ArrayList<Integer> integerArrayGasAmount = new ArrayList<Integer>();
                        for(String stringValue : A){integerArrayGasAmount.add(Integer.parseInt(stringValue));} //Goes through the arraylist<String> and turns it into an

                        int intValueCurrentBallonAmount = Integer.parseInt(currentBallonAmount); //Converts the amount of ballons from string to int
                        mainApp.Inflation(intValueCurrentBallonAmount,integerArrayGasAmount);
                    }
                }
            }
        });
    }

    public void methodChoosen(){
        JButton enterButton = new JButton("Enter");
        enterButton.setFocusable(false);
        enterButton.setBounds(260,400,buttonWidth,buttonHeight); //setBounds(X Coordinates, Y Coordinates, Width, Height)
        myFrame.add(enterButton);

        
        enterButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                String currentMethod = reasonEntering.getItemAt(reasonEntering.getSelectedIndex());
                if(currentMethod == ""){System.out.println("You have not choosen a method");}
                else{nextPageSetUp(currentMethod);}
            }
        });
    }

    /* The close button which wont really need to change were it is or what it does */
    public void closeButton() {
        //Close button
        JButton closeButton = new JButton("Close");
        closeButton.setFocusable(false);
        closeButton.setBounds(260,500,buttonWidth,buttonHeight); //setBounds(X Coordinates, Y Coordinates, Width, Height)
        myFrame.add(closeButton);
        closeButton.addActionListener(e -> {myFrame.dispose();});
    }

    //public static void main(String[] args){MainGuiApp f = new MainGuiApp();};
}

import javax.swing.*;
//import javax.swing.JButton;
//import javax.swing.WindowConstants;

//https://www.tabnine.com/code/java/classes/javax.swing.JFrame

public class MainFrame extends JFrame{
    public void init(){
        setTitle("Main variable input field.");
        JButton b=new JButton("Click Here");
        b.setBounds(50,100,95,30); //x axis, y axis, width, height 
        add(b);
        setSize(400,400);
        setLayout(null);
        setVisible(true);
    }
}

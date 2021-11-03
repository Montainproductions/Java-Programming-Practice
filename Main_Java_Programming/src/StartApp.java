//This file is so that I can run the program with out having to do much scrolling in my code.
//At the same time when I try to run it in either MainFrame.java or App.java it dosent work since both files require to call each other to work and causes a loop without an exit.
public class StartApp{
    public StartApp(){
        MainFrame appFrame = new MainFrame();
        appFrame.init();
    }

    public static void main(String[] args){StartApp f = new StartApp();};
}
package viewer;

import javax.swing.JFrame;

public class BaseWindow {

    public final static int WINDOW_WIDTH = 1015;
    public final static int WINDOW_HEIGHT = 815;
    
    MainGameView mainGameView ; 
	
    public BaseWindow(){
		
        JFrame window = new JFrame("PokmonGoPack");
        mainGameView = new MainGameView();
        window.setContentPane(mainGameView);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(120,70);
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setResizable(false);
        window.setVisible(true);
	}
	
}

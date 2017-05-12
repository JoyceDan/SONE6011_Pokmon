package viewer;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class MainGameView extends JPanel {

    public final static int WINDOW_WIDTH = 1200;
    public final static int WINDOW_HEIGHT = 722;   
    
	private ArrayList<Coordinate> jpanels ;
	
	public HandView handBoard;
	public BenchView bench;
	public AttackCardView attack;
	
	public HandView handBoard_Player;
	public BenchView bench_Player;
	public AttackCardView attack_Player;
	
    /**
     * Constructor sets all views used in the game view.
     */
    public MainGameView() {
 	   jpanels = new ArrayList<Coordinate>();
       setBackground(  Color.cyan);
       setBorder( BorderFactory.createEmptyBorder(5,5,5,5) );
       
       handBoard = new HandView( false );
       jpanels.add(handBoard);
       bench = new BenchView ();
       jpanels.add(bench);
       attack = new AttackCardView(false);
       jpanels.add(attack);
     
       attack_Player = new AttackCardView(true);
       jpanels.add(attack_Player);
       bench_Player = new BenchView ();
       jpanels.add(bench_Player);
       handBoard_Player = new HandView(true);
       jpanels.add(handBoard_Player);
   
       setLayout(null);
       
       for (int i = 0 ; i < jpanels.size() ; i++ ){
    	   add((JPanel)jpanels.get(i)); 
    	   ((JPanel) jpanels.get(i)).setBackground(Color.BLUE);
    	   jpanels.get(i).setXY(5,  125 * i + 5 + (5 * i)  );
    	 
       }
      
    }
}

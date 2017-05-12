package viewer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;

import model.Card;
import model.Deck;

public class AttackCardView extends JPanel implements Coordinate {
	 int x ;
	 int y ;
	   
	 Deck deck;       // A deck of cards to be used in the game.   
     Card card ;
     Font smallFont;    // Font that will be used to draw the cards.
     boolean player;
     JButton doAction;
     String[] petStrings = { "attack", "attack", "attack" };
     JComboBox petList ; 
     public AttackCardView( boolean player){
    	 this.player = player ; 
    	 setLayout(null);  
         setPreferredSize( new Dimension(450, 125));
         inti();
	   }
     
     void inti() {
    	 System.out.println(player);
    	 if(player){
    		 
	    	petList = new JComboBox(petStrings);
	    	petList.setSelectedIndex(0);
	    	JButton doAction = new JButton("Do_Action");
	    	add(petList);
	    	add(doAction);
	    	
	    	petList.setBounds(510, 40, 120, 20);
	    	doAction.setBounds(510,70, 120, 20);
    	 }
         deck = new Deck();   // Create the deck and hand to use for this game.
   
         smallFont = new Font("SansSerif", Font.PLAIN, 12);
         deck.shuffle();
         card  =  deck.dealCard();  // Deal the first card into the hand.
     } // end doNewGame()

     public void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.setFont(smallFont);
         drawCard(g, card, getWidth()/2 - 80 , 10);

     } // end paintComponent()


 	   /**
 	    * Draws a card as a 80 by 100 rectangle with upper left corner at (x,y).
 	    * The card is drawn in the graphics context g.  If card is null, then
 	    * a face-down card is drawn.  (The cards are rather primitive!)
 	    */
 	   public  void drawCard(Graphics g, Card card, int xCoor, int yCoor) {
 	       if (card == null) {  
 	           // Draw a face-down card
 	           g.setColor(Color.RED);
 	           g.fillRect(xCoor , yCoor,80,100);
 	           g.setColor(Color.WHITE);
 	           g.drawRect(xCoor+3 ,yCoor+3 ,73,93);
 	           g.drawRect(xCoor+4 ,yCoor+4 ,71,91);
 	       }
 	       else {
 	           g.setColor(Color.WHITE);
 	           g.fillRect(xCoor ,yCoor ,80,100);
 	           g.setColor(Color.GRAY);
 	           g.drawRect(xCoor ,yCoor ,79,99);
 	           g.drawRect(xCoor+1 ,yCoor+1  ,77,97);
 	           g.setColor(Color.RED);
 	           g.drawString(card.getValueAsString(), xCoor + 10 , yCoor + 30 );
 	           g.drawString("of", xCoor+ 10, yCoor + 50);
 	           g.drawString(card.getSuitAsString(), xCoor + 10, yCoor + 70 );
 	       }
 	   } //

	@Override
	public void setXY(int x, int y) {
		this.x = x ;
		this.y = y ;
		setBounds(x , y, 1000 , 125 );
		repaint();
	}
     
}

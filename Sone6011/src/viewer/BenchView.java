package viewer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Card;
import model.Deck;
import model.Hand;

public class BenchView extends JPanel implements Coordinate{
	
	private int x ;
	private int y ;
	private Deck deck;       // A deck of cards to be used in the game.
    private Hand hand;       // The cards that have been dealt.
    private Font smallFont;    // Font that will be used to draw the cards.
    
	 public BenchView(){
        setPreferredSize( new Dimension(450, 125));
        init();
	   }
	   
	   void init() {
        deck = new Deck();   // Create the deck and hand to use for this game.
        hand = new Hand();
        deck.shuffle();
        hand.addCard( deck.dealCard() );  // Deal the first card into the hand.
    } // end doNewGame()
	   
	   
	   /**
     * This method draws the message at the bottom of the
     * panel, and it draws all of the dealt cards spread out
     * across the canvas.  If the game is in progress, an extra
     * card is drawn face down representing the card to be dealt next.
     */
	   public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.setFont(smallFont);
	        g.setFont(smallFont);
	        g.setColor(Color.RED);
	        g.fillRect(10 + 2 * 90 , 5, 570, 115);
	        g.setColor(Color.WHITE);
	        g.drawRect(10 + 2 * 90 -1  ,5 - 1 ,570 + 1, 115 + 1);
	        g.drawRect(10 + 2 * 90  ,5 ,570 , 115 );
	        int cardCt = hand.getCardCount();
	        for (int i = 0; i < cardCt; i++)
	            drawCard(g, hand.getCard(i), 10 + (i + 2) * 90 + 5, 10);
	 
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
		           g.drawString(card.getSuitAsString(), xCoor + 10 , yCoor + 70 );
		       }
		   } //



	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public void setXY(int x, int y) {
		this.x = x ;
		this.y = y ;
		setBounds(x , y, 1000 , 125 );
		repaint();
	}
}
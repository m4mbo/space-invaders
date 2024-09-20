import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

// the score is not an entity because it doesn't have a speed

public class Score{
	
	private int score;											// integer value that holds the current score
	
	// constructor
	
	public Score(){
		score = 0;												// initialize score to 0
	}
	
	// method to add one to the score
	
	public void increaseScore() {
		score++;
	}
	
	// getter
	
	public int getScore() {
		return score;
	}
	
	// method to draw the string value of the score into the panel
	
	public void draw(Graphics g) {
		
		g.setColor(Color.white);								// setting font color to white
		g.setFont(new Font("Consolas", Font.PLAIN, 30));		// setting font type
		
		g.drawString(String.valueOf(score), 600-80, 40);		// converting the integer value into string to then draw it
	}
	
}

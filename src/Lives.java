import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

// object to keep track of the lives

public class Lives {
	
	private int lives;													// integer value that holds number of lives
	
	Image image;														// heart image
	
	// constructor
	
	public Lives(Image image){
		lives = 3;														// initialize with 3 lives
		this.image = image;
	}
	
	// drawing function
	
	public void draw(Graphics g) {
		
		Graphics2D g2D = (Graphics2D)g;
		
		g2D.drawImage(image, 30, 25, null);								// always draw the first heart
		
		if (lives>=2) {
			
			g2D.drawImage(image, 60, 25, null);							// if there are two lives, draw the second one
			
		} 
		
		if(lives==3) {
			
			g2D.drawImage(image, 90, 25, null);							// if there are three lives, draw the third one
			
		}
		
	}
	
	// method to take one life
	
	public void takeLife() {
		lives--;
	}
	
	// getter
	
	public int getLives() {
		return lives;
	}
	
	
	
}

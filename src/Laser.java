import java.awt.Color;
import java.awt.Graphics;

// child of super class entity, because lasers have a position and a speed

public class Laser extends Entity{
	
	private int width;											// width
	private int height;											// and height of the laser
	
	// constructor of laser object
	
	public Laser(int x, int y, int speed, int width, int height) {
		
		super(x,y,speed);										// inherited constructor
		
		this.width = width;										// width
		
		this.height = height;									// height
	}
	
	public void draw(Graphics g) {
		
		g.setColor(Color.red);									// set the color of the laser to red
		g.fillRect(this.x, this.y, this.width, this.height);	// draw a rectangle with the width and height provided
		
	}
	
	// move the laser up
	
	public void move() {
		
		this.y = y-speed;
	}
}

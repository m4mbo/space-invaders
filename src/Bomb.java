import java.awt.Color;
import java.awt.Graphics;

// bombs will inherit entity properties as they have a position and speed

public class Bomb extends Entity{
	
	private int width;												// dimensions
	private int height;												// of bombs
	
	// constructor
	
	public Bomb(int x, int y, int speed, int width, int height) {
		
		super(x,y,speed);											// inherited constructor
		
		this.width = width;
		
		this.height = height;
	}
	
	// drawing method that creates an oval and draws it into the panel
	
	public void draw(Graphics g) {
		g.setColor(Color.white);									// setting oval color to white
		g.fillOval(this.x, this.y, this.width, this.height);		// drawing oval with the provided dimensions
	}
	
	// method to increase the bomb's y position by the speed
	
	public void move() {
		
		this.y = y+speed;
	}
}
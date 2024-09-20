import java.awt.Graphics;
import java.util.LinkedList;

public class LaserGun {
	
	private LinkedList<Laser> lasers = new LinkedList<Laser>();								// linked list of type laser that will hold all the current lasers
	
	Laser TempLaser;																		// creating a temporary laser 
	
	// constructor 
	
	public LaserGun() {											
		
	}
	
	// move function that iterates through the linked list and calls the move function for each laser
	
	public void move() {
		
		for(int i = 0; i < lasers.size(); i++) {
			
			TempLaser = getLaser(i);														// get the laser from the linked list with the imported linked list method: "get"
			
			if(TempLaser.y <= 0) {
				
				// if the laser y position is less or equal to zero (beyond the panel bounds)
				
				removeLaser(TempLaser);														// remove the laser								
				
			}else {
				
				TempLaser.move();															// call the move function for that laser			
			}
		}
	}
	
	// iterating through the linked list and calling the draw function for each laser
	
	public void draw(Graphics g) {
		
		for(int i = 0; i < size(); i++) {
			
			TempLaser = getLaser(i);														// getting the laser
			
			TempLaser.draw(g);																// calling the draw function
		}
	}
	
	// method to add a laser to the linked list
	
	public void addLaser(Laser l) {
		lasers.add(l);
	}
	
	// method to remove a laser from the linked list
	
	public void removeLaser(Laser l) {
		lasers.remove(l);
	}
	
	// method to get the size of the linked list
	
	public int size() {
		return lasers.size();
	}
	
	// method to get a particular laser from the lasergun linked list
	
	public Laser getLaser(int i) {
		return lasers.get(i);
	}
	
}

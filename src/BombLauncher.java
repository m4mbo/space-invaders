import java.awt.Graphics;
import java.util.LinkedList;

public class BombLauncher {
	
	private LinkedList<Bomb> bombs = new LinkedList<Bomb>();						// linked list of type bomb that will hold all the current bombs
	
	Bomb TempBomb;																	// temporary bomb variable
	
	// constructor
	
	public BombLauncher() {
		
	}
	
	// function that iterates through the linked list and calls the move function for each bomb
	
	public void move() {
		for(int i = 0; i < bombs.size(); i++) {
			
			TempBomb = getBomb(i);
			
			if(TempBomb.y >= 700) {
				removeBomb(TempBomb);												// if the bomb is out of panel bounds, remove it
			}else {
				TempBomb.move();													// calls move function
			}	
		}
	}
	
	// method that iterates through the linked list and calls draw method for each bomb
	
	public void draw(Graphics g) {
		for(int i = 0; i < size(); i++) {
			
			TempBomb = getBomb(i);													// getting the bomb
			
			TempBomb.draw(g);														// drawing it
		}
	}
	
	// adding bomb to linked list
	
	public void addBomb(Bomb b) {
		bombs.add(b);
	}
	
	// removing bomb from linked list
	
	public void removeBomb(Bomb b) {
		bombs.remove(b);
	}
	
	// size of linked list
	
	public int size() {
		return bombs.size();
	}
	
	// getting bomb from linked list
	
	public Bomb getBomb(int i) {
		return bombs.get(i);
	}
	
}

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

// panel class that inherits panel methods and implements the event key listener class, as well as the runnable class to create a thread

public class SpacePanel extends JPanel implements Runnable, KeyListener{
	
	private static final int PANEL_WIDTH = 600;											// panel
	private static final int PANEL_HEIGHT = 700;										// dimensions
	
	private boolean gameOver;															// logic variables
	private boolean gameStart;															// that will determine the current state of the game
	
	// declaring game variables
	
	Thread gameThread;
	Graphics graphics;
	Player player;
	LaserGun lasergun;
	AlienHorde alienhorde;
	Image backgroundImage;
	Image title;
	Image gameover;
	Image image;
	BombLauncher bomblauncher;
	Score score;
	Lives lives;
	
	// constructor
	
	public SpacePanel() {
		
		gameOver = false;																// initializing
		gameStart = false;																// logic variables as false
		
		setSize(PANEL_WIDTH, PANEL_HEIGHT);												// setting the size of the panel
	    addKeyListener(this);															// adding a key listener
	    setFocusable(true);																// setting focusable to true to receive keyboard input
	    
	    backgroundImage = new ImageIcon("../res/starrysky.png").getImage();				// creating a new background image with png file
	    title = new ImageIcon("../res/Title.png").getImage();							// creating a new title image with png file
	    gameover = new ImageIcon("../res/Gameover.png").getImage();						// creating a new game over image with png file
	    
	    score = new Score();															// initializing new score object
	    lives = new Lives(new ImageIcon("../res/Heart.png").getImage());				// creating a new lives object with heart png file as parameter
	    
	    player = new Player((PANEL_WIDTH/2) - 30, (PANEL_HEIGHT - 65), 10, new ImageIcon("../res/Player.png").getImage());			// creating a new player with its position and png file
	    lasergun = new LaserGun();														// creating new laser gun
	    bomblauncher = new BombLauncher();												// creating new bomb launcher
	    alienhorde = new AlienHorde(new ImageIcon("../res/Alien.gif").getImage());		// creating new alien horde with alien gif file
	   
	    
	    gameThread = new Thread(this);													// create and
	    gameThread.start();																// start thread
	    
	}
	
	// paint function that paints bigger image into the panel
	
	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);																	// calling draw method
		g.drawImage(image,0,0,this);
	}
	
	// draw method that varies depending on game state
	
	public void draw(Graphics g) {
		
		g.drawImage(backgroundImage, 0, 0, null);														// always drawing the background
		
		if (!gameStart) {																				// if game started
			
			g.setColor(Color.white);
			g.setFont(new Font("Consolas", Font.PLAIN, 20));
			g.drawString("Press 's' to start", (PANEL_WIDTH/2)-110, (PANEL_HEIGHT/2)+50);				// draw "press s message"
			
			Graphics2D g2D = (Graphics2D)g;
			
			g2D.drawImage(title , (PANEL_WIDTH/2)-210, (PANEL_HEIGHT/2)-180, null);						// draw space invaders title
			
		}else if (gameOver){																			// if the game finished
				
			Graphics2D g2D = (Graphics2D)g;
			
			g2D.drawImage(gameover , (PANEL_WIDTH/2)-210, (PANEL_HEIGHT/2)-180, null);
			
			g.setColor(Color.white);
			g.setFont(new Font("Consolas", Font.PLAIN, 20));
			g.drawString("Final score: ", (PANEL_WIDTH/2)-110, (PANEL_HEIGHT/2)+50);					// drawing "Final score:" message
			
			g.drawString(String.valueOf(score.getScore()), (PANEL_WIDTH/2)+40, (PANEL_HEIGHT/2)+50);	// drawing the score
					
		}else {																							// if game is running
			
			// calling draw methods for each object
			
			score.draw(g);
			player.draw(g);
			lasergun.draw(g);
			alienhorde.draw(g);
			bomblauncher.draw(g);
			lives.draw(g);
		}
		
	}
		
	public void move(){
		
		// calling move methods for every object that requires moving
		
		lasergun.move();
		alienhorde.move(bomblauncher);
		bomblauncher.move();
		
	}
	
	public void checkCollision() {
		
		// checking if both player and aliens have collided
		
		alienhorde.checkCollision(lasergun, score);
		player.checkCollision(alienhorde, bomblauncher, this, lives);
	}
	
	// run method that handles 60 frames per second
	
	public void run() {
		
		// setting up thread
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;				
		
		// thread loop
		
		while(true) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			// if condition met for every frame
			
			if (delta >= 1) {
				
				if(!gameStart) {												// if game didn't start, just repaint
					
				}else if (gameOver){											// if game is over, just repaint

				}else {
					checkCollision();											// if game is running check collision
					move();														// move objects
					if(alienhorde.getAlive() == 0 || lives.getLives() == 0) {	// check if there are no more aliens and if lives is equal to 0
						gameOver = true;
					}

				}
				
				repaint();														// repaint inherited method
				delta--;														// decrease delta
			}
		}
	}

	//Key Listener methods
	
	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		
		player.keyPressed(e);													// call key pressed method from player
		
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {								// if released space, shoot
			
			lasergun.addLaser(new Laser(player.x+15, player.y-5, 5, 3, 5));		// add laser to linked list
		}
		
		if (e.getKeyCode() == KeyEvent.VK_S) {
			
			gameStart = true;													// if pressed s, start the game
		}
	}
	
	// getters and setters
	
	public int getPanelWidth() {
		return PANEL_WIDTH;
	}
	
	public int getPanelHeight() {
		return PANEL_HEIGHT;
	}
	
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

}

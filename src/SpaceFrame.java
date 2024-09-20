import javax.swing.JFrame;
import java.awt.*;

public class SpaceFrame extends JFrame{
	
	private static final int FRAME_WIDTH = 600;			// frame
	private static final int FRAME_HEIGHT = 700;		// dimensions
	
	SpacePanel panel;
	
	// constructor
	
	public SpaceFrame() {
		
		panel = new SpacePanel();
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);				//setting the frame to the constant values declared as properties
		setTitle("Space Invaders");						// setting a title to the frame
		setLocationRelativeTo(null);					//setting frame location to the middle of the screen
		setLayout(null);
		add(panel);										// adding a panel
		setVisible(true);								// making the frame visible
		setResizable(false);							// disabling the frame to be resizable
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	
	}
		
}
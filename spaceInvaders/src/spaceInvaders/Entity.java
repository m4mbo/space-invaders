	package spaceInvaders;
	
	// entity super class, every object that has a speed, x and y coordinated will extend this class
	
	public class Entity{
				
		// x and y coordinates of the entity
		
		public int x;
		public int y;
		
		public int speed;							// speed for the entity: how many pixels will it move per iteration
		
		// default constructor
		
		public Entity() {
			x = 0;
			y = 0;
			speed = 0;								
		}
		
		// parameter constructor
		
		public Entity(int x, int y, int speed) {
			
			this.x = x;
			this.y = y;
			this.speed = speed;
			
		}
	}

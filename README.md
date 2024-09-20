# Space Invaders: Java
This is my attempt on a space invaders game using Java GUI, specifically the swing package. 

## Approach
Every game entity was treated as a different object (player, alien, laser, bomb, etc.). The concepts of inheritance was pretty useful for this matter, as these all inherit the properties of what was defined as an "Entity" class, which contained a 2D position and a speed value (How many pixels will each object move per iteration). This can be seen in the UML class diagram provided in the png file.

A frame creates the window for the game, and a separate panel handles everything else related to graphics. You could think of this panel as a canvas, where everything is drawn. The runnable interface is also implemented to create a thread that theoretically updates the display 60 times per second (60fps).

ADTs such as linked lists where implemented to hold multiple objects of the same type, this was particularlly useful to create multiple lasers and bombs at the same time.

The KeyListener interfance approach was chosen to receive user input, the game is played with the arrow and space keys.

![ppy](res/sample.gif)

## Build and Run

``` 
./run.sh
```
## Credits

* [m4mbo](https://github.com/m4mbo) - Code and pixel art.

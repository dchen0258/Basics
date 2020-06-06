import acm.graphics.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import acm.program.*;

/*
 * This program is designed to display a layer of bricks in a pyramid format.
 * It starts in the center and each layer centers within the next layer.
 * It should work for any brick width, height or bricks in base.
 * My program also adds color to the pyramid bricks, which can be changed when clicked.
 */
public class PyramidTURTLES extends GraphicsProgram {

	private static final int TURTLES_IN_BASE = 14;

	public void run() {

		// Made a variable height, middle which is used in to define the starting brick.
		// since the brick is from top needs to add the brick height after.
		// the middle is the width/2
		// the starting brick is the middle plus half the widths of the brick

		GTurtle Turtle = new GTurtle(0,0);
		double height = getHeight() - Turtle.getHeight();
		double middle = getWidth()/ 2;
		double startingX = (middle - (TURTLES_IN_BASE * (double) (Turtle.getWidth() / 2)));

		// for loop used; one for the no. of layers, one for bricks in layers.
		// the second loop decreases by one each layer.
		for (int i = 0; i < TURTLES_IN_BASE; i++) {

			for (int j = 0; j <TURTLES_IN_BASE - i; j++) {

				Turtle.setLocation(startingX + (j * Turtle.getWidth()), height);
				
				add(Turtle);
				// The bricks not displayed all at once
				pause(7);

			}
			// The height decreases by the brick height each layer
			// The bricks must move over by half a brick length each layer
			height -= Turtle.getHeight();
			startingX += Turtle.getWidth()/ 2;
			
		}

	}

	private void addTurtle(double d, double height) {
		// TODO Auto-generated method stub
		
	}
}
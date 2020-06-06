
/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

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
public class Pyramid extends GraphicsProgram {

	private static final int BRICK_WIDTH = 30;
	private static final int BRICK_HEIGHT = 12;
	private static final int BRICKS_IN_BASE = 14;

	public void run() {

		// Click To change color of brick
		addMouseListeners();

		// Made a variable height, middle which is used in to define the starting brick.
		// since the brick is from top needs to add the brick height after.
		// the middle is the width/2
		// the starting brick is the middle plus half the widths of the brick

		double height = getHeight() - BRICK_HEIGHT;
		double middle = getWidth() / 2;
		double width = (middle - (BRICKS_IN_BASE * (double) (BRICK_WIDTH / 2)));

		// for loop used; one for the no. of layers, one for bricks in layers.
		// the second loop decreases by one each layer.
		//adds turtle
		GTurtle turt= new GTurtle();
		
		for (int i = 0; i < BRICKS_IN_BASE; i++) {

			for (int j = 0; j < BRICKS_IN_BASE - i; j++) {
				//removes turtle, makes sure there is actually a turtle there
				if(j!=0) {
					remove(turt);
				}
				G3DRect Brick = new G3DRect(width + (j * BRICK_WIDTH), height, BRICK_WIDTH, BRICK_HEIGHT);
				// places turtle where brick is 
				turt = new GTurtle(width + (j * BRICK_WIDTH), height);
				
				

				// Changes the color for each multiple of brick per layer
				if (j % 7 == 0) {
					Brick.setFillColor(Color.RED);
				} else if (j % 7 == 1) {
					Brick.setFillColor(Color.ORANGE);
				} else if (j % 7 == 2) {
					Brick.setFillColor(Color.YELLOW);
				} else if (j % 7 == 3) {
					Brick.setFillColor(Color.GREEN);
				} else if (j % 7 == 4) {
					Brick.setFillColor(Color.BLUE);
				} else if (j % 7 == 5) {
					Brick.setFillColor(Color.PINK);
				} else if (j % 7 == 6) {
					Brick.setFillColor(Color.WHITE);
				}

				Brick.setFilled(true);
				
				add(Brick);
				add(turt);
				
				// The bricks not displayed all at once
				pause(60);

			}
			// there is an OBOB at the very end where a turtle is left over
			remove(turt);
			
			// The height decreases by the brick height each layer
			// The bricks must move over by half a brick length each layer
			height -= BRICK_HEIGHT;
			width += BRICK_WIDTH / 2;
		}
		//adds turtle at very top
		add(turt);

	}

	/*
	 * when the mouse gets clicked it gets the x and y coordinates of where it clicked and turns it green. 
	 * found in java textbook
	 */
	public void mousePressed(MouseEvent e) {

		double lastX = e.getX();
		double lastY = e.getY();
		GObject gobj = getElementAt(lastX, lastY);
		if (gobj != null) {
			((G3DRect) gobj).setFillColor(Color.GREEN);
			((G3DRect) gobj).setFilled(true);
		}

	}
}
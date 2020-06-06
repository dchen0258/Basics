
/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;

import acm.program.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/* This program is supposed make a target with the outside red, middle white, and inside red.
 * The outside oval is supposed to be one inch, the middle 0.65, and outside 0.3.
 */

public class Target extends GraphicsProgram {

	// made own constants for the widths and heights of ovals so it is easier to
	// change
	private static final double OVAL1WIDTH = 144;
	private static final double OVAL1HEIGHT = 144;

	private static final double OVAL2WIDTH = 93.6;
	private static final double OVAL2HEIGHT = 93.6;

	private static final double OVAL3WIDTH = 43.2;
	private static final double OVAL3HEIGHT = 43.2;

	// added mouse listener so that the target changes color if you press it
	public void run() {
		addMouseListeners();
		firstOval();
		secondOval();
		thirdOval();
		turtle();

	}
	
	/*
	 * first oval's location must be centered but must take into account that it is
	 * taken from the top left so I just subtracted the circle's height and width to
	 * get centered and then set the color did similar things with other ovals
	 */

	public void firstOval() {
		GOval oval = new GOval(0, 0, OVAL1WIDTH, OVAL1HEIGHT);
		oval.setLocation(getWidth() / 2 - oval.getWidth() / 2, getHeight() / 2 - oval.getHeight() / 2);
		oval.setFillColor(Color.RED);
		oval.setFilled(true);
		add(oval);

	}

	public void secondOval() {
		GOval oval2 = new GOval(0, 0, OVAL2WIDTH, OVAL2HEIGHT);
		oval2.setLocation(getWidth() / 2 - oval2.getWidth() / 2, getHeight() / 2 - oval2.getHeight() / 2);
		oval2.setFillColor(Color.WHITE);
		oval2.setFilled(true);
		add(oval2);
	}

	public void thirdOval() {

		GOval oval3 = new GOval(0, 0, OVAL3WIDTH, OVAL3HEIGHT);
		oval3.setLocation(getWidth() / 2 - oval3.getWidth() / 2, getHeight() / 2 - oval3.getHeight() / 2);
		oval3.setFillColor(Color.RED);
		oval3.setFilled(true);
		add(oval3);
	}
	
	// added turtle for fun but it has its own dimensions

	public void turtle() {
		GTurtle Turtle = new GTurtle(0, 0);
		Turtle.setLocation(getWidth() / 2 - Turtle.getWidth() / 2, getHeight() / 2 - Turtle.getHeight() / 2);
		add(Turtle);
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

			((GOval) gobj).setFillColor(Color.GREEN);
			((GOval) gobj).setFilled(true);
		}

	}
}

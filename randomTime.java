import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.*;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/*
 *  This program is designed to display a random time on a clock.
 */

public class randomTime extends GraphicsProgram {

	// integers, methods, and doubles that are used in multiple methods

	private static final int CLOCK_WIDTH = 450;
	private static final int CLOCK_HEIGHT = 450;

	private RandomGenerator rgen = new RandomGenerator();

	// x + y coordinates of hour and minute hand end points

	double hourX;
	double hourY;

	double minuteX;
	double minuteY;

	int middlex;
	int middley;

	public void run() {
		middlex = getWidth() / 2;
		middley = getHeight() / 2;
		int x = 0;

		// randomizes the angle of the hour and minute hand
		double minutes = rgen.nextDouble(0, 60);
		double hours = rgen.nextDouble(0, 12);

		Clock();
		randomizeTime(minutes, hours);
		drawTicks();
		displayTime();

	}

	public void Clock() {
		addMouseListeners();

		// create yellow clock with four times
		GOval Clock = new GOval(CLOCK_WIDTH, CLOCK_HEIGHT);
		double clockX = middlex - Clock.getWidth() / 2;
		double clockY = middley - Clock.getHeight() / 2;
		Clock.setLocation(clockX, clockY);
		Clock.setFillColor(Color.YELLOW);
		Clock.setFilled(true);
		add(Clock);
		
		GLabel time =new GLabel("12");
		add(time, getWidth()/2-8, getHeight()/2 - 170);
		GLabel time2 =new GLabel("3");
		add( time2, getWidth()/2 + 170, getHeight()/2 +10);
		GLabel time3 =new GLabel("6");
		add( time3, getWidth()/2 -5, getHeight()/2 + 170);
		GLabel time4 =new GLabel("9");
		add( time4, getWidth()/2-170, getHeight()/2 +10);
	}

	public void mousePressed(MouseEvent e) {
		// turns green if pressed
		double lastX = e.getX();
		double lastY = e.getY();
		GObject gobj = getElementAt(lastX, lastY);
		if (gobj != null) {

			((GOval) gobj).setFillColor(Color.GREEN);
			((GOval) gobj).setFilled(true);
		}
	}

	public void drawTicks() {

		// draws ticks for each minute

		for (int degree = 0; degree < 360; degree += 6) {

			int tickSize = 200;

			if (degree % 30 == 0) {

				tickSize = 180;

			}
			GLine ticks = new GLine(middlex + tickSize * Math.cos(degree * Math.PI / 180),
					middley + tickSize * Math.sin(degree * Math.PI / 180),
					middlex + 225 * Math.cos(degree * Math.PI / 180), middley + 225 * Math.sin(degree * Math.PI / 180));

			add(ticks);
		}

	}

	public void randomizeTime(double minutes, double hours) {
		// Takes length of the line to be used in parametric equations

		double radiusHour = CLOCK_WIDTH / 4;
		double radiusMinute = CLOCK_WIDTH / 2.5;

		// parametric equations to determine the x+ y coordinates
		// of the end points minute and hour hands from random angle
		hours = hours*30 +minutes/2;
		hourX = radiusHour * Math.cos(hours  * Math.PI / 180);
		hourY = radiusHour * Math.sin(hours * Math.PI / 180);

		minuteX = radiusMinute * Math.cos(minutes * Math.PI / 180);
		minuteY = radiusMinute * Math.sin(minutes * Math.PI / 180);
	}

	public void displayTime() {

		// Uses all coordinates previously calculated
		// to display time randomly

		double hourHandEndX = hourX + getWidth() / 2;
		double hourHandEndY = hourY + getHeight() / 2;

		double minuteHandEndX = minuteX + getWidth() / 2;
		double minuteHandEndY = minuteY + getHeight() / 2;

		GLine hourHand = new GLine(middlex, middley, hourHandEndX, hourHandEndY);
		GLine minuteHand = new GLine(middlex, middley, minuteHandEndX, minuteHandEndY);

		add(hourHand);
		add(minuteHand);
	}

}

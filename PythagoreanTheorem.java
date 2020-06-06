
/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	/*
	 * The program is supposed to take numbers and do the pythagorean theorem with
	 * them. The numbers can be any integers. I simply did a squared and b squared
	 * instead of doing it in the math.sqrt function for readibility.
	 */
	public void run() {
		println("Enter values to compute the Pythagorean theorem");
		// These are the two integers
		int a = readInt("a:");
		int b = readInt("b:");

		// These are the two integers squared
		int asquared = a * a;
		int bsquared = b * b;

		// Finding area created by integers
		int area = (a * b) / 2;

		// Finding square root and displaying it
		double c = Math.sqrt(asquared + bsquared);
		println("c:" + c);
		println("the area of the triangle is: " + area);
	}
}

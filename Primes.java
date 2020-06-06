
import acm.program.*;

/*
 * This program is designed to print the first' 'n' prime numbers.
 * N is taken from a number that the user enters
 */

public class Primes extends ConsoleProgram {
	public void run() {

		// prompts user for a number, sets values for integers

		int n = readInt("n: ");
		int x = 1;
		int primeCounter = 0;

		calculatePrimes(n, x, primeCounter);
	}

	public void calculatePrimes(int n, int x, int primeCounter) {

		// tests if x is a prime number or not,
		// while the no. of primes is less than n

		for (x = 1; primeCounter < n; x++) {
			if (isPrime(x)) {
				primeCounter++;
				println(x);
			}
		}
	}

	public boolean isPrime(int x) {

		// Calculates if x is a prime by the number of factors it has
		// Runs through every number from 1 to i to see if it factors
		// It is a prime if it has 2 factors

		int factors = 0;
		for (int i = 1; i <= x; i++) {
			if (x % i == 0) {
				factors++;
			}
		}
		if (factors == 2) {
			return (true);
		} else {
			return (false);
		}
	}
}

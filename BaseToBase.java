/* 
 * Paul Leelaviwatana
 * u5715404
 * Exercise 5.3 - TernaryToDecimal
 * v1.2 - Converts any base to decimal
 * Problem: Not counting last digit
 */

import java.util.Scanner;

public class BaseToBase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int base = 2;
		
		// fail-safe
		while (base < 2 || base > 10) {
			System.out.print("Enter base (between 2 and 10) to convert to decimal: ");
			base = sc.nextInt();
		}
		
		System.out.print("Number of base " + base + " to convert to decimal: ");
		int iBaseNumber = sc.nextInt();
		
		if (base == 10) {
			System.out.println("Noob, obviously it's " + iBaseNumber + ".");
			System.exit(0);
		}
		
		String baseNumberS = Integer.toString(iBaseNumber);
		int length = baseNumberS.length();
		
		int[] unitValue = new int[length];
		int[] value = new int[length];
		int[] baseNumber = new int[length];
		
		baseNumber[0] = iBaseNumber;
		int totalValue = 0;
		
		for (int i = 0, p = length-1; p != 0; i++, p--) {
			
			unitValue[i] = baseNumber[i] / (int)Math.pow(10, p);
			baseNumber[i+1] = baseNumber[i] % (int)Math.pow(10, p);
			
			value[i] = unitValue[i] * (int)Math.pow(base, p);
			totalValue += value[i];
			length--;
		}
		
		System.out.println("Base " + base + " of " + baseNumberS + " = " + totalValue);
		sc.close();
	}

}

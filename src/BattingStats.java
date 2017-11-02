import java.util.Arrays;
import java.util.Scanner;

/*
 * 
 * @author Siddique Khatri  on 10/31/2017
 *	Batting Statistics Program
 */

public class BattingStats {

	public static void main(String[] args) {
		
		double batAverage = 0.0;
		String choice = "y";
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Batting Average Calculator!");
		System.out.println("");
		while (choice.equalsIgnoreCase("Y")) {
			System.out.println("Enter number of times at bat:");
			int atBats = scan.nextInt();
			scan.nextLine(); // garbage line to clear scanner
			//array to hold atBats data
			int[] arr1 = new int[atBats];
		
			//calling batting average method
			batAverage = battingAvg(scan, arr1, batAverage);
		
			double slug = batAverage / atBats; //total bases earned/total atBats
			System.out.printf("\nSlugging percentage: %,.3f", slug); //printf method to print to 3 decimal places
			System.out.println("");		
			scan.nextLine(); //clear the scanner
			System.out.println("Another batter? (Y/N)");
			choice = scan.nextLine();
		}
		scan.nextLine();
		System.out.println("Goodbye!");
		scan.close(); 
		}
		
	
	public static double battingAvg(Scanner input, int[] arr1, double sum) {
		double atBats = 0.0;
		//iterates through the second array to hold number of bases
		System.out.println("0=out, 1=single, 2= double, 3=triple, 4=home-run");
		for(int i = 0; i < arr1.length; i++) { 
				System.out.println("Result for at bat (0-4):  "+ i + " ");
				if(!input.hasNextInt()) {
					System.out.println("Error! Please enter number between 0 and 4!");
					input.next(); //clears the scanner of invalid value
				}
				int bases = input.nextInt();
				if(bases < 0 || bases > 4) { //input validation for number of bases entered
					System.out.println("Error! Please enter number between 0 and 4!");
					input.next();
				} else if(bases >= 0 || bases <= 4) { //only adds to array if # bases are between 1 & 4
					arr1[i] = bases; 
					sum += arr1[i];
				} if (bases > 0 ) {
					atBats++; //keeps track of atBats; 
				}
		}
		double battingAverage = atBats/arr1.length; 
		System.out.printf("Batting average:  %,.3f", battingAverage); //printf method to print to 3 decimal places
		return sum;
		
	}

	}


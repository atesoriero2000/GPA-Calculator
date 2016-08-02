import java.util.Scanner;

public class Main {

	static Scanner input = new Scanner(System.in);

	
	
	static double[] unweightedGP = new double[] { 4.33, 4.00, 3.67, 3.33, 3.00,
			2.67, 2.33, 2.00, 1.67, 1.33, 1.00, .67, 0 };

	static double[] weightedGP = new double[] { 5.41, 5.00, 4.59, 4.16, 3.75,
			3.34, 2.91, 2.50, 2.09, 1.66, 1.25, .84, 0 };

	
	public static void main(String[] args) {

		int numCredits = 0;
		double GPxCreditsSum = 0;
		double GPSum = 0;
		int numClasses;

		System.out.print("Number of Classes: ");
		while (input.hasNextInt() == false){}
		numClasses = input.nextInt();

		
		
		for (int currentClass = 0; currentClass < numClasses; currentClass++) {

			double percent=0;
			int credits = 0;
			boolean weighted;
			double gp = 0;
			int arrayPlace = 0;

			
			System.out.print("\nClass " + (currentClass + 1) + " Grade: ");
			while (input.hasNextDouble() == false) {}
			percent = input.nextDouble();
			percent = Math.round(percent);

			
			System.out.print("Class " + (currentClass + 1) + " Credits: ");
			while (input.hasNextInt() == false) {}
			credits = input.nextInt();
			numCredits += credits;

			
			System.out.print("Class " + (currentClass + 1) + " Weighted?: ");
			while (input.hasNextBoolean() == false) {}
			weighted = input.nextBoolean();

			
			
			if (percent >= 97) {
				arrayPlace=0;

			} else if (percent <= 96 && percent >= 93) {
				arrayPlace=1;

			} else if (percent <= 92 && percent >= 90) {
				arrayPlace=2;

			} else if (percent <= 89 && percent >= 87) {
				arrayPlace=3;

			} else if (percent <= 86 && percent >= 83) {
				arrayPlace=4;

			} else if (percent <= 82 && percent >= 80) {
				arrayPlace=5;

			} else if (percent <= 79 && percent >= 77) {
				arrayPlace=6;

			} else if (percent <= 76 && percent >= 73) {
				arrayPlace=7;

			} else if (percent <= 72 && percent >= 70) {
				arrayPlace=8;

			} else if (percent <= 69 && percent >= 67) {
				arrayPlace=9;

			} else if (percent <= 66 && percent >= 63) {
				arrayPlace=10;

			} else if (percent <= 62 && percent >= 60) {
				arrayPlace=11;
				
			} else if (percent <= 59) {
				arrayPlace=12;
			}
			
			
			
			if(weighted){
				gp = weightedGP[arrayPlace];
				
			}else{
				gp = unweightedGP[arrayPlace];
				
			}
				GPSum+=gp;
				
				GPxCreditsSum += gp * credits;

		}
		
		System.out.println("\nWeighted GPA: " + GPxCreditsSum/numCredits);
		System.out.println("Unweighted GPA: " + GPSum/numClasses);
 
	}

}
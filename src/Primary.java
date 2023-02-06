//CSC 1061 1N1, Graham "Boomer" Myers

import java.util.*;
import java.io.*;

public class Primary {
	private static String fileName;
	private static double[] scoreArray = new double[20];
	private static String line;
	
	public Primary() {

	}

	public static void main(String[] args) {
		
		//Create a linked list where the Grade objects will be added as elements.
		LinkedList<Grade> gradeList = new LinkedList<Grade>();
		
		/*
		 * Create a new instance of the calculations class I made to manage the mean, standard
		 * deviation, and grade letter calculations and logic.
		 */
		Calculations calc = new Calculations();
		
		//Open the scanner to take input from the user
		Scanner userInput = new Scanner(System.in);
		
		//Prompt the user for the name of the file they want to open
		System.out.print("Enter the filename: ");
		
		//Allow the user to enter the file name of the file they want to open
		fileName = userInput.nextLine();
		
		/* Open the file stream to read in the file using the input from the user to 
		 * open that file. Then cast each new line to a Double format and add it
		 * to the scoreArray which will be used to calculate the mean, standard deviation,
		 * and curved letter grade.
		 */
		try (BufferedReader buffer = new BufferedReader(new FileReader(fileName))){
			int j = 0;
			while ((line = buffer.readLine()) != null) {
					scoreArray[j] = Double.parseDouble(line);
					j++;
			}
			
			//Use the Calculations class to find the mean.
			calc.setMean(scoreArray);
			
			//Use the Calculations class to find the standard deviation.
			calc.setStandardDeviation(scoreArray);
			
			/*
			 * Take each double in the array scoreArray and the calculations of the mean
			 * and standard deviation made earlier to create a new instance of the "Grade"
			 * class and add that class as an element in the Linked List. With the calculations
			 * of the mean, standard deviation, and the individual score the new instance of 
			 * the Grade can calculate the letter grade automatically.
			 */
			for (int i = 0; i < scoreArray.length; i++) {
				Grade tempgrade = new Grade();
				tempgrade.setLetterGrade(scoreArray[i], calc.getMean(), calc.getStandardDeviation());
				tempgrade.setScore(scoreArray[i]);
				gradeList.add(tempgrade);
			}
			
			//Print out the number of elements in the Linked List 
			System.out.println("Number of grades: " + gradeList.size());
			
			//Print out the mean the Calculations class made
			System.out.println("Mean: " + calc.getMean());
			
			/*
			 * Make a new string to print out the standard deviation. In this case the printf
			 * method is used so that the standard deviation can be printed to 4 decimal places
			 * as is shown in the "Sample Run" example.
			 */
			String str = String.format("Standard Deviation: %.4f", calc.getStandardDeviation());
			System.out.println(str);
			
			//Print out the headers of the columns for the grades.
			System.out.printf("%9s%7s\n", "Score", "Grade");
			
			//Loop to iterate through the grades and print them in the specified format
			for (int i = 0; i < gradeList.size(); i++) {
				System.out.printf("%2s%7.2f%3s\n", i + 1, gradeList.get(i).getScore(), gradeList.get(i).getLetterGrade());
			}
			
		/*
		 * This catch statement is connected to the try statement which attempts to open 
		 * the file buffer and read the contents.
		 */
		}catch (IOException e) {
			System.out.println(e);
		}
		//Close the file reader.
		userInput.close();

	}
}

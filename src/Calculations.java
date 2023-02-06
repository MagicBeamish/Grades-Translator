
public class Calculations {
	private double mean;
	private double standardDeviation;
	private String letterGrade; /*
								 *Eclipse says letterGrade is not used in the class, but that is false.
								 *If this is deleted the class breaks.
								 */
	// Empty Calculations constructor
	public Calculations() {

	}

	// Formatted Calculations constructor
	public Calculations(double mean, double standardDeviation) {
		this.mean = mean;
		this.standardDeviation = standardDeviation;
	}

	/*
	 * Find the mean of the class by adding all the scores together and then
	 * dividing by the number of scores.
	 * 
	 * Mean (m)=(x_1+ x_2+x_3+⋯+x_n)/n
	 */
	public void setMean(double[] arr) {
		double divisor = arr.length;
		double dividend = 0;

		try {
			for (int i = 0; i < arr.length; i++) {
				dividend += arr[i];
			}
			this.mean = dividend / divisor;
			
		/*
		 * This catch is placed to catch the Divide by Zero error if the length of the array is 0.
		 */
		} catch (ArithmeticException e) {
			System.out.println("Cannot divide by zero");
			System.out.println(e);
		}
	}
	
	//Getter method for mean
	public double getMean() {
		return mean;
	}

	/*
	 * Find the standard deviation by using the standard deviation formula.
	 * 
	 * Standard Deviation (sd)=√(((x_1-m)^2+(x_2-m)^2+(x_3-m)^2+⋯+(x_n-m)^2)/(n-1))
	 */
	public void setStandardDeviation(double[] arr) {
		double dividend = 0;
		double divisor = arr.length - 1;

		try {
			for (int i = 0; i < arr.length; i++) {
				dividend += (arr[i] - mean) * (arr[i] - mean);
			}
			standardDeviation = Math.sqrt(dividend / divisor);
		//Catch exception for if there is a Divide by Zero error
		} catch (ArithmeticException e) {
			System.out.println("Cannot divide by zero");
			System.out.println(e);
		}
	}
	
	//Getter method for standard deviation
	public double getStandardDeviation() {
		return standardDeviation;
	}

}

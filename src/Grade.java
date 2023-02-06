public class Grade implements Comparable<Grade>{
	private String letterGrade;
	private Double score;
	
	//Empty constructor
	public Grade() {
		
	}
	
	/*
	 * Constructor with score and letter crade which can be entered manually
	 * instead of having the letter grade be calculated automatically.
	 */
	public Grade(double score, String letterGrade) { 
		this.letterGrade = letterGrade; 
		this.score = score; 
	}
	
	//Setter method for score
	public void setScore(double score) {
		this.score = score;
	}
	
	//Getter method for score
	public double getScore() {
		return score;
	}
	
	/*
	 * Setter method for the curved letter grade. This method sets the curved grade automatically
	 * and will return an "Invalid" string in case the input score is somehow formatted wrong.
	 */
	public void setLetterGrade(double score, double mean, double standardDeviation) {
		
		if ( score >= (mean + 1.5 * standardDeviation)) {
			letterGrade = "A";
		}else if (score >= (mean + 0.5 * standardDeviation) && score < (mean + 1.5 * standardDeviation)){
			letterGrade = "B";
		}else if (score >= (mean - 0.5 * standardDeviation) && score < (mean + 0.5 * standardDeviation)) {
			letterGrade = "C";
		}else if ((int) score >= (mean - 1.5 * standardDeviation) && score < (mean - 0.5 * standardDeviation)) {
			letterGrade = "D";
		}else if (score < (mean - 1.5 * standardDeviation)) {
			letterGrade = "F";
		}else {
			letterGrade = "Invalid";
		}
	}
	
	//Letter grade getter method
	public String getLetterGrade() {
		return letterGrade;
	}
	
	//Grade to string method which was not used in this project except for testing
	public String toString() {
		return new String(this.letterGrade + ":" + this.score);
	}
	
	//A comparator method which I thought I would need to use at one point in the project and did not.
	@Override
	public int compareTo(Grade g2) {
		if (this.score < g2.score) {
			return -1;
		}else if (this.score > g2.score) {
			return 1;
		}else {
			return 0;
		}
	}

}

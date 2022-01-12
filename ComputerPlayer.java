/* Mansi Patel
 * CS 2336.002
 * Ultimate TTT Game Course Project
 * 11/24/21
 */

/* The ComputerPlayer class is a subclass of the APlayer class
 * in which board numbers and row and column values are all 
 * generated randomly by the computer. The ComputerPlayer class 
 * has an inheritance relationship with the APlayer class. 
 */

public class ComputerPlayer extends APlayer {

	// Create two data fields of type String to hold the player's name
	// and mark. 
	private String name;
	private String mark;
	
	// The custom constructor of the ComputerPlayer class calls
	// its super constructor (APlayer) to set the name and 
	// mark of its objects. The method takes in two String type
	// input parameters. 
	public ComputerPlayer(String name, String mark) {
		super(name, mark);
	}
	
	// The randomNumber method generates a random number
	// in a given range and returns the chosen number. The 
	// method takes in an integer as an input parameter and 
	// it is expected to return an int. 
	private int randomNumber(int range) {
		// Generate a random number of double type 
		// between 0 and range but not including the range value.
		// Cast the random value as an integer.
		return (int) (Math.random()*range);
	}
	
	
	// Override selectRowValue and selectColValue
	// methods from superclass APlayer.
	@Override
	// The selectRowValue method selects a randomly generated row value 
	// using the range given from input. The method
	// takes in two integer input parameters, and it is
	// expected to return an integer.
	public int selectRowValue(int range, int board_number) {
		return randomNumber(range);
	}
	
	@Override
	// The selectColValue method selects a randomly generated column 
	// value using the range given from input. The method
	// takes in two integer input parameters, and it is
	// expected to return an integer.
	public int selectColValue(int range, int board_number) {
		return randomNumber(range);
	}
	
	@Override
	// The selectBoardNumber method selects a randomly generated board 
	// number using the range given from input. The method
	// takes in one integer input parameter, and it is
	// expected to return an integer.
	public int selectBoardNumber(int range) {
		return randomNumber(range);
	}
}

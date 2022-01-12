/* Mansi Patel
 * CS 2336.002
 * Ultimate TTT Game Course Project
 * 11/24/21
 */

/* The APlayer class has methods to create and utilize a player object
 * for the tic-tac-toe game. The APlayer class is the parent of two subclasses:
 * HumanPlayer and ComputerPlayer. The subclasses work similarly, so the APlayer
 * class holds common methods between the two classes. 
*/

public abstract class APlayer {

	// Create two data fields of type String to hold the player's name
	// and mark. 
	private String name;
	private String mark;
	
	// The custom constructor of the APlayer class calls
	// the setName method to set the name of the player and
	// the setMark method to set the mark corresponding with the player
	// (X or O).
	public APlayer(String name, String mark) {
		setName(name);
		setMark(mark);
	}

	// The getName method will return the contents of 
	// the name data field. The method does not take in
	// any input parameters, but it is expected to return
	// a String.
	public String getName() {
		return name;
	}

	// The setName method will set the name data field using
	// its input parameter. The method takes in a String input
	// parameter, but it is not expected to return anything.
	public void setName(String name) {
		this.name = name;
	}

	// The getMark method will return the contents of the 
	// mark data field. The method does not take in any input
	// parameters, but it is expected to return a String.
	public String getMark() {
		return mark;
	}

	// The setMark method will set the mark data field using
	// its input parameter. The method takes in a String input
	// parameter, but it is not expected to return anything.
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	// The following methods have no implementation in the APlayer class as 
	// the subclasses HumanPlayer and ComputerPlayer have different versions of 
	// implementation. Further comments on the methods and their specific implementations 
	// will be found in the HumanPlayer and ComputerPlayer class. 
	public abstract int selectRowValue(int range, int board_number);
	public abstract int selectColValue(int range, int board_number);
	public abstract int selectBoardNumber(int range);
}

/* Mansi Patel
 * CS 2336.002
 * Ultimate TTT Game Course Project
 * 11/24/21
 */

/* The Mark enum holds the X, O, - symbol constants that are used
 * as placeholders for the boxes in the game boards.
*/

enum Mark {
	// Create constants X, O, and DASH to hold
	// the three primary symbols of the game.
	X("X"),
	O("O"),
	DASH("-");
	
	// Create a "mark" data field of type String
	// to hold a respective mark.
	private String mark;
	
	// The Mark custom constructor sets
	// the mark data field using the input parameter.
	// The method takes in a String input parameter. 
	Mark(String mark) {
		this.mark = mark;
	}
	
	// The getMark method returns the contents
	// of the "mark" data field. The method takes in
	// no input parameters, but it is expected to return
	// a String.
	public String getMark() {
		return mark;
	}
}

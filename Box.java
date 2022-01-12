/* Mansi Patel
 * CS 2336.002
 * Ultimate TTT Game Course Project
 * 11/24/21
 */

/* The Box class creates a box in a given position on
 * a board with the appropriate mark. The Box class
 * has a composition relationship with the Board class. 
*/

class Box {
	
	// Create two integer data fields to indicate the
	// position of a box on a board.
	private int row;
	private int col;
	// Create a String constant to act as the initial
	// placeholder for every Box object. 
	private final static String DASH = "-";
	// Create a String data field that is set to the
	// initial place holder. 
	private String placeHolder = Box.DASH;

	// The Box custom constructor sets the row, column
	// and place holder data fields using the input
	// parameters. The method takes in two integer input
	// parameters.
	Box(int row, int col) {
		this.row = row;
		this.col = col;
		// Set the "placeholder" data field to a 
		// dash (to be safe).
		this.placeHolder = "-";
	}
	
	// The getPlaceHolder method returns the
	// contents of the placeholder data field. The
	// method takes in no input parameters and it is
	// expected to return a String.
	String getPlaceHolder() {
		return placeHolder;
	}
	
	// The setPlaceHolder method sets the placeholder
	// data field using the input parameter, if 
	// the Box object initially holds a dash or asterisk indicating
	// it is available. The method takes in a String as an input
	// parameter and it is expected to return a boolean.
	boolean setPlaceHolder(String placeHolder) {
		// Call the isAvailable method to see if the
		// Box object is available (meaning its current placeholder 
		// is either a dash or asterisk).
		if(isAvailable()) {
			// If it is available, overwrite the 
			// placeholder to the input parameter. 
			this.placeHolder = placeHolder;
			// Return true to indicate a new place holder
			// has been set. 
			return true;
		}
		// Otherwise, return false. 
		return false;
	}

	// The isAvailable method checks if a given box holds a dash or asterisk
	// symbol, indicating it is an available box. The method takes
	// in no input parameters, but it is expected to return a boolean.
	 boolean isAvailable() {
		 // If the Box object's placeholder is a dash or asterisk symbol,
		 // that means the box is available and thus, the method can return true. 
		 if (this.getPlaceHolder().equals(Box.DASH) || this.getPlaceHolder().equals("*")) {
			 return true;
		 } else {
			 // Otherwise, return false as it is not available.
			 return false;
		 }
	}
	
	// The print method prints the place holder for a given box.
	// The method takes in no input parameters, and it is not
	// expected to return anything.
	void print() {
		// Print the place holder for a given box.
		System.out.print(placeHolder + " ");
	}
	
}

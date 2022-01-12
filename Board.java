/* Mansi Patel
 * CS 2336.002
 * Ultimate TTT Game Course Project
 * 11/24/21
 */

/* The Board class creates a board of a given size
 * with the appropriate number of boxes (i.e. 3 x 3 board = 9 boxes). 
 * The Board class also places marks in its corresponding boxes, checks if there
 * is a winner of a given board, and retrieves marks in specific positions
 * on the board. The Board class has a composition relationship with the Box class.
*/

public class Board {
	
	// Create a "boxes" object array of type Box
	// to hold each box of a given board. 
	private Box[] boxes;
	// Create integer data fields for the boardRowSize and
	// boardColSize, which will be set in the class constructors.
	private int boardRowSize;
	private int boardColSize;
	// Create a String data field to hold the mark of the
	// winner of a board.
	private String winner;
	// Create a boolean data field to act as a flag if there
	// is a winner present on the board. 
	private	boolean	isWinner;
	
	// Default Constructor of Board class
	// The default constructor calls the custom constructor,
	// passing in a row and column size of 3. 
	Board() {
		this(3, 3);
	}
	
	// The Board custom constructor will call the
	// setSize method to set the size of the board.
	// The constructor also initializes the winner data field
	// to the dash symbol, and sets the isWinner boolean flag to
	// false. The method takes in two integer type input parameters.
	Board(int rowSize, int colSize) {
		this.setSize(rowSize, colSize);
		winner = Mark.DASH.getMark();
		isWinner = false;
	}

	// The setSize method validates the input parameters
	// to see if they are a valid board size. If so, the method
	// calls the initializeBoard method to set all boxes of the board.
	// The setSize method takes in two integer input parameters, and it
	// is not expected to return anything.
	public void setSize(int row, int col) {
		// If the row size and column size is less than 3,
		// report that the minimum board size must be 3x3.
		if(row < 3 || col < 3) {
			System.out.println("Minimum board size is 3x3.");
		} else {
			// If the row size and column size are appropriate values,
			// set the boardColSize and boardRowSize data fields to
			// their respective input parameters.
			this.boardColSize = col;
			this.boardRowSize = row;
			// Call the initializeBoard method to set up the board with its
			// initial marks.
			initializeBoard();
		}
		
	}

	// The initializeBoard method will initialize the "boxes" array data field
	// and initialize all place holders in the "boxes" array to dash marks (by
	// calling the Box constructor). The method takes in no input parameters
	// and it is not expected to return anything.
	private void initializeBoard() {
		// Initialize the "boxes" array data field and set its size
		// to boardColSize * boardRowSize; this will allow us to emulate
		// a 2D array, even though it is a 1D array.  
		boxes = new Box[boardColSize * boardRowSize];
		for(int index = 0; index < boxes.length; index++) {
			// Iterate through the "boxes" array and initialize each individual
			// box object. Set the position of each given box as it would
			// be on a board. i.e. If index = 1, the call looks 
			// like new Box(1/3 = 0, 1%3 = 1). Box 1 will be in 
			// position (0, 1) on a board. 
			Box a_box = new Box(index/boardColSize, index%boardColSize);
			boxes[index] = a_box;
		}
	}

	// The print method prints a given board row 
	// by row, along with its corresponding board. The method
	// does not take in any input parameters, but it is not 
	// expected to return anything.
	public void print() {
		// Iterate through the "boxes" array for a given board.
		for(int index = 0; index < boxes.length; index++) {
			// Once reaching an index divisible by 3 (% 3 == 0),
			// print a new line to create a new row.
			if (index != 0 && index%boardColSize == 0) {
				System.out.println();
			}
			// Call the print method of the Box class to print
			// the corresponding box at index. 
			boxes[index].print();
		}
	}

	// The makeMove method places a mark at a given row and column
	// within a board, if the spot is available. The method takes in
	// a String and two integer parameters. The method returns an integer.
	 public int makeMove(String mark, int row, int col) {
		 // Call the setPlaceHolder method for a given box and pass in the
		 // mark from input. The if statement is true if the spot is
		 // available and the mark was made. 
		if(this.boxes[row * this.boardRowSize + col].setPlaceHolder(mark)) {;
			// The formula (row * boardColSize) + col calculates the box number in a given
			// board that the player made a move on. This will be used to dictate the
			// the next player's move. 
			// i.e. row = 1, col = 1: (1 * 3) + 1 = Box #4
			// If this location is available, make the mark
			// by placing X or O in the box and return the box number. 
			return (row * boardColSize) + col;
		} else {
			// If the spot is not available, report that it is not available and return -1. 
			System.out.println("Position at row " + row + " and column " + col + " is taken.");
			return -1;
		}
	}
	
	// The isFull method checks if all boxes in a given board are
	// full. The method takes in no input parameters, but it is expected
	// to return a boolean value.
	public boolean isFull() {
		// Iterate through each box in "boxes" array and
		// check each mark.
		for(Box a_box : boxes) {
			// If a given box is available (a dash symbol is 
			// present in the spot), return false. 
			if(a_box.isAvailable()) {
				return false;
			}
		}
		// Otherwise, return true.
		return true;
	}
	
	// The isWinner method checks if there is a winner in a certain
	// direction on a board. The method takes in no input parameters
	// but it is expected to return a boolean.
	public boolean isWinner() {
		// Check each row, column, and right-left diagonal, and left-right diagonal for 3 consecutive marks. 
		if (this.checkRow() || this.checkColumn() || this.checkDiagRL() || this.checkDiagLR()) {
			// Set the isWinner flag to true, and return true.
			isWinner = true;
			return true;
		}
		// Return false. 
		return false;
	}
	
	// The replaceWithAsterisks method replaces empty spots in
	// a board with a winner with asterisks to indicate they are 
	// available. The method takes in no input parameters, but it 
	// is not expected to return anything. 
	public void replaceWithAsterisks() {
		// Iterate through each box in the "boxes" array. 
		for(int index = 0; index < boxes.length; index++) {
			// If the place holder of a box equals a dash, 
			// set the place holder to an asterisk. 
			if(boxes[index].getPlaceHolder().equals("-")) {
				boxes[index].setPlaceHolder("*");
			}
		}
	}
	
	// The checkDiagLR method checks for three consecutive marks
	// in the left-to-right diagonal direction. The method takes
	// in no input parameters, but it is expected to return a boolean
	// value. 
	private boolean checkDiagLR() {
		// Create two counter variables for X and O marks respectively.
		int countXMarks = 0;
		int countOMarks = 0;
		// Go through each index in diagonal left-right direction and
		// count the number of X and O marks. 
		for(int row = 0, col = 0; row < boardRowSize && col < boardColSize; row++, col++) {
			// If the mark at the given position equals X, increment the X mark counter.
			if(this.getMark(row, col).equals("X")) {
					countXMarks++;
			// Otherwise if the mark at the given position equals X, increment the O mark counter.
			} else if (this.getMark(row, col).equals("O")) {
					countOMarks++;
			}
		}
		// If the number of countXMarks is 3 and the winner data field 
		// does not have a mark other than the dash (meaning O has not won on this board already),
		// set the winner to X and return true.
		if (countXMarks == 3 && !winner.equals("O")) {
			setWinner("X");
			return true;
		// If the number of countOMarks is 3 and the winner data field does not
		// have a mark other than a dash (meaning X has not won on this board already),
		// set the winner to O and return true.
		} else if (countOMarks == 3 && !winner.equals("X")) {
			setWinner("O");
			return true;
		}
		// Otherwise, return false as no winner has been found yet.
		return false;
	}
	
	// The checkDiagRL method checks for three consecutive marks
	// in the right-to-left diagonal direction. The method takes
	// in no input parameters, but it is expected to return a boolean
	// value. 
	private boolean checkDiagRL() {
		// Create two counter variables for X and O marks respectively.
		int countXMarks = 0;
		int countOMarks = 0;
		// Go through each element in diagonal right-left direction and 
		// count the number of X and O marks. 
		for(int row = 0, col = boardColSize - 1; row < boardRowSize && col >= 0; row++, col--) {
			// If the mark at the given position equals X, increment the X mark counter.
			if(this.getMark(row, col).equals("X")) {
					countXMarks++;
			// Otherwise, if the mark at the given position equals O, increment the O mark counter.
			} else if (this.getMark(row, col).equals("O")){
					countOMarks++;
			}
		}
		// If the number of countXMarks is 3 and the winner data field 
		// does not have a mark other than the dash (meaning O has not won on this board already),
		// set the winner to X and return true.
		if (countXMarks == 3 && !winner.equals("O")) {
			setWinner("X");
			return true;
		// If the number of countOMarks is 3 and the winner data field 
		// does not have a mark other than the dash (meaning X has not won on this board already),
		// set the winner to O and return true.
		} else if (countOMarks == 3 && !winner.equals("X")) {
			setWinner("O");
			return true;
		}
		// Otherwise, return false as no winner has been found yet.
		return false;
	}
	
	// The checkColumn method checks for three consecutive marks
	// in each column in a board. The method takes in no input parameters, 
	// but it is expected to return a boolean value. 
	private boolean checkColumn() {
		// Go through each column in the board and count the number of X and O marks. 
		for(int col = 0; col < boardColSize; col++) {
			// Reset the counter variables for X and O marks in each iteration.
			int countXMarks = 0;
			int countOMarks = 0;
			// Go through the rows in a given column and count the marks. 
			for(int row = 0; row < boardColSize; row++) {
				if(this.getMark(row, col).equals("X")) {
					countXMarks++;
				// Otherwise, if the mark at the given position equals O, increment the O mark counter.
				} else if (this.getMark(row, col).equals("O")){
					countOMarks++;
				}
			}
			// If the number of countXMarks is 3 and the winner data field 
			// does not have a mark other than the dash (meaning O has not won on this board already),
			// set the winner to X and return true.
			if (countXMarks == 3 && !winner.equals("O")) {
				setWinner("X");
				return true;
			// If the number of countOMarks is 3 and the winner data field 
			// does not have a mark other than the dash (meaning X has not won on this board already),
			// set the winner to O and return true.
			} else if (countOMarks == 3 && !winner.equals("X")) {
				setWinner("O");
				return true;
			}
		}
		// Otherwise, return false as no winner has been found yet.
		return false;
	}
	
	// The checkRow method checks for three consecutive marks
	// in each row in a board. The method takes in no input parameters, 
	// but it is expected to return a boolean value. 
	private boolean checkRow() {
		// Go through each row and count the number of X and O marks. 
		for(int row = 0; row < boardRowSize; row++) {
			// Reset the counter variables for X and O marks in each iteration. 
			int countXMarks = 0;
			int countOMarks = 0;
			// Go through each column in a given row and count the marks. 
			for(int col = 0; col < boardColSize; col++) {
				// If the mark at the given position equals X, increment the X mark counter.
				if (this.getMark(row, col).equals("X")) {
					countXMarks++;
				// If the mark at the given position equals O, increment the O mark counter.
				} else if (this.getMark(row, col).equals("O")) {
					countOMarks++;
				}
			}
			// If the number of countXMarks is 3 and the winner data field 
			// does not have a mark other than the dash (meaning O has not won on this board already),
			// set the winner to X and return true.
			if (countXMarks == 3 && !winner.equals("O")) {
				setWinner("X");
				return true;
			// If the number of countOMarks is 3 and the winner data field 
			// does not have a mark other than the dash (meaning X has not won on this board already),
			// set the winner to O and return true.
			} else if (countOMarks == 3 && !winner.equals("X")) {
				setWinner("O");
				return true;
			}
		}
		// Otherwise, return false as no winner has been found yet.
		return false;
	}

	// The getWinner method returns the winner of the board using
	// the winner data field. The method takes in no input parameters
	// but it is expected to return a String.
	public String getWinner() {
		return winner;
	}

	// The setWinner method sets the winner data field using its
	// input parameter. The method takes in a String as an input
	// parameter, and it is not expected to return anything.
	public void setWinner(String winner) {
		this.winner = winner;
	}
	
	// The getMark method retrieves the place holder (mark) in a
	// box at a certain position. The method takes in two integer input
	// parameters, and it is expected to return a String.
	public String getMark(int row, int col) {
		// Call the getPlaceHolder method on a certain index of the boxes array. 
		// If row = 1 and col = 1, the formula [row * this.boardRowSize + col] would be
		// would result in Box #4. 
		String mark = this.boxes[row * this.boardColSize + col].getPlaceHolder(); 
		// Return the mark in a certain box. 
		return mark;
	}
	
	// The getColSize method returns the board column size of
	// a board. The method takes in no input parameters, but
	// it returns an integer. 
	public int getColSize() {
		return this.boardColSize;
	}
	
	// The getRowSize method returns the board row size of
	// a board. The method takes in no input parameters, but
	// it returns an integer. 
	public int getRowSize() {
		return this.boardRowSize;
	}

	// The reset method resets a board by calling the initializeBoard
	// method (that method will set all place holders back to dash symbol). 
	// The method takes in no input parameters and it is not expected to return anything.
	public void reset() {
		// Reset a single board by calling the initializeBoard method.
		this.initializeBoard();
	}
	
	
}

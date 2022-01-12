/* Mansi Patel
 * CS 2336.002
 * Ultimate TTT Game Course Project
 * 11/24/21
 */

/* The UltimateGameBoard class creates a large board of a given size
 * with the appropriate number of boards (3 boards x 3 boards = 9 boards). 
 * The UltimateGameBoard class also places marks in boards based on the
 * previously placed mark of the last player, checks if there is a winner
 * of three consecutive boards, and prints the 9 boards row by row. The
 * UltimateGameBoard class has a composition relationship with the Board
 * class. 
*/

public class UltimateGameBoard {
	
	// Create a "game_boards" object array of type Board
	// to hold each board in the Ultimate Game Board.
	private Board[] game_boards;
	// Create integer data fields for the boardRowSize and
	// boardColSize, which will be set in the class constructors.
	private int boardRowSize;
	private int boardColSize;
	
	// The default constructor of the UltimateGameBoard class 
	// calls the custom constructor of the UltimateGameBoard
	// class, passing in the default values of 3 for the row
	// and column size. The method takes in no input parameters. 
	public UltimateGameBoard() {
		this(3, 3);
	}
	
	
	// The UltimateGameBoard custom constructor will call the
	// setSize method to set the size of the board. The method
	// takes in two integer parameters. 
	public UltimateGameBoard(int rowSize, int colSize) {
		this.setSize(rowSize, colSize);
	}
	
	// The setSize method validates the input parameters
	// to see if they are a valid board size. If so, the method
	// calls the initializeBoard method to set all boards in the
	// Ultimate Game Board.  The setSize method takes in two integer 
	// input parameters, and it is not expected to return anything.
	public void setSize (int row, int col) {
		// If the row size and column size is less than 3,
		// report that the minimum Ultimate Game Board size must be 3x3.
		if(row < 3 || col < 3) {
			System.out.println("Minimum Ultimate Game Board size is 3x3.");
		} else {
			// If the row size and column size are appropriate values,
			// set the boardColSize and boardRowSize data fields to
			// their respective input parameters.
			this.boardColSize = col;
			this.boardRowSize = row;
			// Call the initializeBoard method to set up all 9 boards with their
			// initial marks.
			initializeBoard();
		}
		
	}
	
	// The initializeBoard method will initialize the "game_boards" array data field
	// and initialize each board by calling the Board constructor for each index. 
	// The method takes in no input parameters  and it is not expected to return anything.
	public void initializeBoard() {
		// Initialize the "game_boards" array data field and set its size
		// to boardColSize * boardRowSize; this will allow us to emulate
		// a 2D array, even though it is a 1D array. 
		game_boards = new Board[boardColSize * boardRowSize];
		// Iterate through each index in the "game_boards" object array.
		for(int index = 0; index < game_boards.length; index++) {
			// Create a new instance of the Board class and set the element at
			// the given index to the instance. 
			// This will create the 9 individual boards in a 3x3 array of boards.
			// Each Board object within the "game_boards" array will have 3x3 dimensions.
			Board a_board = new Board(3, 3);
			// Each index of "game_boards" array will be a Board object.
			game_boards[index] = a_board;
		}
	}

	
	// The print method will print all nine boards of the Ultimate
	// Game Board row by row, along with their corresponding marks
	// and board numbers. The method takes in no input parameters,
	// and it is not expected to return anything. 
	public void print() {
		// Please note that the print method goes through each singular row
		// in the Ultimate Game Board and prints the information accordingly.
		// This method does not go board by board, it will instead
		// go through each line in the Ultimate Game Board (9 lines from Row 0
		// in the top boards to Row 8 in the bottom boards).
		// Create a row counter to use for output display.
		int row_counter = 0;
		// Iterate through each row in entire game_boards array (9 rows total).
		for(int ultimate_row = 0; ultimate_row < game_boards.length; ultimate_row++) {
			// Calculate the start_board_index of a given row in the ultimate board using / 3. 
			// I.e. If ultimate_row is 0, then (0 / 3) * 3 =  0, so start at board 0
			// ultimate_row is 4 = (4 / 3) * 3 = start at board 3 
			// ultimate_row is 6 = (6 / 3) * 3 = start at board 6
			// This will help create rows with Boards 0 - 2 in row 1, 3 - 5 in row 2,
			// and 6 - 8 in row 3.
			int start_board_index = (ultimate_row / 3) * 3;
			// Iterate through the boards in a given row, which ranges from start_board_index to start_board_index + 2
			// since there must be three boards printed per row.
			for (int board_number = start_board_index; board_number <= start_board_index + 2; board_number++) {
				// Store the board corresponding to the board_number (index) in the "game_boards" array. 
				Board current_board = game_boards[board_number];
				// Print the board number. 
				System.out.print(" Board #" + board_number + " ");
				for (int column_in_board = 0; column_in_board < boardColSize; column_in_board++) {
					// (ultimate_row % 3) will get the specific row number in 9 total rows. 
					// Print the mark in each column of a given row by calling the getMark
					// method of the Board class and passing in the calculated row number
					// and current column position.
					System.out.print("[ " + current_board.getMark(ultimate_row % 3, column_in_board) + " ]");
				}
				// Once we have printed three columns, we go back to the outer for loop with board_number
				// as the index variable to print another board and iterate through its columns.
			}
			// Since another row of the Ultimate Game Board has been printed, increment the row counter. 
			row_counter++;
			// Add a new line to move to the next row in output.
			System.out.println();
			// If row_counter is a value divisible by 3 (0 , 6, 9), add another new line.
			// This will separate each row of boards. 
			if (row_counter % 3 == 0) {
				System.out.println();
			}
			// Since we have printed another row column by column of the Ultimate Game Board,
			// we return to the outer-most for loop to move on to the next row. 
		}
	}

	// The isWinner method checks if there is a winner of three consecutive
	// boards in a given direction. The method takes in no input parameters,
	// but it is expected to return a boolean. 
	public boolean isWinner() {
		// Create a winner_board of type Board (size 3x3) to keep track of winners of each 
		// individual board in their respective spots.
		Board winner_board = new Board(3, 3);
		System.out.println("------------------------------------------------------");
		// Iterate through each board in the "game_boards" array.
		for(int index = 0; index < game_boards.length; index++) {
			// For a given board, check if there is a winner on that board by calling
			// the isWinner method from the Board class for each Board object. 
			if (game_boards[index].isWinner()) {
				// If there is a winner for the board, place the winning mark in the respective spot
				// in the winner_board.
				// I.e. If index = 2 and the winner of Board #2 is X, then Box #2 of the winner board
				// will have a X mark to indicate X won Board #2. 
				winner_board.makeMove(game_boards[index].getWinner(), index/boardColSize, index%boardColSize);
				// Print the winner of the board along with the board number. 
				System.out.println("Board #" + index + " Winner: " + game_boards[index].getWinner());
				// If the board isn't full but there is a winner present, replace all open spots with * symbol.
				if(!game_boards[index].isFull()) {
					game_boards[index].replaceWithAsterisks();
				}
			}
		}
		System.out.println("------------------------------------------------------");
		// In the winner board, check if there are 3 consecutive marks for a player
		// in a given direction. Three consecutive marks in the winner board indicates
		// that the player won three consecutive boards in a given direction. 
		if (winner_board.isWinner()) {
			return true;
		}
		return false;
	}
	
	// The getMark method returns the mark placed at a certain position
	// in a specific board. The getMark method of Ultimate Game Board class 
	// receives three input parameters and it is expected to return a String.
	public String getMark(int board_number, int row, int col) {
		// Call the getMark method of the Board class for 
		// the corresponding Board object in the "game_boards" array.
		// Pass in the row and column to indicate the position we want
		// to get the mark from.
		return game_boards[board_number].getMark(row, col);
	}
	
	// The makeMove method places a move on a board in the Ultimate Game Board
	// based on the opponent's previous position. The method takes in an integer
	// and an APlayer object as input parameters. It is expected to return an integer. 
	public int makeMove(int previous_position, APlayer player) {
		// Store the previous_position input parameter into chosen_board. 
		int chosen_board = previous_position;
		// If the game has just started or the opponent sent the current player to a board that
		// is full, the current player can choose the board in which he/she wants to place their next move.
		if (previous_position == -1 || game_boards[previous_position].isFull()) {
			System.out.println(player.getName() + " gets to choose the board in which they want to place the next move!");
			// Call the selectBoardNumber method of the APlayer class and set the range value to 9.
			chosen_board = player.selectBoardNumber(9);
		} 
		// If the chosen board is full, report that it is full and allow the
		// player to select another board. 
		while (game_boards[chosen_board].isFull()) {
			System.out.println("Chosen Board #"+ chosen_board + ": This board is full. Please try again.");
			chosen_board = player.selectBoardNumber(9);
		}
		// Once they have selected a board that is not full and it is valid, print the board number. 
		System.out.println("Board # to Place Move: " + chosen_board);
		// Call the Board class makeMove method to allow the player to make
		// a move on that board. Call the APlayer class' selectRowValue and selectColValue
		// methods to prompt for and validate input row and column values. 
		int chosen_box = game_boards[chosen_board].makeMove(player.getMark(), player.selectRowValue(boardRowSize, chosen_board),
				player.selectColValue(boardColSize, chosen_board));
		// If chosen_box equals -1 (meaning the makeMove method from Board class returned -1
		// indicating that spot is taken), allow the user to choose another spot until
		// they have made a legal move. 
		while (chosen_box == -1) {
			System.out.println("Please try again.");
			chosen_box = game_boards[chosen_board].makeMove(player.getMark(), player.selectRowValue(boardRowSize, chosen_board),
					player.selectColValue(boardColSize, chosen_board));
		}
		// Once the player has made a legal move, print the box number they have placed their mark in.
		System.out.println("Chosen Box in Board #" + chosen_board + ": " + chosen_box);
		// Return the box number.
		return chosen_box;
	}

	// The isFull method checks if all 9 boards in the Ultimate Game Board are
	// full. The method takes in no input parameters, but it is expected
	// to return a boolean value.
	public boolean isFull() {
		// Create a counter variable to keep track of how many boards are full.
		int full_boards_count = 0;
		for (int index = 0; index < game_boards.length; index++) {
			// Iterate through each board in "game_boards" array and check if 
			// each is full, updating the full_boards_count counter variable 
			// as needed.
			if (game_boards[index].isFull()) {
				// If the board is full, increment the full_board_count variable.
				full_boards_count++;
			}
		}
		// Once iterating through the game_boards_array, if the full_boards_count variable
		// equals 9, then return true as all boards have been filled up.
		if (full_boards_count == 9) {
			return true;
		}
		// Otherwise, return false.
		return false;
	}

	// The getColSize method returns the board column size of
	// the Ultimate Game Board. The method takes in no input 
	// parameters, but it returns an integer.
	public int getColSize() {
		return boardColSize;
	}

	// The getRowSize method returns the board row size of
	// the Ultimate Game Board. The method takes in no input 
	// parameters, but it returns an integer. 
	public int getRowSize() {
		return boardRowSize;
	}


	// The reset method resets the UltimateGameBoard board by calling the reset
	// method for each board in the "game_boards" array. The method takes in no 
	// input parameters and it is not expected to return anything.
	public void reset() {
		// Iterate through each board in game_boards array and reset 
		// each board individually by calling the reset method of the Board
		// class. 
		for (int index = 0; index < game_boards.length; index++) {
			Board a_board = game_boards[index];
			a_board.reset();
		}
	}

	
}

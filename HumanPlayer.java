/* Mansi Patel
 * CS 2336.002
 * Ultimate TTT Game Course Project
 * 11/24/21
 */

/* The HumanPlayer class is a subclass of the APlayer class
 * in which users can input board numbers and row and column values
 * to play the game. The HumanPlayer class has an inheritance relationship
 * with the APlayer class. 
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer extends APlayer {
	
	// Create a data field of type Scanner to read in user input. 
	Scanner input = new Scanner(System.in);
	
	// The custom constructor of the HumanPlayer class calls
	// its super constructor (APlayer) to set the name and 
	// mark of its objects. The method takes in two String type
	// input parameters. 
	public HumanPlayer(String name, String mark) {
		super(name, mark);
	}
	
	
	// Override selectRowValue and selectColValue
	// methods from superclass APlayer.
	@Override
	// The selectRowValue method prompts the user to enter
	// a row value from 0 to 2 in a given board. The method
	// takes in two integer input parameters, and it is
	// expected to return an integer.
	public int selectRowValue(int range, int board_number) {
		int row = 0;
		// The do-while loop will prompt the user; it will continue
		// to reprompt the user and get input until the input is 
		// considered valid. 
		do {
			// If the user enters a value that is not of type int, the
			// try and catch block will allow the user to reenter input
			// until it is valid. 
			try {
				// Prompt the user to enter a row number from 0 to 2 in a given
				// board. 
				System.out.print("Please enter a valid row number (0 to " + (range-1) + ") for Board #" + board_number + ": ");
				row = input.nextInt();
				// If the row number is not within the given range, report this to the user
				// and set row to -1 (will cause us to loop again).
				if (row < 0 || row >= range) {
					System.out.println("You entered invalid input. Please try again.");
					row = -1;
				}
			} catch (InputMismatchException e) {
				// If the user entered an input that is not of type int, report this
				// to the user and set row to -1. 
				System.out.println("You entered invalid input. Please try again.");
				row = -1;
			}
			// Get new input from the user. 
			input.nextLine();
		} while (row < 0 || row >= range);
		// Return the selected, input validated row number. 
		return row;
	}
	
	@Override
	// The selectColValue method prompts the user to enter
	// a column value from 0 to 2 in a given board. The method
	// takes in two integer input parameters, and it is
	// expected to return an integer.
	public int selectColValue(int range, int board_number) {
		int column;
		// The do-while loop will prompt the user; it will continue
		// to reprompt the user and get input until the input is 
		// considered valid. 
		do {
			// If the user enters a value that is not of type int, the
			// try and catch block will allow the user to reenter input
			// until it is valid. 
			try {
				// Prompt the user to enter a column number from 0 to 2 in a given
				// board. 
				System.out.print("Please enter a valid column number (0 to " + (range-1) + ") for Board #" + board_number + ": ");
				column = input.nextInt();
				// If the column number is not within the given range, report this to the user
				// and set column to -1 (will cause us to loop again).
				if (column < 0 || column >= range) {
					System.out.println("You entered invalid input. Please try again.");
					column = -1;
				}
			} catch (InputMismatchException e) {
				// If the user entered an input that is not of type int, report this
				// to the user and set row to -1. 
				System.out.println("You entered invalid input. Please try again.");
				column = -1;
			}
			// Get new input from the user. 
			input.nextLine();
		} while (column < 0 || column >= range);
		// Return the selected, input validated column number. 
		return column;
	}
	
	@Override
	// The selectBoardNumber method prompts the user to enter
	// a row value from 0 to 8 in a given board. The method
	// takes in one integer input parameter, and it is
	// expected to return an integer.
	public int selectBoardNumber(int range) {
		int board_number;
		// The do-while loop will prompt the user; it will continue
		// to reprompt the user and get input until the input is 
		// considered valid.
		do {
			// If the user enters a value that is not of type int, the
			// try and catch block will allow the user to reenter input
			// until it is a valid int. 
			try {
				// Prompt the user to enter a board number from 0 to 8 in the large Ultimate Game Board.
				System.out.print("Please enter a valid board number (0 to " + (range-1) + "): ");
				board_number = input.nextInt();
				// If the board number is not within the given range, report this to the user
				// and set board to -1 (will cause us to loop again).
				if (board_number < 0 || board_number >= range) {
					System.out.println("You entered invalid input. Please try again.");
					board_number = -1;
				}
			} catch (InputMismatchException e) {
				// If the user entered an input that is not of type int, report this
				// to the user and set board number to -1. 
				System.out.println("You entered invalid input. Please try again.");
				board_number = -1;
			}
			// Get new input from the user. 
			input.nextLine();
		} while (board_number < 0 || board_number >= range);
		// Return the selected, input validated board number. 
		return board_number;
	}
}

/* Mansi Patel
 * CS 2336.002
 * Ultimate TTT Game Course Project
 * 11/24/21
 */

/* The TTTGame class coordinates the game as it is running. The TTTGame
class will begin the game and continue the game until one of the 
"Game Over" conditions is satisfied. The TTTGame class works directly
with the APlayer class and UltimateGameBoard class.
*/

import java.util.Random;

public class TTTGame {
	
	// Create a "players" object array of type APlayer to hold the two
	// types of players participating in the game: either 
	// ComputerPlayers and/or HumanPlayers.
	private APlayer[] players = new APlayer[2];
	// Declare a "board" instance of the UltimateGameBoard class.
	private UltimateGameBoard board;
	// Create a "marks" array of type String to hold the
	// two types of marks utilized in the tic-tac-toe game.
	private String[] marks = {"X", "O"};
	// Create three variables initialized to the standard
	// row size, column size, and score needed to win.
	private int gameRowSize = 3;
	private int gameColSize = 3;
	private int gameScoreToWin = 3;
	// Create a "currentPlayerIndex" variable to use
	// with the "players" array.
	private int currentPlayerIndex = -1;
	// Create a "previous_position" variable to use 
	// when facilitating the game.
	private int previous_position = -1;
	
	// Default constructor for best practice
	public TTTGame() {

	}
	
	// The TTTGame custom constructor will call the
	// setPlayers and setBoard methods to set the two players
	// of the game and initialize the board instance of the
	// UltimateGameBoard class. The method takes in
	// two instances of the APlayer class. 
	public TTTGame(APlayer player1, APlayer player2) {
		setPlayers(player1, player2);
		setBoard();
	}
	
	// The setBoard method will create an instance of the UltimateGameBoard
	// class with row and column size 3. The method takes in no input parameters
	// and is not expected to return anything.
	private void setBoard() {
		// Create an instance of the UltimateGameBoard class and 
		// pass in the gameRowSize and gameColSize into the class constructor.
		// Set the board data field to this initialization.
		this.board = new UltimateGameBoard(gameRowSize, gameColSize);
	}
	
	// The setPlayers method will set the indexes of the players
	// array to objects of the APlayer type. Since the HumanPlayer 
	// and ComputerPlayer classes are subclasses of the APlayer class,
	// the players will be either HumanPlayer or ComputerPlayer. 
	// The method does not take in any input parameters and it is not expected to
	// return anything.
	public void setPlayers(APlayer player1, APlayer player2) {
		// Set index 0 of "players" array to the player1 input parameter.
		players[0] = player1;
		// Set index 1 of the "players" array to the player2 input parameter. 
		players[1] = player2;
	}
	
	// The startGame method will begin the game and continue running the game until
	// one of the end game conditions is satisfied. The method does not take
	// in any input parameters and it is not expected to return anything.
	public void startGame() {
		// Print the game header and rules.
		System.out.println("-----------------WELCOME TO THE ULTIMATE TIC TAC TOE GAME!-----------------");
		System.out.println("GAME RULES: ");
		System.out.println("Play this game with either another Human Player or a ");
		System.out.println("Computer Player. Based on your opponent's last move, you can ");
		System.out.println("only place a mark on the board determined by the position of their ");
		System.out.println("last placed mark. For example, if Player 1 was to place an X mark");
		System.out.println("in position (1, 1) or Box #4 of Board #0, Player 2 must place their next O ");
		System.out.println("mark in Board #4. Happy Gaming!");
		System.out.println();
		// Print the initial board with only dashes for place holders.
		board.print();
		System.out.println();
		// Begin the game and continue the game until one of two end game conditions
		// is satisfied: either there is a winner of the game or all nine boards are full.
		do {
			// Call the switchPlayer method to take turns for each player.
			switchPlayer(); 
			// The following loop will allow the player to make a move based on their opponent's
			// previous position by calling the Ultimate Game Board class' makeMove method.
			do {
				// Print the current player's mark.
				System.out.println("Current Player: " + players[this.currentPlayerIndex].getMark());
				// Call the UltimateGameBoard class' makeMove method and pass in the previous position
				// (set by opponent's last move) and the current player object. Set previous position
				// to the result of the method call. 
				previous_position = board.makeMove(previous_position, players[this.currentPlayerIndex]);
				// previous_position is set to -1 if the game has just begun.
			} while(previous_position == -1);
			// Once the current player has made a legal move, print the updated board.
			board.print(); 
			System.out.println();
		} while(!gameOver());
	}
	
	// The switchPlayer method will switch between players or choose a random player
	// to go first when the game begins. The method takes in no input parameters and it
	// is not expected to return anything. 
	private void switchPlayer() {
		if (currentPlayerIndex == -1) {
			// Generate a random number between 0 and 2 (2 is non-inclusive), and 
			// that player index associated with that value will go first. 
			// currentPlayerIndex = (int) (Math.random() % 2);
			Random random_number = new Random();
			currentPlayerIndex = random_number.nextInt(2);
		// If the currentPlayerIndex is 0, player 2 (index 1 of players array) gets a turn. 
		// Set currentPlayerIndex to 1.
		} else if (currentPlayerIndex == 0) {
			currentPlayerIndex = 1;
		// If the currentPlayerIndex is 1, player 1 (index 0 of players array) gets a turn. 
		// Set currentPlayerIndex to 0.
		} else if (currentPlayerIndex == 1) {
			currentPlayerIndex = 0;
		}
	}
	
	// The gameOver method checks if there is a winner in the Ultimate Game Board
	// or if all nine boards are full. If one of these conditions is true, the game
	// is over and the method returns true. The method takes in no input parameters
	// and it is expected to return a boolean value. 
	private boolean gameOver() {
		// Call the isWinner method of the UltimateGameBoard class to check
		// if three boards have a consistent winner in a given direction.
		if (board.isWinner()) {
			// If there is a winner, print the final board.
			System.out.println("Final Game Board: ");
			board.print();
			// State which mark won.
			System.out.println("Winner is Player " + players[this.currentPlayerIndex].getMark() + "!");
			System.out.println("GAME OVER");
			return true;
		}
		// Call the isFull method of the UltimateGameBoard class to check
		// if all nine boards are full and no winner has been reported. 
		else if(board.isFull()) {
			// If true, print the final board.
			System.out.println("Final Game Board: ");
			board.print();
			// Report that the board is full.
			System.out.println("The board is full!");
			System.out.println("GAME OVER");
			return true;
		}
		// If there is no winner and the nine boards are not full
		// yet, return false as the game is not over yet.
		return false;
	}
	
}

/* Mansi Patel 
 * CS 2336.002
 * Ultimate TTT Game Course Project
 * 11/24/21
 */

/* Analysis: What is the problem?
 * The program is expected to simulate an Ultimate Tic-Tac-Toe
 * Game in which there are 9 boards in the game board, and each player's
 * next move is dictated by their opponent's previous position. The program
 * is expected to allow three modes: Human vs. Human, Computer vs. Computer,
 * and Computer vs. Human. The program must allow users to play the game by entering
 * input, validating the input, and updating the boards as needed. At the end, the program
 * must determine the final winner of the Ultimate Board Game.
 */

/* Design: How am I going to solve the problem?
 * Seeking inspiration from the TTT Game Class Code Activity,
 * keep the foundation of the game similar. The Ultimate TTT Game
 * will need the Box class, Board class, TTT Game class, APlayer class and
 * its subclasses HumanPlayer and ComputerPlayer, and a DriverMain class for testing.
 * With these classes, modify each class to work with nine boards in an
 * Ultimate Game Board instead of one board. Using composition relationships, create
 * an UltimateGameBoard class to manage all nine boards in the game, instead of directly
 * working with each as we did with one board before. 
 */

/* Tests
 *  1) Computer VS. Computer: Tested for X as the winner in one game, O as the winner
 *  for another, and no winners.
 *  2) Computer VS. Human: Tested for invalid inputs and logical flow of the game.
 *  3) Human VS. Human: Tested for invalid inputs and illegal moves.
 */

public class DriverMain {
	public static void main(String[] args) {
		
		// To test Computer VS. Computer, uncomment the line below!
		TTTGame game = new TTTGame(new ComputerPlayer("Player 1", Mark.X.getMark()), 
				new ComputerPlayer("Player 2", Mark.O.getMark()));
		
		// To test Human VS. Computer, uncomment the line below!
//		TTTGame game = new TTTGame(new HumanPlayer("Player 1", Mark.X.getMark()), 
//				new ComputerPlayer("Player 2", Mark.O.getMark()));
		
		// To test Human VS. Human, uncomment the line below!
//		TTTGame game = new TTTGame(new HumanPlayer("Player 1", Mark.X.getMark()), 
//		new HumanPlayer("Player 2", Mark.O.getMark()));
		
		game.startGame();
		
	}
}

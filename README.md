# Ultimate-Tic-Tac-Toe-Game
The Ultimate Tic Tac Toe Game was created using Java in the fall of 2021.
The program is run through the DriverMain file. All of the files
present in this repository are crucial to run the program and to access full capabilities. 


What would I do differently if I had to implement this game all over again?
If I had to implement this game all over again, I would start with better project preparation
and management. One aspect that I struggled with while developing the game was that 
many classes and their methods unintentionally became tightly coupled, which made debugging 
extremely difficult. I realized the reason for this issue was that I had pulled many classes 
from the TTT Game Code Activity and simply began adding on to them for this game; I did not think 
about how I was going to organize my new additions and carefully incorporate them into these preexisting classes. 
A better approach would be to list each class and their pre-existing functions from the beginning, and 
then compare what I currently have with the instructions and sample runs to see what was left to be done
before jumping in to implementation. This would allow me to carefully add in new additions all while keeping
the foundation of the game intact and functional. 

In a few classes, some variables or methods remain unused. The primary reason for having these
unused methods were for debugging and safety purposes in case there were further issues during development.
Please feel free to disregard those variables or methods if you wish; they were apart of my own development
process. The game itself is fully functional and can be played in 3 modes: Computer vs. Computer, Human vs. Computer,
and Human vs. Human. To play in one of these modes, simply uncomment the appropriate lines in the DriverMain class. 
Please note that when a player makes a move to win a board, the NEXT board printed after they
made the move will have asterisks in the open spots of the board. 

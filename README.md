tictactoe-lld
Tic Tac Toe Game in Java
A simple console-based Tic Tac Toe game implemented in Java, supporting two players. The game ensures proper validation of inputs, checks for win conditions, and handles draw scenarios.

Features
Two-player mode with players denoted as X and O.
Validates user input to ensure no overwriting of occupied cells or out-of-bound inputs.
Automatically detects a win or draw condition after each move.
A simple and intuitive console-based interface.
How to Run
Clone this repository or copy the source files.
Ensure you have Java installed on your system.
Compile the project using the following command:
javac -d . App.java
java com.game.tictactoe.App

Game Rules The game is played on a 3x3 grid. Player X always starts first, followed by Player O. Players take turns to place their symbol in an empty cell by entering the row and column numbers. A player wins by completing a row, column, or diagonal with their symbol. The game ends in a draw if all cells are filled and no player wins.

Code Structure Classes Player: Represents a player with a specific symbol (X or O). Board: Manages the game board, including initialization, cell updates, and printing. Contains logic to check win conditions and board state (full/empty). Game: Orchestrates the game flow, alternating turns between players, and validates user input.

Key Methods initializeBoard(): Initializes the 3x3 grid with empty values. boardInsert(row, col, value): Updates the board with the player's symbol at the specified location. isGameWon(symbol): Checks if the given player has won the game. isBoardFull(): Determines if the board is full and no further moves are possible.

Welcome to Tic Tac Toe! It's your turn, X Enter row (0-2): 0 Enter column (0-2): 1 X -1 -1 -1 -1 -1 -1 -1 -1
It's your turn, O Enter row (0-2): 1 Enter column (0-2): 1 X -1 -1 -1 O -1 -1 -1 -1
Congratulations! Player X wins!"# tictactoe-lld" 

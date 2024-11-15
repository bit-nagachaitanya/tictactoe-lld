package com.game.tictactoe;
import java.util.*;

/**
 * Tic Tac Toe Game
 */
public class App {

    public enum PlayerSymbol {
        X, O
    }

    public static class Player {
        PlayerSymbol symbol;

        public Player(PlayerSymbol symbol) {
            this.symbol = symbol;
        }

        public PlayerSymbol getSymbol() {
            return this.symbol;
        }
    }

    public static class Board {
        String[][] box = new String[3][3];

        public Board() {
            initializeBoard();
        }

        public void initializeBoard() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    box[i][j] = "-1";
                }
            }
        }

        public void boardInsert(int row, int col, String value) {
            box[row][col] = value;
            printBoard();
        }

        public String giveValue(int row, int col) {
            return box[row][col];
        }

        public void printBoard() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(" " + box[i][j]);
                }
                System.out.println();
            }
        }

        public boolean isGameWon(String symbol) {
            // Check rows
            for (int i = 0; i < 3; i++) {
                if (box[i][0].equals(symbol) && box[i][1].equals(symbol) && box[i][2].equals(symbol)) {
                    return true;
                }
            }

            // Check columns
            for (int j = 0; j < 3; j++) {
                if (box[0][j].equals(symbol) && box[1][j].equals(symbol) && box[2][j].equals(symbol)) {
                    return true;
                }
            }

            // Check diagonals
            if (box[0][0].equals(symbol) && box[1][1].equals(symbol) && box[2][2].equals(symbol)) {
                return true;
            }
            if (box[0][2].equals(symbol) && box[1][1].equals(symbol) && box[2][0].equals(symbol)) {
                return true;
            }

            return false;
        }

        public boolean isBoardFull() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (box[i][j].equals("-1")) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static class Game {
        List<Player> players;
        Board board;

        public Game(List<Player> players) {
            this.players = players;
            this.board = new Board();
        }

        public void start() {
            Scanner sc = new Scanner(System.in);
            boolean won = false;

            while (!won) {
                for (Player player : players) {
                    System.out.println("It's your turn, " + player.getSymbol());
                    int row, col;
                    while (true) {
                        System.out.println("Enter row (0-2): ");
                        row = sc.nextInt();
                        System.out.println("Enter column (0-2): ");
                        col = sc.nextInt();

                        if (row < 0 || row > 2 || col < 0 || col > 2 || !board.giveValue(row, col).equals("-1")) {
                            System.out.println("Invalid move. Try again.");
                        } else {
                            break;
                        }
                    }

                    // Update the board
                    board.boardInsert(row, col, player.getSymbol().toString());

                    // Check for win or draw
                    if (board.isGameWon(player.getSymbol().toString())) {
                        System.out.println("Congratulations! Player " + player.getSymbol() + " wins!");
                        won = true;
                        break;
                    }

                    if (board.isBoardFull()) {
                        System.out.println("It's a draw!");
                        won = true;
                        break;
                    }
                }
            }
            sc.close();
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe!");

        // Initialize players
        Player player1 = new Player(PlayerSymbol.X);
        Player player2 = new Player(PlayerSymbol.O);

        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        // Start the game
        Game game = new Game(players);
        game.start();
    }
}

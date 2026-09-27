import java.util.ArrayList;
import java.util.Scanner;

class Players {
    private String PlayerName;
    private char symbol;

    public Players(String PlayerName, char symbol) {
        this.PlayerName = PlayerName;
        this.symbol = symbol;
    }

    public String getName() {
        return PlayerName;
    }

    public char getSymbol() {
        return symbol;
    }
}

class Board {
    private char[][] board = new char[3][3];

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean checking(int row, int col, char symbol) {
        if (row < 0 || col < 0 || row > 2 || col > 2) {
            return false;
        }
        if (board[row][col] == ' ') {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    public boolean checkFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    return false;
        return true;
    }

    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][0] == board[i][2])
                return true;
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[0][i] == board[2][i])
                return true;
        }
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2])
            return true;
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0])
            return true;
        return false;
    }

    public char[][] getBoard() {
        char[][] copy = new char[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                copy[i][j] = board[i][j];
        return copy;
    }
}

class TicTac {
    private Board board1;
    private Players Player1;
    private Players Player2;
    private History history;

    public TicTac(String name1, String name2, char symbol1, char symbol2, History history) {
        board1 = new Board();
        Player1 = new Players(name1, symbol1);
        Player2 = new Players(name2, symbol2);
        this.history = history;
    }

    public void startGame() {
        Scanner sc = new Scanner(System.in);
        Players now = Player1;

        while (true) {
            board1.printBoard();
            System.out.println(now.getName() + " moves");
            System.out.print("Choose Row (1-3): ");
            int row = sc.nextInt() - 1;
            System.out.print("Choose Col (1-3): ");
            int col = sc.nextInt() - 1;

            if (!board1.checking(row, col, now.getSymbol())) {
                System.out.println("Wrong move. Please choose again.");
                continue;
            }

            if (board1.checkWin()) {
                board1.printBoard();
                System.out.println("The player " + now.getName() + " wins!!!");
                history.saveBoard(board1.getBoard());
                break;
            }

            if (board1.checkFull()) {
                board1.printBoard();
                System.out.println("Draw game");
                history.saveBoard(board1.getBoard());
                break;
            }

            now = (now == Player1) ? Player2 : Player1;
        }
    }
}

class History {
    private ArrayList<char[][]> historyOfGames = new ArrayList<>();

    public void saveBoard(char[][] board) {
        char[][] copyBoard = new char[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                copyBoard[i][j] = board[i][j];
        historyOfGames.add(copyBoard);
    }

    public void printHistory() {
        if (historyOfGames.isEmpty()) {
            System.out.println("No games played yet!");
            return;
        }

        System.out.println("--- HISTORY OF GAMES ---");
        int numberOfGame = 1;
        for (char[][] b : historyOfGames) {
            System.out.println("Game #" + numberOfGame++);
            for (int i = 0; i < 3; i++) {
                System.out.println(" " + b[i][0] + " | " + b[i][1] + " | " + b[i][2]);
                if (i < 2) System.out.println("-----------");
            }
            System.out.println();
        }
    }
}

public class Task {
    public static void main(String[] args) {
        Task gameApp = new Task();
        gameApp.gameTicTac();
    }

    public void gameTicTac() {
        Scanner in = new Scanner(System.in);
        History history = new History();

        while (true) {
            System.out.println("--- TIC-TAC GAME ---");
            System.out.println("Choose one of Options: ");
            System.out.println("1. Start Game");
            System.out.println("2. Show History");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");

            int N = in.nextInt();

            switch (N) {
                case 1:
                    startNewGame(history);
                    break;
                case 2:
                    history.printHistory();
                    break;
                case 3:
                    System.out.println("Exiting game...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
                    N = in.nextInt();
            }
        }
    }

    public void startNewGame(History history) {
        Scanner sac = new Scanner(System.in);
        System.out.print("Enter the name of Player1: ");
        String names1 = sac.next();
        System.out.print("Enter the name of Player2: ");
        String names2 = sac.next();
        System.out.println(names1 + " Choose symbol: 'X'->1  'O'->2 ");
        int ind = sac.nextInt();

        char symbols1, symbols2;
        while (true) {
            if (ind != 1 && ind != 2) {
                System.out.println("Invalid choice. Please choose again");
                ind = sac.nextInt();
                continue;
            }
            if (ind == 1) {
                symbols1 = 'X';
                symbols2 = 'O';
            } else {
                symbols1 = 'O';
                symbols2 = 'X';
            }
            break;
        }

        TicTac game = new TicTac(names1, names2, symbols1, symbols2, history);
        game.startGame();
    }
}

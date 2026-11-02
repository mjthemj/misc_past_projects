package hw2AI.src;

//import java.util.Arrays;
import java.util.Scanner;


public class TicTacToe {

    char Board[][];
    int spacesLeft;

    public TicTacToe(){
        spacesLeft = 9;
        Board = new char[3][3];
        for (int i = 0; i <Board.length; i++){
            for (int j = 0; j < Board.length; j++){
                Board[i][j] = ' ';
            }
        }
    }

    public int playGame(){
        System.out.println("Hello and welcome to Tic Tac Toe!");
        printBoard();
        Scanner scan = new Scanner(System.in);
        while (spacesLeft > 0){
            playerMove(scan);
            if (winCondition() == -1){
                System.out.println("Congrats! You won!");
                scan.close();
                return 1;
            }
            else if (spacesLeft <= 0)
                break;
            else{
            aiMove();
            if (winCondition() == 1){
                System.out.println("The AI has won the game!");
                scan.close();
                return 2;
            }
            }
        }

        System.out.println("Tie!\nA strange game. The only winning move is not to play.");
        scan.close();
        return 0;
    }

    public void printBoard(){
        System.out.println("-------------");
        for (int i = 0; i < 3; i++){
            System.out.print("| ");
            for (int j = 0; j < 3; j++){
                System.out.print(Board[i][j]);
                System.out.print(" | ");
            }
            System.out.println("\n-------------");
        }
        
    }

    public void playerMove(Scanner scan){
        boolean didThatWork = false;
        while (didThatWork == false && scan.hasNextLine()){
       try{
            System.out.println("Your Turn! Enter the coordinates of your move.");
            String response = scan.nextLine();
            String[] splitstr = response.split(" ", 2);
            int xCoord = Integer.parseInt(splitstr[0]);
            int yCoord = Integer.parseInt(splitstr[1]);

            if (xCoord < 0 || xCoord > 2){
                System.out.println("Invalid first coordinate! Enter 0, 1, or 2.");
                didThatWork = false;
            }
            else if (yCoord < 0 || yCoord > 2){
                System.out.println("Invalid second coordinate! Enter 0, 1, or 2.");
                didThatWork = false;

            }
            else if (!(validMove(xCoord, yCoord))){
                System.out.println("Invalid move! An X or O already exists there.");
                didThatWork = false;
            }
            else{
                didThatWork = true;
                Board[xCoord][yCoord] = 'O';
            }
        } catch (Exception e){
            System.out.println("Error! Enter coordinates like this: 0 1");
            didThatWork = false;
        }}
        printBoard();
        spacesLeft--;
        System.out.println("Nice!");
    }

    public void aiMove(){
        int maxVal = -2;
        int coord[] = new int[2];
        char[][] S = Board;
        for (int i = 0; i < 3; i++){//find spot
            for (int j = 0; j < 3; j++){
                if (S[i][j] == ' '){
                    S[i][j] = 'X';
                    int val = minimax(S, spacesLeft - 1, 8 - spacesLeft, true);
                    if (val > maxVal){
                        maxVal = val;
                        coord[0] = i;
                        coord[1] = j;
                    }
                    S[i][j] = ' ';
                }
            }
        }
        //make the best move
        Board[coord[0]][coord[1]] = 'X';
        spacesLeft--;
        printBoard();
        System.out.println("AI has made its move!");
    }

    public int minimax(char[][] S, int hypotheticalSpacesLeft, int depth, boolean aiTurn){//no alpha and beta because everything's -1, 0, or 1
        /*if (depth > 9){//this should be impossible
            return 0;
        }*/
        if (hypotheticalSpacesLeft <= 0){//terminal state: tie
            return 0;
        }
        int winCheck = hypotheticalWinCondition(S);
        if (winCheck != 0){//terminal state: win
            return winCheck;
        }
        if (aiTurn){//maxValue
            int bestMove = -2;
            for (int i = 0; i < 3; i++){//find spot
                for (int j = 0; j < 3; j++){
                    if (S[i][j] == ' '){
                        S[i][j] = 'X';
                        int thisMove = minimax(S, hypotheticalSpacesLeft - 1, depth + 1, false);
                        if (thisMove > bestMove){
                            bestMove = thisMove;
                        }
                        S[i][j] = ' ';
                    }
                }
            }
            return bestMove;
        }
        else{//playerTurn, minValue
            int bestMove = 2;
            for (int i = 0; i < 3; i++){//find spot
                for (int j = 0; j < 3; j++){
                    if (S[i][j] == ' '){
                        S[i][j] = 'O';
                        int thisMove = minimax(S, hypotheticalSpacesLeft - 1, depth + 1, true);
                        if (thisMove < bestMove){
                            bestMove = thisMove;
                        }
                        S[i][j] = ' ';
                    }
                }
            }
            return bestMove;
        }
    }


    public boolean validMove(int x, int y){
        if (Board[x][y] == ' '){
            return true;
        }
        else return false;
    }

    public int winCondition(){//player = -1, ai = 1, not win = 0
        //player win?
        for (int i = 1; i< 3; i++){
            char col1 = Board[0][i];
            char col2 = Board[1][i];
            char col3 = Board[2][i];
            if (col1 == 'O' && col1 == col2 && col2 == col3){
                return -1;
            }
            char row1 = Board[i][0];
            char row2 = Board[i][1];
            char row3 = Board[i][2];
            if (row1 == 'O' && row1 == row2 && row2 == row3){
                return -1;
            }
        }
        if (Board[1][1] == 'O'){
            if ((Board[0][0] == Board[1][1] && Board[1][1] == Board[2][2]) || (Board[0][2] == Board[1][1] && Board[1][1] == Board[2][0])){
                return -1;
            }
        }

        //AI win?
        for (int i = 1; i< 3; i++){
            char col1 = Board[0][i];
            char col2 = Board[1][i];
            char col3 = Board[2][i];
            if (col1 == 'X' && col1 == col2 && col2 == col3){
                return 1;
            }
            char row1 = Board[i][0];
            char row2 = Board[i][1];
            char row3 = Board[i][2];
            if (row1 == 'X' && row1 == row2 && row2 == row3){
                return 1;
            }
        }
        if (Board[1][1] == 'X'){
            if ((Board[0][0] == Board[1][1] && Board[1][1] == Board[2][2]) || (Board[0][2] == Board[1][1] && Board[1][1] == Board[2][0])){
                return 1;
            }
        }
        //nobody has won
        return 0;
    }

    /*Listen. There's definitely a better way of writing this than
        making two different functions to check for win conditions.
        But sometimes when you make an omelette, you need to use
        two cartons of eggs, you know?
    */

    public int hypotheticalWinCondition(char[][] Board){//player = -1, ai = 1, not win = 0
        //player win?
        for (int i = 1; i< 3; i++){
            char col1 = Board[0][i];
            char col2 = Board[1][i];
            char col3 = Board[2][i];
            if (col1 == 'O' && col1 == col2 && col2 == col3){
                return -1;
            }
            char row1 = Board[i][0];
            char row2 = Board[i][1];
            char row3 = Board[i][2];
            if (row1 == 'O' && row1 == row2 && row2 == row3){
                return -1;
            }
        }
        if (Board[1][1] == 'O'){
            if ((Board[0][0] == Board[1][1] && Board[1][1] == Board[2][2]) || (Board[0][2] == Board[1][1] && Board[1][1] == Board[2][0])){
                return -1;
            }
        }

        //AI win?
        for (int i = 1; i< 3; i++){
            char col1 = Board[0][i];
            char col2 = Board[1][i];
            char col3 = Board[2][i];
            if (col1 == 'X' && col1 == col2 && col2 == col3){
                return 1;
            }
            char row1 = Board[i][0];
            char row2 = Board[i][1];
            char row3 = Board[i][2];
            if (row1 == 'X' && row1 == row2 && row2 == row3){
                return 1;
            }
        }
        if (Board[1][1] == 'X'){
            if ((Board[0][0] == Board[1][1] && Board[1][1] == Board[2][2]) || (Board[0][2] == Board[1][1] && Board[1][1] == Board[2][0])){
                return 1;
            }
        }
        //nobody has won
        return 0;
    }

}


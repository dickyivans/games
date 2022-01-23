package com.dickyis.games.service;

import java.util.Scanner;

public class GamesService {
    public void startTicTacToe() {
        System.out.println("RUN TICTACTOE GAME");
        Scanner in2 = new Scanner(System.in);
        System.out.println("Input Board Size :");
        int boardSize = in2.nextInt();


        //Get Players Name
        Scanner in = new Scanner(System.in);
        System.out.println("Player 1 Name: ");
        String p1 = in.nextLine();
        System.out.println("Player 2 Name: ");
        String p2 = in.nextLine();

        char[][] board = new char[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++){
            for (int j = 0; j < boardSize; j++){
                board[i][j] = '-';
            }
        }

        boolean isPlayer1 = true;
        boolean gameEnded = false;

        while (!gameEnded){
            drawBoard(board);

            char symbol = '-';
            if (isPlayer1){
                symbol = 'x';
            } else {
                symbol ='o';
            }

            if (isPlayer1){
                System.out.println(p1+"'s Turn (x)");
            } else {
                System.out.println(p2 + "'s Turn (o)");
            }

            int row = 0;
            int col = 0;

            while (true){
                System.out.println("Enter a row : *Start from 0");
                row = in.nextInt();
                System.out.println("Enter a col : *Start from 0");
                col = in.nextInt();

                if (row < 0 || col < 0 || row >= boardSize || col >= boardSize){
                    System.out.println("Your row and col are out of bounds!");
                }else if (board[row][col] != '-'){
                    System.out.println("Someone has already made a move there!");
                }else {
                    break;
                }
            }

            board[row][col] = symbol;

            if (hasWon(board) == 'x'){
                System.out.println(p1 + " has won!");
                gameEnded = true;
            }else if (hasWon(board) == 'o'){
                System.out.println(p2 + " has won!");
                gameEnded = true;
            }else {
                if (hasTied(board)){
                    System.out.println("It's a tie!");
                    gameEnded=true;
                } else {
                    isPlayer1 = !isPlayer1;
                }
            }
        }

        drawBoard(board);
    }

    public static void drawBoard(char[][] board){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static char hasWon(char[][] board){
        //Row
        for (int i = 0; i <board.length; i++){
            boolean inARow = true;
            char value = board[i][0];
            if (value == '-'){
                inARow = false;
            } else {
                for (int j = 0; j < board[i].length; j++){
                    if (board[i][j] != value){
                        inARow = false;
                        break;
                    }
                }
            }
            if (inARow){
                return value;
            }
        }

        //Col
        for (int j = 0; j <board.length; j++){
            boolean inACol = true;
            char value = board[j][0];
            if (value == '-'){
                inACol = false;
            } else {
                for (int i = 0; i < board[j].length; i++){
                    if (board[i][j] != value){
                        inACol = false;
                        break;
                    }
                }
            }
            if (inACol){
                return value;
            }
        }

        //First Diag
        boolean inDiag1 = true;
        char value1 = board[0][0];
        if (value1 == '-'){
            inDiag1 = false;
        } else {
            for (int i = 0; i < board.length; i++){
                if (board[i][i] != value1){
                    inDiag1 = false;
                    break;
                }
            }
        }
        if (inDiag1){
            return value1;
        }


        //Second Diag
        boolean inDiag2 = true;
        char value2 = board[0][board[0].length-1];
        if (value2 == '-'){
            inDiag2 = false;
        } else {
            for (int i = 0; i < board.length; i++){
                if (board[i][board[0].length-1-i] != value2){
                    inDiag2 = false;
                    break;
                }
            }
        }
        if (inDiag2){
            return value2;
        }

        //No Body Win

        return '-';
    }

    public static boolean hasTied(char[][] board){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j] == '-'){
                    return false;
                }
            }
        }
        return true;
    }
}

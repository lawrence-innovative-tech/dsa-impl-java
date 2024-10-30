package com.data.structure.example.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NQueenProblem {

    public static void main(String[] args) {
        int N = 4; // Change this value to test with different sizes
        List<List<String>> solutions = solveNQueens(N);
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    public static List<List<String>> solveNQueens(int N) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[N][N];

        // Initialize the board
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = '.';
            }
        }

        solveNQueensUtil(board, 0, solutions);
        return solutions;
    }

    private static void solveNQueensUtil(char[][] board, int row, List<List<String>> solutions) {
        if (row == board.length) {
            solutions.add(createSolution(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q'; // Place queen
                solveNQueensUtil(board, row + 1, solutions);
                board[row][col] = '.'; // Backtrack
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        // Check this column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper right diagonal
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private static List<String> createSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }
}

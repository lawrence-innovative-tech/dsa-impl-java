package com.data.structure.example.backtracking;

public class SudokuProblem {

    public static void main(String[] args) {

        int[][] sudokuBoard = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };



    }

    public static boolean isSafe(int[][] board, int row, int col){

        if (board[row][col] != 0){
            return false;
        }

        for (int i = 0; i < row; i++){
            if (board[i][col] == ){

            }

        }

        return true;
    }

}

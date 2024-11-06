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
        int[][] defaultBoard = new int[sudokuBoard.length][sudokuBoard.length];

        for (int i = 0; i < sudokuBoard.length; i++) {
            int j = 0, number = 0;

            while (j < sudokuBoard.length) {

                if ( number > sudokuBoard.length) {
                    j--;
                    if (j < 0) {
                        --i;
                        j = sudokuBoard.length - 1;
                    }
                    for (int k = j; k >= -1; k--) {
                        if (k == -1){
                            --i;
                            k = sudokuBoard.length;
                            continue;
                        }
                        if (defaultBoard[i][k] == 0) {
                            j = k;
                            break;
                        }
                    }
                    number = sudokuBoard[i][j];
                    sudokuBoard[i][j] = 0;
                    number++;
                    continue;
                }

                if (sudokuBoard[i][j] == 0){
                    if (isSafe(sudokuBoard, i, j, number)){
                        sudokuBoard[i][j] = number;
                        j++;
                        number = 0;
                    }
                    else {
                        number++;
                    }
                } else {
                    defaultBoard[i][j] = 1;
                    j++;
                }
            }
        }

        for (int i = 0; i < sudokuBoard.length; i++) {
            for (int j = 0; j < sudokuBoard.length; j++){
                System.out.print(sudokuBoard[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static boolean isSafe(int[][] board, int row, int col, int colNumber){

        for (int i = 0; i < board.length; i++){
            if (board[i][col] == colNumber){
                return false;
            }
        }

        for (int j = 0; j < board.length; j++){
            if (board[row][j] == colNumber){
                return false;
            }
        }

        return true;
    }

}

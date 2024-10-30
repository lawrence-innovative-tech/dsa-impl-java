package com.data.structure.example.backtracking;

public class OwnNQueenProblem {

    public static void main(String[] args) {
        int n = 4;
        int backTrackCount = 0, placedQueenCount = 0;
        int[] placedQueen = new int[n];
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isSafe(board, i, j)) {
                    board[i][j] = 'Q';
                    placedQueen[i] = j;
                    placedQueenCount++;
                    backTrackCount = 0;
                    break;
                } else {
                    backTrackCount++;
                }

                if (backTrackCount == n) {
                    --i;

                    for (int k = i; k >= 0 ; k--) {
                        if (placedQueen[k] == n) {
                            board[k][n - 1] = '.';
                            placedQueen[k] = 0;
                        } else {
                            j = placedQueen[k];
                            board[k][j] = '.';
                            backTrackCount = j + 1;
                            i = k;
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'Q') {
                    System.out.print(board[i][j] + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }

    }

    public static boolean isSafe(char[][] board, int row, int col) {
        //  row check
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        //  col check
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

//        check left upper diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

//      check right upper diagonal
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

}

package com.kimi.leetfight.resolve_nqueens_51;

/**
 * Copyright (c) 2021 Kimi. All Rights Reserved
 *
 * @Date 2021/2/22 16:43
 * @Author Feng Yalong
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2021 Kimi. All Rights Reserved
 *
 * @Date 2021/2/22 14:29
 * @Author Feng Yalong
 */
public class SolutionOnlyOneResult {
    private static List<List<String>> result = new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        char[][] chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = '.';
            }
        }
        backtrack(result, chars, 0);
        return result;
    }

    private static boolean backtrack(List<List<String>> result, char[][] board, int row) {
        if (row == board.length) {
            result.add(format(board));
            return true;
        }

        int n = board.length;
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            if(backtrack(result, board, row + 1)) {
                return true;
            }
            board[row][col] = '.';
        }
        return false;
    }

    private static List<String> format(char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            list.add(new String(board[i]));
        }
        return list;
    }

    private static boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            if ('Q' == board[i][col]) {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if ('Q' == board[i][j]) {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if ('Q' == board[i][j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}

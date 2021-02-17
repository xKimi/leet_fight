package com.kimi.leetfight.search_matrix;

/**
 * Created on 2021/2/18.
 * Copyright xKimi.inc
 *
 * @author Kimi
 */
public class Solution {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int height = 0;

        while (row >= 0 && height < matrix[0].length) {
            if (matrix[row][height] > target) {
                row--;
            } else if (matrix[row][height] < target) {
                height++;
            } else {
                return true;
            }
        }
        return false;
    }
}

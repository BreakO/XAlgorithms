package com.xbreak.bat.sort;

/**
 * 二维有序矩阵中查找	https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 * 
 * 思路 :二分法,
 * 		设置两个指针,从矩阵右上角开始查找,若比目标大,则减少列指针(删去最右一列), 若比目标小,则增加行指针(删去最上一列),指针越界
 * @author XBreak
 */
public class MatrixSearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        int N = matrix.length;  //row count;
        if(N == 0)
            return false;
        int M = matrix[0].length;  //column count;
        
        for(int i = 0,j = M-1; i < N && j >= 0; ){
            
                if(matrix[i][j] < target)
                    i++;
                else if(matrix[i][j] > target)
                    j--;
                else
                    return true;
            
        }
        return false;
        
    }
}

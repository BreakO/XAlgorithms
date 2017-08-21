package com.xbreak.bat.sort;

/**
 * ��ά��������в���	https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 * 
 * ˼· :���ַ�,
 * 		��������ָ��,�Ӿ������Ͻǿ�ʼ����,����Ŀ���,�������ָ��(ɾȥ����һ��), ����Ŀ��С,��������ָ��(ɾȥ����һ��),ָ��Խ��
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

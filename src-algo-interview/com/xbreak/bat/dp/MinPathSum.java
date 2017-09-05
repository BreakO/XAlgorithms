package com.xbreak.bat.dp;

import org.junit.Test;

/**
 * @author XBreak
 *  矩阵最短路径和		https://leetcode.com/problems/minimum-path-sum/description/
 *  有一个矩阵map，它每个格子有一个权值。从左上角的格子开始每次只能向右或者向下走，最后到达右下角的位置，
 *  路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
       给定一个矩阵map及它的行数n和列数m，请返回最小路径和。
 */
public class MinPathSum {
	  public int minPathSum1(int[][] grid) {
		  if(grid == null || grid.length == 0)
			  return 0;
	      return violence(grid, grid.length-1, grid[0].length-1);  
	  }
	  int [][]table;
	  public int minPathSum2(int[][] grid) {
		  if(grid == null || grid.length == 0)
			  return 0;
		  table = new int[grid.length][grid[0].length];
	      return remenber(grid, grid.length-1, grid[0].length-1);  
	  }
	  public int minPathSum3(int[][] grid) {
		  if(grid == null || grid.length == 0)
			  return 0;  
		  int N = grid.length, M = grid[0].length;
		  int [][] dp = new int[N][M];
		  for(int i=0; i < N ; i++)
			  for(int j=0; j < M; j++)
				  if(i == 0 && j == 0)
					  dp[i][j] = grid[0][0];
				  else if(i == 0 )
					  dp[i][j] = dp[i][j-1] + grid[i][j];
				  else if(j == 0 )
					  dp[i][j] = dp[i-1][j] + grid[i][j];
				  else
					  dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
		  
		  return dp[N-1][M-1];
	  }
	 /**
	 * path[i][j] = min(path[i-1][j], path[i][j-1])+arr[i][j]
	 * path[0][0] = arr[0][0]
	 * path[0][i] = arr[0][i]+path[0][i-1];
	 * path[i][0] = arr[i][0]+path[i-1][0];
	 * @param arr
	 * @return
	 */
	  public int violence(int[][] arr, int i, int j) {
		  if(i == 0 && j == 0)
			  return arr[0][0];
		  else if(i == 0)
			  return violence(arr,0,j-1)+arr[i][j];
		  else if(j == 0)
			  return violence(arr,i-1,0)+arr[i][j];
		 
		  return Math.min(violence(arr, i-1,j),violence(arr, i, j-1))+arr[i][j];
	  }
	  public int remenber(int[][] arr, int i, int j) {
		  if(table[i][j] != 0)
			  return table[i][j];
		  if(i == 0 && j == 0)
			  return arr[0][0];
		  else if(i == 0)
			  return remenber(arr,0,j-1)+arr[i][j];
		  else if(j == 0)
			  return remenber(arr,i-1,0)+arr[i][j];
		  table[i][j] = Math.min(remenber(arr, i-1,j),remenber(arr, i, j-1))+arr[i][j];
		  return table[i][j];
	  }
	  @Test
	  public void test1() {
		  int [][]arr = {{1,1},{1,2}};
		  System.out.println(minPathSum1(arr));;
	  }
	  @Test
	  public void test2() {
		  int [][]arr = {{1,1},{1,2}};
		  System.out.println(minPathSum2(arr));;
	  }
	  @Test
	  public void test3() {
		  int [][]arr = {{1,1},{1,2}};
		  System.out.println(minPathSum3(arr));;
	  }
}

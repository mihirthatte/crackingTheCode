/* 
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. 
 * Grid cells are connected horizontally/vertically (not diagonally). 
 * The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). 
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island). 
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 *Example - 
 [[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]
 Output - 16
 */

package test;
import java.util.*;
public class island_Permeter {
	
	static int findPerimeter(int grid[][], int row, int col, boolean visited[][]){
		int left, top, right, bottom;
		left = top = right = bottom = 0;
		if(row < 0 || row >= grid.length) return 1;
		if (col < 0 || col >= grid[0].length) return 1;
		if(visited[row][col]) return 0;
		if (grid[row][col] == 0) return 1;
		else {
			visited[row][col] = true;
			left = findPerimeter(grid, row, col-1,visited);
			top = findPerimeter(grid, row-1, col, visited);
			right = findPerimeter(grid, row, col+1, visited);
			bottom = findPerimeter(grid, row+1, col, visited);
			
		}
		return (left + top + right + bottom);
	}
	
	
	static int island(int grid[][]){
		int perimeter = 0;
		boolean visited[][] =  new boolean[grid.length][grid[0].length];
		for(int i =0; i <grid.length; i++)
			for(int j =0; j<grid[0].length;j++)
				if (grid[i][j] ==1){
					perimeter = findPerimeter(grid, i,j,visited);
					return perimeter;
				}
		return perimeter;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = { {0,1,0,0},
						 {1,1,1,0},
						 {0,1,0,0},
						 {1,1,0,0}
						};
		System.out.println(island(grid));
	}

}


/* Non recursive O(n^2) Solution - 
 public  int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    if (i > 0 && grid[i-1][j] == 1) result -= 2;
                    if (j > 0 && grid[i][j-1] == 1) result -= 2;
                }
            }
        }
        return result;
    }
 */ 

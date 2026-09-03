/*Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'. */

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int islands = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(grid[i][j] == '1'){
                    
                    islands++;
                    q.offer(new int[]{i, j});
                    grid[i][j] = '0';

                    while(!q.isEmpty()){
                        int[] cell = q.poll();

                        int r = cell[0];
                        int c = cell[1];

                        // Up
                        if(r-1 >= 0 && grid[r-1][c] == '1'){
                            q.offer(new int[]{r-1, c});
                            grid[r-1][c] = '0';
                        }

                        // Down
                        if(r+1 < m && grid[r+1][c] == '1'){
                            q.offer(new int[]{r+1, c});
                            grid[r+1][c] = '0';
                        }

                        // Right
                        if(c+1 < n && grid[r][c+1] == '1'){
                            q.offer(new int[]{r, c+1});
                            grid[r][c+1] = '0';
                        }

                        // Left
                        if(c-1 >= 0 && grid[r][c-1] == '1'){
                            q.offer(new int[]{r, c-1});
                            grid[r][c-1] = '0';
                        }
                    }
                }
            }
        }
        return islands;
    }
}
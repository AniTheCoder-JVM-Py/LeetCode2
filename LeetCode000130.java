/*You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

    Connect: A cell is connected to adjacent cells horizontally or vertically.
    Region: To form a region connect every 'O' cell.
    Surround: A region is surrounded if none of the 'O' cells in that region are on the edge of the board. Such regions are completely enclosed by 'X' cells.

To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.

 

Example 1:

Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

Explanation:

In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

Example 2:

Input: board = [["X"]]

Output: [["X"]]

 

Constraints:

    m == board.length
    n == board[i].length
    1 <= m, n <= 200
    board[i][j] is 'X' or 'O'.*/

class Solution {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};  // used for clear movement from top to bottom and left to right

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Left & Right Borders
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O')
                dfs(board, i, 0);
            if(board[i][n-1] == 'O')
                dfs(board, i, n-1);
        }

        // Top & Bottom Borders
        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O')
                dfs(board, 0, j);
            if(board[m-1][j] == 'O')
                dfs(board, m-1, j);
        }

        // Flip the surrounding
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == 'T')
                    board[i][j] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int r, int c){
        int m = board.length;
        int n = board[0].length;

        if(r<0 || c<0 || r>=m || c>=n)
            return;             // base case
        
        if(board[r][c] != 'O')
            return;
        
        board[r][c] = 'T';

        for(int[] d : dir)
            dfs(board, r+d[0], c+d[1]);
    }
}
/*Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example 1:
Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]

Example 2:
Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
 

Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique. */

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    TrieNode root = new TrieNode();

    int m, n;

    public List<String> findWords(char[][] board, String[] words) {

        List<String> result = new ArrayList<>();

        // Build Trie
        for (String word : words) {
            insert(word);
        }

        m = board.length;
        n = board[0].length;

        // Start DFS from every cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    private void insert(String word) {

        TrieNode curr = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.word = word;
    }

    private void dfs(char[][] board,
                     int row,
                     int col,
                     TrieNode node,
                     List<String> result) {

        // Out of bounds
        if (row < 0 || row >= m ||
            col < 0 || col >= n) {
            return;
        }

        char ch = board[row][col];

        // Already visited
        if (ch == '#') {
            return;
        }

        // Character doesn't exist in Trie
        TrieNode next = node.children[ch - 'a'];

        if (next == null) {
            return;
        }

        // Word found
        if (next.word != null) {
            result.add(next.word);

            // Avoid adding same word again
            next.word = null;
        }

        // Mark visited
        board[row][col] = '#';

        // Up
        dfs(board, row - 1, col, next, result);

        // Down
        dfs(board, row + 1, col, next, result);

        // Left
        dfs(board, row, col - 1, next, result);

        // Right
        dfs(board, row, col + 1, next, result);

        // Backtrack
        board[row][col] = ch;
    }
}
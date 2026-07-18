/*Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]

Example 3:

Input: root = []
Output: []

 

Constraints:

    The number of nodes in the tree is in the range [0, 2000].
    -1000 <= Node.val <= 1000*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // Algorithm
 // Step -1 = Initialize a queue of treenode
 // Step-2 = Add the root to the queue
 // Step-3 = while q is not empty remove the front element from the queue
 // Step-4 = Add the removed element in the level array you made to store the same level
 // Step-5 = Add the left child and the right child in the queue if exists and repeat
 
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null)
            return new ArrayList<>();
            
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        q.offer(root);
        int currLevel = 0;

        while(!q.isEmpty()){
            int len = q.size();
            res.add(new ArrayList<>());

            for(int i = 0; i < len; i++){
                TreeNode node = q.poll();
                res.get(currLevel).add(node.val);

                if(node.left != null){
                    q.offer(node.left);
                }
                
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            currLevel++;
        }
        return res;
    }
}
/*Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

 

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: 2

Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5

 

Constraints:

    The number of nodes in the tree is in the range [0, 105].
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

 /*     if(root == null)
            return 0;
        
        // If Left Subtree Doesn't Exists
        if(root.left == null)
            return 1 + minDepth(root.right);
        
        // If Right Subtree Doesn't Exists
        if(root.right == null)
            return 1 + minDepth(root.left);
        
        // If Both Subtrees Exixts
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));*/

// Level Order Traversal Algorithm
class Solution {
    public int minDepth(TreeNode root) {

        if(root == null)
            return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        int depth = 1;

        q.offer(root);

        while(!q.isEmpty()){
            int len = q.size();

            for(int i = 0; i < len; i++){
                TreeNode node = q.poll();

                //First Leaf Found, then End the code
                if(node.left == null && node.right == null)
                    return depth;
                
                // If left child exists then add to the queue
                if(node.left != null)
                    q.offer(node.left);
                
                // If right child exists then add it to the queue
                if(node.right != null)
                    q.offer(node.right);
            }
            depth++;
        }
        return depth;
    }
}
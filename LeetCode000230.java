/*Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 
Constraints:
The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104*/

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
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        int count = 0;
        while(curr != null){
            if(curr.left == null){
                count++;
                if(count == k)
                    return curr.val;
                curr = curr.right;
            }
            else{
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr)
                    prev = prev.right;
                
                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    count++;
                    if(count == k)
                        return curr.val;
                    curr = curr.right;
                }
            }
        }
        return -1;
    }
}
/*Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

<<<<<<< HEAD
 

Example 1:

Input: root = [1,2,3,null,5,null,4]

Output: [1,3,4]

Explanation:



Example 2:

Input: root = [1,2,3,4,null,null,null,5]

Output: [1,3,4,5]

Explanation:



Example 3:

Input: root = [1,null,3]

Output: [1,3]

Example 4:

Input: root = []

Output: []

 

Constraints:

=======
Example 1:
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
Explanation:

Example 2:
Input: root = [1,2,3,4,null,null,null,5]
Output: [1,3,4,5]
Explanation:

Example 3:
Input: root = [1,null,3]
Output: [1,3]

Example 4:
Input: root = []
Output: []

Constraints:
>>>>>>> 4410a5d852c9acf6d4b241186a7abe824ca3f1a5
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100 */

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
    public List<Integer> rightSideView(TreeNode root) {

        if(root == null)
            return new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        List<Integer> res = new ArrayList<>();

        while(!q.isEmpty()){
            int len = q.size();

            for(int i = 0; i < len; i++){
                TreeNode curr = q.poll();

                if(curr.left != null)
                    q.offer(curr.left);
                
                if(curr.right != null)
                    q.offer(curr.right);
                
                if(i == len-1)
                    res.add(curr.val);
            }
        }
        return res;
    }
}
/*Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Example 1:
Input: head = [1,2,2,1]
Output: true

Example 2:
Input: head = [1,2]
Output: false
 
Constraints:
The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Find middle
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse the Second Half
        ListNode prev = null;
        ListNode curr = slow;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // Check the palindrome
        ListNode left = head;
        ListNode right = prev;

        while(right != null){
            if(left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
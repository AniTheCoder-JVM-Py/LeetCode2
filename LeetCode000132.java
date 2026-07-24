/*Given a string s, partition s such that every substring of the partition is a palindrome

Return the minimum cuts needed for a palindrome partitioning of s.

Example 1:

Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

Example 2:

Input: s = "a"
Output: 0

Example 3:

Input: s = "ab"
Output: 1

 

Constraints:

    1 <= s.length <= 2000
    s consists of lowercase English letters only.*/

class Solution {
    public int minCut(String s) {
        int n = s.length();
        return partition(s, 0, n) - 1;
    }

    public int partition(String s, int i, int n){
        //base case
        if(i == n)
            return 0;
        
        int minCount = Integer.MAX_VALUE;
        for(int j = i; j < n; j++){
           if(isPalindrome(s, i, j)){
                int count = 1 + partition(s, j+1, n);
                minCount = Math.min(minCount, count);
            }
        }
        return minCount;
    }

    public boolean isPalindrome(String s, int left, int right){

        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
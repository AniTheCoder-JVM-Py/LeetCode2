/*Given a string s, partition s such that every of the partition is a

. Return all possible palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:

Input: s = "a"
Output: [["a"]]

 

Constraints:

    1 <= s.length <= 16
    s contains only lowercase English letters.*/

class Solution {

    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<>());
        return ans;
    }

    public void backtrack(String s, int start, List<String> path){
        //base case
        if(start == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int end = start; end < s.length(); end++){

            if(isPalindrome(s, start, end)){
                path.add(s.substring(start, end+1));
                backtrack(s, end+1, path);
                path.remove(path.size() - 1);
            }
        }
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
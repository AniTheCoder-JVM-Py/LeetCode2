/*You are given a string s. You can convert s to a palindrome by adding characters in front of it.

Return the shortest palindrome you can find by performing this transformation.

Example 1:
Input: s = "aacecaaa"
Output: "aaacecaaa"

Example 2:
Input: s = "abcd"
Output: "dcbabcd"
 
Constraints:
0 <= s.length <= 5 * 104
s consists of lowercase English letters only. */

// KMP Algorithm (Knutt-Morris-Pratt)
// It is a string pattern matching algorithm used to find whether a pattern exists inside a larger string.
class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s)
                    .reverse()
                    .toString();
        String combined = s + "#" + rev;

        int i = 1;
        int len = 0;
        int[] lps = new int[combined.length()];

        // Finding length of longest palindromic prefix(lps)
        while(i < combined.length()){
            if(combined.charAt(i) == combined.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len != 0){
                    len = lps[len - 1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }

        int longestPalindrome = lps[combined.length() - 1];
        String remaining = s.substring(longestPalindrome);

        String add = new StringBuilder(remaining)
                    .reverse()
                    .toString();
        return add + s;
    }
}
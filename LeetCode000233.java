/*Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

Example 1:
Input: n = 13
Output: 6

Example 2:
Input: n = 0
Output: 0
 
Constraints:
0 <= n <= 109 */

class Solution {
    public int countDigitOne(int n) {
        int count = 0;

        for(long place = 1; place <= n; place *= 10){
            long high = n / (place * 10);
            long cur = (n / place) % 10;
            long low = n % place;

            if(cur == 0)
                count += high * place;
            else if(cur == 1)
                count += high * place + low + 1;
            else
                count += (high + 1) * place;
        }
        return count;
    }
}
/*Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
If the fractional part is repeating, enclose the repeating part in parentheses
If multiple answers are possible, return any of them.
It is guaranteed that the length of the answer string is less than 104 for all the given inputs.
Note that if the fraction can be represented as a finite length string, you must return it.

Example 1:
Input: numerator = 1, denominator = 2
Output: "0.5"

Example 2:
Input: numerator = 2, denominator = 1
Output: "2"

Example 3:
Input: numerator = 4, denominator = 333
Output: "0.(012)"

Constraints:
    -231 <= numerator, denominator <= 231 - 1
    denominator != 0*/

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        
        if(numerator == 0)
            return "0";
        
        StringBuilder ans = new StringBuilder();
        
        // Handle sign
        if((numerator < 0) ^ (denominator < 0))
            ans.append("-");
        
        // Converted to long to ensure no overflow
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        ans.append(num / den);
        long rem = num % den;

        if(rem == 0)
            return ans.toString();
        
        ans.append(".");
        HashMap<Long, Integer> map = new HashMap<>();

        while(rem != 0){

            if(map.containsKey(rem)){
                ans.insert(map.get(rem), "(");
                ans.append(")");
                break;
            }

            map.put(rem, ans.length());
            rem*=10;
            ans.append(rem / den);
            rem%=den;
        }
        return ans.toString();
    }
}
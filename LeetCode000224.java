/*Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

Example 1:
Input: s = "1 + 1"
Output: 2

Example 2:
Input: s = " 2-1 + 2 "
Output: 3

Example 3:
Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
 
Constraints:
1 <= s.length <= 3 * 105
s consists of digits, '+', '-', '(', ')', and ' '.
s represents a valid expression.
'+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
'-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
There will be no two consecutive operators in the input.
Every number and running calculation will fit in a signed 32-bit integer. */

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int num = 0;
        int sign = 1;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            // Build Number
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }
            // Addition
            else if(ch == '+'){
                result += sign * num;
                num = 0;
                sign = 1;
            }
            // Subtraction
            else if(ch == '-'){
                result += sign * num;
                num = 0;
                sign = -1;
            }
            else if(ch == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
            else if(ch == ')'){
                result += sign * num;
                num = 0;
                //Previous Sign
                result *= stack.pop();
                // Previous result
                result += stack.pop();
            }
        }
        // Last Number
        result += sign * num;
        return result;
    }
}
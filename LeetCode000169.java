/*Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2

Constraints:
    n == nums.length
    1 <= n <= 5 * 104
    -109 <= nums[i] <= 109
    The input is generated such that a majority element will exist in the array.*/

// Boyer-Moore Voting Algorithm
/*
Algorithm.
1.Initialize:candidate = 0, count = 0
2.Traverse the array:If count == 0, set candidate = num.
3.If num == candidate, increment count.Else, decrement count.
4.Return candidate.*/

class Solution {
    public int majorityElement(int[] nums) {
        
        int candidate = 0;
        int count = 0;

        for(int num : nums){
            if(count == 0)
                candidate = num;
            
            if(num == candidate)
                count++;
            else
                count--;
        }
        return candidate;
    }
}
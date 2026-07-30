/*Given an integer array nums, return the maximum difference between two successive elements in its sorted form.
If the array contains less than two elements, return 0.
You must write an algorithm that runs in linear time and uses linear extra space.

Example 1:
Input: nums = [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.

Example 2:
Input: nums = [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.

Constraints:
    1 <= nums.length <= 105
    0 <= nums[i] <= 109*/

// Pigeonhole Algorithm
/*
If n < 2, return 0.
Find global min and max.
Create buckets.
Put every number into its bucket.
Traverse buckets.
Gap = currentBucket.min − previousBucket.max.
Return maximum gap.
*/

class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;

        if(n < 2)
            return 0;
        
        // Finding Maximum and Minimum Element of the Array
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if(min == max)
            return 0;

        int bucketSize = Math.max(1, (max - min)/(n-1));
        int bucketCount = (max - min)/bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        boolean[] used = new boolean[bucketCount];

        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        for(int num : nums){
            int index = (num - min) / bucketSize;

            bucketMax[index] = Math.max(bucketMax[index], num);
            bucketMin[index] = Math.min(bucketMin[index], num);
            used[index] = true;
        }

        int maxGap = 0;
        int prevMax = min;

        for(int i = 0; i < bucketCount; i++){
            if(!used[i])
                continue;
            
            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }
        return maxGap;
    }
}
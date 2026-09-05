/*An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number.

 

Example 1:

Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
Example 2:

Input: n = 1
Output: 1
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 

Constraints:

1 <= n <= 1690 */

class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();

        pq.add(1L);
        set.add(1L);

        long ugly = 0L;
        for(int i = 1; i <= n; i++){
            ugly = pq.poll();

            long a = ugly * 2;
            long b = ugly * 3;
            long c = ugly * 5;

            if(set.add(a))
                pq.add(a);
            if(set.add(b))
                pq.add(b);
            if(set.add(c))
                pq.add(c);
        }
        return (int)ugly;
    }
}
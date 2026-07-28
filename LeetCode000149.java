/*Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

Example 1:
Input: points = [[1,1],[2,2],[3,3]]
Output: 3

Example 2:
Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4

Constraints:

    1 <= points.length <= 300
    points[i].length == 2
    -104 <= xi, yi <= 104
    All the points are unique.*/

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;

        if( n <= 2)
            return n;

        int ans = 2;

        for(int i = 0; i < n; i++){
            HashMap<String, Integer> map = new HashMap<>();
            int duplicates = 1;

            for(int j = i+1; j < n; j++){
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if(dx == 0 && dy == 0){
                    duplicates++;
                    continue;
                }

                int g = gcd(dx, dy);
                dx = dx/g;
                dy = dy/g;
                
                // Normalize sign
                if(dx < 0){
                    dx = -dx;
                    dy = -dy;
                } else if(dx == 0){
                    dy = 1;
                } else if(dy == 0){
                    dx = 1;}

                String slope = dy+"/"+dx;
                map.put(slope, map.getOrDefault(slope, 0) + 1);
            }
            int max = 0;
            for(int count : map.values()){
                max = Math.max(max, count);
            }
            ans = Math.max(ans, max+duplicates);
        }
        return ans;
    }

    public int gcd(int a, int b){
        if(b == 0)
            return Math.abs(a);
        
        return gcd(b, a%b);
    }
}
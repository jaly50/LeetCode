/**
 587. Erect the Fence
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public List<Point> outerTrees(Point[] points) {
        // Get the leftest point
        int n = points.length;
        List<Point> ans = new ArrayList<Point>();
        if (n<=3) {
            for (Point p: points) ans.add(p);
            return ans;
        }
        Point start = points[0];
        int start_idx = 0;
        for (int i=0; i<n; i++)
            if (points[i].x < start.x) {
                start = points[i];
                start_idx = i;
            }
        ans.add(start);
        int first_idx = start_idx;
        do {
            Point next = points[0];
            int next_idx = 0;
            // Get next point in clockwise order
            for (int i=1; i<n; i++) {
                Point cur = points[i];
                if (cur==start || cur==next) continue;
                //向量积。
                int cross = crossProduct(cur, start, next);
                // 通过cross>0  or cross<0 来判断两条线段之间的关系 Awesome
                if (cross > 0 || (cross ==0 && distance(start, cur) > distance(start, next))) {
                    next = cur;
                    next_idx = i;
                }
            }
            
            // Add all points in the same line
            for (int i=0; i<n; i++) {
                if (i == next_idx || i==start_idx) continue;
                int cross = crossProduct(next, start, points[i]);
                if (cross==0) ans.add(points[i]);
            }
            if (next_idx != first_idx) ans.add(next);
            start = next;
            start_idx = next_idx;
        } while (start_idx != first_idx);
        return ans;
    }
    public int distance(Point a, Point b) {
        return (b.x - a.x)*(b.x - a.x) + (b.y - a.y) * (b.y - a.y);
    }
    public int crossProduct(Point a, Point b, Point c) {
        int bax = a.x - b.x;
        int bay = a.y - b.y;
        int bcx = c.x - b.x;
        int bcy = c.y - b.y;
        return bax * bcy - bcx*bay;
    }
}

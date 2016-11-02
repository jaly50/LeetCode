/*
 * 278. First Bad Version
 * 4:23 9/20/2016 
 * Reference: False
 * Thoughts: Binary search
 * 边界值要注意
 */
package leetcode;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int l = 1, h= n;
        int mid=l;
        int key = l;
        // h is inclusive, so remember to include the h.
        while (l<=h) {
            mid = l + (h-l)/2;
//            if (isBadVersion(mid)) {h = mid-1;  key = mid;}
//            else l = mid+1;
        }
        return key;
    }

}

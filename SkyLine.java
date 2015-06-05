/*
Scarlett Chen
 6/5/2015 Fri 1:47 am
 Sky Line
 Using priority Queue to maintain Height-top queue.
*/
public class Solution {
   class Point implements Comparable<Point>{
        int x;
        int y;
		public Point(int i, int j) {
			this.x = i;
			this.y =j;
		}
		@Override
		//To define which would be on the top of the priority queue, in this case, the higher one would be on the top
		public int compareTo(Point that) {
			return that.y - this.y;
		}
    }
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> skyline = new ArrayList<int[]>();
        PriorityQueue<Point>  pq = new PriorityQueue<Point>();
        int i=0;
        int x = 0, height=0;
        int n = buildings.length;
        while (i<n || !pq.isEmpty()) {
            //New buildings in || left upper corner
            if (pq.isEmpty() || (i<n && pq.peek().x>= buildings[i][0]) ) {
                x = buildings[i][0];
                // Add buildings with the same x(left) value in to the queue
                while (i<n && buildings[i][0] ==x) {
                    pq.add(new Point(buildings[i][1], buildings[i][2]));
                    i++;
                }
            }
            // right upper corner
            else {
            	//pq.peek() to look up for the highest building point
                x = pq.peek().x;
                // pq.peek().y would always smaller than x's y; so we only compare xs
                while (!pq.isEmpty() && pq.peek().x<=x) {
                    pq.poll();
                    }
                
            }
            if (pq.isEmpty()) {
                height = 0;
            }
            else
            height =pq.peek().y;
            int len = skyline.size();
            if (len==0 || height!=skyline.get(len-1)[1]) {
                skyline.add(new int[]{x,height});
            }
        }
      return skyline;  
    }
}

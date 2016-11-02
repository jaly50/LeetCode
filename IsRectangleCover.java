/*
 * Scarlett Chen
 * 10/24/2016 Mon 10:09
 * 391. Perfect Rectangle
 * To check whether it is all covered,
 * Except the four corners, other should be even
 * 总面积需要相等
 */
public class IsRectangleCover {
    public boolean isRectangleCover(int[][] rectangles) {
        int x1, x2, y1, y2;
        String c1,c2,c3,c4;
        x2 = Integer.MIN_VALUE;
        y2 = Integer.MIN_VALUE;
        x1 = Integer.MAX_VALUE;
        y1 = Integer.MAX_VALUE;
        Set<String> corners = new HashSet<String>();
        long area = 0;
        
        for (int[] rect: rectangles) {
             x1 = Math.min(x1, rect[0]);
             y1 = Math.min(y1, rect[1]);
             x2 = Math.max(x2, rect[2]);
             y2 = Math.max(y2, rect[3]);
             
             c1 = rect[0]+","+rect[1];
             c2 = rect[0] + "," + rect[3];
             c3 = rect[2] + "," + rect[1];
             c4 = rect[2] +","+ rect[3];
             
             area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
             
             if (corners.contains(c1)) corners.remove(c1);
             else corners.add(c1);
             
             if (corners.contains(c2)) corners.remove(c2);
             else corners.add(c2);
             
             if (corners.contains(c3)) corners.remove(c3);
             else corners.add(c3);
             
             if (corners.contains(c4)) corners.remove(c4);
             else corners.add(c4);
        }
        c1 = x1 +"," + y1;
        c2 = x1 + "," + y2;
        c3 = x2 + "," + y1;
        c4 = x2 + "," + y2; 
        if (corners.contains(c1)) corners.remove(c1);
        else return false;
         if (corners.contains(c2)) corners.remove(c2);
          else return false;
        if (corners.contains(c3)) corners.remove(c3);
         else return false;
        if (corners.contains(c4)) corners.remove(c4);
         else return false;
         
         return corners.isEmpty() && (area == (x2-x1) * (y2-y1));
        
        
    }

}


/*
* LeetCode Weekly Contest 31
* Scarlett Chen, Sat 7:43, Ranking 145
* 573. Squirrel Simulation
There's a tree, a squirrel, and several nuts. Positions are represented by the cells in a 2D grid. Your goal is to find the minimal distance for the squirrel to collect all the nuts and put them under the tree one by one. The squirrel can only take at most one nut at one time and can move in four directions - up, down, left and right, to the adjacent cell. The distance is represented by the number of moves.

Example 1:
Input: 
Height : 5
Width : 7
Tree position : [2,2]
Squirrel : [4,4]
Nuts : [[3,0], [2,5]]
Output: 12
Explanation:

Note:
All given positions won't overlap.
The squirrel can take at most one nut at one time.
The given positions of nuts have no order.
Height and width are positive integers. 3 <= height * width <= 10,000.
The given positions contain at least one nut, only one tree and one squirrel.

*
*/
public class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int num_nuts = nuts.length;
        // distance from squirrel to nuts
        int minV = Integer.MAX_VALUE;
        int id = 0;
        int sum = 0;
        for (int[] point: nuts) {
            int squir_nuts = Math.abs(point[0]-squirrel[0]) + Math.abs(point[1] - squirrel[1]);
            int tree_nuts = Math.abs(point[0] - tree[0]) + Math.abs(point[1] - tree[1]);
            minV = Math.min(minV, squir_nuts - tree_nuts);
            sum += tree_nuts;
        }
        return sum*2 + minV;
        
    }
}

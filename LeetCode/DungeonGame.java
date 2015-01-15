import java.util.Arrays;

/*
 * LeetCode 165 Dungeon Game
 * 好酷。自己独立写出来了。
 * 活着 至少是1.
 * 
 */
public class DungeonGame {
	public static int calculateMinimumHP(int[][] dungeon) {
		// get the number of rows and cols
		int n = dungeon.length;
		if (n < 1)
			return 0;
		int m = dungeon[0].length;
		int[][] f = new int[n+1][m+1];
		// set as the least health
		Arrays.fill(f[n], Integer.MAX_VALUE);
		for (int i=0; i<n; i++)
			f[i][m] = Integer.MAX_VALUE;
		for (int i=n-1; i>=0; i--) {
			for (int j=m-1;j >=0; j--) {
				if (i==n-1 && j==m-1)
					f[i][j] =1-dungeon[i][j];
				else
				f[i][j] = Math.min(f[i+1][j], f[i][j+1])-dungeon[i][j];
				if (f[i][j] <1 ) f[i][j] = 1;
			}
		}
		
		return f[0][0];
	}

	/*
	 * 正序情况下，前面是最优的，选择了少体力，后面不一定够用！反而会加更多原始体力，因此不妨从后往前走
	 */
	public static int calculateMinimumHP1(int[][] dungeon) {
		// get the number of rows and cols
		int n = dungeon.length;
		if (n < 1)
			return 0;
		int m = dungeon[0].length;

		// rem[i][j] is the remaining hp from left top to [i][j], if the
		// initialhp is initial[i][j]
		int[][] rem = new int[n][m];
		int[][] initial = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0 && j == 0) {
					// the original hp at least should be 1
					initial[0][0] = Math.max(-dungeon[0][0], 0) + 1;
					rem[0][0] = dungeon[0][0] < 0 ? 1 : dungeon[0][0] + 1;
					continue;
				}
				int iHP = Integer.MAX_VALUE, jHP = Integer.MAX_VALUE;
				int iRem = 0, jRem = 0;
				// if the route comes from top
				if (i > 0) {
					iRem = rem[i - 1][j] + dungeon[i][j];
					iHP = initial[i - 1][j];
					if (iRem < 1) {
						iHP = initial[i - 1][j] - iRem + 1;
						iRem = 1;
					}
				}
				// if the route comes from left
				if (j > 0) {
					jRem = rem[i][j - 1] + dungeon[i][j];
					jHP = initial[i][j - 1];
					if (jRem < 1) {
						jHP = initial[i][j - 1] - jRem + 1;
						jRem = 1;
					}
				}
				if (jHP + jRem < iHP + iRem) {
					initial[i][j] = jHP;
					rem[i][j] = jRem;
				}
				// else
				// if (jHP ==iHP) {
				// initial[i][j] = jHP;
				// rem[i][j] = Math.max(jRem, iRem);
				// }
				else {
					initial[i][j] = iHP;
					rem[i][j] = iRem;
				}
			}
			System.out.println(Arrays.toString(rem[i]) + " "
					+ Arrays.toString(initial[i]));
		}

		return initial[n - 1][m - 1];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] dungeon = new int[][] { { 1, -3, 3 }, { 0, -2, 0 },
				{ -3, -3, -3 } };
		System.out.println(calculateMinimumHP(dungeon));
	}

}

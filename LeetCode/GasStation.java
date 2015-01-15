/*
 * LeetCode 63 Gas Station
 * date: 2014/10/8
 */
public class GasStation {
	private static int ans;
	
	/*
	 * Reference to other people's code:
	 * 简单到让人想哭！！！！
	 * 思路也很简单：
	 *   1. 判断能不能走， 总数>0就一定有可以走的路
	 *   2. 如果从A点开始走，到B点不能走。那么A-B之间的点到B以后都不可能走，所以从B+1点开始试吧
	 */
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		 if (gas.length <1) return -1;
		 int total = 0;
		 for (int i=0 ;i <gas.length; i++) {
			 gas[i] = gas[i] - cost[i];
			 total +=gas[i];
		 }
		 if (total < 0) return -1;
		 int len = gas.length;
		 if (len == 1) return gas[0]>=0? 0: -1;
		 int start = 0;
		 total = 0;
		 for (int i =0; i<len; i++) {
			 total = total + gas[i];
			 if (total < 0) {
			     start = i+1;
			     total = 0;
			 }
		 }
		 return start;
	}
	/*
	 * My solution 2: iterative--- Time Limit Exceeded
	 * time:o(n)
	 * thoughts: % is a good method to make circle
	 */
	 public static int canCompleteCircuit2(int[] gas, int[] cost) {
		 if (gas.length <1) return -1;
		 int total = 0;
		 for (int i=0 ;i <gas.length; i++) {
			 gas[i] = gas[i] - cost[i];
			 total +=gas[i];
		 }
		 if (total < 0) return -1;
		 int len = gas.length;
		 if (len == 1) return gas[0]>=0? 0: -1;
		 int start = -1;
		 for (int i=0; i<len; i++) {
			 total = 0;
			 start = i;
			 for (int j=0; j<len; j++) {
				total +=gas[(start + j) % len];
				if (total <0) break;
			 }
			 if (total >=0) break;
		 }
		 return start;
	 }
	
	/*
	 * My own solution: Time limit exceeded
	 * time: o(n^2)
	 * using resursive way, so space is also used much
	 * thought: one by one, dfs
	 */
	 public static int canCompleteCircuit1(int[] gas, int[] cost) {
		 int gasAmount;
		 ans = -1;
		 if (gas.length <1) return -1;
		 if (gas.length ==1) {
		     if (gas[0] >= cost[0]) return 0;
		     else return -1;
		 }
		 for (int i=0; i< gas.length; i++) {
			 gasAmount = gas[i] - cost[i];
			 if ((gasAmount >0) && (ans == -1))
				 dfs(i,i+1, gasAmount,gas,cost);
		 }
		 
		 return ans;
	    }
	private static void dfs(int startPoint, int curPoint, int gasAmount, int[] gas, int[] cost) {
		// TODO Auto-generated method stub
		if (ans != -1) return;
		if (curPoint == gas.length) {
			curPoint = 0;
		}
		 if (curPoint == startPoint) {
			 ans = curPoint;
			 return;
		 }
		gasAmount += gas[curPoint] - cost[curPoint];
		if (gasAmount >=0) {
			dfs(startPoint,curPoint+1,gasAmount,gas,cost);
		}
	}
	public static void main(String[] args) {
		int[] gas = new int[]{5,3};
		int[] cost = new int[]{4,4};
		System.out.println("It should be 0, it is "+canCompleteCircuit(gas,cost));
		System.out.println("It should be 1, it is "+canCompleteCircuit(new int[]{1,2},new int[]{2,1}));
      
	}

}

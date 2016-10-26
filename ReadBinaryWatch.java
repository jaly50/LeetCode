import java.util.ArrayList;
import java.util.List;

public class ReadBinaryWatch {
    private static int[] hours = new int[]{8,4,2,1};
    private static int[] minutes = new int[]{32,16,8,4,2,1};
    private void combination(int num, int total, int pos, int ele, int[] data, List<Integer> res) {


        if (num==0 && ele<=total) {

            res.add(ele);
            return;
        }
        // note:注意 pos是有可能等于data.length的，当我们combi最后一个值的时候，将经过上面的判断加入result
        if (num <0 || ele > total || pos >= data.length) return;
        if (ele +data[pos] <=total) combination(num-1, total, pos+1, ele+data[pos], data, res);
        combination(num, total, pos+1, ele, data, res);
    }
    public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<String>();

        for (int up=0; up<=Math.min(num, 3); up++) {
        List<Integer> up_list = new ArrayList<Integer>();
        List<Integer> down_list = new ArrayList<Integer>();
            int down = num - up;
            if (down > 5) continue;
            combination(up, 11, 0, 0, hours, up_list);
            combination(down, 59,0 ,0, minutes, down_list);
            for (int u: up_list) {
                for (int d: down_list) {
                    String s;
                    if (d<10) s=u+":0"+d;
                    else s = u+":"+d;
                    ans.add(s);
                }
            }
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadBinaryWatch rbw = new ReadBinaryWatch();
		rbw.readBinaryWatch(1);

	}

}

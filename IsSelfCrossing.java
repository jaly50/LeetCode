
public class IsSelfCrossing {
    public boolean isSelfCrossing(int[] x) {
        for (int i=3; i<x.length; i++) {
            if (x[i] >= x[i-2] && x[i-1] <= x[i-3]) return true;
            if (i>3 && x[i-1]==x[i-3] && x[i] + x[i-4] >=x[i-2] ) return true;
            if (i>4  && x[i-1] + x[i-5] >= x[i-3] && x[i-1] <= x[i-3] &&  x[i]+ x[i-4] >= x[i-2] && x[i-2] >=x[i-4]) return true;
            //System.out.println(i);
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsSelfCrossing is =new IsSelfCrossing();
		is.isSelfCrossing(new int[]{1,1,2,2,3,3,4,4,10,4,4,3,3,2,2,1,1});
	}

}

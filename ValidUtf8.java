// Sun 5:56 PM 11/13/2016 393. UTF-8 Validation
public class Solution {
    public int get_bytes(int ele) {
        // count how many one in the binary form
        String binary = Integer.toBinaryString(ele);
        if (binary.length() < 8) return 0;
        int idx = 0;
        while (idx < binary.length() && binary.charAt(idx)=='1') {
            idx++;
        }
        return idx;
    }
    public boolean validUtf8(int[] data) {
        int n = data.length;
        int cur = 0;
        while ( cur < n) {
            // to check x-byte for the integer
            int x = get_bytes(data[cur]);
            if (x==1) return false;
            //System.out.println("x :" + x);
            for (int i=cur+1; i<cur+x; i++) {
                if (i>=n) return false;
                String binary = Integer.toBinaryString(data[i]);
                //System.out.println(binary);
                if (!(binary.charAt(0)=='1' && binary.charAt(1)=='0') || binary.length() < 8) return false;
            }
            if (x>0) cur = cur + x;
            else cur++;
        }
        return true;
        
    }
}

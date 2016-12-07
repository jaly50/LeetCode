// 字符串处理题 要注意边界条件，如 [] [""]
// 用StringBuilder比String快
//https://discuss.leetcode.com/topic/22848/ac-java-solution 别人的解法更漂亮
public class Codec {
    String spliter = "spliter";
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder ans = new StringBuilder();
        for (String ele: strs) {
            ans.append(spliter).append(ele);
        }
        return ans.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ans = new ArrayList<String>();
        if (s.indexOf(spliter) <0) return ans;
        String[] array = s.split(spliter, -1);
        int start = 0;
        if (array.length > start && array[start].isEmpty()) start++;
        
        for (int i=start; i<array.length; i++) ans.add(array[i]);
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));

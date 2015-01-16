import java.util.ArrayList;
import java.util.List;

/*
 * LeetCode 111
 * Date: 11/06/2014 Thu 11:43 AM
 * 情况复杂，会考虑不足〜
 *  写了1小时ＱＡＱ
 * 字符串处理，本身并不难〜
 * Be careful: 一句话只有一个字符的情况呢？
 * 要熟悉字符串的api.
 * 
 */
public class FullJustify {
    public List<String> fullJustify(String[] words, int L) {
        List<String> sb = new ArrayList<String>();
        //pre
        StringBuffer extraSpace = new StringBuffer();
        for (int i=0; i<L; i++) extraSpace.append(" ");
        
        int count = 0, space = 0;
        StringBuffer line=new StringBuffer();
        for (String  word:words) {
        	// count is the current number in a line, if it appends a new word, it need extra 1 space and space of one word
            if (count+1+word.length() >L && count!=0) {
            	int diff = L - count;
                int pos = 0;
                if (space ==0) line.append(extraSpace.subSequence(0,diff));
            	while (diff!=0 && space !=0) {
            		pos = line.indexOf(" ", pos);
            		int len = diff % space==0? 0: 1; len+= diff / space;
            		line.insert(pos, extraSpace.subSequence(0, len));
            		pos = pos + len+1;
            		//System.out.println(line+"||and the pos||"+line.charAt(pos)+"|   "+pos);
            		diff -=len; space--;
            	}
            	count = 0;
            	space = 0;
            	sb.add(line.toString());
            	line = new StringBuffer();
            }
            else if (count!=0) {
            	line.append(" ");
            	count +=1;
            	space +=1;
            }
            line.append(word);
            count += word.length();
        }
        line.append(extraSpace.subSequence(0,L-line.length()));
        sb.add(line.toString());
        return sb;
      }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
       FullJustify fj = new FullJustify();
       String[] words = new String[] {"This", "is", "an", "example", "of", "text", "justification."};
       System.out.println(fj.fullJustify(words, 16));
       words = new String[]{"a"};
       System.out.println(fj.fullJustify(words, 1));
       words = new String[]{"Listen","to","many,","speak","to","a","few."};
       System.out.println(fj.fullJustify(words, 6));
	}

}

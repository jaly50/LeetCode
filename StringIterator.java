/**
604. Design Compressed String Iterator
Design and implement a data structure for a compressed string iterator. It should support the following operations: next and hasNext.

The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.

next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
hasNext() - Judge whether there is any letter needs to be uncompressed.

Example:

StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");

iterator.next(); // return 'L'
iterator.next(); // return 'e'
iterator.next(); // return 'e'
iterator.next(); // return 't'
iterator.next(); // return 'C'
iterator.next(); // return 'o'
iterator.next(); // return 'd'
iterator.hasNext(); // return true
iterator.next(); // return 'e'
iterator.hasNext(); // return false
iterator.next(); // return ' '

**/
public class StringIterator {
    String[] words;
    int index;
    int count;
    public StringIterator(String compressedString) {
        //\D	A non-digit: [^0-9], word and count
        words = compressedString.split("(?=\\D)");
        index = -1;
        count = 0;
       //System.out.println(Arrays.toString(words));
    }
    
    public char next() {
      // System.out.println(index+" count:"+count);
      if (!this.hasNext()) return ' ';
        if (count<=0) {
            String str_c =words[++index].substring(1);
            //System.out.println(str_c);
            count = Integer.parseInt(str_c);
        }
        char ch = words[index].charAt(0);
        count--;
        
        return ch;
    }
    
    public boolean hasNext() {
        return count > 0 || index < words.length - 1;
        
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

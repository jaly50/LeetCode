//This way will be overflow. And it uses 3 list. it is too much. We can deal with it using only one list.
public int nthUglyNumber(int n) {
        if (n==1) return 1;
        Queue<Integer> q2 = new LinkedList<Integer>();
        Queue<Integer> q3 = new LinkedList<Integer>();
        Queue<Integer> q5 = new LinkedList<Integer>();
        q2.add(2);
        q3.add(3);
        q5.add(5);
        int ele=1;
       int  count=1;
        while (count<n) {
            count++;
            int min = minIndex(q2,q3,q5);
            switch (min) {
                case 2:
                    ele=q2.remove();
                    q2.add(ele*2);
                     q3.add(ele*3);
                    q5.add(ele*5);
                    break;
                case 3:
                    ele=q3.remove();
                     q3.add(ele*3);
                     q5.add(ele*5);
                    break;
                case 5:
                    ele=q5.remove();
                    q5.add(ele*5);
                    break;
            }
            
        }
    return ele;
    }
    private int minIndex(Queue<Integer> q2, Queue<Integer> q3, Queue<Integer> q5) {
		int minindex=2; 
		int minele=q2.peek();
		if (q3.peek() < minele) {
			minindex = 3;
			minele = q3.peek();
		}
		if (q5.peek()< minele) {
			minindex= 5;
			minele= q5.peek();
		}
		return minindex;
		
	}


     // Better way. much more elegant. on space, on time.
      public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0]=1;
        int t2=0, t3=0, t5=0;
        for (int i=1; i<n; i++) {
            ugly[i] = Math.min(ugly[t2]*2, Math.min(ugly[t3]*3, ugly[t5]*5));
            if (ugly[i]== ugly[t2]*2) t2++;
            if (ugly[i]==ugly[t3]*3) t3++;
            if (ugly[i] == ugly[t5]*5) t5++;
        }
        return ugly[n-1];
    }

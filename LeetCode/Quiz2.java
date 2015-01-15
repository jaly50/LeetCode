public class Quiz2 {
	public static boolean isOdd(int x) {
		return x % 2 == 1;
	}
	
	public static void main(String[] args) {
		String dog = "Length: 10";
		String cat = "Length: " + dog.length();
		Object o1 = cat;
		
		System.out.println("Question 5: " + dog.equals(cat)); // true
		System.out.println(dog == cat);  //false (先算了加
		System.out.println("Question 7: " + o1.equals(cat));  //true
		System.out.println("Question 8: " + o1 == cat); //true --false  类型不一样，地址也不会一样。
		System.out.println("Question 9: " + cat.charAt(1)); //e
//		System.out.println("Question 10: " + o1.charAt(1));
		System.out.println("Question 11: " + 2 + 3 * 4); 
		System.out.println("Question 12: " + isOdd(1)); //true
		System.out.println("Question 13: " + isOdd(0));// false
		System.out.println("Question 14: " + isOdd(-1)); // －－－false
		
		System.out.println((-3) % 2);
		System.out.println((-3) / 2);
		
		System.out.println("The answer is " + 3 + (4 == 12)); //3false
	}
}
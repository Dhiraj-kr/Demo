package ds.string;

/*
 First non repeated character in the string 
If the word "stress" is input then it should print 't' as output.
If the word "teeter" is input then it should print 'r' as output.

 */
public class FirstNonRepeatingCh {

	public static void main(String[] args) {
		FirstNonRepeatingCh prog=new FirstNonRepeatingCh();
		
		String str="stress";
		char ch=prog.find(str);
		System.out.println(ch);
	}

	private char find(String str) {
		int[] chArr=new int[256];
		char[] strArr=str.toCharArray();
		for(char ch: strArr) {
			++chArr[ch];
		}
		for(char ch: strArr) {//We are iterating str
			if(chArr[ch]==1)
				return ch;
		}
		return Character.MIN_VALUE;
	}

}

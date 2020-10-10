package techgig;

public class MinPallindrome {

	public static void main(String[] args) {

		int val = findMinInsertions("ab3bd",5);
		System.out.println(val);
		val = findMinInsertions("ab3b",4);
		System.out.println(val);
		val = findMinInsertions("ab3bd".toCharArray(),0,4);
		System.out.println(val);
		val = findMinInsertions("ab3b".toCharArray(),0,3);
		System.out.println(val);
	}
	
	//Iterative
	public static int findMinInsertions(String input, int n)
	{
		char str[]=input.toCharArray();
		int[][] table = new int[n][n];
		int l;
		int h;
		int gap;
	 
	    // Fill the table
	    for (gap = 1; gap < n; ++gap)
	        for (l = 0, h = gap; h < n; ++l, ++h)
	            table[l][h] = (str[l] == str[h])? table[l+1][h-1] :
	                          (min(table[l][h-1], table[l+1][h]) + 1);

	    // Return minimum number of insertions for str[0..n-1]
	    return table[0][n-1];
	}
	
	//Recursive
	public static int findMinInsertions(char str[], int l, int h)
	{
	    // Base Cases
	    if (l > h) return -1;
	    if (l == h) return 0;
	    if (l == h - 1) return (str[l] == str[h])? 0 : 1;
	 
	    // Check if the first and last characters are same. On the basis of the
	    // comparison result, decide which subrpoblem(s) to call
	    return (str[l] == str[h])? findMinInsertions(str, l + 1, h - 1):
	                               (min(findMinInsertions(str, l, h - 1),
	                                   findMinInsertions(str, l + 1, h)) + 1);
	}
	
	public static int min(int a, int b)
	{  
		return a < b ? a : b; 
	}
	
}

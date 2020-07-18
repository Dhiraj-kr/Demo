package pattern;

public class Zigzag {
	
	//do using 2 d array i.e. matrix..first calculated number of columns

	//PAYPALISHIRING
	/* If No. of rows is 3
	 P   A   H   N
	 A P L S I I G
	 Y   I   R
	 
	 n=4
	 
	 P     I     N
	 A   L S   I G
	 Y A   H R
	 P     I
	 
	 n=5
	 
	 P       H       
	 A     S I     
	 Y   I   R   
	 P L     I G
	 A       N
	 
	 */
	
	public static final String SPACE=" ";
	public static final String DOUBLE_SPACE="  ";
	
	public static void main(String arg[]) {
		
		String str=arg[0];
		char[] arr=str.toCharArray();
		int n=Integer.parseInt(arg[1]);
		
		if(n==1) {
			System.out.println(str);
		}
		
		int numMiddleRows=n-2;
		int p=0;
		int q=0;
		int r=0;
		
		StringBuilder sb=new StringBuilder();
		
		//p is the index at which complete column values are printed. Its incremented by n+ middlerows in while loop to print complete columns 
		//r is used to print spaces before zig zag middle entries and also to print the actual mid entries with the help of q
		//q is used to actually print middle entries combining p and r and then (n-i)
		//Using i we print spaces after zig zag entries
		for(int i=0;i<n;i++) {
			
			p=i;
			r=Math.abs(numMiddleRows-i);
			
			while(p < arr.length) {
				System.out.print(arr[p]+SPACE);
				//Ignore sb for now
				sb.append(arr[p]);
	
				if(i==0 || i==n-1) {		//For 1st and last lines, character will be separated by equal spaces 
					for (int k = 0; k < numMiddleRows ;k++) {
						System.out.print(DOUBLE_SPACE);
					}
				}
				else {
						for(int k=0;k < r;k++) {
							System.out.print(DOUBLE_SPACE);
						}
						q = p+r+(n-i);
						if(q < arr.length) {
							System.out.print(arr[q]+SPACE);
							sb.append(arr[q]);
							
							for(int k=0;k<i-1;k++) {
								System.out.print(DOUBLE_SPACE);
							}
						}
				}
				p += n+numMiddleRows;
			}
			System.out.println();
		}
		System.out.println(sb.toString());
	}
}

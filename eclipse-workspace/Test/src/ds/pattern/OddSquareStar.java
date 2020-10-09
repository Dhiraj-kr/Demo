package ds.pattern;

public class OddSquareStar {

	/*
	 
	 *
	 
	 * * *
	 *   *
	 * * *
	 
	 * * * * *
	 *   *   *
	 * * *   *
	 *       *
	 * * * * *
	 
	 
	 * * * * * * *
	 *   *   *   *
	 * * *   *   *
	 *       *   *
	 * * * * *   *
	 *           *
	 * * * * * * *
	 
	 0 based index where * would not print
	 3	->	(11)
	 5	->  (11,13),(23),(31,32,33)
	 7	->  (11,13,15),(23,25),(31,32,33,35),(45),(51,52,53,54,55)
	 
	 1 based index where * would not print
	 3	->  22
	 5  ->  22,24,34,42,43,44
	 7  ->  22,24,26,34,36,42,43,44,46,55,61,62,63,64,65
	 
	 */
	
	private static char[][] matrix;
	
	static int n;
	
	public static void main(String[] args) {
		
		n=Integer.parseInt(args[0]);
		
		matrix=new char[n][n];
		
		for (int i = 0; i < n; i = i + 2) {
			matrix[i][i] = '*';
		}
		 
		for (int i = 1; i < n ; i++) {
			//Below 2 lines, print top and left boundary
			matrix[0][i] = '*';
			matrix[i][0] = '*';
			
			//Below 2 lines, print bottom and right boundary
			matrix[i][n - 1] = '*';
			matrix[n - 1][i] = '*';
		}
		//At end of above loop, outer boundary will be complete
		
		for (int i = 2; i < n - 2; i = i + 2) {
			for (int j = 1; j < i; j++) {
				matrix[i][j] = '*';
				matrix[j][i] = '*';
			}
		}
		
		printMatrix();
	}

	private static void printMatrix() {

		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}
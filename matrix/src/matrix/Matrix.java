package matrix;



public class Matrix {
	public static void swap1(int i, int j, int[][] matrix) {
		int n = matrix.length;
		int tmp = matrix[i][j];
		matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
		matrix[n - 1 - j][n - 1 - i] = tmp;
	}
	
	public static void swap2(int i, int j, int[][] matrix) {
		int n = matrix.length;
		int tmp = matrix[i][j];
		matrix[i][j] = matrix[n - 1 - i][j];
		matrix[n - 1 - i][j] = tmp;
	}
	
	public static int[][] ninetyDegrees(int[][] matrix) {
		if (matrix == null) {
			return null;
		}
		int n = matrix.length;
		int m = matrix.length;
		if (n != m) {
			return null;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				swap1(i, j, matrix);
			}
		}
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				swap2(i, j, matrix);
			}
		}
		return matrix;
	}
	
	public static void printMatrix(int[][] matrix) {
		if (matrix == null) {
			return;
		}
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		printMatrix(matrix);
		matrix = ninetyDegrees(matrix);
		System.out.println("");
		printMatrix(matrix);
	}
}

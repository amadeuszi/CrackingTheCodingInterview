import java.util.LinkedList;
import java.util.List;

public class Matrix {
	private boolean[] zeroedRows;
	private boolean[] zeroedColumns;
	private int[][] matrix;
	
	public Matrix(int[][] matrix) {
		if (matrix == null) {
			return;
		}
		if (matrix.length == 0) {
			return;
		}
		if (matrix.length != matrix[0].length) {
			return;
		}
		this.matrix = matrix;
		int n = matrix.length;
		zeroedColumns = new boolean[n];
		zeroedRows = new boolean[n];
	}
	
	private void zeroTheColumn(int x) {
		if (matrix == null || zeroedColumns == null) {
			return;
		}
		if (zeroedColumns[x] == true) {
			return;
		}

		for (int i = 0; i < matrix.length; i++) {
			matrix[i][x] = 0;
		}
		zeroedColumns[x] = true;
	}
	private void zeroTheRow(int x) {
		if (zeroedRows[x] == true || zeroedRows == null) {
			return;
		}
		if (matrix == null) {
			return;
		}
		
		for (int i = 0; i < matrix.length; i++) {
			matrix[x][i] = 0;
		}
		zeroedRows[x] = true;
	}
	public void zeroTheMatrix() {
		List<Integer> row = new LinkedList<>();
		List<Integer> column = new LinkedList<>();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] == 0) {
					column.add(i);
					row.add(j);
				}
			}
		}
		for (int x : column) {
			zeroTheColumn(x);
		}
		for (int x : row) {
			zeroTheRow(x);
		}
	}
	public String toString() {
		if (matrix == null) {
			return null;
		}
		StringBuilder builder = new StringBuilder(matrix.length * matrix.length * 2);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				builder.append(matrix[i][j] + " ");
			}
			builder.append("\n");
		}
		return builder.toString();
	}
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1,2,3},{2,0,1},{9,9,9}};
		Matrix m = new Matrix(matrix);
		System.out.println(" ");
		m.zeroTheMatrix();
		System.out.println(m);
		System.out.println(m);
	}
}
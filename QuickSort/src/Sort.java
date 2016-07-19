import java.util.Arrays;
import java.util.Random;

public class Sort {
	private static Random r = new Random();
	
	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	private static void quickSort(int[] a, int x, int y) {
		if (y - x < 1) {
			return;
		}

		int pivotPoint = r.nextInt(y - x + 1) + x;
		swap(a, y, pivotPoint);
		int pivot = a[y];
		
		int wall = x;
	
		for (int i = x; i < y; i++) {
			if (a[i] < pivot) {
				swap(a, i, wall);
				wall++;
			}
		}
		swap(a, y, wall);
		
		int middle = wall;
		quickSort(a, x, middle - 1);
		quickSort(a, middle + 1, y);
	}
	
	public static void sort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}
	
	public static void main(String[] args) {
		int[] test = new int[] {2, 3, 1, 6, 0, 122, 93, 11};
		Sort.sort(test);
		System.out.println(Arrays.toString(test));
	}
}

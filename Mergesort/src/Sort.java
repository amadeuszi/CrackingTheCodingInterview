import java.util.Arrays;

public class Sort {
	public static void sort(int[] array) {
		mergeSort(array);
	}
	
	private static void merge(int[] a, int[] left, int[] right) {
		int n = a.length;
		int ln = left.length;
		int rn = right.length;
		
		if (!(ln + rn == n)) {
			throw new RuntimeException();
		}
		
		int index = 0;
		int leftIndex = 0;
		int rightIndex = 0;
		
		while (leftIndex < ln && rightIndex < rn) {
			if (left[leftIndex] < right[rightIndex]) {
				a[index] = left[leftIndex];
				leftIndex++;
			}
			else {
				a[index] = right[rightIndex];
				rightIndex++;
			}
			index++;
		}
		
		while (leftIndex < ln) {
			a[index] = left[leftIndex];
			index++;
			leftIndex++;
		}
		
		while (rightIndex < rn) {
			a[index] = right[rightIndex];
			index++;
			rightIndex++;
		}
	}
	
	public static void mergeSort(int[] a) {
		int n = a.length;
		
		if (n < 2) {
			return;
		}
		
		int middle = n / 2;
		
		int[] left = new  int[middle];
		int[] right = new int[n - middle];
		
		for (int i = 0; i < middle; i++) {
			left[i] = a[i];
		}
		for (int i = middle; i < n; i++) {
			right[i - middle] = a[i];
		}
		
		mergeSort(left);
		mergeSort(right);
		
		merge(a, left, right);
	}
	
	public static void main(String[] args) {
		int[] a = new int[10];
		int[] b = new int[] {1, 2, 5, 10, 22};
		int[] c = new int[] {3, 5, 7, 11, 15};
		merge(a, b, c);
		System.out.println(Arrays.toString(a));
		
		int[] test = new int[] {4, 3, 10, 22, 11, 19, 122, 1};
		Sort.sort(test);
		System.out.println(Arrays.toString(test));
	}
}

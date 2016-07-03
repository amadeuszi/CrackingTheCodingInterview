import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicats {
	public static List<Integer> removeDup(List<Integer> l) {
		if (l == null) {
			return null;
		}
		List<Integer> result = new LinkedList<Integer>();
		
		for (int x : l) {
			if (!result.contains(x)) {
				result.add(x);
			}
		}
		return result;
	}
	
	public static List<Integer> removeDup2(List<Integer> l) {
		if (l == null) {
			return null;
		}
		List<Integer> result = new LinkedList<>();
		Set<Integer> occured = new TreeSet<>(); 
		for (int x : l) {
			if (!occured.contains(x)) {
				occured.add(x);
				result.add(x);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Integer[] tab = new Integer[]{1,2,3,1,1,1,5};
		System.out.println(Arrays.deepToString(removeDup(Arrays.asList(tab)).toArray()));
		System.out.println(Arrays.deepToString(removeDup2(Arrays.asList(tab)).toArray()));
	}
}

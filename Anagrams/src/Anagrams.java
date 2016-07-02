import java.util.ArrayList;
import java.util.List;

public class Anagrams {
	public static boolean isAnagram(String a, String b) {
		if (a == null || b == null) {
			return false;
		}
		
		if (a.length() != b.length()) {
			return false;
		}
		
		int n = 256;
		int[] numbers = new int[n];
		
		for (int i = 0; i < a.length(); i++) {
			numbers[a.charAt(i)]--;
			numbers[b.charAt(i)]++;
		}
		
		for (int x : numbers) {
			if (x != 0) {
				return false;
			}
		}
		return true;
	}
	
	public static String replaceSpaces(String s) {
		if (s == null) {
			return null;
		}
		
		int n = s.length();
		
		char[] helper = s.toCharArray();
		List<Character> result = new ArrayList<Character>();
		for (int i = 0; i < n; i++) {
			if (helper[i] == ' ') {
				result.add('%');
				result.add('2');
				result.add('0');
			}
			else {
				result.add(helper[i]);
			}
		}
		StringBuilder builder = new StringBuilder(result.size());
		for (char c : result) {
			builder.append(c);
		}
		return builder.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(isAnagram("kapitan", "napitka"));
		System.out.println(isAnagram("kot", "kot2"));
		System.out.println(isAnagram("kot", null));
		System.out.println(isAnagram("kot", "tok"));
		System.out.println(isAnagram("zzzzzero", "zzzzeroz"));
		System.out.println(isAnagram("amek", "kote"));
		
		System.out.println(replaceSpaces("Ala ma kota"));
		System.out.println(replaceSpaces("   "));
		System.out.println(replaceSpaces(""));
		System.out.println(replaceSpaces(null));
	}
}

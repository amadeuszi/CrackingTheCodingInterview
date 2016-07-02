import java.util.HashSet;
import java.util.Set;
public class UniqueChars {
	public static boolean isUnique(String s) {
		Set<Character> helper = new HashSet<>(256);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			c = Character.toLowerCase(c);
			if (helper.contains(c)) {
				return false;
			}
			else {
				helper.add(c);
			}
		}
		return true;
	}
		public static void main(String[] args) {
			System.out.println(isUnique("Miszcz"));
			System.out.println(isUnique("Miszer"));
		}
}
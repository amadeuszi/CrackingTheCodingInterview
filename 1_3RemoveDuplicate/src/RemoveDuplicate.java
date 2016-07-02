
public class RemoveDuplicate {
	public static String remove(String s) {
		if (s == null) {
			return null;
		}
		if (s.length() < 2) {
			return s;
		}
		char[] charArray = s.toCharArray();
		int tail = 1;
		int n = charArray.length;
		for (int i = 1; i < n; i++) {
			int j;
			for (j = 0; j < tail; j++) {
				if (charArray[j] == charArray[i]) {
					break;
				}
			}
			if (tail == j) {
				charArray[tail] = charArray[i];
				tail++;
			}
		}
		char[] result = new char[tail];
		for (int i = 0; i < tail; i++) {
			result[i] = charArray[i];
		}
		return new String(result);
	}
	public static void main(String[] args) {
		System.out.println(remove(null));
		System.out.println(remove("aaaa"));
		System.out.println(remove("ababa"));
		System.out.println(remove("aaabbb"));
		System.out.println(remove("asdeeef"));
		
	}
}

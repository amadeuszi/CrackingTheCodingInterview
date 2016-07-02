
public class ReverseString {
	public static String reverse(String s) {
		char[] charArray = s.toCharArray();
		int n = charArray.length;
		for (int i = 0; i < n / 2; i++) {
			char ch =  charArray[i];
			charArray[i] = charArray[n - i - 1];
			charArray[n - i - 1] = ch;
		}
		return new String(charArray);
	}
	public static void main(String[] args) {
		System.out.println(reverse("Amadeusz"));
	}
}

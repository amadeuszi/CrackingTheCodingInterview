
public class Tests {
	public static void main(String[] args) {
		List lista = new List();
		
		lista.add(5);
		lista.add(7);
		lista.add(-100);
		lista.add(411);
		System.out.println(lista);
		lista.remove(-100);
		System.out.println(lista);
	}
}


public class Tests {
	public static void main(String[] args) {
		List lista = new List();

		lista.addEnd(5);
		lista.addEnd(7);
		lista.addEnd(9);
		lista.addEnd(1);
		System.out.println(lista);
		
		List lista2 = new List();
		lista2.add(5);
		lista2.add(2);
		System.out.println(lista2);
		System.out.println(lista2.addInteger(lista));

	}
}

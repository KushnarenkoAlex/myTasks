import java.util.ArrayList;

public class A {

	public void name(ArrayList<String> a) {
		a.add("5");

	}

	public static void main(String g[]) {
		ArrayList<String> al = new ArrayList<>();
		al.add("4");
		new A().name(al);
		for (String string : al) {
			System.out.println(string);
		}
	}
}

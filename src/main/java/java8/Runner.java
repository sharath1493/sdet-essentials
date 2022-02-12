package java8;

public class Runner {

	public static void main(String[] args) {


		MyInterfaceWithGenerics<String, String, String> m = (a,b) -> a+b;

		System.out.println(m.logtoConsole("David ", "Warner"));
	}

}

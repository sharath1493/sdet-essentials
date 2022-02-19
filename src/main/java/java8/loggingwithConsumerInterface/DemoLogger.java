package java8.loggingwithConsumerInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class DemoLogger {

	private DemoLogger(){}


	private static Consumer<String> PASS = (p) -> System.out.println("Pass Test is "+p);
	private static Consumer<String> FAIL = (p) -> System.out.println("Test is "+p);
	private static Consumer<String> SKIP = (p) -> System.out.println("Test is "+p);

	private static Map<String, Consumer<String>> m=new HashMap<>();

	static {
		m.put("Pass", PASS);
		m.put("Fail", FAIL);
		m.put("Skip", SKIP);
	}

	public static void log(String status, String message)
	{
		m.get(status).accept(message);
	}



	private static Consumer<Integer> selfadd = a -> {System.out.println(a+a);};
	private static Consumer<Integer> selfmulti = a -> {System.out.println(a*a);};
	private static Consumer<Integer> selfdivision = a -> {System.out.println(a/a);};

	private static Map<String, Consumer<Integer>> ops=new HashMap<>();

	static
	{
		ops.put("ADD", selfadd);
		ops.put("MULTIPLY", selfmulti);
		ops.put("DIVIDE", selfdivision);

	}

	public static void operation(String type, int a)
	{
		ops.get(type).accept(a);
	}

}

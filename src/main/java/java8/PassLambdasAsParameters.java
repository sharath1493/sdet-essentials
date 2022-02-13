package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class PassLambdasAsParameters {

	public static void main(String[] args) {

		//Passing only the lambda expression
		stringOperation((s)-> System.out.println(s.toLowerCase()) );

		//Passing the lambda expression, along with a data type
		stringOperation((s) -> System.out.println(s.toUpperCase()), "kane mawa");


		//using multiple Consumer Interface at the same time with andThen menthod

		ArrayList<String> l = new ArrayList<String>(Arrays.asList("Geeks", "for","Geeks"));

		System.out.println(l);

		Consumer<String> c = s -> System.out.println(s);
		Consumer<String> c1 = s -> System.out.println(s.toUpperCase());


		l.forEach(c.andThen(c1));



	}


	private static void stringOperation(Consumer<String> c, String temp) {
		c.accept(temp);

	}

	private static void stringOperation(Consumer<String> c) {
		String s="Billy";
		c.accept(s);

	}

}

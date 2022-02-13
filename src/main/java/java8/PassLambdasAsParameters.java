package java8;

import java.util.function.Consumer;

public class PassLambdasAsParameters {

	public static void main(String[] args) {

		//Passing only the lambda expression
		stringOperation((s)-> System.out.println(s.toLowerCase()) );

		//Passing the lambda expression, along with a data type
		stringOperation((s) -> System.out.println(s.toUpperCase()), "kane mawa");

	}


	private static void stringOperation(Consumer<String> c, String temp) {
		c.accept(temp);

	}

	private static void stringOperation(Consumer<String> c) {
		String s="Billy";
		c.accept(s);

	}

}

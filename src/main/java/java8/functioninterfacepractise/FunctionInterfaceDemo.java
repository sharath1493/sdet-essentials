package java8.functioninterfacepractise;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionInterfaceDemo {

	public static void main(String[] args) {

		// Defining Function Interface that take Integer argument and Returns Integer
		Function<Integer, Integer> add5 = (a) -> a + 5;
		Function<Integer, Integer> mul5 = (a) -> a * 5;

		// Defining the Unary Operation which take Integer argument and Returns Integer
		UnaryOperator<Integer> add5unary = (a) -> a + 5;
		UnaryOperator<Integer> mul5unary = (a) -> a * 5;

		// Results of Function Interface uses

		System.out.println(add5.apply(5));
		System.out.println(mul5.apply(6));

		// add5 will be executed first then mul5 - when andThen method is used in
		// function interface
		System.out.println(add5.andThen(mul5).apply(5));

		// mul5 will be executed first then add5 - when consume method is used in
		// function interface
		System.out.println(add5.compose(mul5).apply(5));

		// Results of UnaryOperator Interface uses

		System.out.println(add5unary.apply(4));
		System.out.println(mul5unary.apply(3));

		System.out.println(add5unary.andThen(mul5unary).apply(7));

	}

}

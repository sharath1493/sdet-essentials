package java8.unarybinaryoperatorspractise;

import java.util.Arrays;
import java.util.List;

public class UnaryBinaryOperatorsDemo1 {

	public static void main(String[] args) {

		List<Integer> l = Arrays.asList(24, 5, 7, 3, 678, 56, 4, 46);

		List<String> l1= Arrays.asList("Anna","Nelly","NBull","Billy");


		//------------ Unary operator --------------------- 

		//normal way

		l1.stream().forEach(s -> System.out.println(s.toUpperCase()));

		//Converting a list of String to upper case with unary operator with ReplaceAll method
		l1.replaceAll(s->s.toUpperCase());

		System.out.println(l1);




		//------------ Binary operator --------------------- 

		// Normal way of streaming
		System.out.println(l.stream().mapToInt(s -> s.intValue()).sum());

		// finding sum with Binary Operator in reduce
		System.out.println(l.stream().reduce(0, (a, b) -> a + b));

	}

}

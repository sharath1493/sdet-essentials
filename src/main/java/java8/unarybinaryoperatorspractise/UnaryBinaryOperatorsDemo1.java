package java8.unarybinaryoperatorspractise;

import java.util.Arrays;
import java.util.List;

public class UnaryBinaryOperatorsDemo1 {

	public static void main(String[] args) {

		List<Integer> l = Arrays.asList(24, 5, 7, 3, 678, 56, 4, 46);

		// Normal way of streaming
		System.out.println(l.stream().mapToInt(s -> s.intValue()).sum());

		// finding sum with Binary Operator in reduce
		System.out.println(l.stream().reduce(0, (a, b) -> a + b));

	}

}

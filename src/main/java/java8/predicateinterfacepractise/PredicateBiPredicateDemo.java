package java8.predicateinterfacepractise;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import com.fasterxml.jackson.databind.ser.std.ArraySerializerBase;

public class PredicateBiPredicateDemo {

	public static void main(String[] args) {

		/*
		 * Requirements: 
		 * - Sum of list of integers 
		 * - Sum of list of integers divisible by 2 
		 * - Sum of list of integers non divisible by 2
		 */

		List<Integer> a = Arrays.asList(4, 6, 3, 9, 23, 7, 8, 12,7);

		System.out.println(a);

		// Old school way of solving

		System.out.println(oldsumlist(a));
		System.out.println(olddivtwolist(a));
		System.out.println(olddivnottwolist(a));

		//Java 8 with Predicate

		System.out.println(jav8sum(a, i -> true));
		System.out.println(jav8div2(a, i -> i%2 == 0));
		System.out.println(jav8divnot2(a, i -> i%2 != 0));

		// Bipredicate Demo


		System.out.println(testBipredicate((x,y)-> x%y==0,2,3));

	}

	private static boolean testBipredicate(BiPredicate<Integer, Integer> b, int x, int y) {
		return b.test(x, y);

	}

	private static int jav8divnot2(List<Integer> a, Predicate<Integer> predicate) {

		return a.stream().filter(predicate).reduce(0,Integer::sum);
	}

	private static int jav8div2(List<Integer> a, Predicate<Integer> predicate) {
		return a.stream().filter(predicate).mapToInt(e -> Integer.valueOf(e)).sum();
	}

	private static int jav8sum(List<Integer> a, Predicate<Integer> predicate) {
		return a.stream().filter(predicate).mapToInt(e -> Integer.valueOf(e)).sum();

	}

	private static int oldsumlist(List<Integer> a) {

		int sum = 0;
		for (int i = 0; i < a.size(); i++) {
			sum+=a.get(i);
		}

		return sum;
	}

	private static int olddivtwolist(List<Integer> a) {
		int sum = 0;
		for (int i = 0; i < a.size(); i++) {

			if(a.get(i)%2 == 0)
			{
				sum+=a.get(i);

			}
		}		

		return sum;
	}


	private static int olddivnottwolist(List<Integer> a) {
		int sum = 0;
		for (int i = 0; i < a.size(); i++) {

			if(a.get(i)%2 != 0)
			{
				sum+=a.get(i);

			}
		}		
		return sum;
	}

}

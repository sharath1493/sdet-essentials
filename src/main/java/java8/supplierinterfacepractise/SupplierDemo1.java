package java8.supplierinterfacepractise;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierDemo1 {

	public static void main(String[] args) {

		Supplier<Integer> rint = () -> new Random().nextInt();
		
		System.out.println(rint.get());
		
	}

}

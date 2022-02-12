package java8;

public class LamdaExpressionBasic {

	public static void main(String[] args) {


		/*
		 * Points while using lambda expression
		 * 1. Interface has to functional interface i.e. only one abstract method in interface
		 * 2. Parameters and return type should match
		 * 3. Symbol "->" will be used for lambda expression 
		 */

		IPrintable i = () -> System.out.println("from the lambda expression : "+IPrintable.course);

		i.print();
	}

}

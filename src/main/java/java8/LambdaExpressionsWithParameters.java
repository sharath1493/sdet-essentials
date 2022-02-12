package java8;

public class LambdaExpressionsWithParameters {

	public static void main(String[] args) {


		IDisplay d= (a,b) -> a+b>0;
		
		System.out.println(d.display(-15, 6));

	}

}

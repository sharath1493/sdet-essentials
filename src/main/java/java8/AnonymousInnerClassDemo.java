package java8;

public class AnonymousInnerClassDemo {

	public static void main(String[] args) {

		//AnonymousInnerClass Creation
		IPrintable i= new IPrintable() {

			@Override
			public void print() {
				System.out.println("Your are learning : "+name);
			}
		};

		//AnonymousInnerClass Creation
		IPrintable i1= new IPrintable() {

			@Override
			public void print() {
				System.out.println("Your are learning : "+course);
			}
		};


		i.print();
		i1.print();
	}


}

package threadsdemo;

public class MultiThreadDemo {

	public static void main(String[] args) {
		// main is main thread
		System.out.println("======== Main : App Started ===========");
		
		Printer p = new Printer();
	
		MyThread m = new MyThread(p);
		YourThread y = new YourThread(p);
		m.start();
	
		y.start();
		
		System.out.println("======== Main : App Ended ===========");

	}

}

class Printer
{
	synchronized public void printDocs(int n, String docName)
	{
		for (int i=0; i < 10; i ++)
		{
			System.out.println("Print Doc with pages "+n+" and name "+docName);
		}
	}
}

class MyThread extends Thread
{
	Printer pref;
	
	MyThread(Printer p)
	{
		this.pref = p;
	}
	
	public void run()
	{
		pref.printDocs(10, "John");
	}
}


class YourThread extends Thread
{
	Printer pref;
	
	YourThread(Printer p)
	{
		this.pref = p;
	}
	
	public void run()
	{
		pref.printDocs(10, "Kelly");
	}
}


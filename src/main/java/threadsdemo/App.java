package threadsdemo;

public class App {

	public static void main(String[] args)
	{
		//Job Start
		System.out.println("=============Start===============");
		
		Runnable n = new MyTask();
		Thread r = new Thread(n);
				
		r.start();
		
		new Thread(new YourTask()).start();


		//Job 1
		System.out.println("============= Job 1 - Print Pages ===============");
		for(int i=0; i < 10; i++)
		{
			System.out.println("Print page number: "+i);
		}
		
		


		//Job End
		System.out.println("=============end===============");

	}
}

class CA
{

	
}


class MyTask extends CA implements Runnable
{
	//Job 2
	public void run() {
		System.out.println("============= Job 2 : print Covers ===============");
		for(int i=0; i < 10; i++)
		{
			System.out.println("Print Cover number: "+i);
		}
	}
}



class YourTask implements Runnable
{
	//Job 2
	public void run() {
		System.out.println("============= Job 3 : print images ===============");
		for(int i=0; i < 10; i++)
		{
			System.out.println("Print images number: "+i);
		}
	}
}


/*
// Regular Class
class MyTask
{
	//Job 2
	public void printbooks() {
		System.out.println("============= Job 2 : print Covers ===============");
		for(int i=0; i < 10; i++)
		{
			System.out.println("Print page number: "+i);
		}
	}
}
*/